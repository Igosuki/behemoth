<%@ page import="org.springframework.web.context.request.RequestContextHolder" %>
<%@ page import="grails.plugins.springsecurity.SpringSecurityService" %>
<% def springSecurityService %>

<!DOCTYPE html>
<html ng-app="scaffolding">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

    <title><g:layoutTitle default="Let Geek Play - Behemoth Team - XKE.2013.02"/></title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/png" href="${r.resource(uri:'/images/pentagram-16px.png')}" />
    <g:layoutHead/>

    <script type="text/javascript">
        var CTX = '${request.contextPath}';
    </script>

    <r:require module="application"/>

    <r:layoutResources/>
</head>

<body>

<g:layoutBody />

<footer>
    <p class="simran">Behemoth Team | xke 2013.02</p>
</footer>
<r:layoutResources/>
</body>
</html>
