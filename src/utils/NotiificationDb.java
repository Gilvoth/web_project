package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import filter.DbFilter;
import model.Notification;


public class NotiificationDb {

	
    public static int insert(Notification notification) {
    	Connection conn = DbFilter.getConn(); 
    	
        try{  
            PreparedStatement ps=conn.prepareStatement(  
		            "insert into notifications (id, id_creator, id_type, date, id_document, id_receiver)"+
		            "values (nextval('seq_pk_id_notifications'),?, ?, ?, ?, ?)");  
	        
            ps.setInt(1, notification.getId_creator());
            ps.setInt(2, notification.getId_type());
            ps.setString(3, notification.getDate());
            ps.setInt(4, notification.getId_document());
            ps.setInt(5, notification.getId_receiver());
           
            ps.executeUpdate();  
    		        //System.out.println("запрос выполнен успешно!!!");
    		 
        }catch(Exception ex){
        	
        	System.out.println(ex);}  
        finally 
        {
        	
        	/*try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		}                                  

        
        return selectIdNotification();
    } 	
//*****************************************************************************************************************	
    public static int selectIdNotification() {
    	Connection conn = DbFilter.getConn();
    	int last_value = 0;


	        Statement statement = null;
			try {
				statement  = ((Connection) conn).createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                   

            try {
          	
            	ResultSet resultSet = statement.executeQuery("Select last_value FROM seq_pk_id_notifications");
    			while (resultSet.next()) {
    		        
    		        last_value =  resultSet.getInt("last_value");  		        
    		        System.out.println("last_value " + last_value);

    		        
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

	        return last_value;        

    } 	    	
}
