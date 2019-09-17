package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Notification;
import utils.Calendar;
import utils.DocDb;
import utils.NotiificationDb;

/**
 * Servlet implementation class DocEndServlet
 */
@WebServlet("/DocEndServlet")
public class DocEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			System.out.println("id документа " + id);
			
    		// получаем сессию
            HttpSession session = request.getSession();
            //// получаем объект login
            String login = (String) session.getAttribute("login");
            //// получаем объект logineduser
            String loginedUser = (String) session.getAttribute("loginedUser");
            System.out.println("полученный логин из сессии " + login);
            System.out.println("полученный логинUser из сессии " + loginedUser);
        	
            //создаем уведомление, что документ принят (тип уведомления №3 - работа над документом завершена)
        	Notification notification = new Notification(Integer.parseInt(login), 3, Calendar.Date(), id, 0 );
        	int id_notification = NotiificationDb.insert(notification);
        	System.out.println (String.valueOf(id_notification));	
        	
        	DocDb.updateStatus_finishedDoc(id);
			
			//doGet(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
