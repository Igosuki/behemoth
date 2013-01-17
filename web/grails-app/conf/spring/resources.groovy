import web.json.recipe.BookMarshaller
import web.json.recipe.CustomObjectMarshallers

// Place your Spring DSL code here
beans = {
    customObjectMarshallers(CustomObjectMarshallers) {
        marshallers = [new BookMarshaller()]
    }
}
