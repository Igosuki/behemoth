package fr.xebia.behemoth

class Artist {

    String id

    String name

    String mbid

    Float familiarity

    Float hotness

    String location

    Float latitude

    Float longitude

    String sevenDigitalId

    List<SimilarArtist> similarArtists

    List<Term> terms

    static embedded = ['terms', 'similarArtists']

        static mapping = {
            collection "artists"
            hotness attr:'hotttnesss'
            sevenDigitalId attr:'7digitalid'
        }

    static constraints = {
    }
}
