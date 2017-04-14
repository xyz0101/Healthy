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
<title>注册</title>
<link href="css1/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="css1/style.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<script src="js1/jquery.min.js"></script>
<!--<script src="js1/jquery.easydropdown.js"></script>-->
<!--start slider -->
<link rel="stylesheet" href="css1/fwslider.css" media="all">
<script src="js1/jquery-ui.min.js"></script>
<script src="js1/fwslider.js"></script>
<script src="js1/checkpwd.js"></script>
<!--end slider -->

<script type="text/javascript">
		var a,b,c;
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
        function checkPhone(t){
        var reg=/^1[34578]\d{9}$/; 
      
       if(t==""){
       $("#tphone").css("color","red");
		$("#tphone").html("请输入手机号");
		$("#tphone").css("display","block");
		b=false;
       }
		//alert(reg.test("15115778766"))
		else if(reg.test(t)){
		$("#tphone").css("color","gray");
		$("#tphone").html("手机号输入正确");
		$("#tphone").css("display","block");
		b= true; 
		}else{
		$("#tphone").css("color","red");
		$("#tphone").html("手机号格式不正确");
		$("#tphone").css("display","block");
		b= false;
		}
		
		} 
        function checkPass(t){
        if(t==""){
            $("#tpassword").css("color","red");
             $("#tpassword").css("display","block");
                $("#tpassword").html("密码不能为空");
               c= false;
            }
       else if(t.length<6){
       $("#tpassword").css("color","red");
             $("#tpassword").css("display","block");
                $("#tpassword").html("密码长度必须大于6位");
               c= false;
       }else if(t.length>15){
          $("#tpassword").css("color","red");
             $("#tpassword").css("display","block");
                $("#tpassword").html("密码长度不能大于15位");
                  return false;
       }else{
        $("#tpassword").css("display","none");
          c= true;
       }
        }
        
        function checkName(t){
        if(t==""){
            $("#tname").css("color","red");
             $("#tname").css("display","block");
                $("#tname").html("用户名不能为空");
               a= false;
            }else{
              $("#tname").css("display","none");
            // 验证用户是否重复
                $.ajax({
                    type: "post",
                    async:false,//将异步改为同步才能按顺序执行方法
                    url: "findname",
                    data: "name=" +t,
                    success: function(data){
                    var result = JSON.parse(data);
                 //   alert(result) 
                    if(result>=1){   
                                   
                    	$("#tname").css("color","red");
			             $("#tname").css("display","block");
			                $("#tname").html("该用户名已被注册");
			                a= false;
                        }
                        else {
                         $("#tname").css("display","block");
                        $("#tname").css("color","gray");
                        $("#tname").html("该用户名可用"); 
                        a=true;                        
                      }                     
                   }
               });
            }            
        }
        function check(){
  var checkbox = document.getElementById("book");//
  //alert(checkbox.checked);//是否被选中
  if(checkbox.checked){
  return true;
  }else{
     //没选中
     return false;
  }
}
        function checkAll(){
        if(a&&b&&c&&check()){
        return true;
        }else
        return false;
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
            <form action="Register" method="post" onsubmit="return checkAll();">
								<div class="register-top-grid">
										<h3>用户信息</h3>
										<div>
											<span>用户名<label>*</label></span><span class="tip"id="tname">用户名不能为空</span>
											<input type="text" name="userNickname" onchange="checkName(this.value);"onkeyup="checkName(this.value);"> 
										</div>
										<div>
											<span>密码<label>*</label></span><span class="tip"id="tpassword">密码不能为空</span><table cellpadding="0" cellspacing="0" border="0" id="pwdpower">
											
												<tr>
												<td id="pweak" style="">弱</td>
												<td id="pmedium" style="">中</td>
												<td id="pstrong" style="">强</td>
												</tr>
												</table>
											
												
											<input type="password" name="userPassword" onblur="checkPass(this.value)"onchange="javascript:EvalPwd(this.value);"onkeyup="javascript:EvalPwd(this.value);"> 
										</div>
										<div>
											<span>手机号<label>*</label></span><span class="tip" id="tphone">手机号不能为空</span>
											
											<input type="text" name="userTel"onchange="checkPhone(this.value);"onkeyup="checkPhone(this.value);"> 
										</div>
										
                                    <div>
                                        <span>性别<label>*</label></span>
                                      <div id="sex">  <label	><input type="radio" name="userSex" />男</label><label id="l2" ><input type="radio" name="userSex" checked="checked" />女</label>
                                    </div>
                                    </div>
                                    <div class="clear"> </div>
                                    <a class="news-letter" href="#">
                                        <label class="checkbox"><input id="book" type="checkbox" onclick="check();"name="checkbox" checked=""><i> </i>阅读并同意《健身吧用户协议》</label>
                                    </a>
                                    <div class="clear"> </div>

                                    <div class="clear"> </div>
                                    <input type="submit" value="注册">
								</div>

										
						</form>
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