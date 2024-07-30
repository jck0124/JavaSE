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
		<h1>회원가입</h1>
		<form action="<%=request.getContextPath() %>/JoinServlet" method="post">
			ID:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="join_id"/>
			<br/>
			PW: &nbsp;&nbsp;&nbsp;<input type="password" name="join_pw"/>
			<br/>
			Name: <input type="text" name="join_name"/>
			<br/>
			<button>작성완료</button>
		</form>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script>

	$(function() {
		function inputValidationCheck(id, pw, name) {
			if(( id.trim() != "" ) 
				&& ( pw.trim() != "" ) 
				&& (name.trim() != "" ) ) {
				return true;
			} else {
				return false;
			}
		};

		$("button").click(function(e) {
			let id = $("input[name='join_id']").val();
			let pw = $("input[name='join_pw']").val();
			let name = $("input[name='join_name']").val();
			
			if( inputValidationCheck(id, pw, name) ) {
				alert("가입되었습니다. 로그인 해주세요.");
			} else {
				e.preventDefault();
				alert("모두 작성해주세요.");
			}
		})
	})
	

</script>


</html>