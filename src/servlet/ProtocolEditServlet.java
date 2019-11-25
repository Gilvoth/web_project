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
import model.Protocol;
import model.User;
import utils.Calendar;
import utils.DocDb;
import utils.NotiificationDb;
import utils.ProtocolDb;

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
		int id_document = 0;
		try {
			id_document = Integer.parseInt(request.getParameter("id_document"));
			request.setAttribute("id_document", id_document);
			System.out.println("id документа из ProtocolEditServlet " + id_document);
	        // получаем сессию
	        HttpSession session = request.getSession();
	        //// получаем объект name
	        User user = (User) session.getAttribute("user");
	        System.out.println("user  " + user.getId());

			try {
				ArrayList<Integer> selectIdProtocols = DocDb.selectIdProtocols(id_document);
				List<Protocol> protocols = new ArrayList<Protocol>();
				System.out.println(selectIdProtocols);
				for (Integer i:selectIdProtocols) {
					System.out.println("Протокол №"+ i + "  ");
					Protocol protocol = ProtocolDb.selectProtocolForUser(i, user.getId());					
					System.out.println("Содержание "+ protocol.getContent() + "  ");
					System.out.println("id_protocol " + protocol.getId());
					protocols.add(protocol);
				}
				request.setAttribute("protocols", protocols);

			} catch (NullPointerException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.print("Протокол пустой!! ProtocolEditServlet");
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
			//int id_protocol = Integer.parseInt(request.getParameter("id_protocol"));
			String protocol_content = (String) request.getParameter("protocol_content");
			System.out.println("id_user из ProtocolEditServlet " + id_user);
			//System.out.println("id_protocol из ProtocolEditServlet " + id_protocol);
			System.out.println("id документа из ProtocolEditServlet " + id_document);
			System.out.println("protocol_content документа из ProtocolEditServlet " + protocol_content);      
			DocDb.insertProtocol(protocol_content, id_user);
			response.sendRedirect(
					request.getContextPath() + "/ProtocolViewServlet?id=" + id_document);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			getServletContext().getRequestDispatcher("/WEB-INF/view/notfound.jsp").forward(request, response);
		}
	}

}
