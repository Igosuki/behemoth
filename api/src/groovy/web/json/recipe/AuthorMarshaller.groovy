package web.json.recipe

import grails.converters.JSON
import web.Author

class AuthorMarshaller {

    void register() {

        JSON.registerObjectMarshaller(Author) { Author authorInstance ->
            return [
                    id: authorInstance.id,
                    firstName: authorInstance.firstName,
                    lastName: authorInstance.lastName,
                    birthday: "'${authorInstance.birthday}'"
            ]                   
        }
    }
}
