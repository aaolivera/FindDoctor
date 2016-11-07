package finddoctor
import grails.converters.*
import grails.plugin.springsecurity.annotation.Secured

class ResultController {
    def springSecurityService
    def servicioRepositorioService

    @Secured("permitAll")
    def index(String filter) {
        def usuario = springSecurityService.currentUser;
        def medicos = servicioRepositorioService.filtrarMedicos(filter);
        [resultado: medicos  as JSON, currentUsuario: usuario as JSON]
    }

    @Secured("permitAll")
    def listarComentarios(long medicoId){
        def comentarios = servicioRepositorioService.listarComentariosPorMedicoId(medicoId);
        JSON.use('deep'){
            render comentarios as JSON
        }
    }

    @Secured("ROLE_PACIENTE")
    def guardarComentario(long medicoId,String nuevoComentario){
        def pacienteActual = springSecurityService.currentUser
        servicioRepositorioService.guardarComentario(medicoId, pacienteActual, nuevoComentario)
    }

    @Secured("ROLE_PACIENTE")
    def listarTurnos(long medicoId){
        def pacienteActual = springSecurityService.currentUser
        def turnos = servicioRepositorioService.listarTurnosPorMedicoIdyPaciente(medicoId, pacienteActual)
        render turnos as JSON
    }

    @Secured("ROLE_PACIENTE")
    def crearTurno(long medicoId,String fechaHora){
        def pacienteActual = springSecurityService.currentUser
        def newdate = new Date().parse("d/M/yyyy H:m", fechaHora)
        render servicioRepositorioService.guardarTurno(medicoId, pacienteActual, newdate)
    }

    @Secured("ROLE_PACIENTE")
    def cancelarTurno(long turnoId){
        def pacienteActual = springSecurityService.currentUser
        render servicioRepositorioService.cancelarTurno(turnoId, pacienteActual) as JSON
    }
}
