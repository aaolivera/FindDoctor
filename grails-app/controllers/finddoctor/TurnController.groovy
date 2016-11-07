package finddoctor

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured

class TurnController {
    def springSecurityService
    def servicioRepositorioService

    @Secured("ROLE_PACIENTE")
    def index() {
        def pacienteActual = springSecurityService.currentUser
        def turnos = servicioRepositorioService.listarTurnosPorPaciente(pacienteActual)
        [turnos: turnos  as JSON]
    }
}
