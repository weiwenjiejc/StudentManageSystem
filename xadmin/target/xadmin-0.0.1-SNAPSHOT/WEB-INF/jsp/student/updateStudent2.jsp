<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="sms" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addTeacher</title>
<link rel="stylesheet" href="${sms }/resources/xadmin/css/font.css">
<link rel="stylesheet" href="${sms }/resources/xadmin/css/xadmin.css">
<script src="${sms }/resources/xadmin/lib/layui/layui.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="${sms }/resources/xadmin/js/xadmin.js"></script>
</head>
<body>
	<div class="layui-fluid">
		<div class="layui-row">
			<form class="layui-form">
				<div class="layui-form-item">
					<label for="L_email" class="layui-form-label"> <span
						class="x-red">*</span>学生编号
					</label>
					<div class="layui-input-inline">
						<input readonly="readonly" type="text" id="L_email" name="student_number" required=""
							lay-verify="student_number" autocomplete="off" class="layui-input" value="${LoginUser.student_number }">
					</div>
					<div class="layui-form-mid layui-word-aux">
						<span class="x-red">*</span>将会成为您唯一的登入名
					</div>
				</div>
				<div class="layui-form-item">
					<label for="L_username" class="layui-form-label"> <span
						class="x-red">*</span>学生姓名
					</label>
					<div class="layui-input-inline">
						<input type="text" id="L_username" name="student_name" required=""
							lay-verify="nikename" autocomplete="off" class="layui-input"  value="${LoginUser.student_name }">
					</div>
				</div>
				<div class="layui-form-item">
					<label for="L_pass" class="layui-form-label"> <span
						class="x-red">*</span>密码
					</label>
					<div class="layui-input-inline">
						<input type="password" id="L_pass" name="password" required=""
							lay-verify="pass" autocomplete="off" class="layui-input">
					</div>
					<div class="layui-form-mid layui-word-aux">6到16个字符</div>
				</div>
				<div class="layui-form-item">
					<label for="L_repass" class="layui-form-label"> <span
						class="x-red">*</span>确认密码
					</label>
					<div class="layui-input-inline">
						<input type="password" id="L_repass" name="repass" required=""
							lay-verify="repass" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label for="L_repass" class="layui-form-label"></label>
					<button class="layui-btn" lay-filter="add" lay-submit="">更新</button>
				</div>
			</form>
		</div>
	</div>
	<script>
		layui.use([ 'form', 'layer', 'jquery' ], function() {
			$ = layui.jquery;
			var form = layui.form, layer = layui.layer;

			//自定义验证规则
			form.verify({
				student_number : function(value) {
					if (value.length == 5) {
						return '账号为五位数字';
					}
				},
				pass : [ /(.+){1,6}$/, '密码必须1到6位' ],
				repass : function(value) {
					if ($('#L_pass').val() != $('#L_repass').val()) {
						return '两次密码不一致';
					}
				}
			}); 

			//监听提交
			form.on('submit(add)', function(data) {
				console.log('更新内容:')
				console.log(data.field);
				var request_data = data.field;
				console.log(request_data)
				//发异步，把数据提交给php
				console.log(request_data);
				$.ajax({
					url : "${sms }/student/request/updateStudent",
					contentType : "application/json;charset=UTF-8",
					data : request_data,
					success : function(res) {
						console.log(res);
					},
					error : function(e) {
						console.log(e.status);
						console.log(e.responseText);
					}

				}); 
				layer.alert("修改成功", {
					icon : 6
				}, function() {
					//关闭当前frame
					xadmin.close();

					// 可以对父窗口进行刷新 
					xadmin.father_reload();
				});
				return false;
			});

		});
	</script>
</body>
</html>