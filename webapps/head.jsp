<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*, java.lang.*" %>
<%@ page import="java.text.*, java.net.InetAddress" %>
<c:set var="path0" value="<%=request.getContextPath() %>" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
<style>
.table { min-width:960px; }
#logo2 { display:block; width:85px; height:auto; background-color:white; background-image:url("${path0 }/data/green.jpg");
background-size:85% auto; background-repeat:no-repeat; background-position:center center; }
#nav { border-bottom:3px solid #fff; }
</style>
<script src="https://code.jquery.com/jquery-latest.js"></script>