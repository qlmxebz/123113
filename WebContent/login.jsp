<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录页面</title>
</head>
<body>
<h1>登录</h1>
<form action="/zuoye/Servlet2" method="POST">
手机号: <input type="text" name="phonenumber">
<br />
密码: <input type="text" name="password" />
<input type="submit" value="登录" />
</form>
</body>
</html>