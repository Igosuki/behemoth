import org.codehaus.groovy.grails.web.context.ServletContextHolder as SCH

def allJsUnder(path) {

    def webFileCachePaths = []

    def servletContext = SCH.getServletContext()

//context isn't present when testing in integration mode. -jg
    if (!servletContext) return webFileCachePaths

    def realPath = servletContext.getRealPath('/')

    def appDir = new File("$realPath/$path")

    appDir.eachFileRecurse { File file ->
        if (file.isDirectory()) return
        webFileCachePaths << file.path.replace(realPath, '')
    }

    webFileCachePaths
}

modules = {

    application {

        dependsOn('bootstrap-responsive-css')
        dependsOn('bootstrap-modal')

        resource url: 'css/app.css'

        resource url: 'js/angular.min.js'
        resource url: 'js/angular-resource.min.js'

        dependsOn 'jquery, jquery-ui'

        allJsUnder('/js/ng/ui').each {
            resource url: it
        }

        resource url: 'js/ng/module.js'

        allJsUnder('/js/ng/services').each {
            resource url: it
        }
        allJsUnder('/js/ng/controllers').each {
            resource url: it
        }
        
    }
}