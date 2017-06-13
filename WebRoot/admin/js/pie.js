$(function(){
   $('.box1').click(function(){
      $('.box7').dialog({
        width:500,
        height:500,
      })
      $('#roomType').attr("value",$(this).find('p').eq(0).text());
   })
});

//pie图


$(function() {
   var arr1= new Array();
	arr1 = get();
	$('#container').highcharts({
		
		chart: {
			ploatBackgroudColor:null,
			plotBorderWidth: null,
			plotShadow: false
		},
		title: {
			text: '房间类型收入比例'
		},
		/*tooltip: {
			pointFormat: '{series.name}: <b>{point.percentage:.2f}%</b>'
		},*/
		 tooltip: {
			 formatter: function() {
			 return '<b>'+ this.point.name +'</b>: '+ Highcharts.numberFormat(this.percentage, 2) +'% ('+
			 Highcharts.numberFormat(this.y, 0, ',') +'元)';
			 }
			 },
		credits: {
			enabled:false
		},
		plotOptions: {
			pie: {
				allowPointSelect: true,
				cursor: 'pointer',
				dataLabels: {
					enabled: true,
					color: '#000',
					connectorColor: '#000',
					format: '<b>{point.name}</b>:{point.percentage:.2f} %'
				}
			}
		},
		series: [{
			type: 'pie',
			name:'房间类型收入比例',
			data: [
				['商务间',arr1[0]],
				['主题房',arr1[1]],
				['三人间',arr1[2]],
				['单人间',arr1[3]],
				['豪华房',arr1[4]],
				['标准间',arr1[5]],
			]
		}]
	});

});



function get(){
var result=new Array();
//异步请求数据
$.ajax({
	type:"post",
    url : "http://localhost:8080/hotel/jsonAjax/CountAction_pieCount.action",
    contentType: "application/json; charset=utf-8",
    dataType:"json",
    async : false,
    success : function(data) {
    	var d = eval("("+data+")");//将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
		//得到的d是一个形如{"key":"value","key1":"value1"}的数据类型，然后取值出来  
    	for(var i in d){
    		if(i=="商务间"){
    			result[0]=d[i];
    		}
    		if(i=="情侣主题房"){
    			result[1]=d[i];
    		}
    		if(i=="三人间"){
    			result[2]=d[i];
    		}
    		if(i=="单人间"){
    			result[3]=d[i];
    		}
    		if(i=="豪华房"){
    			result[4]=d[i];
    		}
    		if(i=="标准间"){
    			result[5]=d[i];
    		}
    	}
    	
    },
    error : function(){
        alert("错误");
    }
});
return result;
}