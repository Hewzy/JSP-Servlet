<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript">
//根据不同浏览器分别创建 ajax的 xmlHttp对象
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
	 //检查用户名是否存在
function checkName(){
	var username = document.getElementById("username").value;
	var request = ajaxFunction();
	request.open("POST","CheckUserNameServlet",true);
	request.onreadystatechange = function()
	{
		if(request.readyState==4&&request.status==200){
			var num = request.responseText;
			if(num!=1) {
			alert("用户名不正确，请重新输入！",function(){

		        location.reload();

		});
		}
	}
}
	request.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	request.send("username="+username);
}
	 //检查用户名密码是否正确
function checkPassword(){
	var password= document.getElementById("password").value;
	var request = ajaxFunction();
	request.open("POST","CheckPasswordServlet",true);
	request.onreadystatechange = function()
	{
		if(request.readyState==4&&request.status==200){
			var num = request.responseText;
			if(num!=1) {
			alert("密码不正确，请重新输入！",function(){

		        location.reload();

		});
		}
	}
}
	request.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	request.send("password="+password);
}
</script>
 
<body>
	<form method="post" action="LoginServlet">
	<h1>登陆界面</h1>
	用户名：<input type="text" name="username" id="username" onblur="checkName()"><br>       <!-- 失去焦点是调用检查用户名的方法 -->
	密码: <input type="password" name="password" id="password" onblur="checkPassword()"><br><br> <!-- 失去焦点是调用检查密码的方法 -->
	<input type="submit" value="登陆"> 
	<a href="${pageContext.request.contextPath}/Register.jsp">点击注册</a></form>
</body>
</html> 