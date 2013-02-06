package fr.xebia.behemoth

import grails.converters.JSON
import static javax.servlet.http.HttpServletResponse.*

class ArtistController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {}

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        response.setIntHeader('X-Pagination-Total', Artist.count())
        render Artist.list(params) as JSON
    }


    def get() {
        def artistInstance = Artist.get(params.id)
        if (artistInstance) {
            render artistInstance as JSON
        } else {
            notFound params.id
        }
    }

    def complete() {
        String start = params.start ?: ''
        Integer max = params.max ? params.max.toInteger() : 20
        Integer offset = params.offset ? params.offset.toInteger() : 0

        def result = Artist.findAllByNameIlike(start + '%', [max: max, offset: offset, sort: 'name', order: 'asc'])
        def finalResult = result.collect {
            [ id: it.id, name: it.name ]
        }

        render finalResult as JSON
    }


    private void notFound(id) {
        response.status = SC_NOT_FOUND
        def responseJson = [message: message(code: 'default.not.found.message', args: [message(code: 'artist.label', default: 'Artist'), params.id])]
        render responseJson as JSON
    }
}
