import web.Book
import web.json.recipe.CustomObjectMarshallers

class BootStrap {

    CustomObjectMarshallers customObjectMarshallers

    def init = { servletContext ->

        customObjectMarshallers.register()

        new Book(title: 'Fifty shades of grey', author: 'Erika Leonard James').save()
        new Book(title: 'Conan the barbarian', author: 'Robert Ervin Howard').save()
        new Book(title: 'Neuromancer', author: 'William Gibson').save()
        new Book(title: 'Fifty shades of grey', author: 'Erika Leonard James').save()
        new Book(title: 'Conan the barbarian', author: 'Robert Ervin Howard').save()
        new Book(title: 'Neuromancer', author: 'William Gibson').save()
        new Book(title: 'Fifty shades of grey', author: 'Erika Leonard James').save()
        new Book(title: 'Conan the barbarian', author: 'Robert Ervin Howard').save()
        new Book(title: 'Neuromancer', author: 'William Gibson').save()
    }

    def destroy = {
    }
}
