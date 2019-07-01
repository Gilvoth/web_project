package servlet;

//import model.User;
//import utils.UserDb;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import utils.Calendar;

@WebServlet({ "/", "/index" })
//@SuppressWarnings("serial") // or declare 	private static final long serialVersionUID = 1L;
public class IndexPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static String index = "/WEB-INF/view/index.jsp";

	
    public IndexPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {    	
		  //users = new CopyOnWriteArrayList<>(); // create ThreadSafety array, no memory leak
    	RequestDispatcher dispatcher //
        = this.getServletContext().getRequestDispatcher(index);
    	dispatcher.forward(req, resp);        
    }
	
	
	  
	  
	  @Override 
	  public void init() throws ServletException{ 
		  System.out.println("Сегодняшняя дата " + Calendar.Date());
		  System.out.println("*************SERVLET IS INIT**************");
		  
	  }
	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {
	    	req.setCharacterEncoding("UTF-8"); // set using codepage
	    	doGet(req,resp);
	    	System.out.println("*************do Get**************");
	    }



}
