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
<script type="text/javascript">
	function search() {
		var singleKeyword = document.getElementById("search").value;
		window.location.replace('customer/offerOrRequest/search.do?text=' + singleKeyword);
	}
</script>

<div>
	<input type="text" name="search" id="search"> <input
		type="button" name="searchItem"
		value="<spring:message code="offerOrRequest.search" />"
		onclick="javascript: search();" />


</div>

<!-- Listing OfferOrRequest -->

<display:table pagesize="10" class="displaytag" name="offerOrRequests"
	requestURI="${requestURI}" id="offerOrRequest">

	<!-- Attributes -->

	<spring:message code="offerOrRequest.title" var="ctitle" />
	<display:column property="title" title="${ctitle}" />

	<spring:message code="offerOrRequest.description" var="cdescription" />
	<display:column property="description" title="${cdescription}" />

	<spring:message code="offerOrRequest.moment" var="cmoment" />
	<display:column property="moment" title="${cmoment}" />

	<spring:message code="offerOrRequest.originPlace" var="coriginPlace" />
	<display:column property="originPlace" title="${coriginPlace}" />

	<spring:message code="offerOrRequest.sourcePlace" var="csourcePlace" />
	<display:column property="sourcePlace" title="${csourcePlace}" />

	<spring:message code="offerOrRequest.isOffer" var="cisOffer" />
	<display:column property="isOffer" title="${cisOffer}" />

	<spring:message code="offerOrRequest.isBan" var="cisBan" />
	<display:column property="isBan" title="${cisBan}" />

	<spring:message code="offerOrRequest.comments" var="ccomments" />
	<display:column property="comments" title="${ccomments}" />
	
	<security:authorize access="hasRole('CUSTOMER')">
	<display:column>
		<a href="offerOrRequest/customer/apply.do?offerOrRequestId=${offerOrRequest.id}">
			<spring:message code="offerOrRequest.apply" />
		</a>
	</display:column>
	</security:authorize>
	
	<security:authorize access="hasRole('ADMIN')">
	<display:column>
		<a href="offerOrRequest/customer/ban.do?offerOrRequestId=${offerOrRequest.id}">
			<spring:message code="offerOrRequest.ban" />
		</a>
	</display:column>
	</security:authorize>
	<security:authorize access="isAuthenticated()">
	<display:column>
		<a href="comment/registerByOfferOrRequest.do?offerOrRequestId=${offerOrRequest.id}">
			<spring:message code="offerOrRequest.comment" />
		</a>
	</display:column>
	</security:authorize>	

</display:table>