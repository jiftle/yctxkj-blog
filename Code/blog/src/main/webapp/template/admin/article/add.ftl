<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>文章管理 - 后台</title>

    <!-- Bootstrap core CSS -->
    <link href="${ctx}/assets/admin/css/bootstrap.css" rel="stylesheet">

    <!-- Add custom CSS here -->
    <link href="${ctx}/assets/admin/css/sb-admin.css" rel="stylesheet">
    <link rel="stylesheet" href="${ctx}/assets/admin/font-awesome/css/font-awesome.min.css">
  </head>

  <body>

    <div id="wrapper">

      <#include "../include/menu.ftl">

      <!-- Sidebar -->
      <div id="page-wrapper">

        <div class="row">
          <div class="col-lg-12">
            <ol class="breadcrumb">
              <li class="active"><i class="fa fa-table"></i> 文章管理</li>
              <li class="active"><i class="fa fa-table"></i> 新增文章</li>
            </ol>
          </div>
        </div><!-- /.row -->

        <!-- 工具栏 -->
        <div class="row">
          <div class="col-lg-12">
            <div class="btn-group">
                <button type="button" class="btn btn-default" onclick="JavaScript:history.go(-1);">返回</button>
            </div>
          </div>
        </div><!-- /.row -->

        <div class="row">
          <div class="col-lg-12">
            <form role="form" action="${ctx}/admin/article/save">
      				<div class="form-group">
      					 <label for="title">标题</label>
                 <input type="text" class="form-control" id="title" name="title" placeholder="输入标题" />
      				</div>
              <div class="form-group">
      					 <label for="content">内容</label>
                 <input type="text" class="form-control" id="content" name="content" placeholder="输入内容" />
      				</div>

      				 <button type="submit" class="btn btn-default" >提交</button>
      			</form>
          </div>

        </div><!-- /.row -->




      </div><!-- /#page-wrapper -->

    </div><!-- /#wrapper -->

    <!-- JavaScript -->
    <script src="${ctx}/assets/admin/js/jquery-1.10.2.js"></script>
    <script src="${ctx}/assets/admin/js/bootstrap.js"></script>

    <!-- Page Specific Plugins -->
    <script src="${ctx}/assets/admin/js/tablesorter/jquery.tablesorter.js"></script>
    <script src="${ctx}/assets/admin/js/tablesorter/tables.js"></script>

  </body>
</html>
