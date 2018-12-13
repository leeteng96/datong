$().ready(function() {
    selected();
    loadTree();
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {

		update();
	}
});
function selected(){
	var opt = $("#logisticsType").val();
    $("#select1").find("option[value = '"+opt+"']").attr("selected","selected");
}

$("#select1").on("change",function () {
    var select = $("#select1 option:selected").val();
    $("#logisticsType").val(select);
})


function loadTree(){

    /*$('#cleans').jstree({
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

    }).on("loaded.jstree", function (event, data) {
        //这两句化是在loaded所有的树节点后，然后做的选中操作，这点是需要注意的，loaded.jstree 这个函数
        //取消选中，然后选中某一个节点
        $("#cleans").jstree("deselect_all",true);
        //$("#keyKamokuCd").val()是选中的节点id，然后后面的一个参数 true表示的是不触发默认select_node.change的事件
        $('#cleans').jstree('select_node',$("#cleanStatus").val(),true);
    });*/


    $('#cusId').jstree({
        'core' : {
            "plugins": ["wholerow"],
            'data': {
                'url': '/common/customerInfo/tree',
                'data': function (node) {
                }
            }
        }
    }).on("changed.jstree",function(e,node){

        $("#customerId").val(node.instance.get_node(node.selected[0]).id);

    }).on("loaded.jstree", function (event, data) {
        //这两句化是在loaded所有的树节点后，然后做的选中操作，这点是需要注意的，loaded.jstree 这个函数
        //取消选中，然后选中某一个节点
        $("#cusId").jstree("deselect_all",true);
        //$("#keyKamokuCd").val()是选中的节点id，然后后面的一个参数 true表示的是不触发默认select_node.change的事件
        $('#cusId').jstree('select_node',$("#customerId").val(),true);
    });
    ;
}
function update() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/common/expressOrder/update",
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
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			name : {
				required : true
			}
		},
		messages : {
			name : {
				required : icon + "请输入名字"
			}
		}
	})
}