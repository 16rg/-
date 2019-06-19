<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <script type="text/javascript">
    </script>

<div class="pageContent">
	
	<form method="post" name=form1 action="kaoqinlog/kaoqinlogupdate2.html" class="pageForm" onsubmit="return validateCallback(this,dialogAjaxDone);">
		<div class="pageFormContent" layoutH="58">
		<div class="unit">
				<label>班级编号：</label>
				<select name="banjinum" class="required">
				<option value="${bean.banjinum}">${bean.banjinum}</option>
						<c:forEach items="${banjilist}" var="bean">
                                <option value="${bean.banjinum }" >
                                   	${bean.banjinum }
                                </option>
                                </c:forEach>
				</select> 
				 <input type="hidden" name="id"  value="${bean.id }"/>  
			</div>
			<div class="unit">
				<label>课程:</label>
				<select name="kechengname" class="required">
				<option value="${bean.kechengname}">${bean.kechengname}</option>
						<c:forEach items="${subjectlist}" var="bean">
                                <option value="${bean.subjectname }" >
                                   	${bean.subjectname }
                                </option>
                                </c:forEach>
				</select> 
			</div>
			
			<div class="unit">
				<label>任课老师:</label>
				 <input type="text" name="teacher" class="required"  value="${bean.teacher }"/> 
			</div>
			<div class="unit">
				<label>学号:</label>
				 <input type="text" name="codenum" class="required"  value="${bean.codenum }"/> 
			</div>
			
			<div class="unit">
				<label>日期:</label>
				 <input type="text" name="riqi" class="date" value="${bean.riqi}"/> 
			</div>
			<div class="unit">
				<label>旷课节数:</label>
				 <input type="text" name="kuangkenum" class="required" value="${bean.kuangkenum }"/> 
			</div>
             <div class="unit">
				<label>状态：</label>
				旷课<input type="radio" name="iskuangke" value="1" checked="checked"/> 迟到<input type="radio" name="iskuangke" value="0" />
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