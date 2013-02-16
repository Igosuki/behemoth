<html>
<head>
    <meta name='layout' content='login'/>
    <title><g:message code='spring.security.ui.register.title'/></title>
</head>

<body>

<p/>

<g:form action='register' name='registerForm'>

    <g:if test='${emailSent}'>
        <br/>
        <g:message code='spring.security.ui.register.sent'/>
    </g:if>
    <g:else>

        <br/>

        <table>
            <tbody>

            <app:textFieldRow name='username' labelCode='user.username.label' bean="${command}"
                               size='40' labelCodeDefault='Username' value="${command.username}"/>

            <app:textFieldRow name='email' bean="${command}" value="${command.email}"
                               size='40' labelCode='user.email.label' labelCodeDefault='E-mail'/>

            <app:textFieldRow name='town' bean="${command}" value="${command.email}"
                              size='40' labelCode='user.town.label' labelCodeDefault='City'/>

            <app:passwordFieldRow name='password' labelCode='user.password.label' bean="${command}"
                                   size='40' labelCodeDefault='Password' value="${command.password}"/>

            <app:passwordFieldRow name='password2' labelCode='user.password2.label' bean="${command}"
                                   size='40' labelCodeDefault='Password (again)' value="${command.password2}"/>

            </tbody>
        </table>

        <g:submitButton name='create' form='registerForm' messageCode='spring.security.ui.register.submit'/>

    </g:else>

</g:form>

<script>
    $(document).ready(function() {
        $('#username').focus();
    });
</script>

</body>
</html>
