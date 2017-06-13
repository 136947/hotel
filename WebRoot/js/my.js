$(function(){
   $('.box1').click(function(){
      $('.box7').dialog({
        width:500,
        height:500,
      })
      $('#roomType').attr("value",$(this).find('p').eq(0).text());
   })
});
//柱状图
$(function () {
	var arr = new Array();
	
	arr = getData();
    $('#chart').highcharts({
        title: {
            text: '客房状态统计'//指定图表标题
        },
        xAxis: {
            categories: [], //指定x轴标签
            labels : //定义x轴标签的样式
            {
                    rotation : -80 ,
                    fontStyle : 'italic',
                    style: {
                        fontSize:'',
                        fontFamily: '微软雅黑' 
                    }
            }
        },
        yAxis: {
            title: {
                text: '房间数量(num)'  //指定y轴标题
            }
        },
        credits: {
            enabled:false
  },
        tooltip: {
            valueSuffix: '(间)'   //指定鼠标移动到某个点上的提示框单位
        },
        legend: {  //
            layout: 'vertical',
            align: 'left',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [{
            name: '房间数',
            type:'column', //指定图表类型 为柱状图，默认为折线图。
            data:[{name:"空闲",y:arr[0]},{name:"预定",y:arr[1]},{name:"入住",y:arr[2]},{name:"暂停使用",y:arr[3]}]
        }]
    });
     
//获取highcharts对象
chart = $('#chart').highcharts();

chart.addAxis({ 
    id: 'precipitation',
    title: {
        text: 'num'
    },
    lineWidth: 2,
    lineColor: '#08F',
    labels: {
        format: '{value} mm',
        style: {
            color: '#08F'
        }
    },
    opposite: true //在右边轴显示 ， 用于需要两边轴都需要显示的情况。
});
chart.addSeries({
    name: '房间数',
    type: 'column',
    color: '#08F',
    yAxis: 'precipitation',
    data: precipitationDatas,
    tooltip: {
        valueSuffix: 'mm'
    }
});

//动态删除y轴。
chart.get("precipitation").remove();

});

function getData(){
	var result=new Array();
	//异步请求数据
	$.ajax({
		type:"post",
	    url : "http://localhost:8080/hotel/jsonAjax/ChartAction_count.action",
	    contentType: "application/json; charset=utf-8",
	    dataType:"json",
	    async : false,
	    success : function(data) {
	    	var d = eval("("+data+")");//将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
			//得到的d是一个形如{"key":"value","key1":"value1"}的数据类型，然后取值出来  
	    	for(var i in d){
	    		if(i=="空闲"){
	    			result[0]=d[i];
	    		}
	    		if(i=="预定"){
	    			result[1]=d[i];
	    		}
	    		if(i=="入住"){
	    			result[2]=d[i];
	    		}
	    		if(i=="暂停使用"){
	    			result[3]=d[i];
	    		}
	    	}
	    	
	    },
	    error : function(){
	        alert("错误");
	    }
	});
	return result;
}