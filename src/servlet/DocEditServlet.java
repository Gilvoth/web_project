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
	            //ArrayList<String> contractors = СontractorDb.select();
	            //ArrayList<Type_docs> type_docs =  Type_docsDb.selectType_docs();
	            if(doc!=null) {
	                request.setAttribute("doc", doc);
	                request.setAttribute("image", "C:\\tmp\\0001.png");
	                
	                //*******************
	               /* try{
	                    String fileName = request.getParameter("image");             
	                    FileInputStream fis = new FileInputStream(new File("d:\\"+fileName));
	                    BufferedInputStream bis = new BufferedInputStream(fis);             
	                    response.setContentType(contentType);
	                    BufferedOutputStream output = new BufferedOutputStream(response.getOutputStream());
	                    for (int data; (data = bis.read()) > -1;) {
	                      output.write(data);
	                    }             
	                 }
	                 catch(IOException e){

	                 }finally{
	                     // close the streams
	                 }
	                //*************
	                */
	                
	                //request.setAttribute("image", doc.getBlob()); 
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
		doGet(request, response);
	}

}
