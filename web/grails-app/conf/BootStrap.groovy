import web.Book
import web.json.recipe.CustomObjectMarshallers

class BootStrap {

    CustomObjectMarshallers customObjectMarshallers

    def init = { servletContext ->

        customObjectMarshallers.register()

        new Book(title: 'Fifty shades of grey', author: 'Erika Leonard James').save()
    }

    def destroy = {
    }
}
