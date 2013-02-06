package fr.xebia.behemoth

import grails.converters.JSON
import groovyx.net.http.*

class EventsController {

    def index() {}

    def search() {
        String location = params.location

        def client = new RESTClient( 'http://api.evdb.com/rest/' )

        def resp = client.get( path : 'events/search',
                params: [
                        app_key: '29S3WjD9QdR4LwfH',
                        user: 'behemoth@xebia.fr',
                        password: 'b3h3m0th',
                        location: location
                ] )

        def events = EventsBuilder.build(resp.data)
        render events as JSON
    }
}
