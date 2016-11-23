<%--
  Created by IntelliJ IDEA.
  User: ravi
  Date: 17/11/16
  Time: 3:16 PM
--%>
<html>
<head>
    <title>Student Registration Form</title>
    <style type="text/css">
    h3{font-family: Calibri; font-size: 22pt; font-style: normal; font-weight: bold; color:SlateBlue;
        text-align: center; text-decoration: underline }
    table{font-family: Calibri; color:white; font-size: 11pt; font-style: normal;
        background-color: SlateBlue; border-collapse: collapse; border: 2px solid navy}
    table.inner{border: 0px}
    </style>
</head>

<body>
<h3><g:message code="springSecurity.login.header"/></h3>


<g:if test='${flash.message}'>
    <div class='login_message'>${flash.message}</div>
</g:if>

<g:form action="register">

    <table align="center" cellpadding = "10">

        <!----- User Name ---------------------------------------------------------->
        <tr>
            <td><label for='username'><g:message code="springSecurity.login.username.label"/>:</label></td>
            <td><input type='text' class='text_' name='j_username' id='username' placeholder="enter username or emailid"/>
            </td>
        </tr>

        <!----- Password ---------------------------------------------------------->
        <tr>
            <td><label for='password'><g:message code="springSecurity.login.password.label"/>:</label></td>
            <td><input type='password' class='text_' name='j_password' id='password' placeholder="enter password" />
            </td>
        </tr>


        <!----- Checkbox ---------------------------------------------------------->
        <tr>
            <td><input type='checkbox'  name='${rememberMeParameter}' id='remember_me' <g:if test='${hasCookie}'>checked='checked'</g:if>/>
                <label for='remember_me'><g:message code="springSecurity.login.remember.me.label"/></label>
            </td>

        </tr>



        <!----- Submit and Reset ------------------------------------------------->
        <tr>
            <td colspan="2" align="center">
                <input type='submit' id="submit" value='${message(code: "springSecurity.login.button")}'/>
            </td>
        </tr>
    </table>


    <p>Not a member?<a href="<g:createLink controller="user" action="register"/> ">SignUp</a></p><br><br>
    <p>Forget Password?<a href="<g:createLink controller="user" action="forgetPassword"/> ">Reset Password</a></p>
    <p>Unlock Your account, if locked?<a href="<g:createLink controller="user" action="unlockaccount"/> ">Unlock Account</a></p>
</g:form>
</body>
</html>
