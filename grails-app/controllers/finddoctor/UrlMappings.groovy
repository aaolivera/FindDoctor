package finddoctor

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/" {
            controller = "Find"
            action = "Index"
        }
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
