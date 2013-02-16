
<%@ page import="fr.xebia.behemoth.Artist" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'artist.label', default: 'Artist')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-artist" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-artist" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list artist">
			
				<g:if test="${artistInstance?.familiarity}">
				<li class="fieldcontain">
					<span id="familiarity-label" class="property-label"><g:message code="artist.familiarity.label" default="Familiarity" /></span>
					
						<span class="property-value" aria-labelledby="familiarity-label"><g:fieldValue bean="${artistInstance}" field="familiarity"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${artistInstance?.hotness}">
				<li class="fieldcontain">
					<span id="hotness-label" class="property-label"><g:message code="artist.hotness.label" default="Hotness" /></span>
					
						<span class="property-value" aria-labelledby="hotness-label"><g:fieldValue bean="${artistInstance}" field="hotness"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${artistInstance?.latitude}">
				<li class="fieldcontain">
					<span id="latitude-label" class="property-label"><g:message code="artist.latitude.label" default="Latitude" /></span>
					
						<span class="property-value" aria-labelledby="latitude-label"><g:fieldValue bean="${artistInstance}" field="latitude"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${artistInstance?.location}">
				<li class="fieldcontain">
					<span id="location-label" class="property-label"><g:message code="artist.location.label" default="Location" /></span>
					
						<span class="property-value" aria-labelledby="location-label"><g:fieldValue bean="${artistInstance}" field="location"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${artistInstance?.longitude}">
				<li class="fieldcontain">
					<span id="longitude-label" class="property-label"><g:message code="artist.longitude.label" default="Longitude" /></span>
					
						<span class="property-value" aria-labelledby="longitude-label"><g:fieldValue bean="${artistInstance}" field="longitude"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${artistInstance?.mbid}">
				<li class="fieldcontain">
					<span id="mbid-label" class="property-label"><g:message code="artist.mbid.label" default="Mbid" /></span>
					
						<span class="property-value" aria-labelledby="mbid-label"><g:fieldValue bean="${artistInstance}" field="mbid"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${artistInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="artist.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${artistInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${artistInstance?.sevenDigitalId}">
				<li class="fieldcontain">
					<span id="sevenDigitalId-label" class="property-label"><g:message code="artist.sevenDigitalId.label" default="Seven Digital Id" /></span>
					
						<span class="property-value" aria-labelledby="sevenDigitalId-label"><g:fieldValue bean="${artistInstance}" field="sevenDigitalId"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${artistInstance?.id}" />
					<g:link class="edit" action="edit" id="${artistInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
