<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="学的不仅是技术更是梦想。 - 赢创课堂">
    <title>学的不仅是技术更是梦想。  - 赢创课堂</title>
    <!-- Bootstrap Core CSS -->
    <link href="${ctx}/assets/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="${ctx}/assets/css/blog.css" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media
    queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file://
    -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js">
      </script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js">
      </script>
    <![endif]-->
    <!-- jQuery Version 1.11.0 -->
    <script src="${ctx}/assets/js/jquery/1.11.0/jquery.min.js">
    </script>
    <!-- Bootstrap Core JavaScript -->
    <script src="${ctx}/assets/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        try {
            window.AG_onLoad = function(func) {
                if (window.addEventListener) {
                    window.addEventListener('DOMContentLoaded', func);
                }
            };
            window.AG_removeElementById = function(id) {
                var element = document.getElementById(id);
                if (element && element.parentNode) {
                    element.parentNode.removeChild(element);
                }
            };
            window.AG_removeElementBySelector = function(selector) {
                if (!document.querySelectorAll) {
                    return;
                }
                var nodes = document.querySelectorAll(selector);
                if (nodes) {
                    for (var i = 0; i < nodes.length; i++) {
                        if (nodes[i] && nodes[i].parentNode) {
                            nodes[i].parentNode.removeChild(nodes[i]);
                        }
                    }
                }
            };
            window.AG_each = function(selector, fn) {
                if (!document.querySelectorAll) return;
                var elements = document.querySelectorAll(selector);
                for (var i = 0; i < elements.length; i++) {
                    fn(elements[i]);
                };
            };
            var AG_removeParent = function(el, fn) {
                while (el && el.parentNode) {
                    if (fn(el)) {
                        el.parentNode.removeChild(el);
                        return;
                    }
                    el = el.parentNode;
                }
            };
            var AG_onLoad = function(func) {
                if (document.readyState === "complete" || document.readyState === "interactive") func();
                else if (document.addEventListener) document.addEventListener("DOMContentLoaded", func);
                else if (document.attachEvent) document.attachEvent("DOMContentLoaded", func)
            };
            var AG_removeElementById = function(id) {
                var element = document.getElementById(id);
                if (element && element.parentNode) {
                    element.parentNode.removeChild(element);
                }
            };
            var AG_removeElementBySelector = function(selector) {
                if (!document.querySelectorAll) {
                    return;
                }
                var nodes = document.querySelectorAll(selector);
                if (nodes) {
                    for (var i = 0; i < nodes.length; i++) {
                        if (nodes[i] && nodes[i].parentNode) {
                            nodes[i].parentNode.removeChild(nodes[i]);
                        }
                    }
                }
            };
            var AG_each = function(selector, fn) {
                if (!document.querySelectorAll) return;
                var elements = document.querySelectorAll(selector);
                for (var i = 0; i < elements.length; i++) {
                    fn(elements[i]);
                };
            };
        } catch (ex) {
            console.error('Error executing AG js: ' + ex);
        }
    </script>
    <style id="holderjs-style" type="text/css"></style>
</head>

<body class=" __plain_text_READY__">
    <!-- Navigation -->
    <#include "include/nav.ftl">
    <!-- Page Content -->
    <div class="container">
        <di class="row">
            <!-- Blog Entries Column -->
            <div class="col-md-8">
              	<a href="${ctx}/index">首页</a>&nbsp;>&nbsp;正文

                <!-- BlogIndex ad -->
                <h2>
                    ${article.title?default('')}
                  <div class="post-date">
                	<span class="glyphicon glyphicon-time"></span>
                	${article.create_date}
                  </div>
                </h2>
                <hr>
                 ${(article.content!'')}
                <p></p>
                <hr>

            </div>
          <#include "include/right.ftl">
    </div>
    <!-- /.row -->

    <!-- Footer -->
    <#include "include/footer.ftl">
    </div>
    <!-- /.container -->



</body>

</html>
