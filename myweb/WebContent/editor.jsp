<%--
  Created by IntelliJ IDEA.
  User: WWJ
  Date: 2019/10/20
  Time: 0:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>发表文章</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <script src="layui/layui.js"></script>
    <script type="text/javascript" src="js/jquery.min.js"></script>

    <script>
        var index;
        function beforeSubmit() {
            console.log('表单判断')
            var content = layui.layedit.getContent(index);
            var title = $('input[name="wtitle"]').val();
            $('input[name="wcontent"]').val(content);
            console.log('发表内容:'+content);
            if(title == null || title == "" || title == undefined){
                alert('文章标题不能为空')
                return false;
            }
            return true;
        }
        $(function() {
            layui.use('layedit', function() {
                console.log('建立编辑器')
                var layedit = layui.layedit;
                index = layedit.build('demo'); //建立编辑器
            });
            /* $('resetbtn').on('click', function() {
                alert(layedit.getContent(index))
            }) */
        })
    </script>
</head>
<body>
<div>
    <a href="loadBlog.jsp">浏览文章</a>
</div>
<form class="layui-form" action="PutWenZhang" method="post"
      onsubmit="return beforeSubmit();">
    <div class="layui-form-item">
        <label class="layui-form-label">单行输入框</label>
        <div class="layui-input-block">
            <input type="text" name="wtitle" autocomplete="off"
                   placeholder="请输入标题" class="layui-input">
        </div>
    </div>
    <div style="width: 600px; height: 400px;">
        <textarea id="demo" style="display: none;"></textarea>
        <input type="text" name="wcontent" style="display: none;">
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <input type="submit" class="layui-btn" value="立即提交" />
            <input type="reset" class="layui-btn layui-btn-primary" value="重置" />
        </div>
    </div>
    <!-- <input type="submit" value="立即提交" /> <input type="reset" value="重置"/> -->
</form>
<button  onclick="beforeSubmit()">test</button>
</body>
</html>
