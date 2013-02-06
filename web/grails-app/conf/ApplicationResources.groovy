import grails.util.GrailsUtil
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

def min = GrailsUtil.isDevelopmentEnv() ? '' : '.min'

modules = {

    login {
        dependsOn('bootstrap-responsive-css')

        resource url: 'css/app.css'
    }
    application {

        dependsOn('bootstrap-responsive-css')
        dependsOn('bootstrap-modal')
        dependsOn('atmosphere')
        dependsOn 'jquery, jquery-ui'

        resource url: 'css/app.css'

        resource url: "js/angular${min}.js"
        resource url: "js/angular-resource${min}.js"
    }

    'angular-ui' {

        dependsOn 'application'

        resource url : "/js/ng/ui/angular-ui-ieshiv${min}.js"
        resource url : "/js/ng/ui/angular-ui${min}.js"
        resource url : "/js/ng/ui/angular-ui${min}.css"
    }

    'angular-resources' {

        dependsOn 'application'

        resource url: 'js/ng/module.js'

        resource url : "/js/ng/utils/angular-cookies${min}.js"

        allJsUnder('/js/ng/services').each {
            resource url: it
        }
        allJsUnder('/js/ng/controllers').each {
            resource url: it
        }

        //Scaffolding
        resource url: 'js/ng/scaffolding.js'
    }

    'angular_fr' {
        dependsOn 'application'

        resource url : "js/ng/i18n/angular_fr.js"
    }

    'angular_en' {
        dependsOn 'application'

        resource url : "js/ng/i18n/angular_en.js"
    }
}