<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: михайло
  Date: 14.05.2017
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="user"  action="/account/edit" method="post">
<form:label path="name"  > Name:</form:label>
<br/>
<script>var namee="";</script>
<script>var secondname="";</script>
<script> var emaill="";</script>
<script>var passwordd="";</script>
<script>var cityy="";</script>

<script>var phonee="";</script>
<form:input path="name" onchange="namee=this.value" id="fg"/>

<form:errors path="name"  id="e1"/>
<br/>
<form:label path="secondName"> Second Name:</form:label>
<br/>
<form:input path="secondName" onchange="secondname=this.value" />
<form:errors path="secondName" id="e2"/>
<br/>
<form:label path="city">City:</form:label>
<br/>
<form:input path="city" onchange="cityy=this.value"/>
<form:errors path="city" id="e3"/>
<br/>
<form:label path="phone">Phone</form:label>
<br>
<form:input path="phone" onchange="phonee=this.value"/>
<form:errors path="phone" id="e4"/>
<br/>
<form:label path="email" > Email:</form:label>
<br/>
<form:input path="email" onchange="emaill=this.value"/>
<form:errors path="email" id="e5"/>
<br/>
<form:label path="password">Password:</form:label>
<br/>
<form:input path="password" onchange="passwordd=this.value"/>
<form:errors path="password" id="e6"/>
<br/>
<form:label path="gender">Man</form:label>
<form:radiobutton  path="gender" value="Man"/>
<form:label path="gender">Woman</form:label>
<form:radiobutton path="gender" value="Woman"/>
<br/>
<input name="dates" type="date" value="${date}"/>
<br/>
<form:button id="send">Registration</form:button>
</form:form>
</body>
</html>
