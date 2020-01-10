<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="sms" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>教师管理后台</title>
<link rel="stylesheet" href="${sms }/resources/xadmin/css/font.css">
<link rel="stylesheet" href="${sms }/resources/xadmin/css/xadmin.css">
<script src="${sms }/resources/xadmin/lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="${sms }/resources/xadmin/js/xadmin.js"></script>
</head>
<body class="index">
	<!-- 顶部开始 -->
	<div class="container">
		<div class="logo">
			<a href="./index.html">学生信息管理平台</a>
		</div>
		<div class="left_open">
			<a><i title="展开左侧栏" class="iconfont">&#xe699;</i></a>
		</div>
		<ul class="layui-nav left fast-add" lay-filter="">
			<li class="layui-nav-item"><a href="javascript:;">+新增</a>
				<dl class="layui-nav-child">
					<!-- 二级菜单 -->
					<dd>
						<a onclick="xadmin.open('最大化','http://www.baidu.com','','',true)">
							<i class="iconfont">&#xe6a2;</i>弹出最大化
						</a>
					</dd>
					<dd>
						<a onclick="xadmin.open('弹出自动宽高','http://www.baidu.com')"> <i
							class="iconfont">&#xe6a8;</i>弹出自动宽高
						</a>
					</dd>
					<dd>
						<a onclick="xadmin.open('弹出指定宽高','http://www.baidu.com',500,300)">
							<i class="iconfont">&#xe6a8;</i>弹出指定宽高
						</a>
					</dd>
					<dd>
						<a onclick="xadmin.add_tab('在tab打开','member-list.html')"> <i
							class="iconfont">&#xe6b8;</i>在tab打开
						</a>
					</dd>
					<dd>
						<a onclick="xadmin.add_tab('在tab打开刷新','member-del.html',true)">
							<i class="iconfont">&#xe6b8;</i>在tab打开刷新
						</a>
					</dd>
				</dl></li>
		</ul>
		<ul class="layui-nav right" lay-filter="">
			<li class="layui-nav-item"><a href="javascript:;">${LoginUser.teacher_name }</a>
				<dl class="layui-nav-child">
					<!-- 二级菜单 -->
					<dd>
						<a onclick="xadmin.open('个人信息','http://www.baidu.com')">个人信息</a>
					</dd>
					<dd>
						<a onclick="xadmin.open('切换帐号','http://www.baidu.com')">切换帐号</a>
					</dd>
					<dd>
						<a href="${sms }/logout">退出</a>
					</dd>
				</dl></li>
			<li class="layui-nav-item to-index"><a href="/">前台首页</a></li>
		</ul>
	</div>
	<!-- 顶部结束 -->
	<!-- 中部开始 -->
	<!-- 左侧菜单开始 -->
	<div class="left-nav">
		<div id="side-nav">
			<ul id="nav">
				<li><a href="javascript:;"> <i class="iconfont left-nav-li"
						lay-tips="会员管理">&#xe6b8;</i> <cite>个人信息</cite> <i
						class="iconfont nav_right">&#xe697;</i></a>
						<ul class="sub-menu">
                            <li>
                                <a onclick="xadmin.add_tab('个人资料','${sms }/teacher/updateTeacher2')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>个人资料</cite></a>
                            </li></ul>
					</li>
					<li>
                        <a href="javascript:;">
                            <i class="iconfont left-nav-li" lay-tips="课程管理">&#xe723;</i>
                            <cite>课程管理</cite>
                            <i class="iconfont nav_right">&#xe697;</i></a>
                        <ul class="sub-menu">
                        <li>
                                <a onclick="xadmin.add_tab('课程信息查询','${sms }/course/listCourse')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>课程信息查询</cite></a>
                            </li>
                            <li>
                                <a onclick="xadmin.add_tab('查询授课课程','${sms }/teacher/listTeacherCourse')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>查询授课课程</cite></a>
                            </li>
                            <li>
                                <a onclick="xadmin.add_tab('添加授课课程','${sms}/teacher/addTeacherCourse')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>添加授课课程</cite></a>
                            </li>
                            <%-- <li>
                                <a onclick="xadmin.add_tab('课程修改','${sms}/teacher/selectCourseStudent')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>课程修改</cite></a>
                            </li> --%>
                        </ul>
                    </li>
				<li><a href="javascript:;"> <i class="iconfont left-nav-li"
						lay-tips="学生管理">&#xe723;</i> <cite>学生管理</cite> <i
						class="iconfont nav_right">&#xe697;</i></a>
					<ul class="sub-menu">
						<li><a
							onclick="xadmin.add_tab('课程查询','${sms}/teacher/TeacherCourseStudent')">
								<i class="iconfont">&#xe6a7;</i> <cite>授课学生查询</cite>
						</a></li>
						<%-- <li><a onclick="xadmin.add_tab('已选课程','order-list1.html')">
								<i class="iconfont">&#xe6a7;</i> <cite>已选课程</cite>
						</a></li> --%>
					</ul></li>
			</ul>
		</div>
	</div>
	<!-- <div class="x-slide_left"></div> -->
	<!-- 左侧菜单结束 -->
	<!-- 右侧主体开始 -->
	<div class="page-content">
		<div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
			<ul class="layui-tab-title">
				<li class="home"><i class="layui-icon">&#xe68e;</i>我的桌面</li>
			</ul>
			<div class="layui-unselect layui-form-select layui-form-selected"
				id="tab_right">
				<dl>
					<dd data-type="this">关闭当前</dd>
					<dd data-type="other">关闭其它</dd>
					<dd data-type="all">关闭全部</dd>
				</dl>
			</div>
			<div class="layui-tab-content">
				<div class="layui-tab-item layui-show">
					<iframe src='${sms }/welcome' frameborder="0" scrolling="yes"
						class="x-iframe"></iframe>
				</div>
			</div>
			<div id="tab_show"></div>
		</div>
	</div>
	<div class="page-content-bg"></div>
	<style id="theme_style"></style>
	<!-- 右侧主体结束 -->
	<!-- 中部结束 -->
	<script>
		//百度统计可去掉
		var _hmt = _hmt || [];
		(function() {
			var hm = document.createElement("script");
			hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
			var s = document.getElementsByTagName("script")[0];
			s.parentNode.insertBefore(hm, s);
		})();
	</script>
</body>
</html>