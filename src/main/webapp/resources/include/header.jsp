<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%
String myPath = request.getScheme() + "://"
		+ request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath() +"/";

%>
<input type="button" value="&nbsp;退出登录&nbsp;" onclick="window.location='<%=myPath%>j_spring_security_logout'" class="button" />
