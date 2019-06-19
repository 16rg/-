<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pageContent">
	
	<form method="post" action="userupdate2.html?id=${id}" class="pageForm" onsubmit="return validateCallback(this,dialogAjaxDone);">
		<div class="pageFormContent" layoutH="58">
			<div class="unit">
				<label>用户名：</label>
				<input type="text" name="username" value="${bean.username}" size="30" class="required"/>
			</div>
			<div class="unit">
				<label>密码：</label>
				<input type="password" name="password" value="${bean.password}" size="30" class="required"/>
			</div>
			
			<div class="unit">
				<label>学生编号或老师编号：</label>
				<input type="text" name="codenum" size="30" class="required" value="${bean.codenum}"/>
			</div>
		<c:if test="${bean.role>2}">
			<div class="unit">
				<label>班级编号：</label>
				<select name="banjinum" >
						<option  value="${bean.banjinum}">${bean.banjinum}</option>
							<c:forEach items="${banjilist}" var="bean">
                                <option value="${bean.banjinum }" >
                                   	${bean.banjinum }
                                </option>
                                </c:forEach>
     					</select>   
			</div>
			</c:if>
			<c:if test="${bean.role==2}">
			<div class="unit">
				<label>班级编号：</label>
			<c:forEach items="${banjilist}" var="bean">
              <input type="checkbox" name="banjinum" value="${bean.banjinum }" >${bean.banjinum }
            </c:forEach>
			</div>
			</c:if>
			<div class="unit">
				<label>联系方式：</label>
				<input type="text" name="phone" size="30" value="${bean.phone}"/>
			</div>
			<div class="unit">
				<label>所在宿舍：</label>
				<input type="text" name="room" size="30" value="${bean.room}"/>
			</div>
			<div class="unit">
				<label>家庭住址：</label>
				<input type="text" name="address" size="30" value="${bean.address}"/>
			</div>
			
			<div class="unit">
				<label>状态：</label>
				开启<input type="radio" name="userlock" value="0" checked="checked"/> 禁用<input type="radio" name="userlock" value="1"/>
			</div>	
			<div class="unit">
				<label>权限：</label>
				<select name="role" class="required">
				<option  value="${bean.role}">
                 <c:if test="${bean.role=='0'}">
									管理员
									</c:if>
									<c:if test="${bean.role=='1'}">
									系院院长
									</c:if>
									<c:if test="${bean.role=='2'}">
									任课老师
									</c:if> 
									<c:if test="${bean.role=='3'}">
									班主任
									</c:if> 
									<c:if test="${bean.role=='4'}">
									学生
									</c:if> 
                 </option>
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