<%@page import="wwj.bean.Blog" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>浏览文章</title>
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
				<h3 class="panel-title">笔记列表</h3>
			</div>
			<div class="panel-body">
				<%--这是一个基本的面板--%>
				<ul class="list-group">
					<c:forEach items="${requestScope.wenzhangList }" var="x">
						<li class="list-group-item">
							<div>
								<div>${x.wtitle }</div>
								<div>${x.wcontent }</div>
								<div>${x.wtime }</div>
							</div>
						</li>
					</c:forEach>

				</ul>
				<div>
					<ul class="pagination">
						<c:forEach begin="0" end="${requestScope.total }" var="x">
							<li><a href="${pageContext.request.contextPath}/loadBlog?start=${x}">${x}</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>

	</div>
</div>

</body>
</html>