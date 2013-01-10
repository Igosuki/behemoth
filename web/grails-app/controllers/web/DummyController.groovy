package web

class DummyController {

    def index() { 
		render(contentType: "text/json") {
		    book(title: 'title', author: 'author')
		}
    }
}
