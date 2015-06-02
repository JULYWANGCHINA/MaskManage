<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/resources/include/commons.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>管理平台</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="<%=basePath%>resources/admin/css/css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath%>resources/admin/js/jquery-1.8.2.min.js"></script>
</head>

<body>
	<div class="pageTitle">
		<div class="left"><img src="<%=basePath%>resources/admin/images/icon_edit.png" align="absmiddle">网站地图</div>
		<div class="right">
			<%@include file="/resources/include/header.jsp"%>
		</div><br clear="all" />
	</div>
	<TABLE cellSpacing=1 cellPadding=0 width="100%" class="tabAdd" style="border: solid 1px;">
		<tr>
			<td colspan="2">
				面膜时间API
			</td>
		</tr>
		<tr>
			<th width="210px">面膜接口：</th>
			<td class="pn-fcontent"><a target="_blank" href="<%=basePath %>admin/app/maskmanage"><%=basePath %>admin/app/manage</a></td>
		</tr>
		<tr>
			<th width="210px">用户接口：</th>
			<td class="pn-fcontent"><a target="_blank" href="<%=basePath %>admin/app/usermanage"><%=basePath %>admin/app/appuser_manage</a></td>
		</tr>
		<tr>
			<td colspan="2">
				用户管理
			</td>
		</tr>
		<tr>
			<th width="210px">用户列表：</th>
			<td class="pn-fcontent"><a target="_blank" href="<%=basePath %>admin/appuser/list"><%=basePath %>admin/appuser/list</a></td>
		</tr>
		<tr>
			<td colspan="2">
				消息管理
			</td>
		</tr>
		<tr>
			<th width="210px">发送消息：</th>
			<td class="pn-fcontent"><a target="_blank" href="<%=basePath %>admin/message/toAdd"><%=basePath %>admin/message/toAdd</a></td>
		</tr>
		<tr>
			<td colspan="2">
				问题管理
			</td>
		</tr>
		<tr>
			<th width="210px">问题分组：</th>
			<td class="pn-fcontent"><a target="_blank" href="<%=basePath %>admin/question/group"><%=basePath %>admin/question/group</a></td>
		</tr>
		<tr>
			<th width="210px">问题列表：</th>
			<td class="pn-fcontent"><a target="_blank" href="<%=basePath %>admin/question/topic"><%=basePath %>admin/question/topic</a></td>
		</tr>
		<tr>
			<td colspan="2">
				版本管理
			</td>
		</tr>
		<tr>
			<th width="210px">版本列表：</th>
			<td class="pn-fcontent"><a target="_blank" href="<%=basePath %>admin/version/view"><%=basePath %>admin/version/view</a></td>
		</tr>
		<tr>
			<td colspan="2">
				统计
			</td>
		</tr>
		<tr>
			<th width="210px">用户统计：</th>
			<td class="pn-fcontent"><a target="_blank" href="<%=basePath %>admin/statistics/appuser"><%=basePath %>admin/statistics/appuser</a></td>
		</tr>
		<tr>
			<th width="210px">面膜统计：</th>
			<td class="pn-fcontent"><a target="_blank" href="<%=basePath %>admin/statistics/maskdetail"><%=basePath %>admin/statistics/maskdetail</a></td>
		</tr>
	</TABLE>
</body>
</html>
