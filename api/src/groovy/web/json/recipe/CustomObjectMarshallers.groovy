package web.json.recipe

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class CustomObjectMarshallers {

    private static final Logger log = LoggerFactory.getLogger(CustomObjectMarshallers.class)

    List marshallers = []

    def register() {
        log.debug "Registering custom marshallers"
        marshallers.each {
            it.register()
            log.debug "${it.class.simpleName} registered"
        }
    }
}
