package fr.xebia.behemoth

class UserPreferenceController {

    def badgeService

    def listArtists() {
        // return user.artists
    }

    def addArtists(Artist artist) {
        def newBadges = badgeService.checkBadgeOnAdd(artist);
    }


}
