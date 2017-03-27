<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<form:form action="message/actor/register.do" modelAttribute="messageActor">

	<form:hidden path="id" />
	<form:hidden path="version" />
	<form:hidden path="attachements" />
	<form:hidden path="receiver"/>
	<form:hidden path="sender"/>
	<form:hidden path="moment"/>

	<acme:textbox code="message.title" path="title"/>	
	<acme:textbox code="message.text" path="text"/>
	
	<acme:submit code="message.save" name="save"/>
	<input type="button" name="cancel"
		value="<spring:message code="customer.cancel" />"
		onclick="javascript: relativeRedir('/');" />

</form:form>