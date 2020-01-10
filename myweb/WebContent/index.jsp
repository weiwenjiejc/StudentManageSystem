<%--
  Created by IntelliJ IDEA.
  User: WWJ
  Date: 2019/10/13
  Time: 0:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <script src="jQuery/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div>
    <%--网页导航--%>
    <jsp:include page="header.jsp"></jsp:include>
    <div style="height: 800px;">
        <div id="myCarousel" class="carousel slide">
            <!-- 轮播（Carousel）指标 -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>
            <!-- 轮播（Carousel）项目 -->
            <div class="carousel-inner">
                <div class="item active">
                    <img src="${pageContext.request.contextPath}/images/1.jpg" alt="First slide">
                </div>
                <div class="item">
                    <img src="${pageContext.request.contextPath}/images/2.jpg" alt="Second slide">
                </div>
                <div class="item">
                    <img src="images/3.jpg" alt="Third slide">
                </div>
            </div>
            <!-- 轮播（Carousel）导航 -->
            <a class="carousel-control left" href="#myCarousel"
               data-slide="prev"> <span _ngcontent-c3="" aria-hidden="true"
                                        class="glyphicon glyphicon-chevron-right"></span></a>
            <a class="carousel-control right" href="#myCarousel"
               data-slide="next">&rsaquo;</a>
        </div>
    </div>
    <div style="padding-top:30px;background-color: #181818; height: 120px; text-align: center;vertical-align: middle">
        <%--        底部栏--%>
        <div style="height:30px;line-height: 30px;font-size: 16px;color: #9b9ea0;">
            <p>鲁ICP备<a href="http://www.beian.miit.gov.cn/">18050117</a>号-2</p>
        </div>
    </div>
</div>
</body>
</html>
