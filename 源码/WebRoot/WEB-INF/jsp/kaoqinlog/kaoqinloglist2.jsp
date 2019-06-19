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
<script type="text/javascript">
function uncheckAll()
{
    //var chkall = document.getElementById("chk_selall");
    var chkother = document.getElementsByTagName("input");
    var j = 0;
    
    for (var i=0;i<chkother.length;i++)
    {
        if(chkother[i].type=='checkbox' && chkother[i].id.indexOf('chk_row')>=0)
        {
            if(chkother[i].checked==false)
            {
                j = 1;
            }
        }
    }
  //  if(j==0)
  //  {
   //     chkall.checked=true;
   // }
  //  else
  //  {
    //    chkall.checked=false;
   // }
}


</script>
  </head>
  
  <body>
<form id="pagerForm" method="post" action="kaoqinlog/kaoqinloglist">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${ps}" />
</form>

<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="kaoqinlog/kaoqinloglist2.html" method="post">
	<div class="searchBar">
		
<table class="searchContent">
			<tr>
				<td>
				班级编号：
				<select name="banjinum" class="required">
				<option value="">请选择班级:</option>
						<c:forEach items="${banjilist}" var="bean">
                                <option value="${bean.banjinum }" >
                                   	${bean.banjinum }
                                </option>
                                </c:forEach>
				</select> 
				</td>
				<td>
				课程：
				<select name="kechengname" class="required">
				<option value="">请选择课程:</option>
						<c:forEach items="${subjectlist}" var="bean">
                                <option value="${bean.subjectname }" >
                                   	${bean.subjectname }
                                </option>
                                </c:forEach>
				</select>
				</td>
				<td>
				任课老师：
				<input type="text" name="teacher" size="20" class="required"/>
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
	
	<form method="post" action="kaoqinlog/kaoqinlogaddlist.html" onsubmit="return navTabSearch(this);">
	<table class="table" width="100%" layoutH="168">
		<thead>
			<tr>
			<th style="width: 40px;" align="center">
									选择
								</th>
			    <th width="100">日期</th>
			    <th width="100">课程</th>
			    <th width="100">班级编号</th>
				<th width="100">任课老师</th>
				<th width="100">学号</th>
				<th width="100">姓名</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${kaoqinloglist}" var="bean"  >
			<tr target="sid_user" rel="${bean.id}">
			<td align="center">
										<input id="chk_row" name="ids" type="checkbox"
											onclick="uncheckAll()" value="${bean.id}" />
			</td>
			    <td>
				${riqi}
				 <input type="hidden" name="riqi"  value="${riqi }"/>  
				</td>
				<td>
				${kechengname}
				<input type="hidden" name="kechengname"  value="${kechengname }"/>  
				</td>
				<td>
				${banjinum}
				<input type="hidden" name="banjinum"  value="${banjinum }"/>  
				</td>
				<td>
				${teacher}
				<input type="hidden" name="teacher"  value="${teacher }"/>  
				</td>
				<td>
				${bean.codenum}
				</td>
				<td>
				${bean.username}
				</td>
			</tr>			
			</c:forEach>
			
		</tbody>
	</table>
	<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
		</div>
	</form>
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
