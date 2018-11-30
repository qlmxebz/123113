<%@ page language="java"  import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="cmt.Info" %>
<%@page import="cmt.InfoDao"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>详情页面</title>
</head>
<body>
<%
  request.setCharacterEncoding("utf-8");
  InfoDao dao=new InfoDao();
 Info info=new Info();
 info.setId(Integer.parseInt(request.getParameter("id")));
  ResultSet rs=dao.doSelect(info);
  if(rs.next()){
	  
	   String title = rs.getString("title"); 
	   String data = rs.getString("data");
	   String text = rs.getString("text");
	   info.setTitle(title);
	   info.setData(data);
	   info.setText(text);
  
  %>
  <form action="doupdate.jsp?id=<%=rs.getInt("id")%>" method="post">
  <%=info.getTitle() %></br>
 <%=info.getData() %></br>
  <input type="textarea" value="<%=info.getText() %>" name="text"></br>
  <input type="submit" value="保存" />
  <input type="submit" value="取消" />
  </form>
   <%} %>
</body>
</html>