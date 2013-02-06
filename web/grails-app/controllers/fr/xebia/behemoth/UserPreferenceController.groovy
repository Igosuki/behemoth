package fr.xebia.behemoth

import grails.converters.JSON
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
        def user = User.get(principal.id)

        new UserLike(artistId: artist.id, userId: user.id).save()

        allUsersActionsService.registerEvent(new AllUsersEvent(springSecurityService.currentUser.username, "a ajouté "+ artist.name, "ARTIST"))



        springSecurityService.currentUser.favouriteArtists << artist

        def newBadges = badgeService.checkBadgeOnAdd(artist);

        springSecurityService.currentUser.save()

        render (status: 200)
    }

    def myLikes() {
        def user = User.get(springSecurityService.principal.id)
        def myLikes = UserLike.findByUserId("${user.id}")

        def myArtists = myLikes.collect {
            Artist.get(it.artistId)
        }

render myArtists as JSON
    }


}
