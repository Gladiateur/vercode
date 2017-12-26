<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
   <div align="center">
   		<h3>vercode demo</h3>
   		<form action="check" method="post">
   		<table border="1" width="40%" align="center">
   			<tr>
   				<td>账号 ：</td>
   				<td><input type="text"/></td>
   			</tr>
   			<tr>
   				<td>密码 ：</td>
   				<td><input type="password"/></td>
   			</tr>
   			<tr>
   				<td>验证码 ：</td>
   				<td><input type="text" name="code"/></td>
   				<td><img src="${pageContext.request.contextPath}/ver"/></td>
   			</tr>
   			<tr>
   				<td colspan="2"><input type="submit" value="login"/></td>
   			</tr>
   		</table>
   		</form>
   		${msg }
   </div>
  </body>
</html>
