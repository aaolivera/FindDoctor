package finddoctor
import grails.converters.*
import grails.plugin.springsecurity.annotation.Secured


class FindController {
    @Secured("permitAll")
    def index() {
        def filtros = Filtro.getAll();
        JSON.use('deep'){
            ['filterTree': filtros.findAll( { x -> filtros.findAll({ y -> y.filtrosAsociados.containsAll(x)}).size() == 0 } )  as JSON]
        }
    }
}
