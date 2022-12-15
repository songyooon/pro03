<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path2" value="${pageContext.request.contextPath }" /> 
<div id="nav-group">
	<div class="container"> 
		<nav class="navbar" role="navigation" aria-label="main navigation" id="nav">
		  <div class="navbar-brand">
		    <a class="navbar-item" id="logo2" href="<%=request.getContextPath() %>/">
		    </a>
		
		    <a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false" data-target="navbarBasicExample">
		      <span aria-hidden="true"></span>
		      <span aria-hidden="true"></span>
		      <span aria-hidden="true"></span>
		    </a>
		  </div>
		
		  <div id="navbarBasicExample" class="navbar-menu">
		    <div class="navbar-start" id="gnb">
		    	<!-- ajax로 메뉴 로딩하여 추가하기 -->
		    	

				   <div href="${path2 }/GetTourCateListCtrl.do?cate=A" class="navbar-item has-dropdown is-hoverable single">
			    	<a class="navbar-link is-arrowless">
				      	관광안내
				    </a>
					<div class="navbar-dropdown single">
					     <a class="navbar-item" href="<%=request.getContextPath() %>/GetNoticeListCtrl.do">
					       	공지사항
					     </a>
					   <a class="navbar-item" href="<%=request.getContextPath() %>/GetSightseeingListCtrl.do">
				        마포관광동영상
				      </a>
				      <a class="navbar-item" href="<%=request.getContextPath() %>/GetSightseeingListCtrl.do">
				        관광정보사이트
				      </a>
				    </div> 
				</div>
				 <div class="navbar-dropdown cate" id="cate01">
				    
				    </div> 
				    
		    	
				<div href="${path2 }/GetTourCateListCtrl.do?cate=B" class="navbar-item has-dropdown is-hoverable single">
			    	<a class="navbar-link is-arrowless">
				      	관광명소
				    </a>
					<div class="navbar-dropdown single">
					     <a class="navbar-item" href="<%=request.getContextPath() %>/GetTourListCtrl.do">
					       	자연속힐링
					     </a>
					   <a class="navbar-item" href="<%=request.getContextPath() %>/GetTourListCtrl.do">
				        체험관/전시장
				      </a>
				      <a class="navbar-item" href="<%=request.getContextPath() %>/GetTourListCtrl.do">
				        공연장
				      </a>
				    </div> 
				</div>
					<div class="navbar-dropdown cate" id="cate02">
				    
				    </div>
				
				
				<div href="${path2 }/GetTourCateListCtrl.do?cate=C" class="navbar-item has-dropdown is-hoverable single">
			    	<a class="navbar-link is-arrowless">
				      	쇼핑
				    </a>
					<div class="navbar-dropdown single">
					     <a class="navbar-item" href="<%=request.getContextPath() %>/GetShoppingListCtrl.do">
					       	쇼핑몰
					     </a>
					   <a class="navbar-item" href="<%=request.getContextPath() %>/GetShoppingListCtrl.do">
				       	 전통시장
				      </a>
				    </div> 
				</div>
					<div class="navbar-dropdown cate" id="cate03">
				    
				    </div>
				
				
				<div href="${path2 }/GetTourCateListCtrl.do?cate=D" class="navbar-item has-dropdown is-hoverable single">
			    	<a class="navbar-link is-arrowless">
				      	음식
				    </a>
					<div class="navbar-dropdown single">
					     <a class="navbar-item" href="<%=request.getContextPath() %>/GetFoodListCtrl.do">
					       	모범음식점
					     </a>
					   <a class="navbar-item" href="<%=request.getContextPath() %>/GetFoodListCtrl.do">
				       관광식당
				      </a>
				      <a class="navbar-item" href="<%=request.getContextPath() %>/GetFoodListCtrl.do">
				       안심식당
				      </a>
				    </div> 
				</div>
					<div class="navbar-dropdown cate" id="cate04">
				    
				    </div>
				
		    	<div href="${path2 }/GetTourCateListCtrl.do?cate=E" class="navbar-item has-dropdown is-hoverable single">
			    	<a class="navbar-link is-arrowless">
				      	역사
				    </a>
					<div class="navbar-dropdown single">
					   <a class="navbar-item" href="<%=request.getContextPath() %>/GetHistoryListCtrl.do">
				        마포의 역사
				      </a>
				      <a class="navbar-item" href="<%=request.getContextPath() %>/GetHistoryListCtrl.do">
				        동이름의 유래
				      </a>
				      <a class="navbar-item" href="<%=request.getContextPath() %>/GetHistoryListCtrl.do">
				        동네에 전해져 온 설화
				      </a>
				    </div> 
				</div>
				<div class="navbar-dropdown cate" id="cate05">
				    
				    </div>
				    
			</div>
			
			<div class="navbar-end" id="tnb">
			  <div class="navbar-item">
			  	<c:if test="${empty sid }">
			 <div class="buttons">
			   <a href="${path2 }/user/agree.jsp" class="button is-success">
			     회원가입
			   </a>
			   <a href="${path2 }/user/login.jsp" class="button is-success">
			     로그인
			   </a>
			 </div>
			</c:if>
			<c:if test="${not empty sid }">
			 <div class="buttons">
			   <a href="${path2 }/UserInfoCtrl.do" class="button is-success">
			     회원정보
			   </a>
			   <a href="${path2 }/UserLogoutCtrl.do" class="button is-success">
			     로그아웃
			   </a>
				<c:if test='${sid.equals("admin")}'>
				   <a href="${path2 }/AdminCtrl.do" class="button is-success">
				     관리자
				   </a>
				 </c:if>
			 </div>
			</c:if>
		  </div>
		</div>
		  </div>
		</nav>
	<script>
	$(document).ready(function(){
		$.ajax({
			url:"${path2 }/MenuLoadCtrl.do",
			type:"POST",
			enctype:"UTF-8",
			datatype:"json",
			processData:false,
			contentType:false, 
			cache:false,
			success:function(data){
				$(".navbar-dropdown.cate").empty();
				var trans = $.parseJSON(data);
				$.each(trans, function(key, value){
					if(key=="data"){
						for(var i=0;i<value.length;i++){
							if(value[i].cate=="A"){
								$("#cate01").append("<a href='${path2 }/GetTourDetailCtrl.do?no="+value[i].no+"'>"+value[i].place+"</a>");
							} else if(value[i].cate=="B"){
								$("#cate02").append("<a href='${path2 }/GetTourDetailCtrl.do?no="+value[i].no+"'>"+value[i].place+"</a>");
							} else if(value[i].cate=="C"){
								$("#cate03").append("<a href='${path2 }/GetTourDetailCtrl.do?no="+value[i].no+"'>"+value[i].place+"</a>");
							} else if(value[i].cate=="D"){
								$("#cate04").append("<a href='${path2 }/GetTourDetailCtrl.do?no="+value[i].no+"'>"+value[i].place+"</a>");
							} else if(value[i].cate=="E"){
								$("#cate05").append("<a href='${path2 }/GetTourDetailCtrl.do?no="+value[i].no+"'>"+value[i].place+"</a>");
							} else if(value[i].cate=="F"){
								$("#cate06").append("<a href='${path2 }/GetTourDetailCtrl.do?no="+value[i].no+"'>"+value[i].place+"</a>");
							} else if(value[i].cate=="G"){
								$("#cate07").append("<a href='${path2 }/GetTourDetailCtrl.do?no="+value[i].no+"'>"+value[i].place+"</a>");
							}
						}
					}
				});
				
			}
		});
	});
	</script>
	</div>
</div>