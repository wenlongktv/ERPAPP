<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<form action="user/list" method="get">
	<input type="submit" value="test" />
</form>

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
		</form>
		<footer>
			<button class="btn btn-primary" onclick="searchUser()" >查询</button>
		</footer>
		
	</div>

	<table id="userTable" class="table table-striped table-hover" >
	<thead></thead><tbody></tbody>
	</table>
<script>

function searchUser()
{
	alert($('#userTable').attr('class'));
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
		     		{ "sTitle": "医院代码","mDataProp": "username"},
		 			{ "sTitle": "创建人","mDataProp": "phone"}
		     	]
 });
}
</script>