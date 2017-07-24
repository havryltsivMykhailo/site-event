
$(document).ready(function () {
    getArticle();
})


function getArticle() {
    $("#article").empty();
    $.ajax({
        url:'/all/article',
        method:'GET',
        contentType:'application/json',
        success:function (articles) {

            var html="";
            for (var i=0;i<articles.length;i++){
                if (articles[i].photos!==null){
                    html+="<div style='width: 53%;margin-left: 23.5%;height: 10px;background-color: white;'></div><div style='width: 53%;float: left;margin-left: 23.5%;background-color: white'><img src='"+articles[i].photos.url+"' style='width: 96%;margin-left: 2%'><div style='width: 96%;margin-left: 2%;height: 15px'><hr/></div><div id='inf"+articles[i].id+"' style='width: 96%;margin-left: 2%;height: 18px;float: left'><div id='like"+articles[i].id+"' style='float: left;width: 35px;height: 18px ' onclick='likeArticle("+articles[i].id+")'>" +
                        "</div><div id='com"+articles[i].id+"' style='float: left;width: 35px;height: 18px;margin-left: 10% '></div><a style='float: right' href='/article/delete/"+articles[i].id+"'>Delete</a><div style='float: left;margin-left:  30%;width: auto;height: 18px ' onclick='getComments("+articles[i].id+")' >add comment</div></div><div style='width: 96%;margin-left: 2%;height: auto;display: none;' id='comment"+articles[i].id+"'></div><div style='width: 96%;margin-left: 2%;height: 50px;display: none;margin-top: 25px' id='addComment"+articles[i].id+"'> " +
                        " </div></div>"
                }else if (articles[i].repost!==null){

                }else {
                    if (articles[i].photoUrl!==null||articles[i].photoUrl!==""){

                        // html+="<div style='width: 100%;height: auto;float: left'><img src='"+articles[i].photoUrl+"' style='width: 20%;float: left' ><p style='width: 70%;float: left'>"+articles[i].description+"</p></div><div id='inf"+i+"' style='width: 100%;height: 18px;float: left'></div>"
                        html+="<div style='width: 53%;margin-left: 23.5%;height: 10px;background-color: white;margin-top: 20px;float: left'></div><div style='width: 53%;float: left;margin-left: 23.5%;background-color: white''><img src='"+articles[i].photoUrl+"' style='width: 96%;margin-left: 2%'><div style='width: 96%;margin-left: 2%;height: 15px'><hr/></div><p style='width: 96%;margin-left: 2%'>"+articles[i].description+"</p><div style='width: 96%;margin-left: 2%;height: 15px'><hr/></div><div id='inf"+articles[i].id+"' style='width: 96%;margin-left: 2%;height: 18px;float: left'>" +
                            "<div id='like"+articles[i].id+"' style='float: left;width: 35px;height: 18px ' onclick='likeArticle("+articles[i].id+")'></div><div id='com"+articles[i].id+"' style='float: left;width: 35px;height: 18px;margin-left: 10% '></div><a style='float: right' href='/article/delete/"+articles[i].id+"'>Delete</a><div style='float: right;width: auto;height: 18px ' onclick='getComments("+articles[i].id+")' >add comment</div></div>" +
                            "<div style='width: 96%;margin-left: 2%;height: auto;display: none;' id='comment"+articles[i].id+"'></div><div style='width: 96%;margin-left: 2%;height: 50px;display: none;margin-top: 25px' id='addComment"+articles[i].id+"'></div></div>"
                    }else {
                        html+="<div style='width: 53%;margin-left: 23.5%;height: 10px;background-color: white;'></div><div style='width: 53%;float: left;margin-left: 23.5%;background-color: white''><p style='width: 96%;margin-left: 2%'>"+articles[i].description+"</p><div style='width: 96%;margin-left: 2%;height: 15px'><hr/></div><div id='inf"+i+"' style='width: 96%;margin-left: 2%;height: 18px;float: left'>" +
                            "<div id='like"+i+"' style='float: left;width: 35px;height: 18px ' onclick='likeArticle("+i+")'></div><div id='com"+i+"' style='float: left;width: 35px;height: 18px;margin-left: 10% '></div><a style='float: right' href='/article/delete/"+articles[i].id+"'>Delete</a><div style='float: right;width: auto;height: 18px ' onclick='getComments("+i+")' >add comment</div></div>" +
                            "<div style='width: 96%;margin-left: 2%;height: auto;display: none;' id='comment"+i+"'></div><div style='width: 96%;margin-left: 2%;height: 50px;display: none;margin-top: 25px' id='addComment"+i+"'></div></div>"
                    }


}
                getCommentLengthArticle(articles[i].id);
                getLikeArticle(articles[i].id);
            }


            $("#article").append(html);


        }
    })}

