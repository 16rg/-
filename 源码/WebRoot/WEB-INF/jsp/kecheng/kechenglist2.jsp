<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
<form id="pagerForm" method="post" action="subjectlist.html">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${ps}" />
</form>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
		</ul>
	</div>
	<table class="table" width="100%" layoutH="78">
<tr style="width: 100%;border-collapse:collapse;background-color: #edf3f7;">
<td></td>
<td>星期一</td>
<td>星期二</td>
<td>星期三</td>
<td>星期四</td>
<td>星期五</td>
<td>星期六</td>
<td>星期天</td>
</tr>
<c:forEach items="${kechenglist}" var="bean">
<tr>
	
	<td height="60">	第${bean.kechenglock }节</td>
         <td height="60">${bean.kechengname1 }</td>                        
     <td height="60">${bean.kechengname2 }</td>                           
      <td height="60">${bean.kechengname3 }</td>                        
     <td height="60">${bean.kechengname4 }</td>
      <td height="60">${bean.kechengname5 }</td>                        
     <td height="60">${bean.kechengname6 }</td>
      <td height="60">${bean.kechengname7 }</td>                        
     


</tr>
 </c:forEach>

</table>
</div>

  </body>
</html>
