package finddoctor
import grails.converters.*
import grails.plugin.springsecurity.annotation.Secured

class ResultController {

    @Secured("permitAll")
    def index(String filter) {
        [resultado:  Medico.withCriteria {filtrosAsociados {eq('descripcion', filter) }} as JSON, currentUsuario: springSecurityService.currentUser as JSON]
    }

    @Secured("permitAll")
    def listComentarios(long id){
        println params

        JSON.use('deep'){
            render Comentario.withCriteria {medico {eq('id', id) }} as JSON
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
}
