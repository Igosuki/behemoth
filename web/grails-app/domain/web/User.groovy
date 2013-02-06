package web

class User {

    static mapWith = "mongo"

    transient springSecurityService

    String username
    String password
    String email
    String town
    boolean enabled
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    // Song specifics
    def favouriteArtists = [] as Set
    def badges = [:]

    static constraints = {
        username blank: false, unique: true
        password blank: false
    }

    static mapping = {
        password column: '`password`'
    }

    Set<Role> getAuthorities() {
        UserRole.findAllByUser(this).collect { it.role } as Set
    }

    def beforeInsert() {
        encodePassword()
    }

    def beforeUpdate() {
        if (isDirty('password')) {
            encodePassword()
        }
    }

    protected void encodePassword() {
        password = springSecurityService.encodePassword(password)
    }
}
