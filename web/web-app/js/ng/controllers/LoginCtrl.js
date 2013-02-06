function LoginController($scope, $http, $cookies, authService) {
    var behemothCookie = $cookies.behemoth;
    $cookies.behemoth = 'behemoth';
    $scope.submit = function() {
        $http.post('web/j_spring_security_logout').success(function() {
            authService.loginConfirmed();
        });
    }
}