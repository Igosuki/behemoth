function LoginController($scope, $http, $cookies, $cookieStore, authService) {
//    var behemothCookie = $cookies.grails_remember_me;
//    if(behemothCookie && behemothCookie.grailsRocks == 'true') {
//        $scope.item.item._spring_security_remember_me = true;
//    } else {
//        $scope.item.item._spring_security_remember_me = false;
//    }

//    $cookies.behemoth = 'behemoth';
//    $scope.item._spring_security_remember_me = true;
    $scope.errors = {};
    $scope.submit = function() {
        $http.post('web/j_spring_security_check').success(function(response) {
            authService.loginConfirmed();
        });
    }
}

