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

public class ParttimeData {
	Queries ob = new Queries();
    String s="parttime";

   
    public TablesPojo parttimeDisplay(int id,Connection conn) throws ClassNotFoundException, SQLException {
    	TablesPojo tp=new TablesPojo();
    	PreparedStatement pstmt=conn.prepareStatement(ob.parsearchid());
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
    public TablesPojo deleteParttime(int i,Connection conn) throws ClassNotFoundException, SQLException {
    	TablesPojo tpp=new TablesPojo();
    	PreparedStatement pstmt=conn.prepareStatement(ob.pardelContract());
    	pstmt.setInt(1,i);
    	pstmt.execute();
    	pstmt.close();
    	return tpp;
    }
    public String detaildDel(int i,Connection conn) throws ClassNotFoundException, SQLException {
    	PreparedStatement pstmt=conn.prepareStatement(ob.pardelall());
    	pstmt.setInt(1,i);
    	pstmt.execute();
    	pstmt.close();
    	return "deleted";
    }
    
    public TablesPojo addParttime(TablesPojo t,Connection conn) throws SQLException, ClassNotFoundException {
    	PreparedStatement pstmt=conn.prepareStatement(ob.paraddContract());
    	pstmt.setInt(1, t.getId());
    	pstmt.setString(2, t.getEp());
    	pstmt.setString(3, t.getDepartment());
    	pstmt.setInt(4, t.getSalary());
    	pstmt.execute();
    	pstmt.close();
    	return t;
    	
    }
    public String addAll(TablesPojo json,Connection conn) throws ClassNotFoundException, SQLException {
    	PreparedStatement pstmt=conn.prepareStatement(ob.parallDet());
    	pstmt.setInt(1, json.getId());
    	pstmt.setString(2, json.getEp());
    	pstmt.setString(3, json.getDepartment());
    	pstmt.setInt(4, json.getSalary());
    	pstmt.setString(5,s);
    	pstmt.execute();
    	pstmt.close();
    	return "done";
    }
    public List<Object> ParttimeList(Connection conn) throws ClassNotFoundException, SQLException{
    	List<Object> list=new ArrayList<Object>();
    	PreparedStatement pstmt=conn.prepareStatement(ob.paraddContract());
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

