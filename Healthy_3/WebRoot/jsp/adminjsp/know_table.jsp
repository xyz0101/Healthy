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
                   
                    <div class="kv-item ue-clear">
                        <label>选择类型:</label>
                        <div class="kv-item-content">
                            <select onchange="chan(this.value)">
                                <option >全部</option>
                                <option >器材百科</option>
                                <option >健身计划推荐</option>
                                 <option >人体肌肉百科</option>
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
	var head = [
			{
				label:'分类',
				width:200	
			},
			{
				label:'标题',
				width: 150,
				sortable: 'default',
				name:'name'	
			},{
				label:'网址',
				width:200	
			},
            

            {
                label:'图片',
                width:150	
            }
		];
	//////////////遍历EL
	var b=new Array()
		var dis=new Array()
			var Eq=new Array()
				var Pl=new Array()
				var Mu =new Array()
	var a;
	
	var aEq;
	var aPl;
	var aMu;
	var ind=0;
	var indeq=0;
	var indpl=0;
	var indmu=0;
	
	<c:forEach items="${requestScope.allknow}"  var="allknow"> 
	var i=0; 
	a=new Array()
	
	aEq=new Array()
	aPl=new Array()
	aMu=new Array()
	if("${allknow[1]}"=="健身计划推荐"){
	i=0;
	<c:forEach items="${allknow}"  var="allarr"> 
	///*******************/
		if(i!=0)
	aPl[i-1]="${allarr}";
	i++;
	</c:forEach>
	var att = aPl[0]+","+"${allknow[0]}";
	var oper = [{label:'删除',id:att,onclick:function(){
					 var msg = "您真的确定要删除吗？\n\n请确认！"; 
				 if (confirm(msg)==true){ 
				 $.ajax({
				 /*******************/
					url:"deleteKnow",
					type:"post",
					data:"id="+this.id,
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
				
				}},{label:'编辑',id:att,onclick: function(){
					alert(this.id)
					$.ajax({
					url:"send_id",
					type:"post",
					data:"id="+this.id,
					success: function(msg){
					if(msg=="success"){
					location.href="toedit_Know";
					
					}else{
					alert('无法编辑')
					}
					}
				})	
					
				}
				}]
	aPl[i]=oper;
	Pl[indpl]=aPl;
	indpl++;
	}
	
	if("${allknow[1]}"=="器材百科"){
	i=0
	<c:forEach items="${allknow}"  var="allarr">
	///**************************/
		if(i!=0)
	aEq[i-1]="${allarr}";
	i++;
	</c:forEach>
	var att = aEq[0]+","+"${allknow[0]}";
	var oper = [{label:'删除',id:att,onclick:function(){
		 var msg = "您真的确定要删除吗？\n\n请确认！"; 
				 if (confirm(msg)==true){ 
				 $.ajax({
				 /***************************/
					url:"deleteKnow",
					type:"post",
					data:"id="+this.id,
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
				}},{label:'编辑',id:att,onclick: function(){
					alert(this.id)
					$.ajax({
					url:"send_id",
					type:"post",
					data:"id="+this.id,
					success: function(msg){
					if(msg=="success"){
					location.href="toedit_Know";
					
					}else{
					alert('无法编辑')
					}
					}
				})	
					
				}
				}]
	aEq[i]=oper;
	Eq[indeq]=aEq;
	indeq++;
	}
	
		if("${allknow[1]}"=="人体肌肉百科"){
	i=0
	<c:forEach items="${allknow}"  var="allarr">
	///***************************/
		if(i!=0)
	aMu[i-1]="${allarr}";
	i++;
	</c:forEach>
	var att = aMu[0]+","+"${allknow[0]}";
	var oper = [{label:'删除',id:att,onclick:function(){
		 var msg = "您真的确定要删除吗？\n\n请确认！"; 
				 if (confirm(msg)==true){ 
				 $.ajax({
				 /**********************/
					url:"deleteKnow",
					type:"post",
					data:"id="+this.id,
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
				}},{label:'编辑',id:att,onclick: function(){
					alert(this.id)
					$.ajax({
					url:"send_id",
					type:"post",
					data:"id="+this.id,
					success: function(msg){
					if(msg=="success"){
					location.href="toedit_Know";
					
					}else{
					alert('无法编辑')
					}
					}
				})	
					
				}
				}]
	aMu[i]=oper;
	Mu[indmu]=aMu;
	indmu++;
	}
	
	
	i=0
	<c:forEach items="${allknow}"  var="allarr">  
	/*************************/
		if(i!=0)
	a[i-1]="${allarr}";
	i++;
	</c:forEach>
	var att = a[0]+","+"${allknow[0]}";
	var oper = [{label:'删除',id:att,onclick:function(){
			 var msg = "您真的确定要删除吗？\n\n请确认！"; 
			 //alert(this.id)
				 if (confirm(msg)==true){ 
				   $.ajax({
					url:"deleteKnow",
					type:"post",
					data:"id="+this.id,
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
				
				}},{label:'编辑',id:att,onclick: function(){
					alert(this.id)
					$.ajax({
					url:"send_id",
					type:"post",
					data:"id="+this.id,
					success: function(msg){
					if(msg=="success"){
					location.href="toedit_Know";	
					}else{
				alert('无法编辑')
					}
					}
				})		
				}
				}]
	a[i]=oper;
	b[ind]=a;
	ind++;
	
	
	
	</c:forEach>
	////////////////
	dis=b;
	function chan(t){
	if(t=="健身计划推荐"){
	dis=Pl;
	var tbody =dis;
	/// 模拟异步
	setTimeout(function(){
		$('.grid').Grid('setData',tbody, head);
	},10)
	}
	else if(t=="器材百科"){
	dis=Eq;
	var tbody =dis;
	/// 模拟异步
	setTimeout(function(){
		$('.grid').Grid('setData',tbody, head);
	},10)
	}
	else if(t=="人体肌肉百科"){
	dis=Mu;
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
			location.href="toknow_table?index="+page1

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
