package web

class IndexController {

    def index(String domainClass) {
        render(view: "/$domainClass/index", model : [domainClass: domainClass])
    }
}
