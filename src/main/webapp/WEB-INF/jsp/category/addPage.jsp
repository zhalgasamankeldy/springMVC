<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../head.jsp"%>

<c:url var="backUrl" value="/category" />
<c:url var="saveUrl" value="/category/add" />

<div class="d1">
	<div style="position: absolute; margin-left: -60px; margin-top: -30px;">
		<a href="${backUrl}" class="s1"><spring:message code="label.back" /></a>
	</div>

	<h1>
		<spring:message code="title.addcategory" />
	</h1>

	<form:form modelAttribute="categoryAttribute" method="POST"
		action="${saveUrl}">
		<ul class="form-style-1">
			<li><form:label path="name">
					<spring:message code="label.name" />
					<span class="required">*</span>
				</form:label> 
				<form:input path="name" cssClass="field-long" /> 
				<form:errors path="name" cssClass="error" element="div" />
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