package fr.xebia.behemoth

class Song {

    String id

    String title

    String release

    Map artist

    Float duration

    Float hotness

    String getArtistId() {
        artist['_id']
    }

    static constraints = {
    }



    static mapping = {
        collection "songs"
        hotness attr:'hotttnesss'

    }
}
