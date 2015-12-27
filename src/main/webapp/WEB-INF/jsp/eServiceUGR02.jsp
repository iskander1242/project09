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
<portlet:renderURL var="serviceListUrl">
</portlet:renderURL>
<c:set var="ns">
	<portlet:namespace />
</c:set>
<a href="${serviceListUrl}">Вернуться к списку услуг</a>
<div class="paging"></div>
<aui:form method="POST" action="${sendForm}" name="anketa"  >
	<aui:input name="dfrom" label="Номер государственной регистрации работы" bean="anketa" onchange="showDfrom(this.value)">
		<aui:validator name="required" />
		<aui:validator name="custom" errorMessage="Число не менее 8 символов">
						function (val, fieldNode, ruleValue) {
							var result = false;
							
							if (val == '' || val.search(/^\d{1,8}$/)!=-1){
								result = true;
							}
							return result;
						}
		</aui:validator>
	</aui:input>
<%--	<aui:input name="dto" label="Дата завершения выборки"   bean="anketa"  onchange="showDto(this.value)">
		<aui:validator name="required" />
		<aui:validator name="custom" errorMessage="Формат даты гггг-мм-дд">
						function (val, fieldNode, ruleValue) {
							var result = false;
							
							if (val == '' || val.search(/^\d{4}-\d{2}-\d{2}$/)!=-1){
								result = true;
							}		
							return result;
						}
		</aui:validator>
	</aui:input>
	<aui:select name="orgId" class="chosen" label="Выбор услуги" onchange="showTeams(this.value);">
		<aui:option value=""></aui:option>
		<c:forEach var="i" items="${servicesList}">
			<aui:option value="${i.id}" label="${i.name}"
				selected="${i.id==anketa.orgId}"></aui:option>
		</c:forEach>
	</aui:select> --%>	
	<br/>	
   <table>
		<tr>		
			<td><a id="checkBtn" class="btn btn-primary">Данные по услуге</a></td>
	<!-- 		<td><input class="wert" type="button" onclick="asd();">1111</input></td>  -->
		</tr>
	</table> 
	

</aui:form>
<div id="notFoundResult" style="display: none">
	<p>Данные не найдены</p>
</div>
<div id="t1">    
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
	
	$('#checkBtn').click(checkParam);	
});


function checkParam(){
 	if (showDfrom.res) 
	{ showData();
	 }else{
		alert('Заполните параметры запроса!!!');
	} 
}

function buttonOff(){   
     $('#checkBtn').off()
 }
 
function buttonOn(){   
	$('#checkBtn').click(checkParam);
}



function progressBar(){
	progressBar.interval = 0;

	$("<div id='pb1'></div>").appendTo("#t1");
	$("<div id='p11'></div>").appendTo("#pb1");
	$("#pb1").addClass("progress");
	$("#p11").addClass("progress-bar progress-bar-striped active");
	setInterval(function(){
	if(progressBar.interval != 100){
	progressBar.interval++;
	$("#p11").width(progressBar.interval + "%");
	$("#p11").html(progressBar.interval + "%");	
	
}
	
	if(progressBar.interval >95){
		$("#p11").width( "90%" );
		$("#p11").html("90%");
		
	}
	
	}, 300);
}



$(document).ajaxStart(function(){
	
	progressBar();	
	
	
});

$(document).ajaxStop(function(){
	
	progressBar.interval = 50;	
	
	
});


function showData(){
	buttonOff();
	 $('#t1').empty(); 
	// progressBar();	 
	$('#notFoundResult').css('display','none');
	$('#foundResult').css('display','none');
	//var data = {"unp":$('#unpInputId').val()}; 
	var data = {"unp": 51,"dfrom": showDfrom.res};
	$.ajax({
	   url: '${checkUnpUrl}',
	   dataType: 'json',
	   data: data,
	   success: function(data) {
		  // alert("su");
		 //  progressBar.interval = 98;  
		   var currentdate = new Date(); 
                var datetime = "Now: " + currentdate.getDate() + "/"
                + (currentdate.getMonth()+1)  + "/" 
                + currentdate.getFullYear() + " @ "  
                + currentdate.getHours() + ":"  
                + currentdate.getMinutes() + ":" 
                + currentdate.getSeconds();
				   
		   var titles ={

				   "1": {title1:"Номер государственной регистрации проекта (НИОКТР)",
				       title2: "Наименование проекта",
				       title3:"Наименование организации-исполнителя проекта",
				       title4: "Дата приема отчетной документации в ГР",
				       title5: "Дата утверждения отчета о НИР(пояснительной записки к ОКР, ОТР)",
				       title6: "Инвентарный номер отчета в ГР",
				       title7: "Созданные объекты интеллектуальной собственности",				       
				       title8:"Фактический объем финансирования",
				       title9:"Номер(а)  регистрации в ГУ 'НЦИС'" 
				   },

				   "2":{title1: "Идентификатор источника финансирования научной деятельности",
				                   title2: "Источник финансирования научной деятельности",
				                   title3:"Объём финансирования (тыс. руб.)"				         
				                   },
				    "3": {title1:"Номер государственной регистрации проекта (НИОКТР)",
								       title2: "Наименование проекта",
								       title3:"Наименование организации-исполнителя проекта",
								       title4: "Дата приема отчетной документации в ГР",
								       title5: "Дата утверждения отчета о НИР(пояснительной записки к ОКР, ОТР)",
								       title6: "Инвентарный номер отчета в ГР",
								       title7: "Созданные объекты интеллектуальной собственности",				       
								       title8:"Фактический объем финансирования",
								       title9:"Номер(а)  регистрации в ГУ 'НЦИС'" 
								   }

				   }
		   ;
		   
		   var headers = {
				    "1": "СВЕДЕНИЯ из государственного реестра  НИОК(Т)Р для государственного реестра"+ 
				    "прав на результаты научно-технической деятельности по запросу НЦИС от "+currentdate.getDate() + "/"
	                + (currentdate.getMonth()+1)  + "/"+ currentdate.getFullYear()+ " "+currentdate.getHours()+"ч."+currentdate.getMinutes()+"м.",
				    "2": "Источники финансирования",
				    "3": "Форма представления результата в машиночитаемом формате"
				};
		   LoadCustomers(data, titles, headers);   		 	   
	   }
	 });
	
	
}
	              
function LoadCustomers(data, titles, headers) {
//	alert("su2");
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
        } else {
        	$("#t1 h5").remove();
        	$("#t1").append("<h5 color='red'>Данные не найдены, уточните параметры запроса!!</h5>")
        }
    }
    buttonOn();
}
	              
function showDfrom(param){
	 showDfrom.res = param;  
}

/* 
function showDto(param){
	showDto.res = param;  
} */

function asd(){
	alert(showTeams.res);	
} 


/* function showTeams(param){
	                     
	showTeams.res = param;      
	                     
} */
 </aui:script>

