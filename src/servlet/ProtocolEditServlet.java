package servlet;

import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Doc;
import model.Notification;
import model.User;
import utils.Calendar;
import utils.DocDb;
import utils.NotiificationDb;

/**
 * Servlet implementation class ProtocolEditServlet
 */
@WebServlet("/ProtocolEditServlet")
public class ProtocolEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProtocolEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			System.out.println("id документа из ProtocolEditServlet " + id);

			Doc doc = DocDb.selectProtocol(id);
				if (!doc.equals(null)) {
				request.setAttribute("id_protocol", doc.getId_protocol());
				request.setAttribute("id_document", id);
				}
			
			getServletContext().getRequestDispatcher("/WEB-INF/view/protocoledit.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
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
		
        // получаем сессию
        HttpSession session = request.getSession();
        //// получаем объект User
        User user = (User) session.getAttribute("user");
		
		int id_user = user.getId();
		try {
			int id_document = Integer.parseInt(request.getParameter("id_document"));
			int id_protocol = Integer.parseInt(request.getParameter("id_protocol"));
			String protocol_content = (String) request.getParameter("protocol_content");
			System.out.println("id_user из ProtocolEditServlet " + id_user);
			System.out.println("id_protocol из ProtocolEditServlet " + id_protocol);
			System.out.println("id документа из ProtocolEditServlet " + id_document);
			System.out.println("protocol_content документа из ProtocolEditServlet " + protocol_content);      
			response.sendRedirect(
					request.getContextPath() + "/ProtocolEditServlet?id=" + id_document);
			//DocDb.updateProtocol(id_document, protocolRecordGeneral);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			getServletContext().getRequestDispatcher("/WEB-INF/view/notfound.jsp").forward(request, response);
		}
	}

}
