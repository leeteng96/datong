
var prefix = "/common/declare"
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
                                  pageSize : params.pageSize  
					           // name:$('#searchName').val(),
					           // username:$('#searchName').val()
							};
						},
						// //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
						// queryParamsType = 'limit' ,返回参数必须包含
						// limit, offset, search, sort, order 否则, 需要包含:
						// pageSize, pageNumber, searchText, sortName,
						// sortOrder.
						// 返回false将会终止请求
						responseHandler : function(res){
                            console.log(res);
                            return {
                                "total": res.data.total,//总数
                                "rows": res.data.records   //数据
                             };
                        },
						columns : [
								{
									checkbox : true
								},
																{
									field : 'id', 
									title : '' 
								},
																{
									field : 'category', 
									title : '类别' 
								},
																{
									field : 'transceiverNo', 
									title : '收发货人编号' 
								},
																{
									field : 'transceiverName', 
									title : '收发货人名称' 
								},
																{
									field : 'creditCode', 
									title : '收发货人统一社会信用代码' 
								},
																{
									field : 'ladingBillNo', 
									title : '提单号' 
								},
																{
									field : 'waybillNo', 
									title : '分运单号' 
								},
																{
									field : 'serialNo', 
									title : '商品序号' 
								},
																{
									field : 'productName', 
									title : '货物名称' 
								},
																{
									field : 'enName', 
									title : '货物英文名称' 
								},
																{
									field : 'city', 
									title : '产销城市' 
								},
																{
									field : 'code', 
									title : '商品编码' 
								},
																{
									field : 'quantity', 
									title : '数量' 
								},
																{
									field : 'netwt', 
									title : '净重(KG)' 
								},
																{
									field : 'weight', 
									title : '毛重(KG)' 
								},
																{
									field : 'model', 
									title : '规格/型号' 
								},
																{
									field : 'price', 
									title : '申报单价' 
								},
																{
									field : 'applyQuantity', 
									title : '申报数量' 
								},
																{
									field : 'totalPrice', 
									title : '申报总价' 
								},
																{
									field : 'transactionPrice', 
									title : '成交总价' 
								},
																{
									field : 'firstUit', 
									title : '申报计量单位' 
								},
																{
									field : 'receiver', 
									title : '收件人' 
								},
																{
									field : 'receiverIdcard', 
									title : '收件人证件号' 
								},
																{
									field : 'recevierType', 
									title : '收件人证件类型' 
								},
																{
									field : 'receiverCity', 
									title : '收件人城市' 
								},
																{
									field : 'receiverAddress', 
									title : '收件人地址' 
								},
																{
									field : 'receiverPhone', 
									title : '收件人电话' 
								},
																{
									field : 'unitName', 
									title : '货主单位名称' 
								},
																{
									field : 'unitNo', 
									title : '货主单位代码' 
								},
																{
									field : 'ownerCode', 
									title : '货主单位统一社会信用代码' 
								},
																{
									field : 'ownerAreaCode', 
									title : '货主单位地区代码' 
								},
																{
									field : 'tradingCountry', 
									title : '贸易国别' 
								},
																{
									field : 'copam', 
									title : '产销国' 
								},
																{
									field : 'sender', 
									title : '发件人' 
								},
																{
									field : 'senderEn', 
									title : '英文发件人' 
								},
																{
									field : 'senderNation', 
									title : '发件人国别' 
								},
																{
									field : 'senderCity', 
									title : '发件人城市' 
								},
																{
									field : 'senderCityEn', 
									title : '英文发件人城市' 
								},
																{
									field : 'stopcityEn', 
									title : '英文经停城市' 
								},
																{
									field : 'senderAddress', 
									title : '发件人地址' 
								},
																{
									field : 'senderAddressEn', 
									title : '英文发件人地址' 
								},
																{
									field : 'senderPhone', 
									title : '发件人电话' 
								},
																{
									field : 'packageType', 
									title : '包装种类' 
								},
																{
									field : 'woodenFlag', 
									title : '是否含木质包装' 
								},
																{
									field : 'oldgoodsFlag', 
									title : '是否为旧物品' 
								},
																{
									field : 'lowshipFlag', 
									title : '是否为低温运输' 
								},
																{
									field : 'use', 
									title : '用途' 
								},
																{
									field : 'documentType', 
									title : '随附单证类型' 
								},
																{
									field : 'documentNo', 
									title : '随附单证编号' 
								},
																{
									title : '操作',
									field : 'id',
									align : 'center',
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
								} ]
					});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
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

function comparisonExport(){
    location.href="/importExcel/ExportDeclare.html";

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