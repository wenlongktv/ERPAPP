<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
<head>
<title><decorator:title></decorator:title></title>
<!-- For third-generation iPad with high-resolution Retina display: -->
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="<%=request.getContextPath()%>/resources/iids/components/brandkit/favicon/favicon-144px.png">
<!-- For iPhone with high-resolution Retina display: -->
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="<%=request.getContextPath()%>/resources/iids/components/brandkit/favicon/favicon-114px.png">
<!-- For first- and second-generation iPad: -->
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="<%=request.getContextPath()%>/resources/iids/components/brandkit/favicon/favicon-72px.png">
<!-- For non-Retina iPhone, iPod Touch, and Android 2.1+ devices: -->
<link rel="apple-touch-icon-precomposed" href="<%=request.getContextPath()%>/resources/iids/components/brandkit/favicon/favicon.png">
<!-- css -->
<link href="<%=request.getContextPath()%>/resources/iids/components/prettify/prettify.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/iids/css/iids.css" rel="stylesheet">
<%-- <link href="<%=request.getContextPath()%>/resources/iids/css/responsive.css" rel="stylesheet" type="text/css"> --%>
<link href="<%=request.getContextPath()%>/resources/css/jquery-ui.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/jquery.multiselect.css" rel="stylesheet" type="text/css">
<!-- js -->
<script src="<%=request.getContextPath()%>/resources/iids/components/modernizr/modernizr.js"></script>
<script src="<%=request.getContextPath()%>/resources/iids/components/requirejs/require.js"></script>
<script src="<%=request.getContextPath()%>/resources/iids/js/require.config.js"></script>
<!--  -->
<script type="text/javascript">
//override config.js baseUrl so all future calls
// are relative to this projects' root path to assets
require.config({
	baseUrl : '<%=request.getContextPath()%>/resources/iids/'
});
// require(['iids','collapsible-list']);
require(['collapsible-list']);
</script>

<style>
body {
  background-color: #ffffff;
}
</style>

</head>
<body>
<!-- Top -->
	<div class="navbar navbar-static-top" style="margin:0px">
	    <div class="navbar-inner">
		    <div class="container">
		        <a class="brand" href="${ctx}/usd">
			    <span class="ge-logo"></span>
			    <span>Ultrasound <small><i>powered by</i> GE Healthcare </small></span>
		        </a>
			    <div class="pull-right">
	    	        <div class="btn-toolbar pull-left">
	    	            <div class="btn-group">
	                        <button class="btn btn-inverse dropdown-toggle" data-toggle="dropdown"><i class="icon-user"></i><span class="user-name"><sec:authentication property="name"/></span> <i class="icon-chevron-down"></i></button>
	                        <ul class="dropdown-menu pull-right">
		                        <li><a href="<%=request.getContextPath()%>/j_spring_security_logout">logout</a></li>
		                        <li class="divider"></li>
	                        	<li><a href="<%=request.getContextPath()%>/j_spring_security_logout">切换用户</a></li>
	                        </ul>
	      	            </div>
	    	        </div>
	    	    </div>
		    </div>
		</div>
	</div>

<!-- body -->
	<!-- left -->
	
	<div class="span3" style="margin:0px;">
		<section class="module">
			<div class="accordion">
				<div class="accordion-group">
					<ul class="collapsible-list">
						<li class="collapsible-list-subnav">
						<a class="collapsible-list-parent">注册用户管理</a>
							<ul class="collapsible-list secondary">
								<li><a href="<%=request.getContextPath()%>/cusMgt">注册用户管理</a></li>
							</ul>
						</li>
					</ul>
				</div>
				<div class="accordion-group">
					<ul class="collapsible-list">
						<li class="collapsible-list-subnav">
						<a class="collapsible-list-parent">知识库</a>
							<ul class="collapsible-list secondary">
								<li><a>test page</a></li>
							</ul>
						</li>
					</ul>
				</div>
				<div class="accordion-group">
					<ul class="collapsible-list">
						<li class="collapsible-list-subnav">
						<a class="collapsible-list-parent">消息推送</a>
							<ul class="collapsible-list secondary">
								<li><a href="<%=request.getContextPath()%>/notificationMgt">消息管理</a></li>
							</ul>
						</li>
					</ul>
				</div>
				<div class="accordion-group">
					<ul class="collapsible-list">
						<li class="collapsible-list-subnav">
						<a class="collapsible-list-parent">系统管理</a>
							<ul class="collapsible-list secondary">
								<li><a href="<%=request.getContextPath()%>/user">用户管理</a></li>
								<li><a href="<%=request.getContextPath()%>/role">角色管理</a></li>
								<li><a href="<%=request.getContextPath()%>/resource">资源管理</a></li>
								<li><a href="<%=request.getContextPath()%>/user/password">修改密码</a></li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</section>
	</div>
	
	<!-- right -->
	<div id="div001" class="span11" style="margin:0px">
			<decorator:body></decorator:body>
	</div>

<form:form id="g_deleteByIdForm" method="DELETE">
</form:form>

<!-- 悬浮框 -->
<div id="g_modal" class="modal hide fade" style="display: none;">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal">X</button>
	<h3>M</h3>		
	</div>
	
    <div class="modal-body">
        <!-- body -->
        <section class="module primary-content">
	        <div id="g_infoDialog" class="module-body"></div>
        </section>
    </div>
</div>

<script src="<%=request.getContextPath()%>/resources/js/emobile.js"></script>			
<script src="<%=request.getContextPath()%>/resources/iids/components/respond/respond.src.js"></script>
</body>
</html>
