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
<form id="pagerForm" method="post" action="kaoqinlog/kaoqinloglist">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${ps}" />
</form>

<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="kaoqinlog/searchkaoqin.html" method="post">
	<div class="searchBar">
		
<table class="searchContent">
			<tr>
				<td>
				班级编号：
				<input type="text" name="banjinum" size="20" class="required"/>
				</td>
				<td>
				课程：
				<input type="text" name="kechengname" size="20" class="required"/>
				</td>
				<td>
				任课老师：
				<input type="text" name="teacher" size="20" class="required"/>
				</td>
				<td>
				学生编号：
				<input type="text" name="codenum" size="20" class="required"/>
				</td>
				<td>
				日期：
				<input type="text" name="riqi" size="20" class="date"/>
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
		<li><a class="add" href="kaoqinlog/kaoqinlogadd.html" target="dialog" mask="true"><span>增加考勤</span></a></li>
		<li><a class="edit" href="kaoqinlog/kaoqinlogupdate.html?id={sid_user}" target="dialog" mask="true"><span>修改考勤</span></a></li>
		<li><a class="delete" href="kaoqinlog/kaoqinlogdel.html?id={sid_user}" target="ajaxTodo" title="确定要删除吗?" ><span>删除考勤</span></a></li>
	    </c:if>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="78">
		<thead>
			<tr>
			    <th width="100">日期</th>
			    <th width="100">课程</th>
			    <th width="100">班级编号</th>
				<th width="100">任课老师</th>
				<th width="100">学号</th>
				<th width="100">是否旷课</th>
				<th width="100">状态</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${kaoqinloglist}" var="bean"  >
			<tr target="sid_user" rel="${bean.id}">
			    <td>
				${bean.riqi}
				</td>
				<td>
				${bean.kechengname}
				</td>
				<td>
				${bean.banjinum}
				</td>
				<td>
				${bean.teacher}
				</td>
				<td>
				${bean.codenum}
				</td>
				<td>
				<c:if test="${bean.iskuangke==1}">旷课</c:if>
				</td>
				<td>
				${bean.kqtype}
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
