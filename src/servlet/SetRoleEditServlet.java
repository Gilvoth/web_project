package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import utils.UserDb;

/**
 * Servlet implementation class SetRoleEditServlet
 */
@WebServlet("/SetRoleEditServlet")
public class SetRoleEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetRoleEditServlet() {
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
	            User user = UserDb.selectone(id);
	            if(user!=null) {
	                request.setAttribute("user", user);
	                getServletContext().getRequestDispatcher("/WEB-INF/view/setroleedit.jsp").forward(request, response);
	            }
	            else {
	                getServletContext().getRequestDispatcher("/WEB-INF/view/notfound.jsp").forward(request, response);
	            }
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
		
		//doGet(request, response);
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String second = request.getParameter("second");
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            int id_department = Integer.parseInt(request.getParameter("id_department"));
            //String roles = request.getParameter("roles");
            //1606 String[] roles = request.getParameterValues("roles");
            
            String[] role = {""};
            role = request.getParameterValues("role");//read role from html form input (name role)
            ArrayList<String> role_arr = new ArrayList<String>(Arrays.asList(role));

            
            User user = new User(id, name, second, login, password, id_department, role_arr);
            
            UserDb.update(user);
            response.sendRedirect(request.getContextPath() + "/SetRoleServlet");
        }
        catch(Exception ex) {
             
            getServletContext().getRequestDispatcher("/WEB-INF/view/notfound.jsp").forward(request, response);   
        }
		
		
	}

}
