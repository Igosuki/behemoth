function SearchController($scope, $route, $routeParams, $location, $resource) {

    $scope.$route = $route;
    $scope.$location = $location;
    $scope.$routeParams = $routeParams;

    $scope.checkDetails = function(artistId){
        $location.path($routeParams.domain + '/artist/' + artistId);
    };

    $scope.search = function() {
        if ($scope.complete !== undefined && $scope.complete != '') {
            var Artist = $resource('/web/artists/complete', {},
                {complete: {method: 'GET', isArray: true, params: {'start': $scope.complete}}});
            $scope.artistList = Artist.complete();

            var Song = $resource('/web/songs/complete', {},
                {complete: {method: 'GET', isArray: true, params: {'start': $scope.complete}}});
            $scope.songList = Song.complete();
        }
    };
}