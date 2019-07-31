package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import filter.DbFilter;
import model.Contractor;

public class ContractorDb {

    public ContractorDb() {
        super();
        // TODO Auto-generated constructor stub
    }		

    public static int insert(Contractor contractor) {
    	Connection conn = DbFilter.getConn(); 
    	
        try{  
            PreparedStatement ps=conn.prepareStatement(  
		            "insert into contractor (id, name,comment)"+
		            "values (nextval('seq_pk_id_contractor'),?,?)");  
	        
            ps.setString(1, contractor.getName());
            ps.setString(2, contractor.getComment());
           
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
    
    
    public static ArrayList<String> select() {
    	Connection conn = DbFilter.getConn(); 
    	ArrayList<String> contractors = new ArrayList<String>();

	        Statement statement = null;
			try {
				statement  = ((Connection) conn).createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                   

            try {
          	
            	ResultSet resultSet = statement.executeQuery("Select name FROM contractor");
    			while (resultSet.next()) {
    		        
    		        String name =  resultSet.getString("name");
    		        
    		        contractors.add(name);
    		        
    		        //System.out.println("контрагент " + name);
    		        
    			}
    		        //System.out.println("запрос выполнен успешно!!!");
    		        
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

        
        return contractors;
    } 	    
	
}
