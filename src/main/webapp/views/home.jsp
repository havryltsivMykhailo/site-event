<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: михайло
  Date: 09.05.2017
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="/resources/css/profil.css" rel="stylesheet">
</head>
<script>var us="<sec:authentication property="name"/>"</script>


<div id="cont">
    <div id="site">
        <div id="header">
            <div id="login" >
                <form  action="/sign-in-processing" method="post">


                    <label >Login:</label>

                    <input  name="username" type="text" placeholder="Login"  required>

                    <label >Password:</label>
                    <input name="password" type="password" placeholder="password" required>



                    <button  type="submit">Sign in!</button>
                    <a href="/registration">Dont have Account? Sign up!</a>
                </form>

            </div>
        </div>
        <div id="aside1" onmouseover="asid1()" onmouseout="asid2()">
            <div id="aside1a" style="display: none">
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
            <div id="b5"><a href="/festival"><img src="/resources/pictures/r/childrens-art-festival-icon-music.png" width="100%" title="F EVENT"></a></div>
            <div id="b6"><a href="/party"><img src="/resources/pictures/r/PartyICON.png" width="100%" title="PARTY EVENT"></a></div>
            <div id="b7"><a href="/other"><img src="/resources/pictures/r/star.png" width="100%" title="OTHER EVENT"></a></div>
            <div id="b8"><a href="/event/add"><img src="/resources/pictures/r/More.png" width="100%" title="ADD EVENT"></a></div>
        </div>
        <div id="dateSort"><input style="width: 150px;height: 30px" type="date" name="date" id="sortDate" ><button onclick="sortDate()">sort:</button></div>
        <div id="content">
<div id="repost">
    <div><label>Comment:</label>  <input name="" id="repostComment" value="efcfc"></div>
    <div id="repostEvent"></div>


</div>

        </div>

    </div>


</div>












<script src="/resources/js/jquery-3.2.1.js"></script>
<script src="/resources/js/home.js"></script>

</body>
</html>
