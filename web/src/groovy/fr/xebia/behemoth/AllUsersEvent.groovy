package fr.xebia.behemoth

import grails.converters.JSON


class AllUsersEvent {

    def user
    def action
    def actionType

    private String createMessage() {
        return new JSON( [user : user, action : action, time : new Date().time, actionType : actionType] )
    }
}
