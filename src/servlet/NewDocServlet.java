package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Doc;
import utils.Calendar;
import utils.DocDb;

/**
 * Servlet implementation class NewDocServlet
 */
@WebServlet("/NewDocServlet")
public class NewDocServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewDocServlet() {
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
                .getRequestDispatcher("/WEB-INF/view/newdoc.jsp");

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
        int id_type =  0;
        int id_contractor =  0;
        byte[] blob =  null;
        String name =  null;
        String content =  null;
        int creator =  0;
        int id_urgency =  0;
        String date_cre =  null;
        int status_finished =  0;
        String rec_date =  null;
        ArrayList<String> receiver_list =  null;
        ArrayList<String> sender_list =  null;
        int current_dep =  0;
        
        try {
        id_type = Integer.parseInt(request.getParameter("id_type"));//read from html form
        id_contractor = Integer.parseInt(request.getParameter("id_contractor"));//read from html form
        name = request.getParameter("name");//read from html form
        content = request.getParameter("content");//read from html form
        creator = Integer.parseInt((request.getParameter("creator")));//read from html form + convert to Integer
        id_urgency = Integer.parseInt((request.getParameter("id_urgency")));
        date_cre = Calendar.Date();
        //status_finished = Integer.parseInt((request.getParameter("status_finished")));
        status_finished = 0;
        rec_date = Calendar.Date();
        
        
        String[] receiver_m = {""};
        receiver_m = request.getParameterValues("receiver_m");//read role from html form input (name role)
        receiver_list = new ArrayList<String>(Arrays.asList(receiver_m));
        
        String[] sender_list_m = {""};
        sender_list_m = request.getParameterValues("sender_m");//read role from html form input (name role)
        sender_list = new ArrayList<String>(Arrays.asList(sender_list_m));
        
        current_dep = Integer.parseInt((request.getParameter("current_dep")));
        
        }catch(Exception ex){ex.printStackTrace();} 
        
        if (name.isEmpty()==true | content.isEmpty()==true) 
        {
        System.out.println("Введите обязательные поля!!!"); 		
        
        
		doGet(request, response);
        }
        else {
    	    try{
    	    	
    	    	//ArrayList<String> users = new ArrayList<>();
    	    	Doc doc = new Doc (id_type, id_contractor, name, content, creator, 
    	    			id_urgency, date_cre, status_finished, rec_date, receiver_list, sender_list, current_dep);
    	    	DocDb.insert(doc);
    	    	
    	    }catch(Exception ex){ex.printStackTrace();}         
        		}

			}
}