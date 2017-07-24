/**
 * Created by михайло on 16.06.2017.
 */
$(document).ready(function () {
    authentication();
    getUerEvents();
})
function authentication() {
    var a="anonymous"
    if (us!==a){
        $("#login").css({"display":"none"})
        $("#delComment").css({"display":"block"})
    }

}
function getUerEvents() {

    $("#content").empty();

    $.ajax({
        url:'/get/user/event/'+category,
        method:'GET',
        contentType:'application/json',
        success:function (events) {

            var html="";
            for (var i=0;i<events.length;i++){

                var  p=""
                if (events[i].photo!=null){
                    p="<img src='"+events[i].photo+"'style='float: left' width='150px'>"

                }


                html+="<hr/><div style='width: 100%;float: left;margin-top: 20px; ' >"+p+"<h1 >"+events[i].name+"</h1><p></p><p>"+events[i].location+"</p><p id='a1"+events[i].id+"'>"+events[i].title+"</p><div id='a2"+events[i].id+"' style='display: none'><p  >"+events[i].text+"</p></div><div id='form"+events[i].id+"' style='width: 100%;height: 20px;float: right'><div id='1form"+events[i].id+"' style='width: 8%;height: 20px;float: left'></div><div id='2form"+events[i].id+"' style='width: 8%;height: 20px;float: left'></div><div id='3form"+events[i].id+"' style='width: 8%;height: 20px;float: left'></div></div><button id='more"+events[i].id+"' onclick='f1("+events[i].id+")'>Read more</button><div id='comform"+events[i].id+"' style='display: none'><div id='comm"+events[i].id+"'></div><form ><input id='comment1' type='text'><button onclick='addComment("+events[i].id+")'  >Send</button></form></div><br/></div>"
                getLikeUserEvent(events[i].id);
                getParticipate(events[i].id);
                getPerhapsParticipate(events[i].id);
            }
            $("#content").append(html);
        }
    })

}

function addComment(id) {







    $.ajax({
        url: '/user/event/add/comment/'+id,
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(getCommentObjec()),
        success: function () {

            getAllComment();
        }
    })

}
function getCommentObjec() {
    return {
        comment: $("#comment1").val()
    }
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
            },300)

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
function profile(id) {

    var url = "/profile/"+id;
    $(location).attr('href',url);
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
        data:JSON.stringify(),
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


            var perhaps="";
            if (perhapss>0){

                perhaps=perhapss;
            }
            $("#3form"+id+"").empty();
            $("#3form"+id+"").append("<div id='perhaps"+id+"' style='float: left;width: 35px;height: 18px ' onclick='perhapsParticipate("+id+")'><img style='float: left ' src='/resources/pictures/r/More.png' height='15px' width='15px'  /><div style='float: left;height: 18px '>"+perhaps+"</div> </div>")


        }

    })
}
function asid1() {
    $("#aside1a").css({"display":"block"})
}
function asid2() {
    $("#aside1a").css({"display":"none"})
}
function f1(r) {

    var id1;
    $("#comm"+r+"").empty();

    $.ajax({
        url:'/useruvent/get/comments/'+r,
        method:'GET',
        contentType:'application/json',
        success:function (coments) {
            var html1="";

            for (var i=0;i<coments.length;i++){
                html1+="<h4>"+coments[i].author.name+"</h4><p>"+coments[i].comment+"</p><div id='likes"+coments[i].id+"' style='width: 10%;display: block;background-color: darksalmon;height: auto;float: inherit; margin-left: 35px'></div><div   id='like"+coments[i].id+"' ></div><a id='delComment' style='display: none' href='/event/comment/delete/"+coments[i].id+"'>Delete</a>"
                id1=coments[i].id;
                getAllLikeComment(coments[i].id);
            }

            $("#comm"+r+"").append(html1);
        }
    })

    $("#a1"+r+"").css({"display":"none"})
    $("#a2"+r+"").css({"display":"block"})
    $("#comform"+r+"").css({"display":"block"})
    $("#more"+r+"").css({"display":"none"})
    setTimeout(function () {


            f2(r,id1)}
        ,5000);

}

function f2(r,id) {
    $.ajax({
        url:'/useruvent/get/comments/'+r+'/onl/'+id,
        method:'GET',
        contentType:'application/json',
        success:function (coments) {
            var id1;


            for (var i=0;i<coments.length;i++){

                $("#comm"+r+"").append("<h4 >"+coments[i].author.name+"</h4><p>"+coments[i].comment+"</p><div  id='likes"+id+"'   ></div><a id='delComment' style='display: none' href='/event/comment/delete/"+coments[i].id+"'>Delete</a>");
                id1=coments[i].id;

            }

            if (id1==null){
                id1=id;
            }

            setTimeout(function () {

                f2(r,id1)
            },2000)
        }
    })
}
function sortDate() {
    $("#content").empty();

    $.ajax({
        url:'/get/user/event/'+category,
        method:'POST',
        contentType:'application/json',
        data:JSON.stringify($("#sortDate").val()),
        success:function (events) {

            var html="";
            for (var i=0;i<events.length;i++){
                var  p=""
                if (events[i].photo!=null){
                    p="<img src='"+events[i].photo+"'style='float: left' width='150px'>"

                }


                html+="<hr/><div style='float: left;margin-top: 20px; ' >"+p+"<h1 >"+events[i].name+"</h1><p></p><p>"+events[i].location+"</p><p id='a1"+events[i].id+"'>"+events[i].title+"</p><div id='a2"+events[i].id+"' style='display: none'><p  >"+events[i].text+"</p></div><div id='form"+events[i].id+"' style='width: 100%;height: 20px;float: right'><div id='1form"+events[i].id+"' style='width: 8%;height: 20px;float: left'></div><div id='2form"+events[i].id+"' style='width: 8%;height: 20px;float: left'></div><div id='3form"+events[i].id+"' style='width: 8%;height: 20px;float: left'></div></div><button id='more"+events[i].id+"' onclick='f1("+events[i].id+")'>Read more</button><div id='comform"+events[i].id+"' style='display: none'><div id='comm"+events[i].id+"'></div><form ><input id='addcomment"+events[i].id+"' type='text'><button onclick='addComment("+events[i].id+")'  >Send</button></form></div><br/></div>"
                getLikeUserEvent(events[i].id);
                getParticipate(events[i].id);
                getPerhapsParticipate(events[i].id);
            }
            $("#content").append(html);

        }
    })
}