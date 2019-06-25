package filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import utils.UserDb;

/**
 * Servlet Filter implementation class DbFilter
 */
@WebFilter(urlPatterns = { "/*" }) 
public class DbFilter implements Filter {
	public static Connection conn = null;	

    /**
     * Default constructor. 
     */
    public DbFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		connectDb (); // read Connection conn
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String servletPath = req.getServletPath();
        // Открыть Connection (соединение) только для request со специальной ссылкой
        // (Например ссылка к servlet, jsp, ..)
        // Избегать открытие Connection для обычноых запросов
        // (Например image, css, javascript,... )
        if (servletPath.contains("/LoginPageServlet") )
        	{System.out.println("address is loginpage!");}
        
        

        if (servletPath.contains("/AsupTaskServlet") ) 
    	{System.out.println("address is ASUPpage!");
    	String login = null;
    	String loginedUser = null;

        try {
        	// получаем сессию
            HttpSession session = req.getSession();
        //// получаем объект login
        login = (String) session.getAttribute("login");
        //// получаем объект logineduser
        loginedUser = (String) session.getAttribute("loginedUser");
        System.out.println("полученный логин из сессии" + login);
        System.out.println("полученный логинUser из сессии" + loginedUser);
        
        if (login == null ) {System.out.println("Зайдите пользователем!!"); 
        //String path = req.getContextPath() + "/LoginPageServlet";
        //resp.sendRedirect(path);
        //chain.doFilter(req, resp);
        
        
        //return; 
        }  
          else
          	{System.out.println("Здравствуйте   " + loginedUser + "!! Вы зашли в кабинет администратора");
          	User user = UserDb.selectone(login);
          	System.out.println("Доступные роли пользователя"+user.getRoles());
          	ArrayList<String> roles = user.getRoles();
            //перебор элементов массива
	          	for(String role : roles){
	                
	                System.out.println(role);
	            }
	            // проверяем наличие элемента
	            if(roles.contains("ROLE_ASUP")){
	              
	                System.out.println("ArrayList пользователя contains ROLE_ASUP");
		        	//req.getRequestDispatcher(req.getContextPath() + "/SetRoleServlet");
	                //resp.sendRedirect(req.getContextPath() + "/SetRoleServlet");
		        	
		            //String path = req.getContextPath() + "/SetRoleServlet";
		            //resp.sendRedirect(path);
	                //String contextPath = req.getContextPath();
	                
	                // ==> /ServletTutorial/showMe
	                //resp.sendRedirect(contextPath + "/SetRoleServlet");
	                
	                
	                
		            //chain.doFilter(req, resp);
		            //return;
	            }
          	
          	
          	}        
        }catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();    }
    	}

        System.out.println("DB Filter has been finished!");
		// pass the request along the filter chain
		chain.doFilter(req, resp);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	public void connectDb ()
	{
		if (java.lang.System.getProperty("os.name").equals("Windows 7"))
		{System.out.println("Операционная система Windows 7!");
		String url = "jdbc:postgresql://127.0.0.1:5432/web_db";
        String username = "admin";
        String password = "web_pg";               
        System.out.println("connect 127.0.0.1 ");
    	//////////////////////////////////////////////////////////////////////////////////
        try {
        Class.forName("org.postgresql.Driver");
        System.out.println("PostgreSQL JDBC Driver successfully connected");
        // Создать объект Connection подключенный к database.
        conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
			System.out.println("Connection Failed ClassNotFoundException");
			e.printStackTrace();
        } catch (SQLException e) {
			System.out.println("Connection Failed SQLException");
			e.printStackTrace();
			return;
        }finally {       	
         }			
		
		}
		else {
			System.out.println("Операционная система Windows 10!");
	    	String url = "jdbc:postgresql://10.72.0.128:5432/web_db";
	        String username = "admin";
	        String password = "web_pg";      
	        System.out.println("connect 10.72.0.128 ");
	    	//////////////////////////////////////////////////////////////////////////////////
	        try {
	        Class.forName("org.postgresql.Driver");
	        System.out.println("PostgreSQL JDBC Driver successfully connected");
	        // Создать объект Connection подключенный к database.
	        conn = DriverManager.getConnection(url, username, password);
	        } catch (ClassNotFoundException e) {
				System.out.println("Connection Failed ClassNotFoundException");
				e.printStackTrace();
	        } catch (SQLException e) {
				System.out.println("Connection Failed SQLException");
				e.printStackTrace();
				return;
	        }finally {       	
	         }			
		}
		
	}
    public static Connection getConn() { 
        return conn;
    }
	
	}
	

