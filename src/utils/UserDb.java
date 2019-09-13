package utils;


import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import filter.DbFilter;
import model.User;

/**
 * Servlet implementation class UserDb
 */

public class UserDb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDb() {
        super();
        // TODO Auto-generated constructor stub
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
                
                String[] role_arr = (String[])role.getArray();
                ArrayList<String> role_arraylist= new ArrayList<String>();
                Collections.addAll(role_arraylist, role_arr);
                //System.out.println("отработала коллекция");

                
                User user = new User(id, name, second, login, password, id_department, role_arraylist);
                users.add(user);

					
			    System.out.println(//arrayList+
			    		"\t Номер в базе #" + 
			    resultset.getInt("id")
			            + "\t" + name
			            +"\t" + second);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally 
	        {/*try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			} 		    	
    	
    	return users;
    	
    }	
//--------------------------------------------------------------------------------------------------------------------------
    public static User selectone(String login) {
    	User user = null;
		Connection conn = DbFilter.getConn();

		//Выполним запрос
		String sqlquery = "SELECT * FROM users WHERE login = ?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sqlquery)){
            preparedStatement.setString(1, login);
            ResultSet resultset = preparedStatement.executeQuery();
			if (resultset.next())
				{
                int id = resultset.getInt(1);
                String name = resultset.getString(2);
                String second = resultset.getString(3);
                login = resultset.getString(4);
                String password = resultset.getString(5);
                int id_department = resultset.getInt(6);
                Array role = resultset.getArray(7);
                String[] role_arr = (String[])role.getArray();
                ArrayList<String> role_arraylist= new ArrayList<String>();
                Collections.addAll(role_arraylist, role_arr);
                
                
	                user = new User(id, name, second, login, password, id_department, role_arraylist);
	                //users.add(user);
						
				    System.out.println(//arrayList+
				    		"\t Номер в базе #" + 
				    resultset.getInt("id")+"t" +
				    name + "\t" + second + 
				             "\t" + login
				            +"\t" + password);
				}
          
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //result это указатель на первую строку с выборки
        //чтобы вывести данные мы будем использовать 
        //метод next() , с помощью которого переходим к следующему элементу
/*        finally 
        {try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} 			    	
*/    	
    	return user;
    	
    }	
//**********************************************************************************************************************************************	
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
					ArrayList<String> list = new ArrayList<String>(user.getRoles());// realization feature PG JDBC 
					Array array = conn.createArrayOf("text", list.toArray());// realization feature PG JDBC
					preparedStatement.setArray(6, array);					
					preparedStatement.setInt(7, user.getId());
 
                    return  preparedStatement.executeUpdate();
                    
            
        } catch(SQLException ex){
            System.out.println(ex);
        }        
                finally 
    	        {try {
    				conn.close();
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
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
        catch(SQLException ex){
            System.out.println(ex);
                }
            
            finally 
	        {try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
              
            ps.executeUpdate();  
    		        System.out.println("запрос выполнен успешно!!!");
    		 
        }catch(Exception ex){
        	//ex.printStackTrace();
        	System.out.println(ex);}  
                                  

        
        return 0;
    }    
   
    public static User selectone(int id) {
    	User user = null;
		Connection conn = DbFilter.getConn();

		//Выполним запрос
		String sqlquery = "SELECT * FROM users WHERE id = ?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sqlquery)){
            preparedStatement.setInt(1, id);
            ResultSet resultset = preparedStatement.executeQuery();
			if (resultset.next())
				{
                id = resultset.getInt(1);
                String name = resultset.getString(2);
                String second = resultset.getString(3);
                String login = resultset.getString(4);
                String password = resultset.getString(5);
                int id_department = resultset.getInt(6);
                Array role = resultset.getArray(7);
                String[] role_arr = (String[])role.getArray();
                ArrayList<String> role_arraylist= new ArrayList<String>();
                Collections.addAll(role_arraylist, role_arr);
                
                
	                user = new User(id, name, second, login, password, id_department, role_arraylist);
	                //users.add(user);
						
				    System.out.println(//arrayList+
				    		"\t Номер в базе #" + 
				    resultset.getInt("id")+"t" +
				    name + "\t" + second + 
				             "\t" + login
				            +"\t" + password);
				}
          
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally 
        {try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} 	
        //result это указатель на первую строку с выборки
        //чтобы вывести данные мы будем использовать 
        //метод next() , с помощью которого переходим к следующему элементу
		    	
    	
    	return user;
    	
    }
  
    public static String selectoneStr(int id) {
    	String user = null;
		Connection conn = DbFilter.getConn();

		//Выполним запрос
		String sqlquery = "SELECT name,second FROM users WHERE id = ?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sqlquery)){
            preparedStatement.setInt(1, id);
            ResultSet resultset = preparedStatement.executeQuery();
			while (resultset.next())
				{
                String name = resultset.getString(1);
                String second = resultset.getString(2);
                user = name + " " + second;
				}
          
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally 
        {/*try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		} 	
        //result это указатель на первую строку с выборки
        //чтобы вывести данные мы будем использовать 
        //метод next() , с помощью которого переходим к следующему элементу
		    	
    	
    	return user;
    	
    } 

    public static int selectoneInt(String loginedUser) {
    	int user = 0;
		Connection conn = DbFilter.getConn();

		//Выполним запрос
		String sqlquery = "SELECT id FROM users WHERE name = ?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sqlquery)){
            preparedStatement.setString(1, loginedUser);
            ResultSet resultset = preparedStatement.executeQuery();
			while (resultset.next())
				{
                user = resultset.getInt(1);
				}
          
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally 
        {/*try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		} 	
        //result это указатель на первую строку с выборки
        //чтобы вывести данные мы будем использовать 
        //метод next() , с помощью которого переходим к следующему элементу
		    	
    	
    	return user;
    	
    }
    
    public static ArrayList<Integer> selectUserFromDep(int dep) {

		Connection conn = DbFilter.getConn();
		ArrayList<Integer> users = new ArrayList<Integer>();
		//Выполним запрос
		String sqlquery = "SELECT id FROM users WHERE id_department = ?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sqlquery)){
            preparedStatement.setInt(1, dep);
            ResultSet resultset = preparedStatement.executeQuery();

			while (resultset.next())
				{
                int user = resultset.getInt(1);
           
                users.add(user);
				}
			return users;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
		  catch (NullPointerException ex) {
				// TODO Auto-generated catch block
			  System.out.println("ОШИБКА !!! users нулевой");
			  ex.printStackTrace();
		}
        finally {
        	
			
		} 	
        //result это указатель на первую строку с выборки
        //чтобы вывести данные мы будем использовать 
        //метод next() , с помощью которого переходим к следующему элементу
		return users;
		    	
    	

    	
    }       
}
