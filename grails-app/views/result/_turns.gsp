<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Find a doctor</title>

    <asset:link rel="icon" href="favicon-hospital-o.ico" type="image/x-ico" />
</head>
<body>
<div style="overflow:hidden;">
    <sec:ifLoggedIn>
        <div class="row" style="margin-right: 15px; margin-top: 15px">
            <div class="row" style="margin-bottom: 15px">
                <div class="form-inline">
                    <div class="form-group col-md-5" style="padding: 0">
                        <div class="col-md-3">
                            <label for="datepicker">Dia</label>
                        </div>
                        <div class="input-group col-md-8">
                            <input type="text" class="form-control" id="datepicker" data-bind="value: Fecha">
                            <span class="input-group-addon">
                                <span class="fa fa-calendar"></span>
                            </span>
                        </div>
                    </div>
                    <div class="form-group col-md-4" style="padding: 0">
                        <div class="col-md-5">
                            <label>Turno</label>
                        </div>
                        <div class="input-group clockpicker col-md-7">
                            <input type="text" class="form-control" data-bind="value: Hora">
                            <span class="input-group-addon">
                                <span class="fa fa-clock-o"></span>
                            </span>
                        </div>
                    </div>
                    <div class="form-group col-md-2">
                        <button type="submit" class="btn btn-default" data-bind="click: crearTurno">Aceptar</button>
                    </div>
                </div>
            </div>
            <div data-bind="foreach: Turnos">
                <div class="row">
                    <div class="alert" data-bind="css: { 'alert-success': Estado == 'Aceptado', 'alert-info': Estado == 'Pendiente', 'alert-danger': Estado == 'Cancelado' }" role="alert">

                            <strong>Posee un turno para el dia </strong><strong data-bind="text: FechaHora"></strong><small>&nbsp;&nbsp;En estado&nbsp;</small><small data-bind="text: Estado"></small>

                    </div>
                </div>

            </div>

        </div>
    </sec:ifLoggedIn>
    <sec:ifNotLoggedIn>
        <div class="row" style="margin-right: 15px; margin-top: 15px;">
            <div class="alert alert-warning" role="alert">Debe estar logueado para obtener un turno</div>
        </div>

    </sec:ifNotLoggedIn>

</div>
</body>
</html>