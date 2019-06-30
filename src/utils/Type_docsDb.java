package utils;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import filter.DbFilter;
import model.Type_docs;

public class Type_docsDb {

    public Type_docsDb() {
        super();
        // TODO Auto-generated constructor stub
    }	
	
    public static int insert(Type_docs type_docs) {
    	Connection conn = DbFilter.getConn(); 
    	
        try{  
            PreparedStatement ps=conn.prepareStatement(  
		            "insert into type_docs (id, name)"+
		            "values (nextval('seq_pk_type_docs'),?)");  
	        
            ps.setString(1, type_docs.getName());
           
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
