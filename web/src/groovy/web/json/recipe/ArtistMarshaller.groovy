package web.json.recipe

import grails.converters.JSON
import fr.xebia.behemoth.Artist

class ArtistMarshaller {

    void register() {

        JSON.registerObjectMarshaller(Artist) { Artist artistInstance ->
            return [
                    id: artistInstance.id,
                    name: artistInstance.name,
                    mbid: artistInstance.mbid,
                    familiarity: artistInstance.familiarity,
                    hotness: artistInstance.hotness,
                    location: artistInstance.location,
                    latitude: artistInstance.latitude.toString(),
                    longitude: artistInstance.longitude.toString(),
                    sevenDigitalId: artistInstance.sevenDigitalId
            ]
        }
    }
}
