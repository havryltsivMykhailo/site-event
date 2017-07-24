<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="/resources/css/profil.css" rel="stylesheet">
</head>
<script> var avatar="${user.avatar}";
var getName="${user.name}"+" "+"${user.secondName}"
</script>
<body>

<div id="cont">
    <div id="site">
        <div id="header"></div>
        <div id="aside1">
            <div id="aside1a">
                <div id="a1"><a href="/profile"><img src="/resources/pictures/r/profle.png" width="100%" TITLE="PROFILE" /></a></div>
                <div id="a2"><a href="/account/edit" ><img src="/resources/pictures/r/tools.png" width="100%" title="SETTINGS"></a></div>
                <div id="a3"><a href="/messages"><img src="/resources/pictures/r/chat.png" width="100%" title="MESSAGES"></a></div>
                <div id="a4"><a href="/friends"><img src="/resources/pictures/r/Group-icon.png" width="100%" title="FRIENDS"></a></div>
                <div id="a5"><a href="/"><img src="/resources/pictures/r/news.png" width="100%" title="NEWS"></a></div>
                <div id="a6"><a href="/profile/events"><img src="/resources/pictures/r/calendar.png" width="100%" title="MY EVENTS"></a></div>
            </div>
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


            </div>
            <div id="profil">
                <div id="name">${user.name}</div>
                <div id="secondName">${user.secondName}</div>
                <div> Birthday:${d}</div>
                <div> Gender:${user.gender}</div>
                <div> Lives in:${user.city}</div>


                <a href="/messages">My messages</a>
                <a href="/profile/pictures"> Picture</a>
            </div>


            <form id="addAvatar" action="/profile/add/avatar" method="post" enctype="multipart/form-data">
                <input width="50%"style="float: left" type="file" name="mediaFile">
                <button style="width: 50%">Add avatar</button>
            </form>
            <div id="photos"></div>

            <form action="/add/article" method="post" enctype="multipart/form-data" id="post">
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
<script src="/resources/js/jquery-3.2.1.js"></script>
<script src="/resources/js/myProfile.js"></script>


</body>










</html>
