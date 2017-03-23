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

<!-- Listing OfferOrRequest -->

<display:table pagesize="10" class="displaytag" name="offerOrRequests"
 requestURI="${requestURI}" id="row">
	
	<!-- Attributes -->

	<spring:message code="offerOrRequest.title" var="ctitle" />
	<display:column property="title" title="${ctitle}"/>

	<spring:message code="offerOrRequest.description" var="cdescription" />
	<display:column property="description" title="${cdescription}"/>

	<spring:message code="offerOrRequest.moment" var="cmoment" />
	<display:column property="moment" title="${cmoment}"/>
	
	<spring:message code="offerOrRequest.originPlace" var="coriginPlace" />
	<display:column property="originPlace" title="${coriginPlace}"/>
	
	<spring:message code="offerOrRequest.sourcePlace" var="csourcePlace" />
	<display:column property="sourcePlace" title="${csourcePlace}"/>
	
	<spring:message code="offerOrRequest.isOffer" var="cisOffer" />
	<display:column property="isOffer" title="${cisOffer}"/>

	<spring:message code="offerOrRequest.isBan" var="cisBan" />
	<display:column property="isBan" title="${cisBan}"/>

	<spring:message code="offerOrRequest.comments" var="ccomments" />
	<display:column property="comments" title="${ccomments}"/>
		
</display:table>