<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pageContent">
	
	<form method="post" action="useradd2.html" class="pageForm" onsubmit="return validateCallback(this,dialogAjaxDone);">
		<div class="pageFormContent" layoutH="58">
			<div class="unit">
				<label>用户名：</label>
				<input type="text" name="username" size="30" class="required"/>
			</div>
			<div class="unit">
				<label>密码：</label>
				<input type="password" name="password" size="30" class="required"/>
			</div>
			<div class="unit">
				<label>学生编号或老师编号：</label>
				<input type="text" name="codenum" size="30" class="required"/>
			</div>
			
			<div class="unit">
				<label>联系方式：</label>
				<input type="text" name="phone" size="30" />
			</div>
			<div class="unit">
				<label>所在宿舍：</label>
				<input type="text" name="room" size="30" />
			</div>
			<div class="unit">
				<label>家庭住址：</label>
				<input type="text" name="address" size="30" />
			</div>
			<div class="unit">
				<label>状态：</label>
				开启<input type="radio" name="userlock" value="0" checked="checked"/> 禁用<input type="radio" name="userlock" value="1"/>
			</div>	
			<div class="unit">
				<label>班级：</label>
				<select name="banjinum" >
						<option  value="">其他</option>
							<c:forEach items="${banjilist}" var="bean">
                                <option value="${bean.banjinum }" >
                                   	${bean.banjinum }
                                </option>
                                </c:forEach>
     					</select>   
			</div>	
			<div class="unit">
				<label>权限：</label>
				<select name="role" class="required">
					<option value="0">管理员</option>
					<option value="1">系院院长</option>
					<option value="2">任课老师</option>
					<option value="3">班主任</option>
					<option value="4">学生</option>
				</select>
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