<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body {
		width: 1200px;
		margin: 0 auto;
		padding: 40px 20px 20px 20px;
	}
	.menu1 {
		display: flex;
		justify-content: space-between; 
	}
	table {
            border-collapse: collapse;
            width: 100%;
    }
    th, td {
        border: 1px solid black;
        padding: 8px;
        text-align: center;
    }

</style>
</head>
<body>
	<div class="menu1">
		<div>
			<h1>회원관리</h1>
		</div>
		<div>
			<button class="login">로그인</button>
		</div>
	</div>
	
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>PW</th>
				<th>Name</th>
				<th>Point</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<!-- 반복문 시작 -->
		 	<c:forEach var="uDto" items="${userList}">
				<tr>
					<form action="<%=request.getContextPath()%>/UserInfoUpdateEntranceservlet">
				        <td class="user_id">${uDto.id}</td>
				        <input type="hidden" value="${uDto.id}" name="user_id"/>
				        <td>${uDto.pw}</td>
				        <td>${uDto.name}</td>
				        <td>${uDto.point}</td>
				        <td>
				        		<button class="change">수정</button>
				        </td>
				        <td>
				        	<button class="delete">삭제</button>
				        </td>
			        </form>
			    </tr>
		    </c:forEach>
			<!-- 반복문 종로 -->
		</tbody>
	</table>
	
	<h1>스케줄러 관리</h1>
	<button>스케줄러(20초마다 포인트1 증가)실행 시작</button>	
	<button>스케줄러 실행 종료</button>	
	
	
</body>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script>
$(function() {
	
	const pathname = "/" + window.location.pathname.split("/")[1] + "/";
	const origin = window.location.origin;
	const contextPath = origin + pathname;
	
	$(".login").click(function() {
		window.location.href = contextPath + "/login.jsp";		
	})
	
	$(".delete").click(function() {
		
		let id = $(this).parent().parent().find(".user_id").text();
		console.log(id);
		
		$.ajax({
			type: "GET",
			async: true,
			url: contextPath + "/UserDeleteServlet",
			data: {
				id: id
			},
			dataType: "json",
			success: function(response) {
				alert("삭제되었습니다.")
			}, error: function() {
				console.log("삭제 error")
			}, complete: function() {
				console.log("삭제 complete")
			}
		})
		
		
	})
	
	
	
	
})
</script>
</html>