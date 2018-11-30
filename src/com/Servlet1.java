package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String phonenumber=request.getParameter("phonenumber"); 
		 String password=request.getParameter("password"); 
 if(phonenumber.length()==11)
  {
	if(password.length()>=4)
		 {MD5 md5 = new MD5();
		 String md5password = md5.encode(password);
		 String str = request.getParameter("validate");
		 
		 String driver = "com.mysql.jdbc.Driver"; 
		 String url = "jdbc:mysql://127.0.0.1:3306/test";      
		 String use = "root";       
		 String sqlpassword = "123456";      
		 try
		 {Class.forName(driver);      
		 Connection  conn= DriverManager.getConnection(url,use,sqlpassword); 
		 Connection  conn2= DriverManager.getConnection(url,use,sqlpassword); 
		 PreparedStatement sql =conn.prepareStatement("insert into users(phonenumber,password)values(?,?)");  
		  sql.setString(1,phonenumber);   
		 sql.setString(2,md5password);  
		 
		 ResultSet rs=null;
		 PreparedStatement sql2 =conn2.prepareStatement("select * from users where phonenumber=? and password=?");  
		 sql2.setString(1,phonenumber);   
		 sql2.setString(2,md5password);  
		 rs=sql2.executeQuery();
		 if (!rs.next()) 
		 {
		 
		
		 if(str.equals(request.getSession().getAttribute("code")))
		 {   
			 int rtn=sql.executeUpdate(); 
			 System.out.print("注册成功");
	          response.sendRedirect("/zuoye/login.jsp");
		 }
		 else
		 {
			 System.out.print("验证码错误");
		 }
		
		   
		 }
		 else
		 {
			 System.out.println("用户已存在 请登录");
			 response.sendRedirect("/zuoye/login.jsp");
		 }
		 sql.close();   
		 conn.close();
		 sql2.close();   
		 conn2.close();
		 
		 }
		 
			 
		 catch(Exception e) {};
		
		
		
		 
		 
		 }
  else {
			 System.out.println("密码不能少于4位数字");
		 }
		 }
else
		 {
			 System.out.println("手机号错误");
		 }

	}
	

}
