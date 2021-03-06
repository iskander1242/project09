<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<portlet:defineObjects />
<portlet:renderURL var="anoActualListUrlExt">
	<portlet:param name="view" value="eServices"/>
	<portlet:param name="type" value="extendedService"/>
</portlet:renderURL>
<portlet:renderURL var="anoActualListUrl">
	<portlet:param name="view" value="eServices"/>
	<portlet:param name="type" value="jeneralService"/>
</portlet:renderURL>
<portlet:renderURL var="anoExcludedListUrl">
	<portlet:param name="view" value="eServiceUGR02"/>
</portlet:renderURL>
<portlet:renderURL var="anoRequestListUrl">
	<portlet:param name="view" value="eServiceUGR02"/>
</portlet:renderURL>
<portlet:renderURL var="anoByUnpUrl">
	<portlet:param name="view" value="eServiceUpload"/>
</portlet:renderURL>
<portlet:renderURL var="preparationForRegistrarionService">
	<portlet:param name="view" value="eServiceUpload"/>
	<portlet:param name="type" value="preparationForRegistrarionService"/>
</portlet:renderURL>
<portlet:renderURL var="receptionKitService">
	<portlet:param name="view" value="eServiceUpload"/>
	<portlet:param name="type" value="receptionKitService"/>
</portlet:renderURL>
<portlet:renderURL var="preparationProjectKidService">
	<portlet:param name="view" value="eServiceUpload"/>
	<portlet:param name="type" value="preparationProjectKidService"/>
</portlet:renderURL>
<portlet:renderURL var="receptionKitElDocumentsService">
	<portlet:param name="view" value="eServiceUpload"/>
	<portlet:param name="type" value="receptionKitElDocumentsService"/>
</portlet:renderURL>
<c:set var="ns">
	<portlet:namespace />
</c:set>

<%-- <ul>
	<li><a href="${anoActualListUrl}">Общие сведения о работах, прошедших государственную регистрацию</a></li>
	<li><a href="${anoRequestListUrl}">Расширенные общие сведения о работах, прошедших государственную регистрацию</a></li>
	<li><a href="${anoExcludedListUrl}">Предоставление специально оговоренных данных для обеспечения связи ИР ГР с государственным реестром прав на результаты научно-технической деятельности, который ведется НЦИС</a></li>
 	<li><a href="${anoByUnpUrl}">Загрузка файлов</a></li>
	<li><a href="${downloadFileUrl}">Предоставление полного пакета материалов по процедуре аккредитации конкретной организации</a></li>
</ul> 

preparationForRegistrarionService(59),
        receptionKitService(60),
        preparationProjectKidService(61),
        receptionKitElDocumentsService(62);--%>
<ul>
<c:forEach var="service" items="${servicesList}">
   <c:choose>
    <c:when test="${service.id == 22}">
       <li><a href="${anoExcludedListUrl}">${service.name}</a></li>
    </c:when>
    <c:when test="${service.id == 53}">
       <li><a href="${anoActualListUrl}">${service.name}</a></li>
    </c:when>
    <c:when test="${service.id == 52}">
       <li><a href="${anoActualListUrlExt}">${service.name}</a></li>
    </c:when>
      <c:when test="${service.id == 59}">
       <li><a href="${preparationForRegistrarionService}">${service.name}</a></li>
    </c:when>
      <c:when test="${service.id == 60}">
       <li><a href="${receptionKitService}">${service.name}</a></li>
    </c:when>
      <c:when test="${service.id == 61}">
       <li><a href="${preparationProjectKidService}">${service.name}</a></li>
    </c:when>
      <c:when test="${service.id == 62}">
       <li><a href="${receptionKitElDocumentsService}">${service.name}</a></li>
    </c:when>
    <c:otherwise>
        <li><a href="">${service.name}</a></li>
    </c:otherwise>
</c:choose>   
</c:forEach>
   	<%-- <li><a href="${anoByUnpUrl}">Загрузка файлов</a></li> --%>
<ul>
