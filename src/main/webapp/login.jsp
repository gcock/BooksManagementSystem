<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录 - cock</title>
<link rel="stylesheet" type="text/css" href="./css/loginCss.css">
<link rel="shortcut icon" href="./ico/logo.ico" />
<script type="text/javascript" src="./js/jquery-3.3.1.min.js"></script>
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
		<p><label class="label_input">账号:</label><input name="account" id="account" type="text" class="text_field" placeholder=" 邮箱/手机号"/><br></p>
		<p><label class="label_input">密码:</label><input name="password" id="password" type="password" class="text_field"><br></p>
		<p><label class="label_input">验证码:</label><input name="code" id="code" class="text_field2" maxlength="20">
		<img id="image" border="0"  onclick="refresh()" src="<%=request.getContextPath()%>/image.jsp" title="点击更换图片"> <br></p>
		<input type="button" onclick="validEmpty()" value="登录">&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
		<input type="reset" name="reset" value="重置"><br>
		<div id="login_control">  
            <a id="forget_pwd" href="javascript:void(0);">忘记密码？</a> 
        </div> 
	</form>
	<a id="regist" href="<%=request.getContextPath()%>/register">免费注册</a> 
	</div>

</body>
</html>