<%-- 默认页面页面布局 --%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../commons/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title><sitemesh:write property="title"/></title>
    <%@ include file="../commons/meta.jsp" %>
    <sitemesh:write property='head'/>
</head>
<body>
<div>Header</div>
<sitemesh:write property="body"/>
<spring:url value="/web/"/>
<div>Footer</div>
</body>
</html>
