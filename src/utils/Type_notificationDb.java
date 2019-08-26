package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import filter.DbFilter;
import model.Type_notification;


public class Type_notificationDb {


    public static int insert(Type_notification type_notification) {
    	Connection conn = DbFilter.getConn(); 
    	
        try{  
            PreparedStatement ps=conn.prepareStatement(  
		            "insert into type_notifications (id, name)"+
		            "values (nextval('seq_pk_id_type_notifications'),?)");  
	        
            ps.setString(1, type_notification.getName());
           
            ps.executeUpdate();  
    		        //System.out.println("запрос выполнен успешно!!!");
    		 
        }catch(Exception ex){
        	ex.printStackTrace();
        	System.out.println(ex);}  
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
//*****************************************************************************************************************	
    
    public static ArrayList<String> select() {
    	Connection conn = DbFilter.getConn(); 
    	ArrayList<String> type_notifications = new ArrayList<String>();

	        Statement statement = null;
			try {
				statement  = ((Connection) conn).createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                   

            try {
          	
            	ResultSet resultSet = statement.executeQuery("Select name FROM type_notifications");
    			while (resultSet.next()) {
    		        
    		        String name =  resultSet.getString("name");
    		        
    		        type_notifications.add(name);
    		        
    		        System.out.println("type_notification " + name);
    		        
    			}
    		        System.out.println("полный запрос выполнен успешно!!!");
    		        
        }catch(SQLException ex){
        	ex.printStackTrace();
        	System.out.println(ex);}
        
        finally {
        	/*try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}                                   

        
        return type_notifications;
    } 	    

    
  //*****************************************************************************************************************	
	
}
