package finddoctor
import grails.converters.*
import grails.plugin.springsecurity.annotation.Secured

class ResultController {

    @Secured("permitAll")
    def index() {
        println params

        [resultado:  Medico.getAll() as JSON]
    }

    @Secured("permitAll")
    def listComentarios(){
        println params

        JSON.use('deep'){
        render Comentario.getAll() as JSON
        }
    }

    @Secured("ROLE_PACIENTE")
    def guardarComentario(){
        println params
        render true
    }
}
