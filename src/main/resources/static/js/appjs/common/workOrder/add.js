$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {

		save();
	}
});
/*
function getAllSelectNodes() {
    var ref = $('#menuTree').jstree(true); // 获得整个树

    menuIds = ref.get_selected(); // 获得所有选中节点的，返回值为数组
   alert(menuIds);
    $("#menuTree").find(".jstree-undetermined").each(function(i, element) {
        menuIds.push($(element).closest('.jstree-node').attr("id"));
    });
}
function getMenuTreeData() {
    $.ajax({
        type : "GET",
        url : "/common/workOrder/tree",
        success : function(menuTree) {
            loadMenuTree(menuTree);
        }
    });
}

function loadMenuTree(menuTree) {
    $('#menuTree').jstree({
        'core' : {
            "multiple": false,
            "check_callback": true,
            'data' : menuTree
        },
        "force_text": true,
        "checkbox" : {
            "keep_selected_style": false,//是否默认选中
            "three_state": false,//父子级别级联选择
            "tie_selection": false
        },
        plugins: ["sort", "types", "themes", "html_data"],
    });

}

$('#menuTree').on('check_node.jstree', function(event, obj) {

    var ref = $('#menuTree').jstree(true);
    var nodes = ref.get_checked();  //使用get_checked方法
    alert(nodes);
    $.each(nodes, function(i, nd) {
        if (nd != obj.node.id)
            ref.plugins("checkbox");
    });
});
*/


function save() {

	$.ajax({
		cache : true,
		type : "POST",
		url : "/common/workOrder/save",
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
function validateRule() {
    $("#signupForm").bootstrapValidator({
        message: '此值无效!',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },

        fields: {
            title: {
                validators: {
                    notEmpty: {
                        message: '标题不能为空！'
                    }
                },
            },

            description: {
                validators: {
                    notEmpty: {
                        message: '描述不能为空！'
                    }
                },

            },
            solution: {
                validators: {
                    notEmpty: {
                        message: '解决方案不能为空！'
                    }
                },

            },
            result: {
                validators: {
                    notEmpty: {
                        message: '结果不能为空！'
                    }
                },

            },
            assignment: {
                validators: {
                    notEmpty: {
                        message: '指派不能为空！'
                    }
                },

            },






        }

    }).on('success.form.bv', function (e) {

        save();

        //提交逻辑
    });
}
