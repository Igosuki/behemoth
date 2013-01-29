import org.codehaus.groovy.grails.web.context.ServletContextHolder as SCH

def allJsUnder(path) {

    def webFileCachePaths = []

    def servletContext = SCH.getServletContext()

//context isn't present when testing in integration mode. -jg
    if(!servletContext) return webFileCachePaths

    def realPath = servletContext.getRealPath('/')

    def appDir = new File("$realPath/$path")

    appDir.eachFileRecurse {File file ->
        if (file.isDirectory()) return
        webFileCachePaths << file.path.replace(realPath, '')
    }

    webFileCachePaths
}

modules = {

    application {

        dependsOn('bootstrap-responsive-css')

        resource url:'css/app.css'

        resource url:'js/angular.min.js'

        allJsUnder('/js/ng').each {
            resource url: it
        }
    }
}