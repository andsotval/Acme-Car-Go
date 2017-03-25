<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<form:form action="customer/register.do" modelAttribute="customer">

	<form:hidden path="id" />
	<form:hidden path="version" />
	<form:hidden path="userAccount.authorities" />
	<form:hidden path="receivers" />
	<form:hidden path="senders" />
	<form:hidden path="offers" />
	<form:hidden path="applications" />
	<form:hidden path="comments" />
	
	<acme:textbox code="customer.username" path="userAccount.username"/>
	<acme:password code="customer.password" path="userAccount.password"/>		
	<acme:textbox code="customer.fullName" path="fullName"/>	
	<acme:textbox code="customer.email" path="email"/>	
	<acme:textbox code="customer.phone" path="phone"/>
	
	<acme:submit code="customer.save" name="save"/>
	<acme:submit code="customer.cancel" name="cancel"/>

</form:form>
