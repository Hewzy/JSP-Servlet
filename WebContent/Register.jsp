<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>

<script>
//验证码更换
function reloadImage(){
	document.getElementById('imgCode').src="safecode?time="+new Date().getTime();
}
//根据不同浏览器创建不同的AJAX的xmlhttp对象
function ajaxFunction(){
	   var xmlHttp;
	   try{ // Firefox, Opera 8.0+, Safari
	        xmlHttp=new XMLHttpRequest();
	    }
	    catch (e){
		   try{// Internet Explorer
		         xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
		      }
		    catch (e){
		      try{
		         xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
		      }
		      catch (e){}
		      }
	    }
		return xmlHttp;
	 }
	 //检查要注册的名字数据库中是否存在
	function checkName(){
		var username = document.getElementById("username").value;
		var request = ajaxFunction();
		request.open("POST","CheckUserNameServlet",true);
		request.onreadystatechange = function()
		{
			if(request.readyState==4&&request.status==200){
				var num = request.responseText;
				if(num==1) {
				alert("用户名已存在");
			}
		}
	}
		request.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		request.send("username="+username);
		
	}
	 //检查输入的验证码是否正确
	function checkSafeCode(){
		var safecode = document.getElementById("safecode").value;
		var request = ajaxFunction();
		request.open("POST","CheckSafeCodeServlet",true);
		request.onreadystatechange = function()
		{
			if(request.readyState==4&&request.status==200){
				var num = request.responseText;
				if(num==1) {
				alert("验证码不正确！");
			}
		}
	}
		request.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		request.send("safecode="+safecode);
		
	}
	//检查密码的长度不能小于4
	function checkpassword(){
		var password = document.getElementById("password").value;
		if(password.length<=4)
			alert("密码长度不能小于4");
	}
	function numbererror(){
		var number = document.getElementById("number").value;
		if(number.length!=11)
			alert("手机格式不正确，请重新输入！");
	}
</script>


</head>
<body>
	<form action="${pageContext.request.contextPath}/RegisterServlet" method="post">
	<h1>注册页面</h1>
	用户名：<input type="text" name="username" id="username" onblur="checkName()"><br>     <!-- 失去焦点调用检查用户名的方法 -->
	手机号：<input type="text" id="number" name="number" onblur="numbererror()"><br>		<!-- 失去焦点调用检查手机号方法 -->
	<div id="numbererr" style="display:inline;color:blue;"></div>
	验证码：<input type="text" name="safecode" id="safecode" OnClick="D()" onblur="checkSafeCode()">  <!-- 失去焦点调用检查验证码方法 -->
	<img id="imgCode" src="safecode"/>																<!-- 随机生成验证码的图片 -->
	<input type="button" value="看不清" id="btn" onclick="reloadImage()"><br>
	密码    ：<input type="password" name="password" id="password" onblur="checkpassword()" ><br>	<!-- 失去焦点调用检查密码的方法 -->
	<input type="submit" VALUE="注册">
</form>
</body>
</html>