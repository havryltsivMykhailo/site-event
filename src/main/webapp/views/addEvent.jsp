<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: михайло
  Date: 09.05.2017
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="/resources/css/addEvent.css" rel="stylesheet">
</head>
<body>

<div id="cont">
    <div id="site">
        <div id="header">


        </div>

        <div id="aside1" onmouseover="asid1()" onmouseout="asid2()">
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

            <form:form modelAttribute="userEvents" action="/event/add" method="post" enctype="multipart/form-data">
                <br/>
                <form:label path="name">name</form:label>
                <form:input path="name" size="40"/>
                <br/>
                <form:label path="category">Category:</form:label>
                <form:select path="category">
                    <form:option value="Music">Music</form:option>
                    <form:option value="Sport">Sport</form:option>
                    <form:option value="Festival">Festival</form:option>
                    <form:option value="Party">Party</form:option>
                    <form:option value="Art">Art</form:option>
                    <form:option value="Other">Other</form:option>
                </form:select>
                <br/>


                <form:label path="location">location</form:label>
                <form:input path="location" size="40"/>
                <br/>

                <label >Start date:</label>
                <input name="start" type="date" />
                <br/>
                <label >Completion date:</label>
                <input name="ofCompletion" type="date" data-action=""/>
                <br/>
                <form:label path="title">brief description</form:label>
                <form:textarea path="title" cols="20" rows="7" />

                <br/>
                <form:label path="text">text</form:label>
                <form:textarea path="text" cols="50" rows="5" />

<br/>


<div><input type="file" name="mediaFile"></div>


                <form:button >Add Event</form:button>

            </form:form>


        </div>
    </div>


</div>




</body>
</html>
