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
			<form class="form-horizontal templatemo-container templatemo-login-form-1 margin-bottom-30" role="form" action="#" method="post">
				<div class="form-group">
					<div class="col-xs-12">
						<div class="control-wrapper">
							<label for="username" class="control-label fa-label"><i class="fa fa-user fa-medium"></i></label>
							<input type="text" class="form-control" id="username" placeholder="输入账号">
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-md-12">
						<div class="control-wrapper">
							<label for="password" class="control-label fa-label"><i class="fa fa-lock fa-medium"></i></label>
							<input type="password" class="form-control" id="password" placeholder="输入密码">
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
			<div class="text-center" style="display:none;">
				<a href="create-account.html" class="templatemo-create-new">注册新账户 <i class="fa fa-arrow-circle-o-right"></i></a>
			</div>
		</div>
	</div>
</body>

</html>
