package fr.xebia.behemoth

import grails.converters.JSON


class AllUsersEvent {

    def user
    def action
    def actionType

    AllUsersEvent(user, action, actionType) {
        this.user = user
        this.action = action
        this.actionType = actionType
    }

    private String createMessage() {
        return new JSON( [user : user, action : action, time : new Date().time, actionType : actionType] )
    }
}
