

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
  <title></title>
    <r:script >
        $(document).ready(function() {
            // jquery.atmosphere.response
            function callback(response) {
               if (response.status == 200) {
                    var data = response.responseBody;
                   alert(data)
                   if (data.length > 0) {
                        try {
                            var msgObj = jQuery.parseJSON(data);
                            alert(msgObj)
                        } catch (e) {
                            // Atmosphere sends commented out data to WebKit based browsers
                        }
                    }
                }
            }

            var location = 'http://localhost:8080/web/atmosphere/allusers/actions';
            $.atmosphere.subscribe(location, callback, $.atmosphere.request = {transport: 'websocket', fallbackTransport: 'long-polling'});
        });
    </r:script>
</head>
<body>

</body>
</html>