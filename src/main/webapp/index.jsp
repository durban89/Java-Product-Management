<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<% String path = request.getContextPath(); %>

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
    <div class="col-md-4 col-md-offset-4">
      <form role="form" action="/servlet/LoginAction" method="post">
        <div class="form-group">
          <label for="username">用户名</label>
          <input type="text" class="form-control" id="username" placeholder="输入用户名">
        </div>
        <div class="form-group">
          <label for="password">Password</label>
          <input type="password" class="form-control" id="password" placeholder="输入密码">
        </div>
        <button type="submit" class="btn btn-default">登录</button>
        <a href="<%= path + "/register.jsp" %>">注册</a>
      </form>
    </div>
  </div>
</div>
<script src="http://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
