<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://shiro.apache.org/tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

	<head>

		<title>My JSP 'index.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	</head>

	<body>
		当前的用户:${user.userName}</br>
		用户管理的菜单如下:</br>
		<%-- <c:forEach items="${user.menus}" var="menu">
			${menu}</br>
		</c:forEach> --%>
		<s:hasPermission name="visite2">
		<!-- 这个地方表示只有有visite2这个权限，才能显示下面的按钮，没有权限不能显示，上面要导核心类库进来 -->
			<form action="${pageContext.request.contextPath}/logout.action">
				<input type="submit" value="logout" />
			</form>
			<!--测试的是那个权限的问题-->
			<form action="${pageContext.request.contextPath}/bobo.action" method="post">
				<input type="submit" value="send" />
			</form>

			<a href="/TestShiro_ZH/bobo.action">send2</a>
		</s:hasPermission>

	</body>

</html>