package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

import pojo.AllEmployyPojo;


/**
 * Servlet implementation class AllEmp
 */
public class AllEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Gson gson = new Gson();
	dao.AllEmpData AllEmpData=new dao.AllEmpData();
	Hashtable<Integer,AllEmployyPojo>hmap = new Hashtable<Integer, AllEmployyPojo>();
    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id1"));
		PrintWriter out = response.getWriter();
	

		try {
		if(id!=0) {
			AllEmployyPojo e;			
					e = AllEmpData.getEmployee(id);
			String JsonString = gson.toJson(e);
			out.print(JsonString);
			out.flush();
		}
		else {
		       
		        PrintWriter out1=response.getWriter();
		        Hashtable<Integer, AllEmployyPojo> e=AllEmpData.viewJSON();
		        String s=gson.toJson(e);
		        response.setContentType("application/JSON");
		        System.out.println();
		        out1.println(s);
	
		}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */


}
