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

	<div id="fullNews">
		<div id="date_and_country" style="color: blue;">
			<h6><fmt:formatDate pattern="dd-MM-yyyy" value="${fullNews.date}" />  ${fullNews.country.name}</h6>
		</div>
		<p>${fullNews.fullText}</p>
		<div id="source">
			<a href="${fullNews.link}" target="blank"><i>Источник</i></a>
		</div>
	</div>
</div>
