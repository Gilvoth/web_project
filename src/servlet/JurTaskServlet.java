package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Fdoc;
import model.User;
import utils.DocDb;
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
		int id_department = 0;
		try {
		// получаем сессию
		HttpSession session = request.getSession();
		//// получаем объект login
		login = (String) session.getAttribute("login");
		//// получаем объект logineduser
		loginedUser = (String) session.getAttribute("loginedUser");
		//// получаем объект id_department
		id_department = (int) session.getAttribute("id_department");
		
		System.out.println("jurTask полученный логин из сессии " + login);
		System.out.println("jurTask полученный логинUser из сессии " + loginedUser);
		System.out.println("jurTask полученный id_department из сессии " + id_department);
		
		
		if (login == null ) {System.out.println("Зайдите пользователем!!"); 
		String path = request.getContextPath() + "/LoginPageServlet";
		response.sendRedirect(path);
		return; 
		
		}  
		else
		{System.out.println("Здравствуйте   " + loginedUser + "!! Вы зашли в кабинет юриста");
		User user = UserDb.selectone(login);
		System.out.println("Доступные роли пользователя" + user.getRoles());
		ArrayList<String> roles = user.getRoles();
		//перебор элементов массива
		for(String role : roles){
		
		System.out.println(role);
		}
		// проверяем наличие элемента
		if(roles.contains("ROLE_JUR")){
			List<Integer> users = UserDb.selectUserFromDep(id_department);
			System.out.println("успешно взят список юзеров " + users.get(0) + " " + users.get(1));
			ArrayList<Fdoc> allusers = null;
			for (int user2: users) {
				System.out.println("id user " + user2);
		        ArrayList<Fdoc> docs = DocDb.selectForCurUser_Full(user2);   
		        request.setAttribute("docs", docs);
		        if (allusers.isEmpty()){
		        	allusers.addAll(0, docs);
		        } else {
		        allusers.addAll(docs);
		        }

				
			}
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
