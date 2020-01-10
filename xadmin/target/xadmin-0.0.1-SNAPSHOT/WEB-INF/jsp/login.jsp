<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="sms" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
<link rel="stylesheet" href="${sms }/resources/xadmin/css/font.css">
<link rel="stylesheet" href="${sms }/resources/xadmin/css/xadmin.css">
<script src="${sms }/resources/xadmin/lib/layui/layui.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="${sms }/resources/xadmin/js/xadmin.js"></script>
<script type="text/javascript" src="${sms }/resources/js/jquery.js"></script>
<style type="text/css">
.layadmin-user-login-box {
	padding: 10px;
}

.layadmin-user-login-body .layui-form-item {
	position: relative;
}

.layadmin-user-login-icon {
	position: absolute;
	left: 1px;
	top: 1px;
	width: 38px;
	line-height: 36px;
	text-align: center;
	color: #d2d2d2;
}

.layadmin-user-login-body .layui-form-item .layui-input {
	padding-left: 38px;
}

.layadmin-user-login-header {
	text-align: center;
}
</style>
</head>
<body>
	<div style="width: 380px; margin: 180px auto">
		<div class="layadmin-user-login-box layadmin-user-login-header"
			style="margin: 30px;">
			<h2>用户登录</h2>
			<p>学生信息管理系统</p>
		</div>
		<form action="${sms }/login"
			class="layadmin-user-login-box layadmin-user-login-body layui-form">
			<div class="layui-form-item">
				<label
					class="layadmin-user-login-icon layui-icon layui-icon-username"
					for="LAY-user-login-username"></label> <input type="text"
					name="username" id="LAY-user-login-username" lay-verify="username"
					placeholder="用户名" class="layui-input">
			</div>
			<div class="layui-form-item">
				<label
					class="layadmin-user-login-icon layui-icon layui-icon-password"
					for="LAY-user-login-password"></label> <input type="password"
					name="password" id="LAY-user-login-password" lay-verify="password"
					placeholder="密码" class="layui-input">
			</div>
			<div class="layui-form-item"style="width: 380px;">
				<label class="layui-form-label">身份</label>
				<div class="layui-input-block">
					<input type="radio" name="identity" value="0" title="管理员" checked="">
					<input type="radio" name="identity" value="1" title="教师"> 
					<input type="radio" name="identity" value="2" title="学生">
				</div>
			</div>
			${msg }
			<div class="layui-form-item">
				<input class="layui-btn layui-btn-fluid" type="submit" value="登录" />
			</div>
		</form>
		<script>layui.use(['form','layer','jquery'],function() {
    var form = layui.form,
    layer = layui.layer;
  //自定义验证规则
	form.verify({
		username : function(value) {
			if (value.length == 5) {
				return '账号为五位数字';
			}
		},
		password : [ /(.+){1,6}$/, '密码必须1到6位' ],
		/* repass : function(value) {
			if ($('#L_pass').val() != $('#L_repass').val()) {
				return '两次密码不一致';
			}
		} */
	}); 

  });</script>
	</div>
</body>
</html>