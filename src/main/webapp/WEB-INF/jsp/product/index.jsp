<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../head.jsp"%>

<c:url var="mainUrl" value="/" />
<c:url var="addUrl" value="add" />

<!-- Body -->
<div class="d1">
	<h1>
		<spring:message code="title.product" />
	</h1>

	<form:form method="POST" action="${mainUrl}">
		<table align="center" style="border: none;">
			<tr>
				<th style="width: 40%; border: none;">
					<div style="position: relative;">
						<a href="${addUrl}" class="button button1"><spring:message
								code="label.add" /></a>
					</div>
				</th>
				<th style="width: 60%; border: none;">
					<ul class="form-style-1">
						<li><label><spring:message code="label.filter" />&nbsp;-&nbsp;<span
								class="required" style="font-size: 9pt;"><spring:message
										code="label.name" /></span></label> <input type="text" id="filter"
							name="filter" value="${filter}"/> &nbsp;-&nbsp; <input type="submit"
							value="<spring:message code="label.choose" />" /></li>
					</ul>
				</th>
			</tr>
		</table>
		<table align="center">
			<thead>
				<tr>
					<th><spring:message code="label.name" /></th>
					<th><spring:message code="label.mark" /></th>
					<th><spring:message code="label.amount" /></th>
					<th><spring:message code="label.description" /></th>
					<th>&nbsp;</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${products}" var="product">
					<c:url var="editUrl" value="edit?id=${product.id}" />
					<c:url var="deleteUrl" value="delete?id=${product.id}" />
					<tr>
						<td><c:out value="${product.name}" /></td>
						<td><c:out value="${product.mark}" /></td>
						<td><c:out value="${product.amount}" /></td>
						<td><textarea rows="5" cols="25" readonly="readonly"
								class="field-long field-textarea">
								<c:out value="${product.description}" />
							</textarea></td>
						<td align="left">
							<a href="${editUrl}" class="s2">
								<spring:message	code="label.edit" />
							</a> 
							<a href="${deleteUrl}" class="s2"
								onclick="return show_alert();">
								<spring:message code="label.delete" />
							</a>
						</td>
					</tr>
				</c:forEach>
				<c:if test="${empty products}">
					<td colspan="6"><spring:message code="label.nodata" />.</td>
				</c:if>
			</tbody>
		</table>
	</form:form>
</div>

<%@include file="../footer.jsp"%>