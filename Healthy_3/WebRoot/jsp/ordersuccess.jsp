<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
   <title>我的订单</title>
<link href="css1/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="css1/style.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<script src="js1/jquery.min.js"></script>
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
        
     </script>
	    <style>
        .order_table {

               background: #fcfcfc;
        }
       .order_table  .order{
                content: '\0020';
    display: block;
    height: 120px;
    clear: both;
    margin-left:0px;
        }
.order_table  .order_check{
    float:left;
}
.order_table .order_img{
    float:left;
}
.order_table .order_number{
    float:left;
}
.order_table .order_place{
    float:left;
}
.order_table .order_price{
     float:left;

 }
.order_table .order_time{
      float:left;
  }
 .order_table  .delete_order{
      float:left;
  }
  .order_table .order_checkbox{
      width:40px;
      height:120px;
  }
  .order_table .order_checkbox input{
     margin-top:50px;
     margin-left:10px
  }
 .order_table  .img_block{
      float:left;
      width:100px;
      height:100px;
  }
   .order_table  .img_block img{
     margin:10px 10px 0px 0px;
      width:100px;
      height:100px;
  }
  .order_table .img_sum{
      float:left;
        width:300px;
      height:120px;
  }
   .order_table  .img_sum .summary{
     
      margin-left:20px;
      margin-top:20px;
  }
 .order_table  .summary{
    float:left;
      width:150px;
      height:40px;
  }
  .order_table   .place{
         width:220px;
      height:120px;
  }
  .order_table   .time{
         width:180px;
      height:120px;
    }

  .order_table   .delete{
            width:100px;
      height:120px;

    }
  .order_table   .number{
           width:100px;
      height:120px;
    }
	 .order_table   .price{
           width:100px;
      height:120px;
    }
  .order_table   li{
     border: ridge thin;
    
        list-style:none;
    }
  .order_table   ul p,a,div,li,input{
        margin:0px;
        padding:0px;
    }
    </style>
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
						    	<li><a href="shop.html">运动日历</a></li>
						    	<li><a href="experiance.html">运动社区</a></li>
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
	  <script >
	 /* $(function getOrder(){
        var userid=$("#userinfo").attr("name");
        alert(userid)
        $.ajax({
        	type:"post",
        	url:"getOrderDetail",
        	data:"userid="+userid,
        	success:function(msg){
        		alert(${sessionScope.orderlist })
        	}
        });
        })*/
	  </script>
	     <div class="main">
      <div class="shop_top">
		<div class="container" >
		<p>我的订单：</p>
		
		<c:forEach items="${requestScope.orderlist }" var="odl" begin="0" end="6" varStatus="status"> 
		<div class="order_table">
        <ul class="order">
            <li class="order_check">         
                  <div class="order_checkbox ">
                        <input type="checkbox" checked="checked">
                </div>
            </li>
            <li class="order_img"><div class="img_sum"><div class="img_block"><img src="1/place1.jpg" /></div><div class="summary">摘要</div></div></li>
            <li class="order_place"><div class="place"><p>${odl.orderPlace }</p></div></li>
            <li class="order_time"><div class="time"><p>${odl.orderStartTime }</p><p>${odl.orderEndTime }</p></div></li>
            <li class="order_number"><div class="number"><p>${odl.orderNumber }</p></div></li>
            <li class="order_price"> <div class="price"><p>${odl.orderPrice }</p></div></li>
            <li class="delete_order"><div class="delete"><a href="">删除订单</a></div></li>
        </ul>
    </div>
    </c:forEach>
		
	     </div>
	   </div>
	  </div>

	  </div>
	  <div class="footer">
			<div class="container">
				<div class="row">
					<div class="col-md-3">
						<ul class="footer_box">
							<h4>Products</h4>
							<li><a href="#">Mens</a></li>
							<li><a href="#">Womens</a></li>
							<li><a href="#">Youth</a></li>
						</ul>
					</div>
					<div class="col-md-3">
						<ul class="footer_box">
							<h4>About</h4>
							<li><a href="#">Careers and internships</a></li>
							<li><a href="#">Sponserships</a></li>
							<li><a href="#">team</a></li>
							<li><a href="#">Catalog Request/Download</a></li>
						</ul>
					</div>
					<div class="col-md-3">
						<ul class="footer_box">
							<h4>Customer Support</h4>
							<li><a href="#">Contact Us</a></li>
							<li><a href="#">Shipping and Order Tracking</a></li>
							<li><a href="#">Easy Returns</a></li>
							<li><a href="#">Warranty</a></li>
							<li><a href="#">Replacement Binding Parts</a></li>
						</ul>
					</div>
					<div class="col-md-3">
						<ul class="footer_box">
							<h4>Newsletter</h4>
							<div class="footer_search">
				    		   <form>
				    			<input type="text" value="Enter your email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Enter your email';}">
				    			<input type="submit" value="Go">
				    		   </form>
					        </div>
							<ul class="social">	
							  <li class="facebook"><a href="#"><span> </span></a></li>
							  <li class="twitter"><a href="#"><span> </span></a></li>
							  <li class="instagram"><a href="#"><span> </span></a></li>	
							  <li class="pinterest"><a href="#"><span> </span></a></li>	
							  <li class="youtube"><a href="#"><span> </span></a></li>										  				
						    </ul>
		   				</ul>
					</div>
				</div>
				<div class="row footer_bottom">
				    <div class="copy">
			           <p>© 2014 Template by <a href="http://w3layouts.com" target="_blank">w3layouts</a></p>
		            </div>
					  <dl id="sample" class="dropdown">
				        <dt><a href="#"><span>Change Region</span></a></dt>
				        <dd>
				            <ul>
				                <li><a href="#">Australia<img class="flag" src="img/as.png" alt="" /><span class="value">AS</span></a></li>
				                <li><a href="#">Sri Lanka<img class="flag" src="img/srl.png" alt="" /><span class="value">SL</span></a></li>
				                <li><a href="#">Newziland<img class="flag" src="img/nz.png" alt="" /><span class="value">NZ</span></a></li>
				                <li><a href="#">Pakistan<img class="flag" src="img/pk.png" alt="" /><span class="value">Pk</span></a></li>
				                <li><a href="#">United Kingdom<img class="flag" src="img/uk.png" alt="" /><span class="value">UK</span></a></li>
				                <li><a href="#">United States<img class="flag" src="img/us.png" alt="" /><span class="value">US</span></a></li>
				            </ul>
				         </dd>
	   				  </dl>
   				</div>
			</div>
		</div>
</body>	
</html>