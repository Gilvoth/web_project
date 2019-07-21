package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Type_docs;
import model.User;
import utils.Type_docsDb;
import utils.UserDb;

/**
 * Servlet implementation class NewType_docsServlet
 */
@WebServlet("/NewType_docsServlet")
public class NewType_docsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewType_docsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    
		ArrayList<String> type_docs2 = Type_docsDb.select();
		request.setAttribute("type_docs2", type_docs2);
        
		//request.getRequestDispatcher("/WEB-INF/view/newtype_docs.jsp").forward(request, response); // we give SetRole.jsp to PC-user
		
		RequestDispatcher dispatcher //
          = this.getServletContext()//
                .getRequestDispatcher("/WEB-INF/view/newtype_docs.jsp");

    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        int id = 0;
        String name =  null;
       
        try {
        name = request.getParameter("name");//read from html form
        
        }catch(Exception ex){ex.printStackTrace();} 
        
        if (name.isEmpty()==true) 
        {
        System.out.println("Введите обязательные поля!!!"); 		
              
		doGet(request, response);
        }
        else {
    	    try{
    	    	Type_docs type_docs = new Type_docs (id, name);
    	    	Type_docsDb.insert(type_docs);
    	    	
    	    }catch(Exception ex){ex.printStackTrace();}         
        		}
        PrintWriter writer = response.getWriter();
        writer.println("<p>Тип документа с этими данными успешно зарегистрирован в системе!"+"</p>");
        writer.println("<p>Имя: " + name + "</p>");
        writer.println("<a href=/web_app>Главная страница</a>");
        writer.println("<br>");        
        writer.println("<form method=[GET] "+
    		 "accept-charset=[UTF-8] "+
    				"action=EmployeeTaskServlet>"+
    						"<input type=\"submit\" value=\"Назад\">"+
    						 "</form>"); 
			}

}
