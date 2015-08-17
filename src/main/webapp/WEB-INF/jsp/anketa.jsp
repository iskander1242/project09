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
<center>
	<div id="successMessageContainer" />
</center>
<%-- <aui:form action="${sendForm}">
	<aui:input name="fullFio" bean="anketa" value="${anketa.fullFio}" type="hidden"></aui:input>
	<aui:input name="fio" bean="anketa" value="${anketa.fio}"></aui:input>
	<aui:button-row>
		<div align="left">
			<aui:button type="submit" value="Добавить" />
		</div>
	</aui:button-row>
</aui:form> --%>
<aui:form method="POST" action="${sendForm}" name="anketa">
	<%-- <aui:input name="fio" value="${anketa.fio}" bean="anketa" type="hidden" />
	<aui:input name="fullFio" value="${anketa.fullFio}" bean="anketa" type="hidden" /> --%>

	<aui:input name="surname" label="Фамилия" value="${anketa.surname}" bean="anketa">
		<aui:validator name="required" />
	</aui:input>
	<aui:input name="name" label="Имя" value="${anketa.name}" bean="anketa">
		<aui:validator name="required" />
	</aui:input>

	<aui:input name="patronymic" label="Отчество" value="${anketa.patronymic}" bean="anketa">
		<aui:validator name="required" />
	</aui:input>
	<aui:input name="birthday" label="Дата рождения" value="${anketa.birthday}" bean="anketa">
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
	<c:if test="${not empty anketa.ls}">
		<aui:input name="ls" label="Лицевой счет" value="${anketa.ls}" disabled="true"/>
	</c:if>


	<%-- <aui:input name="fio" label="ФИО краткое" value="${anketa.fio}" bean="anketa" />
	<br />
	<aui:input name="fullFio" label="ФИО полное" value="${anketa.fullFio}" bean="anketa" />
	<br />
	<aui:input name="birthday" label="Дата рождения" disabled="true" value="${anketa.birthday}" bean="anketa" />
	<br /> --%>
	<aui:select name="orgId" class="chosen" label="Организация">
		<aui:option value=""></aui:option>
		<c:forEach var="i" items="${orgList}">
			<aui:option value="${i.id}" label="${i.name}" selected="${i.id==anketa.orgId}"></aui:option>
		</c:forEach>
	</aui:select>
	<aui:select name="uchStepeniIdArr" class="chosen" label="Ученая степень" multiple="true">
		<aui:option value=""></aui:option>
		<c:forEach var="i" items="${uchStepeniList}">
			<c:choose>
				<c:when test="${empty anketa.uchStepeniIdArr}">
					<aui:option value="${i.id}" label="${i.fullName}" selected="${i.id==45}"></aui:option>
				</c:when>
				<c:otherwise>
					<c:set var="contains" value="false" />
					<c:forEach var="item" items="${anketa.uchStepeniIdArr}">
						<c:if test="${item eq i.id}">
							<c:set var="contains" value="true" />
						</c:if>
					</c:forEach>
					<aui:option value="${i.id}" label="${i.fullName}" selected="${contains}"></aui:option>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</aui:select>
	<aui:select name="uchZvaniyIdArr" class="chosen" label="Ученое звание" multiple="true">
		<aui:option value=""></aui:option>
		<c:forEach var="i" items="${uchZvaniyList}">
			<c:choose>
				<c:when test="${empty anketa.uchZvaniyIdArr}">
					<aui:option value="${i.id}" label="${i.fullName}" selected="${i.id==17}"></aui:option>
				</c:when>
				<c:otherwise>
					<c:set var="contains" value="false" />
					<c:forEach var="item" items="${anketa.uchZvaniyIdArr}">
						<c:if test="${item eq i.id}">
							<c:set var="contains" value="true" />
						</c:if>
					</c:forEach>
					<aui:option value="${i.id}" label="${i.fullName}" selected="${contains}"></aui:option>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</aui:select>


	<aui:input name="post" label="Должность" value="${anketa.post}" />
	<br />
	<aui:input name="lab" label="Кафедра" value="${anketa.lab}" />
	<br />

	<aui:input name="homePhone" label="Тел домашний" value="${anketa.homePhone}" />
	<br />
	<aui:input name="jobPhone" label="Тел рабочий" value="${anketa.jobPhone}" />
	<br />
	<aui:input name="mobilePhone" label="Тел мобильный" value="${anketa.mobilePhone}" />
	<br />
	<aui:input name="address" label="Адрес" value="${anketa.address}" />
	<br />
	<aui:input name="email" label="Email" value="${anketa.email}" disabled="true" />
	<aui:input name="email" value="${anketa.email}" type="hidden" />
	<br />


	<aui:button-row>
		<div align="left">
			<aui:button type="submit" value="Сохранить" />
		</div>
	</aui:button-row>
</aui:form>

<aui:script>
$(document).ready(function() {
	$('.disbl').attr('disabled', 'disabled');

	$('select').chosen({
		no_results_text : "Извините, нет совпадений!",
		placeholder_text_single : "Выберите из списка...",
		placeholder_text_multiple : "Выберите нужные пункты...",
		width : '90%'
	});
});
YUI().use(
  function(Y) {
  	var save_result = '${save_result}';
  	if (save_result){
  		showSuccess();
  	}
  }
);

function showSuccess(){
	AUI().use('liferay-notice', function(A){
		var successMessageContainer = A.one('#successMessageContainer');
		var banner = new Liferay.Notice(
			{
				animationConfig:
					{
						duration: 0.1,
						top: '50%',
						left: '50%'
						
					},
				content: '<div class="alert alert-success">Сохранено</div>',
				closeText: false,
				node: '#successMessageContainer',
				type: 'notice',
				toggleText: false,
				timeout: 1000,
				useAnimation: false
				
			}
		);

		banner.show();
	});	
}
</aui:script>