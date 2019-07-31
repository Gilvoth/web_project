package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import filter.DbFilter;
import model.Fdoc;
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
    		        
    		        //System.out.println("тип документа " + name);
    		        
    			}
    		        //System.out.println("запрос выполнен успешно!!!");
    		        
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
//*****************************************************************************************************************
    public static Urgency selectUrgency() {
    	Connection conn = DbFilter.getConn(); 
    	Urgency urgencies = new Urgency();

	        Statement statement = null;
			try {
				statement  = ((Connection) conn).createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                   

            try {
          	
            	ResultSet resultSet = statement.executeQuery("Select id,name FROM urgency");
    			while (resultSet.next()) {
    				int id =  resultSet.getInt("id");
    		        String name =  resultSet.getString("name");
    		        
    		        urgencies.setId(id);
    		        urgencies.setName(name);
    		        
    		        //System.out.println("id документа 123" + id);
    		        //System.out.println("имя типа документа 123" + name);
    		        
    			}
    		        //System.out.println("запрос выполнен успешноdgdfgdfgdfg!!!");
    		        
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
    
    
  //*****************************************************************************************************************
    public static ArrayList<Urgency> selectUrgencyArray() {
    	
    	Connection conn = DbFilter.getConn(); 
    	ArrayList<Urgency> urgencies = new ArrayList<Urgency>();
    	 
	        Statement statement = null;
			try {
				statement  = ((Connection) conn).createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			     

            try {
            	
            	ResultSet resultSet = statement.executeQuery("Select id,name FROM urgency");
    			while (resultSet.next()) {
    				int id =  resultSet.getInt("id");
    		        String name =  resultSet.getString("name");
    		        

    		        Urgency urgency = new Urgency(id,name);
    		        urgency.setId(id);
    		        urgency.setName(name);
    		        //System.out.println("id документа!!! " + id);
    		        //System.out.println("имя типа документа!!! " + name);
    		        urgencies.add(urgency);
    		        
    			}
    		        //System.out.println("запрос выполнен успешно!!!");
    		        
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
    
    //**********************************************************************************************************************************************	
    public static int update(int id, String urgency) {
    	Connection conn = DbFilter.getConn();       
        String sql = "UPDATE documents SET id_urgency = (Select id FROM urgency WHERE name = ?) WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){               	
				
					preparedStatement.setString(1, urgency);
					preparedStatement.setInt(2, id);
					System.out.println("Запрос на изменение urgency в документе выполнен!!");
                    return  preparedStatement.executeUpdate();
                    
            
        } catch(SQLException ex){
            System.out.println(ex);
        }        
                finally 
    	        {/*try {
    				conn.close();
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}*/
    			} 	
                
                
              
        return 0;
    }	    
    
    
}
