<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<portlet:defineObjects />
<portlet:actionURL var="sendForm">
</portlet:actionURL>
<c:set var="ns">
	<portlet:namespace />
</c:set>
<aui:form method="POST" action="${sendForm}" name="anketa">
	<aui:input name="birthday" label="DFROM" value="${anketa.birthday}"
		bean="anketa">
		<aui:validator name="required" />
		<aui:validator name="custom" errorMessage="Формат даты дд-мм-гггг">
						function (val, fieldNode, ruleValue) {
							var result = false;
							
							if (val == '' || val.search(/^\d{2}-\d{2}-\d{4}$/)!=-1){
								result = true;
							}
							return result;
						}
		</aui:validator>
	</aui:input>
	<aui:input name="birthday" label="DTO" value="${anketa.birthday}"
		bean="anketa">
		<aui:validator name="required" />
		<aui:validator name="custom" errorMessage="Формат даты дд-мм-гггг">
						function (val, fieldNode, ruleValue) {
							var result = false;
							
							if (val == '' || val.search(/^\d{2}-\d{2}-\d{4}$/)!=-1){
								result = true;
							}
							return result;
						}
		</aui:validator>
	</aui:input>
	<aui:select name="orgId" class="chosen" label="Организация">
		<aui:option value=""></aui:option>
		<c:forEach var="i" items="${orgList}">
			<aui:option value="${i.id}" label="${i.name}"
				selected="${i.id==anketa.orgId}"></aui:option>
		</c:forEach>
	</aui:select>
	<br />


	<aui:button-row>
		<div align="left">
			<aui:button type="submit" value="Показать данные" />

		</div>
	</aui:button-row>
	<table>
		<tr>
			<td>УНП</td>
			<td><input id="unpInputId" type="text" class='simpleInput' /></td>
			<td><a id="checkBtn" class="btn btn-primary">Проверить</a></td>
		</tr>
	</table>
</aui:form>
<div id="notFoundResult" style="display: none">
	<p>Организация не включена в реестр АНО</p>
</div>


	<table id="ano-table"
		class="table table-bordered table-striped table-hover">	
			<thead>
				<tr>
					<td>ID</td>
					<td>Name</td>
					<td>Company</td>
					<td>Start Date</td>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</table>
<portlet:resourceURL var="checkUnpUrl"></portlet:resourceURL>
<aui:script>
$(document).ready(function() {
	
	
	$('#checkBtn').click(function(){
		$('#notFoundResult').css('display','none');
		$('#foundResult').css('display','none');
		var data = {"unp":$('#unpInputId').val()};  		  	
		$.ajax({
		   url: '${checkUnpUrl}',
		   dataType: 'json',
		   data: data,
		   success: function(data) { LoadCustomers(data); }
		 });
		 
		
		
	});
});

function LoadCustomers(data) {	
	var tbody = $("#ano-table > tbody").html("");
		for ( var i in data) {
			var customer = data[i];			
			var rowText = "<tr><td>" + customer['org']['nameRus'] + "</td><td>" + 1
					+ "</td><td>" + 1 + "</td><td>" + 1 + "</td></tr>";
			$(rowText).appendTo(tbody);			
		}
	}
</aui:script>

