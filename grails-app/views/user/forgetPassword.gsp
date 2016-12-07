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
<g:if test="${flash.message}">
    ${flash.message}
</g:if>

<g:elseif test="${flash.checkNet}">
    <div class="flash">${flash.checkNet}</div>
</g:elseif>

<g:form action="sendALink">
    <table>
        <tr>
        <td><label><g:message code="default.label.username"/> </label></td>
        <td><g:textField name="username" required="required" placeholder="username"/></td>
        </tr>

        <tr>
            <td colspan="1" align="center">
            <g:submitButton name="save" value="Save"/>
            </td>
        </tr>
    </table>
</g:form>
</body>
</html>