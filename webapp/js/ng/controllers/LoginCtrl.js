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
//        $http.post('j_spring_security_check').success(function(response) {
//            authService.loginConfirmed();
//        });
        authAjax();
    }

    function authAjax() {
        $('#loginMessage').val('Sending request ...');
        $('#loginMessage').show();

        var form = $("#loginForm");
        var params = $(form).serialize();
        new $.ajax('j_spring_security_check', {
            method: 'POST',
            data: params,
            dataType: 'json',
            success: function(data) {
                var json = data;
                if (json.success) {
                    //Element.hide('ajaxLogin');
//                    $('loginLink').update('Logged in as ' + json.username +
//                        ' (<%=link(controller: 'logout') { 'Logout' }%>)');
                }
                else if (json.error) {
                    $('#loginMessage').val("<span class='errorMessage'>" +
                        json.error + '</error>');
                }
                else {
                    $('#loginMessage').val(responseText);
                }
            },
            error : function(jqXHR, textStatus, errorThrown) {
                $("#loginMessage").val(errorThrown);
            }
        });
    }
}

