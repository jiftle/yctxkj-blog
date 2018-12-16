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
              <li class="active"><i class="fa fa-table"></i>修改</li>
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
            <form role="form" method="post" action="${ctx}/admin/friend_link/update">
              <input type="text" class="form-control" id="id" name="id" value="${friendLink.id}" />
      				<div class="form-group">
      					 <label for="name">网站名称</label>
                 <input type="text" class="form-control" id="name" name="name" value="${friendLink.name}" />
      				</div>
              <div class="form-group">
      					 <label for="url">网址</label>
                 <input type="text" class="form-control" id="url" name="url" value="${friendLink.url}" />
      				</div>
              <button type="submit" class="btn btn-default" >提交</button>
      			</form>
          </div>

        </div><!-- /.row -->




      </div><!-- /#page-wrapper -->

    </div><!-- /#wrapper -->

    <div>
        <h3 id="focush2"></h3>
    </div>



    <!-- JavaScript -->
    <script src="${ctx}/assets/admin/js/jquery-1.10.2.js"></script>
    <script src="${ctx}/assets/admin/js/bootstrap.js"></script>

    <!-- Page Specific Plugins -->
    <script src="${ctx}/assets/admin/js/tablesorter/jquery.tablesorter.js"></script>
    <script src="${ctx}/assets/admin/js/tablesorter/tables.js"></script>

    <link href="${ctx}/assets/ueditor/mini/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
    <!-- <script type="text/javascript" src="${ctx}/assets/ueditor/third-party/jquery.min.js"></script> -->
<!--     <script type="text/javascript" charset="utf-8" src="${ctx}/assets/ueditor/mini/umeditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${ctx}/assets/ueditor/mini/umeditor.min.js"></script>
    <script type="text/javascript" src="${ctx}/assets/ueditor/mini/lang/zh-cn/zh-cn.js"></script> -->
        <!-- 配置文件 -->
    <script type="text/javascript" src="${ctx}/assets/ueditor/dev/ueditor.config.js"></script>
    <!-- 编辑器源码文件 -->
    <script type="text/javascript" src="${ctx}/assets/ueditor/dev/ueditor.all.min.js"></script>

    <script type="text/javascript">
        //实例化编辑器
        var um = UE.getEditor('myEditor', {
                                autoHeightEnabled: false
                            });

        function getContent() {
            var arr = [];
            arr.push("使用editor.getContent()方法可以获得编辑器的内容");
            arr.push("内容为：");
            arr.push(UE.getEditor('myEditor').getContent());
            alert(arr.join("\n"));
        }

        function getPlainTxt() {
            //  var arr = [];
            //  arr.push("使用editor.getPlainTxt()方法可以获得编辑器的带格式的纯文本内容");
            //  arr.push("内容为：");
            //  arr.push(UM.getEditor('myEditor').getPlainTxt());
            //  alert(arr.join('\n'))

             var plain_text = UE.getEditor('myEditor').getPlainTxt();
             plain_text = plain_text.substring(0,256);
            $('#summary').val(plain_text);
         }
    </script>

  </body>
</html>
