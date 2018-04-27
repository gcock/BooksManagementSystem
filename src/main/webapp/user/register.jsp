<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册 - cock</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/loginCss.css">
<link rel="shortcut icon" href="<%=request.getContextPath()%>/ico/logo.ico" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
function refresh() {  
    //IE存在缓存,需要new Date()实现更换路径的作用  
    document.getElementById("image").src="<%=request.getContextPath()%>/image.jsp?"+new Date();  
}  
function validEmpty(){
	  
    //获取输入框的输入值
    var name = document.getElementById('account').value;
    var password = document.getElementById('password').value;
    var code = document.getElementById("code").value;
    if(name == null || name == ''){
    	document.getElementById('label_color').innerHTML="账号不能为空";
        return false;
    }
    
    if(password == null || password == ''){
    	document.getElementById('label_color').innerHTML="请输入密码";
        return false;
    }

    loginForm.submit();  
 
  }
   
	function different(){  
	    alert("请输入正确的验证码");  
	    location.href = "login.jsp";  
	}  
</script>
</head>
<body>
	<div id="login_frame">  
	<label class="label_color" id="label_color">${msg eq "用户名或密码错误"?"用户名或密码错误":""}</label>
	<form action="<%=request.getContextPath()%>/login" method="post" id="loginForm">
		<p><label class="label_input">用户名:</label><input name="account" id="account" type="text" class="text_field"><label id="color"> *</label><br></p>
		<p><label class="label_input">密码:</label><input name="password" id="password" type="password" class="text_field" placeholder="密码最长为16位"/><label id="color">*</label><br></p>
		<p><label class="label_input">email:</label><input name="password" id="password" type="password" class="text_field"><label id="color">*</label><br></p>
		<input type="button" onclick="validEmpty()" value="注册">
		<div id="login_control">  
            <a id="forget_pwd" href="javascript:void(0);">已有账号,去登陆？</a> 
            <a id="regist" href="./main.jsp">返回首页</a> 
        </div> 
	</form>
	</div>

</body>
</html>