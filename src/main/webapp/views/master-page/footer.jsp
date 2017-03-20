<%--
 * footer.jsp
 *
 * Copyright (C) 2017 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1"	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<jsp:useBean id="date" class="java.util.Date" />

<hr />

<p><b>Copyright &copy; <fmt:formatDate value="${date}" pattern="yyyy" /> Acme Bnb Co., Inc.</b>&nbsp;|&nbsp;
<a href="welcome/privacy.do#cookies"><spring:message code = "master.page.cookies" /></a>&nbsp;|&nbsp;
<a href="welcome/privacy.do"><spring:message code = "master.page.privacy" /></a>&nbsp;|&nbsp;
<a href="welcome/terms.do"><spring:message code = "master.page.terms" /></a></p>
