<%@ page
    import="java.util.*" %>
<%@ page import="com.produt.dbutil.util.DividePage" %>
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
  String proname = (String) request.getAttribute("proname");
  proname = (proname == null ? "" : proname);
  DividePage dividePage = (DividePage) request.getAttribute("dividePage");

  List<Map<String, Object>> listProduct = (List<Map<String, Object>>) request.getAttribute("listProduct");
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
          <form action="<%=path+"/servlet/ProductAction?action_flag=list"%>" method="post">
            <table class="table">
              <tr>
                <td>产品名称</td>
                <td><input name="proname" class="form-control text-input" value="<%=proname%>"/></td>
              </tr>
              <tr>
                <td>
                  <button class="btn btn-primary" type="submit">搜索</button>
                  <a class="btn btn-primary" href="<%=path+"/product/add.jsp" %>">添加</a>
                </td>
                <td></td>
              </tr>
            </table>
          </form>
        </div>
        <div class="panel panel-default">
          <div class="panel-heading">
            <h3 class="panel-title">查询结果</h3>
          </div>
          <form name="listForm" id="listForm" action="<%=path+"/servlet/ProductAction?action_flag=del"%>" method="post">
            <table class="table">
              <tr>
                <th>
                  <input type="checkbox" onclick="checkAll(this.checked)" name="checkall" />
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
              <%
                if(!listProduct.isEmpty()){
                  for(Map<String, Object> map:listProduct){
              %>
              <tr>
                <td>
                  <input type="checkbox" value="<%=map.get("proid")%>" name="checkProid"/>
                  <input type="hidden" value="<%=map.get("proid")%>" name="proid" />
                </td>
                <td>
                  <%=map.get("proname")%>
                </td>
                <td>
                  <%=map.get("proprice")%>
                </td>
                <td>
                  <%=map.get("proaddress")%>
                </td>
              </tr>
              <%
                  }
                }
              %>
              <tr>
                <td>
                  <button class="btn btn-primary" type="button" onclick="del()" >删除</button>
                  <button class="btn btn-primary" type="button" onclick="view()" >查看</button>
                </td>
                <td></td>
                <td></td>
                <td></td>
              </tr>
            </table>
          </form>
        </div>
        <div class="panel panel-default">
          <div class="panel-body">
            <h3 class="panel-title">
              共<%=dividePage.getPageCount()%>页
              <a href="javascript:first()">首页</a>
              <a href="javascript:forward()">上一页</a>
              <a href="javascript:next()">下一页</a>
              <a href="javascript:last()">尾页</a>
              跳转到
              <select onchange="changePage(this.value)">
                <%
                  int len = dividePage.getPageCount();
                  for(int i =1; i<=len;i++){
                %>
                <option value="<%=i%>" <%=dividePage.getCurrentPage() == i ? "selected" : ""%>><%=i%></option>
                <%
                  }
                %>

              </select>
            </h3>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script src="http://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
  <script src="http://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script>
  function first(){
    window.location.href="<%=path+"/servlet/ProductAction?action_flag=list&page_num=1"%>";
  }

  function forward(){
    window.location.href="<%=path+"/servlet/ProductAction?action_flag=list&page_num="+(dividePage.getCurrentPage() - 1)%>";
  }

  function next(){
    window.location.href="<%=path+"/servlet/ProductAction?action_flag=list&page_num="+(dividePage.getCurrentPage() + 1)%>";
  }

  function last(){
    window.location.href="<%=path+"/servlet/ProductAction?action_flag=list&page_num="+dividePage.getPageCount()%>";
  }

  function changePage(page){
    window.location.href="<%=path+"/servlet/ProductAction?action_flag=list&page_num="%>"+page;
  }

  function getSelectCount(){
    var count = 0;
    var ids = document.getElementsByName("checkProid");
    for(var i=0;i<ids.length;i++){
      if(ids[i].checked){
        count++;
      }
    }
    return count;
  }

  function getSelectValue(){
    var ids = document.getElementsByName("checkProid");
    for(var i=0;i<ids.length;i++){
      if(ids[i].checked){
        return ids[i].value;
      }
    }
  }

  function checkAll(flag){
    var ids = document.getElementsByName("checkProid");
    for(var i=0;i<ids.length;i++){
      ids[i].checked = flag;
    }
  }

  function del(){
    if(getSelectCount() <= 0){
      alert("至少选择一个选项");
      return false;
    }
    var formObj = document.listForm;
    formObj.action = "<%=path+"/servlet/ProductAction?action_flag=del"%>";
    formObj.submit();
    return true;
  }

  function view(){
    if(getSelectCount() <= 0){
      alert("至少选择一个选项");
      return false;
    }

    if(getSelectCount() > 1){
      alert("最多选择一个选项");
      return false;
    }
    var formObj = document.listForm;
    formObj.action = "<%=path%>/servlet/ProductAction?action_flag=view&proid="+getSelectValue();
    formObj.submit();
  }
  </script>
</body>
</html>
