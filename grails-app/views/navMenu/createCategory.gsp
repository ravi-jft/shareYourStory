
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="myLayout">
</head>

<body>
<g:if test="${flash.message}">
    ${flash.message}
</g:if>
<g:form action="save">
    <table>
   <tr>
       <td>Category</td>
       <td><g:textField name="category" placeholder="category"/></td>
   </tr>
        <tr>
            <td>Parent</td>
       <td> <g:select name="parent" from="${navmenu}"
        value="${navmenu.category}" optionValue="category" optionKey="id" noSelection="${['null':'Select...']}" /> </td>
        </tr>

   <tr>
      <td> <g:submitButton name="save" value="Save"/></td>
   </tr>
    </table>
</g:form>
</body>
</html>