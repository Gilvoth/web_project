package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Doc;
import model.Protocol;
import model.User;
import utils.DocDb;
import utils.ProtocolDb;

/**
 * Servlet implementation class ProtocolViewServlet
 */
@WebServlet("/ProtocolViewServlet")
public class ProtocolViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProtocolViewServlet() {
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
			System.out.println("id документа из ProtocolViewServlet " + id);
			request.setAttribute("id_document", id);
			try {
				ArrayList<Integer> selectIdProtocols = DocDb.selectIdProtocols(id);
				ArrayList<Protocol> protocols = new ArrayList<Protocol>();
				System.out.println(selectIdProtocols);
				for (Integer i:selectIdProtocols) {
					System.out.println("Протокол №"+ i + "  ");
					Protocol protocol = ProtocolDb.selectProtocol(selectIdProtocols.get(i-1));
					protocols.add(protocol);
					System.out.println("Содержание "+ protocol.getContent() + "  ");
				}
				request.setAttribute("protocols", protocols);
			} catch (NullPointerException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.print("Протокол пустой!! ProtocolViewServlet");
			}			
			getServletContext().getRequestDispatcher("/WEB-INF/view/protocolview.jsp").forward(request, response);
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
			System.out.println("id_user из ProtocolViewServlet " + id_user);
			System.out.println("id_protocol из ProtocolViewServlet " + id_protocol);
			System.out.println("id документа из ProtocolViewServlet " + id_document);
			System.out.println("protocol_content документа из ProtocolViewServlet " + protocol_content);      
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
