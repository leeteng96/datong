
var prefix = "/common/expressOrder";
$(function() {
    load();
});


function load() {

    $('#exampleTable')
        .bootstrapTable(
            {
                method : 'get', // 服务器数据的请求方式 get or post
                url : prefix + "/todo", // 服务器数据的加载地址
                striped : true, // 设置为true会有隔行变色效果
                dataType : "json", // 服务器返回的数据类型
                pagination : true, // 设置为true会在底部显示分页条
                singleSelect : true, // 设置为true将禁止多选

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
                    return {
                        "total": res.data.total,//总数
                        "rows": res.data.records   //数据
                    };
                },
                onLoadSuccess:function(data){

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

                    },
                    {
                        field : 'ladingBillNo',
                        title : '提单号',
                        valign:"middle",
                        align:"center",
                    },


                    {
                        field : 'flightNo',
                        title : '航班号' ,
                        valign:"middle",
                        align:"center",
                    },


                    {
                        field : 'logisticsType',
                        title : '模式' ,
                        valign:"middle",
                        align:"center",
                        formatter:function (value) {

                            if (value == "1")
                                return "BC"
                            if(value == "2")
                                return "CC"
                        }


                    },
                    {
                        field : 'pickupDate',
                        title : '提货日期' ,
                        valign:"middle",
                        align:"center",
                    },
                    {
                        field : 'turnupDate',
                        title : '到场日期' ,
                        valign:"middle",
                        align:"center",
                    },
                    {
                        field : 'cleanDate',
                        title : '清关日期' ,
                        valign:"middle",
                        align:"center",


                    },
                    {
                        field: 'cleanStatus',
                        title: "清关状态",
                        valign:"middle",
                        align:"center",
                        formatter:function (value) {
                            if(value == "1"){
                                return "放行"
                            }
                            if(value == "2"){
                                return "查检放行"
                            }
                            if(value == "3"){
                                return "查检查扣"
                            }
                            if(value == "4"){
                                return "异常长装"
                            }
                            if(value == "5"){
                                return "异常短装"
                            }
                            if(value == "6"){
                                return "无数据"
                            }
                        }

                    },
                    {
                        field: 'cleanRemark',
                        title: '备注',
                        valign:"middle",
                        align:"center",

                    },
                    {
                        field: 'zipCode',
                        title: '邮编',
                        valign:"middle",
                        align:"center",

                    },
                    {
                        field: 'expressCompany',
                        title: '快递公司',
                        valign:"middle",
                        align:"center",

                    },

                    {
                        field : 'customerId',
                        title : '客户名称',
                        valign:"middle",
                        align:"center",
                        formatter:function (val) {
                               var cusName;
                                $.ajax({
                                    url:'/common/expressOrder/customerList',
                                    async:false,
                                    type:"get",
                                    data:{},
                                    success:function(data,status){
                                        $.each(JSON.parse(data),function (key,value) {
                                            if(value.id == val){
                                                cusName = value.name;
                                            }

                                        })
                                    }
                                })
                                return cusName;
                            }
                    },
                    {
                        field: 'indate',
                        title: '创建时间',
                        valign:"middle",
                        align:"center",

                    },





                ]
            });
}
function editStatus(){
    var rows = $('#exampleTable').bootstrapTable('getSelections');
    if (rows.length == 0) {
        layer.msg("请选择要处理的数据");
        return;
    }

    layer.open({
        title:'确认清关',
        skin:'layui-layer-rim',
        area:['450px', '450px'],
        content: ' <div class="row" style="width: 420px;  margin-left:7px; margin-top:10px;">'
            +'<div class="col-sm-12">'
            +'<div class="input-group">'
            +'<span class="input-group-addon"> 清关日期   :</span>'
            +'<input type="text" class="laydate-icon layer-date form-control" id="cleanDate" name="cleanDate"  placeholder="日期"  onclick="laydate({istime: true, format: \'YYYY-MM-DD hh\'})" style="background-color: #fff;" readonly="readonly"/>'
            +'</div>'
            +'<div class="input-group">'
            +'<label class="input-group-addon"> 清关状态   :</label>'
            +'<div id="cleans" ></div>'
            +'<input id = "cleanStatus" name="cleanStatus" type="hidden">'
            +'</div>'
            +'<div class="input-group">'
            +'<label class="input-group-addon"> 清关备注   :</label>'
            +'<textarea id = "cleanRemark" name="cleanRemark" ></textarea>'
            +'</div>'
            +'</div>'
            +'<script type="text/javascript">'
            +'loadTree();'
            +'</script>'
        ,

        btn:['保存','取消'],
        btn1: function (index,layero) {
            $.ajax({
                url:'/common/expressOrder/changeStatus',
                async:false,
                type:'get',
                data : {
                    'id' : rows[0].id,
                    'cleanDate':$("#cleanDate").val(),
                    'cleanStatus':$("#cleanStatus").val(),
                    'cleanRemark':$("#cleanRemark").val(),
                },
                success:function (r) {
                    layer.msg(r.msg);

                }
            })
        },
        btn2:function (index,layero) {
            layer.close(index);
        }



    })


}

function loadTree() {
    $('#cleans').jstree({
        'core': {
            "multiple": false,
            "themes" : { "stripes" : true },

            'data': [
                {
                    'id':'1','text':'放行'
                },
                {
                    'text': '查检',
                    'state': {
                        'opened': true,
                        'disabled':true
                    },
                    'children': [
                        {'id':'2','text': '放行'},
                        {'id':'3','text':'查扣'}
                    ]
                },
                {
                    'text':'异常',
                    'state':{
                        'opened': true,
                        'disabled':true
                    },
                    'children':[
                        {'id':'4','text':'长装'},
                        {'id':'5','text':'短装'},
                        {'id':'6','text':'无数据'},
                    ]
                }
            ]

        },
        "plugins": ["wholerow"],

    }).on("changed.jstree",function(e,node){

        $("#cleanStatus").val(node.instance.get_node(node.selected[0]).id);

    });

}
function reLoad() {
    $('#exampleTable').bootstrapTable('refresh');
}