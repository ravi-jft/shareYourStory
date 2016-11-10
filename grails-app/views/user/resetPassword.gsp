<%--
  Created by IntelliJ IDEA.
  User: ravi
  Date: 27/10/16
  Time: 7:25 PM
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
<g:form action="resetCommit">
    <br>
<g:hiddenField name="tokenUrl" value="${params.tokenUrl}"/>
    <label for="password">Enter new Password </label>
    <g:textField name="password"></g:textField><br>
    <label for="confirmpassword">Confirm Password</label>
    <g:textField name="confirmpassword"></g:textField>
    <g:submitButton name="resetIt" value="ResetIt"/>
</g:form>
</body>
</html>