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
<g:form action="sendALink">
    <label for="loginUser">Enter UserName or Email</label>
    <g:textField name="loginUser"></g:textField>
    <g:submitButton name="save" value="Save"/>
</g:form>
</body>
</html>