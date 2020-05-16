<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%> 

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/visup.js"></script>
<title>增加访客页面</title>
<script type="text/javascript">
		function visup_alert(){
			
			<%String mess = (String)session.getAttribute("message");%>
				//System.out.println("mess:"+mess);
			alert("<%=mess%>");
		
		}
	
</script>
</head>
<body >
 <form action="../VisitorInsServlet" method="post">
 	<label>访客名:</label>
			<input type="text" name="visitorname"/><br>
	<label>受访学生号：</label>
			<input type="text" name="studentid"/><br>	
	<label>进入时间：</label>
			<input type="text" name="starttime"/><br>
	<label>离开时间：</label>
			<input type="text" name="endtime"/><br>
	<input id="visup" type="submit" value="增加" onclick="visup_alert()"> 
	
 </form>
</body>


</html>
