<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*, java.lang.*" %>
<%@ page import="java.text.*, java.net.InetAddress" %>
<c:set var="path1" value="<%=request.getContextPath() %>" />
<%-- <c:set var="path1" value="${pageContext.request.contextPath }" />   --%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>음식점 등록</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
    
    <style>
    .buttons {padding-left: 450px;}
    .title {text-align: center;}
    </style>
    
  </head>
  <body>
  <jsp:include page="../header.jsp" />
  <section class="section">
    <div class="container">
      <h1 class="title">음식점 등록</h1>
      	<form action="${path1 }/AddFoodCtrl.do" method="post">
			<table class="table">
			   <tbody>
			    <tr>
			      <th><label for="name">음식점명</label></th>
			      <td><input type="text" class="input" maxlength="120" name="name" id="name" placeholder="음식점명 입력" required /></td>
			    </tr>
			    
			    <tr>
			      <th><label for="kind">유형</label></th>
			      <td><input type="text" class="input" maxlength="120" name="kind" id="kind" placeholder="유형 입력" required /></td>
			    </tr>
			    
			    <tr>
			      <th><label for="menu">주메뉴</label></th>
			      <td><input type="text" class="input" maxlength="120" name="menu" id="menu" placeholder="주메뉴 입력" required /></td>
			    </tr>
			    
			    <tr>
			      <th><label for="pos">위치</label></th>
			      <td><input type="text" class="input" maxlength="120" name="pos" id="pos" placeholder="위치입력" required /></td>
			    </tr>
			    
			    <tr>
			      <th><label for="tel">전화번호</label></th>
			      <td><input type="text" class="input" maxlength="120" name="tel" id="tel" placeholder="전화번호 입력" required /></td>
			    </tr>

			  </tbody>
			</table>
			<div class="buttons">
			  <button type="submit" class="button is-success">등록</button>
			  <button type="reset" class="button is-success">취소</button>
			  <a href="${path1 }/GetFoodListCtrl.do" class="button is-success">목록</a>
			</div>
		</form>
    </div>
  </section>
  <jsp:include page="../footer.jsp"></jsp:include>
  </body>
</html>