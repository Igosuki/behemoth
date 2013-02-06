package web

class Role {

    static mapWith = "mongo"

    String authority

    static mapping = {
        cache true
    }

    static constraints = {
        authority blank: false, unique: true
    }
}
