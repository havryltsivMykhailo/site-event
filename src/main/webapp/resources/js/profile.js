/**
 * Created by михайло on 26.06.2017.
 */
$(document).ready(function () {
    сheckingForFriendship(id);
    getArticle(id);
})

function сheckingForFriendship(id) {
    $("#frend").empty();
    $.ajax({

        url:'/profile/checking/friend/'+id,
        method:'GET',
        contentType:'application/json',
        success:function (f) {
            if (f===1){
                $("#frend").append("<a href='/friend/delete/"+id+"'>delete friends</a>")
            }else if (f===2){

                $("#frend").append("<p>я підписник</p>" +
                    "<a href='/profile/following/cancel/"+id+"' >Cancel following</a>")
            }else if (f===3){
                $("#frend").append("<a href='/profile/add/friend/"+id+"' >Add friend</a>")

            }else if (f===4){    $("#frend").append("<a href='/profile/"+id+"/add/followers' >Follow</a>") }
        }
    })

}
function getArticle(id) {
    $("#article").empty();
    $.ajax({
        url:'/all/article/'+id,
        method:'GET',
        contentType:'application/json',
        success:function (articles) {
            var html="";
            for (var i=0;i<articles.length;i++){
                if (articles[i].photos!==null){
                    html+="<div style='width: 100%;float: left;'><img src='"+articles[i].photos.url+"' style='width: 30%;position: inherit'></div><div id='inf"+i+"' style='width: 100%;height: 18px;float: left'></div>"
                }else if (articles[i].repost!==null){

                }else {
                    if (articles[i].photoUrl!==null||articles[i].photoUrl!==""){

                        html+="<div style='width: 100%;height: auto;float: left'><img src='"+articles[i].photoUrl+"' style='width: 20%;float: left' ><p style='width: 70%;float: left'>"+articles[i].description+"</p></div><div id='inf"+i+"' style='width: 100%;height: 18px;float: left'></div>"

                    }else {
                        html+="<div style='width: 100%;height: auto;float: left'><p>"+articles[i].description+"</p></div><div id='inf"+i+"' style='width: 100%;height: 18px;float: left'></div>"
                    }

                }
                getLikeArticle(i);
            }
            $("#article").append(html);
        }
    })


}


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
                $("#inf"+id+"").empty();
                $("#inf"+id+"").append("<div id='like"+id+"' style='float: left;width: 35px;height: 18px ' onclick='likeArticle("+id+")'><img style='float: left ' src='/resources/pictures/r/images.png' height='15px' width='15px'  /><div style='float: left;height: 18px '>"+like+"</div> </div>")
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
            $("#inf"+id+"").empty();
            $("#inf"+id+"").append("<div id='like"+id+"' style='float: left;width: 35px;height: 18px ' onmouseover='' onmouseout='' onclick='likeArticle("+id+")'><img style='float: left ' src='/resources/pictures/r/images.png' height='15px' width='15px'  /><div style='float: left;height: 18px '>"+like+"</div> </div>")
        }

    })

}