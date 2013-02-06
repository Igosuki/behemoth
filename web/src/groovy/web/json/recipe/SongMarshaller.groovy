package web.json.recipe

import grails.converters.JSON
import fr.xebia.behemoth.Song

class SongMarshaller {

    void register() {

        JSON.registerObjectMarshaller(Song) { Song songInstance ->
            return [
                    id: songInstance.id,
                    title: songInstance.title,
                    release: songInstance.release,
                    artist: [
                            id: songInstance.artist.id,
                            name: songInstance.artist.name
                    ],
                    duration: songInstance.duration,
                    hotness: songInstance.hotness
            ]
        }
    }
}
