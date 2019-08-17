package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Department;
import model.Fdoc;
import utils.ContractorDb;
import utils.DepartmentDb;
import utils.DocDb;
import utils.Type_docsDb;
import utils.UrgencyDb;

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
	            request.setAttribute("departments", departments);
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
        	int id_dep = Integer.parseInt(request.getParameter("id_dep"));
        	DocDb.updateDepDoc(id, id_dep);



            doGet(request, response);
        }catch (Exception ex)
        {
        	
        }
		//doGet(request, response);
	}

}
