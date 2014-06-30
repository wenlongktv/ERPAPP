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
		<form action="" id="checkout-form" class="smart-form" novalidate="novalidate">
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

				<div class="row">
					<section class="col col-6">
						<label class="input"> <i class="icon-prepend fa fa-envelope-o"></i>
							<input type="email" name="password" placeholder="密码">
						</label>
					</section>
					<section class="col col-6">
						<label class="input"> <i class="icon-prepend fa fa-phone"></i>
							<input type="tel" name="confirmPwd" placeholder="确认密码" data-mask="(999) 999-9999">
						</label>
					</section>
				</div>
			</fieldset>

			<fieldset>
				<div class="row">
					<section class="col col-5">
						<label class="select">
							<select name="country">
								<option value="0" selected="" disabled="">角色</option>
								<option value="1">管理员</option>
								<option value="2">经销商</option>
								<option value="3">终端</option>
							</select> <i></i> </label>
					</section>

					<section class="col col-4">
						<label class="input">
							<input type="text" name="city" placeholder="City">
						</label>
					</section>

					<section class="col col-3">
						<label class="input">
							<input type="text" name="code" placeholder="Post code">
						</label>
					</section>
				</div>

				<section>
					<label for="address" class="input">
						<input type="text" name="address" placeholder="Address">
					</label>
				</section>

				<section>
					<label class="textarea"> 										
						<textarea rows="3" name="info" placeholder="Additional info"></textarea> 
					</label>
				</section>
			</fieldset>

			<fieldset>
				<section>
					<div class="inline-group">
						<label class="radio">
							<input type="radio" name="radio-inline" checked="">
							<i></i>Visa</label>
						<label class="radio">
							<input type="radio" name="radio-inline">
							<i></i>MasterCard</label>
						<label class="radio">
							<input type="radio" name="radio-inline">
							<i></i>American Express</label>
					</div>
				</section>

				<section>
					<label class="input">
						<input type="text" name="name" placeholder="Name on card">
					</label>
				</section>

				<div class="row">
					<section class="col col-10">
						<label class="input">
							<input type="text" name="card" placeholder="Card number" data-mask="9999-9999-9999-9999">
						</label>
							</section>
							<section class="col col-2">
								<label class="input">
									<input type="text" name="cvv" placeholder="CVV2" data-mask="999">
								</label>
							</section>
						</div>

						<div class="row">
							<label class="label col col-4">Expiration date</label>
							<section class="col col-5">
								<label class="select">
									<select name="month">
										<option value="0" selected="" disabled="">Month</option>
										<option value="1">January</option>
										<option value="1">February</option>
										<option value="3">March</option>
										<option value="4">April</option>
										<option value="5">May</option>
										<option value="6">June</option>
										<option value="7">July</option>
										<option value="8">August</option>
										<option value="9">September</option>
										<option value="10">October</option>
										<option value="11">November</option>
										<option value="12">December</option>
									</select> <i></i> </label>
							</section>
							<section class="col col-3">
								<label class="input">
									<input type="text" name="year" placeholder="Year" data-mask="2099">
								</label>
							</section>
						</div>
					</fieldset>

					<footer>
						<button type="submit" class="btn btn-primary">
							Validate Form
						</button>
					</footer>
				</form>

			</div>
			<!-- end widget content -->