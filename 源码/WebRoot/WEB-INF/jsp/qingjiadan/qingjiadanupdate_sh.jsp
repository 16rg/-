<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <script type="text/javascript">
    </script>

<div class="pageContent">
	
	<form method="post" name=form1 action="qingjiadan/qingjiadanupdate2_sh.html" class="pageForm" onsubmit="return validateCallback(this,dialogAjaxDone);">
		<div class="pageFormContent" layoutH="58">
		<div class="unit">
				<label>班级编号：</label>
				 <input type="text" disabled name="username" class="required" value="${bean.banjinum}"/> 
				 <input type="hidden" name="id"  value="${bean.id }"/>  
			</div>
			<div class="unit">
				<label>姓名:</label>
				 <input type="text" disabled name="username" class="required" value="${bean.username}"/> 
			</div>
			<div class="unit">
				<label>请假开始时间:</label>
				 <input type="text" disabled name="qjtime1" class="required" value="${bean.qjtime1}"/> 
				 <input type="hidden"  name="qjtime1" class="required" value="${bean.qjtime1}"/> 
			</div>
			
			<div class="unit">
				<label>请假结束时间:</label>
				 <input type="text" disabled name="qjtime2" class="required" value="${bean.qjtime2}"/> 
				 <input type="hidden"  name="qjtime2" class="required" value="${bean.qjtime2}"/> 
			
			</div>
			
			<div class="unit">
				<label>审核:</label>
					 <select name="shenhe" class="required">
					 <option value="${bean.shenhe}">${bean.shenhe}</option>
						<option value="通过">通过</option>
						<option value="不通过">不通过</option>
					</select>
			</div> 
			
				<div class="unit">
				<label>请假理由:</label>
			 <input type="text" disabled name="qjcontent"  value="${bean.qjcontent}"/> 
			
			</div>
			
			<div class="unit">
				<label>审批意见:</label>
			 <input type="text" name="shenhecontent" value="${bean.shenhecontent}"/> 
			
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