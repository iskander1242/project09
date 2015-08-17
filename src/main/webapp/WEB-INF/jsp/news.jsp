<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<portlet:defineObjects />
<c:set var="ns">
	<portlet:namespace />
</c:set>

<div id="newsBox">
<c:forEach items="${newsList}" var="i" varStatus="n">
	<div id="new-${n.index}">
		<div id="date_and_country" style="color: blue;">
			<h6><fmt:formatDate pattern="dd-MM-yyyy" value="${i.date}" />  ${i.country.name}</h6>
		</div>
		<portlet:renderURL var="fullNewsUrl">
			<portlet:param name="view" value="fullNews"/>
			<portlet:param name="new_id" value="${i.id}"/>
		</portlet:renderURL>
		<p>${i.shortText}  <a href="${fullNewsUrl}">Читать полностью</a></p>
		<div id="source">
			Источник   <a href="${i.link}" target="blank"><i>${i.link}</i></a>
		</div>
	</div>
</c:forEach>

</div>
<div class="pagination">
    <a href="#" class="first" data-action="first">&laquo;</a>
    <a href="#" class="previous" data-action="previous">&lsaquo;</a>
    <input type="text" readonly="readonly" data-max-page="${lastPage}" />
    <a href="#" class="next" data-action="next">&rsaquo;</a>
    <a href="#" class="last" data-action="last">&raquo;</a>
</div>
<aui:script>
$(document).ready(function(){

	$('.pagination').jqPagination({
	current_page:${currentPage},
    paged: function(page) {
      	AUI().use('liferay-portlet-url', function(A) {
      			var url=Liferay.PortletURL.createRenderURL();
      			url.setPortletId('${portletId}');
      			url.setParameter('page',page.toString());
      			A.one(document.createElement('a')).attr('href',url).simulate('click');
   	  		});
    	}
	});
});

</aui:script>