<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
     
                            <span class="choose">
                                <span class="checkboxouter">
                                    <input type="radio" name="time" data-define="define" />
                                    <span class="radio"></span>
                                </span>
                                
                                <span class="text">关键词搜索</span>
                            </span>
                            <span class="define-input">
                            	<input type="text" onchange="getPlace(this.value)" onkeyup="getPlace(this.value)" placeholder="场地名" />
                              
                                <span class="division"></span>
                               
                            </span>
                        </div>
                    </div>
                
             </div>
             
            <div class="table">
           
                <div class="grid"></div>  
                <div class="pagination"></div>
            </div>
        </div>
    </div>
</div>
</body>
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
	   
	    label: '场地ID',
				width: 180,
				sortable: 'default',
				name: 'id'	
			},{
			    label:'场地名称',
				width: 150,
				sortable: 'default',
				name:'name'	
			},{
			    label:'场地价格(每小时)',
				width: 150,
			},
			{
			    label:'场地所属场馆',
				width: 150,
			},{
			    label:'场地图片',
				width: 150,
			},{
			    label:'场地地址',
				width: 150,
			}
            ];
//////////////遍历EL
	var b=new Array()
		var dis=new Array()
			
	var a;
	
	
	var ind=0;
	
	<c:forEach items="${requestScope.allplace}"  var="allplace"> 
	var i=0; 
	a=new Array()		
	i=0
	<c:forEach items="${allplace}"  var="allitem">   
	a[i]='${allitem}';
	i++;
	</c:forEach>
	var oper = [{label:'删除',id:a[0],onclick:function(){
	//alert(this.id)
			 var msg = "您真的确定要删除吗？\n\n请确认！"; 
				 if (confirm(msg)==true){ 
				   $.ajax({
					url:"seller_deletePlace",
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
				
				}
				}	,{label:'编辑',id:a[0],onclick: function(){
					alert(this.id)
					$.ajax({
					url:"seller_send_id",
					type:"post",
					data:"id="+this.id,
					success: function(msg){
					if(msg=="success"){
					location.href="toeditPlace";
					
					}else{
					alert('无法编辑')
					}
					}
				})	
				}
				}
				]
				
	a[i]=oper;
	b[ind]=a;
	ind++;
	//alert(b)
	</c:forEach>
	
	////////////////
	
	
	 function getPlace(t){
	 var res = new Array();
            $.ajax({
            type:"post",
            url:"seller_getplace_table",
            data:"diff="+t,
            success: function(msgdata){
   			var r = msgdata.split("*")
   			for(var i=0;i<r.length;i++){
   			var fres = new Array();
   			fres = r[i].split(",")
   				var oper = [{label:'删除',id:fres[0],onclick:function(){
			 var msg = "您真的确定要删除吗？\n\n请确认！"; 
				 if (confirm(msg)==true){ 
				   $.ajax({
					url:"seller_deletePlace",
					type:"post",
					data:"id="+this.id,
					success: function(msg){
					if(msg=="success"){
					alert("-----"+"删除成功");
					location.reload(true);
					}else{
					alert("-----"+"删除失败");
					}}
					})
				 }else{ 
				  return false; 
				 }}} ,{label:'编辑',id:fres[0],onclick: function(){
					alert(this.id)
					$.ajax({
					url:"seller_send_id",
					type:"post",
					data:"id="+this.id,
					success: function(msg){
					if(msg=="success"){
					location.href="toeditPlace";
					
					}else{
					alert('无法编辑')
					}
					}
				})	
				}
				}
				 ]
				 fres[6]=oper;
				 res[i]=fres
				 }
				//  alert(res)
		 var tbody =res;
	/// 模拟异步
	setTimeout(function(){
		$('.grid').Grid('setData',tbody, head);
		},10)
				 }});
            }
	
	//////筛选////	
	dis=b;
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
			location.href="seller_toplace_table?index="+page1

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
    $(function(){
    
    for(var x=0;x<dis.length;x++){
					var h=document.getElementsByClassName("__data")[0]
					//var hh=h.getElementsByTagName("tr")
					//alert(hh.getElementsByTagName("td"))
					//h.innerHTML="<img src='"+dis[x][4]+"' width='50px' height='50px' />";		
					var hh=h.rows
					alert(hh[2].cells[4])
					
					}
    })
    
</script>
</html>
