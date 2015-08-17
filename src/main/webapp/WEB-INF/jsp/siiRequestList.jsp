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
	<c:forEach var="subject" items="${subjects}">
		<tr>
			<td class="col-md-3 span3">${subject.subject.nameRus}</td>
			<td class="col-md-2 span2">${subject.siiType.name}</td>
			<td class="col-md-2 span2">${subject.subject.city}</td>
			<td class="col-md-2 span2">${subject.subject.addressRus}</td>
			<td class="col-md-3 span3">${subject.subject.description}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<div class="paging"></div>

<aui:script>
$('#sii-table').datatable({
    pageSize: 6,
    sort: [true, true, true, true, true],
    filters: [true, 'select', true, true, true],
    filterText: 'Поиск...',
    sortKey: 0,
    sortDir: 'asc'
}) ;
</aui:script>


