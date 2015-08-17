<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<portlet:defineObjects />
<portlet:renderURL var="vttActualListUrl">
	<portlet:param name="view" value="vttActualList"/>
</portlet:renderURL>
<portlet:renderURL var="vttRequestListUrl">
	<portlet:param name="view" value="vttRequestList"/>
</portlet:renderURL>


<c:set var="ns">
	<portlet:namespace />
</c:set>

<ul>
	<li><a href="${vttActualListUrl}">Предоставление полного актуального состава перечня ВТТ</a></li>
	<li><a href="${vttRequestListUrl}">Предоставление общих сведений о текущих заявках на включение организации в перечень ВТТ</a></li>
</ul>