package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AsupTaskServlet
 */
@WebServlet("/AsupTaskServlet")
public class AsupTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AsupTaskServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = null;
    	dispatcher //
        = this.getServletContext()//
        .getRequestDispatcher("/WEB-INF/view/asupTaskView.jsp");
    	//String login = null;
		/*
    	try {// получаем сессию
        HttpSession session = request.getSession();
        //// получаем объект name
        login = (String) session.getAttribute("login");
        System.out.println("Зашёл " + login);

        
		} catch (Exception e) {e.printStackTrace();
	    }
		
        while (login != null)
        {   	
	        if (login.equals("1"))
	        {		dispatcher //
	            = this.getServletContext()//
	            .getRequestDispatcher("/WEB-INF/view/asupTaskView.jsp");}
        }
	*/
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
