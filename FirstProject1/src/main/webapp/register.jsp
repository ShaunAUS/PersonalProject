<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">

<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!--favicon-->
	<link rel="icon" href="assets/images/favicon-32x32.png" type="image/png" />
	<!--plugins-->
	<link href="assets/plugins/simplebar/css/simplebar.css" rel="stylesheet" />
	<link href="assets/plugins/perfect-scrollbar/css/perfect-scrollbar.css" rel="stylesheet" />
	<link href="assets/plugins/metismenu/css/metisMenu.min.css" rel="stylesheet" />
	<!-- loader-->
	<link href="assets/css/pace.min.css" rel="stylesheet" />
	<script src="assets/js/pace.min.js"></script>
	<!-- Bootstrap CSS -->
	<link href="assets/css/bootstrap.min.css" rel="stylesheet">
	<link href="assets/css/app.css" rel="stylesheet">
	<link href="assets/css/icons.css" rel="stylesheet">
	<!-- Theme Style CSS -->
	<link rel="stylesheet" href="assets/css/dark-theme.css" />
	<link rel="stylesheet" href="assets/css/semi-dark.css" />
	<link rel="stylesheet" href="assets/css/header-colors.css" />
	<title>입력양식</title>
</head>

<body>
	<!--wrapper-->
	<div class="wrapper">
		<!--sidebar wrapper -->
		<div class="sidebar-wrapper" data-simplebar="true">
			<div class="sidebar-header">
				<div>
					<!--<img src="assets/images/logo-icon.png" class="logo-icon" alt="logo icon">-->
				</div>
				<div>
					<h4 class="logo-text">로고</h4>
				</div>
				<div class="toggle-icon ms-auto"><i class='bx bx-arrow-to-left'></i>
				</div>
			</div>
			<!--navigation-->
			<ul class="metismenu" id="menu">


				<li class="menu-label">입력양식</li>
				<li>
					<a class="has-arrow" href="javascript:;">
						<div class="parent-icon"><i class='bx bx-message-square-edit'></i>
						</div>
						<div class="menu-title">입력양식</div>
					</a>
					<ul>
						<li> <a href="form-elements.html"><i class="bx bx-right-arrow-alt"></i>입력 요소 </a>
						</li>
						<li> <a href="form-input-group.html"><i class="bx bx-right-arrow-alt"></i>입력 그룹</a>
						</li>
						<li> <a href="form-layouts.html"><i class="bx bx-right-arrow-alt"></i>입력양식 레이아웃</a>
						</li>
						<li> <a href="form-validations.html"><i class="bx bx-right-arrow-alt"></i>입력양식 오류체크</a>
						</li>
						<li> <a href="form-wizard.html"><i class="bx bx-right-arrow-alt"></i>입력양식 마법사</a>
						</li>
						<li> <a href="form-text-editor.html"><i class="bx bx-right-arrow-alt"></i>텍스트 편집기</a>
						</li>
						<li> <a href="form-file-upload.html"><i class="bx bx-right-arrow-alt"></i>파일 업로드</a>
						</li>
						<li> <a href="form-date-time-pickes.html"><i class="bx bx-right-arrow-alt"></i>날짜 픽업</a>
						</li>
						<li> <a href="form-select2.html"><i class="bx bx-right-arrow-alt"></i>셀렉터</a>
						</li>
					</ul>
				</li>
				<li>
					<a class="has-arrow" href="javascript:;">
						<div class="parent-icon"><i class="bx bx-grid-alt"></i>
						</div>
						<div class="menu-title">테이블</div>
					</a>
					<ul>
						<li> <a href="table-basic-table.html"><i class="bx bx-right-arrow-alt"></i>기본 테이블</a>
						</li>

					</ul>
				</li>
				<li class="menu-label">Pages</li>
				<li>
					<a class="has-arrow" href="javascript:;">
						<div class="parent-icon"><i class="bx bx-lock"></i>
						</div>
						<div class="menu-title">Authentication</div>
					</a>
					<ul>
						<li> <a href="authentication-signin.html" target="_blank"><i class="bx bx-right-arrow-alt"></i>Sign In</a>
						</li>
						<li> <a href="authentication-signup.html" target="_blank"><i class="bx bx-right-arrow-alt"></i>Sign Up</a>
						</li>
						<li> <a href="authentication-signin-with-header-footer.html" target="_blank"><i class="bx bx-right-arrow-alt"></i>Sign In with Header & Footer</a>
						</li>
						<li> <a href="authentication-signup-with-header-footer.html" target="_blank"><i class="bx bx-right-arrow-alt"></i>Sign Up with Header & Footer</a>
						</li>
						<li> <a href="authentication-forgot-password.html" target="_blank"><i class="bx bx-right-arrow-alt"></i>Forgot Password</a>
						</li>
						<li> <a href="authentication-reset-password.html" target="_blank"><i class="bx bx-right-arrow-alt"></i>Reset Password</a>
						</li>
		
					</ul>
				</li>
				<li>
					<a href="user-profile.html">
						<div class="parent-icon"><i class="bx bx-user-circle"></i>
						</div>
						<div class="menu-title">사용자 프로필</div>
					</a>
				</li>

			</ul>
			<!--end navigation-->
		</div>
		<!--end sidebar wrapper -->
		<!--start header -->
		<header>
			<div class="topbar d-flex align-items-center">
				<nav class="navbar navbar-expand">
					<div class="mobile-toggle-menu"><i class='bx bx-menu'></i>
					</div>
					<div class="top-menu-left d-none d-lg-block">
						<ul class="nav">
						  <li class="nav-item">
							<a class="nav-link" href="app-emailbox.html"><i class='bx bx-envelope'></i></a>
						  </li>
						  <li class="nav-item">
							<a class="nav-link" href="app-chat-box.html"><i class='bx bx-message'></i></a>
						  </li>
						  <li class="nav-item">
							<a class="nav-link" href="app-fullcalender.html"><i class='bx bx-calendar'></i></a>
						  </li>
						  <li class="nav-item">
							  <a class="nav-link" href="app-to-do.html"><i class='bx bx-check-square'></i></a>
						  </li>
					  </ul>
					 </div>
					<div class="search-bar flex-grow-1">
						<div class="position-relative search-bar-box">
							<input type="text" class="form-control search-control" placeholder="Type to search..."> <span class="position-absolute top-50 search-show translate-middle-y"><i class='bx bx-search'></i></span>
							<span class="position-absolute top-50 search-close translate-middle-y"><i class='bx bx-x'></i></span>
						</div>
					</div>
					<div class="top-menu ms-auto">
						<ul class="navbar-nav align-items-center">
							<li class="nav-item mobile-search-icon">
								<a class="nav-link" href="#">	<i class='bx bx-search'></i>
								</a>
							</li>
							<li class="nav-item dropdown dropdown-large">

							</li>
							<li class="nav-item dropdown dropdown-large">
								<a class="nav-link dropdown-toggle dropdown-toggle-nocaret position-relative" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"> <span class="alert-count">7</span>
									<i class='bx bx-bell'></i>
								</a>
								<div class="dropdown-menu dropdown-menu-end">
									<a href="javascript:;">
										<div class="msg-header">
											<p class="msg-header-title">알림</p>
											<p class="msg-header-clear ms-auto">모두 읽기</p>
										</div>
									</a>
									<div class="header-notifications-list">
										<a class="dropdown-item" href="javascript:;">
											<div class="d-flex align-items-center">
												<div class="notify bg-light-primary text-primary"><i class="bx bx-group"></i>
												</div>
												<div class="flex-grow-1">
													<h6 class="msg-name">테스트<span class="msg-time float-end">14초 전에
												</span></h6>
													<p class="msg-info">5명 신규회원등록</p>
												</div>
											</div>
										</a>
										<a class="dropdown-item" href="javascript:;">
											<div class="d-flex align-items-center">
												<div class="notify bg-light-danger text-danger"><i class="bx bx-cart-alt"></i>
												</div>
												<div class="flex-grow-1">
													<h6 class="msg-name">산규 주문 <span class="msg-time float-end">2 분전에
												</span></h6>
													<p class="msg-info">새로운 주문이 들어왔습니다</p>
												</div>
											</div>
										</a>
										<a class="dropdown-item" href="javascript:;">
											<div class="d-flex align-items-center">
												<div class="notify bg-light-success text-success"><i class="bx bx-file"></i>
												</div>
												<div class="flex-grow-1">
													<h6 class="msg-name">계산서 발행<span class="msg-time float-end">19 분전에
												</span></h6>
													<p class="msg-info">홍길동 고객님의 계산서가 발행되었습니다</p>
												</div>
											</div>
										</a>

									</div>
									<a href="javascript:;">
										<div class="text-center msg-footer">전체알람 보기</div>
									</a>
								</div>
							</li>
							<li class="nav-item dropdown dropdown-large">

							</li>
						</ul>
					</div>
					<div class="user-box dropdown">
						<a class="d-flex align-items-center nav-link dropdown-toggle dropdown-toggle-nocaret" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
							<img src="https://via.placeholder.com/110x110" class="user-img" alt="user avatar">
							<div class="user-info ps-3">
								<p class="user-name mb-0">홍길동</p>
								<p class="designattion mb-0">개발자</p>
							</div>
						</a>
						<ul class="dropdown-menu dropdown-menu-end">
							<li><a class="dropdown-item" href="javascript:;"><i class="bx bx-user"></i><span>프로필</span></a>
							</li>
							<li><a class="dropdown-item" href="javascript:;"><i class="bx bx-cog"></i><span>설정</span></a>
							</li>
							<li><a class="dropdown-item" href="javascript:;"><i class='bx bx-home-circle'></i><span>대시보드</span></a>
							</li>

							<li>
								<div class="dropdown-divider mb-0"></div>
							</li>
							<li><a class="dropdown-item" href="javascript:;"><i class='bx bx-log-out-circle'></i><span>로그아웃</span></a>
							</li>
						</ul>
					</div>
				</nav>
			</div>
		</header>
		<!--end header -->
		<!--start page wrapper -->
		<div class="page-wrapper">
			<div class="page-content">
				<!--breadcrumb-->
				<div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
					<div class="breadcrumb-title pe-3">입력양식</div>
					<div class="ps-3">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb mb-0 p-0">
								<li class="breadcrumb-item"><a href="javascript:;"><i class="bx bx-home-alt"></i></a>
								</li>
								<li class="breadcrumb-item active" aria-current="page">입력양식 레이아웃</li>
							</ol>
						</nav>
					</div>
					<div class="ms-auto">
						<div class="btn-group">
							<button type="button" class="btn btn-primary">설정</button>
							<button type="button" class="btn btn-primary split-bg-primary dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown">	<span class="visually-hidden">Toggle Dropdown</span>
							</button>
							<div class="dropdown-menu dropdown-menu-right dropdown-menu-lg-end">	<a class="dropdown-item" href="javascript:;">Action</a>
								<a class="dropdown-item" href="javascript:;">Another action</a>
								<a class="dropdown-item" href="javascript:;">Something else here</a>
								<div class="dropdown-divider"></div>	<a class="dropdown-item" href="javascript:;">Separated link</a>
							</div>
						</div>
					</div>
				</div>
				<!--end breadcrumb-->
				<div class="row">
					<div class="col-xl-7 mx-auto">
						<h6 class="mb-0 text-uppercase">기본 입력양식</h6>
						<hr/>
						<div class="card border-top border-0 border-4 border-primary">
							<div class="card-body p-5">
								<div class="card-title d-flex align-items-center">
									<div><i class="bx bxs-user me-1 font-22 text-primary"></i>
									</div>
									<h5 class="mb-0 text-primary">회원가입</h5>
								</div>
								<hr>
								
								
								
								<form action="rc" method="post" class="row g-3">
									<div
									 class="col-md-6">
										<label for="inputFirstName" class="form-label">이름</label>
										<input type="name" name="name" class="form-control" id="inputFirstName">
									</div>
									<div class="col-md-6">
			
									</div>
									<div class="col-md-6">
										<label for="inputEmail" class="form-label">이메일</label>
										<input type="email" name="email"class="form-control" id="inputEmail">
									</div>
									<div class="col-md-6">
										<label for="inputPassword" class="form-label">비밀번호</label>
										<input type="password" name="password"class="form-control" id="inputPassword">
									</div>
									<div class="col-12">
										<label for="inputAddress" class="form-label">주소</label>
										<textarea class="form-control"name="address" id="inputAddress" placeholder="주소..." rows="3"></textarea>
									</div>
									<div class="col-12">
										<label for="inputAddress2" class="form-label">상세주소</label>
										<textarea class="form-control" name="detail_address"id="inputAddress2" placeholder="상세주소..." rows="3"></textarea>
									</div>
									<div class="col-md-6">
										<label for="inputCity" class="form-label">도시</label>
										<input type="text" name="city"class="form-control" id="inputCity">
									</div>
									<div class="col-md-4">
										<label for="inputState" class="form-label">구/시</label>
										<select id="inputState" class="form-select">
											<option selected>선택...</option>
											<option>...</option>
										</select>
									</div>
									<div class="col-md-2">
										<label for="inputZip" class="form-label">우편번호</label>
										<input type="text" name="postcode" class="form-control" id="inputZip">
									</div>
									<div class="col-12">
										<div class="form-check">
											<input class="form-check-input" type="checkbox" id="gridCheck">
											<label class="form-check-label" for="gridCheck">체크하기</label>
										</div>
									</div>
									<div class="col-12">
										<button input type="submit" class="btn btn-primary px-5">회원가입</button>
									</div>
								</form>
								
								
								
								
							</div>
						</div>
						<h6 class="mb-0 text-uppercase">입력양식(아이콘)</h6>
						<hr/>
						<div class="card border-top border-0 border-4 border-danger">
							<div class="card-body p-5">
								<div class="card-title d-flex align-items-center">
									<div><i class="bx bxs-user me-1 font-22 text-danger"></i>
									</div>
									<h5 class="mb-0 text-danger">회원가입</h5>
								</div>
								<hr>
								<form class="row g-3">
									<div class="col-md-6">
										<label for="inputLastName1" class="form-label">이름</label>
										<div class="input-group"> <span class="input-group-text bg-transparent"><i class='bx bxs-user'></i></span>
											<input type="text" class="form-control border-start-0" id="inputLastName1" placeholder="이름" />
										</div>
									</div>
									<div class="col-md-6">
				
									</div>
									<div class="col-12">
										<label for="inputPhoneNo" class="form-label">전화번호</label>
										<div class="input-group"> <span class="input-group-text bg-transparent"><i class='bx bxs-microphone' ></i></span>
											<input type="text" class="form-control border-start-0" id="inputPhoneNo" placeholder="전화번호" />
										</div>
									</div>
									<div class="col-12">
										<label for="inputEmailAddress" class="form-label">이메일주소</label>
										<div class="input-group"> <span class="input-group-text bg-transparent"><i class='bx bxs-message' ></i></span>
											<input type="text" class="form-control border-start-0" id="inputEmailAddress" placeholder="이메일" />
										</div>
									</div>
									<div class="col-12">
										<label for="inputChoosePassword" class="form-label">비밀번호</label>
										<div class="input-group"> <span class="input-group-text bg-transparent"><i class='bx bxs-lock-open' ></i></span>
											<input type="text" class="form-control border-start-0" id="inputChoosePassword" placeholder="비밀번호" />
										</div>
									</div>
									<div class="col-12">
										<label for="inputConfirmPassword" class="form-label">비밀번호 확인</label>
										<div class="input-group"> <span class="input-group-text bg-transparent"><i class='bx bxs-lock' ></i></span>
											<input type="text" class="form-control border-start-0" id="inputConfirmPassword" placeholder="비밀번호확인" />
										</div>
									</div>

									<div class="col-12">
										<div class="form-check">
											<input class="form-check-input" type="checkbox" id="gridCheck2">
											<label class="form-check-label" for="gridCheck2">체크하기</label>
										</div>
									</div>
									<div class="col-12">
										<button type="submit" class="btn btn-danger px-5">회원가입</button>
									</div>
								</form>
							</div>
						</div>

					</div>
				</div>
				<!--end row-->
				<div class="row">
					<div class="col-xl-9 mx-auto">
						<h6 class="mb-0 text-uppercase">입력양식(수평)</h6>
						<hr/>
						<div class="card border-top border-0 border-4 border-info">
							<div class="card-body">
								<div class="border p-4 rounded">
									<div class="card-title d-flex align-items-center">
										<div><i class="bx bxs-user me-1 font-22 text-info"></i>
										</div>
										<h5 class="mb-0 text-info">회원가입</h5>
									</div>
									<hr/>
									<div class="row mb-3">
										<label for="inputEnterYourName" class="col-sm-3 col-form-label">이름</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="inputEnterYourName" placeholder="이름">
										</div>
									</div>
									<div class="row mb-3">
										<label for="inputPhoneNo2" class="col-sm-3 col-form-label">전화번호</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="inputPhoneNo2" placeholder="전화번호">
										</div>
									</div>
									<div class="row mb-3">
										<label for="inputEmailAddress2" class="col-sm-3 col-form-label">이메일주소</label>
										<div class="col-sm-9">
											<input type="email" class="form-control" id="inputEmailAddress2" placeholder="이메일주소">
										</div>
									</div>
									<div class="row mb-3">
										<label for="inputChoosePassword2" class="col-sm-3 col-form-label">비밀번호</label>
										<div class="col-sm-9">
											<input type="email" class="form-control" id="inputChoosePassword2" placeholder="비밀번호">
										</div>
									</div>
									<div class="row mb-3">
										<label for="inputConfirmPassword2" class="col-sm-3 col-form-label">비밀번호 확인</label>
										<div class="col-sm-9">
											<input type="email" class="form-control" id="inputConfirmPassword2" placeholder="비밀번호 확인">
										</div>
									</div>
	
									<div class="row mb-3">
										<label for="inputAddress4" class="col-sm-3 col-form-label"></label>
										<div class="col-sm-9">
											<div class="form-check">
												<input class="form-check-input" type="checkbox" id="gridCheck4">
												<label class="form-check-label" for="gridCheck4">약관동의?</label>
											</div>
										</div>
									</div>
									<div class="row">
										<label class="col-sm-3 col-form-label"></label>
										<div class="col-sm-9">
											<button type="submit" class="btn btn-info px-5">회원가입</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!--end row-->
			</div>
		</div>
		<!--end page wrapper -->
		<!--start overlay-->
		<div class="overlay toggle-icon"></div>
		<!--end overlay-->
		<!--Start Back To Top Button--> <a href="javaScript:;" class="back-to-top"><i class='bx bxs-up-arrow-alt'></i></a>
		<!--End Back To Top Button-->
		<footer class="page-footer">
			<p class="mb-0">Copyright © 2021. All right reserved.</p>
		</footer>
	</div>
	<!--end wrapper-->

	<!-- Bootstrap JS -->
	<script src="assets/js/bootstrap.bundle.min.js"></script>
	<!--plugins-->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/plugins/simplebar/js/simplebar.min.js"></script>
	<script src="assets/plugins/metismenu/js/metisMenu.min.js"></script>
	<script src="assets/plugins/perfect-scrollbar/js/perfect-scrollbar.js"></script>
	<!--app JS-->
	<script src="assets/js/app.js"></script>
</body>

</html>