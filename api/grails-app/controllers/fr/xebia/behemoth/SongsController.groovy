package fr.xebia.behemoth

import grails.converters.JSON
import static javax.servlet.http.HttpServletResponse.*

class SongsController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]


    def index() { }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        response.setIntHeader('X-Pagination-Total', Song.count())
        render Song.list(params) as JSON
    }

    def detail() {
        def songInstance = Song.get(params.id)
        if (songInstance) {
            render songInstance as JSON
        } else {
            notFound params.id
        }
    }

    def complete() {
        String start = params.start ?: ''
        Integer max = params.max ? params.max.toInteger() : 20
        Integer offset = params.offset ? params.offset.toInteger() : 0

        def result = Song.findAllByTitleIlike(start + '%', [max: max, offset: offset, sort: 'name', order: 'asc'])
        def finalResult = result.collect {
            [ id: it.id, title: it.title, artist: [ id: it.artistId, name: it.artistName ] ]
        }

        render finalResult as JSON
    }

    private void notFound(id) {
        response.status = SC_NOT_FOUND
        def responseJson = [message: message(code: 'default.not.found.message', args: [message(code: 'song.label', default: 'Song'), params.id])]
        render responseJson as JSON
    }
}
