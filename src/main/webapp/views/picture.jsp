<%--
  Created by IntelliJ IDEA.
  User: михайло
  Date: 18.05.2017
  Time: 3:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="/resources/css/myEvents.css" rel="stylesheet">
</head>
<body>
<script>var id=${picture.id}</script>
<div id="cont">
    <div id="site">
        <div id="header">

        </div>
        <div id="aside1">
            <div id="a1"><a href="/profile"><img src="/resources/pictures/r/profle.png" width="100%" TITLE="PROFILE" /></a></div>
            <div id="a2"><a href="/account/edit" ><img src="/resources/pictures/r/tools.png" width="100%" title="SETTINGS"></a></div>
            <div id="a3"><a href="/messages"><img src="/resources/pictures/r/chat.png" width="100%" title="MESSAGES"></a></div>
            <div id="a4"><a href="/friends"><img src="/resources/pictures/r/Group-icon.png" width="100%" title="FRIENDS"></a></div>
            <div id="a5"><a href="/"><img src="/resources/pictures/r/news.png" width="100%" title="NEWS"></a></div>
            <div id="a6"><a href="/profile/events"><img src="/resources/pictures/r/calendar.png" width="100%" title="MY EVENTS"></a></div>
        </div>
        <div id="aside2">

            <div id="b1"><a href="/"><img src="/resources/pictures/r/events-icon@2x.png" width="100%" TITLE="ALL EVENT" /></a></div>
            <div id="b2"><a href="/music"><img src="/resources/pictures/r/music.png" width="100%" title="MUSIC EVENT"></a></div>
            <div id="b3"><a href="/sport"><img src="/resources/pictures/r/running.png" width="100%" title="SPORT EVENT"></a></div>
            <div id="b4"><a href="/art"><img src="/resources/pictures/r/art.png" width="100%" title="ART EVENT"></a></div>
            <div id="b5"><a href="/festival"><img src="/resources/pictures/r/childrens-art-festival-icon-music.png" width="100%" title="FESTIVAL EVENT"></a></div>
            <div id="b6"><a href="/party"><img src="/resources/pictures/r/PartyICON.png" width="100%" title="PARTY EVENT"></a></div>
            <div id="b7"><a href="/other"><img src="/resources/pictures/r/star.png" width="100%" title="OTHER EVENT"></a></div>
            <div id="b8"><a href="/event/add"><img src="/resources/pictures/r/More.png" width="100%" title="ADD EVENT"></a></div>
        </div>
        <div id="content">

            <div id="content2" style="width: 45%;margin-left: 25%;height: auto">
            <img src="${picture.url}" width="100%"  alt="lorem"/>
            <p >${picture.date.time}   </p>
           <div id="choose" style="display: none"> <a href="/profile/picture/${picture.id}/avatar">Choose Avatar </a>  <a style='float: right' href="/profile/picture/delete/${picture.id}">Delete</a> </div>
                <div id='inf"' style='width: 96%;margin-left: 2%;height: 18px;float: left'>
                    <div id='like' style='float: left;width: 35px;height: 18px ' onclick='likePhoto(${picture.id})'></div>
                    <div id='com' style='float: left;width: 35px;height: 18px;margin-left: 10% '></div>

                    </div>


            <div id="comments1"></div>

            <div>
                <form action="" method="post">

                    <input id="comment1" type="text" >
                    <button id="send" type="submit" >Send</button>
                </form> </div>





            </div>
        </div>
    </div>


</div>

<div>


</div>


<script src="/resources/js/jquery-3.2.1.js"></script>
<script src="/resources/js/picture.js"></script>
</body>
</html>
