class UrlMappings {

    static verbsToActions = [GET: 'show', PUT: 'update', DELETE: 'delete', POST: 'save']

    static mappings = {

        "/$controller/$action?/$id?" {
            constraints {
                // apply constraints here
            }
        }

        "/book/$id?"(controller: 'book') {
            action = [GET: 'show', PUT: 'update', DELETE: 'delete', POST: 'save']
        }

        '/'(view: '/index')

        '500'(view: '/error')
    }
}
