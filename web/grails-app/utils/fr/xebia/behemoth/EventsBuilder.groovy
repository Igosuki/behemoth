package fr.xebia.behemoth
/**
 *
 * User: Stéphane Moreau <smoreau@xebia.fr>
 */

class EventsBuilder {

    static def build(data) {
        def events = []

        data.events[0].event.each {
            Event event = new Event()
            event.title = it.title
            event.url = it.url
            events.add(event)
        }

        return events
    }
}
