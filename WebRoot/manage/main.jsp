<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
   <title>欧鑫酒店管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link rel="stylesheet" href="admin/css/default/style1.css" type="text/css" media="all" />
</head>
  
  <body>
 <h1>欧鑫国际大酒店</h1>

	<div class="hotel">

		<ul class="menu">
				<li class="item1">
					<a href="">CHOOSE YOUR MENU<i class="menu-down"><img src="images/down.png" alt="" /></i> </a>
						<ul class="cute">
					<li class="subitem1"><a href="/hotel/manage/customer.jsp">客户管理</a>
					</li>
					<li class="subitem2"><a href="/hotel/manage/roomManage.jsp">客房管理</a>
					</li>
					<li class="subitem4" ><a href="/hotel/manage/roomwatch1.jsp">房态一览</a>
					</li>
					<li class="subitem3" ><a href="/hotel/manage/count.jsp">房态统计</a>
					</li>
					<li class="subitem4" ><a href="/hotel/manage/price.jsp">价格调整</a>
					</li>
					
				</ul>
				</li>
    	</ul>
		
	</div>

<div class="footer">
     <p>Copyright &copy; 2017.Company Ou Xin Kokusai Hotel source -1996</p>
</div>
  </body>
</html>
