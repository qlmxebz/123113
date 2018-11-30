<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="cmt.Info" %>

<%@ page import="cmt.InfoConn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>消息列表</title>
</head>
<body>
<table align="center" width="800" border="1">
    <tr>
        <td align="center" colspan="5">
        <h2>所有消息</h2>
        </td>
    </tr>
    <tr align="center">
    <td>标题</td><td>日期</td><td colspan="2">操作方法</td>
    </tr>
    <%
    InfoConn coon=new InfoConn();
    Connection coona=coon.getCoon();
    String sql="SELECT * FROM info;";
    PreparedStatement pst=coona.prepareStatement(sql);
    ResultSet rs= pst.executeQuery();
    Info info = new Info();
    
   
   
   while(rs.next()){ 
   int id = rs.getInt("id"); 
   String title = rs.getString("title"); 
   String data = rs.getString("data"); 
   info.setId(id);
   info.setTitle(title);
   info.setData(data);
 
   %>
  
   <tr align="center">
   <td><%=info.getTitle() %></a></td> <td><%=info.getData() %></td>
     <td><a href="/zuoye/infotext.jsp?id=<%=info.getId()%>">编辑</a></td>
       <td><a href="/zuoye/delete?id=<%=info.getId()%>">删除</a></td>
   
  
   </tr>

     <%} %>
   <% rs.close();
      pst.close();
      coona.close();%> 
     
</body>
</html>