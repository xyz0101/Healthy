<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <link rel="stylesheet" type="text/css" href="css/WdatePicker.css" />
    <link rel="stylesheet" type="text/css" href="css/skin_/table.css" />
    <link rel="stylesheet" type="text/css" href="css/jquery.grid.css" />


    <title>表格</title>
   <style>
       .add_table{
          
           min-width:400px;
            min-height:300px;
       }
     .t_layout{
          border:solid;
           border-width:1px;
           border-color:cornflowerblue;
     }
       .table_title{
         font-size:20px;
         font-weight:600;
           text-align:center;
       }
       #add_btn{
           cursor:pointer;
           font-size:20px;
           
           width:200px;
           height:35px;
           background-color:gray;
       }
   </style>

</head>

<body>
    <div id="container">
        <div id="hd"></div>
        <div id="bd">
            <div id="main">
                <div class="search-box ue-clear">
                    <div class="search-area">
                    </div>
                </div>
                <div class="table">
                    <center>
                        <form action="addProject" method="post" enctype="multipart/form-data" onsubmit="check()">
                            <table class="add_table">
                                <tr><td class="table_title t_layout" colspan="2">添加运动项目</td></tr>
                                <tr>
                                    <td class="t_layout">运动项目名称：</td>
                                    <td class="t_layout">
                                        <center>
                                            <input id="input_id" type="text" name="id" />
                                        </center>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="t_layout">添加图片</td>
                                    <td class="t_layout">
                                        <center>
                                            <input type="file" name="img" />
                                        </center>
                                    </td>
                                </tr>
                                <tr>
                                 
                                    <td class="t_layout" colspan="2">
                                        <center>
                                            <input id="add_btn" type="submit" value="添加" />
                                        </center>
                                    </td>
                                </tr>
                            </table>


                        </form>

                    </center>

                </div>
            </div>
        </div>
    </div>
</body>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/global.js"></script>
<script type="text/javascript" src="js/jquery.select.js"></script>
<script type="text/javascript" src="js/core.js"></script>
<script type="text/javascript" src="js/jquery.pagination.js"></script>
<script type="text/javascript" src="js/jquery.grid.js"></script>
<script type="text/javascript" src="js/WdatePicker.js"></script>
<script type="text/javascript">
	$('select').select();
	function check(){
	var b=false;
	var id=$("#input_id").val();
	$.ajax({
	type:"post",
	url:"findProject",
	data:"id="+id,
	success:function(msg){
	//alert(msg)
	if(msg=="fail"){
	alert("运动项目名称已存在！")
	b=false;
	return false;
	}
	
	else if(msg=="success"){
	b=true;
	alert("添加运动项目成功！")
	}	}	})
	return false;
	}
</script>
</html>
