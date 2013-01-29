
<%@ page import="web.Book" %>
<!doctype html>
<html>
<head>
    <meta name="layout" content="ng-app">

    <g:set var="entityName" value="${message(code: 'book.label', default: 'Book')}"/>


</head>

<body data-ng-app="book" data-base-url="${createLink(uri: '/book/')}">

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><a class="list" href="#list"><g:message code="default.list.label" args="[entityName]"/></a></li>
        <li><a class="create" href="#create"><g:message code="default.new.label" args="[entityName]"/></a></li>
    </ul>
</div>

<div class="content" role="main" data-ng-view>
</div>

</body>
</html>
