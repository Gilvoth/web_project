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
		int id_user = 1;
		try {
			String protocol = request.getParameter("protocol");
			String protocol2 = protocol + "второй";
			System.out.println("protocol документа из ProtocolEditServlet " + protocol);
			List<String> protocolRecord = new ArrayList<String>();
			protocolRecord.add(String.valueOf(id_user));
			protocolRecord.add(protocol);
							List<String> protocolRecord2 = new ArrayList<String>();
							protocolRecord2.add(String.valueOf(id_user));
							protocolRecord2.add(protocol2);
			List<ArrayList<String>> protocolRecordGeneral = new ArrayList<ArrayList<String>>();
			protocolRecordGeneral.add((ArrayList<String>) protocolRecord);
							protocolRecordGeneral.add((ArrayList<String>) protocolRecord2);													
			System.out.println("protocolRecordGeneral документа из ProtocolEditServlet " + protocolRecordGeneral);
        
			
			DocDb.updateProtocol(6, protocolRecordGeneral);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//doGet(request, response);
	}

}
