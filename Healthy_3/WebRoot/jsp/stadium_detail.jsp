<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    
    <title>场馆详情</title>
    
	<link href="css1/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="css1/style.css" rel='stylesheet' type='text/css' />
<link href="css1/comment.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<script src="js1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="css1/datedropper.css">
<link rel="stylesheet" type="text/css" href="css1/timedropper.min.css">
<style type="text/css">
.demo{margin:80px auto 40px auto;width:320px}
.input{padding:6px;border:1px solid #d3d3d3}
</style>
<link rel="stylesheet" type="text/css" href="css1/xcConfirm.css"/>

		
		<script src="js1/xcConfirm.js" type="text/javascript" charset="utf-8"></script>
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
       var sel=1;
       //setInterval("go()", 100)
      //  setInterval("choose(t)", 100)
      
      // 
       function choose(t){
       
      // alert(spl)
     // alert(t)
       		var i=t.getElementsByTagName("a")[0].getAttribute("id");
       		var price=parseInt(t.getElementsByTagName("a")[0].getAttribute("name"));
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
       
        function go(){
       $("#pricenow").html(	pr*parseInt($("#selval").val()));
      // alert(sel)
       }
       function time(t){
       //alert(parseInt(t))
       if(parseInt(t)>8||parseInt(t)<0||t==null ||!(/^(\+|-)?\d+$/.test( parseInt(t) ))){
       $("#time").css("display","");
       return false;
       }else{
       $("#time").css("display","none");
        return true;
       }
      
       }
       
      
       function submit(){
       //var place[];
       //stadiumplace=t.getAttribute("name");
       var date=$("#pickdate").val();
	   var time=$("#picktime").val();
	     		
					var interval=parseInt($("#interval").val());
					var number=$("#selval").val();
					var spl= new Array();
					var userid=$("#userinfo").attr("name");
					var price=$("#pricenow").html()
       			//var stadiumplace={"userName":"test","address":"gz"};			
       				for(i=0;i<$(".comfirm").length;i++){
       				var stp=$(".comfirm")[i].getAttribute("name");
       				spl.push(stp);
       				}
       				
       				//alert(price)
       				stadiumplace=JSON.stringify(spl)
					if(date==""||time==""||interval==""||number==""||spl.length==0)
					return false;
					$.ajax({
					type:"post",
					//contentType:"application/json",
					url:"toOrderSubmit",
					traditional:true,
					data:"stadiumplace="+stadiumplace+"&date="+date+"&time="+time+"&interval="+interval+"&number="+number+"&price="+price,
					//dataType: "json", 
					success:function(msg){
					if(msg=="success"){
						var option = {
						title: "预约提醒",
						btn: parseInt("0011",2),
						onOk: function(){
							// window.location.href ="toOrderDetail"
						},
						onCancel:function(){
						},
						onClose:function(){
						}
					}
					
					window.wxc.xcConfirm("预约成功！是否进入我的订单？", "custom", option);
					
					}
						else if(msg="error")	{
									var option = {
						title: "登录提醒",
						btn: parseInt("0011",2),
						onOk: function(){
							 window.location.href ="tologin";	
						},
						onCancel:function(){
						},
						onClose:function(){
						}
					}
					
					window.wxc.xcConfirm("您还没有登录，是否现在登录？", "custom", option);
						}		
					} ,
					error:function(){
			
					}
					});
					}
	 function toReply(id){
       for(var i=0;i<$(".reply_block").length;i++){
       if($(".reply_block")[i].id==id)
      $(".reply_block")[i].className="reply_block_display";
       }
       for(var i=0;i<$(".reply_btn").length;i++){
       if($(".reply_btn")[i].id==id)
      $(".reply_btn")[i].className="reply_btn_display";
       }
        }
        function upReply(id){
       // var content=""; var reg = /^\s*$/g;
         for(var i=0;i<$(".R_input").length;i++){
       if($(".R_input")[i].name==id)
     content= $(".R_input")[i].value+"";
       } 
     // alert(id)
       /*if(!reg.test(content)){
        alert("输入不能为空");
        return false;
       }*/
      
         $.ajax({
        url:"replyComment",
        type:"post",
        data:"content="+content+"&commentId="+id,
        success: function(msg){
        if(msg=="success"){
         alert("回复成功");
             //location.href="ToStadium_Detail1";
             location.reload(true)
        }
        else if(msg="error")	{
									var option = {
						title: "登录提醒",
						btn: parseInt("0011",2),
						onOk: function(){
							 window.location.href ="tologin";	
						},
						onCancel:function(){
						},
						onClose:function(){
						}
					}
					
					window.wxc.xcConfirm("您还没有登录，是否现在登录？", "custom", option);
						}	
        }
        	});
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
				<div class="col-md-9 single_left">
				   <div class="single_image">
					     <ul id="etalage">
							<c:forEach items="${requestScope.splist }" var="spl" begin="0" end="6" varStatus="status"> 
								<li>
								<a href="javascript;">
									<img class="etalage_thumb_image" src="${spl.placePhoto }" />
									<img class="etalage_source_image" src="${spl.placePhoto }" />
								</a>
							</li>
								</c:forEach>
							
						</ul>
					    </div>
				        <!-- end product_slider -->
				        <div class="single_right">
				        	<h3>场馆详细介绍 </h3>
				        	<p class="m_10">${requestScope.stadium.stadiumIntroduction }</p>
				        	<p>${requestScope.stadium.stadiumLocation }</p></br>
				        	
				        	<ul class="product-colors">
				        	
								<h3>选择场地</h3>
								<c:forEach items="${requestScope.splist }" var="spl" begin="0" end="6" varStatus="status"> 
								<li  onclick="choose(this)" ><div class="uncomfirm" name="${spl.placeId }" ></div><a class="color1" id="0" name="${spl.placePrice }">
								
								<img src="${spl.placePhoto }" width="32px" height="32px">
								</a>
								</li>
								</c:forEach>
								<div class="clear"> </div>
							</ul>
							<p>请选择训练日期：<input type="text" class="input" id="pickdate"  /></p><br/>
								<p>请选择开始时间：<input type="text" class="input" id="picktime" /></p><br/>
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
								<p>请输入训练时长：<input type="text" class="input" onchange="time(this.value)" onkeyup="time(this.value)" id="interval" />
								<span id="time" style="color:red; display:none;">请输入1-8之间的整数</span></p><br/>
								
							<ul class="options">
								<span>选择人数:</span><br>
								<select id="selval" style="width:100px">
									<option>1</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
									<option>5</option>
									<option>6</option>
								</select>
							</ul>
								
								
							<div class="btn_form">
						
								 <input type="button" value="加入订单"onclick="submit()" >
						
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
					            </button>
					        </div>
				   </div>
			   </div>
			   <div class="col-md-3" width="300px">
				  <div class="box-info-price"id="haha">
				
				  	<p class="price">单价:</p>
				 	<p class="price2" id="pricerange" >0-0</p>
					<p class="price">已选价格:</p>
				 	<p class="price2" id="pricenow">0</p>
				  </div>
				  </div>
			</div>		
			<div class="desc">
			   	<h4>场馆评论<span style="font-size:18px;">(${requestScope.commentlist.size() }条)</span></h4>
			   	 
        
        <c:forEach begin="0" end="6" items="${requestScope.commentlist }" var="comm" varStatus="status">
           <div class="comment">
           <c:set var="commpic" value="${comm.commentUser }_pic"/>
           <img src="${requestScope[commpic] }" width="40px" height="40px" />
        <div class="comment_content">
            <div class="content">
                <a style="color:orange">${comm.commentUser }:&nbsp;&nbsp;</a>${comm.commentContent }
            </div>
            <div class="time">
              <c:set var="time" value="${comm.commentTime }"/>
              <c:choose>
                        	<c:when test="${sessionScope.user1.userNickname eq comm.commentUser }">
                        	<div class="comment_time"> ${fn:substring(time, 0, 19)} <a onclick="deleteComment('${comm.commentId}')" style="margin-left:48%;font-size:16px;">删除</a></div>
                        	</c:when>
                        	<c:otherwise>
                         <div class="comment_time" > ${fn:substring(time, 0, 19)}</div>
                        	</c:otherwise>
                        	</c:choose>
                <div class="reply"> <a onclick="toReply('${comm.commentId}')">回复</a></div>
            </div>
            <div class="reply_block" id="${comm.commentId}">
            <textarea class="R_input" name="${comm.commentId}"></textarea>
           </div>
           <div class="reply_btn" id="${comm.commentId}"> 
           <input type="button" onclick="upReply('${comm.commentId}')" value="回复">
           </div>
            <div class="reply_content">
                <ul id="${comm.commentId }reply">

						<c:set var="temp" value="${comm.commentId }"/>
                <c:forEach begin="0" end="2" items="${requestScope[temp]}" var="reply" varStatus="status">
                    <li>
                        <div class="c_reply">
                            <a style="color:orange">${reply.replyUser }:&nbsp;&nbsp;</a>${reply.replyContent }
                        </div>
                         <c:set var="replytime" value="${reply.replyTime }"/>
                        <div class="time">
                        	<c:choose>
                        	<c:when test="${sessionScope.user1.userNickname eq reply.replyUser }">
                            <div class="comment_time" > ${fn:substring(replytime, 0, 19)}<a onclick="deleteReply('${reply.replyId}')" style="font-size:16px;margin-left:70%;">删除</a></div>
                        	</c:when>
                        	<c:otherwise>
                         <div class="comment_time" > ${fn:substring(replytime, 0, 19)}</div>
                        	
                        	</c:otherwise>
                        	</c:choose>
                        </div>
                    </li>
                    </c:forEach>
      
                </ul>
									<div  class="more"> <a onclick="getNext('${comm.commentId }')" >查看更多</a></div>
				
            </div>
            
        </div>
    </div></c:forEach>
			</div>
			
			<script>
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
        function deleteReply(t) {
            var msg = "您确定要删除该回复吗？\n\n请确认！";
            if (confirm(msg) == true) {
                $.ajax({
                    type: "post",
                    url: "deleteMyReply",
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

    </script>
			
			
			<script type="text/javascript">
			
			var i=1;
				var id1="";
			function getNext(t){
			var id=t;
		
			if(id1!=id){
			i=1;
			//alert(1212)
			}
			
			id1=id;
			
			i++;
			alert(i)
			$.ajax({
			type:"post",
			url:"getCommentReply",
			data:"commentId="+t+"&pageNext="+i,
			success:function(msgdata){
				//alert(msgdata)
				//alert(document.getElementById(t+"reply").innerHTML)
				if(msgdata=="")
				alert("没有更多了！")
				 document.getElementById(t+"reply").innerHTML=document.getElementById(t+"reply").innerHTML+msgdata;
				//$("#next_reply").append(msgdata)
			}
			
			})
			}
			
			</script>
			
			<div class="row">
				<h4 class="m_11">相关热门场馆推荐</h4>
				<c:forEach items="${requestScope.relative }" begin="0" end="2" var="rela" varStatus="status">
				<div class="col-md-4 product1">
					<img src="${rela.stadiumPhoto }" class="img-responsive" alt=""/> 
					<div class="shop_desc"><a href="ToStadium_Detail1?id=${rela.stadiumId }">
						</a><h3><a href="single.html"></a><a href="ToStadium_Detail1?id=${rela.stadiumId }">${rela.stadiumName }</a></h3>
						<p>${rela.stadiumIntroduction }</p>
						
						<span class="actual">${rela.stadiumPrice }</span><br>
						<ul class="buttons">
							<li class="cart"><a href="ToStadium_Detail1?id=${rela.stadiumId }">前往场馆</a></li>
						
							<div class="clear"> </div>
					    </ul>
				    </div>
				</div>
				</c:forEach>
			</div>	
	     </div>
	   </div>
	  </div>
	  <div class="footer">
		
		</div>
</body>	
</html>