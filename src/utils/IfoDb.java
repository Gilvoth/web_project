package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import filter.DbFilter;
import model.Ifo;


public class IfoDb {

    public static int insert(Ifo ifo) {
    	Connection conn = DbFilter.getConn(); 
    	
        try{  
            PreparedStatement ps=conn.prepareStatement(  
		            "insert into ifo (id, name)"+
		            "values (nextval('seq_pk_id_ifo'),?)");  
	        
            ps.setString(1, ifo.getName());
           
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
    public static List<String> select() {
    	Connection conn = DbFilter.getConn(); 
    	List<String> ifoes = new ArrayList<String>();

	        Statement statement = null;
			try {
				statement  = ((Connection) conn).createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                   

            try {
          	
            	ResultSet resultSet = statement.executeQuery("Select name FROM ifo");
    			while (resultSet.next()) {
    		        
    		        String name =  resultSet.getString("name");
    		        
    		        ifoes.add(name);
    		        
    		        //System.out.println("тип документа " + name);
    		        
    			}
    		        //System.out.println("запрос выполнен успешно!!!");
    		        
        }catch(SQLException ex){
        	ex.printStackTrace();
        	System.out.println(ex);}
        
        finally {

		}                                   

        
        return ifoes;
    }
//*****************************************************************************************************************
    public static String selectoneStr(int id) {
    	String name = null;
		Connection conn = DbFilter.getConn();

		//Выполним запрос
		String sqlquery = "SELECT name FROM ifo WHERE id = ?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sqlquery)){
            preparedStatement.setInt(1, id);
            ResultSet resultset = preparedStatement.executeQuery();
			while (resultset.next())
				{
                name = resultset.getString(1);
                }
          
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally 
        {/*try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		} 	
        //result это указатель на первую строку с выборки
        //чтобы вывести данные мы будем использовать 
        //метод next() , с помощью которого переходим к следующему элементу
		    	
    	
    	return name;
    	
    } 
//*****************************************************************************************************************
    public static List<Ifo> selectModel() {
    	Connection conn = DbFilter.getConn(); 
    	List<Ifo> ifoes = new ArrayList<Ifo>();

	        Statement statement = null;
			try {
				statement  = ((Connection) conn).createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                   

            try {
          	
            	ResultSet resultSet = statement.executeQuery("Select id, name FROM ifo");
    			while (resultSet.next()) {
    				int id =  resultSet.getInt("id");
    		        String name =  resultSet.getString("name");
    		        Ifo ifo = new Ifo(id, name);    		        
    		        ifoes.add(ifo);    		        
    			}

    		        
        }catch(SQLException ex){
        	ex.printStackTrace();
        	System.out.println(ex);}
        
        finally {

		}                                   

        
        return ifoes;
    }
    
}

