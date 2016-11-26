<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Find a doctor</title>

    <asset:link rel="icon" href="favicon-hospital-o.ico" type="image/x-ico" />
</head>
<body>
<div style="overflow-y: scroll; height: 300px">
    <!-- Comentarios-->
    <div data-bind="foreach: Comentarios">
        <div class="row cuerpo-comentario">
            <div class="col-md-2 img-comentario">
                <img data-bind="attr:{src: ImagenUrl}" alt="..."  class="img-thumbnail">
            </div>
            <div class="col-md-10">
                <div class="row row-comentario">
                    <strong data-bind="text: Nombre"></strong>&nbsp;&nbsp;<small data-bind="text: Fecha">Secondary text</small>
                </div>
                <div class="row" data-bind="text: Texto">
                </div>
            </div>
        </div>
        <hr>
    </div>

    <sec:ifAnyGranted roles="ROLE_PATIENT">
        <!-- Nuevo comenario-->
        <div class="row cuerpo-comentario" style="margin-right: 15px">
            <div class="row">
                <p><strong>Dejar comentario</strong></p>
            </div>
            <div class="row">
                <textarea placeholder="Comentario:"  class="form-control boxsizingBorder" rows="3" data-bind="value: MensajeNuevo"></textarea>
                <button type="button" class="btn btn-primary" data-bind="click: agregarComentario">Publicar comentario</button>
            </div>
        </div>
    </sec:ifAnyGranted>
    <sec:ifNotLoggedIn>
        <div class="row" style="margin-right: 15px; margin-top: 15px;">
            <div class="alert alert-warning" role="alert">Debe estar logueado para escribir nuevos comentarios</div>
        </div>

    </sec:ifNotLoggedIn>



</div>
</body>
</html>