
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="myLayout">
    <title></title>
</head>

<body>
<p>Edit your profile?<a href="<g:createLink controller="user" action="edit"/> ">Edit</a></p><br><br>
<table>
    <tr><b><td>User Name : </td></b><td>${user.username}</td></tr>
    <tr><b><td>First Name : </td></b><td>${user.firstname}</td></tr>
    <tr><b><td>Last Name</td></b><td>${user.lastname}</td></tr>
    <tr><b><td>Contact No : </td></b><td>${user.contact}</td></tr>
    <tr><b><td>Address : </td></b><td>${user.address}</td></tr>
  %{--  <tr><b><td>Profile Picture : </td></b><td><img class="avatar" width="150" height="150" src="${createLink(controller:'profile', action:'viewprofile')}" /></td></tr>--}%
    <tr><b><td>Email: </td></b><td>${user.email}</td></tr>
</table>
</body>
</html>