<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<form:form action="comment/${offerOrRequest.id}/registerOfferOrRequest.do"
	modelAttribute="comment">
	
	<acme:textbox code="comment.title" path="title"/>		
	<acme:textbox code="comment.description" path="description"/>
	<acme:textbox code="comment.stars" path="stars"/>

	<acme:submit code="comment.save" name="save"/>
	<acme:cancel code="comment.cancel" url="/"/>

</form:form>