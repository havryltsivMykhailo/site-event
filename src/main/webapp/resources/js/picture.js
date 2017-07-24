
$(document).ready(function () {

    getAllComment();
    getLikePhoto(id);
    сheckingUser();
});
function сheckingUser() {
    $.ajax({
        url:'/profile/сhecking/'+id,
        method:'GET',
        contentType:'application/json',
        success:function (p) {
            if (p===1){
                $("#choose").css({"display":"block"});
            }
        }
    })

}

function getAllComment() {
setTimeout(function () {
    $("#comments1").empty();


    $.ajax({
        url: '/profile/picture/comment/'+id,
        method: 'GET',
        contentType: 'application/json',
        success: function (commentsr) {
            var html = "";


            for (var i = 0; i < commentsr.length; i++) {
                var dat = new Date();
                dat.setTime(commentsr[i].date)






                html += "<h4 >" + commentsr[i].author.name + "</h4><p>" + commentsr[i].comment + "</p><p>" + dat.toUTCString() + "</p><button  onclick='d("+commentsr[i].id+")'>Delete </button>";
                getAllLikeComment(id);
            }
            $("#comments1").append(html);



        }
    });
},100)

}



function getLikePhoto(id) {
    $.ajax({
        url:'/photo/like/length/'+id,
        method:'GET',
        contentType:'application/json',
        data:JSON.stringify(),
        success:function (likes) {
            setTimeout(function () {

                var like="";
                if (likes>0){

                    like=likes;
                }
                $("#like").empty();
                $("#like").append("<img style='float: left;width: 15px;height: 15px ' src='/resources/pictures/r/images.png' height='15px' width='15px'/><div style='float: left;height: 18px;width: 15px '>"+like+"</div> ")
            },1000)

        }

    })

}
function likePhoto(id) {


    $.ajax({
        url:'/photo/like/'+id,
        method:'GET',
        contentType:'application/json',
        data:JSON.stringify(),
        success:function (likes) {

            var like="";
            if (likes>0){

                like=likes;
            }
            $("#like").empty();
            $("#like").append("<img style='float: left;width: 15px;height: 15px ' src='/resources/pictures/r/images.png' height='15px' width='15px'/><div style='float: left;height: 18px;width: 15px '>"+like+"</div> ")  }

    })

}

function d (f ) {

    $.ajax({
        url:'/profile/picture/delete/comment/'+f,
        method:'GET',
        contentType: 'application/json',
        success: function() {

        }
}
)
    getAllComment();

}

    $("#send").on("click", function (e) {

        e.preventDefault();

        $.ajax({
            url: '/profile/picture/add/comment/'+id,
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(getCommentObject()),
            success: function () {
                getAllComment();
            }
        })

    });

function getCommentObject() {

    return {comment: $("#comment1").val()}

}
function getAllLikeComment(id) {


    $.ajax({
        url:'/get/like/comment/length/'+id,
        method:'GET',
        contentType:'application/json',
        success:function (likes) {


            setTimeout(function () {
                var like="";
                if (likes>0){
                    like=likes;
                }
                var a=id;

                $("#like").empty();
                $("#like").append("<div style='float: left;width: 35px;height: 18px '   onclick='addLikeComment("+id+")'><div style='float: left '><img src='/resources/pictures/r/images.png' height='15px' width='15px'  /></div><div style='float: left;height: 18px ' >" + like + "</div></div>")
            },100)

        }
    })

}
function addLikeComment(id) {

    $.ajax({
        url:'/add/like/comment/'+id,
        method:'GET',
        contentType:'application/json',
        data:JSON.stringify(),
        success:function (likes) {

            var like="";
            if (likes>0){

                like=likes;
            }
            $("#like"+id+"").empty();
            $("#like"+id+"").append("<div style='float: left;width: 35px;height: 18px '   onclick='addLikeComment("+id+")'><div style='float: left '><img src='/resources/pictures/r/images.png' height='15px' width='15px'  /></div><div style='float: left;height: 18px ' >" + like + "</div><div id='likes" + id + "'></div></div>")

        }
    })

}