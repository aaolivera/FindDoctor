package finddoctor

import grails.transaction.Transactional

@Transactional
class servicioRepositorioService {

    def obtenerFiltrosIniciales(){
        def filtros = Filtro.getAll();
        filtros.findAll{ x -> filtros.findAll({ y -> y.filtrosAsociados.containsAll(x)}).size() == 0 };
    }

    def filtrarMedicos(String filtro) {
        Medico.withCriteria {filtrosAsociados {eq('descripcion', filtro) }}
    }

    def listarTurnosPorMedicoIdyPaciente(long medicoId, Paciente usuario){
        def medico = Medico.get(medicoId)
        Turno.withCriteria {eq('medico', medico) eq('paciente', usuario)}
    }

    def listarTurnosPorPaciente(Paciente usuario){
        Turno.withCriteria {eq('paciente', usuario)}
    }

    def listarTurnosPorMedico(Medico usuario){
        Turno.withCriteria {eq('medico', usuario)}
    }

    def listarComentariosPorMedicoId(long id){
        Comentario.withCriteria {medico {eq('id', id) }}
    }

    def guardarComentario(long medicoId, Paciente usuario, String nuevoComentario){
        def medico = Medico.get(medicoId)
        def fechaActual = Calendar.getInstance(TimeZone.getTimeZone('GMT')).time
        new Comentario(texto:nuevoComentario, paciente: usuario, medico: medico, fecha: fechaActual).save()
        return true
    }

    def guardarTurno(long medicoId, Paciente usuario, Date fecha){
        def medico = Medico.get(medicoId)
        def turnosPorPaciente = Turno.withCriteria {eq('medico', medico) eq('paciente', usuario) inList('estado',[Estado.Aceptado, Estado.Pendiente])}.any()
        if(!turnosPorPaciente){
            new Turno(fechaHora:fecha, paciente: usuario, medico: medico, estado: Estado.Pendiente).save()
            return true
        }
        return "Posee un turno activo para el médico seleccionado"
    }

    def cancelarTurno(long turnoId, Paciente usuario){
        def turno = Turno.get(turnoId)
        if(turno.paciente == usuario) {
            turno.estado = Estado.Cancelado
            turno.save()
            return true
        }
        return false
    }

}
