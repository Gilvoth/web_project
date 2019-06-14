package utils;

import java.io.IOException;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import filter.DbFilter;
import model.User;

/**
 * Servlet implementation class UserDb
 */
//@WebServlet("/UserDb")
public class UserDb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDb() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
    public static ArrayList<User> select() {
    	ArrayList<User> users = new ArrayList<User>();

		Connection conn = DbFilter.getConn();

        Statement statement = null;
		try {
			statement  = ((Connection) conn).createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //Выполним запрос
        ResultSet resultset = null;
		try {
			resultset = statement.executeQuery(
			        "SELECT * FROM users ORDER BY id");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //result это указатель на первую строку с выборки
        //чтобы вывести данные мы будем использовать 
        //метод next() , с помощью которого переходим к следующему элементу
        System.out.println("Выводим statement");
        try {
			while (resultset.next()) {
                int id = resultset.getInt(1);
                String name = resultset.getString(2);
                String second = resultset.getString(3);
                String login = resultset.getString(4);
                String password = resultset.getString(5);
                int id_department = resultset.getInt(6);
                Array role = resultset.getArray(7);
                
				//ArrayList<String> list = new ArrayList<String>(role);
				//1406 Array array = conn.createArrayOf("VARCHAR", role.toArray());
				//preparedStatement.setArray(6, array);
                //String stringArray = resultset.getString(7);
        		//String[] stringArray = { "a", "b", "c", "d", "e" };
        		//ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(stringArray));
        		//String[] stringArr = new String[arrayList.size()];
        		//arrayList.toArray(stringArr);
        		//1306 for (String s : stringArr)
        			//1306 System.out.println(s);
        		//System.out.println(arrayList);
                //String[] roles =  stringArr;
                
                //1406 User user = new User(id, name, second, login, password, id_department, role);
                //User user = new User(id, name, second, login, password, id_department);
                //1406 users.add(user);
					
			    System.out.println(//arrayList+
			    		"\t Номер в базе #" + 
			    resultset.getInt("id")
			            + "\t" + resultset.getString("name")
			            +"\t" + second
			            + "\t" + resultset.getString("role")
			            +"\t" + role);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
								} 		    	
    	
    	return users;
    	
    }	
//--------------------------------------------------------------------------------------------------------------------------
    public static User selectone(int id) {
    	User user = null;
		Connection conn = DbFilter.getConn();

		//Выполним запрос
		String sqlquery = "SELECT * FROM users WHERE id = ?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sqlquery)){
            preparedStatement.setInt(1, id);
            ResultSet resultset = preparedStatement.executeQuery();
			if (resultset.next()) {
                int user_id = resultset.getInt(1);
                String name = resultset.getString(2);
                String second = resultset.getString(3);
                String login = resultset.getString(4);
                String password = resultset.getString(5);
                int id_department = resultset.getInt(6);
                String stringArray = resultset.getString(7);
        		//String[] stringArray = { "a", "b", "c", "d", "e" };
        		ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(stringArray));
        		String[] stringArr = new String[arrayList.size()];
        		arrayList.toArray(stringArr);
        		//for (String s : stringArr)
        			//System.out.println(s);
        		System.out.println(arrayList);

                String[] roles =  stringArr;
                //User user = new User(user_id, name, second, login, password, id_department, roles);
                user = new User(user_id, name, second, login, password, id_department, roles);
                }
                
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //result это указатель на первую строку с выборки
        //чтобы вывести данные мы будем использовать 
        //метод next() , с помощью которого переходим к следующему элементу
		    	
    	
    	return user;
    	
    }	
	
    public static int update(User user) {
    	Connection conn = DbFilter.getConn();       
        String sql = "UPDATE users SET name = ?, second = ?, login = ?, pass = ?, "
        		+ "id_department = ?, role = ? WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                	
					preparedStatement.setString(1, user.getName());
					preparedStatement.setString(2, user.getSecond());
					preparedStatement.setString(3, user.getLogin());
					preparedStatement.setString(4, user.getPassword());
					preparedStatement.setInt(5, user.getId_department());
					//List<String> user2=user.getRoles();
					//preparedStatement.setArray(6, (Array) user.getRoles());//(6, user.getRoles());
					ArrayList<String> list = new ArrayList<String>(user.getRoles());
					Array array = conn.createArrayOf("text[]", list.toArray());
					preparedStatement.setArray(6, array);					
					preparedStatement.setInt(7, user.getId());

					

 
                    return  preparedStatement.executeUpdate();
                    
            
        } catch(Exception ex){
            System.out.println(ex);
        }
                System.out.println("Запрос выполнен!!");
        return 0;
    }	
    
    
    public static int delete(int id) {
    	
    	Connection conn = DbFilter.getConn();
               
            try {
                  
                String sql = "DELETE FROM users WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                      
                    return  preparedStatement.executeUpdate();
                }
            
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }    

    public static int insert(User user) {
    	Connection conn = DbFilter.getConn(); 

        try{  
            PreparedStatement ps=conn.prepareStatement(  
		            "insert into users (id, name, second, login, pass, id_department, role)"+
		            "values (nextval('seq_pk_id_users'),?,?,?,?,?,?)");  
	        
            ps.setString(1, user.getName());  
            ps.setString(2, user.getSecond());  
            ps.setString(3, user.getLogin());  
            ps.setString(4, user.getPassword());  
            ps.setInt(5, user.getId_department());
            ArrayList<String> list = new ArrayList<String>(user.getRoles());
            Array array = conn.createArrayOf("text", list.toArray()); //This is Postgre feature Особенность реализации, преобразуем массив понятный Постгре 
			ps.setArray(6, array);					
			//preparedStatement.setInt(7, user.getId());
              
            ps.executeUpdate();  
    		        System.out.println("запрос выполнен успешно!!!");
    		 
        }catch(Exception ex){
        	//ex.printStackTrace();
        	System.out.println(ex);}  
                                  

        
        return 0;
    }    
    
    public static User selectUser() {
    	User users = new User();

		Connection conn = DbFilter.getConn();

        Statement statement = null;
		try {
			statement  = ((Connection) conn).createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //Выполним запрос
        ResultSet resultset = null;
		try {
			resultset = statement.executeQuery(
			        "SELECT * FROM users ORDER BY id");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //result это указатель на первую строку с выборки
        //чтобы вывести данные мы будем использовать 
        //метод next() , с помощью которого переходим к следующему элементу
        System.out.println("Выводим statement");
        try {
			while (resultset.next()) {
                int id = resultset.getInt(1);
                String name = resultset.getString(2);
                String second = resultset.getString(3);
                String login = resultset.getString(4);
                String password = resultset.getString(5);
                int id_department = resultset.getInt(6);
                String stringArray = resultset.getString(7);
        		//String[] stringArray = { "a", "b", "c", "d", "e" };
        		ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(stringArray));
        		String[] stringArr = new String[arrayList.size()];
        		arrayList.toArray(stringArr);
        		//1306 for (String s : stringArr)
        			//1306 System.out.println(s);
        		//System.out.println(arrayList);

                String[] roles =  stringArr;
                User user = new User(id, name, second, login, password, id_department, roles);
                //User user = new User(id, name, second, login, password, id_department);
                //users.add(user);
					
			    System.out.println(arrayList+"\t Номер в базе #" + resultset.getInt("id")
			            + "\t" + resultset.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
								} 		    	
    	
    	return users;
    	
    }	
//--------------------------------------------------------------------------------------------------------------------------
    
    
}
