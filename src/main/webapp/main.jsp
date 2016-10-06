<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
  String path = request.getContextPath();
  String username = (String)session.getAttribute("username");
%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>后台管理</title>
  <link href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<div class="container">
  <div class="row">
    <div class="col-md-4">
      <iframe src="<%=path+"/left_nav.jsp"%>" frameborder="0" style="border: none;min-height: 600px;"></iframe>
    </div>
    <div class="col-md-8">

      <div class="panel panel-default">
        <div class="panel-heading">
          <h3 class="panel-title">欢迎，<%=username%></h3>
        </div>
        <div class="panel-body" style="padding: 0">
          <iframe id="main" name="main" style="border: none;width: 100%;min-height: 600px;" frameborder="0"></iframe>
        </div>
      </div>
    </div>
  </div>
</div>
<script src="http://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
