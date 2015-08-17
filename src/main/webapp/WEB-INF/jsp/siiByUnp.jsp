<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<portlet:defineObjects />
<portlet:renderURL var="serviceListUrl">
</portlet:renderURL>

<c:set var="ns">
	<portlet:namespace />
</c:set>

<a href="${serviceListUrl}">Вернуться к списку услуг</a>
<table>
	<tr>
		<td>УНП</td>
		<td><input id="unpInputId" type="text" class='simpleInput'/></td>
		<td><a id="checkBtn" class="btn btn-primary">Проверить</a></td>
	</tr>
</table>




<div id="notFoundResult" style="display:none">
	<p>Субъект не включен в реестр субъектов инновационной инфраструктуры</p>
</div>

<div id="foundResult" style="display:none">
	<table id="sii-table" class="table table-bordered table-striped table-hover">
		<thead>
			<tr>
				<th>Наименование</th>
				<th>Тип</th>
				<th>Город</th>
				<th>Адрес</th>
				<th>Описание деятельности</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td class="col-md-3 span3" id="td_name"></td>
				<td class="col-md-2 span2" id="td_type"></td>
				<td class="col-md-2 span2" id="td_city"></td>
				<td class="col-md-2 span2" id="td_address"></td>
				<td class="col-md-3 span3" id="td_description"></td>
			</tr>
		</tbody>
	</table>
</div>
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
		   success: function(result){
		   				if (result){
		   					$('#td_name').html(result['subject']['nameRus']);
		   					$('#td_type').html(result['siiType']['name']);
		   					$('#td_city').html(result['subject']['city']);
		   					$('#td_address').html(result['subject']['addressRus']);
		   					$('#td_description').html(result['subject']['description']);
		   					$('#foundResult').css('display','block');
		   				}else{
		   					$('#notFoundResult').css('display','block');
		   				}
		   				
		   			}
		 });
		 
		
		
	});
});
</aui:script>