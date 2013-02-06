package web.json.recipe

import fr.xebia.behemoth.Event
import grails.converters.JSON

class EventMarshaller {

    void register() {

        JSON.registerObjectMarshaller(Event) { Event eventInstance ->
            return [
                    title: eventInstance.title,
                    url: eventInstance.url
            ]
        }
    }
}
