<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pageContent">
	
	<form method="post" action="kecheng/kechengadd2.html" class="pageForm" onsubmit="return validateCallback(this,dialogAjaxDone);">
		<div class="pageFormContent" layoutH="58">
			<div class="unit">
				<label>班级编号：</label>
				<select name="banjinum" class="required">
				<option value="">请选择班级:</option>
						<c:forEach items="${banjilist}" var="bean">
                                <option value="${bean.banjinum }" >
                                   	${bean.banjinum }
                                </option>
                                </c:forEach>
				</select>
			</div>
			<div class="unit">
				<label>顺序：</label>
				<select name="kechenglock" class="required">
					<option value="">请选择课程顺序</option>
					<%  
                        for(int i=11;i>=1;i--)   
                            {   
                                out.print("<option   value="+i+">第"+i+"节</option>");  
                            }   
                     %>  
				</select>
			</div>
			<div class="unit">
				<label>星期一课程名：</label>
				<input type="text" name="kechengname1" size="30" class="required"/>
			</div>
			<div class="unit">
				<label>星期二课程名：</label>
				<input type="text" name="kechengname2" size="30" class="required"/>
			</div>
			<div class="unit">
				<label>星期三课程名：</label>
				<input type="text" name="kechengname3" size="30" class="required"/>
			</div>
			<div class="unit">
				<label>星期四课程名：</label>
				<input type="text" name="kechengname4" size="30" class="required"/>
			</div>
			<div class="unit">
				<label>星期五课程名：</label>
				<input type="text" name="kechengname5" size="30" class="required"/>
			</div>
			<div class="unit">
				<label>星期六课程名：</label>
				<input type="text" name="kechengname6" size="30" class="required"/>
			</div>
			<div class="unit">
				<label>星期天课程名：</label>
				<input type="text" name="kechengname7" size="30" class="required"/>
				<!--  select name="kechengname7" class="required">
				<option value="">请选择科目</option>
						<c:forEach items="${subjectilist}" var="bean">
                                <option value="${bean.subjectname }" >
                                   	${bean.subjectname }
                                </option>
                                </c:forEach>
				</select>
				-->
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