/**
 * This module defines the resource mappings required by Angular JS to map to a
 * standard Grails CRUD URL scheme that uses `"/$controller/$action?/$id?"`.
 */
angular.module('grailsService', ['ngResource']).factory('Grails', function($resource) {

	return $resource(CTX + '/:domain/:id', {id: '@id'}, {
		list: {method: 'GET', isArray: true},
		get: {method: 'GET', params: {}},
		save: {method: 'POST', params: {}},
		update: {method: 'PUT', params: {}},
		delete: {method: 'DELETE', params: {}}
	});
});
