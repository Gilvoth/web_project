package servlet;

import java.io.IOException;
import java.text.ParseException;
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
import utils.DocDb;
import utils.UserDb;
import utils.CreateReport;


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
        String login;
        String loginedUser;
        String filter_docs = "0";

		try {
		// получаем сессию
        HttpSession session = request.getSession();
        //// получаем объект id_department
        id_department = (int) session.getAttribute("id_department");
        System.out.println("Текущий отдел - " + id_department);
        //// получаем объект login
        login = (String) session.getAttribute("login");
        //// получаем объект logineduser
        loginedUser = (String) session.getAttribute("loginedUser");
        System.out.println("полученный логин из сессии " + login);
        System.out.println("полученный логинUser из сессии " + loginedUser);
        System.out.println("полученный id " + UserDb.selectoneInt(loginedUser));
        int id_user = UserDb.selectoneInt(loginedUser);

        try {
        	filter_docs = request.getParameter("filter_docs");
        	if (filter_docs==null) {
                filter_docs = "*";
        	}
        	System.out.println(filter_docs);
        }catch (NullPointerException e) {
        	System.out.println("Параметр не найден!" + e);
        }
        
        
//        ArrayList<Fdoc> docs = DocDb.selectForDep(id_department);
        //ArrayList<Fdoc> docs = DocDb.selectForCurUser_Full(id_user);
        if (filter_docs.equals("*")) {
        	ArrayList<Fdoc> docs = DocDb.selectForCurUser_Full(id_user);         
            request.setAttribute("docs", docs);
            session.setAttribute("docs", docs);
        } else {
        	ArrayList<Fdoc> docs = DocDb.selectForCurUser_Full(id_user, Integer.parseInt(filter_docs));
            request.setAttribute("docs", docs);
            session.setAttribute("docs", docs);
        }

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

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		doGet(request, response);
	}

}
