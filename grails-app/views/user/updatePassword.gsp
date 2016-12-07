<html>
<head>
   %{-- <meta name="layout" content="adminLayout">--}%
    <title></title>
</head>

<body>

<g:if test="${flash.message}">
${flash.message}
</g:if>

<g:elseif test="${flash.error}">
${flash.error}
</g:elseif>

<g:elseif test="${flash.blank}">
    ${flash.blank}
</g:elseif>

<g:form action="update">
    <h3><g:message code="update.password"/></h3>
    <table>
        <tr>
        <td><label><g:message code="default.label.oldPassword"/> </label></td>
        <td><g:passwordField name="password" placeholder="enter old password" required="required" maxlength="15"/></td>
        </tr>

        <tr>
        <td><label><g:message code="default.label.newPassword"/> </label></td>
        <td><g:passwordField name="newPassword"  placeholder="enter new password" required="required" maxlength="15"/></td>
        </tr>

        <tr>
        <td><label><g:message code="default.label.confirmNewPassword"/> </label></td>
        <td><g:passwordField name="confirmNewPassword"  placeholder="reenter new password" required="required" maxlength="15" /></td>
        </tr>

        <td colspan="1" align="center">
        <g:submitButton name="update" value="Update"/>
        </td>
    </table>
</g:form>
</body>
</html>