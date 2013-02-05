import com.gmongo.GMongo
import com.mongodb.DB
import com.mongodb.DBCollection
import ncsa.hdf.object.h5.H5File

import static hdf5_getters.*
/**
 * User: charles
 * Date: 03/02/13
 * Time: 16:47
 * @author charles.blonde@gmail.com
 */


@Grapes([
@Grab(group = 'com.google.guava', module = 'guava', version = '13.0.1'),
@Grab(group = 'com.gmongo', module = 'gmongo', version = '1.0')
]
)

String baseFile = "/Users/charles/Documents/xke/xpua/xpua//data"
def mongoHost = "mongodb3.home.lan"
def databaseName = "behemoth-dev2"

def mongo = new GMongo(mongoHost)
DB db = mongo.getDB(databaseName)
DBCollection artists = db.getCollection("artists")
DBCollection songs = db.getCollection("songs")

//Memory leak ...
songs.find([_id: ["\$regex" : "^TRA[A-A]"]]).sort([_id: 1]).eachWithIndex { song, k ->
    println "Processing song ${song._id}"

    String id = song._id

    def dir1 = id[2]
    def dir2 = id[3]
    def dir3 = id[4]

    def file = new File("${baseFile}/${dir1}/${dir2}/${dir3}/${id}.h5")

    H5File h5 = hdf5_open_readonly(file.absolutePath)

    def artist = artists.findOne([_id: song.artist._id])
    if (!artist."7digitalid") {
        artist["7digitalid"] = get_artist_7digitalid(h5)
        artist["latitude"] = get_artist_latitude(h5)
        artist["longitude"] = get_artist_longitude(h5)
        artist["location"] = get_artist_location(h5)
        artist["playmeid"] = get_artist_playmeid(h5)

        //}

        try {
            String[] terms = get_artist_terms(h5)
            double[] termsFreq = get_artist_terms_freq(h5)
            double[] termsWeight = get_artist_terms_weight(h5)
            artist["terms"] = []

            terms.eachWithIndex { String term, int i ->
                def newTerm = [:]
                newTerm.term = term
                newTerm.freq = termsFreq[i]
                newTerm.weight = termsWeight[i]
                artist["terms"] << newTerm
            }
        } catch (Exception e) {
            println "\tEmpty terms : ${e}"
        }
        artists.save(artist)
    }

    song["release7digitalid"] = get_release_7digitalid(h5)
    song["hotttnesss"] = get_song_hotttnesss(h5)
    song["track7digitalid"] = get_track_7digitalid(h5)
    song["endOfFadeIn"] = get_end_of_fade_in(h5)
    song["key"] = get_key(h5)
    song["keyConfidence"] = get_key_confidence(h5)
    song["loudness"] = get_loudness(h5)
    song["mode"] = get_mode(h5)
    song["modeConfidence"] = get_mode_confidence(h5)
    song["startOfFadeOut"] = get_start_of_fade_out(h5)
    song["tempo"] = get_tempo(h5)
    song["timeSignature"] = get_time_signature(h5)
    song["timeSignatureConfidence"] = get_time_signature_confidence(h5)

    //bars
    try {
        double[] bars = get_bars_start(h5)
        double[] barsConfidence = get_bars_confidence(h5)
        song["bars"] = []

        bars.eachWithIndex { double entry, int i ->
            def bar = [:]
            bar.start = entry
            bar.confidence = barsConfidence[i]
            song["bars"] << bar
        }
    } catch (Exception e) {
        println "\tEmpty bars : ${e}"
    }

    //beats
    try {
        double[] beatsStart = get_beats_start(h5)
        double[] beatsConfidence = get_beats_confidence(h5)
        song["beats"] = []

        beatsStart.eachWithIndex { double entry, int i ->
            def beat = [:]
            beat.start = entry
            beat.confidence = beatsConfidence[i]
            song["beats"] << beat
        }
    } catch (Exception e) {
        println "\tEmpty beats : ${e}"
    }

    //sections
    try {
        double[] sectionsStart = get_sections_start(h5)
        double[] sectionsConfidence = get_sections_confidence(h5)
        song["sections"] = []

        sectionsStart.eachWithIndex { double entry, int i ->
            def section = [:]
            section.start = entry
            section.confidence = sectionsConfidence[i]
            song["sections"] << section
        }
    } catch (Exception e) {
        println "\tEmpty sections : ${e}"
    }

    //tatums
    try {
        double[] tatumsStart = get_tatums_start(h5)
        double[] tatumsConfidence = get_tatums_confidence(h5)
        song["tatums"] = []
        tatumsStart.eachWithIndex { double entry, int i ->
            def tatum = [:]
            tatum.start = entry
            tatum.confidence = tatumsConfidence[i]
            song["tatums"] << tatum
        }
    } catch (Exception e) {
        println "\tEmpty tatums : ${e}"
    }

    //Segments
    try {
        double[] segmentsStart = get_segments_start(h5)
        double[] segmentsConfidence = get_segments_confidence(h5)
        double[] loudnessMax = get_segments_loudness_max(h5)
        double[] loudnessMaxTime = get_segments_loudness_max_time(h5)
        double[] loudnessStart = get_segments_loudness_start(h5)
        double[] segmentsPitches = get_segments_pitches(h5)
        double[] segmentsTimbre = get_segments_timbre(h5)

        song["segments"] = []

        segmentsStart.eachWithIndex { double entry, int i ->
            def segment = [:]
            segment.start = entry
            segment.confidence = segmentsConfidence[i]
            segment.loudness = [:]
            segment.loudness.max = loudnessMax[i]
            segment.loudness.maxTime = loudnessMaxTime[i]
            segment.loudness.start = loudnessStart[i]

            segment.pitches = []
            for (int j = i * 12; j < (i * 12) + 12; j++) {
                segment.pitches << segmentsPitches[j]
            }

            segment.timbres = []
            for (int j = i * 12; j < (i * 12) + 12; j++) {
                segment.timbres << segmentsTimbre[j]
            }

            song["segments"] << segment
        }
    } catch (Exception e) {
        println "\tEmpty segments : ${e}"
    }


    songs.save(song)
    //System.exit(1)
}