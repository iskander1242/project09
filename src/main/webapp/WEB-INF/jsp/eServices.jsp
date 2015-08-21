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
	<aui:input name="birthday" label="DTO"  value="${anketa.birthday}"
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
	<aui:select name="orgId" class="chosen" label="Организация" onchange="showTeams(this.value);">
		<aui:option value=""></aui:option>
		<c:forEach var="i" items="${servicesList}">
			<aui:option value="${i.id}" label="${i.name}"
				selected="${i.id==anketa.orgId}"></aui:option>
		</c:forEach>
	</aui:select>
	
	
	
	<br/>	
   <table>
		<tr>		
			<td><a id="checkBtn" class="btn btn-primary">Данные по услуге</a></td>
			<td><input class="wert" type="button" onclick="asd();">1111</input></td>
		</tr>
	</table> 
	

</aui:form>
<div id="notFoundResult" style="display: none">
	<p>Данные не найдены</p>
</div>
    <h5>РАСПРЕДЕЛЕНИЕ РАБОТ ПРОШЕДШИХ ГОСУДАРСТВЕННУЮ РЕГИСТРАЦИЮ</h5>
	<table id="ano-table"
		class="table table-bordered table-striped table-hover">	
			<thead>
				<tr>
					<td>Источник финансирования научной деятельности</td>
					<td>Количество зарегистрированных работ</td>
					<td>Количество организаций-исполнителей</td>
					<td>Количество организаций-заказчиков</td>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</table>
<portlet:resourceURL var="checkUnpUrl"></portlet:resourceURL>
<aui:script>
$(document).ready(function() {	
	
	$('.disbl').attr('disabled', 'disabled');
	
	//$('.aui-field-select').on("change", showTeams);

	$('select').chosen({
		no_results_text : "Извините, нет совпадений!",
		placeholder_text_single : "Выберите из списка...",
		placeholder_text_multiple : "Выберите нужные пункты...",
		width : '90%'
	});
	
	$('#checkBtn').click(function(){
		alert(showTeams.res);
		$('#notFoundResult').css('display','none');
		$('#foundResult').css('display','none');
		//var data = {"unp":$('#unpInputId').val()}; 
		var data = {"unp": showTeams.res};
		$.ajax({
		   url: '${checkUnpUrl}',
		   dataType: 'json',
		   data: data,
		   success: function(data) { LoadCustomers(data); }
		 });
	});
}); 


function showTeams(param){
	                     
	showTeams.res = param;      
	                     
	              }

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

