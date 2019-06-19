<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="manage.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<c:set scope="request" var="exception_message"><s:property value="exception"/></c:set>
<%
	if (ActionUtil.isAjaxRequest(request)) {
%>
{"statusCode":"300", "message":"<s:property value="exception"/>"}
<%
		return;
	}
%>
<html>
<head><title>该页面出错啦</title></head>
<body>
    <h3>Exception:</h3>
    <s:property value="exception"/>

    <h3>Stack trace:</h3>
    <pre>
        <s:property value="exceptionStack"/>
    </pre>
</body>
</html>