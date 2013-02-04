/**
 * Generic $resource error handler used by all controllers.
 */
function errorHandler($scope, $location, $routeParams, Flash, response) {
    switch (response.status) {
        case 404: // resource not found - return to the list and display message returned by the controller
            Flash.error(response.data.message);
            $location.path($routeParams.domain+'/list');
            break;
        case 409: // optimistic locking failure - display error message on the page
            $scope.message = {level: 'error', text: response.data.message};
            break;
        case 422: // validation error - display errors alongside form fields
            $scope.errors = response.data.errors;
            break;
        default: // TODO: general error handling
    }
}

function ListCtrl($scope, $routeParams, $location, Grails, Flash) {

    Grails.list($routeParams, function(list, headers) {
        $scope.list = list;
        $scope.total = parseInt(headers('X-Pagination-Total'));
        $scope.message = Flash.getMessage();
    }, errorHandler.curry($scope, $location, $routeParams, Flash));

    $scope.show = function(item) {
        $location.path($routeParams.domain+'/show/' + item.id);
    };
}

function ShowCtrl($scope, $routeParams, $location, Grails, Flash) {
    $scope.message = Flash.getMessage();

    Grails.get($routeParams, function(item) {
        $scope.item = item;
    }, errorHandler.curry($scope, $location, $routeParams, Flash));

    $scope.delete = function(item) {
        item.$delete($routeParams, function(response) {
            Flash.success(response.message);
            $location.path($routeParams.domain+'/list');
        }, errorHandler.curry($scope, $location, $routeParams, Flash));
    };
}

function CreateCtrl($scope, $routeParams, $location, Grails, Flash) {
    $scope.item = new Grails;

    $scope.save = function(item) {
        item.$save($routeParams, function(response) {
            Flash.success(response.message);
            $location.path($routeParams.domain+'/show/' + response.id);
        }, errorHandler.curry($scope, $location, $routeParams, Flash));
    };
}

function EditCtrl($scope, $routeParams, $location, Grails, Flash) {
    Grails.get($routeParams, function(item) {
        $scope.item = item;
    }, errorHandler.curry($scope, $location, $routeParams, Flash));

    $scope.update = function(item) {
        item.$update($routeParams, function(response) {
            Flash.success(response.message);
            $location.path($routeParams.domain+'/show/' + response.id);
        }, errorHandler.curry($scope, $location, $routeParams, Flash));
    };

    $scope.delete = function(item) {
        item.$delete($routeParams, function(response) {
            Flash.success(response.message);
            $location.path($routeParams.domain+'/list');
        }, errorHandler.curry($scope, $location, $routeParams, Flash));
    };
}