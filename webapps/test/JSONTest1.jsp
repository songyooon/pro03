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

<meta charset="UTF-8">
<title>JSON test</title>
<jsp:include page="/head.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>

	<p>JavaScript object notation 자바스크립트의 객체 형태로 데이터를 교환하는 방식</p>
	<script>
	//JSON은 javad의 map
	$(document).ready(function(){
		var obj = {name:"김기태", age:38};
		$("#js").html("<p>이름 : "+obj.name+"</p>");
		$("#js").append("<p>나이 : "+obj.age+"</p>");
	});
	</script>

<script>
$(document).ready(function(){
	$.ajax({
		url:"${path1 }/JSONTest1.do",
		type:"post",		
		dataType:"json",		
		success:function(result){
			console.log(result.result);
			var test = result.result;	
				$("#con").html(test);
		}
	});
});

</script>

<script>
$(document).ready(function(){
	var params = { name : "김기태" }
	$.ajax({
		url:"${path1 }/JSONTest2.do",
		type:"post",		
		dataType:"json",		
		data:params,
		success:function(data){
			console.log(data);
			var user = data;	
				$("#con").html("이름 : "+user.name+", 점수 : "+user.point);
		}
	});
});

</script>

</body>
</html>