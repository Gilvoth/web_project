package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Fdoc;
import utils.DocDb;


/**
 * Servlet implementation class UserInfoServlet
 */
@WebServlet("/UserInfoServlet")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        int id_department;
		try {
		// получаем сессию
        HttpSession session = request.getSession();
        //// получаем объект id_department
        id_department = (int) session.getAttribute("id_department");
        System.out.println("Текущий отдел - " + id_department);
        ArrayList<Fdoc> docs = DocDb.selectForDep(id_department);
        request.setAttribute("docs", docs);
        }catch ( Exception e) {
        	System.out.println("Зайдите пользователем!!"); 
            String path = request.getContextPath() + "/LoginPageServlet";
            response.sendRedirect(path);
            return; 
        }
        
		
		
	      RequestDispatcher dispatcher //
          = this.getServletContext().getRequestDispatcher("/WEB-INF/view/userInfoView.jsp");

    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
