<%--
  Created by IntelliJ IDEA.
  User: ravi
  Date: 10/11/16
  Time: 12:02 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
<g:if test="${flash.error}">
    <h4>${flash.error}</h4>
</g:if>

<g:form action="unlockAccountLink">
    <label for="loginUser">Enter UserName or Email</label>
    <g:textField name="loginUser" required="required"></g:textField>
    <g:submitButton name="save" value="Save"/>
</g:form>
</body>
</html>