import web.Book
import web.BookMongo
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

        try {
            if (BookMongo.count() == 0) {
                new BookMongo(title: 'Fifty shades of grey', author: 'Erika Leonard James').save()
                new BookMongo(title: 'Conan the barbarian', author: 'Robert Ervin Howard').save()
                new BookMongo(title: 'Neuromancer', author: 'William Gibson').save()
                new BookMongo(title: 'Fifty shades of grey', author: 'Erika Leonard James').save()
                new BookMongo(title: 'Conan the barbarian', author: 'Robert Ervin Howard').save()
                new BookMongo(title: 'Neuromancer', author: 'William Gibson').save()
                new BookMongo(title: 'Fifty shades of grey', author: 'Erika Leonard James').save()
                new BookMongo(title: 'Conan the barbarian', author: 'Robert Ervin Howard').save()
                new BookMongo(title: 'Neuromancer', author: 'William Gibson').save()
            }
        } catch (Exception e) {
            // If MongoDB is not available, no errors
            log.error("Unable to insert Data in MongoDB", e)
        }
    }

    def destroy = {
    }
}
