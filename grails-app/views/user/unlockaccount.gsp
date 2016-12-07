
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
<g:if test="${flash.message}">
    ${flash.message}
</g:if>

<g:elseif test="${flash.blank}">
   ${flash.blank}
</g:elseif>

<g:elseif test="${flash.checkNet}">
    <div class="flash">${flash.checkNet}</div>
</g:elseif>

<g:form action="unlockAccountLink">
    <label><g:message code="default.label.username"/> </label>
    <g:textField name="loginUser" placeholder="username" required="required"/>
    <g:submitButton name="save" value="Save"/>
</g:form>
</body>
</html>