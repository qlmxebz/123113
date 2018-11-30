package cmt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InfoDao {
	public ResultSet Select(Info info){
	    PreparedStatement pst=null;
	    ResultSet rs=null;
	    InfoConn coon=new InfoConn();
	    Connection conna=coon.getCoon();
	    String sql_Select="select * from info where id=?";
	    try {
	        pst=conna.prepareStatement(sql_Select);
	        pst.setInt(1,info.getId());
	        rs=pst.executeQuery();
	    } catch (Exception e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }

	    return rs;

	}
	public ResultSet doSelect(Info info){
	    PreparedStatement pst=null;
	    ResultSet rs=null;
	    InfoConn coon=new InfoConn();
	    Connection conna=coon.getCoon();
	    String sql_Select="select  n.id,n.title,n.data,ts.text"+" from info as n"
	    		+ " inner join infotext as ts"+ " on n.id=ts.text_id"
	    		+" where n.id=?";
	    try {
	        pst=conna.prepareStatement(sql_Select);
	        pst.setInt(1,info.getId());
	        rs=pst.executeQuery();
	    } catch (Exception e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }

	    return rs;

	}
	public  int Update(Info info){
	    PreparedStatement pst=null;
	    int rs=0;
	    InfoConn coon=new InfoConn();
	    Connection coona=coon.getCoon();
	    String sql_update="update infotext set text=? where text_id=?";
	    try {
	        pst=coona.prepareStatement(sql_update);
	        pst.setString(1,info.getText() );
	       
	        pst.setInt(2, info.getId());
	        rs=pst.executeUpdate();
	    } catch (Exception e) {
	       
	        e.printStackTrace();
	    }
	    return rs;

	}
	public int Delete(Info info){
	    PreparedStatement pst=null;
	    int rs=0;
	    InfoConn coon=new InfoConn();
	    Connection coona=coon.getCoon();
	    String sql_delete="delete from info where id=?";
	    try {
	        pst=coona.prepareStatement(sql_delete);
	        pst.setInt(1, info.getId());
	        rs=pst.executeUpdate();
	    } catch (Exception e) {
	       
	        e.printStackTrace();
	    }

	    return rs;
	}
}
