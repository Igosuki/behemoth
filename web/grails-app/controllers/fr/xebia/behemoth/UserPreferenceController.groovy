package fr.xebia.behemoth

class UserPreferenceController {

    def badgeService
    def springSecurityService

    def listArtists() {
        return springSecurityService.currentUser.favouriteArtists
    }

    def addArtists(Artist artist) {
        springSecurityService.currentUser.favouriteArtists << artist
        def newBadges = badgeService.checkBadgeOnAdd(artist);
        // Save user
    }


}
