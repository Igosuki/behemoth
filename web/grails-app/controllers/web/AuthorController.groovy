package web

import grails.converters.JSON
import grails.converters.XML
import grails.plugins.springsecurity.Secured
import org.springframework.dao.DataIntegrityViolationException

class AuthorController {

    /**
     * Bound to GET
     */
    @Secured("IS_AUTHENTICATED_FULLY")
    def show() {
        def result
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        if (params.id && params.id != "list") {
            result = Author.get(params.id)
        } else {
            result = Author.list(params)
            response.setIntHeader('X-Pagination-Total', Author.count())
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
        def author = new Author(params)
        if (author.save()) {
            withFormat {
                json { render(author as JSON) }
                xml { render(author as XML) }
            }
        } else {
            def errResponse = [errors : author.errors.fieldErrors.collectEntries {
                [(it.field): message(error: it)]
            }]
            response.status = 400
            render errResponse as JSON
        }
    }

    /**
     * Bound to PUT
     */
    def update() {

        if (!params.id) {
            return render(status: 400)
        }

        def author = Author.get(params.id)

        if (!author) {
            return render(status: 404)
        }

        author.properties = params

        if (author.save()) {
            withFormat {
                json { render(author as JSON) }
                xml { render(author as XML) }
            }
        } else {
            def errResponse = [errors : author.errors.fieldErrors.collectEntries {
                [(it.field): message(error: it)]
            }]
            response.status = 400
            render errResponse as JSON
        }
    }

    /**
     * Bound to DELETE
     */
    def delete() {

        if (!params.id) {
            return render(status: 400)
        }

        def author = Author.get(params.id)
        if (!author) {
            return render(status: 404)
        }

        try {
            author.delete(flush: true)
            return render(status: 200)
        } catch (DataIntegrityViolationException e) {
            return render(status: 500)
        }
    }
}
