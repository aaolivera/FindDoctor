package finddoctor
import grails.converters.*
import grails.plugin.springsecurity.annotation.Secured


class FindController {
    def servicioRepositorioService

    @Secured("permitAll")
    def index() {
        JSON.use('deep'){
            ['filterTree': servicioRepositorioService.obtenerFiltrosIniciales()  as JSON]
        }
    }
}
