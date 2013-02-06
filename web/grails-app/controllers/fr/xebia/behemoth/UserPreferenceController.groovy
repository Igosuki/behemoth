package fr.xebia.behemoth

import web.User

class UserPreferenceController {

    def badgeService
    def springSecurityService
    def allUsersActionsService

    def listArtists() {
        def result  = springSecurityService.currentUser.favouriteArtists
        // TODO render page
    }

    def likeArtist() {

        String id = params.id

        println "ID = $id"

        Artist artist = Artist.get(id)

        if (!artist) {
            return render(status: 404)
        }

        def principal = springSecurityService.getPrincipal()
        println "principal = $principal"

        new UserLike(artist: artist, user: principal).save()

        allUsersActionsService.registerEvent(new AllUsersEvent(springSecurityService.currentUser.username, "a ajouté "+ artist.name, "ARTIST"))



        springSecurityService.currentUser.favouriteArtists << artist

        def newBadges = badgeService.checkBadgeOnAdd(artist);

        springSecurityService.currentUser.save()

        render (status: 200)
    }


}
