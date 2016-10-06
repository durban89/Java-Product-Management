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
  <title>Title</title>
  <link href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <div class="panel panel-default">
          <div class="panel-heading">
            <h3 class="panel-title">产品搜素</h3>
          </div>
          <table class="table">
            <tr>
              <td>产品名称</td>
              <td><input class="form-control text-input" /></td>
            </tr>
            <tr>
              <td>
                <button class="btn btn-primary">搜索</button>
                <a class="btn btn-primary" href="<%=path+"/product/add.jsp" %>">添加</a>
              </td>
              <td></td>
            </tr>
          </table>
        </div>
        <div class="panel panel-default">
          <div class="panel-heading">
            <h3 class="panel-title">查询结果</h3>
          </div>
          <table class="table">
            <tr>
              <th>
                <input type="checkbox" />
              </th>
              <th>
                产品名称
              </th>
              <th>
                产品价格
              </th>
              <th>
                产品产地
              </th>
            </tr>
          </table>
        </div>
        <div class="panel panel-default">
          <div class="panel-body">
            <h3 class="panel-title">分页</h3>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script src="http://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
  <script src="http://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
