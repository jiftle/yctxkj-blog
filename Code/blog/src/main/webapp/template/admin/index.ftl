<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>首页 - 管理后台</title>

<#include "include/bootstrap.ftl">

    <!-- Add custom CSS here -->
    <link href="${ctx}/assets/admin/css/sb-admin.css" rel="stylesheet">
    <link rel="stylesheet" href="${ctx}/assets/admin/font-awesome/css/font-awesome.min.css">
  </head>

  <body>

    <div id="wrapper">

      <#include "include/menu.ftl">
      <div id="page-wrapper">

        <div class="row">
          <div class="col-lg-12">
            <ol class="breadcrumb">
              <li class="active"><i class="fa fa-dashboard"></i> 统计概况</li>
            </ol>
          </div>
        </div><!-- /.row -->

        <div class="row">
          <div class="col-lg-12">
            <div class="panel panel-primary">
              <div class="panel-heading">
                <h4 class="panel-title"><i class="fa fa-money"></i> 系统变量</h4>
              </div>
              <div class="panel-body" style="padding: 0px;">
                <div class="table-responsive" >
                  <table class="table table-bordered table-hover table-striped" style="word-break:break-all; word-wrap:break-all;">
                    <thead>
                      <tr>
                        <th>变量名 <i class="fa fa-sort"></i></th>
                        <th>值</th>
                      </tr>
                    </thead>
                    <tbody>
                      <#list systemPro.keySet() as key>
                        <tr>
                          <td style="width:150px;">${key}</td>
                          <td>${systemPro.get(key)}</td>
                        </tr>
                      </#list>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </div><!-- /.row -->

      </div><!-- /#page-wrapper -->

    </div><!-- /#wrapper -->



    <!-- Page Specific Plugins -->
    <script src="${ctx}/assets/admin/js/raphael-min.js"></script>
    <script src="${ctx}/assets/admin/js/morris/chart-data-morris.js"></script>
    <script src="${ctx}/assets/admin/js/tablesorter/jquery.tablesorter.js"></script>
    <script src="${ctx}/assets/admin/js/tablesorter/tables.js"></script>

  </body>
</html>
