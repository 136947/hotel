<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
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
<link rel="stylesheet" type="text/css" href="css/my.css"/>
<script src="share/js/jquery-1.11.0.min.js" type="application/javascript"></script>
<script type="text/javascript" src="share/js/jsUtil.js"></script>
<script type="text/javascript" src="share/js/jquery-ui.js"></script>
<script type="text/javascript" src="share/js/layer/layer.js"></script>
<script src="admin/js/index.js?r=<%=new Random().nextInt()%>" type="application/javascript"></script>
  </head>
  
  <body>
   <div class="bezel" id="bezel-id">
    <div class="head">
        <div class="hleft"><span class="head-icon">欧鑫酒店管理系统</span></div>
        <div class="hcenter" style="width:35%">

        </div>
        <div class="hright">
        	<span> 您好，欢迎登录使用<a class="outLogin" href="/hotel/assistant/login.jsp">退出</a></span>
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
            <div class="position">　当前位置：内容管理　&gt; 房态一览</div>
            <div class="center">
            <div class="search">
            <s:form name="watchSelectService"  action="roomWatchAction_roomWatch" namespace="/actions" method="post">
                        房间类型：<s:select  name="watchSelectService.roomType" list="#{1:'单人间',2:'标准间',3:'商务间',4:'豪华间',5:'情侣主题房',6:'三人间'}" listKey="key" listValue="value"></s:select>
           	楼层：<s:select  name="watchSelectService.floor" list="#{1:'1',2:'2',3:'3',4:'4',5:'5',6:'6'}" listKey="key" listValue="value"></s:select>
          	房价：<s:select  name="watchSelectService.price" list="#{1:'100~300',2:'300~500',3:'500~700',4:'700~1000'}" listKey="key" listValue="value"></s:select>
            <s:textfield name="watchSelectService.select" ></s:textfield>
           	<Button type="submit" class="btn1">查询</Button>
            </s:form>
            <div class="tableMain">
            <table class="right-table" width="99%"  border="0px" cellpadding="0" align="center" cellspacing="0" >
            <tbody>
			<th>房间号</th><th>房间类型</th><th>房间状态</th><th>楼层</th><th>房价</th>
            <c:forEach var="list" items="${list1 }">
           		<tr class="tr1">
           			<td>${list[0] }</td>
           			<td>${list[1] }</td>
           			<td>${list[2] }</td>
           			<td>${list[3] }</td>
           			<td>${list[4] }</td>
           		</tr>
            </c:forEach>
            </tbody>
            </table>
            </div>
        <div id="page">
            <ul>
            <li class="first"><a href="#">&nbsp;首页&nbsp;</a></li>
            <li class="upPage"><a href="#">&nbsp;上一页&nbsp;</a></li>
            <li><a href="#">　1　</a></li>
            <li><a href="#">　2　</a></li>
            <li class="nextPage"><a href="#">&nbsp;下一页&nbsp;</a></li>
            <li class="lastPage"><a href="#">&nbsp;末页&nbsp;</a></li>
            </ul>
        </div>
</div>
</div>
    </div>
<div class="floot">版权</div> 
</div>
  </body>
</html>
