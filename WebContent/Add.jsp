<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>添加</title>
  </head>

  <body>
  <!-- 添加用户信息 -->
  <form action="AddServlet" method="post">
    <table >
        <tr>
            <td>添加信息</td>
        </tr>
        <tr>
            <td>title:</td>
            <td><input  type="text" name="title"/></td>
        </tr>
        <tr>
            <td>time:</td>
            <td><input  type="text" name="time"/></td>
        </tr>
        <tr>
            <td>content:</td>
            <td><input  type="text" name="content"/></td>
        </tr>
        <tr>
            <td >
                <input  type="submit" value="提交"/>
            </td>
        </tr>
    </table>
   </form>
  </body>
</html>