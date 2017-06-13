$(function(){
	$("#contact").ajaxForm(function(responseText,statusText){
		$("#change21").attr("value",responseText);
		$("#change").dialog({
			width:400,
			height:300,
			resizable:false,
			modal:true,
		})
		
	
	})
})



