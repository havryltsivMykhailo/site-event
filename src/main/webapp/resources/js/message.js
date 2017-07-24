
$(document).ready(function () {

    getAllMessage()
});
var id2=0;
function getAllMessage() {
    $("#content1").empty();

    $.ajax({
        url:'/get/message/'+id,
        method:'GET',
        contentType:'application/json',
        success:function (messag) {
          var html="";

if (messag!=null&&messag!="") {

    for (var i = 0; i < messag.length; i++) {

        html += "<p>" + messag[i].name + "</p><p>" + messag[i].message + "</p>" +
            "<a href='' onclick='deleteMessage("+messag[i].id+")'>delete</a><hr/>";

id2=messag[i].id;

    }
    // id2 = messag[messag.length-1].id;
    $("#content1").append(html)
    setInterval(function () {
        getNewMessage()
    }, 5000)
}
        }
    })



}


//
// $("#sed").on("click",function sedMessage(e) {
//
//     e.preventDefault();
//     $.ajax({
//         url:'/message/send/'+id,
//         method:'POST',
//         contentType:'application/json',
//         data:JSON.stringify(getMessageObject()),
//         success:function (mesage) {
//             $("#content1").append("<p>" + mesage.name + "</p><p>" + mesage.message + "</p><hr/>");
//             $("#form").empty();
//             $("#form").append("<form ><input id='messag1' type='text'/><button type='submit' id='sed' onclick='sendMessage()'>Send to</button></form>")
//
//
// id2=mesage.id;
//
//         }
//     })
//
// })

function sendMessage() {
    $.ajax({
        url:'/message/send/'+id,
        method:'POST',
        contentType:'application/json',
        data:JSON.stringify(getMessageObject()),
        success:function (mesage) {



            $("#content1").append("<p>" + mesage.name + "</p><p>" + mesage.message + "</p><a href='/message/delete/"+mesage.id+"'>delete</a><hr/>");
            $("#form").empty();
            $("#form").append("<form ><input id='messag1' type='text'/><button type='submit' id='sed' onclick='sendMessage()'>Send to</button></form>")


            id2=mesage.id;

        }
    })

}
function getMessageObject() {

    return {message: $("#messag1").val()}
}


function getNewMessage() {

    $.ajax({
        url:'/get/message/'+id+'/new/'+id2,
        method:'GET',
        contentType:'application/json',
        success:function (messags){
            var  html="";

            if (messags!=""&&messags!=null){

                for(var i=0;i<messags.length;i++){
                html+="<p>"+messags[i].name+"</p><p>"+messags[i].message+"</p><a href='/message/delete/"+messags[i].id+"'>delete </a><hr/>";

            }
                $("#content1").append(html)
            var o=messags.length-1;
                id2=messags[o].id;

            }
        }


    })




}
function deleteMessage(id) {

    $.ajax({
        url:'/message/delete',
        method:'POST',
        contentType:'application/json',
        data:JSON.stringify(id),
        success:function () {

        }
    })
    getAllMessage();
}