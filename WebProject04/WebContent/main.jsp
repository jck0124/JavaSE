<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body {
		padding: 50px 20px 20px 50px;
		margin: 0 auto;
		width: 1200px;
	}
	header {
		display: flex;
		justify-content: space-between;
	}
	.item_container {
		display: flex;
		justify-content: space-between;
	}
	.item_container > div {
		cursor: pointer;
	}	
	.ad {
		margin-top: 20px;
		display: flex;
		justify-content: flex-end;
	}
	.ad > img {
		cursor: pointer;
	}
	.price {
		text-align: center;
	}
	
</style>
</head>
<body>
	<header>
		<div>
			<h1>메인페이지</h1>
		</div>
		<div>
			<div>
				<span>
					<%=request.getAttribute("loginName")%>
					(<%=session.getAttribute("loginId") %>)	
					님 안녕하세요.
				</span>
				<button class="logout">로그아웃</button> 
			</div>
			<div>포인트:<%=request.getAttribute("loginPoint") %>점</div>
		</div>
	</header>
	
	<div>
		<h2>구입할 컨텐츠를 선택하세요.</h2>
	</div>
	
	<div class="item_container">
		<div class="item">
			<div>
				<img src="<%=request.getContextPath()%>/img/Intro_350_408.png"/>
			</div>
			<div class="price">100,000포인트</div>
			<input type="hidden" name="subject" value="intro"/>
			<input type="hidden" name="item_price" value="100000"/>
		</div>
		<div class="item">
			<div>
				<img src="<%=request.getContextPath()%>/img/Java_350_408.png"/>
			</div>
			<div class="price">500,000포인트</div>
			<input type="hidden" name="subject" value="C++"/>
			<input type="hidden" name="item_price" value="500000"/>
		</div>
		<div class="item">
			<div>
				<img src="<%=request.getContextPath()%>/img/Cpp_350_408.png"/>
			</div>
			<div class="price">300,000포인트</div>
			<input type="hidden" name="subject" value="C++"/>
			<input type="hidden" name="item_price" value="300000"/>
		</div>
	</div>
	
	<div class="ad">
		<img src="<%=request.getContextPath()%>/img/korea_it.png">
	</div>
	
</body>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script>
	
	$(function(){
		const pathname = "/" + window.location.pathname.split("/")[1] + "/";
		const origin = window.location.origin;
		const contextPath = origin + pathname;
		
		// 로그아웃
		$(".logout").click(function() {
			alert("로그아웃 되었습니다.");
			window.location.href = contextPath + "/LogoutServlet";
		});
		
		
		// 상품클릭
		$(".item").click(function() {
			
			let price = $(this).find("input[name='item_price']").val();
			let subject = $(this).find("input[name='subject']").val();

			$.ajax({
				type: "GET",
				async: true,
				url: contextPath + "/RemainingPoints",
				data: {
					price: price,
					subject: subject
				},
				dataType: "json",
				success: function(response) {
				
					if(response.key) {
						alert("컨텐츠(" + subject + ")를 구입하였습니다.");
					} else {
						alert("“포인트가 부족합니다. 광고를 클릭하세요.");
					}
					
				}, error: function() {
					console.log("상품클릭 error")
				}, complete: function() {
					console.log("상품클릭 complete")
				}
				
			})
			
		});


		
		
		// 광고 클릭
		$(".ad > img").click(function() {
			$.ajax({
				type: "GET",
				async: true,
				url: contextPath + "/AdvertisementServlet",
				dataType: "json",
				success: function(response) {
					alert(response.key + "점이 적립되었습니다.")
				}, error: function() {
					console.log("광고클릭 error")
				}, complete: function() {
					console.log("광고클릭 complete")
				}
				
			})
			
		})
		
		
	})

</script>


</html>