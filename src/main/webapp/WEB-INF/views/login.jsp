<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/resources/include/commons.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>app版本管理系统</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="<%=basePath%>resources/admin/css/css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath%>resources/admin/js/jquery-1.8.2.min.js"></script>
</head>

<body>
<div>
    <form action="<%=basePath%>j_spring_security_check" method="post">
    	<table>
    		<c:if test="${errorMsg!=null}">
    		<tr>
    			<td>错误信息</td>
    			<td><font style="color: #ff0000;">${errorMsg }</font></td>
    		</tr>
    		</c:if>
    		<tr>
    			<td>用户名：</td>
    			<td><input name="j_username" id="uname" type="text"></td>
    		</tr>
    		<tr>
    			<td>密码：</td>
    			<td><input name="j_password" id="pword" type="password"></td>
    		</tr>
    		<tr>
    			<td><input name="_spring_security_remember_me" type="checkbox">自动登录</td>
    			<td>
               	 	<input name="reset" value="重置" type="reset">
                	<input name="reaction" value="登录" type="submit" onclick="formaction()">
    			</td>
    		</tr>
    	</table>
            <div>
                
            </div>
    </form>
</div>
<script type="text/javascript">
    function formaction(){
        if($("#uname").val() == "" || null == $("#uname").val()){
            alert("请输入您的用户名");
            return;
        }
        if($("#pword").val() == "" || null == $("#pword").val()){
            alert("请输入您的密码");
            return;
        }
        from.submit();
    }
</script>
</body>
</html>
