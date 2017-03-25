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

<display:table pagesize="10" class="displaytag" name="comments"
 requestURI="${requestURI}" id="comment">
	
	<!-- Attributes -->

	<spring:message code="comment.title" var="ctitle" />
	<display:column property="title" title="${ctitle}"/>
	
	<spring:message code="comment.description" var="cdescription" />
	<display:column property="description" title="${cdescription}"/>
	
	<spring:message code="comment.moment" var="cmoment" />
	<display:column property="moment" title="${cmoment}"/>
	
	<spring:message code="comment.stars" var="cstars" />
	<display:column property="stars" title="${cstars}"/>

		
</display:table>