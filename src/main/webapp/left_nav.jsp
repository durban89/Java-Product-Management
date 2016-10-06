<%--
  Created by IntelliJ IDEA.
  User: durban126
  Date: 16/10/6
  Time: 上午9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page
    contentType="text/html;charset=UTF-8"
    language="java" %>

<%
String path = request.getContextPath();
%>
<html>
<head>
  <title></title>
  <link href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
  <div class="container">
    <div class="row">
      <div class="list-group">
        <a href="<%=path+"/servlet/ProductAction?action_flag=list&page_num=1"%>" target="main" class="list-group-item active">
          产品列表
        </a>
        <a href="#" class="list-group-item">Dapibus ac facilisis in</a>
        <a href="#" class="list-group-item">Morbi leo risus</a>
        <a href="#" class="list-group-item">Porta ac consectetur ac</a>
        <a href="#" class="list-group-item">Vestibulum at eros</a>
      </div>
    </div>
  </div>
  <script src="http://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
  <script src="http://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
