function RootCtrl($rootScope, $scope, $route, $routeParams, $location) {

    $scope.$route = $route;
    $scope.$location = $location;
    $scope.$routeParams = $routeParams;

    $scope.publicContent = [];
    $scope.restrictedContent = [];

//    $scope.publicAction = function() {
//        $http.post('data/public', $scope.publicData).success(function(response) {
//            $scope.publicContent.push(response);
//        });
//    }
//
//    $scope.restrictedAction = function() {
//        $http.post('data/protected', $scope.restrictedData).success(function(response) {
//            // this piece of code will not be executed until user is authenticated
//            $scope.restrictedContent.push(response);
//        });
//    }

    $scope.logout = function() {
        $http({method: 'POST', url: 'http://localhost:8080/web/j_spring_security_logout'}).success(function() {
            $scope.restrictedContent = [];
        });
    }
}