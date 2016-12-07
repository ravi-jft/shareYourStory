<html>
<head>
<title>Student Registration Form</title>
    <meta name="layout" content="AnnoymousLayout">
<style type="text/css">
h3{font-family: Calibri; font-size: 22pt; font-style: normal; font-weight: bold; color:SlateBlue;
text-align: center; text-decoration: underline }
table{font-family: Calibri; color:white; font-size: 11pt; font-style: normal;
background-color: SlateBlue; border-collapse: collapse; border: 2px solid navy}
table.inner{border: 0px}
</style>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"/>
</head>

<body>
<g:hasErrors>
    <div class="errors">
        <g:renderErrors bean="${user}" as="list" />
    </div>
</g:hasErrors>
<g:if test="${flash.message}">
    <div class="flash">${flash.message}</div>
</g:if>
<g:if test="${flash.checkNet}">
    <div class="flash">${flash.checkNet}</div>
</g:if>

<h3><center><g:message code="default.register.title"/></center> </h3>
<g:form action="register">

<table align="center" cellpadding = "10">

<!----- First Name ---------------------------------------------------------->
<tr>
<td><label><g:message code="default.label.firstname"/></label></td>
<td><g:textField type="text" name="firstname" maxlength="20" required="required" placeholder="First Name" value="${user?.firstname}"/>
(max 30 characters a-z and A-Z and mandatory fields)
</td>
</tr>
 
<!----- Last Name ---------------------------------------------------------->
<tr>
    <td><label><g:message code="default.label.lastname"/></label></td>
<td><g:textField type="text" name="lastname" maxlength="20" placeholder="Last Name" value="${user?.lastname}"/>
(max 30 characters a-z and A-Z)
</td>
</tr>
 

<!----- Email Id ---------------------------------------------------------->
<tr>
<td><label><g:message code="default.label.email"/></label></td>
<td><g:textField type="email" name="email" id="email" required="required" placeholder="Email" value="${user?.email}"/>
(mandatory field)
</td>

</tr>


<!----- Mobile Number ---------------------------------------------------------->
<tr>
    <td><label><g:message code="default.label.mobile"/></label></td>
<td>
<g:field type="number" name="contact" min="7000000000" max="9999999999" placeholder="Mobile Number" value="${user?.contact}"/>
(10 digit number)
</td>
</tr>

 
<!----- Address ---------------------------------------------------------->
<tr>
    <td><label><g:message code="default.label.address"/></label></td>
<td><g:textField type="text" name="address" rows="4" cols="30" placeholder="address" maxlength="40" value="${user?.address}"/></td>
</tr>

 
<!----- Username ---------------------------------------------------------->
<tr>
    <td><label><g:message code="default.label.username"/></label></td>
<td><g:textField type="text" name="username" id="username" maxlength="30" required="required" placeholder="username" value="${user?.username}"/>
(mandatory field)
</td>
</tr>
 
<!----- Password ---------------------------------------------------------->
<tr>
    <td><label><g:message code="default.label.password"/></label></td>
<td><g:passwordField type="password" name="password" required="required" maxlength="15" placeholder="password"/>
    (mandatory field)
</td>
</tr>

    <!----- Confirm Password ---------------------------------------------------------->
    <tr>
    <td><label><g:message code="default.label.confirm"/></label></td>
        <td><g:passwordField type="password" name="conformpassword" required="required" maxlength="15" placeholder="re-enter password"/>
        (mandatory field)
        </td>
    </tr>

 
<!----- Submit and Reset ------------------------------------------------->
<tr>
<td colspan="1" align="center">
<g:submitButton name="save" value="Save"/>
</td>
</tr>
</table>
 
</g:form>
<script>
    $("#email").blur(function(){
        $.ajax({
            data:{
                "email":$("#email").val()
            },
            url: "<g:createLink controller='user' action='checkEmail' params="email"/>",
            success: function(result){
                if($("#email").val() == result){
                    alert("Alredy in use");
                }
            }});
    });
</script>

    %{--check username by Ajax--}%
    <script>
    $("#username").blur(function(){
        $.ajax({
            data:{
                "username":$("#email").val()
            },
            url: "<g:createLink controller='user' action='checkUsername' params="username"/>",
            success: function(result){
                if($("#username").val() == result){
                    alert("Alredy in use");
                }
            }});
    });
</script>
</body>
</html>
