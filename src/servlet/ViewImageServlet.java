package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import filter.DbFilter;
import java.io.InputStream;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Servlet implementation class ViewImageServlet
 */
@WebServlet("/ViewImageServlet")
public class ViewImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = null;
		try {
			id = request.getParameter("id");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	
    	if (id!=null) {
	    	Connection conn = DbFilter.getConn();
	        String query = "select documents.blob from documents where id="+id;
	        Statement st = null;
			try {
				st = conn.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        ResultSet rs = null;
			try {
				rs = st.executeQuery(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	        try {
				rs.next();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        byte[] bytearray = new byte[4096];
	        int size = 0;
	        InputStream sImage = null;
	        try {
				sImage = rs.getBinaryStream(1);
				rs.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Нет изображения!!!");
				e.printStackTrace();
			} finally {

			}
	        
	        
	        
	        response.reset();
	        response.setContentType("image/jpeg");
	        response.addHeader("Content-Disposition", "filename=getimage.jpeg");
			if (sImage==null)
				{
				System.out.println("Нет изображения!!!");
				
				
				getServletContext().getRequestDispatcher("/WEB-INF/view/notfound.jsp").forward(request, response);
				return;
				}
				else {
			        while ((size = sImage.read(bytearray)) != -1) {
			        	response.getOutputStream().write(bytearray, 0, size);
			        }			        
			        response.flushBuffer();
			        sImage.close();
		        			        
					}

    	}else
    		System.out.println("Отсутствует параметр!!!");
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String id = null;
		try {
			id = request.getParameter("id");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	
    	if (id!=null) {
	    	Connection conn = DbFilter.getConn();
	        String query = "select documents.blob from documents where id="+id;
	        Statement st = null;
			try {
				st = conn.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        ResultSet rs = null;
			try {
				rs = st.executeQuery(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	        try {
				rs.next();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        byte[] bytearray = new byte[4096];
	        int size = 0;
	        InputStream sImage = null;
	        try {
				sImage = rs.getBinaryStream(1);
				rs.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Нет изображения!!!");
				e.printStackTrace();
			} finally {

			}
	        
	        
	        
	        response.reset();
	        response.setContentType("image/jpeg");
	        response.addHeader("Content-Disposition", "filename=getimage.jpeg");
			if (sImage==null)
				{
				System.out.println("Нет изображения!!!");
				
				
				getServletContext().getRequestDispatcher("/WEB-INF/view/notfound.jsp").forward(request, response);
				return;
				}
				else {
			        while ((size = sImage.read(bytearray)) != -1) {
			        	response.getOutputStream().write(bytearray, 0, size);
			        }			        
			        response.flushBuffer();
			        sImage.close();
		        			        
					}

    	}else
    		System.out.println("Отсутствует параметр!!!");

	

	}
		
		
		
		
	

}
