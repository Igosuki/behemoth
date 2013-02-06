package fr.xebia.behemoth
/**
 *
 * User: Stéphane Moreau <smoreau@xebia.fr>
 */

class EventsBuilder {

    static def build(data) {
        def events = []

        data.events[0].event.each {
            String startTime = it.start_time.text()
            String stopTime = it.stop_time.text()

            Event event = new Event()
            event.title = it.title
            event.url = it.url
            event.description = it.description
            if (!startTime.isEmpty()) {
                event.startDate = new Date().parse("yyyy-M-d H:m:s", startTime)
            }
            if (!stopTime.isEmpty()) {
                event.endDate = new Date().parse("yyyy-M-d H:m:s", stopTime)
            }
            event.city = it.city_name
            event.country = it.country_name
            event.latitude = it.latitude.text().toFloat()
            event.longitude = it.longitude.text().toFloat()
            event.imageUrl = it.image.url

            Venue venue = new Venue()
            venue.id = it.venue_id
            venue.url = it.venue_url
            venue.name = it.venue_name
            venue.address = it.venue_address
            event.venue = venue

            def performers = []
            it.performers[0].performer.each {
                Performer performer = new Performer()
                performer.id = it.id
                performer.url = it.url
                performer.name = it.name
                performer.shortBio = it.short_bio
                performers.add(performer)
            }
            event.performers = performers

            events.add(event)
        }

        return events
    }
}
