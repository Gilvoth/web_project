package filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
        if (servletPath.contains("/LoginPageServlet") )//|| servletPath.contains("/specialPath2")) 
        	{System.out.println("address is loginpage!");}

        if (servletPath.contains("/AsupTaskServlet") )//|| servletPath.contains("/specialPath2")) 
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
        }catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();    }
        
        if (login == null ) {System.out.println("Зайдите пользователем!!");} //chain.doFilter(request, response);} 
        else
        {System.out.println("Здравствуйте   " + loginedUser + "!! Вы зашли в кабинет администратора");
        User user = UserDb.selectone(login);
        try {
			        if (user.getLogin().equals("1"))
			        	{
			        	System.out.println("Администратор зашёл");
			        	//chain.doFilter(request, response);
			        	}
			        else
			        {
			        	//req.getRequestDispatcher(req.getContextPath() + "/LoginPageServlet").forward(req, resp);
			        	//chain.doFilter(request, response);
			            //resp.sendRedirect(req.getContextPath() + "/LoginPageServlet");
			            System.out.println("перенаправить?? ");
			        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();    }
        }
    }
		System.out.println("DB Filter has been finished!");
		// pass the request along the filter chain
		//chain.doFilter(request, response);
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
			return;// conn;
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
	

