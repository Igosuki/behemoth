package web.json.recipe

import fr.xebia.behemoth.Event
import grails.converters.JSON

class EventMarshaller {

    void register() {

        JSON.registerObjectMarshaller(Event) { Event eventInstance ->
            return [
                    title: eventInstance.title,
                    url: eventInstance.url,
                    description: eventInstance.description,
                    startDate: eventInstance.startDate,
                    endDate: eventInstance.endDate,
                    city: eventInstance.city,
                    country: eventInstance.country,
                    latitude: eventInstance.latitude,
                    longitude: eventInstance.longitude,
                    imageUrl: eventInstance.imageUrl,
                    venue: [
                            id: eventInstance.venue.id,
                            url: eventInstance.venue.url,
                            name: eventInstance.venue.name,
                            address: eventInstance.venue.address
                    ]
            ]
        }
    }
}
