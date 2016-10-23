package finddoctor
import grails.converters.*
import grails.plugin.springsecurity.annotation.Secured

class ResultController {

    @Secured("permitAll")
    def index(String filter) {
        [resultado:  Medico.withCriteria {filtrosAsociados {eq('descripcion', filter) }} as JSON, currentUsuario: springSecurityService.currentUser as JSON]
    }

    @Secured("permitAll")
    def listarComentarios(long medicoId){
        println params
        def a = Comentario.where {x -> x.medico.id == medicoId}
        JSON.use('deep'){
            render a.list() as JSON
        }
    }
    def springSecurityService
    @Secured("ROLE_PACIENTE")
    def guardarComentario(long medicoId,String nuevoComentario){
        def medico = Medico.get(medicoId)
        def pacienteActual = springSecurityService.currentUser
        def fechaActual = Calendar.getInstance(TimeZone.getTimeZone('GMT')).time
        new Comentario(texto:nuevoComentario, paciente: pacienteActual, medico: medico, fecha: fechaActual).save()
        render true
    }

    @Secured("ROLE_PACIENTE")
    def listarTurnos(long medicoId){
        def pacienteActual = springSecurityService.currentUser
        def a = Turno.where {x -> x.medico.id == medicoId && x.paciente.id == pacienteActual.id}
        JSON.use('deep'){
            render a.list() as JSON
        }
    }

    @Secured("ROLE_PACIENTE")
    def crearTurno(long medicoId,String fecha){
        def medico = Medico.get(medicoId)
        def pacienteActual = springSecurityService.currentUser
        new Turno(fechaHora:fecha, paciente: pacienteActual, medico: medico, estado: Estado.Pendiente).save()
        render true
    }

    @Secured("ROLE_PACIENTE")
    def cancelarTurno(long turnoId){
        def turno = Turno.get(turnoId)
        turno.estado = Estado.Cancelado
        render true
    }
}
