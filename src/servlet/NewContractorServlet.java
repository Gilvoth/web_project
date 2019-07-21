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

import model.Contractor;
import utils.ContractorDb;
import utils.Type_docsDb;


/**
 * Servlet implementation class NewContractorServlet
 */
@WebServlet("/NewContractorServlet")
public class NewContractorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewContractorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	    
		ArrayList<String> contractors = ContractorDb.select();
		request.setAttribute("contractors", contractors);		
		
		RequestDispatcher dispatcher //
          = this.getServletContext()//
                .getRequestDispatcher("/WEB-INF/view/newcontractor.jsp");

    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        int id = 0;
        String name =  null;
        String comment = null;
       
        try {
        name = request.getParameter("name");//read from html form
        comment = request.getParameter("comment");//read from html form
        
        }catch(Exception ex){ex.printStackTrace();} 
        
        if (name.isEmpty()==true) 
        {
        System.out.println("Введите обязательные поля!!!"); 		
              
		doGet(request, response);
        }
        else {
    	    try{
    	    	Contractor contractor = new Contractor (id, name,comment);
    	    	ContractorDb.insert(contractor);
    	    	
    	    }catch(Exception ex){ex.printStackTrace();}         
        		}

        PrintWriter writer = response.getWriter();
        writer.println("<p>Контрагент с этими данными успешно зарегистрирован в системе!"+"</p>");
        writer.println("<p>Имя: " + name + "</p>");
        writer.println("<p>Комментарий: " + comment + "</p>");
        writer.println("<a href=/web_app>Главная страница</a>");
        writer.println("<br>");        
        writer.println("<form method=[GET] "+
    		 "accept-charset=[UTF-8] "+
    				"action=EmployeeTaskServlet>"+
    						"<input type=\"submit\" value=\"Назад\">"+
    						 "</form>");        
			}


}
