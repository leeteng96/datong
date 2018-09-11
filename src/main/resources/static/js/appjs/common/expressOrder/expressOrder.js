
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
					//	showRefresh : true,
					//	showToggle : true,
					//	showColumns : true,
						iconSize : 'outline',
						toolbar : '#exampleToolbar',
						striped : true, // 设置为true会有隔行变色效果
						dataType : "json", // 服务器返回的数据类型
						singleSelect : false, // 设置为true将禁止多选
						sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
                        showColumns:true,
                        pagination:true,
                        minimumCountColumns:2,
                        pageNumber:1,                       //初始化加载第一页，默认第一页
                        pageSize: 10,                       //每页的记录行数（*）
                        pageList: [10, 15, 20, 25],        //可供选择的每页的行数（*）
                        uniqueId: "id",                     //每一行的唯一标识，一般为主键列
                        clickToSelect: true,
                        undefinedText:"",
                        // //设置为limit则会发送符合RESTFull格式的参数
						queryParams : function(params) {
							return {
								//说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
							     pageNumber : params.pageNumber,
                                  pageSize : params.pageSize  
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
                      /*  onLoadSuccess : function(data) {
                            var data = $('#exampleTable').bootstrapTable('getData', true);
                            //合并单元格
                            mergeCells(data, "waybillNo", 1, $('#exampleTable'));

                        },*/
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

                            [
                                {
                                    checkbox:true,
                                    valign:"middle",
                                    align:"center",
                                    colspan: 1,
                                    rowspan: 3
                                },
                                {
                                    field : 'id',
                                    title : '序号',
                                    valign:"middle",
                                    align:"center",
                                    colspan: 1,
                                    rowspan: 3
                                },
                                {
                                    field : 'ladingBillNo',
                                    title : '提单号',

                                    editable: {
                                        type: 'text',
                                        title: '提单号',
                                        validate: function (value) {
                                            if ($.trim(value) == '') {
                                                return '提单号不能为空!';
                                            }
                                        }
                                    },
                                    valign:"middle",
                                    align:"center",
                                    colspan: 1,
                                    rowspan: 3
                                },
                                {
                                    field : 'relaNo',
                                    title : '关联单号',

                                    editable: {
                                        type: 'text',
                                        title: '提单号',
                                        validate: function (value) {
                                            if ($.trim(value) == '') {
                                                return '提单号不能为空!';
                                            }
                                        }
                                    },
                                    valign:"middle",
                                    align:"center",
                                    colspan: 1,
                                    rowspan: 3
                                },
                                {
                                    field : 'waybillNo',
                                    title : '快递单号' ,

                                    editable: {
                                        type: 'text',
                                        title: '快递单号',
                                        validate: function (value) {
                                            if ($.trim(value) == '') {
                                                return '快递单号不能为空!';
                                            }
                                        }
                                    },
                                    valign:"middle",
                                    align:"center",
                                    colspan: 1,
                                    rowspan: 3
                                },
                                {
                                    field : 'flightNo',
                                    title : '航班号' ,

                                    editable: {
                                        type: 'text',
                                        title: '航班号',
                                        validate: function (value) {
                                            if ($.trim(value) == '') {
                                                return '航班号不能为空!';
                                            }
                                        }
                                    },
                                    valign:"middle",
                                    align:"center",
                                    colspan: 1,
                                    rowspan: 3
                                },


                                {
                                    field : 'logisticsType',
                                    title : '模式' ,

                                    editable: {
                                        type: 'select',
                                        title: '模式',
                                        pk:1,
                                        source:
                                            [{value:"1",text:"BC"},{value:"2",text:"CC"}],

                                    },
                                    valign:"middle",
                                    align:"center",
                                    colspan: 1,
                                    rowspan: 3
                                },
                                {
                                    field : 'pickupDate',
                                    title : '提货日期' ,

                                    editable:{
                                        type:"combodate",
                                        format: 'yyyy-mm-dd HH',
                                        template:"YYYY年MM月DD日HH时 ",
                                        placement:"left",
                                        pk:1,
                                        language: 'zh-CN',
                                        todayBtn: 1,
                                    },
                                    valign:"middle",
                                    align:"center",
                                    colspan: 1,
                                    rowspan: 3
                                },
                                {
                                    field : 'turnupDate',
                                    title : '到场日期' ,

                                    editable:{
                                        type:"combodate",
                                        format: 'yyyy-mm-dd HH',
                                        template:"YYYY年MM月DD日HH时 ",
                                        placement:"left",
                                        pk:1,
                                        language: 'zh-CN',
                                        todayBtn: 1,
                                    },
                                    valign:"middle",
                                    align:"center",
                                    colspan: 1,
                                    rowspan: 3
                                },
                                {
                                    field : 'cleanDate',
                                    title : '清关日期' ,

                                    editable:{
                                        type:"combodate",
                                        format: 'yyyy-mm-dd HH',
                                        template:"YYYY年MM月DD日HH时 ",
                                        placement:"left",
                                        pk:1,
                                        language: 'zh-CN',
                                        todayBtn: 1,
                                    },
                                    valign:"middle",
                                    align:"center",
                                    colspan: 1,
                                    rowspan: 3
                                },
                                {
                                    title: "清关状态",
                                    valign:"middle",
                                    align:"center",
                                    colspan: 8,
                                    rowspan: 1
                                },
                                {
                                    field : 'sender',
                                    title : '发件人',
                                    valign:"middle",
                                    align:"center",
                                    colspan: 1,
                                    rowspan: 3,
                                    editable: {
                                        type: 'text',
                                        title: '发件人',
                                        validate: function (value) {
                                            if ($.trim(value) == '') {
                                                return '发件人不能为空!';
                                            }
                                        }
                                    }
                                },

                                {
                                    field : 'senderAddress',
                                    title : '发件人地址',
                                    valign:"middle",
                                    align:"center",
                                    colspan: 1,
                                    rowspan: 3,
                                    editable: {
                                        type: 'text',
                                        title: '发件人地址',
                                        validate: function (value) {
                                            if ($.trim(value) == '') {
                                                return '发件人地址不能为空!';
                                            }
                                        }
                                    }
                                },
                                {
                                    field : 'senderPhone',
                                    title : '发件人电话',
                                    valign:"middle",
                                    align:"center",
                                    colspan: 1,
                                    rowspan: 3,
                                    editable: {
                                        type: 'text',
                                        title: '发件人电话',
                                        validate: function (value) {
                                            if ($.trim(value) == '') {
                                                return '发件人电话不能为空!';
                                            }
                                        }
                                    }
                                },
                                {
                                    field : 'receiver',
                                    title : '收件人' ,
                                    valign:"middle",
                                    align:"center",
                                    colspan: 1,
                                    rowspan: 3,
                                    editable: {
                                        type: 'text',
                                        title: '收件人',
                                        validate: function (value) {
                                            if ($.trim(value) == '') {
                                                return '收件人电话不能为空!';
                                            }
                                        }
                                    }
                                },
                                {
                                    field : 'receiverIdcard',
                                    title : '收件人身份证号',
                                    valign:"middle",
                                    align:"center",
                                    colspan: 1,
                                    rowspan: 3,
                                    editable: {
                                        type: 'text',
                                        title: '收件人身份证号',
                                        validate: function (value) {
                                            if ($.trim(value) == '') {
                                                return '收件人身份证号不能为空!';
                                            }
                                        }
                                    }
                                },
                                {
                                    field : 'receiverPhone',
                                    title : '收件人电话',
                                    valign:"middle",
                                    align:"center",
                                    colspan: 1,
                                    rowspan: 3,
                                    editable: {
                                        type: 'text',
                                        title: '收件人电话',
                                        validate: function (value) {
                                            if ($.trim(value) == '') {
                                                return '收件人电话不能为空!';
                                            }
                                        }
                                    }

                                },

                                {
                                    field : 'receiverAddress',
                                    title : '收件人地址' ,
                                    valign:"middle",
                                    align:"center",
                                    colspan: 1,
                                    rowspan: 3,
                                    editable: {
                                        type: 'text',
                                        title: '收件人地址',
                                        validate: function (value) {
                                            if ($.trim(value) == '') {
                                                return '收件人地址不能为空!';
                                            }
                                        }
                                    }
                                },
                                {
                                    field : 'goodsSeq',
                                    title : '商品序号',
                                    valign:"middle",
                                    align:"center",
                                    colspan: 1,
                                    rowspan: 3,
                                    editable: {
                                        type: 'text',
                                        title: '商品序号',

                                    }
                                },
                                {
                                    field : 'goodsName',
                                    title : '包裹名称',
                                    valign:"middle",
                                    align:"center",
                                    colspan: 1,
                                    rowspan: 3,
                                    editable: {
                                        type: 'text',
                                        title: '包裹名称',
                                        validate: function (value) {
                                            if ($.trim(value) == '') {
                                                return '包裹名称不能为空!';
                                            }
                                        }
                                    }

                                },
                                {
                                    field : 'goodsWeight',
                                    title : '本包裹总毛重量(KG)',
                                    valign:"middle",
                                    align:"center",
                                    colspan: 1,
                                    rowspan: 3,
                                    editable: {
                                        type: 'text',
                                        title: '本包裹总毛重量',

                                    }
                                },
                                {
                                    field : 'nationalShortName',
                                    title : '国家简称',
                                    valign:"middle",
                                    align:"center",
                                    colspan: 1,
                                    rowspan: 3,
                                    editable: {
                                        type: 'text',
                                        title: '国家简称',

                                    }
                                },
                                {
                                    field : 'originCountry',
                                    title : '原产国',
                                    valign:"middle",
                                    align:"center",
                                    colspan: 1,
                                    rowspan: 3,
                                    editable: {
                                        type: 'text',
                                        title: '原产国',

                                    }

                                },
                                {
                                    field : 'goodsCode',
                                    title : '货号',
                                    valign:"middle",
                                    align:"center",
                                    colspan: 1,
                                    rowspan: 3,
                                    editable: {
                                        type: 'text',
                                        title: '货号',

                                    }
                                },
                                {
                                    field : 'goodsModel',
                                    title : '商品规格',
                                    valign:"middle",
                                    align:"center",
                                    colspan: 1,
                                    rowspan: 3,
                                    editable: {
                                        type: 'text',
                                        title: '商品规格',

                                    }
                                },
                                {
                                    field : 'brand',
                                    valign:"middle",
                                    align:"center",
                                    colspan: 1,
                                    rowspan: 3,
                                    title : '品牌名称',
                                    editable: {
                                        type: 'text',
                                        title: '品牌名称',

                                    }
                                },
                                {
                                    field : 'goodsValue',
                                    title : '单价',
                                    valign:"middle",
                                    align:"center",
                                    colspan: 1,
                                    rowspan: 3,
                                    editable: {
                                        type: 'text',
                                        title: '单价',

                                    }
                                },

                                {
                                    field : 'grossWeight',
                                    title : '毛重',
                                    valign:"middle",
                                    align:"center",
                                    colspan: 1,
                                    rowspan: 3,
                                    editable: {
                                        type: 'text',
                                        title: '毛重',

                                    }
                                },
                                {
                                    field : 'netWt',
                                    title : '净重',
                                    valign:"middle",
                                    align:"center",
                                    colspan: 1,
                                    rowspan: 3,
                                    editable: {
                                        type: 'text',
                                        title: '净重',

                                    }
                                },
                                {
                                    field : 'quantity',
                                    title : '数量',
                                    valign:"middle",
                                    align:"center",
                                    colspan: 1,
                                    rowspan: 3,
                                    editable: {
                                        type: 'text',
                                        title: '数量',

                                    }
                                },


                                {
                                    field : 'customerId',
                                    title : '客户ID',
                                    valign:"middle",
                                    align:"center",
                                    colspan: 1,
                                    rowspan: 3,
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
                                    title : '操作',
                                    field : 'id',
                                    align : 'center',
                                    valign:"middle",
                                    align:"center",
                                    colspan: 1,
                                    rowspan: 3,
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
                            ],
                            [
                                {
                                    field: 'release',
                                    title: '放行',
                                    valign:"middle",
                                    align:"center",
                                    colspan: 1,
                                    rowspan: 2,
                                    editable: {
                                        type: 'select',
                                        title: '放行',
                                        pk:1,
                                        source:
                                            [{value:"1",text:"放行"}],

                                    },
                                },
                                {
                                    field: 'releaseRemark',
                                    title: '备注',
                                    valign:"middle",
                                    align:"center",
                                    colspan: 1,
                                    rowspan: 2,
                                    editable: {
                                        type: 'text',
                                        title: '备注',
                                    },
                                },
                                {
                                    field: 'check',
                                    title: '查检',
                                    valign:"middle",
                                    align:"center",
                                    colspan: 1,
                                    rowspan: 2,
                                    editable: {
                                        type: 'select',
                                        title: '查检',
                                        source:
                                            [{value:"1",text:"放行"},{value:"2",text:"扣件"}],

                                    },
                                },

                                {
                                    field: 'checkReason',
                                    title: '查扣原因',
                                    valign:"middle",
                                    align:"center",
                                    colspan: 1,
                                    rowspan: 2,
                                    editable: {
                                        type: 'text',
                                        title: '查扣原因',

                                    }
                                },
                                {
                                    field: 'checkRemark',
                                    title: '备注',
                                    valign:"middle",
                                    align:"center",
                                    colspan: 1,
                                    rowspan: 2,
                                    editable: {
                                        type: 'text',
                                        title: '备注',

                                    },
                                },
                                {
                                    field: 'odd',
                                    title: '异常',
                                    valign:"middle",
                                    align:"center",
                                    colspan: 1,
                                    rowspan: 2,
                                    editable: {
                                        type: 'select',
                                        title: '异常',
                                        source:
                                            [{value:"1",text:"长装"},{value:"2",text:"短装"},{value:"3",text:"无数据"}],

                                    },
                                },
                                {
                                    field: 'oddReason',
                                    title: '异常原因',
                                    valign:"middle",
                                    align:"center",
                                    colspan: 1,
                                    rowspan: 2,
                                    editable: {
                                        type: 'text',
                                        title: '异常原因',
                                    },
                                },
                                {
                                    field: 'oddRemark',
                                    title: '备注',
                                    valign:"middle",
                                    align:"center",
                                    colspan: 1,
                                    rowspan: 2,
                                    editable: {
                                        type: 'text',
                                        title: '备注',


                                    },
                                },

                            ],
							[

							],






                            /*	[
                                                       */

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
	layer.open({
		type : 2,
		title : '编辑',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/edit/' + id // iframe的url
	});
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