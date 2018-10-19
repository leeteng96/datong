
var prefix = "/common/expressOrder"
$(function() {

    load();
});

function load() {


        $('#exampleTable')
			.bootstrapTable(
					{
                        method : 'get', // 服务器数据的请求方式 get or post
                        url : prefix + "/list", // 服务器数据的加载地址
                        striped : true, // 设置为true会有隔行变色效果
                        dataType : "json", // 服务器返回的数据类型
                        pagination : true, // 设置为true会在底部显示分页条
                        singleSelect : false, // 设置为true将禁止多选

                        // contentType : "application/x-www-form-urlencoded",
                        // //发送到服务器的数据编码类型
                        iconSize : 'outline',
                        toolbar : '#exampleToolbar',
                        pageSize : 10, // 如果设置了分页，每页数据条数
                        pageNumber : 1, // 如果设置了分布，首页页码
                        pageList: [10, 15, 20, 25],        //可供选择的每页的行数（*）
                        sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
                        queryParamsType : "",                  //每页的记录行数（*）
                        uniqueId: "id",                     //每一行的唯一标识，一般为主键列
                        clickToSelect: true,
                        sortable: false,//是否排序
                        strictSearch: true, //是否显 示刷新
                        showColumns: true, //是否显示所有的列
                        showRefresh: true, //是否显示刷新按钮
                        minimumCountColumns: 2, //最少允许的列数
                        showToggle:true, //是否显示详细视图和列表视图的切换按钮
                        cardView: false, //是否显示详细视图
                        // //设置为limit则会发送符合RESTFull格式的参数
						queryParams : function(params) {
							return {
								//说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
							     pageNumber : params.pageNumber,
                                  pageSize : params.pageSize,
                                totalWaybillNo:$('#searchName').val(),
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

                        onEditableSave: function (field, row, oldValue, $el) {
                            $.ajax({
								url: "/common/expressOrder/update",
								async:false,
								type:"POST",
                                dataType: 'JSON',
								data:row,
                                success: function (data, status) {
                                    if (status == "success") {
                                        alert("编辑成功");
                                    }
                                },
                                error: function () {
                                    alert("Error");
                                },
                                complete: function () {

                                }
                            });
                        },
						columns : [

                                {
                                    checkbox:true,
                                    valign:"middle",
                                    align:"center",

                                },
                                {
                                    field : 'id',
                                    title : '序号',
                                    valign:"middle",
                                    align:"center",

                                },

                                {
                                    field : 'totalWaybillNo',
                                    title : '总运单号',
                                    valign:"middle",
                                    align:"center",
                                    editable: {
                                        type: 'text',
                                        title: '总运单号',
                                        emptytext:'-',

                                        validate: function (value) {
                                            if ($.trim(value) == '') {
                                                return '总运单号不能为空!';
                                            }
                                        }
                                    },


                                },
                                {
                                    field : 'ladingBillNo',
                                    title : '提单号',
                                    valign:"middle",
                                    align:"center",
                                    editable: {
                                        type: 'text',
                                        title: '提单号',
                                        emptytext:'-',
                                        validate: function (value) {
                                            if ($.trim(value) == '') {
                                                return '提单号不能为空!';
                                            }
                                        }
                                    },


                                },


                                {
                                    field : 'flightNo',
                                    title : '航班号' ,
                                    valign:"middle",
                                    align:"center",
                                    editable: {
                                        type: 'text',
                                        title: '航班号',
                                        emptytext:'-',
                                        validate: function (value) {
                                            if ($.trim(value) == '') {
                                                return '航班号不能为空!';
                                            }
                                        }
                                    }

                                },


                                {
                                    field : 'logisticsType',
                                    title : '模式' ,
                                    valign:"middle",
                                    align:"center",
                                    editable: {
                                        type: 'select',
                                        title: '模式',
                                        pk:1,
                                        emptytext:'-',
                                        source:
                                            [{value:"1",text:"BC"},{value:"2",text:"CC"}],

                                    },


                                },
                                {
                                    field : 'pickupDate',
                                    title : '提货日期' ,
                                    valign:"middle",
                                    align:"center",
                                    editable:{
                                        type:"combodate",
                                        format: 'YYYY-MM-DD  HH',
                                        template:"YYYY年MM月DD日HH时 ",
                                        placement:"left",
                                        pk:1,
                                        emptytext:'-',
                                        language: 'zh-CN',
                                        todayBtn: 1,
                                    },


                                },
                                {
                                    field : 'turnupDate',
                                    title : '到场日期' ,
                                    valign:"middle",
                                    align:"center",
                                    editable:{
                                        type:"combodate",
                                        format: 'YYYY-MM-DD  HH',
                                        template:"YYYY年MM月DD日HH时 ",
                                        placement:"left",
                                        pk:1,
                                        emptytext:'-',
                                        language: 'zh-CN',
                                        todayBtn: 1,
                                    },


                                },
                                {
                                    field : 'cleanDate',
                                    title : '清关日期' ,
                                    valign:"middle",
                                    align:"center",
                                    editable:{
                                        type:"combodate",
                                        format: 'YYYY-MM-DD  HH',
                                        template:"YYYY年MM月DD日HH时 ",
                                        placement:"left",
                                        pk:1,
                                        emptytext:'-',
                                        language: 'zh-CN',
                                        todayBtn: 1,
                                    },


                                },
                                {
                                    field: 'cleanStatus',
                                    title: "清关状态",
                                    valign:"middle",
                                    align:"center",
                                    editable: {
                                        type: 'select',
                                        title: '清关状态',
                                        emptytext:'-',
                                        source:[
                                            {value:'1',text:'放行'},
                                            {value:'2',text:'查检放行'},
                                            {value:'3',text:'查检查扣'},
                                            {value:'4',text:'异常长装'},
                                            {value:'5',text:'异常短装'},
                                            {value:'6',text:'无数据'},
                                        ]

                                    },

                                },
                                {
                                    field: 'cleanRemark',
                                    title: '备注',
                                    valign:"middle",
                                    align:"center",
                                    editable: {
                                        type: 'text',
                                        title: '备注',
                                        emptytext:'-',


                                    },
                                },
                            {
                                field: 'zipCode',
                                title: '邮编',
                                valign:"middle",
                                align:"center",
                                editable: {
                                    type: 'text',
                                    title: '邮编',
                                    emptytext:'-',

                                },
                            },
                            {
                                field: 'expressCompany',
                                title: '快递公司',
                                valign:"middle",
                                align:"center",
                                editable: {
                                    type: 'text',
                                    title: '快递公司',
                                    emptytext:'-',
                                },
                            },

                                {
                                    field : 'customerId',
                                    title : '客户ID',
                                    valign:"middle",
                                    align:"center",
                                    editable: {
                                        type: 'select',
                                        title: '客户ID',
                                        source:function () {
                                            var result 	= [];
                                            $.ajax({
                                                url:'/common/expressOrder/customerList',
                                                async:false,
                                                type:"get",
                                                data:{},
                                                success:function(data,status){
                                                    $.each(JSON.parse(data),function (key,value) {
                                                        result.push({value:value.id,text:value.name});
                                                    })
                                                }
                                            })
                                            return result;
                                        }

                                    }
                                },
                                {
                                    field: 'indate',
                                    title: '创建时间',
                                    valign:"middle",
                                    align:"center",

                                },

                                {
                                    title : '操作',
                                    field : 'id',
                                    align : 'center',
                                    valign:"middle",
                                    align:"center",
                                    formatter : function(value, row, index) {

                                        var e = '<a class="btn btn-primary btn-sm " href="#" mce_href="#" title="编辑" onclick="edit(\''
                                            + row.id
                                            + '\')"><i class="fa fa-edit"></i></a> ';
                                        var d = '<a class="btn btn-warning btn-sm " href="#" title="删除"  mce_href="#" onclick="remove(\''
                                            + row.id
                                            + '\')"><i class="fa fa-remove"></i></a> ';
                                        var f = '<a class="btn btn-success btn-sm" href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
                                            + row.id
                                            + '\')"><i class="fa fa-key"></i></a> ';
                                        return e + d ;
                                    }
                                }




						]
					});
}



/*
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
    /!*for(var prop in sortMap){
        console.log(prop,sortMap[prop])
    }*!/

    var index = 0;
    for(var prop in sortMap){
        var count = sortMap[prop] * 1;
        $(target).bootstrapTable('mergeCells',{index:index, field:fieldName, colspan: colspan, rowspan: count});
        index += count;
    }
}
*/


function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}

function add() {
	var add = layer.open({
		type : 2,
		title : '增加',
        maxmin: true ,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/add' // iframe的url
	});
	layer.full(add);
}
function edit(id) {
    var edit = layer.open({
		type : 2,
		title : '编辑',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/edit/' + id // iframe的url
	});
    layer.full(edit);
}
function remove(id) {
	layer.confirm('确定要删除选中的记录？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : prefix+"/remove",
			type : "post",
			data : {
				'id' : id
			},
			success : function(r) {
				if (r.code==0) {
					layer.msg(r.msg);
					reLoad();
				}else{
					layer.msg(r.msg);
				}
			}
		});
	})
}

function resetPwd(id) {
}
function batchRemove() {
	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if (rows.length == 0) {
		layer.msg("请选择要删除的数据");
		return;
	}
	layer.confirm("确认要删除选中的'" + rows.length + "'条数据吗?", {
		btn : [ '确定', '取消' ]
	// 按钮
	}, function() {
		var ids = new Array();
		// 遍历所有选择的行数据，取每条数据对应的ID
		$.each(rows, function(i, row) {
			ids[i] = row['id'];
		});
		$.ajax({
			type : 'POST',
			data : {
				"ids" : ids
			},
			url : prefix + '/batchRemove',
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