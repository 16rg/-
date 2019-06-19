<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pageContent">
	
	<form method="post" action="userupdate2.html?id=${id}" class="pageForm" onsubmit="return validateCallback(this,dialogAjaxDone);">
		<div class="pageFormContent" layoutH="58">
			<div class="unit">
				<label>用户名：</label>
				<input type="text" disabled name="username" value="${bean.username}" size="30" class="required"/>
			</div>
			<div class="unit">
				<label>学生编号或老师编号：</label>
				<input type="text" disabled name="codenum" size="30" class="required" value="${bean.codenum}"/>
			</div>
				<c:if test="${bean.role>0}">
			<div class="unit">
				<label>班级编号：</label>
					<input type="text" disabled name="banjinum" size="30" class="required" value="${bean.banjinum}"/>
			</div>
			</c:if>
			<div class="unit">
				<label>联系方式：</label>
				<input type="text" disabled name="phone" size="30" value="${bean.phone}"/>
			</div>
			<div class="unit">
				<label>所在宿舍：</label>
				<input type="text" disabled name="room" size="30" value="${bean.room}"/>
			</div>
			<div class="unit">
				<label>家庭住址：</label>
				<input type="text" disabled name="address" size="30" value="${bean.address}"/>
			</div>
			
				
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
		</div>
	</form>
	
</div>