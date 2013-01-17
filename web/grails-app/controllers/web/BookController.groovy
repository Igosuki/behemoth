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
        if (params.id) {
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
        // save and render saved object with id
    }

    /**
     * Bound to PUT
     */
    def update(Long id, Long version) {
        def bookInstance = Book.get(id)
        if (!bookInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'book.label', default: 'Book'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (bookInstance.version > version) {
                bookInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'book.label', default: 'Book')] as Object[],
                        "Another user has updated this Book while you were editing")
                render(view: "edit", model: [bookInstance: bookInstance])
                return
            }
        }

        bookInstance.properties = params

        if (!bookInstance.save(flush: true)) {
            render(view: "edit", model: [bookInstance: bookInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'book.label', default: 'Book'), bookInstance.id])
        redirect(action: "show", id: bookInstance.id)
    }

    /**
     * Bound to DELETE
     */
    def delete(Long id) {
        def bookInstance = Book.get(id)
        if (!bookInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'book.label', default: 'Book'), id])
            redirect(action: "list")
            return
        }

        try {
            bookInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'book.label', default: 'Book'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'book.label', default: 'Book'), id])
            redirect(action: "show", id: id)
        }
    }
}
