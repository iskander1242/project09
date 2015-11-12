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
<portlet:actionURL var="uploadFileURL">
	<portlet:param name="myActions" value="uploadMultipleFile"></portlet:param>
</portlet:actionURL>
<portlet:renderURL var="serviceListUrl">
</portlet:renderURL>
<c:set var="ns">
	<portlet:namespace />
</c:set>
<portlet:resourceURL var="getFiles" id="getFile"></portlet:resourceURL>
<portlet:resourceURL var="checkUnpUrl"></portlet:resourceURL>
<%-- <portlet:resourceURL var="addFilesMy" id="addFiles"></portlet:resourceURL> --%>
<portlet:resourceURL var="getFilesMy" id="getFiles"></portlet:resourceURL>

<a href="${serviceListUrl}">Вернуться к списку услуг!!!</a>

<h1>Загрузка файлов</h1>
<div style="width: 500px; padding: 20px">

	<input id="fileupload" type="file" name="files[]"
		data-url="<portlet:actionURL><portlet:param name='myActions' value='uploadMultipleFile'/></portlet:actionURL>"
		multiple>
	<div id="dropzone" class="fade well">Drop files here</div>

	<div id="progress" class="progress">
		<div class="bar" style="width: 0%;"></div>
	</div>

	<table id="uploaded-files" class="table">
		<tr>
			<th>File Name</th>
			<th>File Size</th>
			<th>File Type</th>
			<th>Download</th>
		</tr>
	</table>

</div>
<div class="paging"></div>
<div id="notFoundResult" style="display: none">
	<p>Данные не найдены</p>
</div>
<div id="t1"></div>

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
	
	showDataLocal();
});

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



/* $(document).ajaxStart(function(){
	
	progressBar();	
	
	
});

$(document).ajaxStop(function(){
	
	progressBar.interval = 50;	
	
	
}); */

function callServeResource(fileName){
	//alert("callServeResource!!");
	//alert(fileName);	
	var data = {"fileName": fileName};
	$.ajax({
		   url: '${getFilesMy}',
		   data: data,
		   success: function (data) {		
			window.open(this.url)
	       },
	      /*  complete:function (jqXHR, textStatus) {
				alert('Complite!!!!'+textStatus);			
		   } */
		 });	
}           

 function showDataLocal(){  
	//alert('Su');  
	var data = {"unp": 50};
	$.ajax({
	   url: '${checkUnpUrl}',
	   dataType: 'json',
	   data: data,
	   success: function (data) {		
       	$("tr:has(td)").remove();
        $.each(data, function (index, file) {
        	var myString = "<button  id='btnLoad' value='"+file.id+"'>Загрузить</button>";
			var $jQueryObject = $($.parseHTML(myString));
			$jQueryObject.click(function(){
				callServeResource($($jQueryObject).val())
			});
			/* var myString = "<button  id='btnDel' value='"+file.id+"'>Удалить</button>";
			var $jQueryObjectDel = $($.parseHTML(myString));
			$jQueryObject.click(function(){
				callServeResource($($jQueryObjectDel).val())
			}); */
        	
            $("#uploaded-files").append(
            		$('<tr/>')
            		.append($('<td/>').text(file.fileName))
            		.append($('<td/>').text(file.fileSize))
            		.append($('<td/>').text(file.fileType))
            		.append($('<td/>').append($jQueryObject))
            		)
         });       
        }
	 });	
} 

$('#fileupload').fileupload(
    	{
        //dataType: 'json', 
        complete:function (e, msg){        	
        	showDataLocal();
        },
        
        progressall: function (e, data) {
        	$('#progress .bar').css('width','0%');
	        var progress = parseInt(data.loaded / data.total * 100, 10);
	        $('#progress .bar').css(
	            'width',
	            progress + '%'
	        );
   		},
   		
		dropZone: $('#dropzone')
    }
    );
    
/* $(document).ajaxStop(function(){
    //alert('All uploads done');  
    $(this).unbind("ajaxStop");
    showDataLocal();    
}); */
 </aui:script>

