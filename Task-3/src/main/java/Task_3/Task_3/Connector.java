package Task_3.Task_3;

//public class Connector {
//
//}
//package EmployeeDetails.EmployeeDetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Logger;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Connector {
	static Logger log = Logger.getLogger("Connector");

	
	private final String mysql = "jdbc:mysql://localhost:3306/employee";
	private final String name = "root";
	private final String pass = "Nitish@1314";
	
	private final String  insertQuery = "INSERT INTO new_employee(id, salary, name,type) VALUES (?, ?, ?,?)";
	private final String updateQuery="UPDATE new_employee SET   name=? ,salary=? , type=? where id=?";
	private final String deleteQuery="DELETE from new_employee where id=?";
	private final String trun="Truncate TABLE new_employee";
	
	private final String truncontract="Truncate TABLE contract";
	private final String trunpartime="Truncate TABLE partime";
	private final String trunpermanent="Truncate TABLE permanent";
	
	private final String perm="INSERT INTO permanent(id,salary,name) SELECT id,salary,name FROM new_employee WHERE type='permenant'";
	private final String contr="INSERT INTO contract(id,salary,name) SELECT id,salary,name FROM new_employee WHERE type='contract'";
	private final String part="INSERT INTO partime(id,salary,name) SELECT id,salary,name FROM new_employee WHERE type='partime'";
	private final String jasonQuery = "Select * from new_employee";
	
	public Connection getConnector() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection dbConnection = DriverManager.getConnection(mysql,name,pass);
		return dbConnection;
		
	}
	 
	public void createDetails(EmployeePojo e) throws Exception {
		Connection dbConnection = getConnector();
	    PreparedStatement pstmt = dbConnection.prepareStatement(insertQuery);
	    pstmt.setInt(1, e.getEmployeeId());
	    pstmt.setInt(2, e.getSalary());
	    pstmt.setString(3, e.getEmployeeName());
	    pstmt.setString(4, e.getEmployeeType());
	    pstmt.execute();
	}
	
	public void updateDetails(EmployeePojo e ) throws Exception {
		Connection dbConnection = getConnector();
	    PreparedStatement pstmt = dbConnection.prepareStatement(updateQuery);
	    pstmt.setString(1, e.getEmployeeName());
	    pstmt.setInt(2, e.getSalary());
	    pstmt.setString(3, e.getEmployeeType());
	    pstmt.setInt(4, e.getEmployeeId());
	    pstmt.execute();
	}
	
	public void deleteDetails(int id) throws Exception {
		
		Connection dbConnection = getConnector();
	    PreparedStatement pstmt = dbConnection.prepareStatement(deleteQuery);
	    pstmt.setInt(1, id);
	    pstmt.execute();
	   
		
	}
	public void truncateSub() throws Exception {
		Connection dbConnection=getConnector();
		PreparedStatement pstmt=dbConnection.prepareStatement(truncontract);
		PreparedStatement pstmt1=dbConnection.prepareStatement(trunpartime);
		PreparedStatement pstmt2=dbConnection.prepareStatement(trunpermanent);
	    pstmt.execute();
	    pstmt1.execute();
	    pstmt2.execute();


	}
	public void truncate() throws Exception {
		Connection dbConnection=getConnector();
		PreparedStatement pstmt=dbConnection.prepareStatement(trun);
		pstmt.execute();
	}
	@SuppressWarnings("unchecked")
	public void displayJason() throws Exception {
		Connection dbConnection=getConnector();
		PreparedStatement pstmt=dbConnection.prepareStatement(jasonQuery);
		ResultSet rs = pstmt.executeQuery();
		JSONObject jsonObject = new JSONObject();
        JSONArray array = new JSONArray();
        while(rs.next()) {
        	   JSONObject record = new JSONObject();
        	   record.put("EmployeeName", rs.getString("employeeName"));
        	   record.put("EmployeeSalary", rs.getInt("salary"));
        	   record.put("EmplyeeType", rs.getString("employeeType"));
        	   record.put("EmployeeID", rs.getInt("employeeId"));
        	   array.add(record);
        	   jsonObject.put("Employee Details", array);

        	}
 	   System.out.println(jsonObject.toJSONString()+"\n");

	}
	public void addToSubTables() throws Exception {
		Connection dbConnection = getConnector();
		truncateSub();
		PreparedStatement pstmt1 = dbConnection.prepareStatement(perm);
		PreparedStatement pstmt2 = dbConnection.prepareStatement(contr);
		PreparedStatement pstmt3 = dbConnection.prepareStatement(part);
	    pstmt1.execute();	
	    pstmt2.execute();	
	    pstmt3.execute();	

		
	}

}
