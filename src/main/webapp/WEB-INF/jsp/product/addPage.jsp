<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../head.jsp"%>

<c:url var="backUrl" value="/" />
<c:url var="saveUrl" value="/add" />

<div class="d1">
	<div style="position: absolute; margin-left: -60px; margin-top: -30px;">
		<a href="${backUrl}" class="s1"><spring:message code="label.back" /></a>
	</div>

	<h1>
		<spring:message code="title.addproduct" />
	</h1>

	<form:form modelAttribute="productAttribute" method="POST"
		action="${saveUrl}">
		<ul class="form-style-1">
			<li><form:label path="name">
					<spring:message code="label.name" />
					<span class="required">*</span>
				</form:label> 
				<form:input path="name" cssClass="field-long" /> 
				<form:errors path="name" cssClass="error" element="div" />
			</li>
			<li><form:label path="mark">
					<spring:message code="label.mark" />
					<span class="required">*</span>
				</form:label> 
				<form:input path="mark" cssClass="field-long" /> 
				<form:errors path="mark" cssClass="error" element="div" />
			</li>
			<li><form:label path="amount">
					<spring:message code="label.amount" />
				</form:label> <form:input path="amount" cssClass="field-long number_dots" alt="000.00" /> 
				<form:errors path="amount" cssClass="error"	element="div" /></li>
			<li><form:label path="description">
					<spring:message code="label.description" />
				</form:label> 
				<form:textarea path="description" cssClass="field-long field-textarea" />
			</li>
			<li>
				<div style="position: absolute;">
					<input type="submit" value="<spring:message code="label.save" />" />
				</div>
				<div align="right">
					<input type="reset" value="<spring:message code="label.clear" />" />
				</div>
			</li>
		</ul>
	</form:form>
</div>

<%@include file="../footer.jsp"%>