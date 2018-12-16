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
</head>

<body class=" __plain_text_READY__">
    <#include "include/nav.ftl">

    <!-- Page Content -->
    <div class="container">
        <di class="row">
            <!-- Blog Entries Column -->
            <div class="col-md-8">
                <!-- BlogIndex ad -->
                <#list listArticle as article>
                  <h2>
                    <a href="article?id=${article.id}" target="_blank">
                      ${article.title?default('')}
                    </a>
                    <div class="post-date">
                  	<span class="glyphicon glyphicon-time"></span>
                  	${article.create_date}
                    </div>
                  </h2>
                  <hr>
                  <#if (article.summary!'')?length lt 128>
                    ${article.summary!''}
                  <#else>
                    ${(article.summary)?substring(0,128)} ...
                  </#if>
                  <p></p>
                  <h3><a href="article?id=${article.id}" target="_blank">阅读全文 »</a></h3>
                  <p></p>
                  <hr>
                </#list>

                <!-- Pager indicator -->
                <ul class="pager">
                    <li class="next">
                        <a href="#">
                          下一页 →
                        </a>
                    </li>
                </ul>
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
