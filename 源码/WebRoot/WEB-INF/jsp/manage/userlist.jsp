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
<form id="pagerForm" method="post" action="userlist.html">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${ps}" />
</form>


<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="user/searchuser.html" method="post">
	<div class="searchBar">
		
<table class="searchContent">
			<tr>
				<td>
				用户名：<select name="keyword" class="required">
				<option value="">请选择用户名</option>
							<c:forEach items="${searchuserlist}" var="bean">
                                <option value="${bean.username }" >
                                   	${bean.username }
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
		<c:if test="${role!='role4'}">
			<li><a class="add" href="useradd.html" target="dialog" mask="true"><span>添加</span></a></li>
			<li><a class="delete" href="userdel.html?id={sid_user}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="userupdate.html?id={sid_user}" target="dialog" mask="true"><span>修改</span></a></li>
		  </c:if>
		   <li><a  href="usershow.html?id={sid_user}" target="dialog" mask="true"><span><img src="images/image004.png"/>查看</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="120">用户名</th>
				<th width="100">状态</th>
				<th width="100">权限</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${userlist}" var="list">
			<tr target="sid_user" rel="${list.id}">
				<td>${list.username}</td>
				<td><c:if test="${list.userlock==0}">开启</c:if><c:if test="${list.userlock==1}">禁用</c:if></td>
			     <td><c:if test="${list.role==0}">管理员</c:if>
			     <c:if test="${list.role==1}">系院院长</c:if>
			     <c:if test="${list.role==2}">任课老师</c:if>
			     <c:if test="${list.role==3}">班主任</c:if>
			     <c:if test="${list.role==4}">学生</c:if>
			     </td>
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
