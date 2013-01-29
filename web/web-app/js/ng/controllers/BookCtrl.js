function BookCtrl($rootScope, $scope, $route, $routeParams, $location) {

    $scope.$route = $route;
    $scope.$location = $location;
    $scope.$routeParams = $routeParams;

    $scope.save = function(item) {
      console.log('saving item');
    };
}