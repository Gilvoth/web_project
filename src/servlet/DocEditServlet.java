package servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Array;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import filter.DbFilter;
import model.Division;
import model.Fdoc;
import model.Law;
import model.Notification;
import model.Tru;
import utils.DocDb;
import utils.LawDb;
import utils.NotiificationDb;
import utils.TruDb;
import utils.Type_docsDb;
import utils.UrgencyDb;
import utils.Calendar;
import utils.ContractorDb;
import utils.DivisionDb;

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
	            List<Tru> trues =  TruDb.selectModel();
				List<Law> laws = LawDb.selectModel();
				List<Division> divisions = DivisionDb.selectModel();	

	            if(doc!=null) {
	                request.setAttribute("doc", doc);
	                //request.setAttribute("image", "C:\\tmp\\0001.png");
	                
	                request.setAttribute("image", doc.getBlob()); 
	                request.setAttribute("type_docs", type_docs);
	                request.setAttribute("contractors", contractors);
	                request.setAttribute("urgencies", urgencies);
	    			if (!trues.isEmpty()) {
	    				System.out.println("Взят trues!!");
	    			request.setAttribute("trues", trues);
	    				}
	    			if (!laws.isEmpty()) {
	    				System.out.println("Взят laws!!");
	    			request.setAttribute("laws", laws);
	    				}
	    			if (!divisions.isEmpty()) {
	    				System.out.println("Взят divisions!!");
	    			request.setAttribute("divisions", divisions);
	    				}			

//*********************************************************************************************************************************
	                try {
	            		// получаем сессию
	                    HttpSession session = request.getSession();
	                    //// получаем объект login
	                    String login = (String) session.getAttribute("login");
	                    //// получаем объект logineduser
	                    String loginedUser = (String) session.getAttribute("loginedUser");
	                    System.out.println("полученный логин из сессии " + login);
	                    System.out.println("полученный логинUser из сессии " + loginedUser);
               	                	
	                	id = Integer.parseInt(request.getParameter("id"));
	                	//String id_user = (request.getParameter("id_user"));
	                	//System.out.println ("id документа= " + id + "  " + "Пользователь id_user= "+ id_user);
	                	System.out.println ("id документа= " + id);
	                	
	                	//создаем уведомление, что документ принят (тип уведомления №1 - получение )
	                	Notification notification = new Notification(Integer.parseInt(login), 1, Calendar.Date(), id, 0 );
	                	int id_notification = NotiificationDb.insert(notification);
	                	System.out.println (String.valueOf(id_notification));
	                	
	                	Connection conn2 = DbFilter.getConn(); 
	                    List<String> receiver_arraylist = new ArrayList<String>();
	                    receiver_arraylist.add(login);
	                    receiver_arraylist.add(String.valueOf(id_notification));
	                    Array receiver_list = conn2.createArrayOf("text", receiver_arraylist.toArray()); //This is Postgre feature Особенность реализации, преобразуем массив понятный Постгре 
	                    
	                	
	                	DocDb.updateSender_listDoc(id, receiver_list);
	                	
	                	

	                	System.out.println("Чтение завершено!! ");
	                    //doGet(request, response);
	                }catch (Exception ex)
	                {
	                	
	                }	                
//*********************************************************************************************************************************	                
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
            
            String doc_tru = request.getParameter("doc_tru");
            String tru = request.getParameter("tru");
            String doc_law = request.getParameter("doc_law");
            String law = request.getParameter("law");
            String doc_division = request.getParameter("doc_division");
            String division = request.getParameter("division");
            String price = request.getParameter("price");        
            String price2 = request.getParameter("price2");
            String paid = request.getParameter("paid");
            String add_agr = request.getParameter("add_agr"); 
            String add_agr2 = request.getParameter("add_agr2"); 
            String price_add_agr = request.getParameter("price_add_agr");
            String price_add_agr2 = request.getParameter("price_add_agr2");
            System.out.println("Статус paid = " + paid);
            

            
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
            
            if (!doc_tru.equals(tru))
            {	
            	DocDb.updateTru(id, tru);
            	System.out.println("Изменилось ТРУ!");            	
            }
            if (!doc_law.equals(law))
            {	
            	DocDb.updateLaw(id, law);
            	System.out.println("Изменилcя вид закона!");            	
            }
            if (!doc_division.equals(division))
            {	
            	DocDb.updateDivision(id, division);
            	System.out.println("Изменились данные подразделения!");            	
            }
            
            
            if (!price.equals(price2))
            {	
            	DocDb.updatePrice(id, new BigDecimal(price));
            	System.out.println("Изменилась сумма!");            	
            }
            
            if (!add_agr.equals(add_agr2))
            {	
            	DocDb.updateAdd_agr(id, add_agr);
            	System.out.println("Изменилcя доп. соглашение!");            	
            }
      
            if (!price_add_agr.equals(price_add_agr2))
            {	
            	DocDb.updatePrice_add_agr(id, new BigDecimal(price_add_agr));
            	System.out.println("Изменилась сумма по доп. соглашению!");            	
            }

            //if (paid.equals("on"))
            if (paid != null)
            {	            	
            	DocDb.updatePaid(id, true);
            	System.out.println("Изменился факт проплаты true!");            	
            } else {
            	DocDb.updatePaid(id, false);
            	System.out.println("Изменился факт проплаты false!"); 
            }
            
            

            doGet(request, response);
        }catch (Exception ex)
        {
        	
        }
		
		
	}

}
