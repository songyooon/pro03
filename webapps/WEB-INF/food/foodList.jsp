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
    <title>음식점 목록</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
  </head>
  <body>
  <jsp:include page="/header.jsp" />
  <section class="section">
    <div class="container">
      <h1 class="title">음식점 목록</h1>
		<table class="table">
		  <thead>
		    <tr>
		      <th><abbr title="No">번호</abbr></th>
		      <th><abbr title="Name">음식점명</abbr></th>
		      <th><abbr title="Kind">유형</abbr></th>
		      <th><abbr title="Menu">주메뉴</abbr></th>
		      <th><abbr title="Pos">위치</abbr></th>
		      <th><abbr title="Tel">전화번호</abbr></th>
		    </tr>
		  </thead>
		   <tbody>
		   <c:forEach items="${list }" var="dto" varStatus="status">
		    <tr>
		      <td>${status.count }</td>
		      <td><a href="${path1 }/GetFoodCtrl.do?no=${dto.no }">${dto.name }</a></td>
		    </tr>
		    </c:forEach>
<%-- 		    <c:if test="${list==null }">
		    <tr>
		    	<td colspan="3">해당 데이터 목록이 없습니다.</td>
		    </tr>
		    </c:if> --%>
		  </tbody>
		</table>
		<div class="buttons">
		  <a href="${path1 }/food/addFood.jsp" class="button is-success">글 등록</a>
		</div>
    </div>
  </section>
  <jsp:include page="/footer.jsp"></jsp:include>
  </body>
</html>