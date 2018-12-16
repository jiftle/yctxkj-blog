<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>分类管理 - 后台</title>

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
              <li class="active"><i class="fa fa-table"></i> 分类管理</li>
              <li class="active"><i class="fa fa-table"></i> 修改分类</li>
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
            <form role="form" action="${ctx}/admin/category/update">
              <div class="form-group">
      					 <label for="categoryid">编号</label>
                 <input type="text" class="form-control" id="categoryid" name="id" value="${articleCategory.id}" readonly />
      				</div>
      				<div class="form-group">
      					 <label for="categoryname">分类名称</label>
                 <input type="text" class="form-control" id="categoryname" name="name" value="${articleCategory.name}" />
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
