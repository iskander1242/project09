<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<portlet:defineObjects />


<c:set var="ns">
	<portlet:namespace />
</c:set>

<div class="paging"></div>
<table id="newTech-table" class="table table-bordered table-striped table-hover" style="table-layout: fixed">
<thead>
	<tr>		
		<th>Наименование</th>
		<th>Описание услуги</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="item" items="${newTechList}">
		<tr>
			<td class="col-md-2 span2"><div style="font-size:small">${item.name}<input type="button" onclick="alert('ffff')">tttttt</input></div></td>
			<td class="col-md-3 span4" span=""><div style="font-size:small">${item.description}</div></td>						
		</tr>
	</c:forEach>
	</tbody>
</table>
<div class="paging"></div>

<aui:script>
$('#newTech-table').datatable({
    pageSize: 6,
    sort: [true, true],
    filters: [true, true],
    filterText: 'Поиск...'
}) ;
</aui:script>


