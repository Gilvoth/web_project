package utils;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import filter.DbFilter;
import model.Department;

public class DepartmentDb {

	   
    public static Department selectone(int id) {
    	
    	Department department = null;
		Connection conn = DbFilter.getConn();

		//Выполним запрос
		String sqlquery = "SELECT id,name,name_boss FROM departments WHERE id = ?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sqlquery)){
            preparedStatement.setInt(1, id);
            ResultSet resultset = preparedStatement.executeQuery();
			if (resultset.next())
				{
                id = resultset.getInt(1);
                String name = resultset.getString(2);
                String name_boss = resultset.getString(3);

                
                
                department = new Department(id, name, name_boss);
	                //users.add(user);
						
				    System.out.println(//arrayList+
				    		"\t Номер в базе #" + 
				    resultset.getInt("id")+"t" +
				    name + "\t" + name_boss);
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
	
    	return department;
    	
    }

    public static ArrayList<Department> selectAll() {
    	
    	ArrayList<Department> departments = new ArrayList<Department>();
		Connection conn = DbFilter.getConn();

		//Выполним запрос
		String sqlquery = "SELECT id,name,name_boss FROM departments";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sqlquery)){
            ResultSet resultset = preparedStatement.executeQuery();
			while (resultset.next())
				{
                int id = resultset.getInt(1);
                String name = resultset.getString(2);
                String name_boss = resultset.getString(3);

                
                
                Department department = new Department(id, name, name_boss);
                departments.add(department);
						
				    System.out.println(//arrayList+
				    		"\t Номер в базе #" + 
				    resultset.getInt("id")+"t" +
				    name + "\t" + name_boss);
				}
          
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally 
        {/*        try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }*/
		} 	
	
    	return departments;
    	
    }    
	
}
