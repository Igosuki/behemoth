<%@ page import="web.Author" %>



<div class="fieldcontain ${hasErrors(bean: authorInstance, field: 'birthday', 'error')} required">
	<label for="birthday">
		<g:message code="author.birthday.label" default="Birthday" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="birthday" precision="day"  value="${authorInstance?.birthday}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: authorInstance, field: 'firstName', 'error')} ">
	<label for="firstName">
		<g:message code="author.firstName.label" default="First Name" />
		
	</label>
	<g:textField name="firstName" value="${authorInstance?.firstName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: authorInstance, field: 'lastName', 'error')} ">
	<label for="lastName">
		<g:message code="author.lastName.label" default="Last Name" />
		
	</label>
	<g:textField name="lastName" value="${authorInstance?.lastName}"/>
</div>

