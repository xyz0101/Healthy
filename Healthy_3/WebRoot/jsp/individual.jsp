<%@page import="com.Healthy.dao.UserMainDAO"%>
<%@page import="com.Healthy.dao.impl.UserMainDAOImpl"%>
<%@page import="com.Healthy.controller.UserMainController"%>
<%@page import="com.Healthy.model.UserDetail"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
   
    <title>我的资料</title>
    <link href="css1/comment.css" rel='stylesheet' type='text/css' />
    <style>
       
       .white_content{
           display:none;
           position:absolute;
            z-index: 1002;
          background-color: white;
           width:500px;
           height:400px;
          margin-left:10%;
            border: 2px solid orange;
           margin-top:-100px;
       }
        .black_overlay {
            display: none;
            position: absolute;
            top: 0%;
            left: 0%;
            width: 100%;
            height: 100%;
            background-color: none;
            z-index: 1001;
             -moz-opacity: 0.8;
            opacity: .80;
            filter: alpha(opacity=88);
        }
        .content1{
               border: 2px solid lightblue;
               margin-top:5%;
               height:240px;
        }
   </style>
    
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
     <script type="text/javascript" src="js/jquery.pagination.js"></script>
    <link rel="stylesheet" href="css1/detail.css" />
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
    <script>
        function reverse(t) {
           // alert(t.id)
            for (var i = 1; i <=4; i++) {
                $("#d_detail_0" + i).css("display", "none")
                
                 $(".all_order_checkbox").css("display", "none")
                   $(".delete_block" ).css("display", "none")
                      $(".all_order_checkbox1").css("display", "none")
                   $(".delete_block1" ).css("display", "none")
                  $(".pagination").css("display", "none")
                   $(".pagination1").css("display", "none")
                   $(".pagination2").css("display", "none")
                   $(".pay_block" ).css("display", "none")
                $("#0"+ i).css("border-bottom-color", "#F8DBA3")
              
            }
            $("#d_detail_" + t.id).css("display", "block")
            $("#" + t.id).css("border-bottom-color", "#FFFFFF")
             if((t.id)==3){
                $(".pagination2").css("display", "block")
                 getMessage("1")
                  
                  
                }
            if((t.id)==2){
                $(".all_order_checkbox").css("display", "block")
                  $(".delete_block" ).css("display", "block")
                  $(".pagination").css("display", "block")
                   $(".pay_block" ).css("display", "block")
                }
             else   if((t.id)==4){
                $(".all_order_checkbox1").css("display", "block")
                  $(".delete_block1" ).css("display", "block")
                  $(".pagination1").css("display", "block")
                  
                }
            
        }
        
      
    </script>
    <div class="main">
        <div class="shop_top">
            <div class="container">
                <div class="d_body">
                    <div class="d_head"><p>个人资料</p></div>
                    <div class="d_left">
                        <div class="up_head">
                            <p id="icon_container">
                            <a href="javascript:;" onclick="update_head()" class="bor2">
                                <img id="user_icon" src="${sessionScope.user1.getUserPic().getUserPic()}"width="100px" height="100px" >
                                </a>
                            </p>
                            
                            
                        </div>
                    </div>
                    <div class="d_right">
                        <div class="d_nickname">${sessionScope.user1.userNickname}</div>
                         <div class="d_block">
                        <ul>
                            <li><a  class="choose" id="01" onclick="reverse(this)">基本资料</a></li>
                            <li><a  class="choose"id="02"onclick="reverse(this)" >预约订单</a></li>
                            <li><a  class="choose"id="03" onclick="reverse(this)">我的消息</a></li>
                            <li><a  class="choose"id="04" onclick="reverse(this)">已结订单</a></li>
                        </ul>
                            </div>
              
                      <script >
                      $(function writeDetail(){
                      $("#sex").html("${requestScope.usermain.userSex}")             
                      if("${requestScope.userdetail.userBirth}"!=""){
                        $("#age").html("${requestScope.age}")
                         $("#birthday").html("${requestScope.birthday}")
                         $("#astro").html("${requestScope.star}")
                      }
                      if("${requestScope.userdetail.userLocation}"!="")
                      $("#address").html("${requestScope.userdetail.userLocation}")
                      if("${requestScope.userdetail.userEmotion}"!="")
                      $("#emotion").html("${requestScope.userdetail.userEmotion}")
                      if("${requestScope.userdetail.userBlood}"!="")
                      $("#blood").html("${requestScope.userdetail.userBlood}")
                      if("${requestScope.userdetail.userTel}"!="")
                      $("#phone").html("${requestScope.userdetail.userTel}")
                      if("${requestScope.userdetail.userQq}"!="")
                      $("#qq").html("${requestScope.userdetail.userQq}")
                      if("${requestScope.userdetail.userSignature}"!="")
                      $("#signature").html("${requestScope.userdetail.userSignature}")
                      })
                      function go(){
                      alert($("#o_id").begin)
                      }
                      
					    
					                      
                      </script>
                        <div id="d_detail_01">
                            <div class="title">
                                <h4>基本资料</h4>
                            </div>
                            <ul>
                                <li id="sex_li">
                                    <label>性别：</label>
                                    <div id="sex" class="preview_option">未填写</div>
                                </li>
                                <li id="age_li">
                                    <label>年龄：</label>
                                    <div id="age" class="preview_option">未填写</div>
                                </li>
                                <li id="birthday_li">
                                    <label>生日：</label>
                                    <div id="birthday" class="preview_option">未填写</div>
                                </li>
                                <li id="astro_li">
                                    <label>星座：</label>
                                    <div id="astro" class="preview_option">未填写</div>
                                </li>
                                <li id="live_address_li">
                                    <label>现居地：</label>
                                    <div id="address" class="preview_option">未填写
                                    </div>
                                </li>
                                <li id="marriage_li">
                                    <label>感情状况：</label>
                                    <div id="emotion" class="preview_option">保密</div>
                                </li>
                                <li id="blood_li">
                                    <label>血型：</label>
                                    <div id="blood" class="preview_option">未填写</div>
                                </li>
                                <li id="phone_li">
                                    <label>手机号：</label>
                                    <div id="phone" class="preview_option">未填写 </div>
                                </li>
                                <li id="qq_li">
                                    <label>QQ号：</label>
                                    <div id="qq" class="preview_option">未填写  </div>
                                </li>
                                <li id="signature_li">
                                    <label>签名：</label>
                                    <div id="signature" class="preview_option">未填写  </div>
                                </li>
                            </ul>
								
                        </div>
                        <script type="text/javascript">
                        function goPage(t){
                        $.ajax({
                        type:"post",
                        url:"getpage",
                       
                        data:"goPage="+t,
                        success: function(rthtml){
                        alert(rthtml)
                        document.getElementById("d_detail_02").innerHTML = rthtml;
                        }
                        
                        })
                        }
                        function gopayPage(t){
                        $.ajax({
                        type:"post",
                        url:"getPaypage",
                       
                        data:"goPage="+t,
                        success: function(rthtml){
                        alert(rthtml)
                        document.getElementById("d_detail_04").innerHTML = rthtml;
                        }
                        
                        })
                        }
                        
                       function cho(t){
                      
                        var a = document.getElementsByClassName("order_checkbox")
          			 
           				 alert(t.checked)
           				 for (var i = 0; i < a.length; i++) {
           					     var b = a[i].getElementsByTagName("input")
           					if(t.checked)
           				  b[0].checked=true;
           				  else
           				   b[0].checked=false;
     					    }
                        }
                        
                        </script>
                        
                        <div id="d_detail_02">
			<c:forEach items="${requestScope.orderlist }"  var="odl" begin="0" end="4" varStatus="status"> 
		
		<div class="order_table">
        <ul class="order">
            <li class="order_check">         
                  <div class="order_checkbox " id="${odl.orderId }">
                        <input type="checkbox" checked="checked">
                </div>
            </li>
            <li class="order_img"><div class="img_sum"><div class="img_block"><img src="${odl.orderPhoto }" /></div><div class="summary">摘要</div></div></li>
            <li class="order_place"><div class="place"><p>${odl.orderPlace }</p></div></li>
            <li class="order_time"><div class="time"><p>${odl.orderStartTime }</p><p>${odl.orderEndTime }</p></div></li>
            <li class="order_number"><div class="number"><p>${odl.orderNumber }</p></div></li>
            <li class="order_price"> <div class="price"><p>${odl.orderPrice }</p></div></li>
            <li class="delete_order"><div class="delete"><a onclick="deleteo('${odl.orderId }')">删除订单</a></div></li>
            <li class="pay_order"><div class="pay"><a onclick="payo('${odl.orderId }')">支付订单</a></div></li>
        </ul>
        
    </div>
    				</c:forEach>
    				  </div>
                        <div class="all_order_checkbox " >
                        <input type="checkbox" checked="checked" onclick="cho(this)">全选
                		</div>
                        
                         <div class="pagination"></div>
                       <div class="delete_block"> <input onclick="deletechoose()" type="button" value="删除"> </div>
                         
                        <div class="pay_block"> <input onclick="paychoose()" type="button" value="结算"> </div>
                      
                        <script type="text/javascript">                              
                        function deleteo(t){
                         var msg = "您确定要删除该订单吗？\n\n请确认！"; 
				 if (confirm(msg)==true){ 
                        $.ajax({
                        type:"post",
                        url:"delete_order",
                        data:"id="+t,
                        success: function(msg){
                        alert("删除成功")
                        location.reload(true)
                        }
                        })
                        }else{ 
				  return false; 
				 } 
				 }
				 function deletechoose(){
				 var index=0;
				  var a = document.getElementsByClassName("order_checkbox")
          			  var id = "";
           				 alert(a)
           				 for (var i = 0; i < a.length-1; i++) {
           					     var b = a[i].getElementsByTagName("input")
           				   //  alert(b[0].checked)
           				     if (b[0].checked){
           				     index++;
           				      id = id+a[i].id+",";
           				     }
     					    }
     					    if(a[i].getElementsByTagName("input")[0].checked){
     					    index++;
     					     id = id + a[i].id;
     					    }
     					   if(index==0){
     					   alert("您还没有选择订单")
     					   return false;
     					   }
      					    alert(id)
                         var msg = "您确定要删除已选订单吗？\n\n请确认！"; 
				 if (confirm(msg)==true){ 
                        $.ajax({
                        type:"post",
                        url:"delete_order",
                        data:"id="+id,
                        success: function(msg){
                        alert("删除成功")
                        location.reload(true)
                        }
                        })
                        }else{ 
				  return false; 
				 } 
				 }
                         function payo(t){
                         var msg = "您确定要删支付该订单吗？\n\n请确认！"; 
				 if (confirm(msg)==true){ 
                        $.ajax({
                        type:"post",
                        url:"pay_order",
                        data:"id="+t,
                        success: function(msg){
                        alert("支付成功")
                        location.reload(true)
                        }
                        })
                        }else{ 
				  return false; 
				 }
				 } 
				 function paychoose(t){
                         var index=0;
				  var a = document.getElementsByClassName("order_checkbox")
          			  var id = "";
           				 alert(a)
           				 for (var i = 0; i < a.length-1; i++) {
           					     var b = a[i].getElementsByTagName("input")
           				   //  alert(b[0].checked)
           				     if (b[0].checked){
           				     index++;
           				      id = id+a[i].id+",";
           				     }
     					    }
     					    if(a[i].getElementsByTagName("input")[0].checked){
     					    index++;
     					     id = id + a[i].id;
     					    }
     					   if(index==0){
     					   alert("您还没有选择订单")
     					   return false;
     					   }
      					    alert(id)
                         var msg = "您确定要支付已选订单吗？\n\n请确认！"; 
				 if (confirm(msg)==true){ 
                        $.ajax({
                        type:"post",
                        url:"pay_order",
                        data:"id="+id,
                        success: function(msg){
                        alert("支付成功")
                        location.reload(true)
                        }
                        })
                        }else{ 
				  return false; 
				 } 
                    }    
                        
                          $('.pagination').pagination(${requestScope.osize},{
                         items_per_page : 5,
						callback: function(page){
						goPage(page+1)
						alert(page+1);	
						},
						display_msg: true
						});
						
                          
						
						
                        </script>
                        
                        
                        <div id="d_detail_03">
					
							
                        </div>				
                        	
                        <div class="pagination2"></div> 
                        	 	 
                        
                        <div id="d_detail_04">
                        <div id="light" class="white_content">
      					 <center><h3 >评价本次消费</h3></center>
        <a href="javascript:void(0)" style="margin-left:90%;font-size:20px;" onclick="document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none'">关闭</a>
        <center>
            <textarea id="ccontent" class="content1" cols="68" rows="5"></textarea>
        </center>
    <div class="delete_block1" style="margin-top:30px;"> <input onclick="return check();" type="button" value="提交"> </div>
       
    </div>

