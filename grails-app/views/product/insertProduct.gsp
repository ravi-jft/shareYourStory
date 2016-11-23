<html>
<%@ page contentType="text/html;charset=UTF-8" %>
<head>
    <title></title>
</head>

<body>
<g:if test="${flash.message}">
    ${flash.message}
</g:if>
<g:form action="save" method="POST">
    %{--<g:label for="name"><g:message ode="default.name.label"/> </g:label>--}%
    <g:textField name="name" placeholder="name"/><br>

    <g:textField name="price" placeholder="price"/><br>

    %{--<g:label for="details"><g:message code="default.Details.label"/> </g:label>--}%
    <g:textField name="details" placeholder="details"/><br>

    %{--<g:label for="category"><g:message code="default.category.label"/> </g:label>--}%
            <g:select name="category" from="${menus}"
             value="${menus.category}" optionValue="category" optionKey="id" noSelection="${['null':'Select...']}"/>

    <g:submitButton name="save" value="Save"/>

</g:form>
</body>
</html>