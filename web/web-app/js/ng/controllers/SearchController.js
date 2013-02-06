function SearchController($scope, $route, $routeParams, $location, $resource) {

    $scope.$route = $route;
    $scope.$location = $location;
    $scope.$routeParams = $routeParams;

    $scope.checkDetails = function(artistId){
        $location.path($routeParams.domain + '/artist/' + artistId);
    };

    $scope.like = function(artistId){
        var Checker = $resource(CTX + '/userPreference/likeArtist',
            {id: artistId},
            {});
        Checker.save();
    };

    $scope.search = function() {
        if ($scope.complete !== undefined && $scope.complete != '') {
            var Artist = $resource(CTX + '/artists/complete', {},
                {complete: {method: 'GET', isArray: true, params: {'start': $scope.complete}}});
            $scope.artistList = Artist.complete();

            var Song = $resource(CTX + '/songs/complete', {},
                {complete: {method: 'GET', isArray: true, params: {'start': $scope.complete}}});
            $scope.songList = Song.complete();
        }
    };
}