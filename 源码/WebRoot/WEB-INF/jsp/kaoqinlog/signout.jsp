<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <script type="text/javascript">
    </script>

<div class="pageContent">
	
	<form method="post" name=form1 action="kaoqinlog/kaoqinlogexit4stu2.html" class="pageForm" onsubmit="return validateCallback(this,dialogAjaxDone);">
		<div class="pageFormContent" layoutH="58">
		
		<div class="unit">
				<label>所在班级：</label>
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
				<label>当前课程:</label>
				<select name="kechengname" class="required">
				<option value="">请选择课程:</option>
						<c:forEach items="${subjectlist}" var="bean">
                                <option value="${bean.subjectname }" >
                                   	${bean.subjectname }
                                </option>
                        </c:forEach>
				</select> 
			</div>
			
			<div class="unit">
				<label>任课老师:</label>
				 <input type="text" name="teacher" class="required" /> 
			</div>
			<div class="unit">
				<label>学号:</label>
				 <input type="text" name="codenum" class="required"  value="${codenum}"/> 
			</div>
			<div class="unit">
				<label>当前日期:</label>
				 <input type="text" name="riqi" class="date"  value="<%=new java.text.SimpleDateFormat("yyyy-MM-dd").format(new Date()) %>"/> 
			</div>	
			</div>	
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">签退</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
		</div>
	</form>
	
</div>