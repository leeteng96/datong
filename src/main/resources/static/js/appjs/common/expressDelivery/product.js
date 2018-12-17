var prefix = "/common/product"
$(function() {
    load();

});

function load() {

    //销毁bootstrapTable 对象
    $("#tab").bootstrapTable('destroy');
    $("#tab")
        .bootstrapTable(
            {
                method : 'get', // 服务器数据的请求方式 get or post
                url : prefix+"/list", // 服务器数据的加载地址
                striped : true, // 设置为true会有隔行变色效果
                dataType : "json", // 服务器返回的数据类型
                pagination : true, // 设置为true会在底部显示分页条
                singleSelect : false, // 设置为true将禁止多选
                iconSize : 'outline',
                toolbar : '#exampleToolbar',
                pageSize : 10, // 如果设置了分页，每页数据条数
                pageNumber : 1, // 如果设置了分布，首页页码
                search : true, // 是否显示搜索框
                showColumns : true,
                sortName:'productId',
                UniqueId:'productId',
                pageNumber: 1,
                pageSize: 10,
                pageList: [10, 15, 25, 50, 100],
                sortable: true, //排序方式
                sortOrder: "desc",
                sidePagination : "client", // 设置在哪里进行分页，可选值为"client" 或者 "server"
                onLoadSuccess:function(){
                    hideRow();
                },
                columns : [
                    {
                        checkbox : true
                    },
                    {
                        field : 'id',
                        title : '商品ID'
                    },
                    {
                        field : 'name',
                        title : '商品名称'
                    },
                    {
                        field : 'code',
                        title : '商品编码'
                    },
                    {
                        field : 'originCountry',
                        title : '原产国'
                    },
                    {
                        field : 'price',
                        title : '商品价格'
                    },
                    {
                        field : 'weight',
                        title : '商品重量'
                    },
                    {
                        field : 'model',
                        title : '商品规格'
                    },
                    {
                        field : 'color',
                        title : '商品颜色'
                    },
                    {
                        field : 'produceDate',
                        title : '生产日期'
                    },
                    {
                        field : 'shelfLife',
                        title : '有效期'
                    },
                    {
                        field : 'indate',
                        title : '商品录入时间'
                    },
                    {
                        field : 'unit1',
                        title : '第一单位'
                    },
                    {
                        field : 'qty1',
                        title : '第一数量'
                    },
                    {
                        field : 'unit2',
                        title : '第二单位'
                    },
                    {
                        field : 'qty2',
                        title : '第二数量'
                    },
                    {
                        field : 'netwt',
                        title : '净重'
                    },


                   ]
            });


}
//隐藏已有的商品信息 避免商品信息重复
function hideRow(){
    var id = $("#ids").val();
    if (id != 'undefined') {
        var ids = id.split(",");
        var pid = new Array();
        for (var i = 0; i < ids.length; i++) {

            pid[i] = parseInt(ids[i]);
            $('#tab').bootstrapTable('remove', {
                field:'productId',
                values:[parseInt(pid[i])]
            });
        }

    }

}
function transfer(){
    var rows = $('#tab').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
    if (rows.length == 0) {
        layer.msg("请选择商品数据");
        return;
    };
    // 遍历所有选择的行数据，取每条数据对应的ID
    var ids ="";

    // 遍历所有选择的行数据，取每条数据对应的ID
    $.each(rows, function(i, row) {
        ids += ","+row['id'];
    });
    window.parent.$("#insertPro").show();
    var index=parent.layer.getFrameIndex(window.name);
    parent.layer.close(index);
    window.parent.showPro(ids);
}

function add() {

    layer.open({
        type : 2,
        title : '增加',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : prefix + '/add', // iframe的url
        cancel :function () {
            reLoad();
        }
    });
}
function reLoad() {
    $('#tab').bootstrapTable('refresh');
}




