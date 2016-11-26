package finddoctor
import grails.converters.*
import grails.plugin.springsecurity.annotation.Secured

class ResultController {
    def springSecurityService
    def repositoryService

    @Secured("permitAll")
    def index(String filter) {
        def user = springSecurityService.currentUser;
        def doctors = repositoryService.listDoctorByFilter(filter);
        [result: doctors  as JSON, currentUser: user as JSON]
    }

    @Secured("permitAll")
    def listComment(long doctorId){
        def comment = repositoryService.listCommentsByDoctorId(doctorId);
        JSON.use('deep'){
            render comment as JSON
        }
    }

    @Secured(["ROLE_PATIENT", 'ROLE_DOCTOR'])
    def saveComment(long doctorId,String newComment){
        def user = springSecurityService.currentUser
        repositoryService.saveComment(doctorId, user, newComment)
    }

    @Secured("ROLE_PATIENT")
    def listTurns(long doctorId){
        def user = springSecurityService.currentUser
        def turns = repositoryService.listTurnByDoctorAndPatient(doctorId, user)
        render turns as JSON
    }

    @Secured("ROLE_PATIENT")
    def createTurn(long doctorId, String datetime){
        def user = springSecurityService.currentUser
        def newdate = new Date().parse("d/M/yyyy H:m", datetime)
        render repositoryService.saveTurn(doctorId, user, newdate)
    }

}