<c:forEach items="${requestScope.olistpay }"  var="odl" begin="0" end="4" varStatus="status"> 
		
		<div class="order_table">
        <ul class="order">
            <li class="order_check">         
                  <div class="order_checkbox " id="${odl.orderId }">
                        <input type="checkbox" checked="checked">
                </div>
            </li>
            <li class="order_img"><div class="img_sum"><div class="img_block"><img src="${odl.orderPhoto }" /></div><div class="summary">摘要</div></div></li>
            <li class="order_place"><div class="place"><p>${odl.orderPlace }</p></div></li>
            <li class="order_time"><div class="time"><p>${odl.orderStartTime }</p><p>${odl.orderEndTime }</p></div></li>
            <li class="order_number"><div class="number"><p>${odl.orderNumber }</p></div></li>
            <li class="order_price"> <div class="price"><p>${odl.orderPrice }</p></div></li>
            <li class="delete_order"><div class="delete"><a onclick="deleteo('${odl.orderId }')">删除订单</a></div></li>
           <c:choose>
            <c:when test="${odl.orderComment=='未评论'}">
  					
            <li class="pay_order"><div class="pay"><a onclick="comment('${odl.orderId }')">评价订单</a></div></li>
       </c:when>
       <c:otherwise>
                   <li class="pay_order"><div class="pay"><a >已评价</a></div></li>
       
       </c:otherwise>
       </c:choose>
        </ul>
        	                  
    </div>
    				</c:forEach>
    				
                        </div>
                        <div class="all_order_checkbox1 " >
                        <input type="checkbox" checked="checked" onclick="cho(this)">全选
                		</div>
                         <div class="pagination1"></div>
                       <div class="delete_block1"> <input onclick="deletechoose()" type="button" value="删除"> </div>
       
                    </div>


                </div>

            </div>
        </div>
    </div>
     
    <div id="fade" class="black_overlay"></div>
    
    <script type="text/javascript">
                         $(".pagination2").pagination(${requestScope.msize},{
                         items_per_page : ${requestScope.psize},
						callback: function(page){
						getMessage(page+1)
						alert(page+1)
						},
						display_msg: false
						});
                        </script>
    
