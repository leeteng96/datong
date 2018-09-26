
$(function() {

    window.setInterval("getTodo()",1000*60);
});

function getTodo() {
   $.ajax({
       url:"/common/expressOrder/todo",
       method: "get",
       success:function (r) {
           if (r.code==0) {
               layer.open({
                   type : 2,
                   title : '增加',
                   maxmin : true,
                   shadeClose : false, // 点击遮罩关闭层
                   area : [ '800px', '520px' ],

               })
           }
       }
   })
}
function load() {


    $('#exampleTable')
        .bootstrapTable(
            {
                method : 'get', // 服务器数据的请求方式 get or post
                url : prefix + "/todo", // 服务器数据的加载地址
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
                height:600,
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

                    if(res.data.total > 0){
                        $("#home").hide();
                        window.parent.$("#home").hide();
                    }else{
                        $("#todo").hide();
                        window.parent.$("#todo").hide();
                    }
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
                        field : 'relaNo',
                        title : '关联单号',
                        valign:"middle",
                        align:"center",

                    },
                    {
                        field : 'waybillNo',
                        title : '快递单号' ,
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
                        field : 'sender',
                        title : '发件人',
                        valign:"middle",
                        align:"center",

                    },

                    {
                        field : 'senderAddress',
                        title : '发件人地址',
                        valign:"middle",
                        align:"center",

                    },
                    {
                        field : 'senderPhone',
                        title : '发件人电话',
                        valign:"middle",
                        align:"center",

                    },
                    {
                        field : 'receiver',
                        title : '收件人' ,
                        valign:"middle",
                        align:"center",

                    },
                    {
                        field : 'receiverIdcard',
                        title : '收件人身份证号',
                        valign:"middle",
                        align:"center",

                    },
                    {
                        field : 'receiverPhone',
                        title : '收件人电话',
                        valign:"middle",
                        align:"center",


                    },

                    {
                        field : 'receiverAddress',
                        title : '收件人地址' ,
                        valign:"middle",
                        align:"center",

                    },
                    {
                        field : 'goodsSeq',
                        title : '商品序号',
                        valign:"middle",
                        align:"center",
                    },
                    {
                        field : 'goodsName',
                        title : '包裹名称',
                        valign:"middle",
                        align:"center",

                    },

                    {
                        field : 'nationalShortName',
                        title : '国家简称',
                        valign:"middle",
                        align:"center",

                    },
                    {
                        field : 'originCountry',
                        title : '原产国',
                        valign:"middle",
                        align:"center",
                    },
                    {
                        field : 'goodsCode',
                        title : '货号',
                        valign:"middle",
                        align:"center",
                    },
                    {
                        field : 'goodsModel',
                        title : '商品规格',
                        valign:"middle",
                        align:"center",
                    },
                    {
                        field : 'brand',
                        valign:"middle",
                        align:"center",
                        title : '品牌名称',
                    },
                    {
                        field : 'goodsValue',
                        title : '单价',
                        valign:"middle",
                        align:"center",
                    },

                    {
                        field : 'grossWeight',
                        title : '毛重',
                        valign:"middle",
                        align:"center",
                    },
                    {
                        field : 'netWt',
                        title : '净重',
                        valign:"middle",
                        align:"center",
                    },
                    {
                        field : 'quantity',
                        title : '数量',
                        valign:"middle",
                        align:"center",
                    },


                    {
                        field : 'customerId',
                        title : '客户ID',
                        valign:"middle",
                        align:"center",

                    },

                    {
                        title : '处理进度',
                        field : 'schedule',
                        align : 'center',
                        valign:"middle",
                        align:"center",
                        formatter : function(value, row, index) {
                            if(value == 1){
                                return '<a class="btn  btn-danger" href="#" mce_href="#" title="待处理" onclick="editStatus(\''
                                    + row.id
                                    + '\')"></i>确认已处理</a> ';
                            }/*else if(value == 2){
                                return '<a class="btn  btn-primary" href="#" mce_href="#" title="已处理" onclick="editStatus(\''
                                    + row.id
                                    + '\')"></i>已处理</a> ';
                            }*/

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

function editStatus(id){
    $.ajax({
        url : prefix+"/update",
        type : "post",
        data : {
            'id' : id,
            'schedule':2
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

}
function reLoad() {
    window.location.reload();
}


