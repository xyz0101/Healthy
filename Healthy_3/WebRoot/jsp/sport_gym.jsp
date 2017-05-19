<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%

String path = request.getContextPath();
//request.setCharacterEncoding("UTF-8");
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>健身房</title>
    <link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/WdatePicker.css" />
<link rel="stylesheet" type="text/css" href="css/skin_/table.css" />
<link rel="stylesheet" type="text/css" href="css/jquery.grid.css" />
   
<link href="css1/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="css1/style.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<script src="js1/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.pagination.js"></script>

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

                    function staplace(t){
                    $.ajax({
                    type: "post",
                    url: "getstid",
                    data: "stid="+t,
                    success: function(data){
                    //alert(11111);
                    }
                    });
                    }
     </script>
</head>
<body>
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
				  <div class="search-box1">
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
     <div class="main">
      <div class="shop_top">
		<div class="container">
			
			<div class="row">
			<c:forEach items="${requestScope.proj}" var="sta" begin="0" end="8" varStatus="status" >
				<div class="col-md-3 shop_box1" ><a  href="ToStadium_Detail1?id=${sta.stadiumId}">
					<img src="${sta.stadiumPhoto}" width="262px" height="174px" class="img-responsive" alt=""/>
						<span class="new-label">${sta.stadiumName}</span>
					<div class="shop_desc">
					
						<h3 style="margin-left:150px"><a href="ToStadium_Detail1?id=${sta.stadiumId}" >进入场馆</a></h3>
						<p>简介:${sta.stadiumIntroduction } </p>
						<!--  <span class="actual">$12.00</span><br>
						 <ul class="buttons">
							<li class="cart"><a href="#">Add To Cart</a></li>
							<li class="shop_btn"><a href="#">Read More</a></li>
							<div class="clear"> </div>
					    </ul>-->
				    </div>
				</a></div>
				 </c:forEach>
			</div>
			  <div class="pagination" style="margin-left:35%"></div>
		 </div>
		
	   </div>
	  </div>
	   <script>
	  var cp=0;
	  var id="${requestScope.spid}"
	  if("${param.page}"=="")
	  cp=1;
	  else cp="${param.page}";
	  $('.pagination').pagination(${requestScope.number},{
                         items_per_page : ${requestScope.psize},
                         current_page :parseInt(cp)-1,
						callback: function(page){
						page1=page+1
						location.href="tosport_gym?id="+id+"&page="+page1;
						//alert(page+1);	
						},
						display_msg: false
						});
	  
	  </script>
	  
	  
	  <div class="footer">
	
		</div>
</body>	
</html>