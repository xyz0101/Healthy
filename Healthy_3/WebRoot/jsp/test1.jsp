<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'imagePlay.jsp' starting page</title>
    
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
<link rel="stylesheet" type="text/css" href="styles.css">

<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
-->
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript">
function CenterImgPlay() {
        this.list = $(".imgbox").children(":first").children();
        this.indexs = [];
        this.length = this.list.length;
        //图片显示时间
        this.timer = 3000;
        this.showTitle = $(".title");
 
        var index = 0, self = this, pre = 0, handid, isPlay = false, isPagerClick = false;
 
        this.Start = function () {
            this.Init();
            //计时器，用于定时轮播图片
            handid = setInterval(function(){self.Play()}, this.timer);//////////////////////////////////
 
        };
        //初始化
        this.Init = function () {
//////////////////////////////////
            $(".imgbox").mouseenter(function () { clearInterval(handid); }).mouseleave(function () { handid = setInterval(function () { self.Play() }, self.timer); });
 
            var o = $(".pager ul li");
 
            for (var i = o.length - 1, n = 0; i >= 0; i--, n++) {
                this.indexs[n] = o.eq(i).click(self.PagerClick);
            }
 
 
        };
        this.Play = function () {
            isPlay = true;
            index++;
            if (index == self.length) {//说明已经播放到了最后一个，从第一个重新开始播放
                index = 0;
            }
 
            console.log("Play+++index=" + index);
            console.log("Play+++pre=" + pre);
            //先淡出，在回调函数中执行下一张淡入
            self.list.eq(pre).fadeOut(300, function () { self.imageIn() }); //end of fadeout
        };
        this.imageIn = function () {
            var info = self.list.eq(index).fadeIn(500, function () {
                isPlay = false;
                //////////////////////////////////if (isPagerClick) { handid = setInterval(self.Play, self.timer); isPagerClick = false; }
            }).attr("title");
 
            //显示标题
            self.showTitle.text(info);
            //图片序号背景更换
            self.indexs[index].css("background-color", "#FF70Ad");
            self.indexs[pre].css("background-color", "#6f4f67");
 
 
            pre = index;
            console.log("imageIn+++pre=" + pre);
 
        }
        //图片序号点击
        this.PagerClick = function () {
            if (isPlay) { return; }
            isPagerClick = true;
 
            clearInterval(handid);
 
            var oPager = $(this), i = parseInt(oPager.text()) - 1;
 
            if (i != pre) {
                index = i - 1;
            }
            self.Play();
        };
    };
</script>


    <style type="text/css">
        ul,li{margin: 0;padding: 0;list-style: none}
        #out_div{position:relative;border: 1px solid #ccc;width: 400px;height: 200px;margin: 200px auto}
        .banner{height:200px;position: relative;overflow: hidden}
        .banner li{position: absolute;width: 100%;left: 0;background-repeat: repeat-x;background-position: center}
        .banner img{width:400px;height: 200px;z-index:1;}
        .banner_li{position: absolute;left:50%;margin-top: -20px;}
        .banner_li li{font-size:0;float: left;width:12px;height:12px;margin-left:7px;cursor: pointer;border-radius: 50%;background-color:#ddd;cursor: pointer}
        .banner_li .on_li{background-color:#f30}
    </style>
</head>
<body>
<div id="out_div">
    <ul class="banner">
        <li><a href="javascript:void(0)"><img src="http://down.scscms.com/scs/pic/1.jpg" alt=""/></a></li>
        <li><a href="javascript:void(0)"><img src="http://down.scscms.com/scs/pic/2.jpg" alt=""/></a></li>
        <li><a href="javascript:void(0)"><img src="http://down.scscms.com/scs/pic/3.jpg" alt=""/></a></li>
        <li><a href="javascript:void(0)"><img src="http://down.scscms.com/scs/pic/4.jpg" alt=""/></a></li>
    </ul>
</div>
<script type="text/javascript" src="js/jquery-1.4.3.min.js"></script>
<script type="text/javascript">
    $(function(){
        function animate(){
            i ++;old = li.filter(":visible");
            if(i != old.index()){
                i >= l && (i = 0);
                $(".banner_li li").removeAttr("class").eq(i).addClass("on_li");
                li.eq(i).css({zIndex:1,display:"block",opacity:0}).animate({opacity:1},1000,function(){$(this).css({zIndex:0});old.hide()})
            }
        }
        var li = $(".banner li"),l = li.size(),i = 0,arr = new Array(l);
        $(".banner").after('<ul class="banner_li" style="z-index:2;margin-left: -'+Math.floor(l/2*13)+'px"><li class="on_li">'+arr.join("</li><li>")+'</li></ul>');
        var old = li.first().show(),fun = setInterval(animate,6000);
        $(".banner_li").delegate("li","click",function(){i = $(this).index()-1;animate()}).hover(function(){clearInterval(fun)},function(){fun = setInterval(animate,6000)});
    })
</script>
</body>
</html>