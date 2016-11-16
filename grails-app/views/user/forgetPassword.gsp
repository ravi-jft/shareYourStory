<%--
  Created by IntelliJ IDEA.
  User: ravi
  Date: 27/10/16
  Time: 7:43 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
<g:if test="${flash.error}">
    ${flash.error}
</g:if>

<g:elseif test="${flash.message}">
    ${flash.message}
</g:elseif>
<g:form action="sendALink">
    <label for="username">Enter username</label>
    <g:textField name="username"></g:textField>
    <g:submitButton name="save" value="Save"/>
</g:form>
</body>
</html>