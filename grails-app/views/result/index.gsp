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
                var resultado = '${resultado}';
                </g:applyCodec>
            </script>

            <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBeU5QR5N0qOphQkp816JUDOqLpmxIMqSU&callback=initMap" type="text/javascript"></script>

            <div class="col-md-3 colorGrisFondo columnasPrincipales" style="padding-top: 15px;">
                <div class="row columnaResultado">
                    <g:render template="/result/resultados" />
                </div>
            </div>
            <div class="col-md-9 columnasPrincipales" style="padding-left:0"  id="map">
            </div>
            <g:render template="/result/perfil" />
</body>
</html>