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
 
  <title>运动社区</title>
  <link rel="stylesheet" type="text/css" href="css/jquery.grid.css" />
      <link rel="stylesheet" type="text/css" href="css/style.css" />
  <link rel="stylesheet" type="text/css" href="css/skin_/table.css" />
  <link rel="stylesheet" type="text/css" href="css/WdatePicker.css" />
  <link rel="stylesheet" type="text/css" href="css1/xcConfirm.css"/>
    <link href="css1/comment.css" rel='stylesheet' type='text/css' />
  <link href="css1/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="css1/style.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<script src="js1/jquery.min.js"></script>
    <script src="jquery.js"></script>
    <link rel="stylesheet" type="text/css" href="diyUpload/css/webuploader.css">
    <link rel="stylesheet" type="text/css" href="diyUpload/css/diyUpload.css">
    <link rel="stylesheet" type="text/css" href="css1/quanzi.css">
    
    <script type="text/javascript" src="diyUpload/js/webuploader.html5only.min.js"></script>
    <script type="text/javascript" src="diyUpload/js/diyUpload.js"></script>
 </head>
<body >
               <script type="text/javascript" src="js/jquery.pagination.js"></script>

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
	 	<script src="js1/xcConfirm.js" type="text/javascript" charset="utf-8"></script>
	     <div class="main">
      <div class="shop_top">
		<div class="container" >
		  <script>
    
        function _close() {
            $("#box").css("display", "none");
          $("#_update").css("display", "none");
           $("#close").css("display", "none");
        }
        function db() {
           $("#box").css("display", "block");
           $("#up_pic").click();
        
           $("#close").css("display", "block");
        }
        function choose(file){
        $("#_update").css("display", "block");
          var MAXWIDTH  = 260; 
          var MAXHEIGHT = 180;
          var div = document.getElementById('test');
          if (file.files && file.files[0])
          {		
              div.innerHTML ='<img id=imghead>';
              var img = document.getElementById('imghead');
              img.onload = function(){
                var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
                img.width  =  rect.width;
                img.height =  rect.height;
//                 img.style.marginLeft = rect.left+'px';
                img.style.marginTop = rect.top+'px';
              }
              var reader = new FileReader();
              reader.onload = function(evt){img.src = evt.target.result;}
              reader.readAsDataURL(file.files[0]);
          }
          else //兼容IE
          {
            var sFilter='filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="';
            file.select();
            var src = document.selection.createRange().text;
            div.innerHTML = '<img id=imghead>';
            var img = document.getElementById('imghead');
            img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src;
            var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
            status =('rect:'+rect.top+','+rect.left+','+rect.width+','+rect.height);
            div.innerHTML = "<div id=divhead style='width:"+rect.width+"px;height:"+rect.height+"px;margin-top:"+rect.top+"px;"+sFilter+src+"\"'></div>";
          }
        }
        function clacImgZoomParam( maxWidth, maxHeight, width, height ){
            var param = {top:0, left:0, width:width, height:height};
            if( width>maxWidth || height>maxHeight )
            {
                rateWidth = width / maxWidth;
                rateHeight = height / maxHeight;
                
                if( rateWidth > rateHeight )
                {
                    param.width =  maxWidth;
                    param.height = Math.round(height / rateWidth);
                }else
                {
                    param.width = Math.round(width / rateHeight);
                    param.height = maxHeight;
                }
            }
            
            param.left = Math.round((maxWidth - param.width) / 2);
            param.top = Math.round((maxHeight - param.height) / 2);
            return param;
        
        
         
        }
        function sub(){
         $("#is_update").click();
        }
        function up_show(){
        var content=$("#text_input").val();
        $.ajax({
        url:"upSpace",
        type:"post",
        data:"content="+content,
        success: function(msg){
        if(msg=="success"){
             alert("发表成功");
             location.href="toAllSpace";
        }
   			else alert("发表失败");
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
     content= $(".R_input")[i].value;
       } 
      //alert(content)
       /*if(!reg.test(content)){
        alert("输入不能为空");
        return false;
       }*/
      
         $.ajax({
        url:"reply",
        type:"post",
        data:"content="+content+"&showId="+id,
        success: function(msg){
        if(msg=="success"){
         alert("回复成功");
             location.href="toAllSpace";
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
    <div class="write_show">
        <div class="input ">
            <textarea class="W_input" style="background: white" id="text_input"  ></textarea>
            </div>
        <div class="img_button">
            <div class="up_img" id="choose-img"  >
             <a onclick="db()">添加图片</a><br /> 
                <a id="close" onclick="_close()" >取消选择</a>
            </div>
            <div id="text_btn" class="text_submit">
                <input onclick="up_show()" type="button" value="发表" />
            </div>

        </div>
    </div>
    <form style="display: none"action="q_picUpload" method="post"  enctype="multipart/form-data">
           <input type="file" id="up_pic"  onchange="choose(this)" name ="file">
        <input type="submit" value="上传" id="is_update"/>
        </form >
    <div id="box">
        <div id="test">

        </div>
         <input type="button" value="上传" onclick="sub()" id="_update"/>
         </div>
   <div class="q_list">
   
		<c:forEach begin="0" end="6" items="${requestScope.allspace }" var="quan" varStatus="status">
           <div class="comment">
           <c:set var="quanpic" value="${quan.showUser }_pic"/>
           <img src="${requestScope[quanpic] }" width="40px" height="40px" />
        <div class="comment_content">
            <div class="content">
                <a style="color:orange">${quan.showUser }:&nbsp;&nbsp;</a>${quan.showContent }
            </div>
            <div class="time">
            	<c:set var="time" value="${quan.showTime }"/>
            	
            	  <c:choose>
                        	<c:when test="${sessionScope.user1.userNickname eq quan.showUser }">
                        	<div class="comment_time"> ${fn:substring(time, 0, 19)} <a onclick="deleteShow('${quan.showId}')" style="margin-left:58%;font-size:16px;">删除</a></div>
                        	</c:when>
                        	<c:otherwise>
                         <div class="comment_time" > ${fn:substring(time, 0, 19)}</div>
                        	</c:otherwise>
                        	</c:choose>
                <div class="reply"> <a onclick="toReply('${quan.showId}')">回复</a></div>
            </div>
           <div class="reply_block" id="${quan.showId}">
            <textarea class="R_input" name="${quan.showId}"></textarea>
           </div>
           <div class="reply_btn" id="${quan.showId}"> 
           <input type="button" onclick="upReply('${quan.showId}')" value="回复">
           </div>
            <div class="reply_content">
                <ul id="${quan.showId}reply">

						<c:set var="temp" value="${quan.showId }_reply"/>
                <c:forEach begin="0" end="3" items="${requestScope[temp]}" var="reply" varStatus="status">
                    <li>
                        <div class="c_reply">
                            <a style="color:orange">${reply.replyUser }:&nbsp;&nbsp;</a>${reply.replyContent }
                        </div>
                        <c:set var="replytime" value="${reply.replyTime }"/>
                        <div class="time">
                        <c:choose>
                        	<c:when test="${sessionScope.user1.userNickname eq reply.replyUser }">
                            <div class="comment_time" > ${fn:substring(replytime, 0, 19)}<a  onclick="deleteSReply('${reply.replyId}')"style="font-size:16px;margin-left:58%;">删除</a></div>
                        	</c:when>
                        	<c:otherwise>
                         <div class="comment_time" > ${fn:substring(replytime, 0, 19)}</div>
                        	
                        	</c:otherwise>
                        	</c:choose>
                        </div>
                    </li>
                    </c:forEach>
      						
                </ul>
					<div  class="more"> <a onclick="getNext('${quan.showId}')" >查看更多</a></div>
            </div>
            
        </div>
    </div></c:forEach>
		 </div>
		<div class="pagination" style="margin-left:25%"></div>
	     </div> 
	   </div>
	  </div>
	  <script type="text/javascript">
	   if("${param.index}"=="")
	  cp=1;
	  else cp="${param.index}";
	   
	       $('.pagination').pagination(${requestScope.allpage },{
                         items_per_page :${requestScope.pagesize },
						 current_page :parseInt(cp)-1,
						callback: function(page){
						var page1=page+1
						location.href="toAllSpace?index="+page1
						//alert(page+1);	
						},
						display_msg: false
						});
						
	  </script>
	      <script>
	     
	      
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
        function deleteSReply(t) {
            var msg = "您确定要删除该回复吗？\n\n请确认！";
            if (confirm(msg) == true) {
                $.ajax({
                    type: "post",
                    url: "deleteSReply",
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
			//alert(i)
			$.ajax({
			type:"post",
			url:"getReply",
			data:"showId="+t+"&pageNext="+i,
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
	  
	  <div class="footer">
			
		</div>
</body>	
</html>