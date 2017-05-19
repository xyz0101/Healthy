<%@ page language="java" import="java.util.*" pageEncoding="Utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>




<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
   

    <title>健身常识</title>
    <link href="css1/bootstrap.css" rel='stylesheet' type='text/css' />
      <link rel="stylesheet" type="text/css" href="css1/know.css" />
    <link rel="stylesheet" type="text/css" href="css1/xcConfirm.css" />
    <link href="css1/style.css" rel='stylesheet' type='text/css' />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <script src="js1/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $(".dropdown img.flag").addClass("flagvisibility");

            $(".dropdown dt a").click(function () {
                $(".dropdown dd ul").toggle();
            });

            $(".dropdown dd ul li a").click(function () {
                var text = $(this).html();
                $(".dropdown dt a span").html(text);
                $(".dropdown dd ul").hide();
                $("#result").html("Selected value is: " + getSelectedValue("sample"));
            });

            function getSelectedValue(id) {
                return $("#" + id).find("dt a span.value").html();
            }

            $(document).bind('click', function (e) {
                var $clicked = $(e.target);
                if (!$clicked.parents().hasClass("dropdown"))
                    $(".dropdown dd ul").hide();
            });


            $("#flagSwitcher").click(function () {
                $(".dropdown img.flag").toggleClass("flagvisibility");
            });
        });

    </script>
  
</head>
<body>
    <div class="header">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="header-left">
                        <div class="logo">
                            <a href="tosport"><img src="photo/logo.png" width="75px" ,height="60px" alt="" /></a>
                        </div>
                        <div class="menu">
                            <a class="toggleMenu" href="#"><img src="img/nav.png" alt="" /></a>
                            <ul class="nav" id="nav">
						    	<li><a href="tosport">首页</a></li>
						    	<li><a href="Tosportproject">运动项目</a></li>
						    	<li><a href="toHealthyKnow">健身常识</a></li>
						    	<li><a href="toAllSpace">运动社区</a></li>
						    	
								<li><a href="contact.html">联系我们</a></li>									
								<div class="clear"></div>
							</ul>
                            <script type="text/javascript" src="js1/responsive-nav.js"></script>
                        </div>
                        <div class="clear"></div>
                    </div>
                    <div class="header_right">
                        <!-- start search-->
                        <div class="search-box">
                            <div id="sb-search" class="sb-search">
                                <form>
                                    <input class="sb-search-input" placeholder="Enter your search term..." type="search" name="search" id="search">
                                    <input class="sb-search-submit" type="submit" value="">
                                    <span class="sb-icon-search"> </span>
                                </form>
                            </div>
                        </div>
                        <!----search-scripts---->
                        <script src="js1/classie.js"></script>
                        <script src="js1/uisearch.js"></script>
                        <script>
                            new UISearch(document.getElementById('sb-search'));
                        </script>
                        <ul class="icon1 sub-icon1 profile_img">
                            <li>
                                <a class="active-icon c1" href="#"> </a>
                                <ul class="sub-icon1 list">
                                    <c:choose>
                                        <c:when test="${sessionScope.user1==null}">

                                            <div class="product_control_buttons">
                                                <!--  	<a href="#"><img src="img/edit.png" alt=""/></a>-->
                                                <a href="#"><img src="img/close_edit.png" alt="" /></a>
                                            </div>
                                            <div class="clear"></div>
                                            <li class="list_img"><img src="img/1.jpg" width="50px" height="50px" alt="" /></li>

                                            <li class="list_desc">
                                                <h4><a id="userinfo" name="" href="javascript:;">游客你好！</a></h4><span class="actual">
                                                </span>
                                            </li>
                                            <div class="login_buttons">
                                                <div class="check_button"><a href="ToRegister">注册</a></div>
                                                <div class="login_button"><a href="tologin">登录</a></div>
                                                <div class="clear"></div>
                                            </div>
                                            <div class="clear"></div>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="product_control_buttons">
                                                <a href="toEditDetail"><img src="img/edit.png" alt="" /></a>
                                                <a href="#"><img src="img/close_edit.png" alt="" /></a>
                                            </div>
                                            <div class="clear"></div>

                                            <li class="list_img"><img src="${sessionScope.user1.getUserPic().getUserPic()}" width="50px" height="50px" alt="" /></li>

                                            <li class="list_desc">
                                                <h4><a id="userinfo" name="${sessionScope.user1.userId}" href="toIndividual">${sessionScope.user1.userNickname}</a></h4><span class="actual">
                                                    15级
                                                </span>
                                            </li>
                                            <div class="login_buttons">
                                                <!--  <div class="check_button"><a href="Register">注册</a></div> -->
                                                <div class="login_button"><a href="out">注销</a></div>
                                                <div class="clear"></div>
                                            </div>
                                            <div class="clear"></div>

                                        </c:otherwise>
                                    </c:choose>
                                </ul>
                            </li>
                        </ul>
                        <div class="clear"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>     
    <div class="main">
        <div class="shop_top">
            <div class="container">
			   <div class="list_title" id="list_title_id"><h3>器材百科</h3> </div> <div class="list_a"><a href="">更多器材</a> </div>
                <div class="clear"></div>
                  <div class="_br"></div>
                    <div class="col-md-3 shop_box" >
                    <a href="${equipment.equipmentUrl }">
                        <img src="${equipment.equipmentImg }" class="img-responsive" alt="">
                    </a><div class="shop_desc">
                        <a href="${equipment.equipmentUrl }">
                        </a><h3 style="margin-left:100px"><a href="${equipment.equipmentUrl }"> ${equipment.equipmentName }</a></h3>
                    </div>
                </div>


            </div>
            </div>
        </div>
    <div class="footer">

    </div>
</body>
</html>