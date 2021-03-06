<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Grails"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <asset:stylesheet src="application.css"/>

    <g:layoutHead/>
</head>
<body>
    <asset:javascript src="jquery-2.2.0.min.js"/>
    <asset:javascript src="knockout-3.4.0.js"/>
    <asset:javascript src="bootstrap.js"/>
    <asset:javascript src="bootstrap-datepicker.js"/>
    <asset:javascript src="bootstrap-datepickeres.js"/>
    <asset:javascript src="clockpicker.js"/>
    <asset:javascript src="jquery.blockUI.js"/>
    <asset:javascript src="application.js"/>

    <div class="navbar navbar-default navbar-static-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/#">
                    <i class="fa grails-icon">
                        <i class="fa fa-hospital-o" aria-hidden="true"></i>
                    </i> Find a doctor
                </a>
            </div>
            <div class="navbar-collapse collapse" aria-expanded="false" style="height: 0.8px;">
                <ul class="nav navbar-nav navbar-right">
                    <sec:ifAnyGranted roles="ROLE_PATIENT">
                        <li>
                            <g:link controller='perfil' action="perfilPatient">Perfil</g:link>
                        </li>
                        <li>
                            <g:link controller='turn' action="turnsPatient">Turnos</g:link>
                        </li>
                    </sec:ifAnyGranted>
                    <sec:ifAnyGranted roles="ROLE_DOCTOR">
                        <li>
                            <g:link controller='perfil' action="perfilDoctor">Perfil</g:link>
                        </li>
                        <li>
                            <g:link controller='turn' action="turnsDoctor">Turnos</g:link>
                        </li>
                    </sec:ifAnyGranted>
                    <sec:ifLoggedIn>
                        <li>
                            <g:link controller='logout'>Salir</g:link>
                        </li>
                    </sec:ifLoggedIn>
                    <sec:ifNotLoggedIn>
                        <li>
                            <g:link controller='user' action="register">Registrate ahora!</g:link>
                        </li>
                       <li>
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#menu1" role="button" aria-haspopup="true" aria-expanded="false">
                                Ingresar
                                <b class="caret"></b>
                            </a>
                            <div class="dropdown-menu">
                                <form style="margin: 0px" class="loginform" accept-charset="UTF-8" action="/login/authenticate" method="post">
                                    <fieldset class='textbox' style="padding:10px; padding: 0;margin-bottom: 1em">
                                        <input style="margin-top: 8px" class="limpiarError" name="username" id="username" type="text" placeholder="Username" />
                                        <input style="margin-top: 8px" name="password" id="password" type="password" placeholder="Passsword" />


                                        <input style="margin-top: 8px" class="btn btn-primary" name="commit" type="submit" value="Ingresar" />
                                        <p style="margin-top: 8px; margin-bottom: 0" class="alert alert-warning loginError hide" role="alert"></p>
                                    </fieldset>
                                </form>
                            </div>
                       </li>
                    </sec:ifNotLoggedIn>
                </ul>
            </div>
        </div>
    </div>

    <g:layoutBody/>

    <div class="footer" role="contentinfo"></div>

    <div id="spinner" class="spinner" style="display:none;">
        <g:message code="spinner.alt" default="Loading&hellip;"/>
    </div>

</body>
</html>
