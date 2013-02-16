<%@ page import="fr.xebia.behemoth.Artist" %>



<div class="fieldcontain ${hasErrors(bean: artistInstance, field: 'familiarity', 'error')} ">
	<label for="familiarity">
		<g:message code="artist.familiarity.label" default="Familiarity" />
		
	</label>
	<g:field type="number" name="familiarity" value="${artistInstance.familiarity}" />
</div>

<div class="fieldcontain ${hasErrors(bean: artistInstance, field: 'hotness', 'error')} ">
	<label for="hotness">
		<g:message code="artist.hotness.label" default="Hotness" />
		
	</label>
	<g:field type="number" name="hotness" value="${artistInstance.hotness}" />
</div>

<div class="fieldcontain ${hasErrors(bean: artistInstance, field: 'latitude', 'error')} ">
	<label for="latitude">
		<g:message code="artist.latitude.label" default="Latitude" />
		
	</label>
	<g:field type="number" name="latitude" value="${artistInstance.latitude}" />
</div>

<div class="fieldcontain ${hasErrors(bean: artistInstance, field: 'location', 'error')} ">
	<label for="location">
		<g:message code="artist.location.label" default="Location" />
		
	</label>
	<g:textField name="location" value="${artistInstance?.location}" />
</div>

<div class="fieldcontain ${hasErrors(bean: artistInstance, field: 'longitude', 'error')} ">
	<label for="longitude">
		<g:message code="artist.longitude.label" default="Longitude" />
		
	</label>
	<g:field type="number" name="longitude" value="${artistInstance.longitude}" />
</div>

<div class="fieldcontain ${hasErrors(bean: artistInstance, field: 'mbid', 'error')} ">
	<label for="mbid">
		<g:message code="artist.mbid.label" default="Mbid" />
		
	</label>
	<g:textField name="mbid" value="${artistInstance?.mbid}" />
</div>

<div class="fieldcontain ${hasErrors(bean: artistInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="artist.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${artistInstance?.name}" />
</div>

<div class="fieldcontain ${hasErrors(bean: artistInstance, field: 'sevenDigitalId', 'error')} ">
	<label for="sevenDigitalId">
		<g:message code="artist.sevenDigitalId.label" default="Seven Digital Id" />
		
	</label>
	<g:textField name="sevenDigitalId" value="${artistInstance?.sevenDigitalId}" />
</div>

