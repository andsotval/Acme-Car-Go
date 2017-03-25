<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<form:form action="comment/register.do"
	modelAttribute="comment">

	<form:hidden path="id" />
	<form:hidden path="version" />
	<form:hidden path="isBan" />
	<form:hidden path="moment" />
	<form:hidden path="actor" />
	<form:hidden path="offerOrRequest" />

	<form:label path="title">
		<spring:message code="comment.title" />:
	</form:label>
	<form:input path="title" />
	<form:errors cssClass="error" path="title" />
	<br />

	<form:label path="description">
		<spring:message code="comment.description" />:
	</form:label>
	<form:input path="description" />
	<form:errors cssClass="error" path="description" />
	<br />
		<form:label path="stars">
		<spring:message code="comment.stars" />:
	</form:label>
	<form:input path="stars" />
	<form:errors cssClass="error" path="stars" />
	<br />

	<input type="submit" name="save"
		value="<spring:message code="comment.save" />" />&nbsp; 
	<input type="button" name="cancel"
		value="<spring:message code="comment.cancel" />"
		onclick="javascript: relativeRedir('/');" />
	<br />

</form:form>
