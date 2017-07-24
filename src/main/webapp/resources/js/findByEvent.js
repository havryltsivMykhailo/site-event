/**
 * Created by михайло on 14.07.2017.
 */
$(document).ready(function () {
    getUerEvents();
});
function getUerEvents() {

    $("#content").empty();

    $.ajax({
        url:'/event/find/'+id,
        method:'GET',
        contentType:'application/json',
        success:function (event) {
            var html="";

                var  p=""
                if (event.photo!=null){
                    p="<img src='"+event.photo+"'style='float: left' width='150px'>"

                }



                getLikeUserEvent(id);
                getParticipate(id);
                getPerhapsParticipate(id);
            getComments(id);

            $("#content").append("<hr/><div style='width: 100%;float: left;margin-top: 20px; ' >"+p+"<h1 >"+event.name+"</h1><p></p><p>"+event.location+"</p><p id='a1"+event.id+"'>"+event.title+"</p><div id='a2"+event.id+"' ><p  >"+event.text+"</p></div><div id='form"+event.id+"' style='width: 100%;height: 20px;float: right'><div id='1form"+event.id+"' style='width: 8%;height: 20px;float: left'></div><div id='2form"+event.id+"' style='width: 8%;height: 20px;float: left'></div><div id='3form"+event.id+"' style='width: 8%;height: 20px;float: left'></div></div><div id='comform"+event.id+"' ><div id='comm"+event.id+"'></div><form ><input id='addcomment"+event.id+"' type='text'><button onclick='addComment("+event.id+")'  >Send</button></form></div><br/></div>");
        }
    })

}

