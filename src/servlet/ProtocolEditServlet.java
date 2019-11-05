package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Doc;
import model.Notification;
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
        	request.setAttribute("doc", doc);

			
			getServletContext().getRequestDispatcher("/WEB-INF/view/protocoledit.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		
		doGet(request, response);
	}

}
