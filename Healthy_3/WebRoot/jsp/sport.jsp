<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>运动项目</title>
<link href="css1/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="css1/style.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<script src="js1/jquery.min.js"></script>
<!--<script src="js1/jquery.easydropdown.js"></script>-->
<!--start slider -->
<link rel="stylesheet" href="css1/fwslider.css" media="all">
<script src="js1/jquery-ui.min.js"></script>
<script src="js1/fwslider.js"></script>
<!--end slider -->
<script type="text/javascript">
        $(document).ready(function() {
            $(".dropdown img.flag").addClass("flagvisibility");

            $(".dropdown dt a").click(function() {
                $(".dropdown dd ul").toggle();
            });
                        
            $(".dropdown dd ul li a").click(function() {
                var text = $(this).html();
                $(".dropdown dt a span").html(text);
                $(".dropdown dd ul").hide();
                $("#result").html("Selected value is: " + getSelectedValue("sample"));
            });
                        
            function getSelectedValue(id) {
                return $("#" + id).find("dt a span.value").html();
            }

            $(document).bind('click', function(e) {
                var $clicked = $(e.target);
                if (! $clicked.parents().hasClass("dropdown"))
                    $(".dropdown dd ul").hide();
            });


            $("#flagSwitcher").click(function() {
                $(".dropdown img.flag").toggleClass("flagvisibility");
            });
        });
       // alert(${sessionScope.user1.getUserPic().getUserPic()})
    
        
     </script>
</head>
<body >
	<div class="header">
		<div class="container">
			<div class="row">
			  <div class="col-md-12">
				 <div class="header-left">
					 <div class="logo">
						<a href="tosport"><img src="photo/logo.png" width="75px",height="60px"alt=""/></a>
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
							new UISearch( document.getElementById( 'sb-search' ) );
						</script>
						<!----//search-scripts---->
				    <ul class="icon1 sub-icon1 profile_img">
					 <li><a class="active-icon c1" href="#"> </a>
						<ul class="sub-icon1 list">
						  <c:choose>
  					<c:when test="${sessionScope.user1==null}">
  					
  					  <div class="product_control_buttons">
						   <!--  	<a href="#"><img src="img/edit.png" alt=""/></a>-->
						  		<a href="#"><img src="img/close_edit.png" alt=""/></a>
						  </div>
						   <div class="clear"></div>
  					 <li class="list_img"><img src="img/1.jpg" width="50px" height="50px"  alt=""/></li>
						 
						  <li class="list_desc"><h4 ><a id="userinfo"name="" href="javascript:;">游客你好！</a></h4><span class="actual">
                          </span></li>
						  <div class="login_buttons">
							 <div class="check_button"><a href="ToRegister">注册</a></div>
							 <div class="login_button"><a href="tologin">登录</a></div>
							 <div class="clear"></div>
						  </div>
						  <div class="clear"></div>
						  </c:when>
						  <c:otherwise>
						  <div class="product_control_buttons">
						  	<a href="toEditDetail"><img src="img/edit.png" alt=""/></a>
						  		<a href="#"><img src="img/close_edit.png" alt=""/></a>
						  </div>
						   <div class="clear"></div>
						  
						   <li class="list_img"><img src="${sessionScope.user1.getUserPic().getUserPic()}" width="50px" height="50px"  alt=""/></li>
						  
						   <li class="list_desc"><h4 ><a id="userinfo" name="${sessionScope.user1.userId}" href="toIndividual">${sessionScope.user1.userNickname}</a></h4><span class="actual">
                          15级</span></li>
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
	<div class="banner">
	<!-- start slider -->
       <div id="fwslider">
         <div class="slider_container">
            <div class="slide"> 
                <!-- Slide image -->
               <img src="img/slider1.jpg" class="img-responsive" alt=""/>
                <!-- /Slide image -->
                <!-- Texts container -->
                <div class="slide_content">
                    <div class="slide_content_wrap">
                        <!-- Text title -->
                        <h1 class="title">Run Over<br>Everything</h1>
                        <!-- /Text title -->
                    </div>
                </div>
               <!-- /Texts container -->
            </div>
            <!-- /Duplicate to create more slides -->
            <div class="slide">
               <img src="img/slider2.jpg" class="img-responsive" alt=""/>
                <div class="slide_content">
                    <div class="slide_content_wrap">
                        <h1 class="title">Run Over<br>Everything</h1>
                    </div>
                </div>
            </div>
            <!--/slide -->
        </div>
        <div class="timers"></div>
        <div class="slidePrev"><span></span></div>
        <div class="slideNext"><span></span></div>
       </div>
       <!--/slider -->
      </div>
	  <div class="main">
		
		</br></br></br>
		<script type="text/javascript">
		$(function(){
		$(".content-bottom").css("background", "url("+"${requestScope.advice.adviceImg }"+")no-repeat center top")
		$(".content-bottom").css("background-size", " 100% auto");
		})		
		</script>
	<h3 class="m_3">体育运动</h3>
 <div class="content-bottom" >
 
		<div class="container">
		
			<div class="row content_bottom-text" style="margin-top:-15%">
			  <div class="col-md-7">
				<h3>运动知识<br>${requestScope.advice.adviceTitle }</h3>
				<p class="m_1">${requestScope.advice.adviceContent }</p>
			  </div>
			</div>
		</div>
	</div>
	
	<div class="features">
		<div class="container">
			<h3 class="m_3">运动场所推荐</h3>
			<div class="close_but"><i class="close1"> </i></div>
			  <div class="row" >
			  <c:forEach items="${requestScope.beststadium }" begin="0" end="3" var="best" varStatus="status">
                <div class="col-md-3 top_box">
					<div class="view view-ninth"><a href="ToStadium_Detail1?id=${best.stadiumId }">
                    <img src="${best.stadiumPhoto }" class="img-responsive" alt=""/>
                    <div class="mask mask-1"> </div>
                    <div class="mask mask-2"> </div>
                      <div class="content">
                        <h2>${best.stadiumName }</h2>
                        <p>${best.stadiumIntroduction }</p>
                      </div>
                    </a> </div>
                   <h4 class="m_4"><a href="#">${best.stadiumName }</a></h4>
                   <p class="m_5">价格区间：${best.stadiumPrice }</p>
				</div>
				</c:forEach>
				 </div>
			</div>
		 </div>
	    
		<div class="footer">
			<div class="container">
				
			</div>
		</div>
		</div>
</body>	
</html>