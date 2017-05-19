
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
    <link rel="stylesheet" href="css1/detail.css" />
    <link rel="stylesheet" href="css1/edit.css" />
   <link rel="stylesheet" type="text/css" href="css1/xcConfirm.css"/>
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
<script type="text/javascript">
  function up_head(){
        $("#up_head").click()
        }
        function upme(){
         $("#imgfile").click()
        }

</script>
    <div class="main">
        <div class="shop_top">
            <div class="container">
                 <div class="d_body">
                    <div class="d_head"><p>修改资料</p></div>
                    <div class="d_left">
                        <div class="up_head">
                            <p id="icon_container">
                                <a href="javascript:;" onclick="up_head();return false;" class="bor2">
                                    <img id="user_icon" src="${requestScope.epic.userPic}" width="100px" height="100px">
                                </a>
                            </p>
                            <p id="edit_icon_info" class="">
                                <a href="javascript:;" onclick="up_head();return false;" class="c_tx">修改头像</a>
                            </p>
                        </div>
                    </div>
                    <form style="display:none" action="UpHead" method="post" enctype="multipart/form-data">
                    	<input id="up_head" type="file" name="file" onchange="upme()"/>
                    	<input  id="imgfile" type="submit" />
                    </form>
                    <div class="d_right">
                        <div class="base_detail">
                            <h4>基本资料</h4>
                        </div>
                        <div id="e_detail_01">
                            <table>
                                <tbody>
                                    <tr>
                                        <td class="base_title">昵称：</td>
                                        <td class="base_nickname">
                                        <input onchange="checkName(this.value);"onkeyup="checkName(this.value);" id="name_input" class="text_input" type="text" placeholder="${requestScope.euser.userNickname }" name="userNickname">
                                         <span id="tname" style="display:none;color:red;"></span>
                                        </td>
                                   
                                    </tr>

                                    <tr>
                                        <td class="base_title">性别：</td>
                                        <td class="sex_td">
                                            <div class="basicinfo_box" id="sex_box">
                                                <select id="sex_select" class="select_small">
                                                    <option value="1">男</option>
                                                    <option value="2">女</option>
                                                </select>
                                            </div>
                                        </td>
                                    </tr>
                                  
                                    <tr>
                                    
                                        <td class="base_title">生日：</td>
                                        <td class="birth_td">
                                            <div class="basicinfo_box" id="birth_box">
                                                <select id="birth_select_year" class="select_small">
                                                    <option value="1960">1960</option>
                                                    <option value="1961">1961</option>
                                                    <option value="1962">1962</option>
                                                    <option value="1963">1963</option>
                                                    <option value="1964">1964</option>
                                                    <option value="1965">1965</option>
                                                    <option value="1966">1966</option>
                                                    <option value="1967">1967</option>
                                                    <option value="1968">1968</option>
                                                    <option value="1969">1969</option>
                                                    <option value="1970">1970</option>
                                                    <option value="1971">1971</option>
                                                    <option value="1972">1972</option>
                                                    <option value="1973">1973</option>
                                                    <option value="1974">1974</option>
                                                    <option value="1975">1975</option>
                                                    <option value="1976">1976</option>
                                                    <option value="1977">1977</option>
                                                    <option value="1978">1978</option>
                                                    <option value="1979">1979</option>
                                                    <option value="1980">1980</option>
                                                    <option value="1981">1981</option>
                                                    <option value="1982">1982</option>
                                                    <option value="1983">1983</option>
                                                    <option value="1984">1984</option>
                                                    <option value="1985">1985</option>
                                                    <option value="1986">1986</option>
                                                    <option value="1987">1987</option>
                                                    <option value="1988">1988</option>
                                                    <option value="1989">1989</option>
                                                    <option value="1990">1990</option>
                                                    <option value="1991">1991</option>
                                                    <option value="1992">1992</option>
                                                    <option value="1993">1993</option>
                                                    <option value="1994">1994</option>
                                                    <option value="1995">1995</option>
                                                    <option value="1996">1996</option>
                                                    <option value="1997">1997</option>
                                                    <option value="1998">1998</option>
                                                    <option value="1999">1999</option>
                                                    <option value="2000">2000</option>
                                                    <option value="2001">2001</option>
                                                    <option value="2002">2002</option>
                                                    <option value="2003">2003</option>
                                                    <option value="2004">2004</option>
                                                    <option value="2005">2005</option>
                                                    <option value="2006">2006</option>
                                                    <option value="2007">2007</option>
                                                    <option value="2008">2008</option>
                                                    <option value="2009">2009</option>
                                                    <option value="2010">2010</option>
                                                    <option value="2011">2011</option>
                                                    <option value="2012">2012</option>
                                                    <option value="2013">2013</option>
                                                    <option value="2014">2014</option>
                                                    <option value="2015">2015</option>
                                                    <option value="2016">2016</option>
                                                    <option value="2017">2017</option>




                                                </select>
                                                年 <select id="birth_select_month" class="select_small">
                                                     <option value="1">1</option>
                                                     <option value="2">2</option>
                                                     <option value="3">3</option>
                                                     <option value="4">4</option>
                                                     <option value="5">5</option>
                                                     <option value="6">6</option>
                                                     <option value="7">7</option>
                                                     <option value="8">8</option>
                                                     <option value="9">9</option>
                                                     <option value="10">10</option>
                                                     <option value="11">11</option>
                                                     <option value="12">12</option>

                                                 </select> 月
                                                <select id="birth_select_day" class="select_small">
                                                    <option value="1">1</option>
                                                    <option value="2">2</option>
                                                    <option value="3">3</option>
                                                    <option value="4">4</option>
                                                    <option value="5">5</option>
                                                    <option value="6">6</option>
                                                    <option value="7">7</option>
                                                    <option value="8">8</option>
                                                    <option value="9">9</option>
                                                    <option value="10">10</option>
                                                    <option value="11">11</option>
                                                    <option value="12">12</option>
                                                    <option value="13">13</option>
                                                    <option value="14">14</option>
                                                    <option value="15">15</option>
                                                    <option value="16">16</option>
                                                    <option value="17">17</option>
                                                    <option value="18">18</option>
                                                    <option value="19">19</option>
                                                    <option value="20">20</option>
                                                    <option value="21">21</option>
                                                    <option value="22">22</option>
                                                    <option value="23">23</option>
                                                    <option value="24">24</option>
                                                    <option value="25">25</option>
                                                    <option value="26">26</option>
                                                    <option value="27">27</option>
                                                    <option value="28">28</option>
                                                    <option id="day_29" value="29">29</option>
                                                    <option id="day_30" value="30">30</option>
                                                    <option id="day_31" value="31">31</option>

                                                 </select>日
                                            </div>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td class="base_title">现居地：</td>
                                        <td class="location_td">
                                            <input id="provence_input" class="text_input" type="text" placeholder="${requestScope.pro}" name="provence">省
                                            <input id="city_input" class="text_input" type="text" placeholder="${requestScope.city}" name="city">市
                                        </td>
                                    </tr>

                                    <tr>
                                        <td class="base_title">感情状况：</td>
                                        <td class="emotion_td">
                                            <div class="basicinfo_box" id="emotion_box">
                                                <select id="emotion_select" class="select_small">

                                                    <option value="单身">单身</option>
                                                    <option value="恋爱中">恋爱中</option>
                                                    <option value="已订婚">已订婚</option>
                                                    <option value="已婚">已婚</option>
                                                    <option value="分居">分居</option>
                                                    <option value="离异">离异</option>
                                                    <option value="保密">保密</option>
                                                </select>
                                            </div>
                                        </td>

                                    </tr>

                                    <tr>
                                        <td class="base_title">血型：</td>
                                        <td class="blood_td">
                                            <div class="basicinfo_box" id="blood_box">
                                                <select id="blood_select" class="select_small">

                                                    <option value="A">A</option>
                                                    <option value="B">B</option>
                                                    <option value="AB">AB</option>
                                                    <option value="O">O</option>
                                                    <option value="其它">其它</option>
                                                  
                                                </select>
                                                </div>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td class="base_title">手机号：</td>
                                        <td class="phone_td">
                                            <input onchange="checkPhone(this.value)" onkeyup="checkPhone(this.value)"  id="phone_input" class="text_input" placeholder="${requestScope.eud.userTel}" type="text" name="phone">
                                           <span id="tphone" style="display:none;color:red;"></span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="base_title">QQ号：</td>
                                        <td class="qq_td">
                                            <input id="qq_input" class="text_input" placeholder="${requestScope.eud.userQq}" type="text" name="qq">

                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="base_title">我的签名：</td>
                                        <td class="signature_td">
                                            <textarea  id="signature_input" class="text_input" name="signature"  cols="40" rows="4">${requestScope.eud.userSignature}</textarea>
                                           	<input onclick="update()" type="button" id= "save" class="base_save"value="保存">
                                           

                                        </td>
                                    </tr>


                                </tbody>
                            </table>

                        </div>
                    </div>

   <script type="text/javascript">
   if("${requestScope.euser.userSex}"=="男")
