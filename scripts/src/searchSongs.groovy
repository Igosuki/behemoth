import com.gmongo.GMongo
import com.mongodb.DB
import com.mongodb.DBCollection
import groovy.sql.Sql
/**
 * User: charles
 * Date: 03/02/13
 * Time: 12:11
 * @author charles.blonde@gmail.com
 */
@Grapes([
@Grab(group = 'org.xerial', module = 'sqlite-jdbc', version = '3.7.2'),
@Grab(group = 'com.google.guava', module = 'guava', version = '13.0.1'),
@Grab(group = 'com.gmongo', module = 'gmongo', version = '1.0')
]
)

def pathSqlFile="/Users/charles/Documents/xke/xpua/xpua/AdditionalFiles"

String dbLocationMetadata = "jdbc:sqlite:${pathSqlFile}/subset_track_metadata.db"
String dbLocationTerm = "jdbc:sqlite:${pathSqlFile}/subset_artist_term.db"
String dbLocationSimilarity = "jdbc:sqlite:${pathSqlFile}/subset_artist_similarity.db"

String dbDriver = "org.sqlite.JDBC"


Sql sqlMetadata = groovy.sql.Sql.newInstance(dbLocationMetadata, dbDriver)
Sql sqlTerm = groovy.sql.Sql.newInstance(dbLocationTerm, dbDriver)
Sql sqlSimilarity = groovy.sql.Sql.newInstance(dbLocationSimilarity, dbDriver)

/*
sqlMetadata.rows("SELECT * FROM songs WHERE artist_name='Radiohead'").each{
    println it
}
*/

/*
sqlSimilarity.rows("select * from similarity").each{
    println it
}

System.exit(1)
*/

def mongo = new GMongo("mongodb3.home.lan")
DB db = mongo.getDB("behemoth-dev2")
DBCollection artists = db.getCollection("artists")
DBCollection songs = db.getCollection("songs")


sqlMetadata.rows("SELECT artist_id, artist_mbid, artist_name,AVG(artist_familiarity) AS artist_familiarity, AVG(artist_hotttnesss) AS artist_hotttnesss FROM songs GROUP BY artist_id,artist_mbid,artist_name").each {
    def artist = [:]
    artist._id = it.artist_id
    artist.name = it.artist_name
    artist.mbid = it.artist_mbid
    artist.familiarity = it.artist_familiarity
    artist.hotttnesss = it.artist_hotttnesss
    artist.terms = []
    artist.mbtags = []
    artist.similarArtists = []

    sqlTerm.rows("SELECT term FROM artist_term AT WHERE AT.artist_id = ? ", [it.artist_id]).each {
        artist.terms << it.term
    }

    sqlTerm.rows("SELECT mbtag FROM artist_mbtag AM WHERE AM.artist_id = ? ", [it.artist_id]).each {
        artist.mbtags << it.mbtag
    }

    sqlSimilarity.rows("SELECT similar FROM similarity WHERE target = ?", [it.artist_id]).each {
        def artistSimilar = [:]
        artistSimilar.id = it.similar
        sqlMetadata.rows("SELECT artist_name FROM songs WHERE artist_id = ?", [it.similar], 0, 1).each {
            artistSimilar.name = it.artist_name
        }
        artist.similarArtists << artistSimilar
    }

    //println artist
    //artists.insert(artist,WriteConcern.SAFE)
    artists.insert(artist)
}

sqlMetadata.rows("SELECT * FROM songs").each {
    def song = [:]
    def songArtist = [:]
    song._id = it.track_id
    song.title = it.title
    song.release = it.release
    songArtist._id = it.artist_id
    songArtist.name = it.artist_name
    song.artist = songArtist
    if (it.year != 0) {
        song.year = it.year
    }
    song.duration = it.duration

    println song
    songs.insert(song)
    //System.exit(1)
}

/*
sqlMetadata.rows("SELECT * FROM songs WHERE artist_id='ARZZRK91187B9A5CA5'").each{
    println it
}
*/

/*
sqlMetadata.rows("select * from sqlite_master").each{
    println it
}
*/

/*
sqlTerm.rows("select * from sqlite_master").each{
    println it
}
*/

/*
sqlTerm.rows("select * from terms").each{
    println it;
}
*/

/*
sqlTerm.rows("select * from artist_term").each{
    println it;
}
*/

/*
sqlTerm.rows("select count(*) from mbtags").each{
    println it;
}
*/

/*
def getDb(){
    return groovy.sql.Sql.newInstance(dbLocation, dbDriver)
}
*/
/*
void insert(String url){
    def sql = getDb()
    sql.execute("insert into myTable(colname1, colname2) values(?, ?)", [url, new Date()])
}
void printContents(){
    def sql = getDb()
    sql.rows("select * from myTable order by date desc").each{
        println(it)
    }
}

*/