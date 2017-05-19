<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
<title>登陆</title>
<link href="css1/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="css1/style.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<script src="js1/jquery.min.js"></script>
<script type="text/javascript">

		$( function(){
			if("${param.status}"=="1")
			alert("用户名或密码错误！")
		})

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
        var a;
        function checkName(t){
        //alert (t)
        if(t==""){
        $("#lname").css("color","red");
        $("#lname").css("display","block");
        $("#lname").html("请输入用户名或手机号");
        a=false;
        }else{
        // 同步验证用户是否重复
        var name=t;
                $.ajax({
                    type: "post",
                    async:false,//将异步改为同步才能按顺序执行方法
                    url: "findname",
                    data: "name=" + name,
                    success: function(msg){
                    //var result = JSON.parse(data);
                 //   alert(msg)
                    if(msg=="none"){                   
                    	$("#lname").css("color","red");
        				$("#lname").css("display","block");
        				$("#lname").html("该用户未注册");
        				a=false;
                        }
                        else {
                       
        				$("#lname").css("display","none");
        				a=true;
                                         
                      }                     
                   }
               });
            
        }
        } var b;
        function checkPass(t){
        //alert(t)
        if(t==""){
         $("#lpass").css("color","red");
        $("#lpass").css("display","block");
        $("#lpass").html("请输入密码");
        b=false;
        }else{
          $("#lpass").css("display","none");
          b=true;
        }
        }
        function checkAll(){
        if(a&&b)
        return true; 
        else 
        return false;
        }
         function keyLogin(){  
  if (event.keyCode==13)                         
//按Enter键的键值为13  
     document.getElementById("sub").click(); 
     
//调用登录按钮的登录事件 
 }

     </script>
 </head>
<body onkeydown="keyLogin();">
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
						  	<a href="#"><img src="img/edit.png" alt=""/></a>
						  		<a href="#"><img src="img/close_edit.png" alt=""/></a>
						  </div>
						   <div class="clear"></div>
						  
						   <li class="list_img"><img src="${sessionScope.user1.getUserPic().getUserPic()}" width="50px" height="50px"  alt=""/></li>
						  
						   <li class="list_desc"><h4 ><a id="userinfo" name="${sessionScope.user1.userId}" href="#">${sessionScope.user1.userNickname}</a></h4><span class="actual">
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
			<div class="col-md-6">
				 <div class="login-page">
					<h4 class="title">新用户</h4>
					<p>为方便您获得我站更多的优质服务，您可以点击下面按钮注册我站会员。如若已经注册，请到右侧登陆</p>
					<div class="button1">
					   <a href="ToRegister"><input type="submit" name="Submit" value="注册一个用户"></a>
					 </div>
					 <div class="clear"></div>
				  </div>
				</div>
				<div class="col-md-6">
				 <div class="login-title">
	           		<h4 class="title">登陆用户</h4>
					<div id="loginbox" class="loginbox">
						<form action="login" method="post" name="login" onsubmit="checkAll();"id="login-form">
						  <fieldset class="input">
						    <p id="login-form-username">
						      <label for="modlgn_username">用户名/手机号</label> <label id="lname">请输入用户名</label>
						      <input id="modlgn_username" type="text" onchange="checkName(this.value)"onkeyup="checkName(this.value)" name="nameorphone" class="inputbox" size="18" autocomplete="off">
						    </p>
						    <p id="login-form-password">
						      <label for="modlgn_passwd">密码</label><label id="lpass">请输入密码</label>
						      <input id="modlgn_passwd" type="password" name="password" onchange="checkPass(this.value)"onkeyup="checkPass(this.value)"class="inputbox" size="18" autocomplete="off">
						    </p>
						    <div class="remember">
							    <p id="login-form-remember">
							      <label for="modlgn_remember"><a href="#">忘记密码？ </a></label>
							   </p>
							    <input type="submit" name="Submit" id="sub"class="button" value="Login"><div class="clear"></div>
							 </div>
						  </fieldset>
						 </form>
					</div>
			      </div>
				 <div class="clear"></div>
			  </div>
			</div>
		  </div>
	  </div>
	  <div class="footer">
			
		</div>
</body>	
</html>