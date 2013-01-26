class UrlMappings {

    static mappings = {

        "/$controller/$action?/$id?" {
            constraints {
                // apply constraints here
            }
        }

        // 'resource' maps [GET: 'show', PUT: 'update', DELETE: 'delete', POST: 'save']
        "/book/$id?"(resource: 'book')


        "/index/$domainClass"(controller: "index", action: "index")

        '/'(view: '/index')

        '500'(view: '/error')
    }
}
