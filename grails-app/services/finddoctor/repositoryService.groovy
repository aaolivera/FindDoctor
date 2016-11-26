package finddoctor

import grails.transaction.Transactional

@Transactional
class repositoryService {

    def getInitialFilters(){
        def filters = Filtro.getAll();
        filters.findAll{ x -> filters.findAll({ y -> y.filtrosAsociados.containsAll(x)}).size() == 0 };
    }

    def listDoctorByFilter(String filtro) {
        Medico.withCriteria {filtrosAsociados {eq('descripcion', filtro) }}
    }

    def listTurnByDoctorAndPatient(long doctorId, Paciente user){
        def doctor = Medico.get(doctorId)
        Turno.withCriteria {eq('medico', doctor) eq('paciente', user)}
    }

    def listTurnByPatient(Paciente user){
        Turno.withCriteria {eq('paciente', user)}
    }

    def listTurnByDoctor(Medico user){
        Turno.withCriteria {eq('medico', user)}
    }

    def listCommentsByDoctorId(long id){
        Comentario.withCriteria {medico {eq('id', id) }}
    }

    
    
    def saveComment(long doctorId, Paciente user, String newComment){
        def medico = Medico.get(doctorId)
        def fechaActual = Calendar.getInstance(TimeZone.getTimeZone('GMT')).time
        new Comentario(texto:newComment, paciente: user, medico: medico, fecha: fechaActual).save()
        return true
    }

    def saveTurn(long doctorId, Paciente user, Date date){
        def medico = Medico.get(doctorId)
        def turnosPorPaciente = Turno.withCriteria {eq('medico', medico) eq('paciente', user) inList('estado',[State.Aceptado, State.Pendiente])}.any()
        if(!turnosPorPaciente){
            new Turno(fechaHora:date, paciente: user, medico: medico, estado: State.Pendiente).save()
            return true
        }
        return "Posee un turno activo para el médico seleccionado"
    }

    def cancelTurn(long turnId){
        def turn = Turno.get(turnId)
        turn.estado = State.Cancelado
        turn.save()
        return true
    }

    def acceptTurn(long turnId){
        def turn = Turno.get(turnId)
        turn.estado = State.Aceptado
        turn.save()
        return true
    }

}
