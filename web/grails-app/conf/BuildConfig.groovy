grails.servlet.version = "3.0" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
grails.project.war.file = "target/${appName}-${appVersion}.war"

// uncomment (and adjust settings) to fork the JVM to isolate classpaths
//grails.project.fork = [
//   run: [maxMemory:1024, minMemory:64, debug:false, maxPerm:256]
//]

grails.project.repos.default = "snapshots"
grails.project.dependency.distribution = {
    remoteRepository(id: "releases", url: "http://behemot-ci.aws.xebiatechevent.info:8081/nexus/content/repositories/releases/") {
        authentication username : "admin", password : "admin123"
    }  
}
grails.project.dependency.distribution = {
    remoteRepository(id: "snapshots", url: "http://behemot-ci.aws.xebiatechevent.info:8081/nexus/content/repositories/snapshots/") {
        authentication username : "admin", password : "admin123"
    }
}

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // for logback when plugin fixed
        //excludes 'grails-plugin-log4j'
    }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve
    legacyResolve false // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility

    repositories {
        inherits true // Whether to inherit repository definitions from plugins

        grailsPlugins()
        grailsHome()
        grailsCentral()

        mavenLocal()
        mavenCentral()

        // uncomment these (or add new ones) to enable remote dependency resolution from public Maven repositories
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }

    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes e.g.

        // for logback when plugin fixed
        //compile 'org.grails.plugins:logback:0.1.1'
        build("org.apache.maven:maven-ant-tasks:2.1.0")
        //runtime 'mysql:mysql-connector-java:5.1.20'
    }

    plugins {
        //runtime ":mongodb:1.1.0.GA"
        runtime ':hibernate:2.2.0'
        runtime ":jquery:1.8.3"
        runtime ":resources:1.1.6"
        compile ':mongodb:1.1.0.GA'

        // Uncomment these (or add new ones) to enable additional resources capabilities
        //runtime ":zipped-resources:1.0"
        //runtime ":cached-resources:1.0"
        //runtime ":yui-minify-resources:0.1.4"

        build(":release:2.2.0") {
            exclude 'maven-ant-tasks'
        }

        build ":tomcat:$grailsVersion"

        compile ":twitter-bootstrap:2.2.2"
        runtime ":database-migration:1.2.1"

        compile ':cache:1.0.1'
    }
}
