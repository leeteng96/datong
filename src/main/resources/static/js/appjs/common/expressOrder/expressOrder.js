
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
                        onLoadSuccess:function(){

                            lay('.starttime-item').each(function(){
                                laydate.render({
                                    elem: this,
                                    type: 'datetime',
                                    format: 'yyyy年MM月dd日 HH时'
                                });
                                 });

                        },
                        onEditableSave: function (field, row, oldValue, $el) {
                            $.ajax({
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
									checkbox : true
								},
								{
									field : 'id',
									title : '序号'
								},
								{
									field : 'ladingBillNo',
									title : '提单号'
								},
																{
									field : 'relaNo', 
									title : '关联单号' 
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
									}
                                  },

																{
									field : 'flightNo', 
									title : '航班号' 
								},
																{
									field : 'packageNo', 
									title : '票数',

                                                                },
																{
									field : 'logisticsType', 
									title : '模式' ,

								},
																{
									field : 'pickupDate', 
									title : '提货日期' ,
                                     formatter: function (value, row, index) {

                                            return "<a class='starttime-item' id='starttime_\"+row.id+\"' onclick='loadingDate()'>请选择日期!</a>";
                                        /*return "<input type='type'  id='starttime_"+row.id+"' class='starttime-item'>";*/
                                     },

								},
																{
									field : 'turnupDate', 
									title : '到场日期' 
								},
																{
									field : 'cleanDate', 
									title : '清关日期' 
								},
																{
									field : 'release', 
									title : '放行' 
								},
																{
									field : 'check', 
									title : '查检' 
								},
																{
									field : 'odd', 
									title : '异常' 
								},
																{
									field : 'sender', 
									title : '发件人' 
								},
																{
									field : 'senderAddress', 
									title : '发件人地址' 
								},
																{
									field : 'senderPhone', 
									title : '发件人电话' 
								},
																{
									field : 'receiver', 
									title : '收件人' 
								},
																{
									field : 'receiverIdcard', 
									title : '收件人身份证号' 
								},
																{
									field : 'receiverPhone', 
									title : '收件人电话' 
								},

																{
									field : 'receiverAddress', 
									title : '收件人地址' 
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
									field : 'goodsWeight', 
									title : '本包裹总毛重量(KG)' 
								},
																{
									field : 'nationalShortName', 
									title : '国家简称' 
								},
																{
									field : 'originCountry',
									title : '原产国'
								},
																{
									field : 'goodsCode', 
									title : '货号' 
								},
																{
									field : 'goodsModel', 
									title : '商品规格' 
								},
																{
									field : 'brand', 
									title : '品牌名称' 
								},
																{
									field : 'goodsValue', 
									title : '单价' 
								},
																{
									field : 'currency', 
									title : '币制' 
								},
																{
									field : 'grossWeight', 
									title : '毛重' 
								},
																{
									field : 'netWt', 
									title : '净重' 
								},
																{
									field : 'quantity', 
									title : '数量' 
								},

																{
									field : 'expressId', 
									title : '快递公司ID' 
								},
																{
									field : 'express', 
									title : '快递公司编码' 
								},
																{
									field : 'userId', 
									title : '操作用户' 
								},
																{
									field : 'customerId', 
									title : '客户ID' 
								},

																{
									title : '操作',
									field : 'id',
									align : 'center',
									formatter : function(value, row, index) {

										var e = '<a class="btn btn-primary btn-sm '+s_edit_h+'" href="#" mce_href="#" title="编辑" onclick="edit(\''
												+ row.id
												+ '\')"><i class="fa fa-edit"></i></a> ';
										var d = '<a class="btn btn-warning btn-sm '+s_remove_h+'" href="#" title="删除"  mce_href="#" onclick="remove(\''
												+ row.id
												+ '\')"><i class="fa fa-remove"></i></a> ';
										var f = '<a class="btn btn-success btn-sm" href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
												+ row.id
												+ '\')"><i class="fa fa-key"></i></a> ';
										return e + d ;
									}
								} ]
					});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}

function loadingDate(){

}



function add() {
	layer.open({
		type : 2,
		title : '增加',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/add' // iframe的url
	});
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