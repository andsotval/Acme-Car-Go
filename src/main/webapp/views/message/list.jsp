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

<!-- Listing Messages -->

<display:table pagesize="10" class="displaytag" name="messages"
 requestURI="${requestURI}" id="row">
	
	<!-- Attributes -->

	<spring:message code="message.title" var="ctitle" />
	<display:column property="title" title="${ctitle}"/>

	<spring:message code="message.text" var="ctext" />
	<display:column property="text" title="${ctext}"/>

	<spring:message code="message.moment" var="cmoment" />
	<display:column property="moment" title="${cmoment}"/>
	
	<spring:message code="message.attachements" var="cattachements" />
	<display:column property="attachements" title="${cattachements}"/>
		
</display:table>