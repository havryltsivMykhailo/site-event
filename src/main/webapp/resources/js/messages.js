$(document).ready(function () {
    getListMessage()
});
function getListMessage() {
    $("#content1").empty();

    $.ajax({
       url: '/messages/list',
        method:'GET',
        contentType:'application/json',
        success:function (messages) {
           var html="";
            for(var i=0;i<messages.length;i++){
                html+="<div id='messages' onclick=window.location.assign('/message/'+"+messages[i].userMesage.id+")>" +
                " <h4>"+messages[i].name+"</h4><p>"+messages[i].message+"</p></div>";
            }
            $("#content1").append(html)
        }
    })


}