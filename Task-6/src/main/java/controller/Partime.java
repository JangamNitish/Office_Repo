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
import pojo.TablesPojo;

/**
 * Servlet implementation class Parttime
 */
public class Partime extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Gson gson=new Gson();
       dao.ParttimeData ParttimeData=new dao.ParttimeData();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Partime() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TablesPojo json=gson.fromJson(request.getReader(), TablesPojo.class);
		PrintWriter out=response.getWriter();
		if(json!=null) {
		try {
			ServletContext sc=request.getServletContext();
	        ComMet obj=(ComMet)sc.getAttribute("dB");
	        Connection conn = obj.getConnection();
			TablesPojo tp=ParttimeData.parttimeDisplay(json.getId(),conn);
			String str=gson.toJson(tp);
			out.print(str);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else if(json==null) {
			List<Object> list;
			try {
				ServletContext sc=request.getServletContext();
		        ComMet obj=(ComMet)sc.getAttribute("dB");
		        Connection conn = obj.getConnection();
				list = ParttimeData.ParttimeList(conn);
				String str=gson.toJson(list);
				out.print(str);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TablesPojo json=gson.fromJson(request.getReader(), TablesPojo.class);
		PrintWriter out=response.getWriter();
		TablesPojo tp;
		try {
			ServletContext sc=request.getServletContext();
	        ComMet obj=(ComMet)sc.getAttribute("dB");
	        Connection conn = obj.getConnection();
			tp = ParttimeData.addParttime(json,conn);
			String st=ParttimeData.addAll(json,conn);
//			String str=gson.toJson(tp);
			out.print("Inserted");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	protected void doDelete(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		TablesPojo json=gson.fromJson(request.getReader(),TablesPojo.class);
		PrintWriter out=response.getWriter();
		TablesPojo tp;
		try {
			ServletContext sc=request.getServletContext();
	        ComMet obj=(ComMet)sc.getAttribute("dB");
	        Connection conn = obj.getConnection();
			tp = ParttimeData.deleteParttime(json.getId(),conn);
			String st=ParttimeData.detaildDel(json.getId(),conn);
//			String str=gson.toJson(tp);
			out.print("Deleted");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
	}

}
