
<!DOCTYPE html>
<html lang="en">

<head>
    <title></title>
    <meta name="layout" content="adminLayout">
</head>

<body>
<table border="1">
    <tbody>
    <tr>
        <td>Product Name</td>
        <td>Price</td>
        <td>Details</td>
    </tr>
    <g:each in="${product}" var="i">
        <tr>
            <td>${i.name}</td>
            <td>${i.price}</td>
            <td>${i.details}</td
        </tr>
    </g:each>
    </tbody>
</table>

<!-- jQuery -->
<script src="vendor/jquery/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Contact Form JavaScript -->
<script src="js/jqBootstrapValidation.js"></script>
<script src="js/contact_me.js"></script>

<!-- Theme JavaScript -->
<script src="js/clean-blog.min.js"></script>

</body>

</html>