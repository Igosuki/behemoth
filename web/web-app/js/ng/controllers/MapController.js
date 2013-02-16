function MapController($scope, $route, $routeParams, $location, Grails, Flash, $resource) {
    $scope.$route = $route;
    $scope.$location = $location;
    $scope.$routeParams = $routeParams;

    $scope.mapClick = function($event, $window) {
        $window.alert("Boo");
    }

    $scope.myMarkers = [];

    $scope.eventsByLocation = [];

    $scope.locationSearchTerm = "Paris";

    $scope.searchLocation = function() {
        var Events = $resource(CTX+'/events/searchByLocation', {},
            {complete: {method: 'GET', isArray: true, params: {'location': $scope.locationSearchTerm}}});
        $scope.eventsByLocation = Events.complete();
    }


    $scope.mapOptions = {
        center: new google.maps.LatLng(35.784, -78.670),
        zoom: 15,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };

    $scope.addMarker = function($event) {
        $scope.myMarkers.push(new google.maps.Marker({
            map: $scope.myMap,
            position: $event.latLng
        }));
    };

    $scope.setZoomMessage = function(zoom) {
        $scope.zoomMessage = 'You just zoomed to '+zoom+'!';
        console.log(zoom,'zoomed')
    };

    $scope.openMarkerInfo = function(marker) {
        $scope.currentMarker = marker;
        $scope.currentMarkerLat = marker.getPosition().lat();
        $scope.currentMarkerLng = marker.getPosition().lng();
        $scope.myInfoWindow.open($scope.myMap, marker);
    };

    $scope.setMarkerPosition = function(marker, lat, lng) {
        marker.setPosition(new google.maps.LatLng(lat, lng));
    };
}