<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<form:form action="customer/register.do" modelAttribute="customer">

	<form:hidden path="id" />
	<form:hidden path="version" />
	<form:hidden path="userAccount" />
	<form:hidden path="receivers" />
	<form:hidden path="senders" />
	<form:hidden path="offers" />
	<form:hidden path="applications" />
	<form:hidden path="comments" />

	<form:label path="fullName">
		<spring:message code="customer.fullName" />:
	</form:label>
	<form:input path="fullName" />
	<form:errors cssClass="error" path="fullName" />
	<br />
	
	<form:label path="email">
		<spring:message code="customer.email" />:
	</form:label>
	<form:input path="email" />
	<form:errors cssClass="error" path="email" />
	<br />
	
	<form:label path="phone">
		<spring:message code="customer.phone" />:
	</form:label>
	<form:input path="phone" />
	<form:errors cssClass="error" path="phone" />
	<br />	
	
	<input type="submit" name="save"
		value="<spring:message code="customer.save" />" />&nbsp; 
	<input type="button" name="cancel"
		value="<spring:message code="customer.cancel" />"
		onclick="javascript: relativeRedir('/');" />
	<br />

</form:form>
