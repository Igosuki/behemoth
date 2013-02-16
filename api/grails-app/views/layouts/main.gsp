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
    <script type="text/javascript"
        src="http://maps.googleapis.com/maps/api/js?${config?.googlemaps?.apikey}&sensor=false">
    </script>
    <g:layoutHead/>

    <script type="text/javascript">
        var CTX = '${request.contextPath}';
    </script>

    <r:require module="application"/>
    <r:require module="angular-ui" />
    <r:require module="angular-resources" />
    <r:require module="angular_fr" />
    <r:require module="angular_en" />

    <r:layoutResources/>
</head>

<body ng-controller="RootCtrl" data-common-template-url="ng-templates">

<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">

            <a class="brand" ng-click="$location.path('/home')">
                <span class="simran">Behemoth
                <r:img uri="/images/pentagram-16px-neg.png"/>
                Records</span>
            </a>

            <ul class="nav">
                <li ng-class="{active: $location.path() == '/'}">
                    <a ng-click="$location.path('/home')">Home</a>
                </li>
                <li ng-class="{active: $location.path().indexOf('/search') == 0}">
                    <a ng-click="$location.path('/search')">Rechercher</a>
                </li>

                <li ng-class="{active: $location.path().indexOf('/profile') == 0}">
                    <a ng-click="$location.path('/profile')">Profile</a>
                </li>
                <li ng-class="{active: $location.path().indexOf('/map') == 0}">
                    <a ng-click="$location.path('/map')">Map </a>
                </li>
                <li>
                    <a href="logout">Logout</a>
                </li>
                <li style="color: #999999;text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.25);padding: 10px 15px 10px;text-align: right">
                    ||&nbsp;&nbsp;&nbsp;&nbsp;Logged in as : <sec:loggedInUserInfo field="username"/>
                </li>
            </ul>

            <div class="navbar-form pull-right">


            </div>
            %{--<form >--}%
                %{--<input class="span2" type="text" placeholder="Email" ng-model="username"/>--}%
                %{--<input class="span2" type="password" placeholder="Password" ng-model="password">--}%
                %{--<button type="submit" class="btn" ng-click="doLogin(username, password)">Sign in</button>--}%
            %{--</form>--}%

        </div>
    </div>
</div>


<div class="mainview">
    <div class="container ng-view"></div>
</div>


<footer>
    <p class="simran">Behemoth Team | xke 2013.02</p>
</footer>
<r:layoutResources/>
</body>
</html>
