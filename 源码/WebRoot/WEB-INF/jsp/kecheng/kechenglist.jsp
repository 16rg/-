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
<form id="pagerForm" method="post" action="kecheng/kechenglist.html">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${ps}" />
</form>


<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="kecheng/searchkecheng.html" method="post">
	<div class="searchBar">
		
<table class="searchContent">
			<tr>
				<td>
				班级：
				<select name="keyword" class="required">
				<option value="">请选择班级:</option>
						<c:forEach items="${banjilist}" var="bean">
                                <option value="${bean.banjinum }" >
                                   	${bean.banjinum }
                                </option>
                                </c:forEach>
				</select>
				</td>
			</tr>
		</table>
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></li>
			</ul>
		</div>
	</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
		<c:if test="${role!='role2'}">
			<li><a class="add" href="kecheng/kechengadd.html" target="dialog" mask="true"><span>添加</span></a></li>
			<li><a class="delete" href="kecheng/kechengdel.html?id={sid_kecheng}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="kecheng/kechengupdate.html?id={sid_kecheng}" target="dialog" mask="true"><span>修改</span></a></li>
	    </c:if>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">

		<tbody>
					<tr style="width: 100%;border-collapse:collapse;background-color: #edf3f7;">
<td></td>
<td>星期一</td>
<td>星期二</td>
<td>星期三</td>
<td>星期四</td>
<td>星期五</td>
<td>星期六</td>
<td>星期天</td>
<td>班级</td>
</tr>
			
	<c:forEach items="${kechenglist}" var="bean">
<tr target="sid_kecheng" rel="${bean.id}">
	<td height="30">	第${bean.kechenglock }节</td>
         <td height="30">${bean.kechengname1 }</td>                        
     <td height="30">${bean.kechengname2 }</td>                           
      <td height="30">${bean.kechengname3 }</td>                        
     <td height="30">${bean.kechengname4 }</td>
      <td height="30">${bean.kechengname5 }</td>                        
     <td height="30">${bean.kechengname6 }</td>
      <td height="30">${bean.kechengname7 }</td>  
      <td height="30">${bean.banjinum }</td>                        

</tr>
		</c:forEach>	
		</tbody>
	</table>
	<div class="panelBar">
	<div class="pages">
			<span>显示</span>
			<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
				<option value="20" <c:if test="${numPerPage ==20 }">selected="selected"</c:if>>20</option>
				<option value="50" <c:if test="${numPerPage ==50 }">selected="selected"</c:if>>50</option>
				<option value="100" <c:if test="${numPerPage ==100 }">selected="selected"</c:if>>100</option>
				<option value="200" <c:if test="${numPerPage ==200 }">selected="selected"</c:if>>200</option>
			</select>
			<span>条，共${totalCount}条</span>
		</div>
		
		<div class="pagination" targetType="navTab" totalCount="${totalCount}" numPerPage="${ps}" pageNumShown="10" pageNum="${pn}"></div>

	</div>
</div>


  </body>
</html>
