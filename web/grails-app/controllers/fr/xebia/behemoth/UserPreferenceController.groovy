package fr.xebia.behemoth

class UserPreferenceController {

    def badgeService
    def springSecurityService
    def allUsersActionsService

    def listArtists() {
        def result  = springSecurityService.currentUser.favouriteArtists
        // TODO render page
    }

    def addArtists(Artist artist) {
        allUsersActionsService.registerEvent(new AllUsersEvent(springSecurityService.currentUser.username, "a ajouté "+ artist.name))
        springSecurityService.currentUser.favouriteArtists << artist
        def newBadges = badgeService.checkBadgeOnAdd(artist);
        // TODO save user
        // TODO render page
    }


}
