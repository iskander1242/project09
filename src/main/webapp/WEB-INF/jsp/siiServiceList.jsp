<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<portlet:defineObjects />
<portlet:renderURL var="siiActualListUrl">
	<portlet:param name="view" value="siiActualList"/>
</portlet:renderURL>
<portlet:renderURL var="siiRequestListUrl">
	<portlet:param name="view" value="siiRequestList"/>
</portlet:renderURL>
<portlet:renderURL var="siiExcludedListUrl">
	<portlet:param name="view" value="siiExcludedList"/>
</portlet:renderURL>
<portlet:renderURL var="siiByUnpUrl">
	<portlet:param name="view" value="siiByUnp"/>
</portlet:renderURL>
<portlet:resourceURL id="downloadFile" var="downloadFileUrl"/>
<c:set var="ns">
	<portlet:namespace />
</c:set>

<ul>
	<li><a href="${siiActualListUrl}">Предоставление полного актуального состава регистра СИИ</a></li>
	<li><a href="${siiRequestListUrl}">Предоставление общих сведений о текущих заявках на включение организации в реестр СИИ</a></li>
	<li><a href="${siiExcludedListUrl}">Предоставление перечня организаций исключенных из регистра СИИ</a></li>
	<li><a href="${siiByUnpUrl}">Предоставление сведений о нахождении или отсутствии организации в составе реестра СИИ</a></li>
	<li><a href="${downloadFileUrl}">Предоставление полного пакета материалов по заявке включение в регистр СИИ конкретной организации</a></li>
</ul>