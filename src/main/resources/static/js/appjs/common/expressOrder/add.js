$().ready(function() {
	validateRule();
    loadjsTree()
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
		url : "/common/expressOrder/save",
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

function  loadjsTree() {

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



  $('#cusId').jstree({
       'core' : {
           'data': {
               'url': '/common/customerInfo/tree',
               'data': function (node) {
               }
           }
       }
   }).on("changed.jstree",function(e,node){

      $("#customerId").val(node.instance.get_node(node.selected[0]).id);

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
				required : icon + "请输入姓名"
			}
		}
	})
}