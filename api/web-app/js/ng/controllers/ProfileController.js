function ProfileController($scope, $route, $routeParams, $location, $resource) {

    $scope.$route = $route;
    $scope.$location = $location;
    $scope.$routeParams = $routeParams;

    $scope.checkDetails = function(artistId){
        $location.path($routeParams.domain + '/artist/' + artistId);
    };



    var Artist = $resource(CTX + '/userPreference/myLikes', {},
        {complete: {method: 'GET', isArray: true}} );

    $scope.artistList = Artist.complete();
}