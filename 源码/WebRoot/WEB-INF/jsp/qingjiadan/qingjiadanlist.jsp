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
<form id="pagerForm" method="post" action="qingjiadan/qingjiadanlist">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${ps}" />
</form>

<!--  
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="demo_page1.html" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					&nbsp;
				</td>
				<td>
					&nbsp;
				</td>
				<td>
					&nbsp;
				</td>
			</tr>
		</table>
		<div class="subBar">
			<ul>
				<li>&nbsp;</li>
				<li>&nbsp;</li>
			</ul>
		</div>
	</div>
	</form>
</div>
-->
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
		
		<li><a class="add" href="qingjiadan/qingjiadanadd.html" target="dialog" mask="true"><span>增加请假单</span></a></li>
		<li><a class="edit" href="qingjiadan/qingjiadanupdate.html?id={sid_user}" target="dialog" mask="true"><span>修改请假单</span></a></li>
		
		<c:if test="${role!='role4'}">
		<li><a class="delete" href="qingjiadan/qingjiadandel.html?id={sid_user}" target="ajaxTodo" title="确定要删除吗?" ><span>删除请假单</span></a></li>
		<li><a class="edit" href="qingjiadan/qingjiadanupdate_sh.html?id={sid_user}" target="dialog" mask="true"><span>审核请假单</span></a></li>
		</c:if>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
			    <th width="100">班级编号</th>
			    <th width="100">学生编号</th>
				<th width="100">姓名</th>
				<th width="100">请假开始时间</th>
				<th width="100">请假结束时间</th>
				<th width="100">请假理由</th>
				<th width="100">审核状态</th>
				<th width="100">审核意见</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${qingjiadanlist}" var="bean"  >
			<tr target="sid_user" rel="${bean.id}">
				<td>
				${bean.banjinum}
				</td>
				<td>
				${bean.codenum}
				</td>
				<td>
				${bean.username}
				</td>
				<td>
				${bean.qjtime1}
				</td>
				<td>
				${bean.qjtime2}
				</td>
				<td>
				${bean.qjcontent}
				</td>
				<td>
				${bean.shenhe}
				</td>
				<td>
				${bean.shenhecontent}
				</td>
			</tr>			
			</c:forEach>
			
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
			<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
				<option value="20">20</option>
				<option value="50">50</option>
				<option value="100">100</option>
				<option value="200">200</option>
			</select>
			<span>条，共${totalCount}条</span>
		</div>
		
		<div class="pagination" targetType="navTab" totalCount="${totalCount}" numPerPage="${ps}" pageNumShown="10" currentPage="${pn}"></div>

	</div>
</div>

  </body>
</html>
