<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>宿舍管理系统</title>
<style type="text/css">	
	table{margin: 50px auto;padding:0px; width: 900px;height:150px;text-align: center;}
	h2 {font-size: 30px;color: #000000; display : inline}
</style>
</head>
<body style="background:url(../image/dormitory.jpg)">
	<h2>宿舍管理系统（当前用户：学生）</h2>
	<a href="login.jsp" style="margin-left:1000px">退出</a>
<div style="background:#c0c0c0; color:#000;height:40px">
	
	        <a href="../DormServlet?opt=stu" style="width:75px; margin-left:160px;color:white;Font-size:28px">宿舍信息</a>
            <a href="../DamServlet?opt=stu" style="width:75px; margin-left:160px;color:white;Font-size:28px">商品保修</a>
  	
</div>

<div>   
	<table align="center" border="1px solid #ccc" style ="border:10px solid #c0c0c0;margin-top:60px;background-color:#ffffff;margin-left:300px;margin-right:250px">
	<thead>
		<tr>
			<th width="200px">宿舍号</th>
			<th width="200px">总床位数</th>
			<th width="200px">剩余床位数</th>
			<th width="200px">宿舍长</th>
		</tr>
	</thead>
	  <tbody>
              <c:forEach items="${dormlist}" var="dormlist">
                  <tr>
                       <td>${dormlist.d_id}</td>
                       <td>${dormlist.total}</td>
                       <td>${dormlist.used}</td>
                       <td>${dormlist.dormadmin}</td>
                     
                   </tr>
               </c:forEach>
       </tbody>
	</table>
</div>

</body>
</html>