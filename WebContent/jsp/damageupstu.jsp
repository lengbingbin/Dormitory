<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上报损耗物品页面</title>

</head>
<body>
 <form action="../DamInsServlet?opti=stu" method="post">
 	<label>损耗情况:</label>
			<input type="text" name="damagestation"/><br>
	<label>损坏时间：</label>
			<input type="text" name="damagetime"/><br>	
	<label>是否修复：</label>
			<input type="text" name="isfixed"/><br>
	<label>宿舍号   ：</label>
			<input type="text" name="dormid"/><br>
	<input type="submit" value="上报"> 
 </form>
</body>
</html>
