<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href=<c:url value="/resources/css/home.css"/>
	rel="stylesheet" />
<link type="text/css" href=<c:url value="/resources/css/form.css"/>
	rel="stylesheet" />
<link type="text/css" href=<c:url value="/resources/css/menu.css"/>
	rel="stylesheet" />

<script src="<c:url value="/resources/js/jquery.min.js" />"
	type="text/javascript"> </script>
<script src="<c:url value="/resources/js/myjs.js" />"
	type="text/javascript"> </script>
<script src="<c:url value="/resources/js/modernizr.js" />"
	type="text/javascript"> </script>
<script src="<c:url value="/resources/js/prefixfree.min.js" />"
	type="text/javascript"> </script>

<title><spring:message code="title.product" /></title>
</head>
<body>
	<c:url var="refUrl" value="/category/" />

	<!-- Menu -->
	<ul class="menu cf">
		<li><a href="/vev"><spring:message code="label.main" /></a></li>
		<li><a href="#"><spring:message code="label.menu" /></a>
			<ul class="submenu">
				<li><a href="${refUrl}" class="s1"><spring:message
							code="title.category" /></a></li>
			</ul></li>
		<li><a href="${aboutUrl}" class="s1"><spring:message
					code="title.about" /></a></li>
	</ul>