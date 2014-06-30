<meta name="decorator" content='/WEB-INF/decorator/noDecorator.jsp' />
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!-- widget content -->
<div class="widget-body">
	<form id="addGiftForm" class="smart-form">
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
			<div class="row">
				<section class="col col-6">
					<label class="input"> <i class="icon-prepend fa fa-user"></i>
						<input type="text" name="fname" placeholder="比例">
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
			<a class="btn btn-primary" >取消</a>
			<a class="btn bg-color-purple txt-color-white">确定</a>
		</footer>
	</form>
</div>