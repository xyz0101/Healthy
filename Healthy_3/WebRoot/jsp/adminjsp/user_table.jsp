<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/WdatePicker.css" />
<link rel="stylesheet" type="text/css" href="css/skin_/table.css" />
<link rel="stylesheet" type="text/css" href="css/jquery.grid.css" />


<title>表格</title>
</head>

<body>

<div id="container">
	<div id="hd"></div>
    <div id="bd">
    	<div id="main">
        	<div class="search-box ue-clear">
            	<div class="search-area">
                    <!--
                    <div class="kv-item ue-clear">
                        <label>选择时间：</label>
                        <div class="kv-item-content ue-clear">
                            <span class="choose">
                                <span class="checkboxouter">
                                    <input type="radio" name="time" />
                                    <span class="radio"></span>
                                </span>
                                <span class="text">全部</span>
                            </span>
                            <span class="choose">
                                <span class="checkboxouter">
                                    <input type="radio" name="time" />
                                    <span class="radio"></span>
                                </span>
                                <span class="text">近3天</span>
                            </span>
                            <span class="choose">
                                <span class="checkboxouter">
                                    <input type="radio" name="time" />
                                    <span class="radio"></span>
                                </span>
                                <span class="text">近一周</span>
                            </span>
                            <span class="choose">
                                <span class="checkboxouter">
                                    <input type="radio" name="time" />
                                    <span class="radio"></span>
                                </span>
                                <span class="text">近一月</span>
                            </span>
                            <span class="choose">
                                <span class="checkboxouter">
                                    <input type="radio" name="time" data-define="define" />
                                    <span class="radio"></span>
                                </span>
                                <span class="text">自定义</span>
                            </span>
                            <span class="define-input">
                            	<input type="text" placeholder="开始时间" />
                                <span class="division"></span>
                                <input type="text" placeholder="结束时间" />
                            </span>
                        </div>
                    </div>-->
                    <div class="kv-item ue-clear">
                        <label>选择类型:</label>
                        <div class="kv-item-content">
                            <select onchange="chan(this.value)">
                                <option >全部</option>
                                <option >仅商家</option>
                                <option >仅用户</option>
                            </select>
                        </div>
                    </div>
                </div>
                
                <!--
                <div class="search-button">
                	<input class="button" type="button" value="搜索一下" />
                </div>
                     -->
             </div>
             
            <div class="table">
                <!--
            	<div class="opt ue-clear">
                	<span class="sortarea">
                    	<span class="sort">
                        	<label>排序：</label>
                            <span class="name">
                            	<i class="icon"></i>
                                <span class="text">名称</span>
                            </span>
                        </span>
                        
                        <i class="list"></i>
                        <i class="card"></i>
                    </span>
                	<span class="optarea">
                        <a href="javascript:;" class="add">
                            <i class="icon"></i>
                            <span class="text">添加</span>
                        </a>
                        <a href="javascript:;" class="delete">
                            <i class="icon"></i>
                            <span class="text">删除</span>
                        </a>
                        
                        <a href="javascript:;" class="statistics">
                            <i class="icon"></i>
                            <span class="text">统计</span>
                        </a>
                        
                        <a href="javascript:;" class="config">
                            <i class="icon"></i>
                            <span class="text">配置</span>
                        </a>
                    </span>
                </div>
                   
              -->
                <div class="grid"></div>  
                <div class="pagination"></div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/global.js"></script>
