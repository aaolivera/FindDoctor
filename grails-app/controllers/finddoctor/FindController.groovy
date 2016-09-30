package finddoctor
import grails.converters.*


class FindController {

    def index() {
        def a = new Filtro(descripcion:'a', filtrosAsociados: [ new Filtro(descripcion:'b', filtrosAsociados: [ new Filtro(descripcion:'G'), new Filtro(descripcion:'H'), new Filtro(descripcion:'z')]), new Filtro(descripcion:'c')])
        def b = new Filtro(descripcion:'D', filtrosAsociados: [ new Filtro(descripcion:'E'), new Filtro(descripcion:'F')])
        ['filterTree': [a, b] as JSON]
    }
}
