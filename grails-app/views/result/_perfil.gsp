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
                                <strong>Twitter, Inc.</strong><br>
                                1355 Market Street, Suite 900<br>
                                San Francisco, CA 94103<br>
                                <abbr title="Phone">P:</abbr> (123) 456-7890
                            </address>

                            <address>
                                <strong>Full Name</strong><br>
                                <a href="mailto:#">first.last@example.com</a>
                            </address>
                        </div>
                    </div>
                    </div>
                </div>
                <div class="row">


                    <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true" style="margin-bottom: 0">
                        <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="headingOne">
                                <h4 class="panel-title">
                                    <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
                                        <span class="fa fa-plus"></span>
                                        Turnos
                                    </a>
                                </h4>
                            </div>
                            <div id="collapseOne" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
                                <div class="panel-body">

                                    <div style="overflow:hidden;">

                                        <div class="form-inline">
                                            <div class="form-group">
                                                <label for="datepicker">Dia</label>
                                                <input type="text" class="form-control input-sm" id="datepicker">
                                            </div>
                                            <div class="form-group">
                                                <label for="exampleInputEmail2">Turno</label>
                                                <input type="email" class="form-control input-sm" id="exampleInputEmail2">
                                            </div>
                                            <div class="form-group">
                                                <button type="submit" class="btn btn-default">Aceptar</button>
                                            </div>
                                        </div>


                                    </div>

                                </div>
                            </div>
                        </div>
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
                                    <g:render template="/result/comentarios" />
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