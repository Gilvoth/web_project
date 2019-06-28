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

import model.User;
import utils.UserDb;

/**
 * Servlet implementation class JurTaskServlet
 */
@WebServlet("/JurTaskServlet")
public class JurTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JurTaskServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		String login = null;
		String loginedUser = null;
		
		try {
		// получаем сессию
		HttpSession session = request.getSession();
		//// получаем объект login
		login = (String) session.getAttribute("login");
		//// получаем объект logineduser
		loginedUser = (String) session.getAttribute("loginedUser");
		System.out.println("asuptask полученный логин из сессии " + login);
		System.out.println("asuptask полученный логинUser из сессии " + loginedUser);
		
		if (login == null ) {System.out.println("Зайдите пользователем!!"); 
		String path = request.getContextPath() + "/LoginPageServlet";
		response.sendRedirect(path);
		return; 
		
		}  
		else
		{System.out.println("Здравствуйте   " + loginedUser + "!! Вы зашли в кабинет администратора");
		User user = UserDb.selectone(login);
		System.out.println("Доступные роли пользователя"+user.getRoles());
		ArrayList<String> roles = user.getRoles();
		//перебор элементов массива
		for(String role : roles){
		
		System.out.println(role);
		}
		// проверяем наличие элемента
		if(roles.contains("ROLE_JUR")){
		
		RequestDispatcher dispatcher = null;
		dispatcher //
		= this.getServletContext()//
		.getRequestDispatcher("/WEB-INF/view/jurTaskView.jsp");
		
		dispatcher.forward(request, response);	
		
		}
		else
		{
		
		RequestDispatcher dispatcher = null;
		dispatcher //
		= this.getServletContext()//
		.getRequestDispatcher("/WEB-INF/view/accessDenied.jsp");
		
		dispatcher.forward(request, response);	
		
		}
		}
		}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();    }

}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*
	 * RequestDispatcher dispatcher // = this.getServletContext()//
	 * .getRequestDispatcher("/WEB-INF/view/jurTaskView.jsp");
	 * 
	 * dispatcher.forward(request, response); }
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
