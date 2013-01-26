package web

import grails.converters.JSON
import grails.converters.XML
import org.springframework.dao.DataIntegrityViolationException

class BookController {

    /**
     * Bound to GET
     */
    def show() {
        def result
        if (params.id && params.id != "list") {
            result = Book.get(params.id)
        } else {
            result = Book.list()
        }

        if (!result) {
            render(status: 404)
        } else {
            withFormat {
                json { render(result as JSON) }
                xml { render(result as XML) }
            }
        }
    }

    /**
     * Bound to POST
     */
    def save() {
        def book = new Book(params)
        if (book.save()) {
            withFormat {
                json { render(book as JSON) }
                xml { render(book as XML) }
            }
        } else {
            render(status: 400)
        }
    }

    /**
     * Bound to PUT
     */
    def update() {

        if (!params.id) {
            return render(status: 400)
        }

        def book = Book.get(params.id)

        if (!book) {
            return render(status: 404)
        }

        book.properties = params

        if (book.save()) {
            withFormat {
                json { render(book as JSON) }
                xml { render(book as XML) }
            }
        } else {
            render(status: 400)
        }
    }

    /**
     * Bound to DELETE
     */
    def delete() {

        if (!params.id) {
            return render(status: 400)
        }

        def book = Book.get(params.id)
        if (!book) {
            return render(status: 404)
        }

        try {
            book.delete(flush: true)
            return render(status: 200)
        } catch (DataIntegrityViolationException e) {
            return render(status: 500)
        }
    }
}