function getLikeArticle(id) {
    $.ajax({
        url:'/article/like/length/'+id,
        method:'GET',
        contentType:'application/json',
        data:JSON.stringify(),
        success:function (likes) {
            setTimeout(function () {

                var like="";
                if (likes>0){

                    like=likes;
                }
                $("#like"+id+"").empty();
                $("#like"+id+"").append("<img style='float: left;width: 15px;height: 15px ' src='/resources/pictures/r/images.png' height='15px' width='15px'/><div style='float: left;height: 18px;width: 15px '>"+like+"</div> ")
            },100)

        }

    })

}

function likeArticle(id) {


    $.ajax({
        url:'/article/like/'+id,
        method:'GET',
        contentType:'application/json',
        data:JSON.stringify(),
        success:function (likes) {

            var like="";
            if (likes>0){

                like=likes;
            }
            $("#like"+id+"").empty();
            $("#like"+id+"").append("<img style='float: left;width: 15px;height: 15px ' src='/resources/pictures/r/images.png' height='15px' width='15px'/><div style='float: left;height: 18px;width: 15px '>"+like+"</div> ")  }

    })

}
function getCommentLengthArticle(id) {
    $.ajax({
        url:'/article/get/comments/length/'+id,
        method:'GET',
        contentType:'application/json',
        data:JSON.stringify(),
        success:function (comments) {
            setTimeout(function () {

                var comment="";
                if (comments>0){

                    comment=comments;
                }
                $("#com"+id+"").empty();
                $("#com"+id+"").append("<img style='float: left ' src='/resources/pictures/r/chat.png' height='15px' width='15px'  /><div style='float: left;height: 18px;width: 15px '>"+comment+"</div>")
            },100)

        }

    })

}
function getComments(id) {

    var id1;
    $("#comment"+id+"").empty();
    $("#addComment"+id+"").empty();



    $.ajax({
        url:'/article/get/comments/'+id,
        method:'GET',
        contentType:'application/json',
        success:function (coments) {
            var html1="";

            for (var i=0;i<coments.length;i++){



                html1+="<h4>"+coments[i].author.name+"</h4><p>"+coments[i].comment+"</p><br/><div id='likes"+coments[i].id+"' style='width: 10%;display: block;background-color: darksalmon;height: auto;float: inherit; margin-left: 35px'></div><div   id='like"+coments[i].id+"' ></div><a href='/article/comment/delete/"+coments[i].id+"'>Delete</a>"
                id1=coments[i].id;
                getAllLikeComment(id1);




        }
            $("#comment"+id+"").append(html1);

    } })

    $("#addComment"+id+"").append("<img style='float: left;width: 10%' src='"+avatar+"'> <textarea id='textComment"+id+"' style='float: left;width: 80%;height: 50px'></textarea> <button style='width: 10%;height: 50px;float: right' onclick='addComment("+id+")'>Sed</button> ");
    $("#comment"+id+"").css({"display":"block"})
    $("#addComment"+id+"").css({"display":"block"})





}


    function addComment(i) {


    $.ajax({
        url:'/article/add/comment/'+i,
        method:'POST',
        contentType:'application/json',
        data:JSON.stringify(getComment(i)),
        success:function () {
            $("#addComment").css({"display":"none"});
getComments(i);

        }
    })

    }



function getComment(i) {
    return {
        comment: $("#textComment"+i+"").val()
}
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

                $("#like"+id+"").empty();
                $("#like"+id+"").append("<div style='float: left;width: 35px;height: 18px '   onclick='addLikeComment("+id+")'><div style='float: left '><img src='/resources/pictures/r/images.png' height='15px' width='15px'  /></div><div style='float: left;height: 18px ' >" + like + "</div></div>")
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