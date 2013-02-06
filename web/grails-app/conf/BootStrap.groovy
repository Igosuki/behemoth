import grails.converters.JSON
import web.Author
import web.Book
import web.BookMongo
import web.User
import web.json.recipe.CustomObjectMarshallers

class BootStrap {

    CustomObjectMarshallers customObjectMarshallers

    def init = { servletContext ->

        customObjectMarshallers.register()
//        JSON.registerObjectMarshaller(Date) {
//            return it?.format("dd-MM-yyyy")
//        }

        new Book(title: 'Fifty shades of grey', author: 'Erika Leonard James').save()
        new Book(title: 'Conan the barbarian', author: 'Robert Ervin Howard').save()
        new Book(title: 'Neuromancer', author: 'William Gibson').save()
        new Book(title: 'Fifty shades of grey', author: 'Erika Leonard James').save()
        new Book(title: 'Conan the barbarian', author: 'Robert Ervin Howard').save()
        new Book(title: 'Neuromancer', author: 'William Gibson').save()
        new Book(title: 'Fifty shades of grey', author: 'Erika Leonard James').save()
        new Book(title: 'Conan the barbarian', author: 'Robert Ervin Howard').save()
        new Book(title: 'Neuromancer', author: 'William Gibson').save()
        new Book(title: 'Neuromancer', author: 'William Gibson').save()
        new Book(title: 'Fifty shades of grey', author: 'Erika Leonard James').save()
        new Book(title: 'Conan the barbarian', author: 'Robert Ervin Howard').save()
        new Book(title: 'Neuromancer', author: 'William Gibson').save()

        new Author(firstName: 'William', lastName: 'Gibson', birthday: new Date()).save()

        new User(accountExpired: false, accountLocked: false, email: "toto@toto.com", enabled: true, town: "Paris",
        passwordExpired: false, password: "toto", username: "toto")

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
