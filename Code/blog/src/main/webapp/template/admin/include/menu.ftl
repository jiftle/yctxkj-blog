<!-- Sidebar -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
  <!-- Brand and toggle get grouped for better mobile display -->
  <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
      <span class="sr-only">Toggle navigation</span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="index">管理后台</a>
  </div>

  <!-- Collect the nav links, forms, and other content for toggling -->
  <div class="collapse navbar-collapse navbar-ex1-collapse">
    <ul class="nav navbar-nav side-nav">
      <li class="active"><a href="${ctx}/admin/index"><i class="fa fa-dashboard"></i> 消息中心</a></li>
      <li><a href="${ctx}/admin/category/list"><i class="fa fa-table"></i> 分类管理</a></li>
      <li><a href="${ctx}/admin/article/list"><i class="fa fa-table"></i> 文章管理</a></li>

      <li><a href="${ctx}/admin/charts"><i class="fa fa-bar-chart-o"></i> Charts</a></li>
      <li><a href="${ctx}/admin/tables"><i class="fa fa-table"></i> Tables</a></li>
      <li><a href="${ctx}/admin/forms"><i class="fa fa-edit"></i> Forms</a></li>
      <li><a href="${ctx}/admin/typography"><i class="fa fa-font"></i> Typography</a></li>
      <li><a href="${ctx}/admin/bootstrap-elements"><i class="fa fa-desktop"></i> Bootstrap Elements</a></li>
      <li><a href="${ctx}/admin/bootstrap-grid"><i class="fa fa-wrench"></i> Bootstrap Grid</a></li>
      <li><a href="${ctx}/admin/blank-page"><i class="fa fa-file"></i> Blank Page</a></li>
      <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-caret-square-o-down"></i> Dropdown <b class="caret"></b></a>
        <ul class="dropdown-menu">
          <li><a href="#">Dropdown Item</a></li>
          <li><a href="#">Another Item</a></li>
          <li><a href="#">Third Item</a></li>
          <li><a href="#">Last Item</a></li>
        </ul>
      </li>
    </ul>
<#include "menu_head.ftl">

  </div><!-- /.navbar-collapse -->
</nav>
