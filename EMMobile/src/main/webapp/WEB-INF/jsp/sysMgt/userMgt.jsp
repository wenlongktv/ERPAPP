<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<button class='btn btn-primary btn-lg' data-toggle="collapse" data-target="#form"><span class="glyphicon glyphicon-search"></span> 查找用户 </button>
<button class='btn btn-primary btn-lg' onclick="addUser()"><span class="glyphicon glyphicon-plus"></span> 新增用户 </button>

<div class="panel">
  <div id='form' class="panel-body collapse">
    <form id="searchForm" role="form">
	<div class="row">
		  <div class='col-md-6'><div class="input-group">
		  	<span class="input-group-addon">用户名</span>
		     <input type="text" class="form-control" id="firstname" placeholder="搜索名字" />
		  </div></div>
		  <div class='col-md-6'><div class="col-md-6 input-group">
		  	<span class="input-group-addon">电话号码</span>
		    <input type="text" class="form-control" id="firstname" placeholder="搜索电话号码" />
		  </div></div>
	</div>
	</form>
	<div class='panel-body'><button id='search' class='btn btn-default' onclick="search()">
		<span class="glyphicon glyphicon-search"></span> 查 找 </button>
	</div>
  </div>
   
</div>

<!-- <div id="form" class="collapse in"> -->
<!-- <form id="searchForm" role="form"> -->
<!-- 	<div class="row"> -->
<!-- 		<div class="form-group"> -->
<!-- 		  <label for="firstname" class="col-md-1 control-label">用户名</label> -->
<!-- 		  <div class="col-md-5"> -->
<!-- 		     <input type="text" class="form-control" id="firstname" placeholder="搜索名字"> -->
<!-- 		  </div> -->
<!-- 		  <label for="firstname" class="col-md-1 control-label">电话号码</label> -->
<!-- 		  <div class="col-md-5"> -->
<!-- 		     <input type="text" class="form-control" id="firstname" placeholder="搜索电话号码"> -->
<!-- 		  </div> -->
<!-- 		</div> -->
<!-- 	</div> -->
<!-- </form> -->
<!-- <button id='search' class='btn btn-primary' onclick="search()">查找</button> -->
<!-- </div> -->

<div class="panel">
<table id="userTable" class="table table-striped table-hover">
	<thead><tr>
	<th>ID</th>
	<th>用戶名</th>
	<th>电话号码</th>
	<th>E-mail</th>
	</tr></thead>
	<tbody></tbody>
</table>
</div>

<script>
function search()
{
	_loadJsonObj('sysUser/ajax/list',fillDataTable);
}

function addUser()
{
	_loadAjaxPage("sysUser/ajax?action=add");
}


function fillDataTable(data)
{
// 	alert(JSON.stringify(data));	
	$('#userTable').DataTable({
		"autoWidth": false,
		"bProcessing": true,
		"bDestroy": true,
		'bLengthChange': false,
	    data: data.aaData,
	    columns: [
					{ data: 'id' },
			        { data: 'username' },
			        { data: 'email' },
			        { data: 'phone' }
			    ],
		language: dataTableLanguage
	});
}

</script>