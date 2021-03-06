<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<header>
	<h2>赠品规则管理 </h2>				
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
							<input type="text" name="fname" placeholder="規則名稱">
						</label>
					</section>
					<section class="col col-6">
						<label class="input"> <i class="icon-prepend fa fa-user"></i>
							<input type="text" name="lname" placeholder="活動">
						</label>
					</section>
				</div>
			</fieldset>
			<footer>
				<a class="btn btn-primary" onclick="searchUser()" >查询</a>
				<a class="btn bg-color-purple txt-color-white" href="#" onclick="g_OpenModal('添加规则', 'gift/adder')">添加规则</a>
			</footer>
		</form>
	</div>

	<table id="giftTable" class="table table-striped table-hover" >
	<thead></thead><tbody></tbody>
	</table>
<script>

function searchUser()
{
	$('#giftTable').dataTable({
//     	"bServerSide": true,
        "bProcessing": true,                           //当datatable获取数据时候是否显示正在处理提示信息。
        "sAjaxSource": "user/list",
        "bDestroy": true,
     	"sAjaxDataProp": "aaData",				       //后台把json数据注入的对象名
     	'bPaginate': true,                             //是否分页。
     	'bFilter': false,                              	//是否使用内置的过滤功能。
     	'bLengthChange': false, 	             	   //是否允许用户自定义每页显示条数(iDisplayLength,default=10)
     	"aoColumns": 
		     	[
		     	    { "sTitle": "id","mDataProp": "id"},
		     		{ "sTitle": "规则名称","mDataProp": "username"},
		 			{ "sTitle": "活动","mDataProp": "phone"},
		     		{ "sTitle": "时间","mDataProp": "phone"},
		     		{ "sTitle": "详细","mDataProp": "phone"}
		     	]
 		});
}
</script>