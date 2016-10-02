package finddoctor

class Usuario {
    Long id

    String nombre
    String imagenUrl
    String telefono

    Long version
    String email
    String password
    String toString() { "$email" }

}
