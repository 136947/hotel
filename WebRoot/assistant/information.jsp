<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link href="share/images/favicon.ico" rel="shortcut icon"/>
<link rel="stylesheet" type="text/css" href="share/css/share.css"/>
<link rel="stylesheet" type="text/css" href="admin/css/default/index.css"/>
<link rel="stylesheet" type="text/css" href="admin/css/default/share.css"/>
<link rel="stylesheet" type="text/css" href="share/css/jquery-ui.css"/>
<link rel="stylesheet" type="text/css" href="css/my1.css"/>
<script src="share/js/jquery-1.11.0.min.js" type="application/javascript"></script>
<script type="text/javascript" src="share/js/jsUtil.js"></script>
<script type="text/javascript" src="share/js/jquery-ui.js"></script>
<script type="text/javascript" src="share/js/layer/layer.js"></script>
<script src="admin/js/index.js" type="application/javascript"></script>
  </head>
  
  <body>
  <div class="bezel" id="bezel-id">
    <div class="head">
        <div class="hleft"><span class="head-icon">欧鑫酒店管理系统</span></div>
        <div class="hcenter" style="width:35%">
        </div>
        <div class="hright">
        	<span> 您好，欢迎登录使用！<a class="outLogin" href="/hotel/assistant/login.jsp">退出</a></span>
        </div>
    </div>
    <div class="center">
        <div class="cleft" id="cleft-id">	
            <h4 class="on">系统管理</h4>
             <ul style="display:block;">
            	<li><a href="/hotel/assistant/economic.jsp" target="contentMain">预定客房</a></li>
            	<li><a href="/hotel/assistant/live.jsp" target="contentMain">入住登记</a></li>
            	<li><a href="/hotel/assistant/leave.jsp">退房结算</a></li>
            </ul>
            <h4>内容管理</h4>
            <ul>
            	<li class="on"><a href="/hotel/assistant/roomwatch1.jsp">房态一览</a></li>
            	<li><a href="/hotel/assistant/customer.jsp">客户管理</a></li>
            	<li><a href="/hotel/assistant/information.jsp">客服信息</a></li>
            </ul>
        </div>
        <div class="rleft">
            <div class="position">　当前位置：内容管理　&gt; 客服信息</div>
            <div class="center">
 				&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
            	<span style="font-size:20px">客服编号：<label>1002</label></span><br><br>
            	&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
            	<span style="font-size:20px">客服姓名：<label>小明</label></span><br><br>
            	&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
            	<span style="font-size:20px">家庭住址：<label>江西省南昌市红谷滩</label></span><br><br>
            	&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
            	<span style="font-size:20px">身份证号：<label></label>360427199812120045</span><br><br>
            	&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
            	<span style="font-size:20px">个人说明：<label></label>热爱生活，热爱工作</span><br><br>
            	&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
            	<span style="font-size:20px">客服密码：<label></label><span><input id="write" type="button" id="password" value="修改密码"><br><br>
			</div>
		</div>
    </div>
<div class="floot">版权</div> 
</div>
<div style="text-align:center;">
<p>来源：<a href="http://www.mycodes.net/" target="_blank">源码之家</a></p>
</div>
<div id="div1111" style="display:none">
    <s:form id="formStyle" name="passwordService" action="passwordAction_changePassword" namespace="/actions">
    	新密码：<s:textfield name="passwordService.password"></s:textfield>
    	再次输入密码：<s:textfield></s:textfield>
    	 <fieldset>
      <button type="submit">确定</button>
    </fieldset>
    </s:form>
</div>
  </body>
</html>
