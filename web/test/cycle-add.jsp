<%--
  Created by IntelliJ IDEA.
  User: GaoXiang
  Date: 2015/12/28 0028
  Time: 下午 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <!-- 可选的Bootstrap主题文件（一般不用引入） -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
<button class="btn btn-info" onclick="save()">提交</button>
<button class="btn btn-info" onclick="save2()">提交2</button>
</body>
</html>
<script>

    function save(){
        var param = {
            "rate":"66,68,65,75",
            "appId":"888888",
            "time":"1311254111111,1311254111111,1311254111111,1311254111111"
        };
        $.post("/rate/history",param,function(data){
            console.log(data);
        },"json");
    };

    function save2(){
        var param = {
            "rate":66,
            "appId":"1",
            "time":1311254111111
        };
        $.post("/rate/save",param,function(data){
            console.log(data);
        },"json");
    };
</script>

