<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<header>
	<h2>用户管理 </h2>				
</header>
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
			<a class="btn btn-primary" onclick="searchUser()">查询用户</a>
		</footer>
	</form>
	<div class="widget-body">
		<table id="userTable" class="table table-striped table-hover" >
		<thead><tr><th>ID</th></tr>
		  <tr><th>用戶名</th></tr>
		</thead>
		<tbody></tbody>
		</table>
	</div>
</div>

<script>

function searchUser()
{
// 	$('#userTable').html("");
// 	$('#userTable').dataTable({
//     	"bServerSide": true,
//         "bProcessing": true,                           //当datatable获取数据时候是否显示正在处理提示信息。
//         "sAjaxSource": "user/list",
//         "bDestroy": true,
//      	"sAjaxDataProp": "aaData",				       //后台把json数据注入的对象名
//      	'bPaginate': true,                             //是否分页。
//      	'bFilter': false,                              //是否使用内置的过滤功能。
//      	'bLengthChange': false, 	             	       //是否允许用户自定义每页显示条数(iDisplayLength,default=10)
//      	"aoColumns":
// 		     	[
// 		     	    { "sTitle": "id","mDataProp": "id"},
// 		     		{ "sTitle": "用户名","mDataProp": "username"},
// 		 			{ "sTitle": "电话号码","mDataProp": "phone"}
// 		     	]
//  	});
	var data = loadJson("user/list", fillDataTable);
	return false;
}

function fillDataTable(data)
{
	alert( JSON.stringify(data.aaData));
	$('#userTable').DataTable( {
		"bProcessing": true,
		"bDestroy": true,
		'bLengthChange': false,
	    data: data.aaData,
	    columns: [
					{ data: 'id' },
			        { data: 'username' },
			        { data: 'password' },
			        { data: 'email' },
			        { data: 'phone' }
			    ]   
		} );
}
</script>