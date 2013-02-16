package fr.xebia.behemoth

import grails.converters.JSON
import groovyx.net.http.*

class EventsController {

    def index() {}

    def searchByLocation() {
        String location = params.location
        Integer max = params.max ? params.max.toInteger() : 20
        Integer offset = params.offset ? params.offset.toInteger() : 0

        def client = new RESTClient( 'http://api.evdb.com/rest/' )

        def resp = client.get( path : 'events/search',
                params: [
                        app_key: '29S3WjD9QdR4LwfH',
                        user: 'behemoth@xebia.fr',
                        password: 'b3h3m0th',
                        date: 'Future',
                        page_size: max,
                        page_number: offset % max,
                        location: location
                ] )

        def events = EventsBuilder.build(resp.data)
        render events as JSON
    }

    def searchByArtist() {
        String artist = params.artist

        def client = new RESTClient( 'http://api.evdb.com/rest/' )

        def resp = client.get( path : 'events/search',
                params: [
                        app_key: '29S3WjD9QdR4LwfH',
                        user: 'behemoth@xebia.fr',
                        password: 'b3h3m0th',
                        date: 'Future',
                        keywords: artist
                ] )

        def events = EventsBuilder.build(resp.data)
        render events as JSON
    }
}
