<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>返回结果</title>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div>
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">返回信息</h3>
		</div>
		<div class="panel-body">
			<%--这是一个基本的面板--%>
				<!-- 通过session传值 -->
				<h4>成功发表：${requestScope.msg}篇</h4>
				<a href="index.jsp">返回首页</a>
		</div>
	</div>
</div>


</body>
</html>