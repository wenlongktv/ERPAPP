<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>信息系统模板</title>

    <!-- Bootstrap -->
    <link href="assets/default/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/default/datatable/css/jquery.dataTables.min.css" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
	<script src="assets/default/jquery-1.11.1.min.js"></script>
	<style type="text/css">
		body{font-family:  Hiragino Sans GB, Microsoft Yahei}
	</style>
  </head>
<body>
<div class="modal fade bs-example-modal-lg" id="gModalDialg" tabindex="-1" role="dialog"  aria-labelledby="gModalLabel" aria-hidden="true">
</div>

<div class="container-fluid">
<div class="row">
<div class="page-header">
  <h1>信息系统的模板 <small>副标题</small></h1>
</div></div>

<div class="row">

<div class="panel-group col-md-2" id="sidebar">
    <div class="panel">
    <a class='btn' data-toggle="collapse" data-parent="#sidebar" href="#collapse1"><h3>菜单一</h3></a>
    <div id="collapse1" class="collapse">
      	<ul class="nav nav-pills nav-stacked">
				<li><a data-toggle="tab" href="#">HTML5</a></li>
				<li><a data-toggle="tab" href="#">PHP</a></li>
				<li><a data-toggle="tab" href="#">MySQL</a></li>
				<li><a data-toggle="tab" href="#">JavaScript</a></li>
			</ul>
    </div>
  </div>
  <div class="panel">
    <a class='btn' data-toggle="collapse" data-parent="#sidebar" href="#collapse2"><h3>菜单2</h3></a>	        
    <div id="collapse2" class="collapse">
      	<ul class="nav nav-pills nav-stacked">
				<li><a data-toggle="tab" href="#">HTML5</a></li>
				<li><a data-toggle="tab" href="#">PHP</a></li>
				<li><a data-toggle="tab" href="#">MySQL</a></li>
				<li><a data-toggle="tab" href="#">JavaScript</a></li>
			</ul>
    </div>
  </div>
  <div class="panel">
    <a class='btn' data-toggle="collapse" data-parent="#sidebar" href="#collapse3"><h3>系统管理</h3></a>	        
    <div id="collapse3" class="	">
      	<ul class="nav nav-pills nav-stacked">
				<li><a href="sysUser">用户管理</a></li>
				<li><a href="sysRole">权限管理</a></li>
				<li><a href="sysResource">资源管理</a></li>
			</ul>
    </div>
  </div>
</div>


<div class="col-md-10">
	<decorator:body></decorator:body>		 
</div>

</div>
</div>
<script src="assets/default/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/default/datatable/js/jquery.dataTables.min.js"></script>
<script src="assets/default/myapp.js"></script>
<script>
$(function(){
	$('#sidebar li a').each(function(){
		if ("/emmobile/" + $(this).attr("href") == window.location.pathname)
		{
			$(this).parent().attr('class', 'active');
			$(this).parent().parent().parent().collapse()
		}
	});
});
</script>
</body>
</html>
