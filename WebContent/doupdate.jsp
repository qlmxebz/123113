<%@ page language="java"  import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="cmt.Info" %>
<%@page import="cmt.InfoDao"  %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>更新页面</title>
</head>
<body>
 <% request.setCharacterEncoding("utf-8");
  InfoDao dao=new InfoDao();
 Info info=new Info();
 info.setText(request.getParameter("text"));
 
 info.setId(Integer.parseInt(request.getParameter("id")));
 int rs=0;
 rs=dao.Update(info);
		System.out.print(rs);
		 response.sendRedirect("/zuoye/showPage.jsp");

    %>
</body>
</html>