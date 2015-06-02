<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tag" uri="http://www.quantumti.me.tag" %>
<%@ page import="java.util.*" %>
<%@page import="me.quantumti.utils.PropertiesUtils"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://"
		+ request.getServerName() + ":" + request.getServerPort()
		+ path +"/";

/* String voteFilePath = basePath + PropertiesUtils.readConfig(PropertiesUtils.FILE_CONFIG,"file.vote.dir"); */
%>
