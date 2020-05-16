<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<style type="text/css">
	*{margin: 0;padding: 0;}
	form{margin: 200px auto;padding:15px; width: 300px;height:300px;text-align: center;}
	#submit{padding: 10px}
	#submit input{width: 50px;height: 24px;}
</style>
</head>
<body style="background:url(../image/login2.jpg)">
	<div class="p1" style="padding:50px,50px,50px,50px">
	
		<form action="../s" method="post" >
		<input type="hidden" name="per" value="login"><!-- 设置一个隐藏的input用于把value传过去后台 -->
		<h1 style="text-align:center">宿舍管理系统</h1>
			<label>用户名:</label>
				<input type="text" name="userName"/><br><br>
			<label>密码：</label>
				<input type="password" name="password"/><br>	
			<div id="submit">
				<input type="submit" value="登录"/>
			</div>
		</form>
	
	</div>

</body>


</html>
