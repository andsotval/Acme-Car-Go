<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<form:form action="offerOrRequest/customer/register.do" modelAttribute="offerOrRequest">

	<form:hidden path="id" />
	<form:hidden path="version" />
	<form:hidden path="comments" />
	<form:hidden path="offer"/>
	<form:hidden path="applications"/>
	<form:hidden path="isOffer"/>
	<form:hidden path="isBan"/>

	<form:label path="title">
		<spring:message code="offerOrRequest.title" />:
	</form:label>
	<form:input path="title" />
	<form:errors cssClass="error" path="title" />
	<br />
	
	<form:label path="description">
		<spring:message code="offerOrRequest.description" />:
	</form:label>
	<form:input path="description" />
	<form:errors cssClass="error" path="description" />
	<br />
	
	<form:label path="moment">
		<spring:message code="offerOrRequest.moment" />:
	</form:label>
	<form:input path="moment" />
	<form:errors cssClass="error" path="moment" />
	<br />

	<form:label path="originPlace">
		<spring:message code="offerOrRequest.originPlace" />:
	</form:label>
	<form:input path="originPlace" />
	<form:errors cssClass="error" path="originPlace" />
	<br />
	
	<form:label path="sourcePlace">
		<spring:message code="offerOrRequest.sourcePlace" />:
	</form:label>
	<form:input path="sourcePlace" />
	<form:errors cssClass="error" path="sourcePlace" />
	<br />		
	
	<input type="submit" name="save"
		value="<spring:message code="customer.save" />" />&nbsp; 
	<input type="button" name="cancel"
		value="<spring:message code="customer.cancel" />"
		onclick="javascript: relativeRedir('/');" />
	<br />

</form:form>