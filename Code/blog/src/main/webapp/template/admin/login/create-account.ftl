<!DOCTYPE html>
<head>
	<title>注册管理员账号</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<link href="${ctx}/assets/admin/login/css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="${ctx}/assets/admin/login/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
	<link href="${ctx}/assets/admin/login/css/templatemo_style.css" rel="stylesheet" type="text/css">
</head>
<body class="templatemo-bg-gray">
	<h1 class="margin-bottom-15">注册管理员账号</h1>
	<div class="container">
		<div class="col-md-12">
			<form class="form-horizontal templatemo-create-account templatemo-container" role="form" action="${ctx}/admin/admin/submit" method="post">
				<div class="form-inner">
							<div class="form-group">
			          <div class="col-md-12">
			            <label for="username" class="control-label">账号</label>
			            <input type="text" class="form-control" id="username" name="username" placeholder="">
			          </div>
			        </div>
			        <div class="form-group">
			          <div class="col-md-12">
			            <label for="email" class="control-label">邮箱</label>
			            <input type="email" class="form-control" id="email" name="email" placeholder="">
			          </div>
			        </div>
			        <div class="form-group">
			          <div class="col-md-12">
			            <label for="nickname" class="control-label">昵称</label>
			            <input type="text" class="form-control" id="nickname" name="nickname" placeholder="">
			          </div>
			        </div>
			        <div class="form-group">
			          <div class="col-md-6">
			            <label for="pwd" class="control-label">密码</label>
			            <input type="password" class="form-control" id="pwd" name="pwd" placeholder="">
			          </div>
			          <div class="col-md-6">
			            <label for="repwd" class="control-label">确认密码</label>
			            <input type="repwd" class="form-control" id="repwd" name="repwd" placeholder="">
			          </div>
			        </div>
							<div class="form-group">
			          <div class="col-md-12">
									<label for="captcha" class="control-label">验证码</label>
									 <input type="text" class="form-control" style="width:150px;" id="captcha" name="captcha" placeholder="请输入验证码">
									 <img class="vcode" id="captchaimg" src="${ctx}/admin/admin/captcha_img">
			          </div>
			        </div>
			        <div class="form-group">
			          <div class="col-md-12">
			            <label><input type="checkbox">我同意 <a href="javascript:;" data-toggle="modal" data-target="#templatemo_modal">注册协议</a> and <a href="#">用户隐私保护条款.</a></label>
			          </div>
			        </div>
			        <div class="form-group">
			          <div class="col-md-12">
			            <input type="submit" value="确认创建账号" class="btn btn-info">
			            <a href="${ctx}/admin/login" class="pull-right">登录</a>
			          </div>
			        </div>
				</div>
		      </form>
		</div>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="templatemo_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
	        <h4 class="modal-title" id="myModalLabel">Terms of Service</h4>
	      </div>
	      <div class="modal-body">
	      	<p>This form is provided by <a rel="nofollow" href="http://www.cssmoban.com/page/1">Free HTML5 Templates</a> that can be used for your websites. Cras mattis consectetur purus sit amet fermentum. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Morbi leo risus, porta ac consectetur ac, vestibulum at eros.</p>
	        <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur et. Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor. Aenean lacinia bibendum nulla sed consectetur. Praesent commodo cursus magna, vel scelerisque nisl consectetur et. Donec sed odio dui. Donec ullamcorper nulla non metus auctor fringilla. Cras mattis consectetur purus sit amet fermentum. Cras justo odio, dapibus ac facilisis in, egestas eget quam.</p>
	        <p>Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Praesent commodo cursus magna, vel scelerisque nisl consectetur et. Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor.</p>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	      </div>
	    </div>
	  </div>
	</div>
	<script type="text/javascript" src="${ctx}/assets/admin/login/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="${ctx}/assets/admin/login/js/bootstrap.min.js"></script>
</body>
</html>
