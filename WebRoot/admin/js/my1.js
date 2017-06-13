$(function(){
	$("#dx").click(function(){
		$("#tab").dialog({
			height:600,
			width:550,
			modal:true,
		})
		$(".roomNum").attr("value",$(this).siblings("#roomNum").text());
		$(".name").attr("value",$(this).siblings("#name").text());
		$(".tel").attr("value",$(this).siblings("#tel").text());
		$(".idCard").attr("value",$(this).siblings("#idCard").text());
		$(".bookIntoDate").attr("value",$(this).siblings("#bookIntoDate").text());
	})
})

$(function(){
	$("#sc").click(function(){
		$("#tab2").dialog({
			height:600,
			width:550,
			modal:true,
		})
		$(".roomNum").attr("value",$(this).siblings("#roomNum").text());
		$(".name").attr("value",$(this).siblings("#name").text());
		$(".tel").attr("value",$(this).siblings("#tel").text());
		$(".idCard").attr("value",$(this).siblings("#idCard").text());
		$(".bookIntoDate").attr("value",$(this).siblings("#bookIntoDate").text());
	})
})


$(function(){
	$(".add").click(function(){
		$("#tab3").dialog({
			height:480,
			width:550,
			modal:true,
		})
	})
})

$(function(){
	$(".dx1").click(function(){
		$("#tab4").dialog({
			height:480,
			width:550,
			modal:true,
		})
		$(".num").attr("value",$(this).siblings(".Num").text());
	})
})


//É¾³ý¿Í·¿
$(function(){
	$(".sc1").click(function(){
		$("#tab5").dialog({
			height:480,
			width:550,
			modal:true,
		})
		$(".num").attr("value",$(this).siblings(".Num").text());
		$(".roomType").attr("value",$(this).siblings(".RType").text());
		$(".status").attr("value",$(this).siblings(".Rstatus").text());
		
	})
})