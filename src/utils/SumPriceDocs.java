package utils;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import filter.DbFilter;
import model.Doc;
public class SumPriceDocs {

	
    public static List<Doc> sumPrices() {
    	List<Doc> sumPrices = new ArrayList<Doc> ();
    	Connection conn = DbFilter.getConn();
    	Doc doc = null;
		//Выполним запрос
		String sqlquery =					
				"SELECT \r\n" + 
				"num,\r\n" + 
				"SUM(price) as price\r\n" +
				"FROM documents\r\n" + 
				"GROUP BY num;";
		
        try (PreparedStatement preparedStatement = conn.prepareStatement(sqlquery)){
            ResultSet resultset = preparedStatement.executeQuery();		
    			while (resultset.next()) {
    				String num =  resultset.getString("num");
    				BigDecimal price = resultset.getBigDecimal("price");
    		        
    				doc = new Doc (num, price);

    				sumPrices.add(doc);
                
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
    	
    	return sumPrices;
    	
    }	
	
	
	
}
