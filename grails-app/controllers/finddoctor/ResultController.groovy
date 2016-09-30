package finddoctor
import grails.converters.*

class ResultController {

    def index() {
        println params

        [resultado:  [
                new Medico(nombre:'mrhaki',
                                    imagenUrl:'http://orig04.deviantart.net/92ae/f/2009/230/4/1/spongebob_9_150x150_png_by_somemilk.png',
                                    estrellas: 4,
                                    votos: 123
                                    ),
                new Medico(nombre:'mrhaki2',
                                    imagenUrl:'http://orig04.deviantart.net/92ae/f/2009/230/4/1/spongebob_9_150x150_png_by_somemilk.png',
                                    estrellas: 2, votos: 12)] as JSON]
    }

    def listComentarios(){
        println params
        a = new Paciente(
                nombre:'pepe',
                imagenUrl:'123'
        );
        b = new Paciente(
                nombre:'pepa',
                imagenUrl:'456'
        );
        [comentarios:  [new Comentario(texto:'Hola', paciente: a), new Comentario(texto:'Hola2', paciente: b), new Comentario(texto:'Hola3', paciente: a)] as JSON]
    }
}
