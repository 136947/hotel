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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
							<li class="subitem1"><a href="/hotel/assistant/economic.jsp">预定客房</a></li>
							<li class="subitem2"><a href="/hotel/assistant/live.jsp">入住登记</a></li>
							<li class="subitem3"><a href="/hotel/assistant/roomwatch1.jsp">房态一览</a></li>
							<!-- <li class="subitem3"><a href="customer.">客户管理</a></li> -->
							<li class="subitem1"><a href="/hotel/assistant/leave.jsp">退房结算</a></li>
							<li class="subitem2"><a href="/hotel/assistant/information.jsp">客服信息</a></li>
							<li class="subitem3"><a href="/hotel/assistant/login.jsp">注销</a></li>
						</ul>
				</li>
    	</ul>
		
	</div>

<div class="footer">
     <p>Copyright &copy; 2017.Company Ou Xin Kokusai Hotel source -1996</p>
</div>
  </body>
</html>
