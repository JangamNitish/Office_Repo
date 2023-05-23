package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

import Context.ComMet;
import pojo.AllEmployyPojo;


/**
 * Servlet implementation class AllEmp
 */
public class AllEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Gson gson = new Gson();
	dao.AllEmpData AllEmpData=new dao.AllEmpData();
	private Connection conn;
    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			
			try {
				ServletContext sc=request.getServletContext();
		        ComMet obj=(ComMet)sc.getAttribute("dB");
		        Connection conn = obj.getConnection();
			} catch (SQLException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
		
		int id=Integer.parseInt(request.getParameter("id1"));
		PrintWriter out = response.getWriter();
	

		try {
		if(id!=0) {
			AllEmployyPojo e;			
					e = AllEmpData.getEmployee(id,conn);
			String JsonString = gson.toJson(e);
			out.print(JsonString);
			out.flush();
		}
		else {
			List<Object> e = AllEmpData.getall(conn);
			String employeeJsonString = gson.toJson(e);
			out.print(employeeJsonString);
			out.flush();	
		}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */


}