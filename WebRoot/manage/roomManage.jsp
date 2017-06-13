<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'roomwatch.jsp' starting page</title>
    
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
<link rel="stylesheet" type="text/css" href="css/my.css"/>
<link rel="stylesheet" type="text/css" href="share/css/jquery-ui.css"/>
<script src="share/js/jquery-1.11.0.min.js" type="application/javascript"></script>
<script type="text/javascript" src="share/js/jsUtil.js"></script>
<script type="text/javascript" src="share/js/jquery-ui.js"></script>
<script type="text/javascript" src="share/js/layer/layer.js"></script>
<script src="admin/js/index.js" type="application/javascript"></script>
<script src="admin/js/my1.js" type="application/javascript"></script>
  </head>
  
  <body>
    <div class="bezel" id="bezel-id">
    <div class="head">
        <div class="hleft"><span class="head-icon">欧鑫酒店管理系统</span></div>
        <div class="hcenter" style="width:35%">
        </div>
        <div class="hright">
        	<span>您好，欢迎登录使用！<a class="outLogin" href="/hotel/assistant/login.jsp">退出</a></span>
        </div>
    </div>
    <div class="center">
        <div class="cleft" id="cleft-id">	
            <h4 class="on">系统管理</h4>
             <ul style="display:block;">
            	<li class="on"><a href="/hotel/manage/information.jsp">客服信息</a></li>
            </ul>
            <h4>内容管理</h4>
            <ul>
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
        </div>
        <div class="rleft">
            <div class="position">　当前位置：内容管理　&gt; 客房管理</div>
            <div class="center">
            <div class="search">
            <s:form action="RoomAction_check" namespace="/actions">
							<span>房间类型：
							  <select name="roomview.roomTypeId">
									<option value="1">单人间</option>
									<option value="2">标准间</option>
									<option value="3">商务间</option>
									<option value="4">情侣主题房</option>
									<option value="5">豪华</option>
									<option value="6">三人间</option>
							   </select> 
							</span>
							<span>查询方式：
							   <select name="roomview.checkStyle">
									<option value="1">同类型统计</option>
									<option value="2">所有类型统计</option>
									<option value="3">已入住查询</option>
									<option value="4">已预定查询</option>
									<option value="5">空闲房间查询</option>
							   </select>
							</span>
							<input type="text" name="roomview.roomNumber" />
							<input type="submit" id="search-btn" value="查询" /> </span>
						</s:form>
            </div>
          
            <div class="tableMain">
            <table class="right-table" width="99%"  border="0px" cellpadding="0" align="center" cellspacing="0" >
               <thead>
           <c:if test="${1==requestScope.key}">
        	<tr>
				<th>房间类型名</th>
				<th>状态</th>
				<th>数量</th>
            </tr>
		</thead>
        <tbody>
        	   <c:forEach var="item" items="${requestScope.list}">
        	       <tr class="">
						<td>${item[0]}</td>
						<td class="td1">${item[1]}</td>
						<td class="td1">${item[2]}</td>
				 </tr>
        	   </c:forEach>
        </tbody>
        </c:if>
        
        <c:if test="${2==requestScope.key}">
        <thead>
        	<tr>
				<th>状态</th>
				<th>数量</th>
            </tr>
		</thead>
        <tbody>
        	   <c:forEach var="item" items="${requestScope.list}">
        	       <tr class="">
						<td>${item[0]}</td>
						<td class="td1">${item[1]}</td>
				 </tr>
        	   </c:forEach>
        </tbody>
        </c:if>
        
        
         <c:if test="${3==requestScope.key}">
         <thead>
        	<tr>
				<th>房间号</th>
				<th>房间类型</th>
				<th>房间楼层</th>
				<th>房间状态</th>
				<th>修改</th>
				<th>删除</th>
            </tr>
		</thead>
        <tbody>
        	   <c:forEach var="item" items="${requestScope.list}">
        	       <tr class="">
						<td class="Num">${item[0]}</td>
						<td class="RType">${item[1]}</td>
						<td class="td1">${item[2]}</td>
						<td class="Rstatus">${item[3]}</td>
						<td class="dx1">修改</td>
						<td class="sc1">删除</td>	
				   </tr>
        	   </c:forEach>
        </tbody>
        </c:if>
        
         <c:if test="${4==requestScope.key}">
         <thead>
        	<tr>
				<th>房间号</th>
				<th>房间类型</th>
				<th>房间状态</th>
				<th>顾客姓名</th>
				<th>顾客电话</th>
				<th>到达日期</th>
				<th>预定离开日期</th>
				
            </tr>
		</thead>
        <tbody>
        	   <c:forEach var="item" items="${requestScope.list}">
        	       <tr class="">
						<td>${item[0]}</td>
						<td class="td1">${item[1]}</td>
						<td class="td1">${item[2]}</td>
						<td class="td1">${item[3]}</td>
						<td class="td1">${item[4]}</td>
						<td class="td1">${item[5]}</td>
						<td class="td1">${item[6]}</td>
				 </tr>
        	   </c:forEach>
        </tbody>
        </c:if>
      
      <c:if test="${5==requestScope.key}">
        <thead>
        	<tr>
				<th>房间号</th>
				<th>顾客电话</th>
				<th>顾客身份证号</th>
				<th>预计到达日期</th>
				<th>修改</th>
				<th>删除</th>
            </tr>
		</thead>
        <tbody>
        	   <c:forEach var="item" items="${requestScope.list}">
        	       <tr>
						<td id="roomNum">${item[0]}</td>
						<td class="td1" id="tel">${item[1]}</td>
						<td class="td1" id="idCard">${item[2]}</td>
						<td class="td1" id="bookIntoDate">${item[3]}</td>
						<td class="td1" id="dx">修改</td>
						<td class="td1" id="sc">删除</td>
						
				 </tr>
        	   </c:forEach>
        </tbody>
        </c:if>
            
            
      <c:if test="${6==requestScope.key}">
          <thead>
        	<tr>
				<th>房间号</th>
				<th>房间类型</th>
				<th>房间楼层</th>
				<th>房间状态</th>
				<th>增加</th>
				<th>修改</th>
				<th>删除</th>
            </tr>
		</thead>
        <tbody>
        	   <c:forEach var="item" items="${requestScope.list}">
        	       <tr>
						<td class="Num">${item[0]}</td>
						<td class="RType" id="roomType">${item[1]}</td>
						<td class="td1" id="floor">${item[2]}</td>
						<td class="Rstatus" id="status">${item[3]}</td>
						<td class="add">增加</td>
						<td class="dx1">修改</td>
						<td class="sc1">删除</td>	
				  </tr>
        	   </c:forEach>
        </tbody>
        </c:if>
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
<p>来源：<a href="http://www.baidu.com" target="_blank">友情链接</a></p>
</div>

    
  <div id="tab" style="display:none">  
  <s:form id="contact" action="RoomAction_check2" method="post" >
    <h3>[修改]</h3>
    <fieldset>
     房间号:<input type="text"  name="gsService.roomNum"  class="roomNum" tabindex="1">
    </fieldset>
    <fieldset>
     顾客电话 <input type="tel" name="gsService.tel" class="tel" tabindex="3">
    </fieldset>
    <fieldset>
      顾客身份证号:<input type="text" name="gsService.idCard" class="idCard" tabindex="4">
    </fieldset>
    <fieldset>
      预定到达日期:<input type="text"  name="gsService.bookIntoDate" class="bookIntoDate" tabindex="4" id="dateset">
    </fieldset>
    <fieldset>
      <button type="submit">修改</button>
    </fieldset>
  </s:form>

