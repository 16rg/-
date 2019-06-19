<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <script type="text/javascript">
    </script>

<div class="pageContent">
	
	<form method="post" name=form1 action="qingjiadan/qingjiadanupdate2.html" class="pageForm" onsubmit="return validateCallback(this,dialogAjaxDone);">
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
				<label>姓名:</label>
				 <input type="text" name="username" class="required" value="${bean.username}"/> 
			</div>
			<div class="unit">
				<label>请假开始时间:</label>
				 <input type="text" name="qjtime1" class="date required" readonly="true"  format="yyyy-MM-dd HH:mm:ss"  value="${bean.qjtime1}"/> 
			</div>
			
			<div class="unit">
				<label>请假结束时间:</label>
				 <input type="text" name="qjtime2" class="date required" readonly="true"  format="yyyy-MM-dd HH:mm:ss"  value="${bean.qjtime2}"/> 
			</div>
			<div class="unit">
				<label>请假理由:</label>
			 <input type="text"  name="qjcontent"  value="${bean.qjcontent}"/> 
			
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