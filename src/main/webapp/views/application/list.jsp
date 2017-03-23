<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<!-- Listing Appication -->

<display:table pagesize="10" class="displaytag" name="applications"
 requestURI="${requestURI}" id="row">
	
	<!-- Attributes -->

	<spring:message code="application.application" var="capplication" />
	<display:column property="application" title="${capplication}"/>
	
	<spring:message code="application.customer" var="ccustomer" />
	<display:column property="customer" title="${ccustomer}"/>
	
	<spring:message code="application.request" var="crequest" />
	<display:column property="request" title="${crequest}"/>

		
</display:table>