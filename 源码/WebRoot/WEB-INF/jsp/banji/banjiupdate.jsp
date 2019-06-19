<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <script type="text/javascript">
    </script>

<div class="pageContent">
	
	<form method="post" name=form1 action="banji/banjiupdate2.html" class="pageForm" onsubmit="return validateCallback(this,dialogAjaxDone);">
		<div class="pageFormContent" layoutH="58">
		<div class="unit">
				<label>院系:</label>
				 <input type="text" name="yuanxi" class="required" value="${bean.yuanxi}"/> 
				 <input type="hidden" name="id"  value="${bean.id }"/> 
			</div>
			
			<div class="unit">
				<label>专业:</label>
				 <input type="text" name="zhuanye" class="required"  value="${bean.zhuanye}"/> 
			</div>
			<div class="unit">
				<label>班级名称:</label>
				 <input type="text" name="banjiname" class="required"  value="${bean.banjiname}"/> 
			</div>
			<div class="unit">
				<label>班级编号:</label>
				 <input type="text" name="banjinum" class="required"  value="${bean.banjinum}"/> 
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