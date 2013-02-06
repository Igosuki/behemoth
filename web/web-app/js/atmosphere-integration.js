$(document).ready(function () {
    // jquery.atmosphere.response
    function callback(response) {
        if (response.status == 200) {
            var data = response.responseBody;
            if (data.length > 0) {
                try {
                    var msgObj = jQuery.parseJSON(data);
                    alert(msgObj.user + ' ' + msgObj.action)
                    $("#allUsersEvent").append('<p>' + msgObj.user + ' ' + msgObj.action + '</p>')


                    $.atmosphere.subscribe(location, callback, $.atmosphere.request = {transport: 'websocket', fallbackTransport: 'long-polling'});

                } catch (e) {
                    alert("exception : " + e);
                    // Atmosphere sends commented out data to WebKit based browsers
                }
            }
        }
    }

    var location = CTX + '/atmosphere/allusers/actions';
    $.atmosphere.subscribe(location, callback, $.atmosphere.request = {transport: 'websocket', fallbackTransport: 'long-polling'});
});