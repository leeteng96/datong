$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/common/product/save",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}
function dateShow(){
    $("div[name='date']").datetimepicker({
        format: 'YYYY-MM-DD HH:mm:ss',
        locale: moment.locale('zh-cn')
    })
}



function validateRule() {
    $("#signupForm").bootstrapValidator({
        message: '此值无效!',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },

        fields: {
            productName: {
                validators: {
                    notEmpty: {
                        message: '商品名称不能为空！'
                    }
                },
            },

            productCode: {
                validators: {
                    notEmpty: {
                        message: '商品编码不能为空！'
                    }
                },
            },

            originCountry: {
                validators: {
                    notEmpty: {
                        message: '原产国不能为空！'
                    }
                },
            },

            productPrice: {
                validators: {
                    notEmpty: {
                        message: '商品价格不能为空！'
                    }
                },
                regexp: {
                    regexp: /^[0-9]+$/,
                    message: '商品价格只能为数字！'
                }
            },

            productWeight: {
                validators: {
                    notEmpty: {
                        message: '订单号不能为空！'
                    }
                },
                regexp: {
                    regexp: /^[0-9]+$/,
                    message: '商品重量只能为数字！'
                }
            },

            productModel: {
                validators: {
                    notEmpty: {
                        message: '订单号不能为空！'
                    }
                },
                regexp: {
                    regexp: /^[0-9]+$/,
                    message: '商品规格只能为数字！'
                }
            },

            productionDate: {
                validators: {
                    notEmpty: {
                        message: '生产日期不能为空！'
                    }
                },
                regexp: {
                    regexp: /(((01[0-9]{2}|0[2-9][0-9]{2}|[1-9][0-9]{3})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|((01[0-9]{2}|0[2-9][0-9]{2}|[1-9][0-9]{3})-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|((01[0-9]{2}|0[2-9][0-9]{2}|[1-9][0-9]{3})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((04|08|12|16|[2468][048]|[3579][26])00))-0?2-29)) (20|21|22|23|[0-1]?\\d):[0-5]?\\d:[0-5]?\\d/,
                    message: '请正确填写生产日期！'
                }
            },



            productName: {
                validators: {
                    notEmpty: {
                        message: '订单号不能为空！'
                    }
                },
            },

            productName: {
                validators: {
                    notEmpty: {
                        message: '订单号不能为空！'
                    }
                },
            },

            productName: {
                validators: {
                    notEmpty: {
                        message: '订单号不能为空！'
                    }
                },
            },
        }

    }).on('success.form.bv', function (e) {

        save();

        //提交逻辑
    });
}