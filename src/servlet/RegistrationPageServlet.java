package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import filter.DbFilter;
import model.User;
import utils.UserDb;


/**
 * Servlet implementation class RegistrationPageServlet
 */
@WebServlet("/RegistrationPageServlet")
public class RegistrationPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static String index = "/WEB-INF/view/registration.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


@Override 
	  public void init() throws ServletException{ 
		  System.out.println("*************REG SERVLET IS INIT**************");
		  
		  
	  }    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		Connection conn = DbFilter.getConn();
		
		
		
        Statement statement = null;
		try {
			statement  = ((Connection) conn).createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //Выполним запрос
        ResultSet result1 = null;
		try {
			result1 = statement.executeQuery(
			        "SELECT * FROM departments where id >0");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //result это указатель на первую строку с выборки
        //чтобы вывести данные мы будем использовать 
        //метод next() , с помощью которого переходим к следующему элементу
        System.out.println("Выводим statement");
        try {
			while (result1.next()) {
			    System.out.println("Номер в выборке #" + result1.getRow()
			            + "\t Номер в базе #" + result1.getInt("id")
			            + "\t" + result1.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
								}   		
		*/
		
		
		req.getRequestDispatcher(index).forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        String name = null; // init 
        String second =  null; // init 
        String login =  null; // init 
        String pass =  null; // init 
        Integer id_department = null; // init 
        ArrayList<String> role_arr = null; // init 
        try {
        name = req.getParameter("name");//read name from html form
        second = req.getParameter("second");//read second from html form
        login = req.getParameter("login");//read login from html form
        pass = req.getParameter("pass");//read pass from html form
        id_department = Integer.parseInt((req.getParameter("id_department")));//read department from html form + convert to Integer
        String[] role = {""};
        role = req.getParameterValues("role");//read role from html form input (name role)
        role_arr = new ArrayList<String>(Arrays.asList(role));
        }catch(Exception ex){ex.printStackTrace();} 
        
        if (name.isEmpty()==true | second.isEmpty()==true | login.isEmpty()==true | pass.isEmpty()==true ) 
        {
        System.out.println("Введите обязательные поля!!!"); 
        //PrintWriter writer = resp.getWriter();
        //writer.println("alert(Введите обязательные поля!!!!)"+"</p>");
        
        doGet(req, resp);
        }
        else {
        	if (java.lang.System.getProperty("os.name").equals("Windows 7"))
    	    {
    	            
    		        try{  
    	    	    	User user = new User(name,second,login,pass,id_department, role_arr);
    	    	    	UserDb.insert(user);
    		        }catch(Exception ex){ex.printStackTrace();}  
    	    	
    	    } else 

    	    try{
    	    	
    	    	//ArrayList<String> users = new ArrayList<>();
    	    	User user = new User(name,second,login,pass,id_department, role_arr);
    	    	UserDb.insert(user);
    	    	
    	    }catch(Exception ex){ex.printStackTrace();} 

        PrintWriter writer = resp.getWriter();
        writer.println("<p>Пользователь с этими данными успешно зарегистрирован в системе!"+"</p>");
        writer.println("<p>Имя: " + name + "</p>");
        writer.println("<p>Фамилия: " + second + "</p>");
        writer.println("<p>Логин: " + login + "</p>");
        writer.println("<p>Отдел: " + id_department + "</p>");
        writer.println("<a href=/web_app>Главная страница</a>");
                
 writer.println("<form method=[GET] "+
 		 "accept-charset=[UTF-8] "+
 				"action=LoginPageServlet>"+
 						"<input type=\"submit\" value=\"Назад\">"+
 						 "</form>");
			  
		  
		  
        	}

	}
}
