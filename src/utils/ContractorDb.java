package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import filter.DbFilter;
import model.Contractor;

public class ContractorDb {

	

    public static int insert(Contractor contractor) {
    	Connection conn = DbFilter.getConn(); 
    	
        try{  
            PreparedStatement ps=conn.prepareStatement(  
		            "insert into contractor (id, name,comment)"+
		            "values (nextval('seq_pk_id_contractor'),?,?)");  
	        
            ps.setString(1, contractor.getName());
            ps.setString(2, contractor.getComment());
           
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
