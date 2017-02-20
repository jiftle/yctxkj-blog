<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>友情链接 - 后台</title>

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
              <li class="active"><i class="fa fa-table"></i>友情链接</li>
              <li class="active"><i class="fa fa-table"></i> 列表</li>
            </ol>
          </div>
        </div><!-- /.row -->

        <!-- 工具栏 -->
        <div class="row">
          <div class="col-lg-12">
            <a href="add">
              <button type="button" class="btn btn-default">
              添加
              </button>
            </a>
            <button type="button" class="btn btn-default" onclick="JavaScript:history.go(-1);">返回</button>
          </div>
        </div><!-- /.row -->

        <div class="row">
          <div class="col-lg-12">
            <div class="table-responsive">
              <table class="table table-hover tablesorter">
                <thead>
                  <tr>
                    <th>id <i class="fa fa-sort"></i></th>
                    <th>名称 <i class="fa fa-sort"></i></th>
                    <th>网址 <i class="fa fa-sort"></i></th>
                    <th>创建时间<i class="fa fa-sort"></i></th>
                    <th>操作 <i class="fa fa-sort"></i></th>
                  </tr>
                </thead>
                <tbody>
                <#list friendLinkList as friendLink>
                  <tr>
                    <td>${friendLink.id}</td>
                    <td>${friendLink.name}</td>
                    <td>${friendLink.url}</td>
                    <td>${friendLink.createDate}</td>
                    <td>
                      <a href="edit?id=${friendLink.id}">[修改]</a>
                      <a href="del?id=${friendLink.id}">[删除]</a>
                    </td>
                  </tr>
                </#list>
                </tbody>
              </table>
            </div>
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
