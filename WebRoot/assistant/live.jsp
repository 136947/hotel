<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'live.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link href="share/images/favicon.ico" rel="shortcut icon" />
<link rel="stylesheet" type="text/css" href="share/css/share.css" />
<link rel="stylesheet" type="text/css" href="admin/css/default/index.css" />
<link rel="stylesheet" type="text/css" href="admin/css/default/share.css" />
<link rel="stylesheet" type="text/css" href="share/css/jquery-ui.css" />
<link rel="stylesheet" type="text/css" href="css/my.css"/>
<script src="share/js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script type="text/javascript" src="share/js/jsUtil.js"></script>
<script type="text/javascript" src="share/js/jquery-ui.js"></script>
<script type="text/javascript" src="share/js/jquery-ui.js"></script>
<script type="text/javascript" src="js/my2.js"></script>
<script src="admin/js/index.js?=r=<%=new Random().nextInt() %>" type="application/javascript"></script>
</head>
<body>
	<div class="bezel" id="bezel-id">
		<div class="head">
			<div class="hleft">
				<span class="head-icon">欧鑫酒店管理系统</span>
			</div>
			<div class="hcenter" style="width:35%"></div>
			<div class="hright">
				<span>您好，欢迎登录使用！
					<a class="outLogin" href="/hotel/assistant/login.jsp">退出</a> </span>
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
				<div class="position">当前位置：系统管理 &gt; 入住登记</div>
				<div class="center">
					<div class="search">
						<s:form action="LiveAction_check" namespace="/actions" name="liveselect">				
							<span>房间类型：<select name="liveselect.roomTypeId">
									<option value="1">单人间</option>
									<option value="2">标准间</option>
									<option value="3">商务间</option>
									<option value="4">情侣主题房</option>
									<option value="5">豪华</option>
									<option value="6">三人间</option>
							</select> </span>
							<span>楼层：<select name="liveselect.floor">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
							</select> </span>
							<span>房价： <select name="liveselect.roomPrice1">
									<option value="100">100</option>
									<option value="150">150</option>
									<option value="200">200</option>
									<option value="250">250</option>
							</select> <select name="liveselect.roomPrice2">
									<option value="400">400</option>
									<option value="500">500</option>
									<option value="700">700</option>
									<option value="1000">1000</option>
							</select> </span>
							<span><input type="text" name="liveselect.roomNumber" /><input
								type="submit" id="search-btn" value="查询" /> </span>
						</s:form>
					</div>
					<div class="tableMain">
						<table class="right-table" width="99%"  border="0.5px solid" 
							cellpadding="0" align="center" cellspacing="0">
							<tbody>
							<c:if test="${0==requestScope.key}">
							    <tr>
							        <td>房间号</td>
							         <td>房间类型</td>
							          <td>房间价格</td>
							           <td>房间状态</td>
							            <td>房间介绍</td>
							    </tr>
							     <c:forEach var="item" items="${requestScope.list}">
									<tr class="live1">
										<td>${item[0]}</td>
										<td class="td1">${item[1]}</td>
										<td class="td1">${item[2]}</td>
										<td class="td1">${item[3]}</td>
										<td class="td1">${item[4]}</td>
									</tr>
								</c:forEach>
							</c:if>
							<c:if test="${1==requestScope.key}">
							    <tr class="live2">
							        <td>房间号</td>
							         <td>电话号码</td>
							           <td>房间状态</td>
							            <td>预定入住日期</td>
							             <td>预计离开日期</td>   
							    </tr>
							   <c:forEach var="ite" items="${requestScope.list}">
									<tr class="live2">
										<td>${ite.room.roomNumber}</td>
										<td>${ite.tel}</td>
										<td style="display:none">${ite.customer.idCard}</td>
										<td>${ite.room.status}</td>
										<td>${ite.bookIntoDate}</td>
										<td>${ite.bookLeaveDate}</td>
									    <td style="display:none">${ite.customer.name}</td>

									</tr>
								</c:forEach>
							</c:if>
								
							</tbody>
						</table>
					</div>
					<div id="page">
						<ul>
							<li class="first"><a href="#">&nbsp;首页&nbsp;</a></li>
							<li class="upPage"><a href="#">&nbsp;上一页&nbsp;</a></li>
							<li><a href="#"> 1 </a></li>
							<li><a href="#"> 2 </a></li>
							<li class="nextPage"><a href="#">&nbsp;下一页&nbsp;</a></li>
							<li class="lastPage"><a href="#">&nbsp;末页&nbsp;</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="floot">版权</div>
	</div>
	<div style="text-align:center;">
		<p>
			来源：<a href="http://www.mycodes.net/" target="_blank">源码之家</a>
		</p>
	</div>
	<div id="div1" style="display:none">
		<s:form action="LiveAction_liveCheck" id="contact" namespace="/actions">
			        <fieldset>房间号:<input class="num" type="text" name="liveInto.roomNumber"></fieldset>
			       <fieldset>联系电话:<input class="tel" type="text" name="liveInto.tel"></fieldset>
			         <fieldset>身份证号：<input class="idCard" type="text" name="liveInto.idCard"></fieldset>
			         <fieldset>姓名:<input class="name" type="text" name="liveInto.name"></fieldset>
				 <fieldset> 入住日期：<input class="liveIntoDate" type="text" readonly="readonly" name="liveInto.liveDate" id="dateset"></fieldset>
				<fieldset>预离开日期:<input class="liveLeaveDate"  type="text" readonly="readonly" name="liveInto.wileaveDate" id="dateset1"></fieldset>
			         <fieldset>押金：<input type="text" name="liveInto.security"></fieldset>
			      <fieldset><Button type="submit">确定</Button></fieldset>
		</s:form>
	</div>
	<div id="div2" style="display:none">
		<s:form id="contact" action="LiveAction_roomCheck" namespace="/actions">
			       <fieldset>房间号:<input class="num" type="text" name="liveInto.roomNumber"></fieldset>
			       <fieldset>联系电话:<input class="tel" type="text" name="liveInto.tel"></fieldset>
			         <fieldset>身份证号：<input class="idCard" type="text" name="liveInto.idCard"></fieldset>
			         <fieldset>姓名:<input class="name" type="text" name="liveInto.name"></fieldset>
				 <fieldset> 入住日期：<input class="liveIntoDate" type="text" readonly="readonly" name="liveInto.liveDate"></fieldset>
				<fieldset>预离开日期:<input class="liveLeaveDate"  type="text" readonly="readonly" name="liveInto.wileaveDate"></fieldset>
			         <fieldset>押金：<input type="text" name="liveInto.security"></fieldset>
			      <fieldset><Button type="submit">确定</Button></fieldset>
		</s:form>
	</div>
</body>
</html>
