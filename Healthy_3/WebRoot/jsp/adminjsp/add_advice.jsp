<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="css/style.css" />
  
   

    <style>
        .type{
            margin-left:30%;
              margin-top:5%;
             }
          .edit_table{
          
           min-width:600px;
            min-height:400px;
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
    <title>表格</title>
</head>

<body>

    <div id="container">
        <div id="hd"></div>
        <div id="bd">
            <div id="main">

                <div class="table">

                    <div class="type">
                        <form action="addAdvice" method="post" enctype="multipart/form-data" onsubmit="return check()">
                            <table class="edit_table ">
                                <tr><td class="table_title t_layout" colspan="2">添加运动推荐</td></tr>


                                <tr class="t_layout">
                                    <td class="t_layout"><center>编辑标题</center></td>
                                    <td class="t_layout"> <center><input type="text" id="name" name="title" placeholder="" /></center></td>
                                </tr>
                                <tr>
                                    <td class="t_layout" ><center>添加图片</center></td>
                                    <td class="t_layout"> <center><input id="imgfile" type="file" name="img" /></center></td>
                                  
                                </tr>
                                
                                <tr>
                                    <td class="t_layout"><center>运动介绍</center></td>
                                    <td class="t_layout"> <center><textarea  name="content" rows="7" cols="80"></textarea></center></td>
                                </tr>
                                <tr>
                                    <td class="t_layout" colspan="2">
                                        <center>
                                            <input id="add_btn" type="submit" value="保存" />
                                        </center>
                                    </td>

                                </tr>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript" src="js/jquery.js"></script>
  
    <script type="text/javascript">
   
            	function check(){
            	var x=true;
            	var name=$("#name").val();
            	var url=$("#url").val();
            	var img=$("#imgfile").val();
            	if(name==""){
            	alert("请输标题")
            	x=false
            	}
            else	if(url==""){
            	alert("请输入运动介绍")
            	x=false
            	}
            	
            else	if(img==""){
            	alert("请选择图片")
            	x=false
            	}
            	else{
            	alert("添加成功")
            	}
            	return x;
            	}	
    </script>
</body>

</html>
