package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.Calendar;

/**
 * Servlet implementation class EmployeeTaskServlet
 */
@WebServlet("/EmployeeTaskServlet")
public class EmployeeTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeTaskServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login = null;
		
		try {
		// получаем сессию
        HttpSession session = request.getSession();
		String st_date = Calendar.Date();
        // устанавливаем объект с ключом st_date
        session.setAttribute("st_date", st_date);
        
		//// получаем объект login
		login = (String) session.getAttribute("login");
		if (login == null ) {
			System.out.println("Зайдите пользователем!!"); 
			String path = request.getContextPath() + "/LoginPageServlet";
			response.sendRedirect(path);
			return;
		} else {  
			RequestDispatcher dispatcher //
		    = this.getServletContext()//
		    .getRequestDispatcher("/WEB-INF/view/employeeTaskView.jsp");
		    dispatcher.forward(request, response);
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();    
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
