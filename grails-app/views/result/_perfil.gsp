<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Find a doctor</title>

    <asset:link rel="icon" href="favicon-hospital-o.ico" type="image/x-ico" />
</head>
<body>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-bind="with: currentMedico">

    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h2 class="modal-title" ><strong data-bind="text: Nombre"></strong></h2>
            </div>
            <div class="modal-body">

                <div class="panel panel-default">
                    <div class="panel-heading" role="tab"><div class="row">
                        <div class="col-md-4" style="padding-left: 0">
                            <img data-bind="attr:{src: ImagenUrl}" alt="..." class="img-thumbnail">
                        </div>
                        <div class="col-md-8">
                            <address>
                                <strong data-bind="text: Direccion"></strong>
                                <br>
                                <br>
                                <div data-bind="text: Ciudad"></div>
                                <br>
                                <abbr title="Phone">P:</abbr><span data-bind="text: Telefono"></span>
                            </address>

                            <address>
                                <strong data-bind="text: PaginaWeb"></strong><br>
                                <a href="mailto:#" data-bind="text: Email"></a>
                            </address>
                        </div>
                    </div>
                    </div>
                </div>
                <div class="row">


                    <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true" style="margin-bottom: 0">
                        <sec:ifAnyGranted roles="ROLE_PATIENT">
                        <div class="panel panel-default" data-bind="visible: TurnosPorHora.length > 0 && HorasLaborales.length > 0">
                            <div class="panel-heading" role="tab" id="headingOne">
                                <h4 class="panel-title">
                                    <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
                                        <span class="fa fa-plus"></span>
                                        Turnos
                                    </a>
                                </h4>
                            </div>
                            <div id="collapseOne" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
                                <div class="panel-body panel-body-comentario">
                                    <g:render template="/result/turns" />
                                </div>
                            </div>
                        </div>
                        </sec:ifAnyGranted>
                        <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="headingTwo">
                                <h4 class="panel-title">
                                    <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                        <span class="fa fa-plus"></span>
                                        Comentarios
                                    </a>
                                </h4>
                            </div>

                            <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                                <div class="panel-body panel-body-comentario">
                                    <g:render template="/result/ccomments" />
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>


</div>


</body>
</html>