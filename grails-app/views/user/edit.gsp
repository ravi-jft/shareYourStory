<html>
<head>
    <title>Student Registration Form</title>
    <meta name="layout" content="myLayout">
    <style type="text/css">
    h3{font-family: Calibri; font-size: 22pt; font-style: normal; font-weight: bold; color:SlateBlue;
        text-align: center; text-decoration: underline }
    table{font-family: Calibri; color:white; font-size: 11pt; font-style: normal;
        text-align:; background-color: SlateBlue; border-collapse: collapse; border: 2px solid navy}
    table.inner{border: 0px}
    </style>
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
<h3>Edit Details</h3>
<<g:form action="updateInfo">

    <table align="center" cellpadding = "10">

        <!----- First Name ---------------------------------------------------------->
        <tr>
            <td>FIRST NAME</td>
            <td><g:textField type="text" name="firstname" maxlength="20"  placeholder="${user.firstname}"/>
            (max 30 characters a-z and A-Z and mandatory fields)
            </td>
        </tr>

        <!----- Last Name ---------------------------------------------------------->
        <tr>
            <td>LAST NAME</td>
            <td><g:textField type="text" name="lastname" maxlength="20" placeholder="${user.lastname}"/>
            (max 30 characters a-z and A-Z)
            </td>
        </tr>
        <!----- Mobile Number ---------------------------------------------------------->
        <tr>
            <td>MOBILE NUMBER</td>
            <td>
                <g:textField type="text" name="contact" maxlength="10" placeholder="${user.contact}"/>
                (10 digit number)
            </td>
        </tr>


        <!----- Address ---------------------------------------------------------->
        <tr>
            <td>ADDRESS <br /><br /><br /></td>
            <td><g:textField type="text" name="address" rows="4" cols="30" placeholder="${user.address}"/></td>
        </tr>


        <!----- Submit and Reset ------------------------------------------------->
        <tr>
            <td colspan="2" align="center">
                <g:submitButton name="update" value="Update"/>
                <input type="reset" value="Reset">
            </td>
        </tr>
    </table>

</g:form>

</body>
</html>
