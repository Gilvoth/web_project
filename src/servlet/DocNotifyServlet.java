package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Fdoc;
import model.Notification;
import utils.NotiificationDb;

/**
 * Servlet implementation class DocNotifyServlet
 */
@WebServlet("/DocNotifyServlet")
public class DocNotifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static String index = "/WEB-INF/view/docnotify.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocNotifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		try {
			int id_doc = Integer.parseInt(request.getParameter("id_doc"));
			System.out.println("id документа " + id_doc);
			ArrayList<Notification> notifications = NotiificationDb.selectId(6);
			request.setAttribute("notifications", notifications);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher(index).forward(request, response);
		//req.getRequestDispatcher(index).forward(req, resp); // we give login.jsp to PC-user getServletContext().
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
