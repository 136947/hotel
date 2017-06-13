<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="share/images/favicon.ico" rel="shortcut icon"/>
<link href="share/css/share.css" rel="stylesheet" type="text/css"/>
<link href="admin/css/default/login.css" rel="stylesheet" type="text/css"  />
<link href="admin/css/default/share.css" rel="stylesheet" type="text/css"  />
<link href="css/button.css" rel="stylesheet" type="text/css"/>
  </head>
  
  
	<body id="loginBody">
		<div id="pointerOpen" onclick="hideLoginBezel()">开启登录</div>
		<div id="loginBezel">
		<div id="loginChildTop">　<img src="admin/images/logo-right.png" width="57" height="50" align="absbottom"  /> 欧鑫酒店管理系统</div>
		<div id="loginChildBottom">
		<table cellpadding="0" cellspacing="0" width="100%" height="95%" border="0">
			<s:form action="loginAction_checkStuff" namespace="/actions" name="loginService" method="post">
			<tr>
				<td align="right" width="35%">账　号：</td>
				<td align="left" width="65%"><input name="loginService.name" type="text" id="account"  class="inputUP"/></td>
			</tr>
			<tr>
				<td align="right">密　码：</td>
				<td align="left"><input type="password" name="loginService.password" id="pwd" class="inputUP"/></td>
			</tr>
			
			<tr>
				<td align="center" colspan="2"> <button type="submit" class="button">登录</button></td>
			</tr> 
			</s:form>
		</table>
		</div>
		</div>
		<script src="share/js/jquery-1.11.0.js"></script>
		<script src="admin/js/login.js"></script>
		<div style="text-align:center;">
</div>
</body>
</html>
