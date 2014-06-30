<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<!DOCTYPE html>
<html lang="en-us">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<!--<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">-->
		
		<title> SmartAdmin </title>
		<meta name="description" content="">
		<meta name="author" content="">
		
		<!-- http://davidbcalhoun.com/2010/viewport-metatag -->
		<meta name="HandheldFriendly" content="True">
		<meta name="MobileOptimized" content="320">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		
		<!-- Basic Styles -->
		<link rel="stylesheet" type="text/css" media="screen" href="res/css/bootstrap.min.css">	
		<link rel="stylesheet" type="text/css" media="screen" href="res/css/font-awesome.min.css">

		<!-- SmartAdmin Styles : Please note (smartadmin-production.css) was created using LESS variables -->
		<link rel="stylesheet" type="text/css" media="screen" href="res/css/smartadmin-production.css">
		<link rel="stylesheet" type="text/css" media="screen" href="res/css/smartadmin-skins.css">	
		
		<!-- SmartAdmin RTL Support is under construction
			<link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-rtl.css"> -->
		
		<!-- Demo purpose only: goes with demo.js, you can delete this css when designing your own WebApp -->
<!-- 		<link rel="stylesheet" type="text/css" media="screen" href="res/css/demo.css"> -->
		
		<!-- FAVICONS -->
		<link rel="shortcut icon" href="img/favicon/favicon.ico" type="image/x-icon">
		<link rel="icon" href="img/favicon/favicon.ico" type="image/x-icon">
		
		<!-- GOOGLE FONT -->
<!-- 		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,700italic,300,400,700"> -->
		<style type="text/css">
		body
		{
			font-family:arial, sans-serif，雅黑，黑体;
		}
		</style>
	</head>
	<body class=""> <!-- possible classes: minified, fixed-ribbon, fixed-header, fixed-width-->
		
		<!-- HEADER -->
		<header id="header" height="80px">
			<div id="logo-group">
				<!-- PLACE YOUR LOGO HERE -->
				<span id="logo">
					<img src="res/img/logo.png" alt="SmartAdmin">
				</span>
				<!-- END LOGO PLACEHOLDER -->
				
				<!-- Note: The activity badge color changes when clicked and resets the number to 0 
					 Suggestion: You may want to set a flag when this happens to tick off all checked messages / notifications -->
				<span id="activity" class="activity-dropdown">
					<i class="fa fa-user"></i>
				</span>
			</div>
			
			<!-- projects dropdown -->
<!-- 			<div id="project-context"> -->
<!-- 				<span class="label">Projects:</span> -->
<!-- 				<span id="project-selector" class="popover-trigger-element dropdown-toggle" data-toggle="dropdown">Recent projects <i class="fa fa-angle-down"></i></span> -->
				
