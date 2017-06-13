<%@ page language="java" import="java.util.*,java.text.*" pageEncoding="UTF-8"%>
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
    
    <title>My JSP 'leave.jsp' starting page</title>
    
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
<script type="text/javascript" src="js/jquery.form.js"></script>
<script src="admin/js/index.js?r=<%=new Random().nextInt() %>" type="application/javascript"></script>
<script src="admin/js/myjs.js?r=<%=new Random().nextInt() %>" charset="utf-8" type="application/javascript"></script>

  </head>
  
  <body>

    <div class="bezel" id="bezel-id">
    <div class="head">
        <div class="hleft"><span class="head-icon">欧鑫酒店管理系统</span></div>
        <div class="hcenter" style="width:35%">
        </div>
        <div class="hright">
        	<span>您好，欢迎登录使用！ 　<a class="outLogin" href="/hotel/assistant/login.jsp">退出</a></span>
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
            <div class="position">　当前位置：系统管理　&gt; 退房结算</div>
            <div class="center">
            <s:form name="leaveSelectService" action="leaveAction_leaveSelect" namespace="/actions" method="post">
            
           	请输入房间号：<s:textfield name="leaveSelectService.select" ></s:textfield>
           		<Button type="submit" class="btn1">查询</Button>
            </s:form>
            <div class="tableMain">
            <table class="right-table" style="color:red" width="99%"  border="0px" cellpadding="0" align="center" cellspacing="0" >
            <tbody>
            	<th>房间号</th><th>房间状态</th><th>姓名</th><th>身份证号</th><th>联系电话</th><th>押金</th><th>店内消费</th>
            	<th>入住日期</th><th>预计离开日期</th><th>结算</th>
       			<c:forEach var="item" items="${list1 }">
       				<tr class="tr3">
						<td class="td3">${item[0] }</td>
						<td class="td3">${item[1] }</td>
						<td class="td3">${item[2] }</td>
						<td class="td3">${item[3] }</td>
						<td class="td3">${item[4] }</td>
						<td class="td3">${item[5] }</td>
						<td class="td3">${allRoomPrise }</td>
						<td class="td3">${item[7] }</td>
						<td class="td3">${item[8] }</td>
						<td class="td31">结算</td>
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
<div style="text-align:center;">
<p>来源：<a href="http://www.mycodes.net/" target="_blank">源码之家</a></p>
</div>
<div id="allRoomPrise" style="display:none">${allRoomPrise }</div>
<div id="change1" style="display:none">${change }</div>
<div id="div3" style="display:none">
    <s:form id="contact" action="leaveAction_leave" namespace="/actions" name="leaveService">
         <fieldset>房间编号：<s:textfield name="leaveService.roomNumber" id="roomId"></s:textfield></fieldset>
         <fieldset>身份证号：<s:textfield name="leaveService.idCard" id="idcard"></s:textfield> <fieldset>
        <fieldset> 联系电话：<s:textfield name="leaveService.tel" id="phone"></s:textfield><fieldset>
         <fieldset>入住日期：<s:textfield name="leaveService.liveIntoDate" id="liveIntoDate"></s:textfield> <fieldset>
        <fieldset> 离开日期：<s:textfield name="leaveService.leaveDate" id="liveOutDate"></s:textfield> <fieldset>
        <fieldset> 总房价：<s:textfield name="leaveService.totalPrice" id="allRoomPrise1"></s:textfield> <fieldset>
	 <fieldset>押金：<s:textfield name="leaveService.security" id="security"></s:textfield> <fieldset>
	 <fieldset>交费：<s:textfield name="leaveService.pay"></s:textfield> <fieldset>
    <fieldset><Button type="submit">确定</Button></fieldset>
    </s:form>
    
</div>
	<div id="change" style="display:none">
	<s:form action="leaveAction_changeStatus" namespace="/actions">
		找零：<s:textfield id="change21"></s:textfield>
		<s:submit value="确定"></s:submit>
		</s:form>
	</div>
  </body>
</html>
