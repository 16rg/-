<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <script type="text/javascript">
    </script>

<div class="pageContent">
	
	<form method="post" name=form1 action="subject/subjectupdate2.html" class="pageForm" onsubmit="return validateCallback(this,dialogAjaxDone);">
		<div class="pageFormContent" layoutH="58">
			<div class="unit">
				<label>课程名称:</label>
				 <input type="text" name="subjectname" class="required"  value="${bean.subjectname}"/> 
			 <input type="hidden" name="id"  value="${bean.id }"/>  
			</div>
			<div class="unit">
				<label>上课时间:</label>
				 <input type="text" name="sksj" class="required" value="${bean.sksj}"/>（格式：08:00:00）
			</div>
			<div class="unit">
				<label>下课时间:</label>
				 <input type="text" name="xksj" class="required" value="${bean.xksj}"/>（格式：08:00:00）
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