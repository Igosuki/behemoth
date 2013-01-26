<!doctype html>
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]>    <html class="no-js lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]>    <html class="no-js lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang="en"> <!--<![endif]-->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><g:layoutTitle default="Grails"/></title>
    <meta name="viewport" content="width=device-width">
    <link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
    <link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
    <link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">
    <g:layoutHead/>
    <r:layoutResources />
</head>
<body data-ng-app="${pageProperty(name: 'body.data-ng-app')}"
      data-base-url="${pageProperty(name: 'body.data-base-url', default: createLink(action: 'index').replaceAll(/index$/, ''))}"
      data-template-url="${pageProperty(name: 'body.data-template-url', default: createLink(uri: "/ng-templates/$domainClass"))}"
      data-common-template-url="${pageProperty(name: 'body.data-common-template-url', default: createLink(uri: '/ng-templates'))}">
<div id="grailsLogo" role="banner"><a href="http://grails.org"><img src="${resource(dir: 'images', file: 'grails_logo.png')}" alt="Grails"/></a></div>
<g:layoutBody/>
<div class="footer" role="contentinfo"></div>
<r:layoutResources />
</body>
</html>