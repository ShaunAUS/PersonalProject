<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!--favicon-->
	<link rel="icon" href="assets/images/favicon-32x32.png" type="image/png" />
	<!-- loader-->
	<link href="assets/css/pace.min.css" rel="stylesheet" />
	<script src="assets/js/pace.min.js"></script>
	<!-- Bootstrap CSS -->
	<link href="assets/css/bootstrap.min.css" rel="stylesheet">
	<link href="assets/css/app.css" rel="stylesheet">
	<link href="assets/css/icons.css" rel="stylesheet">
	<title>입력양식</title>
</head>

<body class="bg-forgot">
	<!-- wrapper -->	
	<div class="wrapper">
		<div class="authentication-forgot d-flex align-items-center justify-content-center">
			<div class="card forgot-box">
				<div class="card-body">
					<div class="p-4 rounded  border">
						<div class="text-center">
							<img src="assets/images/icons/forgot-2.png" width="120" alt="" />
						</div>
						<h4 class="mt-5 font-weight-bold">비밀번호를 분실하셨나요?</h4>
						<p class="text-muted">등록하신 이메일주소를 입력하시면 확인후 새 비밀번호 입력이 가능합니다</p>
						
				<form action="fp" method="post">	
						<div class="my-4">
							<label class="form-label">이메일주소</label>
							<input type="text" name="forgotPassword_email" class="form-control form-control-lg" placeholder="example@user.com" />
						</div>
					
						
						<div class="d-grid gap-2">
							<button input type="submit"  class="btn btn-primary btn-lg">계정찾기</button> <a href="signin.jsp" class="btn btn-light btn-lg"><i class='bx bx-arrow-back me-1'></i>로그인으로 이동</a>
						</div>
				</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end wrapper -->
</body>

</html>