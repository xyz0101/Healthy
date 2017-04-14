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
    
    <title>场馆详情</title>
    
	<link href="css1/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="css1/style.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<script src="js1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="css1/datedropper.css">
<link rel="stylesheet" type="text/css" href="css1/timedropper.min.css">
<style type="text/css">
.demo{margin:80px auto 40px auto;width:320px}
.input{padding:6px;border:1px solid #d3d3d3}
</style>
<script src="js1/datedropper.min.js"></script>
<script src="js1/timedropper.min.js"></script>

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

       $(function(){
       
        $("#pricerange").html(${requestScope.min }+"-"+${requestScope.max});
      // 	avr();
       } );
       var pr=0;
       function choose(t){
       var spl=t.getAttribute("name");
       alert(spl)
       		var i=t.getElementsByTagName("a")[0].getAttribute("id");
       		var price=t.getElementsByTagName("a")[0].getAttribute("name");
       		//alert(i+"---"+price)
       		if(i==0){
       		pr=pr+parseInt(price);
       		t.getElementsByTagName("a")[0].setAttribute("id","1");
       		t.getElementsByTagName("div")[0].setAttribute("class","comfirm");
       		$("#pricenow").html(pr);
       		}
       		else{
       		pr=pr-parseInt(price);
       		t.getElementsByTagName("a")[0].setAttribute("id","0");
       		t.getElementsByTagName("div")[0].setAttribute("class","uncomfirm");
       		 $("#pricenow").html(pr);
       		}       	
       }
       </script>
     <!----details-product-slider--->
				<!-- Include the Etalage files -->
					<link rel="stylesheet" href="css1/etalage.css">
					<script src="js1/jquery.etalage.min.js"></script>
				<!-- Include the Etalage files -->
				<script>
						jQuery(document).ready(function($){
			
							$('#etalage').etalage({
								thumb_image_width: 300,
								thumb_image_height: 400,
								
								show_hint: true,
								click_callback: function(image_anchor, instance_id){
									alert('Callback example:\nYou clicked on an image with the anchor: "'+image_anchor+'"\n(in Etalage instance: "'+instance_id+'")');
								}
							});
							// This is for the dropdown list example:
							$('.dropdownlist').change(function(){
								etalage_show( $(this).find('option:selected').attr('class') );
							});

					});
				</script>
				<!----//details-product-slider--->	
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
						  <div class="product_control_buttons">
						  	<a href="#"><img src="img/edit.png" alt=""/></a>
						  		<a href="#"><img src="img/close_edit.png" alt=""/></a>
						  </div>
						   <div class="clear"></div>
						 <c:choose>
  					<c:when test="${sessionScope.user1==null}">
  					 <li class="list_img"><img src="img/1.jpg" width="50px" height="50px"  alt=""/></li>
						  
						  <li class="list_desc"><h4 ><a id="userinfo" href="#">游客你好！</a></h4><span class="actual">
                          </span></li>
						  <div class="login_buttons">
							 <div class="check_button"><a href="ToRegister">注册</a></div>
							 <div class="login_button"><a href="tologin">登录</a></div>
							 <div class="clear"></div>
						  </div>
						  <div class="clear"></div>
						  </c:when>
						  <c:otherwise>
						   <li class="list_img"><img src="${sessionScope.user1.getUserPic().getUserPic()}" width="50px" height="50px"  alt=""/></li>
						  
						   <li class="list_desc"><h4 ><a id="userinfo" href="#">${sessionScope.user1.userNickname}</a></h4><span class="actual">
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
				<div class="col-md-9 single_left">
				   <div class="single_image">
					     <ul id="etalage">
							<li>
								<a href="optionallink.html">
									<img class="etalage_thumb_image" src="img/3.jpg" />
									<img class="etalage_source_image" src="img/3.jpg" />
								</a>
							</li>
							<li>
								<img class="etalage_thumb_image" src="img/4.jpg" />
								<img class="etalage_source_image" src="img/4.jpg" />
							</li>
							<li>
								<img class="etalage_thumb_image" src="img/5.jpg" />
								<img class="etalage_source_image" src="img/5.jpg" />
							</li>
							<li>
								<img class="etalage_thumb_image" src="img/6.jpg" />
								<img class="etalage_source_image" src="img/6.jpg" />
							</li>
							<li>
								<img class="etalage_thumb_image" src="img/7.jpg" />
								<img class="etalage_source_image" src="img/7.jpg" />
							</li>
							<li>
								<img class="etalage_thumb_image" src="img/8.jpg" />
								<img class="etalage_source_image" src="img/8.jpg" />
							</li>
							<li>
								<img class="etalage_thumb_image" src="img/9.jpg" />
								<img class="etalage_source_image" src="img/9.jpg" />
							</li>
						</ul>
					    </div>
				        <!-- end product_slider -->
				        <div class="single_right">
				        	<h3>场馆详细介绍 </h3>
				        	<p class="m_10">${requestScope.stadium.stadiumIntroduction }</p>
				        	<p>${requestScope.stadium.stadiumLocation }</p>
				        	<ul class="options">
								<span>选择人数:</span><br>
								<select style="width:100px">
									<option>1</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
									<option>5</option>
									<option>6</option>
								</select>
							</ul>
				        	<ul class="product-colors">
								<h3>选择场地</h3>
								<c:forEach items="${requestScope.splist }" var="spl" begin="0" end="6" varStatus="status"> 
								<li name="${spl }" onclick="choose(this)"><div class="uncomfirm"></div><a class="color1" id="0" name="${spl.placePrice }">
								
								<img src="${spl.placePhoto }" width="32px" height="32px">
								</a>
								</li>
								</c:forEach>
								<div class="clear"> </div>
							</ul>
							
								<p>请选择日期：<input type="text" class="input" id="pickdate" /></p><br/>
								<p>请开始时间：<input type="text" class="input" id="picktime" /></p><br/>
								<p>请结束时间：<input type="text" class="input" id="pickovertime" /></p><br/>
								
								<script>
									$("#pickdate").dateDropper({
										animate: false,
										format: 'Y-m-d',
										maxYear: '2020'
									});
									$("#picktime").timeDropper({
										meridians: false,
										format: 'HH:mm',
									});
									$("#pickovertime").timeDropper({
										meridians: false,
										format: 'HH:mm',
									});
									</script>
							<div class="btn_form">
							   <form action="" method="post" onsubmit="check()">
								 <input type="submit" value="立即预约" title="">
							  </form>
							</div>
							
				        </div>
				        <div class="clear"> </div>
				</div>
				<div class="col-md-3" width="300px">
				  <div class="box-info-product">
					      <ul class="add-to-links">
    			              <li><img src="img/wish.png" alt=""><a href="#">添加到收藏</a></li>
    			            </ul>
							<div class="social_buttons">
								<h4>分享到：</h4>
								<button type="button" class="btn1 btn1-default1 btn1-twitter" onclick="">
					              <i class="icon-twitter"></i> QQ空间
					            </button>
					            <button type="button" class="btn1 btn1-default1 btn1-facebook" onclick="">
					              <i class="icon-facebook"></i> 圈子
					            
					        </div>
				   </div>
			   </div>
			   <div class="col-md-3" width="300px">
				  <div class="box-info-price"id="haha">
				
				  	<p class="price">价格:</p>
				 	<p class="price2" id="pricerange" >0-0</p>
					<p class="price">已选价格:</p>
				 	<p class="price2" id="pricenow">0</p>
				  </div>
				  </div>
			</div>		
			<div class="desc">
			   	<h4>Description</h4>
			   	<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores</p>
			</div>
			<div class="row">
				<h4 class="m_11">相关热门场地推荐</h4>
				<div class="col-md-4 product1">
					<img src="img/s1.jpg" class="img-responsive" alt=""/> 
					<div class="shop_desc"><a href="single.html">
						</a><h3><a href="single.html"></a><a href="#">aliquam volutp</a></h3>
						<p>Lorem ipsum consectetuer adipiscing </p>
						<span class="reducedfrom">$66.00</span>
						<span class="actual">$12.00</span><br>
						<ul class="buttons">
							<li class="cart"><a href="#">Add To Cart</a></li>
							<li class="shop_btn"><a href="#">Read More</a></li>
							<div class="clear"> </div>
					    </ul>
				    </div>
				</div>
				<div class="col-md-4 product1">
					<img src="img/s2.jpg" class="img-responsive" alt=""/> 
					<div class="shop_desc"><a href="single.html">
						</a><h3><a href="single.html"></a><a href="#">aliquam volutp</a></h3>
						<p>Lorem ipsum consectetuer adipiscing </p>
						<span class="reducedfrom">$66.00</span>
						<span class="actual">$12.00</span><br>
						<ul class="buttons">
							<li class="cart"><a href="#">Add To Cart</a></li>
							<li class="shop_btn"><a href="#">Read More</a></li>
							<div class="clear"> </div>
					    </ul>
				    </div>
				</div>
				<div class="col-md-4">
					<img src="img/s3.jpg" class="img-responsive" alt=""/> 
					<div class="shop_desc"><a href="single.html">
						</a><h3><a href="single.html"></a><a href="#">aliquam volutp</a></h3>
						<p>Lorem ipsum consectetuer adipiscing </p>
						<span class="reducedfrom">$66.00</span>
						<span class="actual">$12.00</span><br>
						<ul class="buttons">
							<li class="cart"><a href="#">Add To Cart</a></li>
							<li class="shop_btn"><a href="#">Read More</a></li>
							<div class="clear"> </div>
					    </ul>
				    </div>
				</div>
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