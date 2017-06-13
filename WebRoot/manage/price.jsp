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
    
    <title>My JSP 'write.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

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
  <script type="text/javascript" src="js/my.js"></script>
  </head>
  <style>
 #cla {
    margin-left: 10px;
    width:300px;
    height: 400px;
} 
.box1{
    width: 250px;
    margin: 20px; 
    padding: 10px;
    min-height: 50px;
    position:relative;
    display: inline-block; 
    background: -webkit-gradient(linear, 0% 20%, 0% 1000%, from(#fff), to(#fff), color-stop(.1,#f3f3f3));
    border: 1px solid #ccc;
    -webkit-box-shadow: 0px 3px 30px rgba(0, 0, 0, 0.1) inset;
    -webkit-border-bottom-right-radius: 6px 50px;    
}
.box1{
  margin-left:30px;
}
.box4{
  margin-left:30px;
  clear: both;
}
.box7 span {
  font-size: 17px;
}
.box7 .btn {
  font-size: 20px;
  border:none;
  padding:15px 20px;
  border-radius:25px;
  background-color: #FFFF99;
}

.txt{
	font-size: 20px;
  border:none;
  padding:15px 20px;
  border-radius:25px;
  background-color: #FFFF99;
}

 .box7 span {
   font-size: 18px;
   font-weight: solid;
} 
img {
    width: 100%;
    margin-top: 15px;
}

p{ 
    margin-top: 15px;
    text-align: justify;
}

h1{
    font-size: 20px;
    font-weight: bold;
    margin-top: 5px; 
    text-shadow: 1px 1px 3px rgba(0,0,0,0.3);
}
 .btn:hover{
    text-decoration: underline;
    font-size: 30px;

} 
</style>
  <body>
   <div class="bezel" id="bezel-id">
    <div class="head">
        <div class="hleft"><span class="head-icon">酒店管理系统</span></div>
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
            <div class="position">　当前位置：内容管理　&gt; 价格调整</div>
            <div class="tableMain">
            <table class="right-table" width="99%"  border="0px" cellpadding="0" align="center" cellspacing="0" >
    <table id="cla">
     <tr>
     <td><div class="box1">
       <h1>单间</h1>   
       <img src="images/danren.png">
        <p>1</p> 
       <br/>
    </div>

    </td>

     <td>
      <div class="box1">
       <h1>标准间</h1>   
       <img src="images/biaojian.png">
       <p>2</p> 
       <br/>
</div>
</td>


     <td>
        <div class="box1">
       <h1>商务间</h1>   
       <img src="images/business.png">
       <p>3</p> 
       <br/>
</div>
     </td>
   </tr>

   <tr>
       <td>
         <div class="box1">
       <h1>情侣主题房</h1>   
       <img src="images/love.png">
       <p>4</p> 
       <br/>
</div>
       </td>


        <td>
           <div class="box1">
       <h1>三人间</h1>   
       <img src="images/shanren.jpg">
       <p>5</p> 
       <br/>
</div>
        </td>

         <td>
             <div class="box1">
       <h1>豪华房</h1>   
       <img src="images/haohua.jpg">
       <p>6</p> 
       <br/>
</div>
         </td>
     </tr>
 </table>
</div>
</div>
    </div>
<div class="floot">版权</div> 
</div>
<div style="text-align:center;">
<p>来源：<a href="http://www.mycodes.net/" target="_blank">源码之家</a></p>
</div>
<div class="box7" style="display:none;">
 <s:form id="contact" action="PriceAction_modifyPrice" namespace="/actions">
    <h3>[确定更改价格?]</h3>
    <fieldset>
     房间类型号:<input id="roomType" class="txt" type=text name="priceService.roomType" tabindex="1"/>
    </fieldset>
     <fieldset>
       房间价格:<input class="txt" type=text name="priceService.price"/>
     </fieldset>
    <fieldset>
    修改日期:</span><input class="txt" type=text id="dateset" rowspan="3" name="priceService.modifyDate"/>
    </fieldset>
    <fieldset>
      <button type="submit">确定</button>
    </fieldset>
  </s:form> 
</div>
  </body>
</html>
