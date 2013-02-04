function MapController($scope, $route, $routeParams, $location, Grails, Flash) {
    $scope.$route = $route;
    $scope.$location = $location;
    $scope.$routeParams = $routeParams;

    $scope.mapClick = function($event, $window) {
        $window.alert("Boo");
    }
}