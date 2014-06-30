<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<header>
	<span class="widget-icon"> <i class="fa fa-edit"></i> </span>
	<h2>Checkout Form </h2>				
</header>
<!-- widget div-->
<div>
	<!-- widget edit box -->
	<div class="jarviswidget-editbox">
		<!-- This area used as dropdown edit box -->
	</div>
	<!-- end widget edit box -->
	
	<!-- widget content -->
	<div class="widget-body no-padding">
		<form id="searchForm" class="smart-form">
			<fieldset>
				<div class="row">
					<section class="col col-6">
						<label class="input"> <i class="icon-prepend fa fa-user"></i>
							<input type="text" name="fname" placeholder="用户名">
						</label>
					</section>
					<section class="col col-6">
						<label class="input"> <i class="icon-prepend fa fa-user"></i>
							<input type="text" name="lname" placeholder="联系电话">
						</label>
					</section>
				</div>
			</fieldset>
			<footer>
				<a class="btn btn-primary" onclick="searchUser()">查询</a>
			</footer>
		</form>
			
	</div>

	<table id="userTable" class="table table-striped table-hover" >
	</table>
<script>

function searchUser()
{
	$('#userTable').html("");
	$('#userTable').dataTable({
    	"bServerSide": true,
        "bProcessing": true,                           //当datatable获取数据时候是否显示正在处理提示信息。
        "sAjaxSource": "/ep/user/list",
        "bDestroy": true,
     	"sAjaxDataProp": "aaData",				       //后台把json数据注入的对象名
     	'bPaginate': true,                             //是否分页。
     	'bFilter': false,                              //是否使用内置的过滤功能。
     	'bLengthChange': false, 	             	       //是否允许用户自定义每页显示条数(iDisplayLength,default=10)
     	"aoColumns":
		     	[
		     	    { "sTitle": "id","mDataProp": "id"},
		     		{ "sTitle": "用户名","mDataProp": "username"},
		 			{ "sTitle": "电话号码","mDataProp": "phone"}
		     	]
 	});
	return false;
}
</script>