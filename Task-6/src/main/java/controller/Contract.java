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
import dao.ContractData;
import pojo.TablesPojo;
/**
 * Servlet implementation class Contract
 */
public class Contract extends HttpServlet {
    private static final long serialVersionUID = 1L;
//    ContractData ob=new ContractData();
    dao.ContractData ContractData=new dao.ContractData();
    Gson gson = new Gson();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Contract() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    	TablesPojo json=gson.fromJson(request.getReader(), TablesPojo.class);
//        int id1=Integer.parseInt(request.getParameter("id"));
        PrintWriter out = response.getWriter();

        	try {
        		ServletContext sc=request.getServletContext();
		        ComMet obj=(ComMet)sc.getAttribute("dB");
		        Connection conn = obj.getConnection();
        		TablesPojo tp;
        		@SuppressWarnings("unused")
				String st;
				tp= ContractData.deleteContract(json.getId(),conn);
				st=ContractData.detaildDel(json.getId(),conn);
//				String jstr=gson.toJson(tp);
				out.print("Deleted");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       
        
       
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	 TablesPojo json=gson.fromJson(request.getReader(), TablesPojo.class);
         PrintWriter out=response.getWriter(); 
    	if(json!=null) {
    		try {
    			ServletContext sc=request.getServletContext();
		        ComMet obj=(ComMet)sc.getAttribute("dB");
		        Connection conn = obj.getConnection();
				TablesPojo e=ContractData.contractDisplay(json.getId(),conn);
				String st=gson.toJson(e);
				out.print(st);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	else if(json==null) {
         List<Object> e;
		try {
			ServletContext sc=request.getServletContext();
	        ComMet obj=(ComMet)sc.getAttribute("dB");
	        Connection conn = obj.getConnection();
			e = ContractData.contractList(conn);
			String strcontract=gson.toJson(e);
			out.print(strcontract);
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
    }
    }
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        TablesPojo json=gson.fromJson(request.getReader(), TablesPojo.class);
        PrintWriter out=response.getWriter();
        TablesPojo tp;
        @SuppressWarnings("unused")
		String ap;
		try {
			ServletContext sc=request.getServletContext();
	        ComMet obj=(ComMet)sc.getAttribute("dB");
	        Connection conn = obj.getConnection();
			tp = ContractData.addContract(json,conn);
			ap=ContractData.addAll(json,conn);
//			String con = gson.toJson(tp);
	        out.print("Inserted");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        }
}