<!-- 				Suggestion: populate this list with fetch and push technique -->
<!-- 				<ul class="dropdown-menu"> -->
<!-- 					<li> -->
<!-- 						<a href="javascript:void(0);">Online e-merchant management system - attaching integration with the iOS</a> -->
<!-- 					</li> -->
<!-- 					<li> -->
<!-- 						<a href="javascript:void(0);">Notes on pipeline upgradee</a> -->
<!-- 					</li> -->
<!-- 					<li> -->
<!-- 						<a href="javascript:void(0);">Assesment Report for merchant account</a> -->
<!-- 					</li> -->
<!-- 					<li class="divider"></li> -->
<!-- 					<li> -->
<!-- 						<a href="javascript:void(0);"><i class="fa fa-power-off"></i> Clear</a> -->
<!-- 					</li> -->
<!-- 				</ul> -->
<!-- 				end dropdown-menu -->
<!-- 			</div> -->
			<!-- end projects dropdown -->
			
			<!-- pulled right: nav area -->
			<div class="pull-right">
				<!-- logout button -->
				<div id="logout" class="btn-header transparent pull-right">
					<span>
						<a href="login.html" title="Sign Out"><i class="fa fa-sign-out"></i></a>
					</span>
				</div>
				<!-- end logout button -->
			</div>
			<!-- end pulled right: nav area -->
		</header>
		<!-- END HEADER -->
		
		<!-- Left panel : Navigation area -->
		<!-- Note: This width of the aside area can be adjusted through LESS variables -->
		<aside id="left-panel">
			<!-- NAVIGATION : This navigation is also responsive 
				 
				 To make this navigation dynamic please make sure to link the node 
				 (the reference to the nav > ul) after page load. Or the navigation 
				 will not initialize.
			-->
			<nav>
				<!-- NOTE: Notice the gaps after each icon usage <i></i>.. 
					 Please note that these links work a bit different than
					 traditional hre="" links. See documentation for details.
					-->
				
				<ul>
					<li><a href="/ep"><i class="fa fa-lg fa-fw fa-list-alt"></i><span class="menu-item-parent">主页</span></a>
					</li>
					
					<li><a href="#"><i class="fa fa-lg fa-fw fa-list-alt"></i><span class="menu-item-parent">销售记录管理</span></a>
						<ul>
							<li><a href="singleSalesImport">裸机销售记录导入</a></li>
							<li><a href="contractSalesImport">合约机销售记录导入</a></li>
						</ul>
					</li>
					
					<li><a href="#"><i class="fa fa-lg fa-fw fa-list-alt"></i><span class="menu-item-parent">赠品管理</span></a>
						<ul>
							<li><a href="gift">赠品活动管理</a></li>
							<li><a href="gift">赠品预发放</a></li>
							<li><a href="gift">赠品发放申请</a></li>
						</ul>
					</li>
					
					<li><a href="#"><i class="fa fa-lg fa-fw fa-list-alt"></i><span class="menu-item-parent">原始数据管理</span></a>
						<ul>
							<li><a href="phoneData">手机原始数据导入</a></li>
							<li><a href="agencyData">经销商原始数据导入</a></li>
							<li><a href="phoneData">销售记录查询</a></li>
						</ul>
					</li>
					
					<li><a href="#"><i class="fa fa-lg fa-fw fa-list-alt"></i><span class="menu-item-parent">报表统计</span></a>
						<ul>
							<li><a href="user">报表统计1</a></li>
							<li><a href="role">报表统计2</a></li>
						</ul>
					</li>
					
					<li><a href="#"><i class="fa fa-lg fa-fw fa-list-alt"></i><span class="menu-item-parent">系统日志</span></a>
						<ul>
							<li><a href="user">用户管理</a></li>
							<li><a href="role">角色管理</a></li>
							<li><a href="role">日志管理</a></li>
						</ul>
					</li>
				</ul>
			</nav>
			<span class="minifyme">
				<i class="fa fa-arrow-circle-left hit"></i>
			</span>

			
		</aside>
		<!-- END NAVIGATION -->
		
		<!-- MAIN PANEL -->
		<div id="main" >
			
			<!-- RIBBON -->
			<div id="ribbon">
				<!-- breadcrumb -->
				<ol class="breadcrumb">
					<!-- This is auto generated -->
				</ol>		
				<!-- end breadcrumb -->	
			</div>
			<!-- END RIBBON -->
			
			<!-- MAIN CONTENT -->
			<div id="content">
				<decorator:body></decorator:body>
			</div>
			<!-- END MAIN CONTENT -->				
					
		</div>
		<!-- END MAIN PANEL -->
		
		<div id="g_modal_dialog" title="弹出窗口" style="height:500px; width:500px; display:none;"></div>

		<!--================================================== -->	
		<script src="res/js/libs/jquery-2.0.2.min.js"></script>

		<script src="res/js/libs/jquery-ui-1.10.3.min.js"></script>

		<!-- JS TOUCH : include this plugin for mobile drag / drop touch events 		
		<script src="js/plugin/jquery-touch/jquery.ui.touch-punch.min.js"></script> -->

		<!-- BOOTSTRAP JS -->		
		<script src="res/js/bootstrap/bootstrap.min.js"></script>

		<!-- JARVIS WIDGETS -->
		<script src="res/js/smartwidgets/jarvis.widget.min.js"></script>
		
		<!-- JQUERY VALIDATE -->
		<script src="res/js/plugin/jquery-validate/jquery.validate.min.js"></script>
		
		<!-- JQUERY MASKED INPUT -->
<!-- 		<script src="res/js/plugin/masked-input/jquery.maskedinput.min.js"></script> -->
		
		<!-- JQUERY SELECT2 INPUT -->
		<script src="res/js/plugin/select2/select2.min.js"></script>

		<!-- JQUERY UI + Bootstrap Slider -->
<!-- 		<script src="res/js/plugin/bootstrap-slider/bootstrap-slider.min.js"></script> -->
		
		<!-- browser msie issue fix -->
<!-- 		<script src="res/js/plugin/msie-fix/jquery.mb.browser.min.js"></script> -->
		
		<!-- data tables -->
		<script src="res/js/plugin/datatables/jquery.dataTables-cust.min.js"></script>
		
		<!--[if IE 7]>
			<h1>Your browser is out of date, please update your browser by going to www.microsoft.com/download</h1>
		<![endif]-->
		
		<!-- Demo purpose only -->
		<!-- <script src="res/js/demo.js"></script> -->
		
		<!-- MAIN APP JS FILE -->
		<script src="res/js/myapp.js"></script>
		
		<script>
		function g_OpenModal(title, url)
		{
			var div = $('#g_modal_dialog');
		    if (!div) 
		    {
				alert('网页错误。');
				return;
		    }

		    div.html("");
		    $.ajax({
				url : url,
				type : "GET",
				success : function(returnView) { div.html(returnView); }
		    });
			
			$("#g_modal_dialog").dialog({
				modal: true,
				title: title,
				width: 800,
				resizable: false
			});
			$('#g_modal_dialog').dialog('open');
			return false;
		}
		</script>
	</body>	
	
</html>