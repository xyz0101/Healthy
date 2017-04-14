<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'registeradm.jsp' starting page</title>
    

  </head>
  <script src="js/jquery-1.4.3.min.js"></script>
  <body>
  
  <script type="text/javascript" >
	function doget(id){
					var id1 =id;
					var x=121212;
					//alert(id1);
					$.ajax({
					type:"post",
					
					url:"deleteUser",
					//参数名+参数
						data:"userid="+id1,
					//返回的json数据变为map
						//data:JSON.stringify({userid:id1,userid2:x}),  
					//json格式数据
						//datatype:"json",
					//requestbody接受必写
						//contentType:"application/json",
                    success: function(data){
                    
                    }
                    });
                    }
   
  </script>
  	${requestScope.alluser }<br><br>
  	<c:forEach items="${requestScope.alluser }" var="user" begin="0" end="8" varStatus="status">
  	<p>昵称：：：${user.userNickname }</p><div onClick="doget('${user.userId}')"><a href="javascript:void(0)" onclick="location.reload()" >删除</a></div>
  	</c:forEach>
  </body>
</html>
