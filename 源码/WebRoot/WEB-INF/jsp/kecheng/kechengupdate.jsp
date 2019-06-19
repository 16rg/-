<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pageContent">
	
	<form method="post" action="kecheng/kechengupdate2.html?id=${id}" class="pageForm" onsubmit="return validateCallback(this,dialogAjaxDone);">
		<div class="pageFormContent" layoutH="58">
		<div class="unit">
				<label>顺序：</label>
				<select name="kechenglock" class="required">
					<option value="${bean.kechenglock}">第${bean.kechenglock}节</option>
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
				<input type="text" name="kechengname1" size="30" class="required" value="${bean.kechengname1}"/>
			</div>
			<div class="unit">
				<label>星期二课程名：</label>
			<input type="text" name="kechengname2" size="30" class="required" value="${bean.kechengname2}"/>
			</div>
			<div class="unit">
				<label>星期三课程名：</label>
				<input type="text" name="kechengname3" size="30" class="required" value="${bean.kechengname3}"/>
			</div>
			<div class="unit">
				<label>星期四课程名：</label>
				<input type="text" name="kechengname4" size="30" class="required" value="${bean.kechengname4}"/>
			</div>
			<div class="unit">
				<label>星期五课程名：</label>
				<input type="text" name="kechengname5" size="30" class="required" value="${bean.kechengname5}"/>
			</div>
			<div class="unit">
				<label>星期六课程名：</label>
				<input type="text" name="kechengname6" size="30" class="required" value="${bean.kechengname6}"/>
			</div>
			<div class="unit">
				<label>星期天课程名：</label>
				<input type="text" name="kechengname7" size="30" class="required" value="${bean.kechengname7}"/>
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