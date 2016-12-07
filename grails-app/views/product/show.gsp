
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="myLayout">
    <title></title>
</head>

<body>

<table border="1">
    <tr>
        <th>Product Name</th>
        <th>Price</th>
        <th>Details</th>
        <th>Image</th>
    </tr>
    <tr>
        <g:each in="${product}" var="i">
            <tr>
            <td>${i.name}</td>
            <td>${i.price}</td>
            <td>${i.details}</td>
            <td><g:img width="150" height="150" dir="productImages" file="${i.productImage}"/></td>
            </tr>
        </g:each>
    </tr>
</table>
</body>
</html>