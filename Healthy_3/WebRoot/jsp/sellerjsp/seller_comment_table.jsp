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
                   
                    <div class="kv-item ue-clear">
                        <label>时间筛选：</label>
                        <div class="kv-item-content ue-clear">
                            <span class="choose">
                                <span class="checkboxouter">
                                    <input type="radio" onclick="getQuanzi('all','0')" name="time" />
                                    <span class="radio"></span>
                                </span>
                                <span class="text">全部</span>
                            </span>
                            <span class="choose">
                                <span class="checkboxouter">
                                    <input type="radio" onclick="getQuanzi('day','3')" name="time" />
                                    <span class="radio"></span>
                                </span>
                                <span class="text">近3天</span>
                            </span>
                            <span class="choose">
                                <span class="checkboxouter">
                                    <input type="radio" onclick="getQuanzi('week','1')" name="time" />
                                    <span class="radio"></span>
                                </span>
                                <span class="text">近一周</span>
                            </span>
                            <span class="choose">
                                <span class="checkboxouter">
                                    <input type="radio"onclick="getQuanzi('month','1')" name="time" />
                                    <span class="radio"></span>
                                </span>
                                <span class="text">近一月</span>
                            </span>
                            <span class="choose">
                                <span class="checkboxouter">
                                    <input type="radio" name="time" data-define="define" />
                                    <span class="radio"></span>
                                </span>
                                <span class="text">指定用户</span>
                            </span>
                            <span class="define-input">
                            	<input type="text" onchange="getQuanzi('appoint',this.value)" onkeyup="getQuanzi('appoint',this.value)" placeholder="用户名" />
                              
                                <span class="division"></span>
                               
                            </span>
                        </div>
                    </div>
                   <!--  <div class="kv-item ue-clear">
                        <label>选择类型:</label>
                        <div class="kv-item-content" >
                            <select onchange="chan(this.value)">
                              <option>全部</option>
                                <option>已支付</option>
                                <option>待支付</option>
                                
                            </select>
                        </div>
                    </div> -->
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
	   
	    label: '评论ID',
				width: 180,
				sortable: 'default',
				name: 'id'	
			},{
                label:'评论内容',
                width:380	
            }
			,{
			    label:'评论人昵称',
				width: 150,
				sortable: 'default',
				name:'name'	
			},{
   		 label:'评论人手机号',
				width:100	
			},
            
{
    label:'评论的场馆',
                width:100	
            },
            {
    label:'发表时间',
                width:150	
            },
            
            {
    label:'评论的回复数量',
                width:50	
            }
           
            ];
            
            
           
			
	
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
	<c:forEach items="${requestScope.cinit}"  var="cl"> 
	var i=0; 
	a=new Array()
	
	aYh=new Array()
	aSj=new Array()
	
	i=0
	<c:forEach items="${cl}"  var="allitem">   
	a[i]='${allitem}';
	i++;
	</c:forEach>
	var oper = [{label:'删除',id:a[0],onclick:function(){
	//alert(this.id)
			 var msg = "您真的确定要删除吗？\n\n请确认！"; 
				 if (confirm(msg)==true){ 
				   $.ajax({
					url:"seller_deleteComment",
					type:"post",
					data:"commentid="+this.id,
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
				}	
					
				]
	a[i]=oper;
	b[ind]=a;
	ind++;
	//alert(b)
	</c:forEach>
	////////////////
	
	
	 function getQuanzi(k,t){
	 var res = new Array();
            $.ajax({
            type:"post",
            url:"seller_getcomment_table",
            data:"kind="+k+"&diff="+t,
            success: function(msgdata){
   			var r = msgdata.split("*")
   			for(var i=0;i<r.length;i++){
   			var fres = new Array();
   			fres = r[i].split(",")
   				var oper = [{label:'删除',id:fres[0],onclick:function(){
			 var msg = "您真的确定要删除吗？\n\n请确认！"; 
				 if (confirm(msg)==true){ 
				   $.ajax({
					url:"deleteComment",
					type:"post",
					data:"commentid="+this.id,
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
				 }}}]
				 fres[7]=oper;
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
			location.href="seller_tocomment_table?index="+page1

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
</html>
