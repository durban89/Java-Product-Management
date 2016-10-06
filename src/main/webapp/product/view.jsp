<%--
  Created by IntelliJ IDEA.
  User: durban126
  Date: 16/10/6
  Time: 上午9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page
    contentType="text/html;charset=UTF-8"
    language="java" import="java.util.*" %>
<%
String path = request.getContextPath();
  Map<String, Object> map = (Map<String, Object>) request.getAttribute("map");
%>
<html>
<head>
  <title></title>
  <link href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <div class="panel panel-default">
          <div class="panel-heading">
            <h3 class="panel-title">产品查看</h3>
          </div>
          <form action="<%=path+"/servlet/ProductAction"%>?action_flag=add" method="post" enctype="multipart/form-data">
          <table class="table">
            <tr>
              <td>产品名称</td>
              <td><%=map.get("proname")%></td>
            </tr>
            <tr>
              <td>产品价格</td>
              <td><%=map.get("proprice")%></td>
            </tr>
            <tr>
              <td>产品地址</td>
              <td><%=map.get("proaddress")%></td>
            </tr>
            <tr>
              <td>产品图片</td>
              <td><img src="<%=path%>\\upload\\<%=map.get("proimage")%>"/></td>
            </tr>
            <tr>
              <td><button class="btn btn-primary" type="button" onclick="javascript:window.history.back()">返回</button></td>
              <td></td>
            </tr>
          </table>
          </form>
        </div>
      </div>
    </div>
  </div>
  <script src="http://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
  <script src="http://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
