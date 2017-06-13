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
<link href="share/images/favicon.ico" rel="shortcut icon"/>
<link rel="stylesheet" type="text/css" href="share/css/share.css"/>
<link rel="stylesheet" type="text/css" href="admin/css/default/index.css"/>
<link rel="stylesheet" type="text/css" href="admin/css/default/share.css"/>
<link rel="stylesheet" type="text/css" href="share/css/jquery-ui.css"/>
<link rel="stylesheet" type="text/css" href="css/my1.css"/>
<link rel="stylesheet" type="text/css" href="css/my.css"/>
<script src="share/js/jquery-1.11.0.min.js" type="application/javascript"></script>
<script type="text/javascript" src="share/js/jsUtil.js"></script>
</script>
<script type="text/javascript" src="share/js/jquery-ui.js"></script>
<script type="text/javascript" src="share/js/layer/layer.js"></script>
<script src="admin/js/index.js?r=<%=new Random().nextInt() %>" charset="utf-8" type="text/javascript"></script>
<script src="js/my2.js?r=<%=new Random().nextInt() %>" charset="utf-8" type="text/javascript"></script>

<style type="text/css">
	td{
		width:25%;
	}
	.td1 .ul1 li{
		float:left;
		list-style:none;
	}
</style>
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
            <div class="position">　当前位置：系统管理　&gt; 预定客房</div>
            <div class="center">
            <div class="search">
            <s:form name="bookSelectService" action="economic_book1" namespace="/actions" method="post">
        	预定入住时间：<s:textfield id="dateset" name="bookSelectService.bookLiveDate" readonly="readonly"></s:textfield>
                              预定离开时间：<s:textfield id="dateset1" name="bookSelectService.bookLeaveDate" readonly="readonly"></s:textfield>
	                        房间类型：<s:select  name="bookSelectService.roomType" list="#{1:'单人间',2:'标准间',3:'商务间',4:'豪华间',5:'情侣主题房',6:'三人间'}" listKey="key" listValue="value"></s:select>
           	楼层：<s:select  name="bookSelectService.floor" list="#{1:'1',2:'2',3:'3',4:'4',5:'5',6:'6'}" listKey="key" listValue="value"></s:select>
          	房价：<s:select  name="bookSelectService.price" list="#{1:'100~300',2:'300~500',3:'500~700',4:'700~1000'}" listKey="key" listValue="value"></s:select>
            <s:textfield name="bookSelectService.select" ></s:textfield>
           	<Button type="submit" style="background-color:#666666 ">查询</Button>
            </s:form>
            </div>
            <div class="tableMain">
            <table class="right-table" style="width:100%; color:#fff;"  border="0px" cellpadding="0" align="center" cellspacing="0" >
            <tbody>
            <th>房间号</th><th>房间类型</th><th>房间状态</th><th>楼层</th><th style="width:40px">房价</th>
            <c:forEach var="list" items="${list }">
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
<div class="floot">欧鑫客房管理系统</div> 
</div>
<div style="text-align:center;">
</div>
<div id="div1"  style="display:none">
	<s:form name="bookService" id="contact" action="economic_book2" namespace="/actions" method="post">
		客服编号：<s:textfield name="bookService.stuffNumber"></s:textfield>
		身份证号：<s:textfield name="bookService.idcard"></s:textfield><br>
		联系电话：<s:textfield name="bookService.phone"></s:textfield>
		&nbsp;&nbsp;&nbsp;&nbsp;房间号：<s:textfield name="bookService.roomNumber" id="bookroomNumber"></s:textfield><br>
		入住日期：<s:textfield  name="bookService.liveDate" readonly="readonly" id="selectLiveDate"></s:textfield>
		离开日期：<s:textfield  name="bookService.leaveDate" readonly="readonly" id="selectLeaveDate"></s:textfield><br>
		<!-- &nbsp;&nbsp;&nbsp;&nbsp;<s:submit class="button button-pill button-primary" value="提交"></s:submit> -->
		<Button type="submit">确定</Button>
	</s:form>
</div>
  </body>
</html>
