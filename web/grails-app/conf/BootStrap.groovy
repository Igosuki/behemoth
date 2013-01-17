import web.Book
import web.json.recipe.CustomObjectMarshallers

class BootStrap {

    CustomObjectMarshallers customObjectMarshallers

    def init = { servletContext ->

        customObjectMarshallers.register()

        new Book(title:  'truc', author: 'muche').save()
    }
    def destroy = {
    }
}
