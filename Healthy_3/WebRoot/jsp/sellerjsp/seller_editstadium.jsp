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
        .type {
            margin-left: 30%;
            margin-top: 5%;
        }

        .edit_table {
            min-width: 600px;
            min-height: 400px;
        }

        .t_layout {
            border: solid;
            border-width: 1px;
            border-color: cornflowerblue;
        }

        .table_title {
            font-size: 20px;
            font-weight: 600;
            text-align: center;
        }

        #add_btn {
            cursor: pointer;
            font-size: 20px;
            width: 200px;
            height: 35px;
            background-color: gray;
        }

        #location {
            width: 500px;
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
                        <form action="editStadium" method="post" enctype="multipart/form-data" onsubmit="return check()">
                            <table class="edit_table ">
                                <tr><td class="table_title t_layout" colspan="2">编辑健身场馆</td></tr>
                                <tr>

                                    <td class="t_layout">
                                        <center>
                                            	请选择运动项目
                                        </center>
                                    </td>
                                    <td class="t_layout">
                                        <center>
                                            <div class="kv-item ue-clear">
                                                <div class="kv-item-content">
                                                    <select id="typeselect" name="type">
                                                        <c:forEach begin="0" end="${requestScope.projecttype.size() }" items="${requestScope.projecttype }" var="type" varStatus="status">
                                                        <option value="${type.projectId }">${type.projectId }</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                        </center>
                                    </td>
                                </tr>

                                <tr class="t_layout">
                                    <td class="t_layout"><center>场馆名称</center></td>
                                    <td class="t_layout"> <center><input type="text" id="name" name="name" placeholder="${requestScope.stadium.stadiumName }" /></center></td>
                                </tr>
                                <tr>
                                    <td class="t_layout" rowspan="2"><center>修改图片</center></td>
                                    <td class="t_layout"> <center><img id="img" src="${requestScope.stadium.stadiumPhoto }" width="100px" height="100px" /></center></td>


                                </tr>
                                <tr>
                                    <td class="t_layout"> <center><input type="file" name="img" /></center></td>

                                </tr>
                                <tr>
                                    <td class="t_layout"><center>场馆介绍</center></td>
                                    <td class="t_layout"> <center><textarea rows="7" cols="80" id="intro" type="text" name="introduce">${requestScope.stadium.stadiumIntroduction }</textarea></center></td>
                                </tr>
                                <tr>
                                    <td class="t_layout"><center>场馆地址</center></td>
                                    <td class="t_layout"> <center><input placeholder="${requestScope.stadium.stadiumLocation }" id="location" type="text" name="location" /></center></td>
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

			document.getElementById("typeselect").value="${requestScope.stadium.sportProject.projectId}"


            	function check(){
            	    var x = true;
            	    var type = $("#typeselect").val();
            	var name=$("#name").val();
            	var url=$("#location").val();
            	var img = $("#imgfile").val();
            	var intro = $("#intro").val();
            	if(name==""){
            	alert("请输入场馆名")
            	x=false
            	//location.reload(true)
            	//history.go(-1);
            	}
            else	if(url==""){
            	alert("请输入地址")
            	x=false
            	//location.reload(true)
            } else if (type  == "无") {
                alert("请选择场馆分类")
                x = false
                //location.reload(true)
            }

            else	if(img==""){
            	alert("请选择图片")
            	x=false
            //location.reload(true)
            } else if (intro == "") {
                alert("请输入场馆介绍")
                x = false
                //location.reload(true)
            }
            	else{
            	alert("修改成功")
            	}

            	return x;
            	}
    </script>
</body>

</html>