function getLikeUserEvent(id) {
    $.ajax({
        url:'/like/userevent/Length/'+id,
        method:'GET',
        contentType:'application/json',
        data:JSON.stringify(),
        success:function (likes) {
            setTimeout(function () {
                var like="";
                if (likes>0){

                    like=likes;
                }
                $("#1form"+id+"").empty();
                $("#1form"+id+"").append("<div id='like"+id+"' style='float: left;width: 35px;height: 18px ' onclick='likeUserEvent("+id+")'><img style='float: left ' src='/resources/pictures/r/images.png' height='15px' width='15px'  /><div style='float: left;height: 18px '>"+like+"</div> </div>")
            },100)

        }

    })

}
function likeUserEvent(id) {


    $.ajax({
        url:'/like/userevent/'+id,
        method:'GET',
        contentType:'application/json',
        data:JSON.stringify(),
        success:function (likes) {

            var like="";
            if (likes>0){

                like=likes;
            }
            $("#1form"+id+"").empty();
            $("#1form"+id+"").append("<div id='like"+id+"' style='float: left;width: 35px;height: 18px ' onmouseover='' onmouseout='' onclick='likeUserEvent("+id+")'><img style='float: left ' src='/resources/pictures/r/images.png' height='15px' width='15px'  /><div style='float: left;height: 18px '>"+like+"</div> </div>")
        }

    })

}
function getParticipate(id) {
    $.ajax({
        url:'/participate/userevent/Length/'+id,
        method:'GET',
        contentType:'application/json',
        data:JSON.stringify(),
        success:function (participates) {
            setTimeout(function () {
                var participate="";
                if (participates>0){

                    participate=participates;
                }
                $("#2form"+id+"").empty();
                $("#2form"+id+"").append("<div id='participate"+id+"' style='float: left;width: 35px;height: 18px ' onclick='participate("+id+")'><img style='float: left ' src='/resources/pictures/r/More.png' height='15px' width='15px'  /><div style='float: left;height: 18px '>"+participate+"</div> </div>")
            },100)

        }

    })

}
function participate(id) {
    $.ajax({
        url:'/participate/userevent/'+id,
        method:'GET',
        contentType:'application/json',
        success:function (participates) {

            var participate="";
            if (participates>0){

                participate=participates;
            }
            $("#2form"+id+"").empty();
            $("#2form"+id+"").append("<div id='participate"+id+"' style='float: left;width: 35px;height: 18px ' onclick='participate("+id+")'><img style='float: left ' src='/resources/pictures/r/More.png' height='15px' width='15px'  /><div style='float: left;height: 18px '>"+participate+"</div> </div>")


        }

    })
}
function getPerhapsParticipate(id) {
    $.ajax({
        url:'/participate/userevent/Length/'+id,
        method:'GET',
        contentType:'application/json',
        data:JSON.stringify(),
        success:function (perhapss) {
            setTimeout(function () {
                var perhap="";
                if (perhapss>0){

                    perhap=perhapss;
                }
                $("#3form"+id+"").empty();
                $("#3form"+id+"").append("<div id='perhaps"+id+"' style='float: left;width: 100%;height: 18px; ' onclick='perhapsParticipate("+id+")'><img style='float: left ' src='/resources/pictures/r/More.png' height='15px' width='15px'  /><div style='float: left;height: 18px;'>"+perhap+"</div> </div>")
            },100)

        }

    })
}
function perhapsParticipate(id) {
    $.ajax({
        url:'/perhaps/participate/userevent/'+id,
        method:'GET',
        contentType:'application/json',
        data:JSON.stringify(),
        success:function (perhapss) {

var  perhaps="";

            if (perhapss>0){

                perhaps=perhapss;
            }
            $("#3form"+id+"").empty();
            $("#3form"+id+"").append("<div id='perhaps"+id+"' style='float: left;width: 35px;height: 18px ' onclick='perhapsParticipate("+id+")'><img style='float: left ' src='/resources/pictures/r/More.png' height='15px' width='15px'  /><div style='float: left;height: 18px '>"+perhaps+"</div> </div>")


        }

    })
}
function getComments(r) {

    var id1;
    $("#comm"+r+"").empty();

    $.ajax({
        url:'/useruvent/get/comments/'+r,
        method:'GET',
        contentType:'application/json',
        success:function (coments) {
            var html1="";

            for (var i=0;i<coments.length;i++){
                html1+="<h4>"+coments[i].author.name+"</h4><p>"+coments[i].comment+"</p><br/><div id='likes"+coments[i].id+"' style='width: 10%;display: block;background-color: darksalmon;height: auto;float: inherit; margin-left: 35px'></div><div   id='like"+coments[i].id+"' ></div>"
                id1=coments[i].id;
                getAllLikeComment(coments[i].id);
            }
            $("#comm"+r+"").append(html1);
        }
    })

    // $("#a1"+r+"").css({"display":"none"})
    //
    // setTimeout(function () {
    //
    //
    //         f2(r,id1)}
    //     ,5000);

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
                $("#like"+id+"").append("<div style='float: left;width: 35px;height: 18px ' onmouseover='getListLikeComment("+id+")'  onmouseout='ssd("+id+")'  onclick='addLikeComment("+id+")'><div style='float: left '><img src='/resources/pictures/r/images.png' height='15px' width='15px'  /></div><div style='float: left;height: 18px ' >" + like + "</div></div>")
            },100)

        }
    })

}
function getListLikeComment(id) {

    $.ajax({
        url:'/get/list/like/comment'+id,
        method:'GET',
        contentType:'application/json',
        success:function (likes) {

            var  html="";
            if (likes!=null){
                $("#likes"+id+"").empty();



                for (var i=0;i<likes.length;i++){

                    html+="<div onmouseout='ssd("+id+")'  style='width: 100%;height: auto' onclick='profile("+likes[i].author.id+")'>"+likes[i].author.name+" "+likes[i].author.secondName+"</div>"
                }

                $("#likes"+id+"").append(html);


                $("#likes"+id+"").css({"display":"block"});

            }
        }
    })


}
function ssd(id) {
    $("#likes"+id+"").css({"display":"none"});

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
            $("#like"+id+"").append("<div style='float: left;width: 35px;height: 18px ' onmouseover='getListLikeComment("+id+")' onmouseout='' onclick='addLikeComment("+id+")'><div style='float: left '><img src='/resources/pictures/r/images.png' height='15px' width='15px'  /></div><div style='float: left;height: 18px ' >" + like + "</div><div id='likes" + id + "'></div></div>")

        }
    })

}
function addComment(id) {

    $.ajax({
        url: '/user/event/add/comment/'+id,
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(getCommentObjec(id)),
        success: function () {


        }
    })

}
function getCommentObjec(d) {
    return {
        comment: $("#addcomment"+d+"").val()
    }
}