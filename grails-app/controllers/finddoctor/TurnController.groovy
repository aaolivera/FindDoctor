package finddoctor

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured

class TurnController {
    def springSecurityService
    def repositoryService

    @Secured("ROLE_PATIENT")
    def turnsPatient() {
        def user = springSecurityService.currentUser
        def turns = repositoryService.listTurnByPatient(user)

        JSON.use('deep'){
            [turns: turns  as JSON]
        }
    }

    @Secured("ROLE_DOCTOR")
    def turnsDoctor() {
        def user = springSecurityService.currentUser
        def turns = repositoryService.listTurnByDoctor(user)

        JSON.use('deep'){
            [turns: turns  as JSON]
        }
    }

    @Secured(["ROLE_DOCTOR", "ROLE_PATIENT"])
    def acceptTurn(long turnId){
        repositoryService.acceptTurn(turnId);
    }

    @Secured(["ROLE_DOCTOR", "ROLE_PATIENT"])
    def cancelTurn(long turnId){
        repositoryService.cancelTurn(turnId);
    }

}
