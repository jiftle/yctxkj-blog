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
    <a class="navbar-brand" href="${ctx}/admin/ndex">管理后台</a>
  </div>

  <!-- Collect the nav links, forms, and other content for toggling -->
  <div class="collapse navbar-collapse navbar-ex1-collapse">
    <ul class="nav navbar-nav side-nav">
      <li class="active"><a href="${ctx}/admin/index"><i class="fa fa-dashboard"></i> 消息中心</a></li>
      <li><a href="${ctx}/admin/category/list"><i class="fa fa-table"></i> 分类管理</a></li>
      <li><a href="${ctx}/admin/article/list"><i class="fa fa-table"></i> 文章管理</a></li>
      <li><a href="${ctx}/admin/friend_link/list"><i class="fa fa-table"></i>友情链接</a></li>
      <li><a href="${ctx}/admin/cache/index"><i class="fa fa-table"></i>清理缓存</a></li>
      <li><a href="${ctx}/admin/log/login_list"><i class="fa fa-table"></i>登录日志</a></li>
      <li><a href="${ctx}/admin/log/access_list"><i class="fa fa-table"></i>访问日志</a></li>
    </ul>
<#include "menu_head.ftl">

  </div><!-- /.navbar-collapse -->
</nav>
