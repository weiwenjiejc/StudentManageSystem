<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="sms" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${sms }/resources/xadmin/css/font.css">
<link rel="stylesheet" href="${sms }/resources/xadmin/css/xadmin.css">
<link rel="stylesheet" href="${sms }/resources/xadmin/lib/layui/css/layui.css">
<script src="${sms }/resources/xadmin/lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="${sms }/resources/xadmin/js/xadmin.js"></script>
</head>
<body>
<table id="demo" lay-filter="test"></table>
 
<script src="/layui/layui.js"></script>
<script type="text/javascript">
layui.use('table',
  function() {
    var table = layui.table;
    table.render({
      elem: '#teacher_table',
      page: true,
      title: '教师表',
      height: 315,
      cols: [[{
        type: 'checkbox',
        fixed: 'left'
      },
      {
        field: 'id',
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
        fixed: 'right',
        title: '操作',
        width: 180,
        align: 'center',
        toolbar: '#barDemo'
      }]],
      url: '${sms }/teacher/request/listAllTeacher'
    });
    </script>
</body>
</html>