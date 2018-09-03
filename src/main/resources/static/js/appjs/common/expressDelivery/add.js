$(function() {
    $("#insertPro").hide();
    validateRule();
});


var  i=0;
function save() {
    var productId = $('#exampleTable').bootstrapTable('getSelections');
    var ids = new Array();
    // 遍历所有选择的行数据，取每条数据对应的ID
    $.each(productId, function(i, row) {
        ids[i] = row['productId'];
    });
    i = 1;
    if($.trim(ids) != ''){
        //选择商品以后
        $.ajax({
            cache : true,
            type : "POST",
            url : "/common/expressDelivery/insertPro/"+ids,
            data : $('#signupForm').serialize(),
            // data :expressDeliverys,// 你的formid
            async : false,
            error : function(request) {
                parent.layer.alert("Connection error");
            },
            success : function(data) {
                if (data.code == 0) {
                    parent.layer.msg("保存成功");
                    parent.reLoad();
                    var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
                    parent.layer.close(index);

                } else {
                    parent.layer.alert(data.msg)
                }

            }
        });
    }else{
        //没有选择之前
        $.ajax({
            cache : true,
            type : "POST",
            url : "/common/expressDelivery/save",
            data : $('#signupForm').serialize(),
            // data :expressDeliverys,// 你的formid
            async : false,
            error : function(request) {
                parent.layer.alert("Connection error");
            },
            success : function(data) {
                var row = $("#exampleTable").bootstrapTable('getData');
                console.log(row.rows);
                if (data.code == 0) {
                    parent.layer.msg("保存成功");
                    // parent.reLoad();
                    var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
                    //parent.location.reload();
                }

            }
        });
        document.forms[0].target="rfFrame";
    }

}


function showPro(ids){
    var id = ids.substring(1);
    $("#exampleTable").bootstrapTable('destroy');
    $('#exampleTable')
        .bootstrapTable(
            {
                method : 'get', // 服务器数据的请求方式 get or post
                url : "/common/product/jumpAdd/"+id, // 服务器数据的加载地址
                iconSize : 'outline',
                toolbar : '#exampleToolbar',
                striped : true, // 设置为true会有隔行变色效果
                dataType : "json", // 服务器返回的数据类型
                pagination : true, // 设置为true会在底部显示分页条
                singleSelect : false, // 设置为true将禁止多选
                showColumns : false, // 是否显示内容下拉框（选择显示的列）
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

                columns : [
                    {
                        checkbox : true,
                        formatter:function (value, row, index) {
                            return{
                                checked: true//设置选中
                            }
                        }
                    },

                    {
                        field : 'productId',
                        title : '序号',
                    },
                    {
                        field : 'productName',
                        title : '商品名称'
                    },
                    {
                        field : 'productCode',
                        title : '商品编码'
                    },
                    {
                        field : 'originCountry',
                        title : '原产国'
                    },
                    {
                        field : 'productPrice',
                        title : '商品价格'
                    },
                    {
                        field : 'productWeight',
                        title : '商品重量'
                    },
                    {
                        field : 'productModel',
                        title : '商品规格'
                    },
                    {
                        field : 'productColor',
                        title : '商品颜色'
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
                        title : '操作',
                        field : 'productionDate',
                        formatter : function(value, row, index) {

                            var d = '<a class="btn btn-warning btn-sm " href="#" title="删除"  mce_href="#" onclick="remove(\''
                                + row.productId
                                + '\')"><i class="fa fa-remove"></i></a> ';

                            return  d;
                        }
                    } ]
            });



}

function remove(id){
    $('#exampleTable').bootstrapTable('remove', {
        field:'productId',
        values:[parseInt(id)]
    });
}


$('#proShow').on('click', function(){
   if(i<1){
        parent.layer.alert("请先提交！");
    }else{
    var products = $('#exampleTable').bootstrapTable('getSelections');
    var ids ="";
    $.each(products, function(i, product) {
        if(ids == ""){
            ids += product['productId'];
        }else{
            ids += ","+product['productId'];
        }

    });
    if(ids != 'undefined'){
        layer.open({
            type: 2
            ,title: '请选择商品'
            ,maxmin : true
            ,shadeClose : false
            ,area: ['500px', '260px']
            ,content: '/common/product/jumpPro/'+ids,
            end:function () {
                $('#proShow').show();
            },
            success:function () {
                $('#proShow').hide();
            }
        });
    }else{

        layer.open({
            type: 2
            ,title: '请选择商品'
            ,maxmin : true
            ,shadeClose : false
            ,area: ['500px', '260px']
            ,content: '/common/product/jumpPro',
            end:function () {
                $('#proShow').show();
            },
            success:function () {
                $('#proShow').hide();
            }
        });
    }


       }
});

