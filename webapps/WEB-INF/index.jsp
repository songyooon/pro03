<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*, java.lang.*" %>
<%@ page import="java.text.*, java.net.InetAddress" %>
<c:set var="path1" value="${request.getContextPath() }" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>마포 문화관광</title>
    <jsp:include page="/head.jsp" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
    
    
    <style>
    a:link { color: rgb(0, 0, 0); text-decoration:none !important}	
    a:visited { color: #000; text-decoration:none !important}	

    a:active { color: rgb(0, 0, 0); text-decoration:none !important}
   
    #index1 { display:block; width:120px; height:auto; background-color:white; background-image:url("${path0 }/data/index/1.jfif");
background-size:85% auto; background-repeat:no-repeat; background-position:center center; }
    
         	/* 브라우저 마진과 패딩 리셋 */
	* {margin:0;padding:0;}

    /* INPUT 가리기 */
    .section [id*="slide"] {display:none;}

    /* 슬라이드 영역 - max-width 크기를 조절해주면 됩니다*/
    .section .slidewrap {max-width:2000px;margin:0 auto;overflow:hidden;position:relative;}
    .section .slidelist {white-space:nowrap;font-size:0;}
    .section .slidelist > li {display:inline-block;vertical-align:middle;width:100%;transition:all .9s;}
    .section .slidelist > li > a {display:block;position:relative;}

    /* 좌우로 넘기는 LABEL버튼에 대한 스타일 */
    .section .slide-control {position:absolute;top:0;left:0;z-index:10;width:100%;height:100%;}
    .section .slide-control label {position:absolute;z-index:1;top:50%;transform:translateY(-50%);padding:50px;cursor:pointer;}
    .section .slide-control .left {left:0;background:url('${path0 }/data/icon/left.png') center center / 22% no-repeat;}
    .section .slide-control .right {right:170px;background:url('${path0 }/data/icon/right.png') center center / 100% no-repeat;}
    .section .slide-control [class*="control"] {display:none;}

    /* INPUT이 체크되면 변화값이 li까지 전달되는 스타일 */
    .section [id="slide01"]:checked ~ .slidewrap .slidelist > li {transform:translateX(0%);}
    .section [id="slide02"]:checked ~ .slidewrap .slidelist > li {transform:translateX(-100%);}
    .section [id="slide03"]:checked ~ .slidewrap .slidelist > li {transform:translateX(-200%);}
    .section [id="slide04"]:checked ~ .slidewrap .slidelist > li {transform:translateX(-300%);}

    /*  INPUT이 체크되면 변화값이 좌우 슬라이드 버튼을 담고 있는 div 까지 전달되는 스타일 */
    .section [id="slide01"]:checked ~ .slidewrap .control01 {display:block;}
    .section [id="slide02"]:checked ~ .slidewrap .control02 {display:block;}
    .section [id="slide03"]:checked ~ .slidewrap .control03 {display:block;}   
    .section [id="slide04"]:checked ~ .slidewrap .control04 {display:block;}


    /* 페이징 */
	.slide-pagelist {text-align:center;padding:20px;}
	.slide-pagelist > li {display:inline-block;vertical-align:middle;}
	.slide-pagelist > li > label {display:block;padding:7px 13px;border-radius:30px;background:#ccc;margin:20px 10px;cursor:pointer;}
	.section input[id="slide01"]:checked ~ .slidewrap .slide-pagelist > li:nth-child(1) > label {background:#999;}
	.section input[id="slide02"]:checked ~ .slidewrap .slide-pagelist > li:nth-child(2) > label {background:#999;}
	.section input[id="slide03"]:checked ~ .slidewrap .slide-pagelist > li:nth-child(3) > label {background:#999;}
   

    
    .pro_ra { display:none; }
    .ban1 { clear:both; width: 100%; height:auto; margin:0 auto; overflow-x:hidden; }
    .ban_img_fr { clear:both; width:9000px; margin-left: 0; transition-duration:0.6s; }
    #pro_ra1:checked ~ .ban_img_fr { margin-left: 0; }
    #pro_ra2:checked ~ .ban_img_fr { margin-left:-1200px; }
    #pro_ra3:checked ~ .ban_img_fr { margin-left:-2400px; }
    #pro_ra4:checked ~ .ban_img_fr { margin-left: -3600px; }

    .ban_img_fr:after { content:""; display:block; clear:both; }
    .ban_img_fr li { float:left; width: 1200px; margin: 0; }
    .ban_img_fr li img { display:block; width: 100%; height: auto; margin: 0; }
    .btn_fr { clear:both; }
    .btn_group.left { float:left; }
    .btn_group.left label { display:block; width: 12px; height: 12px; background-color:transparent; border:2px solid
    rgb(141, 141, 141); border-radius: 50%; text-indent:-9999px; margin: 8px; cursor:pointer; }
    #pro_ra1:checked ~ .btn_fr .btn_group.left li.item1 label { background-color:rgb(141, 141, 141); }
    #pro_ra2:checked ~ .btn_fr .btn_group.left li.item2 label { background-color:rgb(141, 141, 141); }
    #pro_ra3:checked ~ .btn_fr .btn_group.left li.item3 label { background-color:rgb(141, 141, 141); }
    #pro_ra4:checked ~ .btn_fr .btn_group.left li.item4 label { background-color:rgb(141, 141, 141); }

    .btn_group.right { float:right; }
    .btn_group li { float:left; margin: 8px;}
    .btn_group.right li a { display:block; width: 32px; height: 32px; background-repeat: no-repeat; background-size:32px
    32px; }
    
    
    
    </style>
</head>
<body>
  	<jsp:include page="${path1 }/header.jsp" />
  	
		    
		                <div class="section">
                <input type="radio" name="slide" id="slide01" checked>
                <input type="radio" name="slide" id="slide02">
                <input type="radio" name="slide" id="slide03">
                <input type="radio" name="slide" id="slide04">

                <div class="slidewrap">
                    <ul class="slidelist">
                        <li>
                            <a>
                                <img src="${path0 }/data/index/1.jfif">

                            </a>
                        </li>
                        <li>
                            <a>
                                <img src="${path0 }/data/index/2.jfif">
                            </a>
                        </li>
                        <li>
                            <a>
                                <img src="${path0 }/data/index/3.jfif">
                            </a>
                        </li>
                        <li>
                            <a>
                                <img src="${path0 }/data/index/4.jfif">
                            </a>
                        </li>

                    </ul>
            
                    <div class="slide-control">
                        <div class="control01">
                            <label for="slide04" class="left"></label>
                            <label for="slide02" class="right"></label>
                        </div>
                        <div class="control02">
                            <label for="slide01" class="left"></label>
                            <label for="slide03" class="right"></label>
                        </div>
                        <div class="control03">
                            <label for="slide02" class="left"></label>
                            <label for="slide04" class="right"></label>
                        </div>
                        <div class="control04">
                            <label for="slide03" class="left"></label>
                            <label for="slide01" class="right"></label>
                        </div>
                        
                    </div>

                    		<!-- 페이징 -->
		            <ul class="slide-pagelist">
			        <li><label for="slide01"></label></li>
			        <li><label for="slide02"></label></li>
			        <li><label for="slide03"></label></li>
                    <li><label for="slide04"></label></li>

		            </ul>

                </div>
            </div>
		    
            
	<jsp:include page="${path1 }/footer.jsp" />
</body>
</html>