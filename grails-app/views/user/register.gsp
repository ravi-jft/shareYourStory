<html>
<head>
<title>Student Registration Form</title>
    <meta name="layout" content="signUpLayout">
<style type="text/css">
h3{font-family: Calibri; font-size: 22pt; font-style: normal; font-weight: bold; color:SlateBlue;
text-align: center; text-decoration: underline }
table{font-family: Calibri; color:white; font-size: 11pt; font-style: normal;
background-color: SlateBlue; border-collapse: collapse; border: 2px solid navy}
table.inner{border: 0px}
</style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
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
<h3>STUDENT REGISTRATION FORM</h3>
<g:form action="register">
 
<table align="center" cellpadding = "10">
 
<!----- First Name ---------------------------------------------------------->
<tr>
<td>FIRST NAME</td>
<td><g:textField type="text" name="firstname" maxlength="20" required="required" placeholder="First Name" value="${user?.firstname}"/>
(max 30 characters a-z and A-Z and mandatory fields)
</td>
</tr>
 
<!----- Last Name ---------------------------------------------------------->
<tr>
<td>LAST NAME</td>
<td><g:textField type="text" name="lastname" maxlength="20" placeholder="Last Name" value="${user?.lastname}"/>
(max 30 characters a-z and A-Z)
</td>
</tr>
 

<!----- Email Id ---------------------------------------------------------->
<tr>
<td>EMAIL ID</td>
<td><g:textField type="text" name="email" id="email" required="required" placeholder="Email"  value="${user?.email}"/>
(mandatory field)
</td>

</tr>


<!----- Mobile Number ---------------------------------------------------------->
<tr>
<td>MOBILE NUMBER</td>
<td>
<g:textField type="text" name="contact" maxlength="10" placeholder="Mobile Number"  value="${user?.contact}"/>
(10 digit number)
</td>
</tr>

 
<!----- Address ---------------------------------------------------------->
<tr>
<td>ADDRESS <br /><br /><br /></td>
<td><g:textField type="text" name="address" rows="4" cols="30" placeholder="address"  value="${user?.address}"/></td>
</tr>

 
<!----- Username ---------------------------------------------------------->
<tr>
<td>Username</td>
<td><g:textField type="text" name="username" maxlength="30" required="required" placeholder="username"  value="${user?.username}" />
(mandatory field)
</td>
</tr>
 
<!----- Password ---------------------------------------------------------->
<tr>
<td>Password</td>
<td><g:passwordField type="password" name="password" required="required" placeholder="password"  value="${user?.password}"/>
    (mandatory field)
</td>
</tr>

    <!----- Confirm Password ---------------------------------------------------------->
    <tr>
        <td>Conform Password</td>
        <td><g:passwordField type="password" name="conformpassword" required="required" placeholder="re-enter password"  value="${user?.conformpassword}"/>
        (mandatory field)
        </td>
    </tr>

 
<!----- Submit and Reset ------------------------------------------------->
<tr>
<td colspan="2" align="center">
<g:submitButton name="save" value="Save"/>
<input type="reset" value="Reset">
</td>
</tr>
</table>
 
</g:form>
%{-- <script>
     $("#email").blur(function(){
         console.log("we are inside");
         $.ajax({
             url: "<g:createLink controller='user' action='checkEmail'/>",
             data:{
                 "email":$("#email").val()
             },
             method : "post",
             success: function(result){
                 console.log("Fine" + result);
                 console.log(result.length)
                 for (var i=0;i<result.length;i++)
                 {
                        if($("#email").val() == result[i]){
                            alert("Alredy in use");}
                 }

             }
            /* error: function(err){
                 console.log(err);
                 alert("some erro");

             }*/
         });
     });

 </script>--}%

 <script>
     $("#email").blur(function(){
         console.log("we are inside");
         $.ajax({
             data:{
                 "email":$("#email").val()
             },
             url: "<g:createLink controller='user' action='checkEmail' params="email"/>",
             method : "post",
             success: function(result){
                alert(result)
             }
         });
     });

 </script>

</body>
</html>
