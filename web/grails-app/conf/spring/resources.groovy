import web.json.recipe.AuthorMarshaller
import web.json.recipe.BookMarshaller
import web.json.recipe.ArtistMarshaller
import web.json.recipe.CustomObjectMarshallers
import web.json.recipe.SongMarshaller

// Place your Spring DSL code here
beans = {
    customObjectMarshallers(CustomObjectMarshallers) {
        marshallers = [
                new BookMarshaller(),
                new AuthorMarshaller(),
                new ArtistMarshaller(),
                new SongMarshaller()
        ]
    }
}
