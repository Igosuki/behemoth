package web.json.recipe

import grails.converters.JSON
import web.Book

class BookMarshaller {

    void register() {

        JSON.registerObjectMarshaller(Book) { Book bookInstance ->
            return [
                    id: bookInstance.id,
                    title: bookInstance.title,
                    author: bookInstance.author
            ]
        }
    }
}
