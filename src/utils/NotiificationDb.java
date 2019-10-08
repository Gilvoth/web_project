package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
    
  //*****************************************************************************************************************	
    public static ArrayList<Notification> selectAll() {
    	Connection conn = DbFilter.getConn();
    	ArrayList<Notification> notifications = new ArrayList<Notification>();
	        Statement statement = null;
			try {
				statement  = ((Connection) conn).createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                   

            try {
          	
            	ResultSet resultSet = statement.executeQuery
            			/*("Select id, id_creator, id_type, date, id_document, id_receiver,"
            					+ "type_notifications.id as type_notify_id,  type_notifications.name as type_notify_name "
            					+ " FROM notifications "
            					+ "LEFT JOIN type_notifications ON notifications.id_type = type_notifications.id       "
            					+ "ORDER BY notifications.id DESC");*/
            	("Select notifications.id, notifications.id_creator, notifications.id_type, notifications.date, "  +
            	"notifications.id_document, notifications.id_receiver, " +
            	"type_notifications.id as type_notify_id,  type_notifications.name as type_notify_name " +
            	"FROM notifications "+
            	"LEFT JOIN type_notifications ON notifications.id_type = type_notifications.id "+
            	"ORDER BY notifications.id DESC");
            	
    			while (resultSet.next()) {
    				int id = resultSet.getInt("id");
    				int id_creator = resultSet.getInt("id_creator");
    				int id_type= resultSet.getInt("id_type");
    				String date = resultSet.getString("date");
    				int id_document = resultSet.getInt("id_document");
    				int id_receiver = resultSet.getInt("id_receiver");
    				String type_notify_name = resultSet.getString("type_notify_name");
    				Notification notification = new Notification(id, id_creator, id_type, date, id_document, id_receiver, type_notify_name);
    				if (!notification.equals(null)) {
        				notifications.add(notification);    					
    				}

    			}
    		        System.out.println("полная выборка уведомления выполнена успешно!!!");
    		        
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

	        return notifications;        

    }
    //*****************************************************************************************************************	
    public static ArrayList<Notification> selectId(int id_doc) {
    	Connection conn = DbFilter.getConn();
    	ArrayList<Notification> notifications = new ArrayList<Notification>();
			
			//Выполним запрос
			String sqlquery = "Select notifications.id, notifications.id_creator, notifications.id_type, notifications.date, "  +
	            	"notifications.id_document, notifications.id_receiver , " +
	            	"type_notifications.id as type_notify_id,  type_notifications.name as type_notify_name, "
	            	+ "users.id as users_id, users.name as users_name, users.second as users_second "	            	
	            	+ "FROM notifications "
	            	+ "LEFT JOIN type_notifications ON notifications.id_type = type_notifications.id "
/*	            	+ "LEFT JOIN users ON (notifications.id_creator = users.id) AND (notifications.id_receiver = users.id) " */
	            	+ "LEFT JOIN users ON (notifications.id_creator = users.id) "
	            	+ "WHERE id_document = ? "
	            	+ "ORDER BY notifications.id DESC";                   
	        try (PreparedStatement preparedStatement = conn.prepareStatement(sqlquery)){
	            preparedStatement.setInt(1, id_doc);
	            ResultSet resultSet = preparedStatement.executeQuery();
    			while (resultSet.next()) {
    				int id = resultSet.getInt("id");
    				int id_creator = resultSet.getInt("id_creator");
    				int id_type= resultSet.getInt("id_type");
    				String date = resultSet.getString("date");
    				int id_document = resultSet.getInt("id_document");
    				int id_receiver = resultSet.getInt("id_receiver");
    				String type_notify_name = resultSet.getString("type_notify_name");
    				String users_name = resultSet.getString("users_name");
    				String users_second = resultSet.getString("users_second");
    				Notification notification = new Notification(id, id_creator, id_type, date, id_document, id_receiver, type_notify_name, users_name, users_second);
    				if (!notification.equals(null)) {
        				notifications.add(notification);    					
    					}
    			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        
        finally {
        	/*try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}                                   

	        return notifications;        

    }    
}
