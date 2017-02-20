package finddoctor

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured

class UserController {
    def springSecurityService
    def repositoryService

    @Secured("permitAll")
    def register() {

    }

    @Secured("permitAll")
    def registerUser() {

    }
}
