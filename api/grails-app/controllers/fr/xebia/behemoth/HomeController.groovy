package fr.xebia.behemoth

class HomeController {

    def allUsersActionsService

    def index() {
        println 'Inside index'
        def userEvent = new AllUsersEvent()
        userEvent.user = 'User'
        userEvent.action = 'new Song'
        userEvent.actionType = 'new'
        allUsersActionsService.registerEvent(userEvent)
        render(view: '/index')
    }
}
