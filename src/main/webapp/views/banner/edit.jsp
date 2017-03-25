<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<form:form action="banner/administrator/register.do" modelAttribute="banner">

	<form:hidden path="id" />
	<form:hidden path="version" />

	<form:label path="url">
		<spring:message code="banner.url" />:
	</form:label>
	<form:input path="url" />
	<form:errors cssClass="error" path="url" />
	<br />
	
	<input type="submit" name="save"
		value="<spring:message code="banner.save" />" />&nbsp; 
	<input type="button" name="cancel"
		value="<spring:message code="banner.cancel" />"
		onclick="javascript: relativeRedir('/');" />
	<br />

</form:form>
