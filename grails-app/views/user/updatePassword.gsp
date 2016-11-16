<html>
<head>
    <title></title>
</head>

<body>
<g:if test="${flash.message}"></g:if>
<h2>${flash.message}</h2>
<g:if test="${flash.error}"></g:if>
<h2>${flash.error}</h2>
<g:form controller="user" action="update">
    <g:textField name="password" placeholder="enter old password"/><br>
    <g:textField name="newPassword" placeholder="enter new password"/><br>
    <g:textField name="confirmNewPassword" placeholder="reenter new password"/>
    <g:submitButton name="update" value="Update"/>
</g:form>
</body>
</html>