document.getElementById("sex_select").value="1"
else if("${requestScope.euser.userSex}"=="女")
document.getElementById("sex_select").value="2"
   if("${requestScope.year}"!="")
document.getElementById("birth_select_year").value="${requestScope.year}"
 if("${requestScope.month}"!="")
document.getElementById("birth_select_month").value="${requestScope.month}"
 if("${requestScope.day}"!="")
 document.getElementById("birth_select_day").value="${requestScope.day}"
if("${requestScope.eud.userEmotion}"!="")
document.getElementById("emotion_select").value="${requestScope.eud.userEmotion}"
if("${requestScope.eud.userBlood}"!="")
document.getElementById("blood_select").value="${requestScope.eud.userBlood}"
</script>
<script type="text/javascript">
var a=true;
                        var b = true;
                         function checkPhone(t){
        var reg=/^1[34578]\d{9}$/; 
      if(t!=""&&!reg.test(t)){
		$("#tphone").css("color","red");
		$("#tphone").html("手机号格式不正确");
		$("#tphone").css("display","block");
		b= false;
		}else if(t==""){
		$("#tphone").css("color","gray");
		$("#tphone").html("不修改手机号");
		$("#tphone").css("display","block");
		b= true;
		}else{
		    $.ajax({
                    type: "post",
                    async:false,//将异步改为同步才能按顺序执行方法
                    url: "findphone",
                    data: "phone=" +t,
                    success: function(msg){
                    if(msg=="have"){   
                                   
                    	$("#tphone").css("color","red");
			             $("#tphone").css("display","block");
			                $("#tphone").html("该手机号已存在");
			                a= false;
                        }
                        else {
                         $("#tphone").css("color","gray");
							$("#tphone").html("手机号输入正确");
						$("#tphone").css("display","block");
							b= true;              
                      }                     
                   }
               });
		}
		}  
                        function checkName(t){
                      if(t!=""&&!/^[^ ]{1,16}$/.test(t)){     
            $("#tname").css("color","red");
             $("#tname").css("display","block");
                $("#tname").html("用户名格式不正确");
               a= false;
            }
          else  if(t==""){     
            $("#tname").css("color","gray");
             $("#tname").css("display","block");
                $("#tname").html("不更改用户名");
               a= true;
            }
            else{
              $("#tname").css("display","none");
            // 验证用户是否重复
                $.ajax({
                    type: "post",
                    async:false,//将异步改为同步才能按顺序执行方法
                    url: "findname",
                    data: "name=" +t,
                    success: function(msg){
                    if(msg=="have"){   
                                   
                    	$("#tname").css("color","red");
			             $("#tname").css("display","block");
			                $("#tname").html("该用户名已存在");
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
            }      var x=true;
            	function update(){
            	//alert(a)
            	if(a&&b){
            		x= true;	
            	}
            	else
            	x= false;
            	var name=$("#name_input").val();
            	var sex=$("#sex_select").val();
            	var year=$("#birth_select_year").val();
            	var month=$("#birth_select_month").val();
            	var day=$("#birth_select_day").val();
            	var provence=$("#provence_input").val();
            	var city=$("#city_input").val();
            	var emotion=$("#emotion_select").val();
            	var blood=$("#blood_select").val();
            	var signature=$("#signature_input").val();
            	var phone=$("#phone_input").val();
            	var qq=$("#qq_input").val();
            	var userid="${requestScope.euser.userId}";
            	$.ajax({
            	 type: "post",
                    url: "update",
                    data: "name="+name+"&sex="+sex+"&userid="+userid+"&year=" +year+"&month=" +month+"&day=" +day+"&provence=" +provence+"&city=" 
                    +city+"&emotion=" +emotion+"&blood=" +blood+"&signature="
                     +signature+"&phone=" +phone+"&qq=" +qq,
                    success: function(msg){
                    if(msg=="unfail"){
							 location.href="toMain"
                    }
                    }
            	});
            	return x;
            	}	
</script>
                </div>

            </div>
        </div>
    </div>

   
    <div class="footer">
 
    </div>
</body>
</html>