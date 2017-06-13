
(function($){   
$.fn.leftMenu=function(options){
var defaults = {
	sibling:'h4',
	nextSibling:'ul',
	};
	var opt = $.extend(defaults,options);
	var $currentThis = $(this);
	return $currentThis.find(opt.sibling).each(function(){
		var $this = $(this);
		$this.click(function(e){
			e.preventDefault();
			$currentThis.find(opt.sibling).removeClass('on');
			$currentThis.find(opt.nextSibling).slideUp();
			$this.addClass("on");
			$this.next().slideDown();
			//$("#cleft").mCustomScrollbar("destroy");
			//$("#cleft").mCustomScrollbar("update"); //update scrollbar according to newly loaded content
		   // $("#cleft").mCustomScrollbar("scrollTo","h2:last",{scrollInertia:2500,scrollEasing:"easeInOutQuad"}); //scroll to appended content
		});
		$this.next().find('a').click(function(){
				$this.next().find('li').removeClass('on');
				$(this).parent().addClass('on');
		});
	});
};
})(jQuery); 
  
$(function() {
	var browser=navigator.appName;
	$("#cleft-id").leftMenu();
	resizeWindows('#bezel-id');
});
function outLogin(){
	location.href='login.html';
}
$(function(){
	$('#dateset').datepicker({
		changeMonth:true,
		changeYear:true,
		maxDate:null,
		dateFormat:"yy-mm-dd",
		yearRange:'1950:2017',
		showOtherMonths:true,
		selectOtherMonths:true,
	});
	
})
/*$(function(){
	
})*/
$(function(){
	$(".tr1").click(function(){

		$("#div1").dialog({
			height:625,
			width:580,
			resizable:false,
			modal:true,
		})
		$("#bookroomNumber").attr("value",$(this).find("td").eq(0).text());
		$("#selectLiveDate").attr("value",$("#dateset").val());
		$("#selectLeaveDate").attr("value",$("#dateset1").val());
	})
})
$(function(){
	$(".td1").click(function(){
		$("#div2").dialog({
			height:800,
			width:620,
			resizable:false,
			modal:true,
		})
		
	})
});

$(function(){
	$(".tr3").click(function(){
		$("#div3").dialog({
			height:800,
			width:600,
			resizable:false,
			modal:true,
		})
		$("#roomId").attr("value",$(".tr3").find("td").eq(0).text());
		$("#idcard").attr("value",$(".tr3").find("td").eq(3).text());
		$("#phone").attr("value",$(".tr3").find("td").eq(4).text());
		$("#liveIntoDate").attr("value",$(".tr3").find("td").eq(7).text());
		$("#liveOutDate").attr("value",$(".tr3").find("td").eq(8).text());
		$("#allRoomPrise1").attr("value",$("#allRoomPrise").text())
		
		$("#security").attr("value",$(".tr3").find("td").eq(5).text());
		
	})

})
$(function(){
	$(".customertr").click(function(){
		$("#customerdiv").dialog({
			width:550,
			height:760,
			resizable:false,
			modal:true,
		})
		$("#name").attr("value",$(this).find("td").eq(0).text());
		$("#tel").attr("value",$(this).find("td").eq(1).text());
		$("#idcard").attr("value",$(this).find("td").eq(2).text());
		$("#roomNumber").attr("value",$(this).find("td").eq(3).text());
		$("#status").attr("value",$(this).find("td").eq(4).text());
		$("#dateset").attr("value",$(this).find("td").eq(5).text());
		$("#dateset1").attr("value",$(this).find("td").eq(6).text());
	})
})
$(function(){
	$(".live1").click(function(){
		$("#div1").dialog({
			height:700,
			width:600,
			modal:true,
		})
		
		$(".num").attr("value",$(this).find('td').eq(0).text());
	})
})
$(function(){
	$(".live2").click(function(){
		$("#div2").dialog({
			height:800,
			width:620,
			resizable:false,
			modal:true,
		})
		$(".num").attr("value",$(this).find('td').eq(0).text());
		$(".tel").attr("value",$(this).find('td').eq(1).text());
		$(".idCard").attr("value",$(this).find('td').eq(2).text());
		$(".liveIntoDate").attr("value",$(this).find('td').eq(4).text());
		$(".liveLeaveDate").attr("value",$(this).find('td').eq(5).text());
		$(".name").attr("value",$(this).find('td').eq(6).text());
	})
})
$(function(){
	$("#write").click(function(){
		$("#div1111").dialog({
			height:400,
			width:420,
			resizable:false,
			modal:true,
		})
	})
})

