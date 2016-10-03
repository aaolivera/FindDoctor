package finddoctor

class Paciente extends Usuario {
    static hasMany = [comentarios:Comentario]
}
