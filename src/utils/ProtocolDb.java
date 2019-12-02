package utils;

import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import filter.DbFilter;
import model.Doc;
import model.Protocol;

public class ProtocolDb {

    public ProtocolDb() {
        super();
        // TODO Auto-generated constructor stub
    }
    
//  ***********************************************************************************************************************************      
    public static Protocol selectProtocol(int id) {
		Connection conn = DbFilter.getConn();
		Protocol protocol = null;
    	int id_protocol = 0;
    	String content = null;
    	java.sql.Date date;
    	int id_user = 0;
		//Выполним запрос
		String sqlquery =					
		"SELECT	protocols.id, protocols.content, protocols.date, protocols.id_user FROM protocols WHERE protocols.id = ?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sqlquery)){
            preparedStatement.setInt(1, id);
            ResultSet resultset = preparedStatement.executeQuery();		
            while (resultset.next()) {
            	id_protocol = resultset.getInt("id");
            	content = resultset.getString("content");
            	date = resultset.getDate("date");
            	id_user = resultset.getInt("id_user");
				/*
				 * Array id_protocol = resultset.getArray("id_protocol"); Integer[]
				 * id_protocol_arr = (Integer[])id_protocol.getArray(); ArrayList<Integer>
				 * id_protocol_arraylist= new ArrayList<Integer>();
				 * Collections.addAll(id_protocol_arraylist, id_protocol_arr);
				 */
				/*
				 * 
				 * if (id_protocol_arraylist.equals(null)) { //id_protocol=1999;
				 * System.out.print("Протокол пустой"); }
				 */
            	protocol = new Protocol (id_protocol, content, date.toLocalDate(), id_user);
                //return protocol;
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally 
	        {
/*        	try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();		
			}							*/
			} 		    	
    	
    	return protocol;
    	
    }
    
    
//  ***********************************************************************************************************************************      
    public static Protocol selectProtocolForUser(int id, int id_userUser) {
		Connection conn = DbFilter.getConn();
		Protocol protocol = null;
    	int id_protocol = 0;
    	String content = null;
    	java.sql.Date date;
    	int id_user = 0;
		//Выполним запрос
		String sqlquery =					
		"SELECT	protocols.id, protocols.content, protocols.date, protocols.id_user FROM protocols WHERE protocols.id = ? AND protocols.id_user = ?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sqlquery)){
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, id_userUser);
            ResultSet resultset = preparedStatement.executeQuery();		
            while (resultset.next()) {
            	id_protocol = resultset.getInt("id");
            	content = resultset.getString("content");
            	date = resultset.getDate("date");
            	id_user = resultset.getInt("id_user");
				/*
				 * Array id_protocol = resultset.getArray("id_protocol"); Integer[]
				 * id_protocol_arr = (Integer[])id_protocol.getArray(); ArrayList<Integer>
				 * id_protocol_arraylist= new ArrayList<Integer>();
				 * Collections.addAll(id_protocol_arraylist, id_protocol_arr);
				 */
				/*
				 * 
				 * if (id_protocol_arraylist.equals(null)) { //id_protocol=1999;
				 * System.out.print("Протокол пустой"); }
				 */
            	protocol = new Protocol (id_protocol, content, date.toLocalDate(), id_user);
                //return protocol;
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally 
	        {
/*        	try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();		
			}							*/
			} 		    	
    	
    	return protocol;
    	
    }
    
    
}
