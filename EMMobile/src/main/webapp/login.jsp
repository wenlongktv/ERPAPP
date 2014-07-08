<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en-us">
	<head>
		<meta charset="utf-8">
		<title> 登陆 </title>
		<meta name="description" content="">
		<meta name="author" content="">
		<!-- http://davidbcalhoun.com/2010/viewport-metatag -->
		<meta name="HandheldFriendly" content="True">
		<meta name="MobileOptimized" content="320">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<!-- Basic Styles -->
		<link rel="stylesheet" type="text/css" media="screen" href="res/css/bootstrap.min.css">	

		<!-- SmartAdmin Styles : Please note (smartadmin-production.css) was created using LESS variables -->
		<link rel="stylesheet" type="text/css" media="screen" href="res/css/smartadmin-production.css">
		<link rel="stylesheet" type="text/css" media="screen" href="res/css/smartadmin-skins.css">	
	</head>
	<body id="login">
		<div style="height:130px; border:1px solid ">
		<header id="header">
			<div style="height:120px; border:1px solid #F00"> sssd</div>
			<span id="login-header-space"> <a href="register.html" class="btn btn-danger">Creat account</a> </span>
		</header>
		</div>	
		<div id="main" role="main">
			<!-- MAIN CONTENT -->
			<div id="content" class="container">
				<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-7 col-lg-8 hidden-xs hidden-sm">
						<h1 class="txt-color-red login-header-big">SmartAdmin</h1>
						<div class="hero">

							<div class="pull-left login-desc-box-l">
								<h4 class="paragraph-header">It's Okay to be Smart. Experience the simplicity of SmartAdmin, everywhere you go!</h4>
								<div class="login-app-icons">
									<a href="javascript:void(0);" class="btn btn-danger btn-sm">Frontend Template</a>
									<a href="javascript:void(0);" class="btn btn-danger btn-sm">Find out more</a>
								</div>
							</div>
							<img src="res/img/demo/iphoneview.png" class="pull-right display-image" width="210px">
						</div>
					</div>
					<div class="col-xs-12 col-sm-12 col-md-5 col-lg-4">
						<div class="well no-padding">
							<form action="<%=request.getContextPath() %>/j_spring_security_check" id="login-form" class="smart-form client-form" method='post'>
								<header>登陆</header>
								<fieldset>
									<section>
										<label class="label">E-mail</label>
										<label class="input"> <i class="icon-append fa fa-user"></i>
											<input type="text" name="j_username">
											<b class="tooltip tooltip-top-right"><i class="fa fa-user txt-color-teal"></i> Please enter email address/username</b></label>
									</section>
									<section>
										<label class="label">Password</label>
										<label class="input"> <i class="icon-append fa fa-lock"></i>
											<input type="password" name="j_password">
											<b class="tooltip tooltip-top-right"><i class="fa fa-lock txt-color-teal"></i> Enter your password</b> </label>
										<div class="note">
											<a href="javascript:void(0)">Forgot password?</a>
										</div>
									</section>
									<section>
										<label class="checkbox">
											<input type="checkbox" name="remember" checked="">
											<i></i>Stay signed in</label>
									</section>
								</fieldset>
								<footer>
									<input type="submit" class="btn btn-primary" value='登 陆' />
								</footer>
							</form>
						</div>
					</div>
				</div>
			</div>

		<!--================================================== -->	

		<!-- PACE LOADER -->
		<script data-pace-options='{ "restartOnRequestAfter": true }' src="res/js/plugin/pace/pace.min.js"></script>

	    <!-- Link to Google CDN's jQuery + jQueryUI; fall back to local -->
	    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
		<script> if (!window.jQuery) { document.write('<script src="res/js/libs/jquery-2.0.2.min.js"><\/script>');} </script>

	    <script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
		<script> if (!window.jQuery.ui) { document.write('<script src="res/js/libs/jquery-ui-1.10.3.min.js"><\/script>');} </script>

		<!-- BOOTSTRAP JS -->		
		<script src="res/js/bootstrap/bootstrap.min.js"></script>

		<!-- CUSTOM NOTIFICATION -->
		<script src="res/js/notification/SmartNotification.min.js"></script>

		<!-- JARVIS WIDGETS -->
		<script src="res/js/smartwidgets/jarvis.widget.min.js"></script>
		
		<!-- EASY PIE CHARTS -->
		<script src="res/js/plugin/easy-pie-chart/jquery.easy-pie-chart.min.js"></script>
		
		<!-- SPARKLINES -->
		<script src="res/js/plugin/sparkline/jquery.sparkline.min.js"></script>
		
		<!-- JQUERY VALIDATE -->
		<script src="res/js/plugin/jquery-validate/jquery.validate.min.js"></script>
		
		<!-- JQUERY MASKED INPUT -->
		<script src="res/js/plugin/masked-input/jquery.maskedinput.min.js"></script>
		
		<!-- JQUERY SELECT2 INPUT -->
		<script src="res/js/plugin/select2/select2.min.js"></script>

		<!-- JQUERY UI + Bootstrap Slider -->
		<script src="res/js/plugin/bootstrap-slider/bootstrap-slider.min.js"></script>
		
		<!-- browser msie issue fix -->
		<script src="res/js/plugin/msie-fix/jquery.mb.browser.min.js"></script>
		
		<!--[if IE 7]>
			
			<h1>Your browser is out of date, please update your browser by going to www.microsoft.com/download</h1>
			
		<![endif]-->

		<!-- MAIN APP JS FILE -->
		<script src="res/js/app.js"></script>

		<script type="text/javascript">
			runAllForms();

			$(function() {
				// Validation
// 				$("#login-form").validate({
// 					// Rules for form validation
// 					rules : {
// 						email : {
// 							required : true,
// 							email : true
// 						},
// 						password : {
// 							required : true,
// 							minlength : 3,
// 							maxlength : 20
// 						}
// 					},

// 					// Messages for form validation
// 					messages : {
// 						email : {
// 							required : 'Please enter your email address',
// 							email : 'Please enter a VALID email address'
// 						},
// 						password : {
// 							required : 'Please enter your password'
// 						}
// 					},

// 					// Do not change code below
// 					errorPlacement : function(error, element) {
// 						error.insertAfter(element.parent());
// 					}
// 				});
			});
		</script>

	</body>
</html>