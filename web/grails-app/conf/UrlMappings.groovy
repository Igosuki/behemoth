class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?" {
			
			// REST API ?
			// action = [GET:'show', PUT:'update', DELETE:'delete', POST:'save']
			
			constraints {
				// apply constraints here
			}
		}

		'/'(view:'/index')

		'500'(view:'/error')
	}
}
