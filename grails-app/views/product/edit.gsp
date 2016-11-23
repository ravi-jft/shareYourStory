
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="myLayout">
    <title></title>
</head>

<body>
%{--<p>Edit your profile?<a href="<g:createLink controller="user" action="edit"/> ">Edit</a></p><br><br>--}%
<g:form action="update">
<table>
    <tr><td><label>Product Name</label></td>
        <td><g:textField name="name" value="${product.name}"/></td>
    </tr>
    
    <tr><td><label>Price</label></td>
        <td><g:textField name="price" value="${product.price}"/></td>
    </tr>
    
    <tr><<td><label>Details</label></td>
        <td><g:textField name="details" value="${product.details}"/></td>
    </tr>
    <tr>
          <td><g:submitButton name="update" value="Update"/> </td>
    </tr>
</table>
</g:form>
</body>
</html>