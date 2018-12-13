var prefix = "/common/board"
$(function() {
    getNowFormatDate();
});

function getNowFormatDate(){
    var date = new Date();
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear()  + month  + strDate
        + date.getHours()  + date.getMinutes()
        + date.getSeconds();
    $("#boardId").val(currentdate);
}



function playBoard(){
    var waybillNos = new Array();
    waybillNos = $("#waybillNo").val().split("\n");
    if (waybillNos == "") {
        layer.alert("请输入数据再打板!");
        return;
    }
    layer.confirm("确认'" + waybillNos.length + "'条数据打板吗?", {
        btn : [ '确定', '取消' ]
    },function(){

        $.ajax({
            type : 'POST',
            data : {
                "waybillNo" : waybillNos,
                "boardId":$("#boardId").val()
            },
            url : prefix + '/playBoard',
            success : function(r) {
                if (r.code == 0) {
                    layer.msg(r.msg);
                    location.reload();

                } else {
                    layer.msg(r.msg);
                }
            }
        });
    },function(){

    });

}
