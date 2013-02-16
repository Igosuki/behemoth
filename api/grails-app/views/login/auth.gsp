<html>
<head>
    <meta name='layout' content='login'/>
    <title><g:message code="springSecurity.login.title"/></title>
</head>

<body>

<div class="span6 offset3">
    <form action='${postUrl}' method='POST' id='loginForm' class='cssform' autocomplete='off'>
        <fieldset>
            <input type="text" name='j_username' id='username'
                   placeholder="<g:message code="springSecurity.login.username.label"/>">

            <input type="password" name='j_password' id='password'
                   placeholder="<g:message code="springSecurity.login.password.label"/>">

            <label class="checkbox">
                <input type="checkbox" name='${rememberMeParameter}' id='remember_me'
                       <g:if test='${hasCookie}'>checked='checked'</g:if>> Se souvenir de moi
            </label>

            <div class="center">
                <button class="btn btn-primary" type="submit" class="btn">Se connecter</button>
                &nbsp;&nbsp;<g:link controller="register" action="index">
                    <button class="btn btn-primary" type="submit" class="btn">S'enregistrer</button>
                </g:link>
            </div>
        </fieldset>
    </form>

</div>


<script type='text/javascript'>
    <!--
    (function () {
        document.forms['loginForm'].elements['j_username'].focus();
    })();
    // -->
</script>
</body>
</html>
