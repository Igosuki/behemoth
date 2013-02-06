package fr.xebia.behemoth

class BadgeService {

    def springSecurityService


    def checkBadgeOnAdd(Artist artist) {
        // Get artist term weight > 0.9
        // Find in user all similar artists
        // Find if badge check
        // Add Badge
        def newBadges = []

        artist.terms.each { term ->
            if (term.freq > 0.9) {
               int badgeCount = springSecurityService.currentUser.badges.get(term.name)?:0

               if (badgeCount==2){
                   // AddNewBadge
               }
                badgeCount += 1
                springSecurityService.currentUser.badges.put(term.name, badgeCount)
            }
            newBadges << term.name
        }

        return newBadges

        // Metal
        // 80
        // Rap
        // Reggae
        // RnB
        // Rock
        // Rookie
        // Soul
        // Classic
        // Comedie
        // Irrecuperable
        // DiscoFan


    }
}
