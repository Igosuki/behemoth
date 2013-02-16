package fr.xebia.behemoth

class AllUsersActionsService {

    static transactional = false
    static atmosphere = [mapping: '/atmosphere/allusers/actions']

    def onRequest = { event ->
        println "onRequest, $event"

        // Mark this connection as suspended.
        event.suspend()
    }

    def registerEvent(AllUsersEvent userEvent) {
        println 'Inside registerEvent!'
        // broadcast to the atmosphere
        broadcaster['/atmosphere/allusers/actions'].broadcast(userEvent.createMessage())
        println "Broadcasted ${userEvent.createMessage()}"

        return null
    }

    def onStateChange = { event ->
        println 'State changed'
        if (event.message) {
            println "onStateChange, message: ${event.message}"

            if (event.isSuspended()) {
                println 'event suspended'
                event.resource.response.writer.with {
                    write "${event.message}"
                    flush()
                }
                event.resume()
            }
        }
    }





}
