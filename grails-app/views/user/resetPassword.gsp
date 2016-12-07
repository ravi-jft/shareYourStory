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

<g:elseif test="${flash.message}">
    ${flash.message}
</g:elseif>

<g:form action="resetCommit">
    <br>
<g:hiddenField name="token" value="${params.token}"/>
    <table>
         <tr>
            <td><label><g:message code="default.label.password"/> </label></td>
            <td><g:passwordField name="password" required="required"/></td>
         </tr>

        <tr>
            <td><label><g:message code="default.label.confirm"/> </label></td>
            <td><g:passwordField name="confirmpassword" required="required"/></td>
        </tr>

       <tr>
           <td colspan="1" align="center">
            <g:submitButton name="resetIt" value="ResetIt"/></td>
       </tr>
    </table>
</g:form>
</body>
</html>