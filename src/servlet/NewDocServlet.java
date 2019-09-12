package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Array;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import filter.DbFilter;
import model.Contractor;
import model.Department;
import model.Division;
import model.Doc;
import model.Law;
import model.Tru;
import model.Type_docs;
import model.Urgency;
import utils.Calendar;
import utils.ContractorDb;
import utils.DepartmentDb;
import utils.DivisionDb;
import utils.DocDb;
import utils.LawDb;
import utils.TruDb;
import utils.Type_docsDb;
import utils.UrgencyDb;

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
		try 
		{
	        // получаем сессию
	        HttpSession session = request.getSession();
	        //// получаем объект id_department
	        int id_department = (int) session.getAttribute("id_department");
	        System.out.println("Текущий отдел - " + id_department);
	        //// получаем объект id_creator, name+second
	        int id_creator = (int) session.getAttribute("id_creator");
	        String loginedUser = (String) session.getAttribute("loginedUser");
	        String loginedUserSecond = (String) session.getAttribute("loginedUserSecond");
	        System.out.println("Текущий автор - " + id_creator + "\n" + loginedUser + "\n" + loginedUserSecond);
	        
			ArrayList<Type_docs> type_docs =  Type_docsDb.selectType_docs();
			ArrayList<Contractor> contractors = ContractorDb.selectContractors();
			ArrayList<Urgency> urgencies = UrgencyDb.selectUrgencyArray();
			ArrayList<Tru> trues =  TruDb.selectModel();
			List<Law> laws = LawDb.selectModel();
			List<Division> divisions = DivisionDb.selectModel();
			Department department = DepartmentDb.selectone(id_department);
			
			

			
			
			if (!type_docs.isEmpty()) {
				System.out.println("Взят тип документа!!");
			request.setAttribute("type_docs", type_docs);
				}
			if (!contractors.isEmpty()) {
				System.out.println("Взят контрагент!!");
			request.setAttribute("contractors", contractors);
				}
			if (!urgencies.isEmpty()) {
				System.out.println("Взят статус срочности!!");
			request.setAttribute("urgencies", urgencies);
				}
			if (department != null) {
				System.out.println("Взят отдел!!");
			request.setAttribute("department", department);
				}
			
			if (!trues.isEmpty()) {
				System.out.println("Взят trues!!");
			request.setAttribute("trues", trues);
				}
			if (!laws.isEmpty()) {
				System.out.println("Взят laws!!");
			request.setAttribute("laws", laws);
				}
			if (!laws.isEmpty()) {
				System.out.println("Взят laws!!");
			request.setAttribute("laws", laws);
				}
			if (!divisions.isEmpty()) {
				System.out.println("Взят divisions!!");
			request.setAttribute("divisions", divisions);
				}			
			
		}
		catch(Exception ex){ex.printStackTrace();} 
		finally
		{
			
		}
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
        //int id = 0;
        int id_type =  0;
        int id_contractor =  0;
        //byte[] blob =  null;
        String name =  null;
        String content =  null;
        int creator =  0;
        int id_urgency =  0;
        String date_cre =  null;
        int status_finished =  0;
        String rec_date =  null;
        //ArrayList<String> receiver_list =  null;
        //ArrayList<String> sender_list =  null;
        int current_dep =  0;
		String date_registry =  null;
		int id_tru =  0;
		int id_law =  0;	
		int id_division =  0;
		BigDecimal price =  null;
		boolean paid = false;
		String add_agr =  null; 
		BigDecimal price_add_agr =  null;	
		//ArrayList<Integer> ifo =  null;

        
        
        try {
        id_type = Integer.parseInt(request.getParameter("id_type"));//read from html form
        id_contractor = Integer.parseInt(request.getParameter("id_contractor"));//read from html form
        //InputStream is = part.getInputStream();
        //blob = request.getInputStream();
        name = request.getParameter("name");//read from html form
        content = request.getParameter("content");//read from html form
        creator = Integer.parseInt((request.getParameter("creator")));//read from html form + convert to Integer
        id_urgency = Integer.parseInt((request.getParameter("id_urgency")));
        date_cre = Calendar.Date();
        //status_finished = Integer.parseInt((request.getParameter("status_finished")));
        status_finished = 0;
        rec_date = request.getParameter("rec_date");
        
        
        //String[] receiver_m = {""};
        //receiver_m = request.getParameterValues("receiver_m");//read role from html form input (name role)
        //receiver_list = new ArrayList<String>(Arrays.asList(receiver_m));
        //receiver_list = null;
        
        //String[] sender_list_m = {""};
        //sender_list_m = request.getParameterValues("sender_m");//read role from html form input (name role)
        //sender_list = new ArrayList<String>(Arrays.asList(sender_list_m));
        //sender_list = null;
        
         current_dep = Integer.parseInt((request.getParameter("current_dep")));
		 //date_registry =  "-";
		 //id_tru =  1;//исправить
		 id_tru = Integer.parseInt((request.getParameter("id_tru")));//read from html form + convert to Integer
		 //id_law =  1;//исправить	
		 id_law = Integer.parseInt((request.getParameter("id_law")));//read from html form + convert to Integer
		 //id_division =  1;//исправить
		 id_division = Integer.parseInt((request.getParameter("id_division")));//read from html form + convert to Integer
		 //price = BigDecimal.valueOf(1);
		 paid = false;
		 //add_agr =  "-"; 
		 //price_add_agr = BigDecimal.valueOf(1);	
		 
        

        
        }catch(Exception ex){ex.printStackTrace();} 
        
        if (name.isEmpty()==true | content.isEmpty()==true) 
        {
        System.out.println("Введите обязательные поля!!!"); 		
        
        
		doGet(request, response);
        }
        else {
    	    try{
    	        ArrayList<String> receiver_list = new ArrayList<String>();
    	        receiver_list.add(0, String.valueOf(creator));
    	        receiver_list.add(1, null);
    	        
    	        ArrayList<String> sender_list = new ArrayList<String>();
    	        sender_list.add(0, String.valueOf(creator));
    	        sender_list.add(1, null);
    	        
    	        ArrayList<Integer> ifo = new ArrayList<Integer>();
    	        ifo.add(0, null);
    	        //ifo.add(1, null);
    	        
    	    	Doc doc = new Doc (id_type, id_contractor, name, content, creator, 
    	    			id_urgency, date_cre, status_finished, rec_date, receiver_list, sender_list, current_dep,
    	    			date_registry, id_tru, id_law, id_division, price,
    	    			 paid, add_agr, price_add_agr, ifo);
    	    	DocDb.insert(doc);

    	    	
    	    	
    	    	
			      RequestDispatcher dispatcher //
		          = this.getServletContext()//
		                .getRequestDispatcher("/WEB-INF/view/employeeTaskView.jsp");

		    dispatcher.forward(request, response);
    	    }catch(Exception ex){ex.printStackTrace();}         
        		}

			}
}