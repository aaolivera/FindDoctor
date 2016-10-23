import finddoctor.*

class BootStrap {

    def init = { servletContext ->
        //filtros
        Filtro c = new Filtro(descripcion:'c').save()
        Filtro z = new Filtro(descripcion:'z').save()
        Filtro h = new Filtro(descripcion:'H')
        Filtro b = new Filtro(descripcion:'b').save()
        Filtro a = new Filtro(descripcion:'a').save()
        a.addToFiltrosAsociados(b).addToFiltrosAsociados(z).addToFiltrosAsociados(c).save()

        Filtro d = new Filtro(descripcion:'d').save()
        d.addToFiltrosAsociados(h).save()


        //medicos
        Medico mrhaki = new Medico(username:'mrhaki', password:'secret', enabled:true,telefono: '12',email: '23',paginaWeb:'1',direccion:'1', geolocalizacion: '1',ciudad: '1',
                imagenUrl:'http://orig04.deviantart.net/92ae/f/2009/230/4/1/spongebob_9_150x150_png_by_somemilk.png',
                estrellas: 4,
                votos: 123
        ).save()
        Medico mrhaki2 = new Medico(username:'mrhaki2', password:'secret', enabled:true,telefono: '12',email: '23',paginaWeb:'1',direccion:'1', geolocalizacion: '1',ciudad: '1',
               imagenUrl:'http://orig04.deviantart.net/92ae/f/2009/230/4/1/spongebob_9_150x150_png_by_somemilk.png',
                estrellas: 2,
                votos: 12
        ).save()

        mrhaki.addToFiltrosAsociados(c).save()
        mrhaki2.addToFiltrosAsociados(h).save()
        //usuarios
        Paciente admin = new Paciente(username:'admin', password:'secret', enabled:true,telefono: '12',email: '23',
                imagenUrl:'http://orig04.deviantart.net/92ae/f/2009/230/4/1/spongebob_9_150x150_png_by_somemilk.png'
        ).save()
        Paciente john = new Paciente(username:'john', password:'secret', enabled:true,telefono: '12',email: '23',
                imagenUrl:'http://orig04.deviantart.net/92ae/f/2009/230/4/1/spongebob_9_150x150_png_by_somemilk.png'
        ).save()
        Paciente jane = new Paciente(username:'jane', password:'secret', enabled:true,telefono: '12',email: '23',
                imagenUrl:'http://orig04.deviantart.net/92ae/f/2009/230/4/1/spongebob_9_150x150_png_by_somemilk.png'
        ).save()

        //comentarios
        new Comentario(texto:'Hola', paciente: jane, medico: mrhaki, fecha: Calendar.getInstance(TimeZone.getTimeZone('GMT')).time).save()
        new Comentario(texto:'Hola', paciente: jane, medico: mrhaki, fecha: Calendar.getInstance(TimeZone.getTimeZone('GMT')).time).save()
        new Comentario(texto:'Hola', paciente: jane, medico: mrhaki2, fecha: Calendar.getInstance(TimeZone.getTimeZone('GMT')).time).save()
        new Comentario(texto:'Hola', paciente: john, medico: mrhaki2, fecha: Calendar.getInstance(TimeZone.getTimeZone('GMT')).time).save()

        //seguridad
        SecAppRole paciente = new SecAppRole(authority: 'ROLE_PACIENTE').save()
        SecAppRole medico = new SecAppRole(authority: 'ROLE_MEDICO').save()
        SecUsuarioSecAppRole.create(admin, paciente)
        SecUsuarioSecAppRole.create(mrhaki, medico)
    }
    def destroy = {
    }
}