</div>

<!-- 删除预定记录 -->
  <div id="tab2" style="display:none">  
  <s:form id="contact" action="RoomAction_check3" method="post" >
    <h3>[确定删除该预定记录?]</h3>
    <fieldset>
     房间号:<input type="text"  name="gsService.roomNum" readonly="readonly" class="roomNum" tabindex="1">
    </fieldset>
    <fieldset>
     顾客电话 <input type="tel" name="gsService.tel" readonly="readonly" class="tel" tabindex="3">
    </fieldset>
    <fieldset>
      顾客身份证号:<input type="text" name="gsService.idCard"  class="idCard" tabindex="4" readonly="readonly">
    </fieldset>
    <fieldset>
      预定到达日期:<input type="text"  name="gsService.bookIntoDate" class="bookIntoDate" tabindex="4" readonly="readonly">
    </fieldset>
    <fieldset>
      <button type="submit">删除</button>
    </fieldset>
  </s:form>

</div>



<!-- 增加客房 -->
  <div id="tab3" style="display:none">  
  <s:form id="contact" action="RoomAction_check4" method="post" >
    <h3>[确定增加该客房记录?]</h3>
    <fieldset>
     房间号:<input type="text"  name="room.roomNumber"  class="roomNum" tabindex="1">
    </fieldset>
    <fieldset>
     房间类型<select name="room.roomType">
           <option value="1">单人间</option>
           <option value="2">标准间</option>
           <option value="3">商务间</option>
           <option value="4">情侣主题房</option>
           <option value="5">豪华房</option>
           <option value="6">三人间</option>
        </select>
    <fieldset>
      房间楼层:<select name="room.floor">
             <option>1</option>
             <option>2</option>
             <option>3</option>
             <option>4</option>
             <option>5</option>
             <option>6</option>
         </select>
    </fieldset>
    <fieldset>
      <button type="submit">增加</button>
    </fieldset>
  </s:form>
</div>



<!--修改客房-->
  <div id="tab4" style="display:none">  
  <s:form id="contact" action="RoomAction_check5" method="post" >
    <h3>[确定修改该客房信息?]</h3>
    <fieldset>
     房间号:<input type="text"  name="room.roomNumber" readonly="readonly" class="num" tabindex="1">
    </fieldset>
    <fieldset>
     房间类型<select name="room.roomType" id="roomType">
           <option value="1">单人间</option>
           <option value="2">标准间</option>
           <option value="3">商务间</option>
           <option value="4">情侣主题房</option>
           <option value="5">豪华房</option>
           <option value="6">三人间</option>
        </select>
    <fieldset>
    <br/>
      房间状态:<select name="room.status" id="status">
           <option value="空闲">空闲状态</option>
           <option value="暂停使用">暂停使用</option>
         </select>
    </fieldset>
    <fieldset>
      <button type="submit">修改</button>
    </fieldset>
  </s:form>
</div>



<!--删除客房-->
  <div id="tab5" style="display:none">  
  <s:form id="contact" action="RoomAction_check6" method="post" >
    <h3>[确定删除该客房?]</h3>
    <fieldset>
     房间号:<input type="text"  name="room.roomNumber" readonly="readonly" class="num" tabindex="1">
    </fieldset>
    <fieldset>
     房间类型 :<input type="text"  name="" readonly="readonly" class="roomType" tabindex="1">
    </fieldset>
  <fieldset>
      房间状态: <input type="text"  name="" readonly="readonly" class="status" tabindex="1">
    </fieldset>
    <fieldset>
      <button type="submit">删除</button>
    </fieldset>
  </s:form>
</div>
  </body>
</html>
