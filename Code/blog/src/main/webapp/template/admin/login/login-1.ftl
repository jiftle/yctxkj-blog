<!DOCTYPE html>

<head>
	<title>登录</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<link href="${ctx}/assets/admin/login/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="${ctx}/assets/admin/login/css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="${ctx}/assets/admin/login/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
	<link href="${ctx}/assets/admin/login/css/templatemo_style.css" rel="stylesheet" type="text/css">
</head>

<body class="templatemo-bg-gray">
	<div class="container">
		<div class="col-md-12">
			<h1 class="margin-bottom-15">登录</h1>
			<form id="loginForm" class="form-horizontal templatemo-container templatemo-login-form-1 margin-bottom-30" role="form" action="${ctx}/admin/login/submit" method="post">
				<div class="form-group">
					<div class="col-xs-12">
						<div class="control-wrapper">
							<label for="username" class="control-label fa-label"><i class="fa fa-user fa-medium"></i></label>
							<input type="text" class="form-control" id="username" name="username" placeholder="输入账号">
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-md-12">
						<div class="control-wrapper">
							<label for="password" class="control-label fa-label"><i class="fa fa-lock fa-medium"></i></label>
							<input type="password" class="form-control" id="password" name="pwd" placeholder="输入密码">
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-md-12">
						<div class="control-wrapper">
							<label for="captcha" class="control-label fa-label"><i class="fa fa-qrcode fa-medium"></i></label>
							<div class="input-group">
								<input type="text" style="height:50px;" class="form-control" id="captcha" name="captcha" placeholder="请输入验证码">
	 						 	<span class="input-group-addon" style="height:50px;padding:1px 1px;">
									<img style="height:46px;" id="captchaimg" src="${ctx}/admin/admin/captcha_img">
								</span>
							</div>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-md-12">
						<div class="checkbox control-wrapper">
							<label>
	            	<input type="checkbox"> 记住密码
              </label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-md-12">
						<div class="control-wrapper">
							<input type="submit" value="登录" class="btn btn-info btn-block">
							<a href="forgot-password.html" class="text-right pull-right" style="display:none;">忘记密码?</a>
						</div>
					</div>
				</div>
				<hr style="display:none;">
				<div class="form-group" style="display:none;">
					<div class="col-md-12">
						<label>Login with: </label>
						<div class="inline-block">
							<a href="#"><i class="fa fa-facebook-square login-with"></i></a>
							<a href="#"><i class="fa fa-twitter-square login-with"></i></a>
							<a href="#"><i class="fa fa-google-plus-square login-with"></i></a>
							<a href="#"><i class="fa fa-tumblr-square login-with"></i></a>
							<a href="#"><i class="fa fa-github-square login-with"></i></a>
						</div>
					</div>
				</div>
			</form>
			<div class="text-center" style="display:block;">
				<a href="${ctx}/admin/admin/register" class="templatemo-create-new">注册新账户 <i class="fa fa-arrow-circle-o-right"></i></a>
			</div>
		</div>
	</div>



<!-- 引入js脚本  -->
<script src="${ctx}/assets/admin/login/js/jquery-1.11.1.min.js"></script>
<script src="${ctx}/assets/admin/login/js/bootstrap.min.js"></script>
<script src="${ctx}/assets/layer/3.0.1/layer.js"></script>
<script src="${ctx}/assets/js/jquery/plugins/jquery.validate/1.15.0/jquery.validate.min.js"></script>

<script>
$(document).ready(function(){

	$loginForm = $("#loginForm");

	$loginForm.validate({
		 debug:true,
     rules: {
       username: {
         required: true,
         minlength: 4
       },
       pwd: {
         required: true,
         minlength: 6
       },
			 captcha:{
				 required: true,
				 minlength: 4
			 }
     },
		 messages: {
       username: {
         required: "请输入用户名",
         minlength: "用户名必需由4个字母组成"
       },
       pwd: {
         required: "请输入密码",
         minlength: "密码长度不能小于6个字母"
       },
			 captcha:{
				 required: "请输入验证码",
				 minlength: "请完整输入"
			 }
		 },
		submitHandler:function(form){
			$.ajax({
					url: $loginForm.attr("action"),
					type: "post",
					data: $loginForm.serialize(),
					dataType: "json",
					success: function(result,status,xhr){
						console.log(result);
						layer.msg(result.msg);

						location.href="${ctx}/admin/index";
					},
					error: function(xhr){
						console.log(xhr);
						layer.msg(xhr.status + " " + xhr.statusText);
					}
			});
    }
 });

});
</script>

</body>

</html>
