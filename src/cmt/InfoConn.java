package cmt;

import java.sql.Connection;
import java.sql.DriverManager;

public class InfoConn {
	 public static final String DBDRIVER="com.mysql.jdbc.Driver";
	    public static final String DBURL="jdbc:mysql://localhost:3306/test";
	    public static final String DBUSER="root";
	    public static final String DBPASS="123456";
	    Connection conn=null;
	    public Connection getCoon(){
	        try {
	            Class.forName(DBDRIVER);
	            conn=DriverManager.getConnection(DBURL,DBUSER,DBPASS);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return conn;
	    }
}
	
	

