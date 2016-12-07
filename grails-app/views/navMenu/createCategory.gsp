
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="adminLayout">
</head>

<body>
<g:if test="${flash.message}">
    ${flash.message}
</g:if>

<g:hasErrors>
    <div class="errors">
        <g:renderErrors bean="${navInstance}" as="list" />
    </div>
</g:hasErrors>

<g:form action="save">
    <table>
       <tr>
           <td><label><g:message code="default.label.category"/> </label></td>
           <td><g:textField name="category" placeholder="category" required="required"/></td>
       </tr>

        <tr>
            <td><label><g:message code="default.label.parent"/> </label></td>
            <td> <g:select name="parent" from="${navmenu}"
            value="${navmenu?.category}" optionValue="category" optionKey="id" noSelection="${['null':'Select...']}" /> </td>
        </tr>

       <tr>
          <td> <g:submitButton name="save" value="Save"/></td>
       </tr>
    </table>
</g:form>
</body>
</html>