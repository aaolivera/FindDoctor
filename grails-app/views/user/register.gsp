<!doctype html>
<html>
    <head>
        <meta name="layout" content="main"/>
        <title>Find a doctor</title>
        <asset:link rel="icon" href="favicon-hospital-o.ico" type="image/x-ico" />
    </head>
    <body>
        <asset:javascript src="find.index.js"/>
        <script type="text/javascript">
            <g:applyCodec encodeAs="none">
            var filterTree = '${filterTree}';
            </g:applyCodec>
        </script>

        <div class="svg text-center colorAzul" role="presentation" style="padding-top: 10px">
        <i class="fa fa-hospital-o fa-5x" aria-hidden="true"></i>
        </div>
        <div id="content" role="main">
            <section class="row colset-2-its">
                <g:form name="myForm" controller="result" action="index">
                    <div class="col-md-4  col-md-offset-4 text-center colorAzul">
                        <div class="form-group">
                            <h2><strong>Find a doctor</strong></h2>
                        </div>
                    </div>
                    <div class="col-md-4  col-md-offset-4" data-bind="foreach: filterTree">

                        <button type="button" class="btn btn-primary btn-lg btn-block" data-bind="text: descripcion,click: cargarHijos"></button>

                    </div>
                </g:form>
            </section>
        </div>
        </br>
    </body>
</html>