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
 * Servlet implementation class Servlet2
 */
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet2() {
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
		 MD5  md5= new MD5();
		 String md5password = md5.encode(password);
		String driver = "com.mysql.jdbc.Driver"; 
		 String url = "jdbc:mysql://127.0.0.1:3306/test";      
		 String use = "root";       
		 String sqlpassword = "123456"; 
		 
		 ResultSet rs=null;
		 try
		 {Class.forName(driver);      
		 Connection  conn= DriverManager.getConnection(url,use,sqlpassword); 
		 
		 PreparedStatement sql =conn.prepareStatement("select * from users where phonenumber=? and password=?");  
		  sql.setString(1,phonenumber);   
		 sql.setString(2,md5password);    
		 rs=sql.executeQuery();
		 if (rs.next()) 
		 {  
			 response.sendRedirect("/zuoye/showPage.jsp");
         }
		 else
		 {
			 System.out.println("用户不存在");
		 }
		 
		 rs.close();
         sql.close();   
		 conn.close();}
		 catch(Exception e) {};
		

	}

}
