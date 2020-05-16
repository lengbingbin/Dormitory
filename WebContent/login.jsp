<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<head>
    <title>宿舍管理系统</title>   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<!-- 导入easyui的资源文件 -->
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
	<link id="themeLink" rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
    <style>
        html, body
        {
            width: 100%;
            height: 100%;
            margin: 0;
            padding: 0;
        }

        h1
        {
            color: rgb(128, 128, 128);
            text-align: center;
        }

        a:link, a:hover, a:visited, a:active
        {
            color: rgb(128, 128, 128);
            text-decoration: none;
        }

        form
        {
            width: 400px;
            min-width: 400px;
            position: absolute;
            left: 35%;
            top: 15%;
            margin: 0;
            padding: 30px;
            background-color: white;
            border: 2px solid rgba(128, 128, 128, 0.2);
            border-radius: 10px;
        }

            form div
            {
                margin-bottom: 10px;
            }
    </style>
</head>
<body style="background:url(image/background.jpg)">
    <form id="editForm"  method="post">
        <div>
            <h1>用户登录</h1>
        </div>
        <div>
            <input class="easyui-textbox" name="username" data-options="iconCls:'icon-man',iconWidth:30,iconAlign:'left',prompt:'用户名'" style="width:100%;height:40px;" />
        </div>
        <div>
            <input class="easyui-textbox" name="password" data-options="iconCls:'icon-lock',iconWidth:30,iconAlign:'left',prompt:'密码'" style="width:100%;height:40px;" />
        </div>
        <div>
        	<div style="display:inline;margin-left:320px;">
                <a href="javascript:void(0)">忘记密码？</a>
        	</div>    
        </div>
		<div>
            <input id="login" class="easyui-linkbutton"  value="登录" style="width:100%;height:45px;"/>
        </div>
        <div>
        	<div style="display:inline;margin-left:0px;">
                	还没有账号？<a href="../Dormitory/register.jsp">立即注册</a>
        	</div>    
        </div>
    </form>
<!-- <body style="background:url(image/background.jpg)">
    <form id="editForm" action="${pageContext.request.contextPath}/dormitory/login.action" method="post">
        <div>
            <h1>用户登录</h1>
        </div>
        <div>
            <input class="easyui-textbox" name="username" data-options="iconCls:'icon-man',iconWidth:30,iconAlign:'left',prompt:'用户名'" style="width:100%;height:40px;" />
        </div>
        <div>
            <input class="easyui-textbox" name="password" data-options="iconCls:'icon-lock',iconWidth:30,iconAlign:'left',prompt:'密码'" style="width:100%;height:40px;" />
        </div>
        <div>
        	<div style="display:inline;margin-left:320px;">
                <a href="javascript:void(0)">忘记密码？</a>
        	</div>    
        </div>
		<div>
            <input id="login"  class="easyui-linkbutton" type="submit" value="登陆" style="width:100%;height:45px;" />
        </div>
        <div>
        	<div style="display:inline;margin-left:0px;">
                	还没有账号？<a href="../Dormitory/register.jsp">立即注册</a>
        	</div>    
        </div>
    </form>-->
    <!--  <script type="text/javascript">
    	$("#login").click(function(){ 		
    		
    		alert(msg);
    	});
    		
    </script>-->
      
    <script type="text/javascript">
    	$("#login").click(function() {
    		//alert("userName:",userName);
    		$("#editForm").form("submit",{
    			url:"dormitory/login.action",
    			onSubmit:function(){
						//判断表单的验证是否都通过了
						return $("#editForm").form("validate");
					},
    			success:function(data){
    				data = eval("("+data+")");
    				if(data.success){
    					
    					alert("登录成功");
    					location.href="index.jsp";
    					//$.messager.alert("提示","保存成功","info");
					}else{
						alert("用户名或者密码错误");
						location.href="login.jsp";
					}
    			}
    		});
    	});
    </script>
</body>
</html>
