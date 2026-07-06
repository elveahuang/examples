<%@ tag description="Base Layout" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/commons/taglibs.jsp" %>
<%@ attribute name="title" required="false" %>
<title>${title}</title>
<link rel="stylesheet" href="${ctx}/webjars/bootstrap/5.3.8/css/bootstrap.min.css"/>
<jsp:doBody/>
