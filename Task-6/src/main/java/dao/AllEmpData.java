package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DBQueries.Queries;
import pojo.AllEmployyPojo;


public class AllEmpData {

	Queries ob = new Queries();

//	static Connection conn = null;
//	static Connection getConnection() {
//		
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee1","root","Nitish@1314");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return conn;
//	}
	public AllEmployyPojo getEmployee(int id,Connection conn) throws SQLException {
		AllEmployyPojo Ae=new AllEmployyPojo();
//		conn = getConnection();
		PreparedStatement pstmt=conn.prepareStatement(ob.searchid());
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
	public List<Object> getall(Connection conn) throws SQLException, ClassNotFoundException{
		List<Object> list = new ArrayList<Object>();
//		conn = getConnection();
    	PreparedStatement pstmt=conn.prepareStatement(ob.jsonquery());
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					AllEmployyPojo e = new AllEmployyPojo(rs.getInt("id"),rs.getInt("salary"),rs.getString("ep"),rs.getString("department"),rs.getString("type"));
					list.add(e);
				}
				pstmt.close();
				rs.close();
				return list;
		}
		
	
	public AllEmployyPojo addCont(AllEmployyPojo json,Connection conn) throws ClassNotFoundException, SQLException {
//		conn = getConnection();
    	PreparedStatement pstmt=conn.prepareStatement(ob.add());
    	pstmt.setInt(1, json.getId());
    	pstmt.setString(2, json.getEp());
    	pstmt.setInt(3, json.getSalary());
    	pstmt.setString(4, json.getDepartment());
    	pstmt.setString(5, json.getType());
    	pstmt.execute();
    	pstmt.close();
    	return json;	
	}
}
