<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>编辑</title>
  </head>
  
  <body>
  <!-- 编辑修该用户信息 -->
    <form action="EditServlet" method="post">
    <table border="1" class="t1">
        <tr>
            <td >修改信息</td>
        </tr>
        <tr>
            <td>id:</td>
            <td><input  type="text" name="id" value="${mes.id}" readonly="readonly"/></td>
        </tr>
        
        <tr>
            <td>title:</td>
            <td><input  type="text" name="title" value="${mes.title}"/></td>
        </tr>
        <tr>
            <td>time:</td>
            <td><input  type="text" name="time" value="${mes.time}"/></td>
        </tr>
         <tr>
            <td>content:</td>
            <td><input  type="text" name="content" value="${mes.content}"/></td>
        </tr>
        <tr>
        	<td>
                <input  type="submit" value="提交"/>
                <a href="${pageContext.request.contextPath}/MessageServlet">返回</a>
            </td>
        </tr>
    </table>
   </form>
  </body>
</html>