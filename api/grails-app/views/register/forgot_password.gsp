<html>

<head>
    <title><g:message code='spring.security.ui.forgotPassword.title'/></title>
    <meta name='layout' content='register'/>
</head>

<body>

<p/>

<g:form action='forgotPassword' name="forgotPasswordForm" autocomplete='off'>

    <g:if test='${emailSent}'>
        <br/>
        <g:message code='spring.security.ui.forgotPassword.sent'/>
    </g:if>

    <g:else>

        <br/>
        <h4><g:message code='spring.security.ui.forgotPassword.description'/></h4>

        <table>
            <tr>
                <td><label for="username"><g:message code='spring.security.ui.forgotPassword.username'/></label></td>
                <td><g:textField name="username" size="25" /></td>
            </tr>
        </table>

        <g:submitButton name='reset' form='forgotPasswordForm' messageCode='spring.security.ui.forgotPassword.submit'/>

    </g:else>

</g:form>

<script>
    $(document).ready(function() {
        $('#username').focus();
    });
</script>

</body>
</html>
