
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="myLayout">
    <title></title>
</head>

<body>
%{--<p>Edit your profile?<a href="<g:createLink controller="user" action="edit"/> ">Edit</a></p><br><br>--}%
<table>
    <tr><b><td>Product Name : </td></b><td>${product.name}</td></tr>
    <tr><b><td>Price : </td></b><td>${product.price}</td></tr>
    <tr><b><td>Details</td></b><td>${product.details}</td></tr>
</table>
</body>
</html>