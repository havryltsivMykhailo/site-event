<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: михайло
  Date: 14.07.2017
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="/resources/css/myEvents.css" rel="stylesheet">
</head>
<body>
<div id="cont">
    <div id="site">
        <div id="header">
            <div id="header2">
                <a id="actiw" href="/profile/events">My Events</a>
                <a id="part" href="/profile/events/take/part">Take part</a>
                <a id="involving" href="/profile/events/involving/friends">Events involving friends</a>
            </div>
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
            <div id="b5"><a href="/festival"><img src="/resources/pictures/r/childrens-art-festival-icon-music.png" width="100%" title="F EVENT"></a></div>
            <div id="b6"><a href="/party"><img src="/resources/pictures/r/PartyICON.png" width="100%" title="PARTY EVENT"></a></div>
            <div id="b7"><a href="/other"><img src="/resources/pictures/r/star.png" width="100%" title="OTHER EVENT"></a></div>
            <div id="b8"><a href="/event/add"><img src="/resources/pictures/r/More.png" width="100%" title="ADD EVENT"></a></div>
        </div>
        <div id="content">
            <c:forEach items="${events}" var="event">
                <div id="frend" onclick="window.location.assign('/event/${event.id}')">

                        <hr/><div style='width: 100%;float: left;margin-top: 20px; ' ><img src="${event.photo}" style='float: left' width='150px'><h1 >${event.name}</h1><p></p><p>${event.location}</p><p id='a1"+event.id+"'>${event.title}</p><div id='a2"+event.id+"' >
                        <p>${event.text}</p></div><div id='form"+event.id+"' style='width: 100%;height: 20px;float: right'><div id='1form"+event.id+"' style='width: 8%;height: 20px;float: left'></div><div id='2form"+event.id+"' style='width: 8%;height: 20px;float: left'>
                    </div><div id='3form"+event.id+"' style='width: 8%;height: 20px;float: left'></div></div><div id='comform"+event.id+"' ></div><br/></div>


                </div>

            </c:forEach>
        </div>
    </div>


</div>
</body>
</html>
