package fr.xebia.behemoth

class Song {

    String id

    String title

    String release

    Map artist

    Float duration

    Float hotness

    Artist getArtistEntity () {
        Artist.get(artist['_id'])
    }

    String getArtistId() {
        artist['_id']
    }

    String getArtistName() {
        artist['name']
    }

    static constraints = {
    }

    static mapping = {
        collection "songs"
        hotness attr:'hotttnesss'

    }
}
