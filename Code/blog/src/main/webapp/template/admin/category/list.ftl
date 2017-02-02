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


      <!-- Sidebar -->
      <div id="page-wrapper">

        <div class="row">
          <div class="col-lg-12">
            <ol class="breadcrumb">
              <li class="active"><i class="fa fa-table"></i> 分类管理</li>
            </ol>
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
                    <th>创建时间<i class="fa fa-sort"></i></th>
                    <th>修改时间 <i class="fa fa-sort"></i></th>
                  </tr>
                </thead>
                <tbody>
                <#list list as articleCategory>
                  <tr>
                    <td>${articleCategory.id}</td>
                    <td>${articleCategory.name}</td>
                    <td>${articleCategory.createDate}</td>
                    <td>${articleCategory.modifyDate}</td>
                  </tr>
                </#list>
                </tbody>
              </table>
            </div>
          </div>

        </div><!-- /.row -->




      </div><!-- /#page-wrapper -->


    <!-- JavaScript -->
    <script src="${ctx}/assets/admin/js/jquery-1.10.2.js"></script>
    <script src="${ctx}/assets/admin/js/bootstrap.js"></script>

    <!-- Page Specific Plugins -->
    <script src="${ctx}/assets/admin/js/tablesorter/jquery.tablesorter.js"></script>
    <script src="${ctx}/assets/admin/js/tablesorter/tables.js"></script>

  </body>
</html>
