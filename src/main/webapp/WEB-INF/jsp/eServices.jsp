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
<aui:form method="POST" action="${sendForm}" name="anketa">
	<aui:input name="birthday" label="DFROM" value="${anketa.birthday}"
		bean="anketa">
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
	<aui:input name="birthday" label="DTO"  value="${anketa.birthday}"
		bean="anketa">
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
	<aui:select name="orgId" class="chosen" label="Организация" onchange="showTeams(this.value);">
		<aui:option value=""></aui:option>
		<c:forEach var="i" items="${servicesList}">
			<aui:option value="${i.id}" label="${i.name}"
				selected="${i.id==anketa.orgId}"></aui:option>
		</c:forEach>
	</aui:select>
	
	
	
	<br/>	
   <table>
		<tr>		
			<td><a id="checkBtn" class="btn btn-primary">Данные по услуге</a></td>
			<td><input class="wert" type="button" onclick="asd();">1111</input></td>
		</tr>
	</table> 
	

</aui:form>
<div id="notFoundResult" style="display: none">
	<p>Данные не найдены</p>
</div>
    <h5>РАСПРЕДЕЛЕНИЕ РАБОТ ПРОШЕДШИХ ГОСУДАРСТВЕННУЮ РЕГИСТРАЦИЮ</h5>
    <div id="t1">
    	<table id="ano-table"
		class="table table-bordered table-striped table-hover">	
			<thead>
				<tr>
					<td>Источник финансирования научной деятельности</td>
					<td>Количество зарегистрированных работ</td>
					<td>Количество организаций-исполнителей</td>
					<td>Количество организаций-заказчиков</td>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
    
    </div>
    
    

<portlet:resourceURL var="checkUnpUrl"></portlet:resourceURL>
<aui:script>
$(document).ready(function() {	
	
	$('.disbl').attr('disabled', 'disabled');
	
	//$('.aui-field-select').on("change", showTeams);

	$('select').chosen({
		no_results_text : "Извините, нет совпадений!",
		placeholder_text_single : "Выберите из списка...",
		placeholder_text_multiple : "Выберите нужные пункты...",
		width : '90%'
	});
	
	$('#checkBtn').click(function(){
		alert(showTeams.res);
		$('#notFoundResult').css('display','none');
		$('#foundResult').css('display','none');
		//var data = {"unp":$('#unpInputId').val()}; 
		var data = {"unp": showTeams.res};
		$.ajax({
		   url: '${checkUnpUrl}',
		   dataType: 'json',
		   data: data,
		   success: function(data) { 
			   
			   var titles ={

					   "1": {title1: "Источник финансирования научной деятельности",
					       title2: "Количество зарегистрированных работ",
					       title3:"Количество организаций-исполнителей",
					       title4: "Количество организаций-заказчиков",
					       title5: "dfgdfgdfgdfgdfgdfg",
					       title6: "wwwwwwwwwwwwwwww"
					   },

					   "2":{title1: "Источник финансирования научной деятельности",
					                   title2: "Количество зарегистрированных работ",
					                   title3:"Количество организаций-исполнителей",
					                   title4: "Количество организаций-заказчиков",
					                   title5: "dfgdfgdfgdfgdfgdfg"

					                   },
					       "3":{title1: "Источник финансирования научной деятельности",
					           title2: "Количество зарегистрированных работ",
					           title3:"Количество организаций-исполнителей",
					           title4: "Количество организаций-заказчиков",
					           title5: "dfgdfgdfgdfgdfgdfg"

					       },

					       "4":{title1: "Источник финансирования научной деятельности",
					           title2: "Количество зарегистрированных работ",
					           title3:"Количество организаций-исполнителей",
					           title4: "Количество организаций-заказчиков",
					           title5: "dfgdfgdfgdfgdfgdfg"

					       },

					       "5":{title1: "Источник финансирования научной деятельности",
					           title2: "Количество зарегистрированных работ",
					           title3:"Количество организаций-исполнителей",
					           title4: "Количество организаций-заказчиков",
					           title5: "dfgdfgdfgdfgdfgdfg"

					       },
					       "6":{title1: "Источник финансирования научной деятельности",
					           title2: "Количество зарегистрированных работ",
					           title3:"Количество организаций-исполнителей",
					           title4: "Количество организаций-заказчиков",
					           title5: "dfgdfgdfgdfgdfgdfg"

					       },

					       "7":{title1: "Источник финансирования научной деятельности",
					           title2: "Количество зарегистрированных работ",
					           title3:"Количество организаций-исполнителей",
					           title4: "Количество организаций-заказчиков",
					           title5: "dfgdfgdfgdfgdfgdfg"

					       }

					   };
			   
			   var headers = {

					    "1": "Таблица 1",
					    "2": "Таблица 2",
					    "3": "Таблица 3",
					    "4": "Таблица 4",
					    "5": "Таблица 5",
					    "6": "Таблица 6",
					    "7": "Таблица 7"

					};
			   
			   
			   LoadCustomers(data, titles, headers); }
		 });
	});
}); 


function showTeams(param){
	                     
	showTeams.res = param;      
	                     
	              }


	              
function LoadCustomers(data, titles, headers) {

    $("#t1").empty();
    var _addHead = function (titles) {

        var thead = document.createElement("thead");
        var tr = document.createElement("tr");
        var td, tn, h5;


        $.each(titles, function (key, value) {

            td = document.createElement("td");
            tn = document.createTextNode(value);
            td.appendChild(tn);
            tr.appendChild(td);

        });

        thead.appendChild(tr);

        return thead;

    };
var uid = 0;
    for(var o in data) {

        var listRes2 = data[o];
uid = ++uid;
        if (listRes2.length > 0) {


            var table = document.createElement("table");

            var td, tn;
            for (var i = 0; i < listRes2.length; i++) {
                var tr = document.createElement("tr");

                var obj = listRes2[i];

                $.each(obj, function (key, value) {

                    td = document.createElement("td");
                    tn = document.createTextNode(value);
                    td.appendChild(tn);
                    tr.appendChild(td);

                });
                table.appendChild(tr);


            }
            
            h5 = document.createElement("h5");
            $(h5).html(headers[uid]);
            $("#t1").append(h5);
            table.appendChild(_addHead(titles[uid]));
            $("#t1").append(table).addClass("table table-bordered table-striped table-hover");;
        }
    }
}
	     
	              

/* function LoadCustomers(data) {	
	var tbody = $("#ano-table > tbody").html("");
 		for ( var i in data) {
			var customer = data[i];			
			var rowText = "<tr><td>" + customer['org']['nameRus'] + "</td><td>" + 1
					+ "</td><td>" + 1 + "</td><td>" + 1 + "</td></tr>";
			$(rowText).appendTo(tbody);			
		} 
 	
	    } */

	    
 </aui:script>

