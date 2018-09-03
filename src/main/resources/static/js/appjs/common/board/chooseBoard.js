
var prefix = "/common/board"
$(function() {
	load();
    getNowFormatDate();
});

function load() {
	$('#exampleTable')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + "/list", // 服务器数据的加载地址
					//	showRefresh : true,
					//	showToggle : true,
					//	showColumns : true,
						iconSize : 'outline',
						toolbar : '#exampleToolbar',
						striped : true, // 设置为true会有隔行变色效果
						dataType : "json", // 服务器返回的数据类型
						pagination : true, // 设置为true会在底部显示分页条
						singleSelect : false, // 设置为true将禁止多选
						// contentType : "application/x-www-form-urlencoded",
						// //发送到服务器的数据编码类型
						pageSize : 10, // 如果设置了分页，每页数据条数
						pageNumber : 1, // 如果设置了分布，首页页码
						//search : true, // 是否显示搜索框
						showColumns : false, // 是否显示内容下拉框（选择显示的列）
						sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
						queryParamsType : "",
						// //设置为limit则会发送符合RESTFull格式的参数
						queryParams : function(params) {
							return {
								//说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
							     pageNumber : params.pageNumber,
								 pageSize : params.pageSize,
                                 waybillNo :$('#searchName').val()
					           // name:$('#searchName').val(),
					           // username:$('#searchName').val()
							};
						},
						responseHandler : function(res){
                            console.log(res);
                            return {
                                "total": res.data.total,//总数
                                "rows": res.data.records   //数据
                             };
                        },
                        onLoadSuccess : function(data) {
                            var data = $('#exampleTable').bootstrapTable('getData', true);
                            //合并单元格
                            mergeCells(data, "waybillNo", 1, $('#exampleTable'));


                        },
                        columns : [
                            {	field :"checkBox",
                                checkbox : true
                            },

                            {
                                field : 'waybillNo',
                                title : '快递单号'
                            },


                            {
                                field : 'goodsSeq',
                                title : '商品序号'
                            },
                            {
                                field : 'goodsName',
                                title : '本包裹名称'
                            },

                            {
                                field : 'goodsModel',
                                title : '商品规格'
                            },

                            ]
					});
}

/**
 * 合并单元格
 * @param data  原始数据（在服务端完成排序）
 * @param fieldName 合并属性名称
 * @param colspan   合并列
 * @param target    目标表格对象
 */
function mergeCells(data,fieldName,colspan,target){
    //声明一个map计算相同属性值在data对象出现的次数和
    var sortMap = {};

    for(var i = 0 ; i < data.length ; i++){
        for(var prop in data[i]){
            if(prop == fieldName){
                var key = data[i][prop]
                if(sortMap.hasOwnProperty(key)){
                    sortMap[key] = sortMap[key] * 1 + 1;
                } else {
                    sortMap[key] = 1;
                }
                break;
            }

        }
    }
    /*for(var prop in sortMap){
        console.log(prop,sortMap[prop])
    }*/

    var index = 0;
    for(var prop in sortMap){
        var count = sortMap[prop] * 1;
        $(target).bootstrapTable('mergeCells',{index:index, field:fieldName, colspan: colspan, rowspan: count});
        $(target).bootstrapTable('mergeCells',{index:index, field:"checkBox", colspan: colspan, rowspan: count});
        index += count;
    }
}


function getNowFormatDate(){
    var date = new Date();
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear()  + month  + strDate
		+ date.getHours()  + date.getMinutes()
		+ date.getSeconds();
	$("#boardId").val(currentdate);
}

function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}



function resetPwd(id) {
}
function playBoard() {
	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if (rows.length == 0) {
        layer.alert("请选择快递单号再打板!");
		return;
	}
	layer.confirm("确认将选中的'" + rows.length + "'条数据打板吗?", {
		btn : [ '确定', '取消' ]
	}, function() {
		var ids = new Array();
		// 遍历所有选择的行数据，取每条数据对应的ID
		$.each(rows, function(i, row) {
			ids[i] = row['waybillNo'];
		});
		$.ajax({
			type : 'POST',
			data : {
				"waybillNo" : ids,
				"boardId":$("#boardId").val()
			},
			url : prefix + '/playBoard',
			success : function(r) {
				if (r.code == 0) {
					layer.msg(r.msg);
					reLoad();
				} else {
					layer.msg(r.msg);
				}
			}
		});
	}, function() {

	});
}