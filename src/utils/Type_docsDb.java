package utils;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
    		        //System.out.println("запрос выполнен успешно!!!");
    		 
        }catch(Exception ex){
        	ex.printStackTrace();
        	System.out.println(ex);}  
        
        finally {
        	try {
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
    	ArrayList<String> type_docs = new ArrayList<String>();

	        Statement statement = null;
			try {
				statement  = ((Connection) conn).createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                   

            try {
          	
            	ResultSet resultSet = statement.executeQuery("Select name FROM type_docs");
    			while (resultSet.next()) {
    		        
    		        String name =  resultSet.getString("name");
    		        
    		        type_docs.add(name);
    		        
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
        return type_docs;
    } 	
//*****************************************************************************************************************
    public static ArrayList<Type_docs> selectType_docs() {
    	Connection conn = DbFilter.getConn(); 
    	ArrayList<Type_docs>  type_docs = new ArrayList<Type_docs> ();

        Statement statement = null;
		try {
			statement  = ((Connection) conn).createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
            
			try {
				ResultSet resultSet = statement.executeQuery
						("Select * FROM type_docs");
    			while (resultSet.next()) {
    		        int id = resultSet.getInt("id");
    		        String name =  resultSet.getString("name");
    		        Type_docs type_doc = new Type_docs(id, name);
    		        type_docs.add(type_doc);
    		        
    		        
    			}
    			
    		        //System.out.println("запрос выполнен успешно!!!");
    		        
        }catch(Exception ex){
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

        
        return type_docs;
    }
    
    public static int update(int id, String id_type) {
    	Connection conn = DbFilter.getConn();       
        String sql = "UPDATE documents SET id_type_docs = (Select id FROM type_docs WHERE name = ?) WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){               	
				
					preparedStatement.setString(1, id_type);
					preparedStatement.setInt(2, id);
					System.out.println("Запрос на изменение id_type в документе выполнен!!");
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
