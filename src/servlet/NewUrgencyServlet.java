package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Type_docs;
import model.Urgency;
import utils.Type_docsDb;
import utils.UrgencyDb;

/**
 * Servlet implementation class NewUrgencyServlet
 */
@WebServlet("/NewUrgencyServlet")
public class NewUrgencyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUrgencyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	      RequestDispatcher dispatcher //
          = this.getServletContext()//
                .getRequestDispatcher("/WEB-INF/view/newurgency.jsp");

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
    	    	Urgency urgency = new Urgency (id, name);
    	    	UrgencyDb.insert(urgency);
    	    	
    	    }catch(Exception ex){ex.printStackTrace();}         
        		}

			}
	

}
