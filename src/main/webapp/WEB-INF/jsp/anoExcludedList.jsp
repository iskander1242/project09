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
<div class="paging"></div>
<table id="ano-table" class="table table-bordered table-striped table-hover">
<thead>
	<tr>
		<th>Наименование</th>
		<th>Город</th>
		<th>Адрес</th>
		<th>Описание деятельности</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="ano" items="${anoList}">
		<tr>
			<td class="col-md-4 span4">${ano.org.nameRus}</td>
			<td class="col-md-2 span2">${ano.org.city}</td>
			<td class="col-md-2 span2">${ano.org.addressRus}</td>
			<td class="col-md-4 span4">${ano.org.description}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<div class="paging"></div>

<aui:script>
$('#ano-table').datatable({
    pageSize: 6,
    sort: [true, true, true, true],
    filters: [true, true, true, true],
    filterText: 'Поиск...',
    sortKey: 0,
    sortDir: 'asc'
}) ;
</aui:script>


