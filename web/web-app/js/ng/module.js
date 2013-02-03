'use strict';

var behemothModule = angular.module('behemoth', ['ngResource', 'ui'], function ($routeProvider, $locationProvider) {

    $routeProvider.when('/', { templateUrl: 'ng-templates/home.html' });
    $routeProvider.when('/books', { templateUrl: 'ng-templates/books/list.html', controller: BookCtrl });
    $routeProvider.when('/books/create', { templateUrl: 'ng-templates/books/create.html', controller: BookCtrl });

    $routeProvider.otherwise({redirectTo: '/'});

    $locationProvider.html5Mode(false);
});
