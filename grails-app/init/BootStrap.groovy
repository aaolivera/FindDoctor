import finddoctor.*

class BootStrap {

    def init = { servletContext ->
        //filtros

        Filtro a = new Filtro(descripcion:'Clínica Médica').save()
        Filtro b = new Filtro(descripcion:'Neurología').save()
        Filtro c = new Filtro(descripcion:'Cardiología').save()
        Filtro d = new Filtro(descripcion:'Dermatología').save()

        Filtro z = new Filtro(descripcion:'Obra Social').save()
        Filtro h = new Filtro(descripcion:'Particular').save()

        z.addToFiltrosAsociados(a).addToFiltrosAsociados(b).addToFiltrosAsociados(c).addToFiltrosAsociados(d).save()
        h.addToFiltrosAsociados(a).addToFiltrosAsociados(b).addToFiltrosAsociados(c).addToFiltrosAsociados(d).save()

        //medicos
        Medico doctorJuan = new Medico(username:'Doctor Juan Perez', password:'secret', enabled:true,telefono: '011-3133-1313',email: 'doctor.juan@gmail.com',paginaWeb:'-',direccion:'Humberto Primo 461', geolocalizacion: '-34.619293, -58.370106',ciudad: 'Ciudad de Buenos Aires',
                imagenUrl:'http://ichef.bbci.co.uk/news/660/media/images/76055000/jpg/_76055361_482566485.jpg',
                estrellas: 2,
                votos: 123
        ).save()
        Medico doctorHouse = new Medico(username:'Doctor House', password:'secret', enabled:true,telefono: '011-3433-1111',email: 'house@house.com.ar',paginaWeb:'www.house.com',direccion:'Balcarce 922', geolocalizacion: '-34.619293, -58.373106',ciudad: 'Ciudad de Buenos Aires',
               imagenUrl:'http://www.juegosgratisinternet.com/noticias/fotos/dr-house-nueva-final.jpg',
                estrellas: 5,
                votos: 12,
                horasLaborales: [10,11,12,13,14,15,16,17,18,19],
                turnosPorHora: [0,20,40]
        ).save()

        Medico doctorDoolitle = new Medico(username:'Doctor Dolittle', password:'secret', enabled:true,telefono: '011-3433-9999',email: 'doctor@doolitle.com',paginaWeb:'1',direccion:'Chile 355', geolocalizacion: '-34.615861, -58.371187',ciudad: 'Buenos Aires',
                imagenUrl:'http://iv1.lisimg.com/image/1509301/474full-dr.-dolittle-2-screenshot.jpg',
                estrellas: 5,
                votos: 12,
                horasLaborales: [16,17,18,19],
                turnosPorHora: [0,30]
        ).save()

        doctorHouse.addToFiltrosAsociados(a).save()
        doctorJuan.addToFiltrosAsociados(a).save()
        doctorDoolitle.addToFiltrosAsociados(a).save()

        //usuarios
        Paciente admin = new Paciente(username:'admin', password:'secret', enabled:true,telefono: '011-4545-3422',email: '50',
                imagenUrl:'http://www.thestar.com.my/~/media/online/2017/01/20/21/07/20170120t210657z_4_lynxmped0j1jj_rtroptp_3_usatrumpinauguration.ashx/?w=620&h=413&crop=1&hash=0088438441B9983D2C9FE1428965503C1AD8F2A4'
        ).save()
        Paciente homer = new Paciente(username:'Homer', password:'secret', enabled:true,telefono: '011-4514-1313',email: '40',
                imagenUrl:'https://pbs.twimg.com/profile_images/609439993094770690/MqfzEbtj.jpg'
        ).save()
        Paciente lisa = new Paciente(username:'Lisa', password:'secret', enabled:true,telefono: '011-4514-2222',email: '20',
                imagenUrl:'http://images.yodibujo.es/_uploads/_tiny_galerie/20130414/lisa-simpson-hija_6zs.jpg'
        ).save()

        //comentarios
        new Comentario(texto:'Excelente atención, poco tiempo de espera', paciente: homer, medico: doctorJuan, fecha: Calendar.getInstance(TimeZone.getTimeZone('GMT')).time).save()
        new Comentario(texto:'Excelente Profesional', paciente: lisa, medico: doctorHouse, fecha: Calendar.getInstance(TimeZone.getTimeZone('GMT')).time).save()
        new Comentario(texto:'Lugar de espera pequeño y con mucha demora', paciente: homer, medico: doctorHouse, fecha: Calendar.getInstance(TimeZone.getTimeZone('GMT')).time).save()
        new Comentario(texto:'Excelente', paciente: admin, medico: doctorHouse, fecha: Calendar.getInstance(TimeZone.getTimeZone('GMT')).time).save()

        //seguridad
        SecAppRole paciente = new SecAppRole(authority: 'ROLE_PATIENT').save()
        SecAppRole medico = new SecAppRole(authority: 'ROLE_DOCTOR').save()
        SecUsuarioSecAppRole.create(admin, paciente)
        SecUsuarioSecAppRole.create(doctorJuan, medico)
        SecUsuarioSecAppRole.create(doctorHouse, medico)

    }
    def destroy = {
    }
}
