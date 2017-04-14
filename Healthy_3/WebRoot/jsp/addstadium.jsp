<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addstadium.jsp' starting page</title>
    
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
   <form action="stadium" method="post"  enctype="multipart/form-data">
   		场馆名称:<input type="text" name="staName"><br>
   		场馆电话:<input type="text" name="staTel"><br>
   		场官地址:<input type="text" name="staAddr"><br>
   		场馆介绍:<input type="text" name="staDesc"><br> 
   		<input type="file" name="file" /> <input type="submit" value="Submit" /></form> 		
  		<br>
  <form action="delete" method="post">
  	删除用户:<input type="text" name="name"><br>
  	<input type="submit" value="删除">
   </form>
</html>
