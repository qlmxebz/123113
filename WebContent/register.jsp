<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册页面</title>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
<script>
function getCode(){
	$.get("/code",alert("获取验证码成功"))
}
</script>
</head>
<body>
<h1>注册</h1>
<form action="/zuoye/Servlet1" method="POST">
手机号: <input type="text" name="phonenumber">
<br />
<tr>
<td>
验证码：
</td>	
<td>		
<input type="text" name="validate" size="5" class="text" onBlur="checkCode()"/>	
 <input type="button" value="获取验证码" name="yzm" class="yzm"  onclick="getCode()">
	   	
	<img class="code" alt="点击刷新" src="code" onclick="this.src='code?s='+new Date().getTime();" >	
	</td>	
	<td>		
	<div id="checkCode" class="check">*</div>
		</td>
		</tr>
密码: <input type="text" name="password" />
<input type="submit" value="提交" />
</form>
</body>
</html>