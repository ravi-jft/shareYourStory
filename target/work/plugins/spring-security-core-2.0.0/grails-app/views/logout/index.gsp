<%--
  Created by IntelliJ IDEA.
  User: ravi
  Date: 27/10/16
  Time: 11:47 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
<g:if test="${flash.message}">
    <h4>${flash.error}</h4>
</g:if>
<g:if test="${flash.messageLink}">
    <h4>${flash.error}</h4>
</g:if>
<p>Redirect to login page?<a href="<g:createLink controller="login" action="auth"/> ">SignIn</a></p>

<p>SignUp for another account?<a href="<g:createLink controller="user" action="register"/> ">SignUp</a></p>
</body>
</html>