<script type="text/javascript">

     
        function deleteShow(t) {
            var msg = "您确定要删除该条动态吗？\n\n请确认！";
            if (confirm(msg) == true) {
                $.ajax({
                    type: "post",
                    url: "deleteMyShow",
                    data: "id=" + t,
                    success: function (msg) {
                        if (msg == "success") {
                            alert("删除成功")
                            location.reload(true)
                        } else {
                            alert("删除失败")
                        }
                        
                    }
                })
            } else {
                return false;
            }
        }
        
        function deleteComment(t) {
            var msg = "您确定要删除该评论吗？\n\n请确认！";
            if (confirm(msg) == true) {
                $.ajax({
                    type: "post",
                    url: "deleteMyComment",
                    data: "id=" + t,
                    success: function (msg) {
                        if (msg == "success") {
                            alert("删除成功")
                            location.reload(true)
                        } else {
                            alert("删除失败")
                        }
                        
                    }
                })
            } else {
                return false;
            }
        }


var tt="";
function comment(t){
tt=t;
	document.getElementById('light').style.display='block';
	document.getElementById('fade').style.display='block'
	
}
function check(){
var content=document.getElementById("ccontent").value
if(content==""){
alert("请输入内容！")
return false;
}else{

 return subcomment(tt,content);
}


return true;
}
 function subcomment(t,content){
 var f = false;
$.ajax({
	type:'post',
	url:'commentOrder',
	data:"oid="+t+"&content="+content,
	success:function(msg){
	if(msg=="success"){
	alert("评论成功！")
	f=true
	document.getElementById('light').style.display='none';
	document.getElementById('fade').style.display='none'
	 location.reload(true)
	}
	else {
	alert("评论失败！")
	f=false
	}
	}
	
	})
	return f;
}
 $('.pagination1').pagination(${requestScope.opsize},{
                         items_per_page : 5,
						callback: function(page){
						gopayPage(page+1)
						alert(page+1);	
						},
						display_msg: false
						});
	function getMessage(p){
	$.ajax({
	type:'post',
	url:'getMessage',
	data:"page="+p,
	success:function(msgdata){
	 document.getElementById("d_detail_03").innerHTML = msgdata;
	}
	})	}				
</script>
    </div>
    <div class="footer">
  
    </div>
</body>
</html>