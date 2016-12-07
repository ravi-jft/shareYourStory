<html>
<%@ page import="loginWithMail.Product" contentType="text/html;charset=UTF-8" %>
<head>
    <title></title>
    <meta name="layout" content="adminLayout">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"/>
</head>

<body>
<g:if test="${flash.message}">
    ${flash.message}
</g:if>

<g:hasErrors>
    <div class="errors">
        <g:renderErrors bean="${productInstance}" as ="list"/>
    </div>
</g:hasErrors>

<g:uploadForm controller="product" action="save" method="post" enctype="multipart/form-data">

    <table align="center" cellpadding = "10">
        <tr>
       <td> <label> <g:message code="default.name.label"/> </label></td>
       <td><input type="text" name="name" id="name" placeholder="name" value="${productInstance?.name}" maxlength="15" required="required"/></td>
        </tr>

         <tr>
       <td><label><g:message code="default.price.label"/> </label></td>
            <td><input type="number" name="price" placeholder="price" value="${productInstance?.price}" min="1",max="1000000"  required="required"/></td>
         </tr>

        <tr>
            <td><label><g:message code="default.Unit.label"/> </label></td>
            <td><input type="number" name="unit" placeholder="Unit" value="${productInstance?.unit}" required="required" min="1" max="1000"/></td>
        </tr>

       <tr>
          <td><label><g:message code="default.Details.label"/> </label></td>
           <td><input type="text" name="details"  id="details" placeholder="details" value="${productInstance?.details}" required="required" maxlength="50"/></td>
       </tr>

        <tr>
            <td><label><g:message code="default.category.label"/> </label></td>
            <td><g:select name="category" from="${menus}"
             value="${menus?.category}" optionValue="category" optionKey="id" noSelection="${['null':'Select...']}"/></td>
        </tr>

        <tr>
           <td><input type="file" name="productImage" id="productImage"></td>
        </tr>

        <tr>
            <td colspan="2" align="center">
            <g:submitButton name="save" value="Save"/>
        </td>
        </tr>
    </table>

</g:uploadForm>
<h1>View All Product</h1>
<table border="1">
    <tr>
        <th>Product Name</th>
        <th>Price</th>
        <th>Unit</th>
        <th>Details</th>
        <th>Image</th>
    </tr>
        <g:each in="${Product.list()}" var="i">
            <tr>
                <td>${i.name}</td>
                <td>${i.price}</td>
                <td>${i.unit}</td>
                <td>${i.details}</td>
                <td><g:img width="150" height="150" dir="productImages" file="${i.productImage}"/></td>
                <td> <g:link controller="cart" action="save" params='[price:"${i.price}",productid:"${i.id}",productimage:"${i.productImage}"]'>Add To Cart</g:link> </td>
            </tr>
        </g:each>
</table>

<script>
    $('#name').keypress(function (e) {
        var regex = new RegExp("^[a-zA-Z0-9-]*$");
        var str = String.fromCharCode(!e.charCode ? e.which : e.charCode);
        if (regex.test(str)) {
            return true;
        }

        e.preventDefault();
        return false;
    });
</script>

</body>
</html>