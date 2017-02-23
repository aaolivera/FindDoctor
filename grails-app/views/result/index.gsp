<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Find a doctor</title>

    <asset:link rel="icon" href="favicon-hospital-o.ico" type="image/x-ico" />
</head>
<body>
            <asset:javascript src="result.index.js"/>
            <script type="text/javascript">
                <g:applyCodec encodeAs="none">
                    var resultado = '${result}';
                    var currentUsuario = '${currentUser}';
                </g:applyCodec>
            </script>

            <div class="col-md-3 colorGrisFondo columnasPrincipales" style="padding-top: 15px;">
                <div class="row columnaResultado">
                    <g:render template="/result/results" />
                </div>
            </div>
            <div class="col-md-9 columnasPrincipales" style="padding-left:0"  id="map">
            </div>
            <g:render template="/result/perfil" />
<script>
    function initMap() {
        var buenosAires = {lat: -34.603722, lng: -58.381592}
        map = new google.maps.Map(document.getElementById('map'), {
        center: buenosAires,
        zoom: 13
    });

        var infoWindow = new google.maps.InfoWindow({map: map});

        // Try HTML5 geolocation.
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function(position) {
              var pos = {
                lat: position.coords.latitude,
                lng: position.coords.longitude
              };

              map.setCenter(pos);
              setCurrentPosMarker(pos, 'Usted');

            }, function() {
              handleLocationError(true, infoWindow, map.getCenter());
            });
            } else {
            // Browser doesn't support Geolocation
            handleLocationError(false, infoWindow, map.getCenter());
            }

        }
        function handleLocationError(browserHasGeolocation, infoWindow, pos) {
          infoWindow.setPosition(pos);
          infoWindow.setContent(browserHasGeolocation ?
                                'Error: The Geolocation service failed.' :
                                'Error: Your browser doesn\'t support geolocation.');
        }

    </script>

    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBeU5QR5N0qOphQkp816JUDOqLpmxIMqSU&callback=initMap">
   </script>
</script>
</body>
</html>