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
              <li class="active"><i class="fa fa-table"></i> 列表</li>
            </ol>
          </div>
        </div><!-- /.row -->

        <!-- 工具栏 -->
        <div class="row">
          <div class="col-lg-12">
            <a href="add">
              <button type="button" class="btn btn-default">
              添加文章
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
                    <th>内容 <i class="fa fa-sort"></i></th>
                    <th>创建时间<i class="fa fa-sort"></i></th>
                    <th>修改时间 <i class="fa fa-sort"></i></th>
                    <th>操作 <i class="fa fa-sort"></i></th>
                  </tr>
                </thead>
                <tbody>
                <#list page.list as article>
                  <tr>
                    <td>${article.id}</td>
                    <td>
                      <a href="${ctx}/article?id=${article.id}" target="_blank">
                      <#if article.title?length lt 20>
                        ${(article.title)?default("")}
                      <#else>
                        ${article.title?substring(0,20)} ...
                      </#if>
                      </a>
                    </td>
                    <td>
                      <#if article.content?length lt 50>
                        ${article.content?html}
                      <#else>
                        ${(article.content?html)?substring(0,50)} ...
                      </#if>
                    </td>
                    <td>${article.createDate}</td>
                    <td>${article.modifyDate}</td>
                    <td><a href="edit?id=${article.id}">[修改]</a>&nbsp;
                      <a href="del?id=${article.id}">[删除]</a></td>
                  </tr>
                </#list>
                </tbody>
              </table>
            </div>
          </div>

        </div><!-- /.row -->

        <div class="row">
          <div class="col-md-4">
            <strong>共${page.totalPage}页，${page.totalRow}条记录，当前第${page.pageNumber}页</strong>
          </div>
          <div class="col-md-8">
                <ul class="pagination pull-right" style="margin:0px 0px;">
                  <li>
                  <a href="#" onclick="prePage();">上一页</a>
                  </li>
                  <li>
                  <a href="#">1</a>
                  </li>
                  <li>
                  <a href="#">2</a>
                  </li>
                  <li>
                  <a href="#">3</a>
                  </li>
                  <li>
                  <a href="#" onclick="nextPage();">后一页</a>
                  </li>
                </ul>
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
<script>

function prePage(){
  var pageNumber = ${page.pageNumber};
  pageNumber = pageNumber -1;
  location.href="${ctx}/admin/article/list?pageNumber=" + pageNumber;
}

function nextPage(){
  var pageNumber = ${page.pageNumber};
  pageNumber = pageNumber + 1;
  location.href="${ctx}/admin/article/list?pageNumber=" + pageNumber;
}

</script>

  </body>
</html>
