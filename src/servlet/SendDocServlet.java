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
import javax.servlet.http.HttpSession;

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
    		// получаем сессию
            HttpSession session = request.getSession();

            //// получаем объект login
            String login = (String) session.getAttribute("login");
            //// получаем объект logineduser
            String loginedUser = (String) session.getAttribute("loginedUser");
            System.out.println("полученный логин из сессии " + login);
            System.out.println("полученный логинUser из сессии " + loginedUser);
        	
        	
        	int id = Integer.parseInt(request.getParameter("id"));
        	String id_user = (request.getParameter("id_user"));
        	System.out.println ("id= " + id + "  " + "id_user= "+ id_user);
        	
        	User userModel = UserDb.selectone(login);
        	Notification notification = new Notification(userModel.getId(), 2, Calendar.Date(), id, Integer.parseInt(id_user) );
        	int id_notification = NotiificationDb.insert(notification);
        	System.out.println (String.valueOf(id_notification));
        	
        	Connection conn = DbFilter.getConn(); 
            List<String> sender_arraylist = new ArrayList<String>();
            sender_arraylist.add(String.valueOf (userModel.getId()));
            sender_arraylist.add(String.valueOf(id_notification));
            Array sender_list = conn.createArrayOf("text", sender_arraylist.toArray()); //This is Postgre feature Особенность реализации, преобразуем массив понятный Постгре 

        	Connection conn2 = DbFilter.getConn(); 
            List<String> receiver_arraylist = new ArrayList<String>();
            receiver_arraylist.add(id_user);
            receiver_arraylist.add(null);
            Array receiver_list = conn2.createArrayOf("text", receiver_arraylist.toArray()); //This is Postgre feature Особенность реализации, преобразуем массив понятный Постгре 
            
        	
        	DocDb.updateSender_listDoc(id, sender_list, receiver_list);
        	
        	


            doGet(request, response);
        }catch (Exception ex)
        {
        	
        }
		//doGet(request, response);
	}

}
