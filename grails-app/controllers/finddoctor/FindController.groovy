package finddoctor
import grails.converters.*
import grails.plugin.springsecurity.annotation.Secured


class FindController {
    def repositoryService

    @Secured("permitAll")
    def index() {
        JSON.use('deep'){
            ['filterTree': repositoryService.getInitialFilters()  as JSON]
        }
    }
}
