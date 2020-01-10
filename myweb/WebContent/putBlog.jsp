<%--
  Created by IntelliJ IDEA.
  User: WWJ
  Date: 2019/10/20
  Time: 0:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>写日记</title>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div>
    <%--网页导航--%>
    <jsp:include page="header.jsp"></jsp:include>
    <div>
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">写笔记</h3>
            </div>
            <div class="panel-body">
                <%--这是一个基本的面板--%>
                <form action="${pageContext.request.contextPath}/putBlog" method="post">
                    <div class="form-group">
                        <label>文章标题</label>
                        <input type="text" class="form-control" placeholder="文章标题" name="wtitle">
                    </div>
                    <div class="form-group">
                        <label>笔记内容：</label>
                        <textarea class="form-control" rows="10" name="wcontent"></textarea>
                    </div>
                    <input type="submit" class="btn btn-default">
                    <input type="reset" class="btn btn-default">
                </form>
            </div>
        </div>

    </div>
</div>

</body>
</html>
