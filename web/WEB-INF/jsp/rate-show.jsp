<%--
  Created by IntelliJ IDEA.
  User: GaoXiang
  Date: 2015/12/29 0029
  Time: 下午 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<html>
<head>
    <title>用户心率</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">

    <script src="/static/js/jquery-1.11.3.js"></script>
    <script src="/static/js/bootstrap.min.js"></script>
    <script src="/static/js/highcharts4.2.1.js"></script>
</head>
<body style="background-color: #E6E6E6">
<nav class="navbar navbar-default navbar-inverse">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">用户心率</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">折线图 <span class="sr-only">(current)</span></a></li>

            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">祝您身体健康</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<div style="width: 100%;" align="center">
    <div>
        <form class="form-inline">
            <div class="form-group">
                <label for="timeBegin">开始：</label>
                <input type="datetime" class="form-control" id="timeBegin" placeholder="2015-11-11 11:11:11">
            </div>
            <div class="form-group" style="margin-left: 10px;" >
                <label for="timeEnd">结束：</label>
                <input type="datetime" class="form-control" id="timeEnd" placeholder="2015-12-12 12:12:12">
            </div>

            <button type="submit" class="btn btn-success">搜索</button>
        </form>
    </div>

    <div id="container" style="width: 80%;height: 75%;"></div>


    <div id="table" style="width: 80%;margin-top: 20px;">

        <table class="table hide">
            <caption>列表展示：</caption>
            <thead>
            <tr>
                <th>时间</th>
                <th>心率</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${list}" varStatus="status" >

                <tr>
                    <th  scope="row"><fmt:formatDate value="${item.time}" pattern="yyyy-MM-dd HH:mm:ss"/></th>
                    <td class="rate-time hide"><fmt:formatDate value="${item.time}" pattern="HH:mm:ss"/></td>
                    <td class="rate-value"><c:out value="${item.rate}" /></td>
                </tr>

            </c:forEach>


            </tbody>
        </table>
    </div>

</div>
</body>
</html>
<script>

    $(function () {

        var timeArray = getTimeArray();
        var rateArray = getRateArray();
        console.log(timeArray)
        console.log(rateArray)

        $('#container').highcharts({
            chart: {
                type: 'spline'
            },
            title: {
                text: '用户心率展示',
                x: -20 //center
            },
            subtitle: {
                text: '此处显示指定时间段的心率',
                x: -20
            },
            xAxis: {
                type: 'datetime',
                categories: timeArray,
                title: {
                    text: '日期'
                }
            },
            yAxis: {
                title: {
                    text: '心率 (bpm)'
                },
                min: 0,
                plotLines: [{
                    value: 0,
                    width: 1,
                    color: '#808080'
                }]
            },
            tooltip: {
                valueSuffix: ' bpm'
            },
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'middle',
                borderWidth: 0
            },
            series: [{
                name: '心率',
                data: rateArray
            }]
        });
    });

    function getTimeArray(){
        var objs = $(".rate-time");
        var values = new Array(objs.length);
        for(var i = 0;i<objs.length;i++){
            try{
                var val = objs.eq(i).text();
                values[i] = val;
            }catch (e){
                console.log(e);
            }
        }
        return values;
    }

    function getRateArray(){
        var objs = $(".rate-value");
        var values = new Array(objs.length);
        for(var i = 0;i<objs.length;i++){
            var val = objs.eq(i).text();
            try{
                if(val == ""){
                    values[i] = null;
                }else{
                    var root = parseInt(val);
                    values[i] = root;
                }

            }catch (e){
                values[i] = "null";
                console.log(e);
            }
        }
        return values;
    }
</script>