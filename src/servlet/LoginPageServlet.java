package servlet;

import java.io.IOException;
//import java.util.concurrent.CopyOnWriteArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;
import utils.UserDb;

/**
 * Servlet implementation class LoginPageServlet
 */
@WebServlet("/LoginPageServlet") //alternative declare of servlets
public class LoginPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static String index = "/WEB-INF/view/login.jsp";
	//private CopyOnWriteArrayList<User> users;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
    	//users = new CopyOnWriteArrayList<>(); // create ThreadSafety array, no memory leak
		req.getRequestDispatcher(index).forward(req, resp); // we give login.jsp to PC-user
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
        String login = req.getParameter("login");
        System.out.println("введенный логин ");
        System.out.println(login);
        String password = req.getParameter("password");
        System.out.println("введенный пароль");
        System.out.println(password);
        //User user = DataDao.findUser(login, password);
        //User user = DataDao.findUser(login, password);
        //UserDb.select();
//        users.add(new User(UserDb.selectone(login)));
        //User user = new User(UserDb.selectone(login));
        User user = UserDb.selectone(login);
        //users.add(user);
        if(user != null) {
        System.out.println("Создан объект user!!");
        }else
        {
        	System.out.println("Объект user не существует. Выход!!");
        	doGet(req, resp);
        	return;
        }
          //User loginedUserstatus = AuthUtil.getLoginedUser(req.getSession());
          //AuthUtil.storeLoginedUser(req.getSession(), user);  
  
/*
        if (loginedUserstatus != null) {
            // User Name
            String name = loginedUserstatus.getName();
            String loginedUser = loginedUserstatus.getName();
            System.out.println("userName");            
            System.out.println(name);        
        } 
*/
        
        // получаем сессию
        HttpSession session = req.getSession();
        //// получаем объект name
        String name = (String) session.getAttribute("login");
//        String second = (String) session.getAttribute("second");
         
        //PrintWriter out = resp.getWriter();
        try {
            // если объект ранее не установлен
            if(name == null) {
                // устанавливаем объект с ключом name
                session.setAttribute("login", login);
                session.setAttribute("loginedUser", user.getName());
                session.setAttribute("loginedUserSecond", user.getSecond());
                session.setAttribute("id_department", user.getId_department());
                session.setAttribute("id_creator", user.getId());
                //out.println("Session data are set");
                System.out.println(user.getName());
                System.out.println(user.getSecond());
                System.out.println("Отдел: " + user.getId_department());
                
            }
            else {
                //out.println("Name: " + name);
                // удаляем объект с ключом name
                //session.removeAttribute("name");
            }
        }
        finally {
            //out.close();
//        	resp.sendRedirect("/UserInfoServlet");
        	
        }
        
        
        //AuthUtil.storeLoginedUser(req.getSession(), user);
        /*
         if (users == null) {
            String errorMessage = "Invalid userName or Password";
            System.out.println("Юзераккаунт нулевой");
            req.setAttribute("errorMessage", errorMessage);
 
            RequestDispatcher dispatcher //
                    = this.getServletContext().getRequestDispatcher("/WEB-INF/view/login.jsp");
 
            dispatcher.forward(req, resp);
            return;
        }
 		*/
        System.out.println("создаем сессию Юзераккаунт ");
        
        //req.getRequestDispatcher(index).forward(req, resp);
        resp.sendRedirect(req.getContextPath() + "/UserInfoServlet");
        /* 
        int redirectId = -1;
        try {
            redirectId = Integer.parseInt(req.getParameter("redirectId"));
        } catch (Exception e) {
        }
        */
/*
        if (requestUri != null) {
            resp.sendRedirect(requestUri);
        } else {
            // По умолчанию после успешного входа в систему
            // перенаправить на страницу /userInfo
        	
            resp.sendRedirect(req.getContextPath() + "/UserInfoServlet");
            System.out.println("перенаправляем ");
        }
*/ 
    
	}

}
