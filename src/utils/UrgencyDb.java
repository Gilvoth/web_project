package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import filter.DbFilter;
import model.Urgency;

public class UrgencyDb {

    public static int insert(Urgency urgency) {
    	Connection conn = DbFilter.getConn(); 
    	
        try{  
            PreparedStatement ps=conn.prepareStatement(  
		            "insert into urgency (id, name)"+
		            "values (nextval('seq_pk_urgency'),?)");  
	        
            ps.setString(1, urgency.getName());
           
            ps.executeUpdate();  
    		        System.out.println("запрос выполнен успешно!!!");
    		 
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
	
}
