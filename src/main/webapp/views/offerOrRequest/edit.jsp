<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<form:form action="offerOrRequest/customer/register.do"
	modelAttribute="offerOrRequest">

	<form:hidden path="id" />
	<form:hidden path="version" />
	<form:hidden path="comments" />
	<form:hidden path="offer" />
	<form:hidden path="applications" />
	<form:hidden path="isOffer" />
	<form:hidden path="isBan" />

	<acme:textbox code="offerOrRequest.title" path="title" />
	<acme:textbox code="offerOrRequest.description" path="description" />
	<acme:textbox code="offerOrRequest.moment" path="moment" />
	<acme:textbox code="offerOrRequest.originPlace" path="originPlace" />
	<acme:textbox code="offerOrRequest.sourcePlace" path="sourcePlace" />
	
	<acme:submit code="offerOrRequest.save" name="save" />
	<acme:cancel code="offerOrRequest.cancel" url="/"/>

</form:form>