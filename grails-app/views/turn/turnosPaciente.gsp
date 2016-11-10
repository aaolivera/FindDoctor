<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Find a doctor</title>

    <asset:link rel="icon" href="favicon-hospital-o.ico" type="image/x-ico" />
</head>
<body>
            <asset:javascript src="turn.index.js"/>
            <script type="text/javascript">
                <g:applyCodec encodeAs="none">
                    var turnos = '${turnos}';
                </g:applyCodec>
            </script>

            <div id="content" role="main">
                <section class="row colset-2-its">
                    <g:form name="myForm" controller="result" action="index">
                        <div class="col-md-4  col-md-offset-4 text-center colorAzul">
                            <div class="form-group">
                                <h2><strong>Turnos</strong></h2>
                            </div>
                        </div>
                        <div class="col-md-6  col-md-offset-3">
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Medico</th>
                                        <th>Fecha</th>
                                        <th>Estado</th>
                                    </tr>
                                </thead>
                                <tbody data-bind="foreach: turnos">
                                    <tr class="active"  data-bind="css: { 'success': Estado == 'Aceptado', 'info': Estado == 'Pendiente', 'danger': Estado == 'Cancelado' }">
                                        <th scope="row">1</th>
                                        <td data-bind="text: Medico"></td>
                                        <td data-bind="text: FechaHora"></td>
                                        <td data-bind="text: Estado"></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </g:form>
                </section>
            </div>
</body>
</html>