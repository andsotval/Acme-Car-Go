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

<display:table pagesize="10" class="displaytag" name="customers"
 requestURI="${requestURI}" id="customer">
	
	<!-- Attributes -->

	<spring:message code="customer.fullName" var="cfullName" />
	<display:column property="fullName" title="${cfullName}"/>
	
	<spring:message code="customer.email" var="cemail" />
	<display:column property="email" title="${cemail}"/>
	
	<spring:message code="customer.phone" var="cphone" />
	<display:column property="phone" title="${cphone}"/>
	
	<security:authorize access="isAuthenticated()">
	<display:column>
		<a href="message/actor/register.do?actorId=<jstl:out value="${customer.id}"/>">
			<spring:message code="customer.message" />
		</a>
	</display:column>
	</security:authorize>
		
</display:table>