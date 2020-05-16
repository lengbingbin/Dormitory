<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上报损耗物品页面</title>
<script type="text/javascript">
		function dormup_alert(){
			
			<%String mess = (String)session.getAttribute("message");%>
				//System.out.println("mess:"+mess);
			alert("<%=mess%>");
		
		}
	
</script>
</head>
<body>
 <form action="../DormInsServlet?opti=adm" method="post">
 	<label>宿舍号:</label>
			<input type="text" name="D_id"/><br>
	<label>总床位数：</label>
			<input type="text" name="total"/><br>	
	<label>剩余床位数：</label>
			<input type="text" name="used"/><br>
	<label>宿舍长   ：</label>
			<input type="text" name="dormadmin"/><br>
	<input type="submit" value="提交" onclick="dormup_alert()"> 
	
 </form>

</body>


</html>
