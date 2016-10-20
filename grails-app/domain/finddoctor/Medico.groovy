package finddoctor

class Medico extends Usuario {
    int estrellas
    int votos

    String ciudad
    String direccion
    String geolocalizacion
    String paginaWeb
    static hasMany = [comentarios:Comentario, filtrosAsociados:Filtro]
}
