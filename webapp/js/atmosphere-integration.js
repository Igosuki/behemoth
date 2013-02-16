$(document).ready(function () {
    // jquery.atmosphere.response
    function callback(response) {
        if (response.status == 200) {
            var data = response.responseBody;
            if (data.length > 0) {
                try {
                    i ++;
                    var msgObj = jQuery.parseJSON(data);
                    var remove = i
                    remove -= 5
                    $("#allUsersEvent").prepend('<p id="event'+i+'" style="display:none">' + msgObj.user + ' ' + msgObj.action + '</p>')
                    $("#event"+remove).fadeOut("slow");
                    $("#event"+i).fadeIn("slow");
                    $("#event"+remove).remove();

                    $.atmosphere.subscribe(location, callback, $.atmosphere.request = {transport: 'websocket', fallbackTransport: 'long-polling'});

                } catch (e) {
                    alert("exception : " + e);
                    // Atmosphere sends commented out data to WebKit based browsers
                }
            }
        }
    }
    var i=0
    var location = CTX + '/atmosphere/allusers/actions';
    $.atmosphere.subscribe(location, callback, $.atmosphere.request = {transport: 'websocket', fallbackTransport: 'long-polling'});
});