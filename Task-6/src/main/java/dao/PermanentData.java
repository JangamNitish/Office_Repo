package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Context.ComMet;
import DBQueries.Queries;
import pojo.TablesPojo;

public class PermanentData {
    Queries ob = new Queries();
    String s="permanent";
 
    public TablesPojo permanentDisplay(int id,Connection conn) throws ClassNotFoundException, SQLException {
    	TablesPojo tp=new TablesPojo();
    	PreparedStatement pstmt=conn.prepareStatement(ob.persearchid());
    	pstmt.setInt(1, id);
    	ResultSet rs = pstmt.executeQuery();
    	if(rs.next()) {
    		tp.setId(rs.getInt("id"));
    		tp.setEp(rs.getString("ep"));
    		tp.setSalary(rs.getInt("salary"));
    		tp.setDepartment(rs.getString("department"));
    		}
    	pstmt.close();
    	rs.close();
    	return tp;
    }
    public TablesPojo deletePermanent(int i,Connection conn) throws ClassNotFoundException, SQLException {
    	TablesPojo tpp=new TablesPojo();
    	PreparedStatement pstmt=conn.prepareStatement(ob.perdelContract());
    	pstmt.setInt(1,i);
    	pstmt.execute();
    	pstmt.close();
    	return tpp;
    }
    public String detaildDel(int i,Connection conn) throws ClassNotFoundException, SQLException {
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee1","root","Nitish@1314");
    	PreparedStatement pstmt=conn.prepareStatement(ob.perdelall());
    	pstmt.setInt(1,i);
    	pstmt.execute();
    	pstmt.close();
    	return "deleted";
    }
    
    public TablesPojo addPermanent(TablesPojo t,Connection conn) throws SQLException, ClassNotFoundException {
    	PreparedStatement pstmt=conn.prepareStatement(ob.peraddContract());
    	pstmt.setInt(1, t.getId());
    	pstmt.setString(2, t.getEp());
    	pstmt.setString(3, t.getDepartment());
    	pstmt.setInt(4, t.getSalary());
    	pstmt.execute();
    	pstmt.close();
    	return t;
    	
    }
    public String addAll(TablesPojo json,Connection conn) throws ClassNotFoundException, SQLException {
    	PreparedStatement pstmt=conn.prepareStatement(ob.perallDet());
    	pstmt.setInt(1, json.getId());
    	pstmt.setString(2, json.getEp());
    	pstmt.setString(3, json.getDepartment());
    	pstmt.setInt(4, json.getSalary());
    	pstmt.setString(5,s);
    	pstmt.execute();
    	pstmt.close();
    	return "done";
    }
    public List<Object> PermanentList(Connection conn) throws ClassNotFoundException, SQLException{
    	List<Object> list=new ArrayList<Object>();
    	PreparedStatement pstmt=conn.prepareStatement(ob.perallContract());
    	ResultSet rs = pstmt.executeQuery();
    	while(rs.next()) {
			TablesPojo t = new TablesPojo(rs.getInt("id"),rs.getString("ep"),rs.getString("department"),rs.getInt("salary"));
			list.add(t);
		}
    	pstmt.close();
    	rs.close();
    	return list;
    	
    }
    

}

