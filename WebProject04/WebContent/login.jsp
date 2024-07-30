<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	*{ 
		margin: 0 auto;
	}
	div {
		width: 250px;
		padding: 40px 20px 20px 20px;
		border: 1px solid black;
	}
	button {
		width: 210px;
		text-align: center;
	}
</style>
</head>
<body>
	<div>
		<h1>로그인창</h1>
		ID:&nbsp;&nbsp;<input type="text" name="login_id"/>
		<br/>
		PW: <input type="password" name="login_pw"/>
		<br/>
		<button id="login">로그인</button>
		<br/>
		<button id="join">회원가입</button>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script>
	
	
	$(function() {
		const pathname = "/" + window.location.pathname.split("/")[1] + "/";
		const origin = window.location.origin;
		const contextPath = origin + pathname;
		
		
		function inputValidationCheck(id, pw) {
			if(id != "" && pw != "") {
				return true;
			} else {
				return false;
			}
		}
		
		
		$("#login").click(function() {
			
			let loginId = $("input[name='login_id']").val();
			let loginPw = $("input[name='login_pw']").val();
		
			if ( inputValidationCheck(loginId, loginPw) ) {
				
				$.ajax({
					type: "POST",
					async: true,
					url: contextPath + "/LoginServlet",
					data: {
						loginId: loginId,
						loginPw: loginPw
					},
					dataType: "json",
					success: function(response) {
						if(response.key) {
							alert("로그인 성공");
								window.location.href = contextPath + "/LoginAfterServlet";
						} else {
							alert("로그인 실패");
						}
					}, error: function() {
						console.log("login error");
					}, complete: function() {
						console.log("login complete");
					}
					
				})
				
			} else {
				alert("아이디와 비밀번호를 입력해주세요.")
			}
			
			
			
			
			
			
		})
		
		
	 	$("#join").click(function() {
	 		window.location.href = contextPath + "/join.jsp";
	 	})
	})
	

</script>

</html>