<script type="text/javascript" src="js/jquery.select.js"></script>
<script type="text/javascript" src="js/core.js"></script>
<script type="text/javascript" src="js/jquery.pagination.js"></script>
<script type="text/javascript" src="js/jquery.grid.js"></script>
<script type="text/javascript" src="js/WdatePicker.js"></script>
<script type="text/javascript">
	$('select').select();
	var head = [{
				label: 'ID',
				width: 180,
				sortable: 'default',
				name: 'id'	
			},{
				label:'手机号',
				width: 150,
				sortable: 'default',
				name:'name'	
			},{
				label:'昵称',
				width:100	
			},
            /*{
                label:'姓名',
                width:80	
            },*/

            {
                label:'性别',
                width:50	
            },
            {
                label:'qq',
                width:100	
            },
            {
                label:'血型',
                width:50	
            },
            {
                label:'签名',
                width:200	
            },
            {
				label: '籍贯',
				width: 100	
			},
			/*{
				label: '注册时间',
				minWidth: 120	
			},
			*/
			{
				label: '出生日期',
				width: 100	
			},{
				label: '是否商家',
				width:50	
			}];
	//////////////遍历EL
	var b=new Array()
		var dis=new Array()
			var Sj=new Array()
				var Yh=new Array()
	var a;
	
	var aSj;
	var aYh;
	var ind=0;
	var indsj=0;
	var indyh=0;
	
	<c:forEach items="${requestScope.alluser}"  var="alluser"> 
	var i=0; 
	a=new Array()
	
	aYh=new Array()
	aSj=new Array()
	if("${alluser[9]}"=="商家"){
	i=0;
	<c:forEach items="${alluser}"  var="allarr"> 
	if(i==8)  {
	<c:set var="time" value="${allarr}"/>
	aSj[i]="${fn:replace(time, '0:00:00', ' ')}";
	}else 
	aSj[i]="${allarr}";
	i++;
	</c:forEach>
	var oper = [{label:'删除',id:aSj[0],onclick:function(){
					 var msg = "您真的确定要删除吗？\n\n请确认！"; 
				 if (confirm(msg)==true){ 
				 $.ajax({
					url:"deleteUser",
					type:"post",
					data:"userid="+this.id,
					success: function(msg){
					if(msg=="success"){
					alert("-----"+"删除成功");
					location.reload(true);
					}else{
					alert("-----"+"删除失败");
					}
					}
				})
				 }else{ 
				  return false; 
				 } 
				
				}},{label:'编辑',id:aSj[0],onclick: function(){
					//alert('编辑')
					$.ajax({
					url:"send_id",
					type:"post",
					data:"id="+this.id,
					success: function(msg){
					if(msg=="success"){
					location.href="to_edit";
					
					}else{
					alert('无法编辑')
					}
					}
				})	
					
				}
				}]
	aSj[10]=oper;
	Sj[indsj]=aSj;
	indsj++;
	}
	
	if("${alluser[9]}"=="普通用户"){
	i=0
	<c:forEach items="${alluser}"  var="allarr">
	if(i==8)  {
	<c:set var="time" value="${allarr}"/>
	aYh[i]="${fn:replace(time, '0:00:00', ' ')}";
	}else
	aYh[i]="${allarr}";
	i++;
	</c:forEach>
	var oper = [{label:'删除',id:aYh[0],onclick:function(){
		 var msg = "您真的确定要删除吗？\n\n请确认！"; 
				 if (confirm(msg)==true){ 
				 $.ajax({
					url:"deleteUser",
					type:"post",
					data:"userid="+this.id,
					success: function(msg){
					if(msg=="success"){
					alert("-----"+"删除成功");
					location.reload(true);
					}else{
					alert("-----"+"删除失败");
					}
					}
				})
				 }else{ 
				  return false; 
				 } 
				
					//	alert(this.id);
				}},{label:'编辑',id:aYh[0],onclick: function(){
					//alert('编辑')
					$.ajax({
					url:"send_id",
					type:"post",
					data:"id="+this.id,
					success: function(msg){
					if(msg=="success"){
					location.href="to_edit";
					
					}else{
					alert('无法编辑')
					}
					}
				})	
					
				}
				}]
	aYh[10]=oper;
	Yh[indyh]=aYh;
	indyh++;
	}
	i=0
	<c:forEach items="${alluser}"  var="allarr">  
	
	if(i==8)  {
	<c:set var="time" value="${allarr}"/>
	a[i]="${fn:replace(time, '0:00:00', ' ')}";
	}else 
	a[i]="${allarr}";
	i++;
	</c:forEach>
	var oper = [{label:'删除',id:a[0],onclick:function(){
			 var msg = "您真的确定要删除吗？\n\n请确认！"; 
				 if (confirm(msg)==true){ 
				   $.ajax({
					url:"deleteUser",
					type:"post",
					data:"userid="+this.id,
					success: function(msg){
					if(msg=="success"){
					alert("-----"+"删除成功");
					location.reload(true);
					}else{
					alert("-----"+"删除失败");
					}
					}
				})
				 }else{ 
				  return false; 
				 } 
				
				}},{label:'编辑',id:a[0],onclick: function(){
					//alert('编辑')
					$.ajax({
					url:"send_id",
					type:"post",
					data:"id="+this.id,
					success: function(msg){
					if(msg=="success"){
					location.href="to_edit";	
					}else{
				alert('无法编辑')
					}
					}
				})		
				}
				}]
	a[10]=oper;
	b[ind]=a;
	ind++;
	</c:forEach>
	////////////////
	dis=b;
	function chan(t){
	if(t=="仅商家"){
	dis=Sj;
	var tbody =dis;
	/// 模拟异步
	setTimeout(function(){
		$('.grid').Grid('setData',tbody, head);
	},10)
	}
	else if(t=="仅用户"){
	dis=Yh;
	var tbody =dis;
	/// 模拟异步
	setTimeout(function(){
		$('.grid').Grid('setData',tbody, head);
	},10)
	}
	
	else{
	dis=b;
	var tbody =dis;
	/// 模拟异步
	setTimeout(function(){
		$('.grid').Grid('setData',tbody, head);
	},10)
	}
	}
	
	var tbody =dis;
	/// 模拟异步
	setTimeout(function(){
		$('.grid').Grid('setData',tbody, head);
	},10)
		$('.grid').Grid({
			thead: head,
			tbody: null,
			height:400,
			checkbox: {
				single:true	
			},
			operator: {
				type : "normal",
				width : 100	
			},
			sortCallBack : function(name,index,type){
				alert(name+","+index+','+type);
			}
			
		});
	
	$('.grid').Grid('addLoading');
	
	
	
	var cp=0;
	  if("${param.index}"=="")
	  cp=1;
	  else cp="${param.index}";
	$('.pagination').pagination(${requestScope.allsize},{
			 items_per_page : ${requestScope.pagesize},
              current_page :parseInt(cp)-1,
	
		callback: function(page){
		page1=page+1
			location.href="touser_table?index="+page1

		},
		display_msg: false
	});
	
	$('.search-box input[type=radio]').click(function(e) {
        if($(this).prop('checked')){
			if($(this).attr('data-define') === 'define'){
				$('.define-input').show();
			}else{
				$('.define-input').hide();
			}
		}
    });
</script>
</body>

</html>
