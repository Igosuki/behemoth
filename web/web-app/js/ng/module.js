'use strict';

var behemothModule = angular.module('behemoth', ['ngResource', 'ui'], function ($routeProvider, $locationProvider) {

    $routeProvider.when('/', { templateUrl: 'ng-templates/home.html' });
    $routeProvider.when('/book', { templateUrl: 'ng-templates/book/list.html', controller: BookCtrl });
    $routeProvider.when('/book/create', { templateUrl: 'ng-templates/book/create.html', controller: BookCtrl });

    $routeProvider.otherwise({redirectTo: '/'});

    $locationProvider.html5Mode(false);
});
