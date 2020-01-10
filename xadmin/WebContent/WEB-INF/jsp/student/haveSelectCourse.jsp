<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="sms" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>haveSelectCourse</title>
<link rel="stylesheet" href="${sms }/resources/xadmin/css/font.css">
<link rel="stylesheet" href="${sms }/resources/xadmin/css/xadmin.css">
<script src="${sms }/resources/xadmin/lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="${sms }/resources/xadmin/js/xadmin.js"></script>
</head>
<body>
<div class="x-nav">
		<span class="layui-breadcrumb"> <a href="">首页</a> <a href="">我的课程</a>
			<a> <cite>已选课程</cite></a>
		</span> <a class="layui-btn layui-btn-small"
                   style="line-height: 1.6em; margin-top: 3px; float: right"
                   onclick="location.reload()" title="刷新"> <i
        class="layui-icon layui-icon-refresh" style="line-height: 30px"></i>
</a>
</div>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body ">
                    <form class="layui-form layui-col-space5">
                        <!-- <div class="layui-inline layui-show-xs-block">
                    <input class="layui-input" autocomplete="off" placeholder="开始日"
                    name="start" id="start">
                    </div>
                    <div class="layui-inline layui-show-xs-block">
                    <input class="layui-input" autocomplete="off" placeholder="截止日"
                    name="end" id="end">
                    </div> -->
                        <!-- <div class="layui-inline layui-show-xs-block">
                            <input type="text" name="username" placeholder="请输入用户名"
                                   autocomplete="off" class="layui-input">
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <button class="layui-btn" lay-submit="" lay-filter="sreach">
                                <i class="layui-icon">&#xe615;</i>
                            </button>
                        </div> -->
                    </form>
                </div>
                <%-- <div class="layui-card-header">
                    <button class="layui-btn layui-btn-danger" onclick="delAll()">
                        <i class="layui-icon"></i>批量删除
                    </button>
                    <button class="layui-btn"
                            onclick="xadmin.open('添加教师','${sms}/teacher/addTeacher',600,400)">
                        <i class="layui-icon"></i>添加
                    </button>
                </div> --%>
                <div class="layui-card-body ">
                    <table id="student_course_table" lay-filter="student_test"></table>
                    <script type="text/html" id="student_course_bar">
                        <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
                        <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="del">取消课程</a>
                    </script>
                    <script type="text/javascript">
                        layui.use('table',function () {
                                    var table = layui.table;
                                    table.render({
                                            elem: '#student_course_table',
                                            page: true,
                                            title: '选课表',
                                            height: 315,
                                            cols: [[
                                                {
                                                    type: 'checkbox',
                                                    fixed: 'left'
                                                },
                                                {
                                                    field: 'teacher_id',
                                                    title: 'ID',
                                                    width: 80,
                                                    align: 'center',
                                                    sort: true,
                                                    fixed: 'left'
                                                },
                                                {
                                                    field: 'teacher_number',
                                                    title: '教师编号',
                                                    align: 'center',
                                                    width: 160
                                                },
                                                {
                                                    field: 'teacher_name',
                                                    title: '教师姓名',
                                                    align: 'center',
                                                    width: 160,
                                                    sort: true
                                                },
                                                {
                                                    field: 'course_number',
                                                    title: '课程编号',
                                                    align: 'center',
                                                    width: 160,
                                                    sort: true
                                                },
                                                {
                                                    field: 'course_name',
                                                    title: '课程名',
                                                    align: 'center',
                                                    width: 160,
                                                    sort: true
                                                },
                                                {
                                                    fixed: 'right',
                                                    title: '操作',
                                                    width: 160,
                                                    align: 'center',
                                                    toolbar: '#student_course_bar'
                                                }]],
                                            url: '${sms }/student/request/listSelectedCourse'
                                        });
                                    //监听行工具事件
                                    table.on('tool(student_test)',function (obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
                                                var data = obj.data //获得当前行数据
                                                    , layEvent = obj.event; //获得 lay-event 对应的值
                                                if (layEvent === 'detail') {
                                                    layer.msg('查看操作');
                                                } else if (layEvent === 'del') {//选课
                                                    console.log(data);
                                                    layer.confirm('确认取消选课',function (index) {
                                                                /* obj.del(); */ //删除对应行（tr）的DOM结构
                                                                layer.close(index);
                                                                //向服务端发送删除指令
                                                                $.ajax({
                                                                        url: "${sms }/student/request/unOrderCourse",
                                                                        contentType: "application/json;charset=UTF-8",
                                                                        data: {
                                                                            teacher_id: data.teacher_id
                                                                        },
                                                                        success: function (res) {
                                                                            console.log(res);
                                                                        },
                                                                        error: function (e) {
                                                                            console.log(e.status);
                                                                            console.log(e.responseText);
                                                                        }

                                                                    });
                                                            })
                                                } else if (layEvent === 'edit') {
                                                    layer.msg('编辑操作');
                                                    console.log(data);
                                                
                                                }
                                            });
                                });
                    </script>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>