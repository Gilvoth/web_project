package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import model.Fdoc;
import utils.DocDb;
import utils.Type_docsDb;
import utils.UrgencyDb;
import utils.ContractorDb;

/**
 * Servlet implementation class DocEditServlet
 */
@WebServlet("/DocEditServlet")
public class DocEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//ArrayList<String> type_docs =  Type_docsDb.select();
	       try {
	            int id = Integer.parseInt(request.getParameter("id"));
	            
	            Fdoc doc = DocDb.selectone2(id); // Заменить на селектван2
	            ArrayList<String> type_docs =  Type_docsDb.select();
	            ArrayList<String> contractors =  ContractorDb.select();
	            ArrayList<String> urgencies =  UrgencyDb.select();

	            if(doc!=null) {
	                request.setAttribute("doc", doc);
	                //request.setAttribute("image", "C:\\tmp\\0001.png");
	                
	                request.setAttribute("image", doc.getBlob()); 
	                request.setAttribute("type_docs", type_docs);
	                request.setAttribute("contractors", contractors);
	                request.setAttribute("urgencies", urgencies);
	                getServletContext().getRequestDispatcher("/WEB-INF/view/docedit.jsp").forward(request, response);
	            }
	            else {
	                getServletContext().getRequestDispatcher("/WEB-INF/view/notfound.jsp").forward(request, response);
	            }
	        }
	        catch(Exception ex) {
	            getServletContext().getRequestDispatcher("/WEB-INF/view/notfound.jsp").forward(request, response);
	        }	
	}

	  @Override 
	  public void init() throws ServletException{ 

		  System.out.println("*************SERVLET IS INIT DocEditServlet**************");
		  
	  }	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		
        try {
        	int id = Integer.parseInt(request.getParameter("id"));
            String doc_urgency = request.getParameter("doc_urgency");
            String urgency = request.getParameter("urgency");
            //int id_urgency = Integer.parseInt (request.getParameter("id_urgency"));
            String doc_id_type = request.getParameter("doc_id_type");
            String id_type = request.getParameter("id_type");
            String content = request.getParameter("content");
            String content2 = request.getParameter("content2");
            String name = request.getParameter("name");
            String name2 = request.getParameter("name2");
            String rec_date = request.getParameter("rec_date");
            String rec_date2 = request.getParameter("rec_date2");
            
            
            if (!doc_urgency.equals(urgency) )
            {
            	UrgencyDb.update(id, urgency);
            	System.out.println("Изменился статус срочности!");
            }
            if (!doc_id_type.equals(id_type))
            {
            	Type_docsDb.update(id, id_type);
            	System.out.println("Изменился тип!");
            }
            
	        if (!name.equals(name2))
	        {
	        	DocDb.updateName(id, name);
	        	System.out.println("Изменилось имя!");
	        }
	        
            if (!content.equals(content2))
            {	
            	DocDb.updateContent(id, content);
            	System.out.println("Изменилось содержание!");
            	
            }
            if (!rec_date.equals(rec_date2))
            {	
            	DocDb.updateRecDate(id, rec_date);
            	System.out.println("Изменилась рек. дата!");
            	
            }

            doGet(request, response);
        }catch (Exception ex)
        {
        	
        }
		
		
	}

}
