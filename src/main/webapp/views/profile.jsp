<%--
  Created by IntelliJ IDEA.
  User: михайло
  Date: 14.05.2017
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="/resources/css/profil.css" rel="stylesheet">
    <script> var id=${user.id}</script>
</head>
<body>
<div id="cont">
    <div id="site">
        <div id="header"></div>
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
            <div id="photo">
                <img src="${user.avatar}" width="80%"  alt="lorem"/>

                <div id="frend"></div>
            </div>
            <div id="profil">
                <div id="name">${user.name}</div>
                <div id="secondName">${user.secondName}</div>
                <div> Birthday:${d}</div>
                <div> Gender:${user.gender}</div>
                <div> Lives in:${user.city}</div>


                <a href="/message/${user.id}">Sed message</a>
                <a href="/profile/${user.id}/pictures"> Picture</a>
                <a href="/profile/${user.id}/friends">friends</a>
                <a href="/profile/followers/${user.id}">followers</a>
            </div>



                <form action="/add/article/${user.id}" method="post" enctype="multipart/form-data" id="post">
                <div id="post2">


                        <input type="file" name="mediaFile">


                </div>
                <div id="post1">
                    <textarea name="post" id="newpost" rows="3" style="width: 100%;height: 100%" > </textarea>

                </div>


                <button id="sedpost" >Sed</button>
                </form>
<div id="article"></div>
        </div>

    </div>


</div>

<br/>
<br/>




<script src="/resources/js/jquery-3.2.1.js"></script>
<script src="/resources/js/profile.js"></script>
</body>
</html>