function validateRule() {
    $("#signupForm").bootstrapValidator({
        message: '此值无效!',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },

        fields: {
            orderNo: {
                validators: {
                    notEmpty: {
                        message: '订单号不能为空！'
                    }
                },
            },
            receiverAddress: {
                validators: {
                    notEmpty: {
                        message: '收件人地址不能为空！'

                    },
                },
            },
            receiver: {
                validators: {
                    notEmpty: {
                        message: '收件人不能为空！'
                    },
                    stringLength: {
                        min: 2,
                        message: '收件人名字长度必须大于1！'
                    },


                },
            },
            receiverIdcard: {
                validators: {
                    notEmpty: {
                        message: '身份证号码不能为空！'
                    },
                    regexp: {
                        regexp: /^(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx])$)$/,
                        message: '身份证号码格式不正确，为15位和18位身份证号码！'
                    },
                    callback: {
                        /*自定义，可以在这里与其他输入项联动校验*/
                        message: '身份证号码无效！',
                        callback: function (value, validator, $field) {
                            //15位和18位身份证号码的正则表达式
                            var regIdCard = /^(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx])$)$/;
                            //如果通过该验证，说明身份证格式正确，但准确性还需计算
                            var idCard = value;
                            if (regIdCard.test(idCard)) {
                                if (idCard.length == 18) {
                                    var idCardWi = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2); //将前17位加权因子保存在数组里
                                    var idCardY = new Array(1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2); //这是除以11后，可能产生的11位余数、验证码，也保存成数组
                                    var idCardWiSum = 0; //用来保存前17位各自乖以加权因子后的总和
                                    for (var i = 0; i < 17; i++) {
                                        idCardWiSum += idCard.substring(i, i + 1) * idCardWi[i];
                                    }
                                    var idCardMod = idCardWiSum % 11;//计算出校验码所在数组的位置
                                    var idCardLast = idCard.substring(17);//得到最后一位身份证号码
                                    //如果等于2，则说明校验码是10，身份证号码最后一位应该是X
                                    if (idCardMod == 2) {
                                        if (idCardLast == "X" || idCardLast == "x") {
                                            return true;
                                            //alert("恭喜通过验证啦！");
                                        } else {
                                            return false;
                                            //alert("身份证号码错误！");
                                        }
                                    } else {
                                        //用计算出的验证码与最后一位身份证号码匹配，如果一致，说明通过，否则是无效的身份证号码
                                        if (idCardLast == idCardY[idCardMod]) {
                                            //alert("恭喜通过验证啦！");
                                            return true;
                                        } else {
                                            return false;
                                            //alert("身份证号码错误！");
                                        }
                                    }
                                }
                            } else {
                                //alert("身份证格式不正确!");
                                return false;
                            }
                        }
                    }
                }
            },
            senderAddress: {
                validators: {
                    notEmpty: {
                        message: '发件人地址值不能为空！',



                    },
                },
            },

            sender: {
                validators: {
                    notEmpty: {
                        message: '发件人不能为空！'
                    },
                    stringLength: {
                        min: 1,
                        message: '发件人名字长度必须大于1！'
                    },
                    /* regexp: {
                         regexp: /^[a-zA-Z\u4e00-\u9fa5]+$/,
                         message: '用户名不能有数字和字符！'
                     }*/


                },
            },
            senderIdcard: {
                validators: {
                    notEmpty: {
                        message: '身份证号码不能为空！'
                    },
                    regexp: {
                        regexp: /^(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx])$)$/,
                        message: '身份证号码格式不正确，为15位和18位身份证号码！'
                    },
                    callback: {
                        /*自定义，可以在这里与其他输入项联动校验*/
                        message: '身份证号码无效！',
                        callback: function (value, validator, $field) {
                            //15位和18位身份证号码的正则表达式
                            var regIdCard = /^(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx])$)$/;
                            //如果通过该验证，说明身份证格式正确，但准确性还需计算
                            var idCard = value;
                            if (regIdCard.test(idCard)) {
                                if (idCard.length == 18) {
                                    var idCardWi = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2); //将前17位加权因子保存在数组里
                                    var idCardY = new Array(1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2); //这是除以11后，可能产生的11位余数、验证码，也保存成数组
                                    var idCardWiSum = 0; //用来保存前17位各自乖以加权因子后的总和
                                    for (var i = 0; i < 17; i++) {
                                        idCardWiSum += idCard.substring(i, i + 1) * idCardWi[i];
                                    }
                                    var idCardMod = idCardWiSum % 11;//计算出校验码所在数组的位置
                                    var idCardLast = idCard.substring(17);//得到最后一位身份证号码
                                    //如果等于2，则说明校验码是10，身份证号码最后一位应该是X
                                    if (idCardMod == 2) {
                                        if (idCardLast == "X" || idCardLast == "x") {
                                            return true;
                                            //alert("恭喜通过验证啦！");
                                        } else {
                                            return false;
                                            //alert("身份证号码错误！");
                                        }
                                    } else {
                                        //用计算出的验证码与最后一位身份证号码匹配，如果一致，说明通过，否则是无效的身份证号码
                                        if (idCardLast == idCardY[idCardMod]) {
                                            //alert("恭喜通过验证啦！");
                                            return true;
                                        } else {
                                            return false;
                                            //alert("身份证号码错误！");
                                        }
                                    }
                                }
                            } else {
                                //alert("身份证格式不正确!");
                                return false;
                            }
                        }
                    }
                }
            },
            data: {
                validators: {
                    notEmpty: {
                        message: '数量不能为空！'
                    },
                    regexp: {
                        regexp: /^[0-9]+$/,
                        message: '数量量只能为数字！'
                    }

                }
            },
            weight: {
                validators: {
                    notEmpty: {
                        message: '重量不能为空！'
                    },


                }
            },






        }

    }).on('success.form.bv', function (e) {

        save();

        //提交逻辑
    });
}

