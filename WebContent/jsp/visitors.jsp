<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>普通学生界面</title>
<style type="text/css">	
	form{margin: 20px auto;padding:15px; width: 800px;height:30px;text-align: center;}
	table{margin: 30px auto;padding:0px; width: 1000px;height:150px;text-align: center;}
	h2 {font-size: 30px;color: #000000; display : inline}
</style>
</head>
<body style="background:url(../image/dormitory.jpg)">
	<h2>宿舍管理系统</h2>
	<a href="login.jsp" style="margin-left:1280px">退出</a>
<div style="background:#c0c0c0; color:#000;height:40px">
	
	        <a href="../s?per=dorm" style="width:75px; margin-left:160px;color:white;Font-size:28px">宿舍信息</a>
            <a href="../s?per=dam" style="width:75px; margin-left:160px;color:white;Font-size:28px">损耗物品</a>
            <a href="../s?per=vis" style="width:75px; margin-left:160px;color:white;Font-size:28px">访客信息</a>
            <a href="../s?per=sco" style="width:75px; margin-left:160px;color:white;Font-size:28px">宿舍评分</a>
            <a href="../s?per=stuinfo" style="width:75px; margin-left:160px;color:white;Font-size:28px">学生信息</a>
</div>
<div align="center" style ="border:10px solid #c0c0c0;margin-top:60px;background-color:#ffffff;margin-left:250px;margin-right:250px">
 <form action="../SelServlet" method="post">
	<label>请输入访客名：</label>
	<input name="visname" type="text">
	<input type="submit" value="查找">
 </form>
  
	<table align="center" border="1px solid #ccc">
	<thead>
		<tr>
			<th width="200px">访客名</th>
			<th width="200px">受访学生</th>
			<th width="200px">进入时间</th>
			<th width="200px">离开时间</th>
		</tr>
	</thead>
	  <tbody>
              <c:forEach items="${vislist}" var="vislist">
                  <tr>
                       <td>${vislist.visitorname}</td>
                       <td>${vislist.studentid}</td>
                       <td>${vislist.starttime}</td>
                       <td>${vislist.endtime}</td>
                       <td>
                       <a href="../DeleteServlet?op=deleteVis&id=${vislist.id}">删除</a>
                       </td>
                       <td>
                       <a href="../ViewVisServlet?vi=vis&id=${vislist.id}">详情</a>
                       </td>
                   </tr>
               </c:forEach>
       </tbody>
	</table>
	<br>
	<input  type="button" value="增加" onclick="window.location.href='visitorup.jsp'">
</div>
</body>
</html>