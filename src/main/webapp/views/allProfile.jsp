<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: михайло
  Date: 18.05.2017
  Time: 5:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div>
    <c:forEach items='${users}' var="user1">
        <div id="profiles" onclick="window.location.assign('/profile/${user1.id}')"  >

        <img src="${user1.avatar}"  width="189" height="255" alt="lorem">
        <h3>${user1.name}  ${user1.secondName}</h3>

        </div>
    </c:forEach>
</div>
</body>
</html>
