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
        def a = new Paciente(
                nombre:'pepe',
                imagenUrl:'http://orig04.deviantart.net/92ae/f/2009/230/4/1/spongebob_9_150x150_png_by_somemilk.png'
        );
        def b = new Paciente(
                nombre:'pepa',
                imagenUrl:'http://orig04.deviantart.net/92ae/f/2009/230/4/1/spongebob_9_150x150_png_by_somemilk.png'

        );
        def comentarios = [new Comentario(texto:'Hola', paciente: a, fecha: Calendar.getInstance(TimeZone.getTimeZone('GMT')).time), new Comentario(texto:'Hola2', paciente: b, fecha: Calendar.getInstance(TimeZone.getTimeZone('GMT')).time), new Comentario(texto:'Hola3', paciente: a, fecha: Calendar.getInstance(TimeZone.getTimeZone('GMT')).time)]
        JSON.use('deep'){
        render comentarios as JSON
        }
    }

    def guardarComentario(){
        println params
        render true
    }
}
