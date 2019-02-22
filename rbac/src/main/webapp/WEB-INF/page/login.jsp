<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>登录</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css" />
</head>
<body>
	<form action="${pageContext.request.contextPath}/user/login" method="post">
		<p class="center">用户名：<input type="text" name="username" /></p>
		<p class="center">密码：<input type="password" name="password" /></p>
		<p class="center"><input type="submit" value="登录" /></p>
	</form>
</body>
</html>