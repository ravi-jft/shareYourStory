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
<g:hiddenField name="token" value="${params.token}"/>
    <label for="password">Enter new Password </label>
    <g:textField name="password" required="required"></g:textField><br>
    <label for="confirmpassword">Confirm Password</label>
    <g:textField name="confirmpassword" required="required"></g:textField>
    <g:submitButton name="resetIt" value="ResetIt"/>
</g:form>
</body>
</html>