package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
//*****************************************************************************************************************
    public static ArrayList<String> select() {
    	Connection conn = DbFilter.getConn(); 
    	ArrayList<String> urgencies = new ArrayList<String>();

	        Statement statement = null;
			try {
				statement  = ((Connection) conn).createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                   

            try {
          	
            	ResultSet resultSet = statement.executeQuery("Select name FROM urgency");
    			while (resultSet.next()) {
    		        
    		        String name =  resultSet.getString("name");
    		        
    		        urgencies.add(name);
    		        
    		        System.out.println("тип документа " + name);
    		        
    			}
    		        System.out.println("запрос выполнен успешно!!!");
    		        
        }catch(SQLException ex){
        	ex.printStackTrace();
        	System.out.println(ex);}
        
        finally {
        /*	try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}                                   

        
        return urgencies;
    } 	    
}
