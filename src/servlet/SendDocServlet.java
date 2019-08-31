package servlet;

import java.io.IOException;
import java.sql.Array;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import filter.DbFilter;
import model.Department;
import model.Notification;
import model.User;
import utils.Calendar;
import utils.DepartmentDb;
import utils.DocDb;
import utils.NotiificationDb;
import utils.UserDb;

/**
 * Servlet implementation class SendDocServlet
 */
@WebServlet("/SendDocServlet")
public class SendDocServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendDocServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	       try {
	            int id = Integer.parseInt(request.getParameter("id"));
	            request.setAttribute("id", id);
	            ArrayList<Department> departments = DepartmentDb.selectAll();
	            ArrayList<User> users = UserDb.select();
	            request.setAttribute("departments", departments);
	            request.setAttribute("users", users);
	            getServletContext().getRequestDispatcher("/WEB-INF/view/senddoc.jsp").forward(request, response);
	        }
	        catch(Exception ex) {
	            getServletContext().getRequestDispatcher("/WEB-INF/view/notfound.jsp").forward(request, response);
	        }	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		
        try {
        	int id = Integer.parseInt(request.getParameter("id"));
        	/*int id_dep = Integer.parseInt(request.getParameter("id_dep"));
        	DocDb.updateDepDoc(id, id_dep);*/
        	String id_user = (request.getParameter("id_user"));
        	System.out.println (id + "   " + id_user);
        	
        	Notification notification = new Notification(99, 2, Calendar.Date(), id, Integer.parseInt(id_user) );
        	int id_notification = NotiificationDb.insert(notification);
        	System.out.println (String.valueOf(id_notification));
        	
        	Connection conn = DbFilter.getConn(); 
            List<String> sender_arraylist = new ArrayList<String>();
            sender_arraylist.add(id_user);
            sender_arraylist.add(String.valueOf(id_notification));
            Array sender_list = conn.createArrayOf("text", sender_arraylist.toArray()); //This is Postgre feature Особенность реализации, преобразуем массив понятный Постгре 
			
        	
        	DocDb.updateSender_listDoc(id, sender_list);
        	
        	


            doGet(request, response);
        }catch (Exception ex)
        {
        	
        }
		//doGet(request, response);
	}

}
