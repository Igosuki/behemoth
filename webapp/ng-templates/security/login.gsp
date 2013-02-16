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

    <r:require module="login"/>

    <r:layoutResources/>
</head>

<body>

<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">

            <a class="brand" ng-click="$location.path('/home')">
                <span class="simran">Behemoth
                <r:img uri="/images/pentagram-16px-neg.png"/>
                Records</span>
            </a>

            <div class="navbar-form pull-right">

            </div>

        </div>
    </div>
</div>


<div class="mainview">
    <div class="container">

    <div class="hero-unit home-big">
        <div class="center">
            <h1 class="simran">You Are What You Listen</h1>

            <p>
                Rapprochez vous de vos artistes
            </p>
        </div>
    </div>

    <g:layoutBody />
    </div>
</div>



<footer>
    <p class="simran">Behemoth Team | xke 2013.02</p>
</footer>
<r:layoutResources/>
</body>
</html>

