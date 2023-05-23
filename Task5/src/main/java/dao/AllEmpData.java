package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import pojo.AllEmployyPojo;


public class AllEmpData {
	String jsonquery = "SELECT * FROM alldetails";
	String searchid = "SELECT * FROM alldetails WHERE id=?";

	static Connection conn = null;
	static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee1","root","Nitish@1314");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public AllEmployyPojo getEmployee(int id) throws SQLException {
		AllEmployyPojo Ae=new AllEmployyPojo();
		conn = getConnection();
		PreparedStatement pstmt=conn.prepareStatement(searchid);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			Ae.setId(rs.getInt("id"));
			Ae.setEp(rs.getString("ep"));
			Ae.setSalary(rs.getInt("salary"));
			Ae.setDepartment(rs.getString("department"));
			Ae.setType(rs.getString("type"));
		}
		pstmt.close();
		return Ae;
	}
public Hashtable<Integer,AllEmployyPojo> viewJSON() throws SQLException  {
        
        PreparedStatement pstmt=null;
        Hashtable<Integer, AllEmployyPojo> hMap=new Hashtable<Integer, AllEmployyPojo>();
       
            conn = getConnection();
    		PreparedStatement pstmt1=conn.prepareStatement(jsonquery);
            ResultSet rs=pstmt1.executeQuery();   
           while(rs.next()) {
        	   AllEmployyPojo e=new AllEmployyPojo(rs.getInt("id"), rs.getInt("salary"), rs.getString("ep"),rs.getString("department"),rs.getString("type"));
               hMap.put(rs.getInt("id"), e);
               for (Integer key : hMap.keySet()) {
            	    System.out.println(key + ":" + hMap.get(key));
            	}
           }
           return hMap;
        }

	

}