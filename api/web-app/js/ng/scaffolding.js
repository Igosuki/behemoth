/**
 * The main scaffolding module.
 */
var scaffoldingModule = angular.module('scaffolding', ['grailsService', 'flashService', 'ui', 'ngCookies', 'http-auth-interceptor']);

scaffoldingModule.value('ui.config', {});

/**
 * Route definitions connecting URL fragments to views and controllers.
 */
scaffoldingModule.config([
    '$routeProvider',
    function($routeProvider) {
        var baseUrl = CTX + "/ng-templates/";
        function list(routePathParams) {
            return baseUrl + routePathParams.domain+"/list.html";
        }
        function show(routePathParams) {
            return baseUrl + routePathParams.domain+"/show.html";
        }
        function edit(routePathParams) {
            return baseUrl + routePathParams.domain+"/edit.html";
        }
        function create(routePathParams) {
            return baseUrl + routePathParams.domain+"/create.html";
        }

        $routeProvider.
            when('/map', { templateUrl: baseUrl + 'imap/active_map.html', controller: MapController}).
            when('/home', { templateUrl: baseUrl + '/home.html' }).
            when('/search', { templateUrl: baseUrl + '/search.html' }).
            when('/badges', { templateUrl: baseUrl + '/badges.html' }).
            when('/profile', { templateUrl: baseUrl + '/profile.html' }).
            when('/', {redirectTo: '/home'} ).
            when('/map', { templateUrl: baseUrl + 'imap/active_map.html', controller: MapController}).
            when('/login', { templateUrl: baseUrl + 'login.html', controller: LoginController}).
            otherwise({redirectTo: '/'});
        /*
            when('/author/secured', {templateUrl: baseUrl + 'author/list.html', controller: ListCtrl}).
            when('/:domain/create', {templateUrl: create, controller: CreateCtrl}).
            when('/:domain/edit/:id', {templateUrl: edit, controller: EditCtrl}).
            when('/:domain/list', {templateUrl: list, controller: ListCtrl}).
            when('/:domain/show/:id', {templateUrl: show, controller: ShowCtrl}).
            */

    }
]);

scaffoldingModule.directive('loginApp', function() {
    return {
        restrict: 'C',
        link: function(scope, elem, attrs) {
            //once Angular is started, remove class:
            elem.removeClass('waiting-for-angular');

            var login = elem.find('#login-holder');
            var main = elem.find('#main-content');

            login.hide();

            scope.$on('event:auth-loginRequired', function() {
                login.slideDown('slow', function() {
                    main.hide();
                });
            });
            scope.$on('event:auth-loginConfirmed', function() {
                main.show();
                login.slideUp();
            });
        }
    }
});

/**
 * A directive for including menu pills
 */
scaffoldingModule.directive('pills', function() {
    var baseUrl = $('body').data('common-template-url');
    return {
        restrict: 'A', // can only be used as an element
        scope: {
            text: '@text'
        },
        controller: function($scope, $routeParams, $location) {
            $scope.$domain = $routeParams.domain;
            $scope.$location = $location;
        },
        templateUrl: baseUrl + '/pills.html',
        replace: true
    }
});

/**
 * A directive for including menu pills
 */
scaffoldingModule.directive('modal', function($routeParams) {
    var baseUrl = $('body').data('common-template-url');
    return {
        restrict: 'A', // can only be used as an element
        controller: function($scope, $routeParams, $location) {
            $scope.$location = $location;
        },
        templateUrl: baseUrl + "/" + $routeParams.domain + '/modal.html',
        replace: true
    }
});

/**
 * A directive for including an alert message in the page.
 */
scaffoldingModule.directive('alert', function() {
	var baseUrl = $('body').data('common-template-url');
	return {
        restrict: 'E', // can only be used as an element
        transclude: false, // the element should not contain any content so there's no need to transclude
        scope: {
			level: '@level',
			text: '@text'
        },
        templateUrl: baseUrl + '/alert.html',
        replace: true
    }
});

/**
 * A directive for including a standard pagination block in the page.
 */
scaffoldingModule.directive('pagination', function() {
	var baseUrl = $('body').data('common-template-url');
	return {
        restrict: 'A', // can only be used as an attribute
        transclude: false, // the element should not contain any content so there's no need to transclude
        scope: {
            total: '=total' // inherit the total property from the controller scope
        },
        controller: function($scope, $routeParams) {
            $scope.max = parseInt($routeParams.max) || 10;
            $scope.offset = parseInt($routeParams.offset) || 0;
            $scope.currentPage = Math.ceil($scope.offset / $scope.max);
            $scope.$routeParams = $routeParams;
            $scope.pages = function() {
                var pages = [];
                for (var i = 0; i < Math.ceil($scope.total / $scope.max); i++)
                    pages.push(i);
                return pages;
            };

            $scope.lastPage = function() {
                return $scope.pages().slice(-1)[0];
            };
        },
        templateUrl: baseUrl + '/pagination.html',
        replace: false
    }
});

function toArray(element) {
    return Array.prototype.slice.call(element);
}

Function.prototype.curry = function() {
    if (arguments.length < 1) {
        return this; //nothing to curry with - return function
    }
    var __method = this;
    var args = toArray(arguments);
    return function() {
        return __method.apply(this, args.concat(toArray(arguments)));
    }
}


$.fn.serializeObject = function()
{
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};
