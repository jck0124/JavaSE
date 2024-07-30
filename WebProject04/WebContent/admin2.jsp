<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원관리 - 수정관리자</h1>
	<form action="<%=request.getContextPath()%>/UserInfoUpdateServlet">
		ID <input type="text" name="change_id" value="<%=request.getAttribute("userId") %>" readonly/>
		<br/>
		PW <input type="text" name="change_pw"/>
		<br/>	
		Name <input type="text" name="change_name"/>
		<br/>	
		Point <input type="text" name="change_point"/>
		<br/>	
		<button style="width=300px;">제출</button>
	</form>
</body>
</html>