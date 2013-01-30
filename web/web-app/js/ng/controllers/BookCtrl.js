function BookCtrl($scope, $route, $routeParams, $location, Book) {

    $scope.$route = $route;
    $scope.$location = $location;
    $scope.$routeParams = $routeParams;

    $scope.save = function (item) {
        new Book(item).$save(function(savedObject, reponseHttpHeader) {
            $location.path('/books');
        });
    };
}