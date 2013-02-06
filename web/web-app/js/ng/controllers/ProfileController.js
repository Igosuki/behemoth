function ProfileController($scope, $route, $routeParams, $location, $resource) {

    $scope.$route = $route;
    $scope.$location = $location;
    $scope.$routeParams = $routeParams;

    $scope.checkDetails = function(artistId){
        $location.path($routeParams.domain + '/artist/' + artistId);
    };

    $scope.artistList = [{name:'artiste1'}, {name:'artiste2'}, {name:'artiste3'}];
}