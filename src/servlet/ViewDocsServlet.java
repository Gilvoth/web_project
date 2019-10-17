package servlet;

import java.io.IOException;
import java.util.ArrayList;
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
import utils.CreateReport;
import utils.DocDb;
import utils.UserDb;

/**
 * Servlet implementation class ViewDocsServlet
 */
@WebServlet("/ViewDocsServlet")
public class ViewDocsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewDocsServlet() {
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
			System.out.println("полученный логин из сессии " + login);
			System.out.println("полученный логинUser из сессии " + loginedUser);
			
			
			if (login == null ) {
				System.out.println("Зайдите пользователем!!"); 
				String path = request.getContextPath() + "/LoginPageServlet";
				response.sendRedirect(path);
				return; 
			
			}else{
				//// получаем объект id_department
				id_department = (int) session.getAttribute("id_department");
				System.out.println("jurTask полученный id_department из сессии " + id_department);
				System.out.println("Здравствуйте   " + loginedUser + "!! Вы зашли в кабинет юриста");
				User user = UserDb.selectone(login);
				System.out.println("Доступные роли пользователя" + user.getRoles());
				ArrayList<String> roles = user.getRoles();
				//перебор элементов массива
				for(String role : roles){			
				System.out.println(role);
				}
				// проверяем наличие элемента
				if(roles.contains("ROLE_JUR")){
					ArrayList<Fdoc> docs = null;
					docs = DocDb.selectAllFull();
					
					System.out.println("размер массива из селекта : " + docs.size());
					request.setAttribute("docs_size", docs.size());
					request.setAttribute("docs", docs);
					request.setAttribute("user", user);
					session.setAttribute("docs", docs); // присваиваем сессии для выгрузки отчёта
					session.setAttribute("user", user); // присваиваем сессии для использовании при редактировании документа
					RequestDispatcher dispatcher //
					= this.getServletContext()//
					.getRequestDispatcher("/WEB-INF/view/viewdocs.jsp");
					
					dispatcher.forward(request, response);			
				}else{		
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String filepath = null;
		try {			
			// получаем сессию если есть
	        HttpSession session = request.getSession(true);
	        ArrayList<Fdoc> fdocs = (ArrayList<Fdoc>) session.getAttribute("docs");
	        System.out.println("полученный docs из сессии " + fdocs.get(0));
	        Fdoc name = fdocs.get(0);
	        String name2 = name.getName();
	        System.out.println("полученный name2 docs из сессии " + name2);
	        System.out.println("закончен ли " + fdocs.get(0).getStatus_finished());
	        filepath = request.getParameter("filepath");
	        System.out.println(filepath);
	        CreateReport.createReport(fdocs, filepath);
	        
	        //new ProcessBuilder("D:\\soft\\Captura-Setup.exe").start();
	        //new ProcessBuilder("D:\\soft\\cmd.exe").start();
	        
	        //Runtime.getRuntime().exec("D:\\soft\\Captura-Setup.exe");
	        
	        //Process proc = Runtime.getRuntime().exec("D:\\soft\\YUMI-2.0.5.0.exe");
	        //proc.wait();
	        
	        // указываем в конструкторе ProcessBuilder,
	        // что нужно запустить программу ls с параметрами -l /dev
	        ProcessBuilder procBuilder = new ProcessBuilder("D:\\soft\\Captura-Setup.exe");  
	         
	        // перенаправляем стандартный поток ошибок на
	        // стандартный вывод
	        procBuilder.redirectErrorStream(true);
	        
	        // запуск программы
	        Process process = procBuilder.start();
	        


		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		doGet(request, response);
	}

}
