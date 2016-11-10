package finddoctor

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured

class TurnController {
    def springSecurityService
    def servicioRepositorioService

    @Secured("ROLE_PACIENTE")
    def turnosPaciente() {
        def pacienteActual = springSecurityService.currentUser
        def turnos = servicioRepositorioService.listarTurnosPorPaciente(pacienteActual)

        JSON.use('deep'){
            [turnos: turnos  as JSON]
        }
    }

    @Secured("ROLE_MEDICO")
    def turnosMedico() {
        def pacienteActual = springSecurityService.currentUser
        def turnos = servicioRepositorioService.listarTurnosPorMedico(pacienteActual)

        JSON.use('deep'){
            [turnos: turnos  as JSON]
        }
    }
}
