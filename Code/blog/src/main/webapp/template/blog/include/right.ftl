<!-- Blog Sidebar Widgets Column -->
<div class="col-md-4">
    <!-- Blog Categories Well -->
    <div class="well">
        <h4>
          栏目分类
        </h4>
        <div class="row">
            <div class="col-lg-12">
                <ul class="list-unstyled">
                  <#list list as articleCategory>
                    <li>
                        <a href="list?id=${articleCategory.id}">
                        ${articleCategory.name}
                        </a>
                    </li>
                  </#list>
                </ul>
            </div>

        </div>
        <!-- /.row -->
    </div>

    <!-- Blog Recent Well -->
    <div class="well">
        <h4>
          最新文章
        </h4>
        <div class="row">
            <div class="col-lg-12">
                <ul class="list-unstyled">
                  <#list listArticle as article>
                    <#if article_index gt 4 >
                      <#break>
                    </#if>

                    <li>
                      <a href="article?id=${article.id}" >
                        ${article.title?default('')}
                      </a>
                    </li>
                  </#list>
                </ul>
            </div>
        </div>
    </div>
    <!-- Blog Links Well -->
    <div class="well">
        <h4>
          友情链接
        </h4>
        <ul class="list-unstyled">
            <li>
                <a href="https://github.com/">
                  GitHub
                </a>
            </li>
        </ul>

    </div>
</div>
