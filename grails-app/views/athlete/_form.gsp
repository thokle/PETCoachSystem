<%@ page import="petcoachsystem.Athlete" %>



<div class="fieldcontain ${hasErrors(bean: athleteInstance, field: 'username', 'error')} required">
	<label for="username">
		<g:message code="athlete.username.label" default="Username" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="username" required="" value="${athleteInstance?.username}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: athleteInstance, field: 'password', 'error')} required">
	<label for="password">
		<g:message code="athlete.password.label" default="Password" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="password" required="" value="${athleteInstance?.password}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: athleteInstance, field: 'accountExpired', 'error')} ">
	<label for="accountExpired">
		<g:message code="athlete.accountExpired.label" default="Account Expired" />
		
	</label>
	<g:checkBox name="accountExpired" value="${athleteInstance?.accountExpired}" />
</div>

<div class="fieldcontain ${hasErrors(bean: athleteInstance, field: 'accountLocked', 'error')} ">
	<label for="accountLocked">
		<g:message code="athlete.accountLocked.label" default="Account Locked" />
		
	</label>
	<g:checkBox name="accountLocked" value="${athleteInstance?.accountLocked}" />
</div>

<div class="fieldcontain ${hasErrors(bean: athleteInstance, field: 'athletes', 'error')} ">
	<label for="athletes">
		<g:message code="athlete.athletes.label" default="Athletes" />
		
	</label>
	<g:select name="athletes" from="${petcoachsystem.Athlete.list()}" multiple="multiple" optionKey="id" size="5" value="${athleteInstance?.athletes*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: athleteInstance, field: 'enabled', 'error')} ">
	<label for="enabled">
		<g:message code="athlete.enabled.label" default="Enabled" />
		
	</label>
	<g:checkBox name="enabled" value="${athleteInstance?.enabled}" />
</div>

<div class="fieldcontain ${hasErrors(bean: athleteInstance, field: 'firstname', 'error')} ">
	<label for="firstname">
		<g:message code="athlete.firstname.label" default="Firstname" />
		
	</label>
	<g:textField name="firstname" value="${athleteInstance?.firstname}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: athleteInstance, field: 'lastname', 'error')} ">
	<label for="lastname">
		<g:message code="athlete.lastname.label" default="Lastname" />
		
	</label>
	<g:textField name="lastname" value="${athleteInstance?.lastname}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: athleteInstance, field: 'passwordExpired', 'error')} ">
	<label for="passwordExpired">
		<g:message code="athlete.passwordExpired.label" default="Password Expired" />
		
	</label>
	<g:checkBox name="passwordExpired" value="${athleteInstance?.passwordExpired}" />
</div>

