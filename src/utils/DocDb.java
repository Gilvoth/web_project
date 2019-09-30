package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import filter.DbFilter;
import model.Doc;
import model.Fdoc;
import model.User;



public class DocDb {

    public DocDb() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public static int insert(Doc doc) throws FileNotFoundException {
    	Connection conn = DbFilter.getConn(); 
    	
        try{
            //File file = new File("C:\\tmp\\0001.png");
            //File file = new File("C:\\tmp\\0001.png");
            //FileInputStream fis = new FileInputStream(file);
            //FileInputStream fis = new FileInputStream(file);
            
            PreparedStatement ps=conn.prepareStatement(  
		            "insert into documents (id, id_type_docs, id_contractor, name, "
		            + "content, creator, id_urgency, date_cre, status_finished, rec_date, receiver_list, sender_list, current_dep, blob,"
		            + "date_registry, id_tru, id_law, id_division, price, paid, add_agr, price_add_agr, id_ifo)"+
		            "values (nextval('seq_pk_id_docs'),?,?,?,?,?,?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?)");  
	        
            ps.setInt(1, doc.getId_type());
            ps.setInt(2, doc.getId_contractor());
            ps.setString(3, doc.getName());
            ps.setString(4, doc.getContent());
            ps.setInt(5, doc.getCreator());  
            ps.setInt(6, doc.getId_urgency());
            ps.setString(7, doc.getDate_cre());  
            ps.setInt(8, doc.getStatus_finished());
            ps.setString(9, doc.getRec_date());
            
            
            ArrayList<String> list = new ArrayList<String>(doc.getReceiver_list());
            Array array = conn.createArrayOf("text", list.toArray()); //This is Postgre feature Особенность реализации, преобразуем массив понятный Постгре 
			ps.setArray(10, array);
			
            ArrayList<String> list2 = new ArrayList<String>(doc.getSender_list());
            Array array2 = conn.createArrayOf("text", list2.toArray()); //This is Postgre feature Особенность реализации, преобразуем массив понятный Постгре 
			ps.setArray(11, array2);
			
			ps.setInt(12, doc.getCurrent_dep()); 
			//ps.setBinaryStream(13, fis, (int)file.length()); // BLOB
			ps.setNull(13, java.sql.Types.ARRAY); // load null 
			
			//добавить новые поля
			ps.setString(14, doc.getDate_registry());
			ps.setInt(15, doc.getId_tru());
			ps.setInt(16, doc.getId_law());
			ps.setInt(17, doc.getId_division());
			ps.setBigDecimal(18, doc.getPrice());
			ps.setBoolean(19, doc.isPaid());
			ps.setString(20, doc.getAdd_agr());
			ps.setBigDecimal(21, doc.getPrice_add_agr());
            
			ArrayList<Integer> ifo = new ArrayList<Integer>(doc.getIfo());
            Array array3 = conn.createArrayOf("integer", ifo.toArray()); //This is Postgre feature Особенность реализации, преобразуем массив понятный Постгре 
			ps.setArray(22, array3);

			
            ps.executeUpdate();  
            //fis.close();
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

//***********************************************************************************************************************************
    public static Fdoc selectone(int id) {
		Connection conn = DbFilter.getConn();
    	Fdoc fdoc = null;
		//Выполним запрос
		String sqlquery =					
				/*"SELECT \r\n" + 
				"(SELECT documents.id FROM documents WHERE documents.id=?) as \"id\",\r\n" + 
				"type_docs.name as \"type\",\r\n" + 
				"contractor.name as \"contractor\",\r\n" + 
				"documents.name as \"name\",\r\n" + 
				"documents.content as \"content\",\r\n" + 
				"users.name as \"creator_name\",\r\n" + 
				"users.second as \"creator_second\",\r\n" + 
				"urgency.name as \"urgency\",\r\n" + 
				"documents.date_cre,\r\n" + 
				"documents.status_finished,\r\n" + 
				"documents.rec_date,\r\n" + 
				"documents.receiver_list,\r\n" + 
				"documents.sender_list,\r\n" + 
				"departments.name as \"dep\"\r\n" + 
				"FROM documents\r\n" +
				"LEFT JOIN contractor ON documents.id_contractor = contractor.id \r\n" + 
				"LEFT JOIN type_docs ON documents.id_type_docs = type_docs.id\r\n" + 
				"LEFT JOIN users ON documents.creator = users.id\r\n" + 
				"LEFT JOIN urgency ON documents.id_urgency = urgency.id\r\n" + 
				"LEFT JOIN departments ON departments.id = documents.current_dep\r\n";*/
				"SELECT \r\n" + 
				"documents.id as \"id\",\r\n" + 
				"type_docs.name as \"type\",\r\n" + 
				"contractor.name as \"contractor\",\r\n" + 
				"documents.name as \"name\",\r\n" + 
				"documents.content as \"content\",\r\n" + 
				"users.name as \"creator_name\",\r\n" + 
				"users.second as \"creator_second\",\r\n" + 
				"urgency.name as \"urgency\",\r\n" + 
				"documents.date_cre,\r\n" + 
				"documents.status_finished,\r\n" + 
				"documents.rec_date,\r\n" + 
				"documents.receiver_list,\r\n" + 
				"documents.sender_list,\r\n" + 
				"departments.name as \"dep\"\r\n" + 
				"FROM documents\r\n" +
				"LEFT JOIN contractor ON documents.id_contractor = contractor.id \r\n" + 
				"LEFT JOIN type_docs ON documents.id_type_docs = type_docs.id\r\n" + 
				"LEFT JOIN users ON documents.creator = users.id\r\n" + 
				"LEFT JOIN urgency ON documents.id_urgency = urgency.id\r\n" + 
				"LEFT JOIN departments ON departments.id = documents.current_dep\r\n" +
				"WHERE documents.id = ?";
		
        try (PreparedStatement preparedStatement = conn.prepareStatement(sqlquery)){
            preparedStatement.setInt(1, id);
            ResultSet resultset = preparedStatement.executeQuery();		
			if (resultset.next()) {
		        int id_doc = resultset.getInt("id");
		        String type =  resultset.getString("type");
		        String contractor =  resultset.getString("contractor");
		        //byte[] blob =  resultset.getBytes("blob");
		        String name =  resultset.getString("name");
		        String content =  resultset.getString("content");
		        String creator_name =  resultset.getString("creator_name");
		        String creator_second =  resultset.getString("creator_second");
		        String urgency =  resultset.getString("urgency");
		        String date_cre =  resultset.getString("date_cre");
		        int status_finished =  resultset.getInt("status_finished");
		        String rec_date =  resultset.getString("rec_date");
		        
		        Array receiver = resultset.getArray("receiver_list");
                String[] receiver_arr = (String[])receiver.getArray();
                ArrayList<String> receiver_arraylist= new ArrayList<String>();
                Collections.addAll(receiver_arraylist, receiver_arr);
                //System.out.println("отработала коллекция");
		        
		        
		        Array sender = resultset.getArray("sender_list");
                String[] sender_arr = (String[])sender.getArray();
                ArrayList<String> sender_arraylist= new ArrayList<String>();
                Collections.addAll(sender_arraylist, sender_arr);
                //System.out.println("отработала коллекция");
        
                String dep =  resultset.getString("dep");

                fdoc = new Fdoc (id_doc, type, contractor, name, content, creator_name,creator_second, 
    	    			urgency, date_cre, status_finished, rec_date, receiver_arraylist, sender_arraylist, dep);
                
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
    	
    	return fdoc;
    	
    }	
//********************************************************************************************************************************
	
    public static ArrayList<Fdoc> select(int id_department) {
    	ArrayList<Fdoc> fdocs = new ArrayList<Fdoc>();

    	
    	
		Connection conn = DbFilter.getConn();

        Statement statement = null;
		try {
			statement  = ((Connection) conn).createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //Выполним запрос
        ResultSet resultset = null;
		try {
			resultset = statement.executeQuery(
			        //"SELECT * FROM documents ORDER BY id"
					"SELECT \r\n" + 
					"documents.id as \"id\",\r\n" + 
					"type_docs.id as \"id_type_int\",\r\n" + "type_docs.name as \"type\",\r\n" +
					"contractor.name as \"contractor\",\r\n" + 
					"documents.name as \"name\",\r\n" + 
					"documents.content as \"content\",\r\n" + 
					"users.name as \"creator_name\",\r\n" + 
					"users.second as \"creator_second\",\r\n" + 
					"urgency.id as \"id_urgency\",\r\n" +"urgency.name as \"urgency\",\r\n" + 
					"documents.date_cre,\r\n" + 
					"documents.status_finished,\r\n" + 
					"documents.rec_date,\r\n" + 
					"documents.receiver_list,\r\n" + 
					"documents.sender_list,\r\n" + 
					"departments.name as \"dep\",\r\n"+ 
					"documents.blob as \"blob\" \r\n"+
					"FROM documents\r\n" + 
					"LEFT JOIN contractor ON documents.id_contractor = contractor.id \r\n" + 
					"LEFT JOIN type_docs ON documents.id_type_docs = type_docs.id\r\n" + 
					"LEFT JOIN users ON documents.creator = users.id\r\n" + 
					"LEFT JOIN urgency ON documents.id_urgency = urgency.id\r\n" + 
					"LEFT JOIN departments ON departments.id = documents.current_dep " +
					"WHERE documents.current_dep = 2 ORDER BY documents.id;"
					);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //result это указатель на первую строку с выборки
        //чтобы вывести данные мы будем использовать 
        //метод next() , с помощью которого переходим к следующему элементу
        System.out.println("Выводим statement");
        try {
			while (resultset.next()) {
		        int id = resultset.getInt("id");
		        int id_type_int =  resultset.getInt("id_type_int");
		        String type =  resultset.getString("type");
		        String contractor =  resultset.getString("contractor");
		        
		        String name =  resultset.getString("name");
		        String content =  resultset.getString("content");
		        String creator_name =  resultset.getString("creator_name");
		        String creator_second =  resultset.getString("creator_second");
		        int id_urgency =  resultset.getInt("id_urgency");
		        String urgency =  resultset.getString("urgency");
		        String date_cre =  resultset.getString("date_cre");
		        int status_finished =  resultset.getInt("status_finished");
		        String rec_date =  resultset.getString("rec_date");
		        
		        Array receiver = resultset.getArray("receiver_list");
                String[] receiver_arr = (String[])receiver.getArray();
                ArrayList<String> receiver_arraylist= new ArrayList<String>();
                Collections.addAll(receiver_arraylist, receiver_arr);
                //System.out.println("отработала коллекция");
		        
		        
		        Array sender = resultset.getArray("sender_list");
                String[] sender_arr = (String[])sender.getArray();
                ArrayList<String> sender_arraylist= new ArrayList<String>();
                Collections.addAll(sender_arraylist, sender_arr);
                //System.out.println("отработала коллекция");
        
                String dep =  resultset.getString("dep");
                byte[] blob =  resultset.getBytes("blob"); // 05072019
                Fdoc fdoc = new Fdoc (id, id_type_int, type, contractor, name, content, creator_name,creator_second, 
                		id_urgency, urgency, date_cre, status_finished, rec_date, receiver_arraylist, sender_arraylist, dep, blob);
                fdocs.add(fdoc);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally 
	        {try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			} 		    	
    	
    	return fdocs;
    	
    }	
//--------------------------------------------------------------------------------------------------------------------------    
  //***********************************************************************************************************************************
    //with BLOB
    public static Fdoc selectone2(int id) {
		Connection conn = DbFilter.getConn();
    	Fdoc fdoc = null;
		//Выполним запрос
		String sqlquery =					
				"SELECT \r\n" + 
				"documents.id as \"id\",\r\n" +
				
				"type_docs.id as \"id_type_int\",\r\n" + "type_docs.name as \"type\",\r\n" +  
				"contractor.name as \"contractor\",\r\n" + 
				"documents.name as \"name\",\r\n" + 
				"documents.content as \"content\",\r\n" + 
				"users.name as \"creator_name\",\r\n" + 
				"users.second as \"creator_second\",\r\n" + 
				"urgency.id as \"id_urgency\",\r\n" +"urgency.name as \"urgency\",\r\n" +
				"documents.date_cre,\r\n" + 
				"documents.status_finished,\r\n" + 
				"documents.rec_date,\r\n" + 
				"documents.receiver_list,\r\n" + 
				"documents.sender_list,\r\n" + 
				"departments.name as \"dep\",\r\n"+
				"documents.blob as \"blob\", \r\n" +
				"documents.date_registry as    date_registry ,    "+ 
				"tru.id as \"id_tru\",\r\n" +"tru.name as \"tru\",\r\n" +
				"law.id as \"id_law\",\r\n" +"law.name as \"law\",\r\n" +
				"division.id as \"id_division\",\r\n" +"division.name as \"division\",\r\n" +
				  "documents.price as      price     ,     "+ 
				  "documents.paid as      paid     ,      "+
				  "documents.id_ifo ,      "+
				  "documents.add_agr as      add_agr     ,    "+  
				  "documents.price_add_agr   as      price_add_agr      "+     

				"FROM documents\r\n" +
				"LEFT JOIN contractor ON documents.id_contractor = contractor.id \r\n" + 
				"LEFT JOIN type_docs ON documents.id_type_docs = type_docs.id\r\n" + 
				"LEFT JOIN users ON documents.creator = users.id\r\n" + 
				"LEFT JOIN urgency ON documents.id_urgency = urgency.id\r\n" +
				"LEFT JOIN tru ON documents.id_tru = tru.id\r\n" +
				"LEFT JOIN law ON documents.id_law = law.id\r\n" +
				"LEFT JOIN division ON documents.id_division = division.id\r\n" +
				"LEFT JOIN departments ON departments.id = documents.current_dep\r\n" +
				"WHERE documents.id = ?";

	
        try (PreparedStatement preparedStatement = conn.prepareStatement(sqlquery)){
            preparedStatement.setInt(1, id);
            ResultSet resultset = preparedStatement.executeQuery();		
			if (resultset.next()) {
		        //int id_doc = resultset.getInt("id");
		        int id_type_int = resultset.getInt("id_type_int");
		        String type =  resultset.getString("type");
		        String contractor =  resultset.getString("contractor");
		        //byte[] blob =  resultset.getBytes("blob");
		        String name =  resultset.getString("name");
		        String content =  resultset.getString("content");
		        String creator_name =  resultset.getString("creator_name");
		        String creator_second =  resultset.getString("creator_second");
		        int id_urgency =  resultset.getInt("id_urgency");
		        String urgency =  resultset.getString("urgency");
		        String date_cre =  resultset.getString("date_cre");
		        int status_finished =  resultset.getInt("status_finished");
		        String rec_date =  resultset.getString("rec_date");
		        
		        Array receiver = resultset.getArray("receiver_list");
                String[] receiver_arr = (String[])receiver.getArray();
                ArrayList<String> receiver_arraylist= new ArrayList<String>();
                Collections.addAll(receiver_arraylist, receiver_arr);
                //System.out.println("отработала коллекция");
		        
		        
		        Array sender = resultset.getArray("sender_list");
                String[] sender_arr = (String[])sender.getArray();
                ArrayList<String> sender_arraylist= new ArrayList<String>();
                Collections.addAll(sender_arraylist, sender_arr);
                //System.out.println("отработала коллекция");
        
                String dep =  resultset.getString("dep");
                byte[] blob =  resultset.getBytes("blob");
                
                String date_registry =  resultset.getString("date_registry");
		        int id_tru =  resultset.getInt("id_tru");
		        String tru =  resultset.getString("tru");
		        int id_law =  resultset.getInt("id_law");
		        String law =  resultset.getString("law");
		        int id_division =  resultset.getInt("id_division");
		        String division =  resultset.getString("division");		        
		        BigDecimal price = resultset.getBigDecimal("price");
		        boolean paid = resultset.getBoolean("paid");	        
		        Array id_ifo = resultset.getArray("id_ifo");
		        
                Integer[] id_ifo_arr = (Integer[])id_ifo.getArray();
                ArrayList<Integer> ifo_arraylist= new ArrayList<Integer>();
                Collections.addAll(ifo_arraylist, id_ifo_arr);
                //System.out.println("отработала коллекция");
                
		        String add_agr =  resultset.getString("add_agr");
		        BigDecimal price_add_agr = resultset.getBigDecimal("price_add_agr");  
		        
				ArrayList<String> ifo_arraylist_str = new ArrayList<String>();
                for(Integer ifo : ifo_arraylist){                      
                    String ifo_str = new String(IfoDb.selectoneStr(ifo));
                    ifo_arraylist_str.add(ifo_str);
                	}

				/*
				 * fdoc = new Fdoc (id_doc, id_type_int, type, contractor, name, content,
				 * creator_name,creator_second, id_urgency, urgency, date_cre, status_finished,
				 * rec_date, receiver_arraylist, sender_arraylist, dep, blob);
				 */
                
                fdoc = new Fdoc (id, id_type_int, type, contractor, name, content, creator_name,creator_second, 
                		id_urgency, urgency, date_cre, status_finished, rec_date, receiver_arraylist, sender_arraylist, dep, blob,
                		date_registry,id_tru,tru,id_law,law,id_division,division,price,paid,add_agr,price_add_agr,ifo_arraylist, ifo_arraylist_str);
                
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
    	
    	return fdoc;
    	
    }	
//********************************************************************************************************************************
	
    public static int updateContent(int id, String content) {
    	Connection conn = DbFilter.getConn();       
        String sql = "UPDATE documents SET content =? WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){               	
				
					preparedStatement.setString(1, content);
					preparedStatement.setInt(2, id);
					System.out.println("Запрос на изменение content в документе выполнен!!");
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
    
//**********************************************************************************************************************************************    
    public static int updateName(int id, String name) {
    	Connection conn = DbFilter.getConn();       
        String sql = "UPDATE documents SET name =? WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){               	
				
					preparedStatement.setString(1, name);
					preparedStatement.setInt(2, id);
					System.out.println("Запрос на изменение name в документе выполнен!!");
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
//  ***********************************************************************************************************************************    
    
    public static int insertBlob(int id, String filepath) throws FileNotFoundException {
    	Connection conn = DbFilter.getConn(); 
    	String sql = "UPDATE documents SET blob =? WHERE id = ?";
        try{
            
        	File file = new File(filepath);
            FileInputStream fis = new FileInputStream(file);
        	
            
            PreparedStatement ps=conn.prepareStatement(sql);  
	        

			ps.setBinaryStream(1, fis, (int)file.length()); // BLOB
			//ps.setBlob(1, file);
            ps.setInt(2, id);			
            ps.executeUpdate();  
            fis.close();
    		        System.out.println("запрос BLOB выполнен успешно!!!");
    		 
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

//***********************************************************************************************************************************    
    public static int updateRecDate(int id, String rec_date) {
    	Connection conn = DbFilter.getConn();       
        String sql = "UPDATE documents SET rec_date =? WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){               	
				
					preparedStatement.setString(1, rec_date);
					preparedStatement.setInt(2, id);
					System.out.println("Запрос на изменение rec_date в документе выполнен!!");
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
//  ***********************************************************************************************************************************    

    public static ArrayList<Fdoc> selectForDep(int id_department) {
    	ArrayList<Fdoc> fdocs = new ArrayList<Fdoc>();
    	Connection conn = DbFilter.getConn();
    	Fdoc fdoc = null;
		//Выполним запрос
		String sqlquery =					
				"SELECT \r\n" + 
				"documents.id as \"id\",\r\n" + 
				"type_docs.id as \"id_type_int\",\r\n" + "type_docs.name as \"type\",\r\n" +
				"contractor.name as \"contractor\",\r\n" + 
				"documents.name as \"name\",\r\n" + 
				"documents.content as \"content\",\r\n" + 
				"users.name as \"creator_name\",\r\n" + 
				"users.second as \"creator_second\",\r\n" + 
				"urgency.id as \"id_urgency\",\r\n" +"urgency.name as \"urgency\",\r\n" + 
				"documents.date_cre,\r\n" + 
				"documents.status_finished,\r\n" + 
				"documents.rec_date,\r\n" + 
				"documents.receiver_list,\r\n" + 
				"documents.sender_list,\r\n" + 
				"departments.name as \"dep\",\r\n"+ 
				"documents.blob as \"blob\" \r\n"+
				"FROM documents\r\n" + 
				"LEFT JOIN contractor ON documents.id_contractor = contractor.id \r\n" + 
				"LEFT JOIN type_docs ON documents.id_type_docs = type_docs.id\r\n" + 
				"LEFT JOIN users ON documents.creator = users.id\r\n" + 
				"LEFT JOIN urgency ON documents.id_urgency = urgency.id\r\n" + 
				"LEFT JOIN departments ON departments.id = documents.current_dep " +
				"WHERE documents.current_dep = ? ORDER BY documents.id;";
		
        try (PreparedStatement preparedStatement = conn.prepareStatement(sqlquery)){
            preparedStatement.setInt(1, id_department);
            ResultSet resultset = preparedStatement.executeQuery();		
    			while (resultset.next()) {
    		        int id = resultset.getInt("id");
    		        int id_type_int =  resultset.getInt("id_type_int");
    		        String type =  resultset.getString("type");
    		        String contractor =  resultset.getString("contractor");
    		        
    		        String name =  resultset.getString("name");
    		        String content =  resultset.getString("content");
    		        String creator_name =  resultset.getString("creator_name");
    		        String creator_second =  resultset.getString("creator_second");
    		        int id_urgency =  resultset.getInt("id_urgency");
    		        String urgency =  resultset.getString("urgency");
    		        String date_cre =  resultset.getString("date_cre");
    		        int status_finished =  resultset.getInt("status_finished");
    		        String rec_date =  resultset.getString("rec_date");
    		        
    		        Array receiver = resultset.getArray("receiver_list");
                    String[] receiver_arr = (String[])receiver.getArray();
                    ArrayList<String> receiver_arraylist= new ArrayList<String>();
                    Collections.addAll(receiver_arraylist, receiver_arr);
                    //System.out.println("отработала коллекция");
    		        
    		        
    		        Array sender = resultset.getArray("sender_list");
                    String[] sender_arr = (String[])sender.getArray();
                    ArrayList<String> sender_arraylist= new ArrayList<String>();
                    Collections.addAll(sender_arraylist, sender_arr);
                    //System.out.println("отработала коллекция");
                    int notifications_user = Integer.parseInt (sender_arraylist.get(0));
                    //System.out.println("notifications_user " + notifications_user);
                    //System.out.println("notifications_user из селекта " + UserDb.selectoneStr(notifications_user));
                    sender_arraylist.set(0, UserDb.selectoneStr(notifications_user));
            
                    String dep =  resultset.getString("dep");
                    byte[] blob =  resultset.getBytes("blob"); // 05072019
                    fdoc = new Fdoc (id, id_type_int, type, contractor, name, content, creator_name,creator_second, 
                    		id_urgency, urgency, date_cre, status_finished, rec_date, receiver_arraylist, sender_arraylist, dep, blob);

                fdocs.add(fdoc);
                
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
    	
    	return fdocs;
    	
    }	

//  ***********************************************************************************************************************************    

    public static ArrayList<Fdoc> selectForCurUser(int id_user) {
    	ArrayList<Fdoc> fdocs = new ArrayList<Fdoc>();
    	Connection conn = DbFilter.getConn();
    	Fdoc fdoc = null;
		//Выполним запрос
		String sqlquery =					
				"SELECT \r\n" + 
				"documents.id as \"id\",\r\n" + 
				"type_docs.id as \"id_type_int\",\r\n" + "type_docs.name as \"type\",\r\n" +
				"contractor.name as \"contractor\",\r\n" + 
				"documents.name as \"name\",\r\n" + 
				"documents.content as \"content\",\r\n" + 
				"users.name as \"creator_name\",\r\n" + 
				"users.second as \"creator_second\",\r\n" + 
				"urgency.id as \"id_urgency\",\r\n" +"urgency.name as \"urgency\",\r\n" + 
				"documents.date_cre,\r\n" + 
				"documents.status_finished,\r\n" + 
				"documents.rec_date,\r\n" + 
				"documents.receiver_list,\r\n" + 
				"documents.sender_list,\r\n" + 
				"departments.name as \"dep\",\r\n"+ 
				"documents.blob as \"blob\" \r\n"+
				"FROM documents\r\n" + 
				"LEFT JOIN contractor ON documents.id_contractor = contractor.id \r\n" + 
				"LEFT JOIN type_docs ON documents.id_type_docs = type_docs.id\r\n" + 
				"LEFT JOIN users ON documents.creator = users.id\r\n" + 
				"LEFT JOIN urgency ON documents.id_urgency = urgency.id\r\n" + 
				"LEFT JOIN departments ON departments.id = documents.current_dep " +
				"WHERE documents.receiver_list[1] = ?::varchar ORDER BY documents.id; ";
		      //"WHERE documents.current_dep = ?      ORDER BY documents.id; ";
		
        try (PreparedStatement preparedStatement = conn.prepareStatement(sqlquery)){
            preparedStatement.setInt(1, id_user);
            ResultSet resultset = preparedStatement.executeQuery();		
    			while (resultset.next()) {
    		        int id = resultset.getInt("id");
    		        int id_type_int =  resultset.getInt("id_type_int");
    		        String type =  resultset.getString("type");
    		        String contractor =  resultset.getString("contractor");
    		        
    		        String name =  resultset.getString("name");
    		        String content =  resultset.getString("content");
    		        String creator_name =  resultset.getString("creator_name");
    		        String creator_second =  resultset.getString("creator_second");
    		        int id_urgency =  resultset.getInt("id_urgency");
    		        String urgency =  resultset.getString("urgency");
    		        String date_cre =  resultset.getString("date_cre");
    		        int status_finished =  resultset.getInt("status_finished");
    		        String rec_date =  resultset.getString("rec_date");
    		        
    		        Array receiver = resultset.getArray("receiver_list");
                    String[] receiver_arr = (String[])receiver.getArray();
                    ArrayList<String> receiver_arraylist= new ArrayList<String>();
                    Collections.addAll(receiver_arraylist, receiver_arr);
                    //System.out.println("отработала коллекция");
    		        
    		        
    		        Array sender = resultset.getArray("sender_list");
                    String[] sender_arr = (String[])sender.getArray();
                    ArrayList<String> sender_arraylist= new ArrayList<String>();
                    Collections.addAll(sender_arraylist, sender_arr);
                    //System.out.println("отработала коллекция");
                    int notifications_user = Integer.parseInt (sender_arraylist.get(0));
                    //System.out.println("notifications_user " + notifications_user);
                    //System.out.println("notifications_user из селекта " + UserDb.selectoneStr(notifications_user));
                    sender_arraylist.set(0, UserDb.selectoneStr(notifications_user));
            
                    String dep =  resultset.getString("dep");
                    byte[] blob =  resultset.getBytes("blob"); // 05072019
                    fdoc = new Fdoc (id, id_type_int, type, contractor, name, content, creator_name,creator_second, 
                    		id_urgency, urgency, date_cre, status_finished, rec_date, receiver_arraylist, sender_arraylist, dep, blob);

                fdocs.add(fdoc);
                
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
    	
    	return fdocs;
    	
    }	    
//********************************************************************************************************************************
    public static int updateSender_listDoc(int id, Array sender_list, Array receiver_list) {
    	Connection conn = DbFilter.getConn();       
        String sql = "UPDATE documents SET sender_list =?, receiver_list = ? WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){               	
				
					preparedStatement.setArray(1, sender_list);
					preparedStatement.setArray(2, receiver_list);
					preparedStatement.setInt(3, id);
					System.out.println("Запрос на изменение sender_list  и receiver_list в документе выполнен!!");
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
//  ***********************************************************************************************************************************

    public static int updateSender_listDoc(int id, Array receiver_list) {
    	Connection conn = DbFilter.getConn();       
        String sql = "UPDATE documents SET receiver_list = ? WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){               	
				
					
					preparedStatement.setArray(1, receiver_list);
					preparedStatement.setInt(2, id);
					System.out.println("Запрос на изменение receiver_list в документе выполнен!!");
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
//  ***********************************************************************************************************************************      
    public static int updateDepDoc(int id, int current_dep) {
    	Connection conn = DbFilter.getConn();       
        String sql = "UPDATE documents SET current_dep =? WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){               	
				
					preparedStatement.setInt(1, current_dep);
					preparedStatement.setInt(2, id);
					System.out.println("Запрос на изменение current_dep в документе выполнен!!");
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
//  ***********************************************************************************************************************************

    public static int updateStatus_finishedDoc(int id) {
    	Connection conn = DbFilter.getConn();       
        String sql = "UPDATE documents SET status_finished = 1 WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){               	
				
					preparedStatement.setInt(1, id);
					System.out.println("Запрос на изменение Status_finished в документе выполнен!!");
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
    
//  ***********************************************************************************************************************************      
    public static ArrayList<Fdoc> selectForCurUser_Full(int id_user) {
    	ArrayList<Fdoc> fdocs = new ArrayList<Fdoc>();
    	Connection conn = DbFilter.getConn();
    	Fdoc fdoc = null;
		//Выполним запрос
		String sqlquery =			
				/*
				"SELECT \r\n" + 
				"documents.id as \"id\",\r\n" + 
				"type_docs.id as \"id_type_int\",\r\n" + "type_docs.name as \"type\",\r\n" +
				"contractor.name as \"contractor\",\r\n" + 
				"documents.name as \"name\",\r\n" + 
				"documents.content as \"content\",\r\n" + 
				"users.name as \"creator_name\",\r\n" + 
				"users.second as \"creator_second\",\r\n" + 
				"urgency.id as \"id_urgency\",\r\n" +"urgency.name as \"urgency\",\r\n" + 
				"documents.date_cre,\r\n" + 
				"documents.status_finished,\r\n" + 
				"documents.rec_date,\r\n" + 
				"documents.receiver_list,\r\n" + 
				"documents.sender_list,\r\n" + 
				"departments.name as \"dep\",\r\n"+ 
				"documents.blob as \"blob\", \r\n"+
				"documents.date_registry as \"date_registry\", \r\n"+
				"tru.id as \"id_tru\",\r\n\" + \"tru.name as \"tru\",\r\n" +
				"law.id as \"id_law\",\r\n\" + \"law.name as \"law\",\r\n" +
				"division.id as \"id_division\",\r\n\" + \"division.name as \"division\",\r\n" +
				"documents.price as \"price\",\r\n" +
				"documents.paid as \"paid\",\r\n" +
				"documents.add_agr as \"add_agr\",\r\n" +
				"documents.price_add_agr as \"price_add_agr\",\r\n" +
				//"ifo.id as \"id_ifo\",\r\n\" + \"ifo.name as \"ifo\",\r\n" +
				"documents.id_ifo \r\n" + 
				"FROM documents \r\n" + 
				"LEFT JOIN contractor ON documents.id_contractor = contractor.id \r\n" + 
				"LEFT JOIN type_docs ON documents.id_type_docs = type_docs.id\r\n" + 
				"LEFT JOIN users ON documents.creator = users.id\r\n" + 
				"LEFT JOIN urgency ON documents.id_urgency = urgency.id\r\n" + 
				"LEFT JOIN departments ON departments.id = documents.current_dep " +
				//"LEFT JOIN tru ON documents.id_tru = tru.id \r\n" + 
				//"LEFT JOIN law ON documents.id_law = law.id \r\n" + 
				//"LEFT JOIN division ON documents.id_division = division.id \r\n" + 
				//"LEFT JOIN ifo ON documents.id_ifo = ifo.id \r\n" + 
				"WHERE documents.receiver_list[1] = ?::varchar ORDER BY documents.id; "; */
		
		  "SELECT " +        
		  "documents.id as      id     , "+       
		  "type_docs.id as      id_type_int     ,"+         
		  "type_docs.name as      type     ,      "+
		  "contractor.name as      contractor     ,"+       
		  "documents.name as      name     ,       "+
		  "documents.content as      content     , "+      
		  "users.name as      creator_name     ,   "+    
		  "users.second as      creator_second     , "+      
		  "urgency.id as      id_urgency     ,        "+
		  "urgency.name as      urgency     ,       "+
		  "documents.date_cre,       "+
		  "documents.status_finished,       "+
		  "documents.rec_date,       "+
		  "documents.receiver_list,       "+
		  "documents.sender_list,       "+
		  "departments.name as      dep     ,      "+
		  "documents.blob as      blob,           "+
		  "documents.date_registry as    date_registry ,    "+      
		  "tru.id as      id_tru     ,               "+
		  "tru.name as      tru     ,      "+
		  "law.id as      id_law     ,              "+
		  "law.name as      law     ,      "+
		  "division.id as      id_division     ,    "+            
		  "division.name as      division     ,    "+  
		  "documents.price as      price     ,     "+ 
		  "documents.paid as      paid     ,      "+
		  "documents.add_agr as      add_agr     ,    "+  
		  "documents.price_add_agr   as      price_add_agr     , "+     
		
		  "documents.id_ifo       "+
		  "FROM documents       "+
		  "LEFT JOIN contractor ON documents.id_contractor = contractor.id  "+      
		  "LEFT JOIN type_docs ON documents.id_type_docs = type_docs.id     "+  
		  "LEFT JOIN users ON documents.creator = users.id       "+
		  "LEFT JOIN urgency ON documents.id_urgency = urgency.id       "+
		  "LEFT JOIN departments ON departments.id = documents.current_dep  "+      
		  "LEFT JOIN tru ON documents.id_tru = tru.id        "+
		  "LEFT JOIN law ON documents.id_law = law.id        "+
		  "LEFT JOIN division ON documents.id_division = division.id  		"+
		  "WHERE documents.receiver_list[1] = ?::varchar ORDER BY documents.id; ";
		      
		
        try (PreparedStatement preparedStatement = conn.prepareStatement(sqlquery)){
            preparedStatement.setInt(1, id_user);
            ResultSet resultset = preparedStatement.executeQuery();		
    			while (resultset.next()) {
    		        int id = resultset.getInt("id");
    		        int id_type_int =  resultset.getInt("id_type_int");
    		        String type =  resultset.getString("type");
    		        String contractor =  resultset.getString("contractor");
    		        
    		        String name =  resultset.getString("name");
    		        String content =  resultset.getString("content");
    		        String creator_name =  resultset.getString("creator_name");
    		        String creator_second =  resultset.getString("creator_second");
    		        int id_urgency =  resultset.getInt("id_urgency");
    		        String urgency =  resultset.getString("urgency");
    		        String date_cre =  resultset.getString("date_cre");
    		        int status_finished =  resultset.getInt("status_finished");
    		        String rec_date =  resultset.getString("rec_date");
    		        
    		        Array receiver = resultset.getArray("receiver_list");
                    String[] receiver_arr = (String[])receiver.getArray();
                    ArrayList<String> receiver_arraylist= new ArrayList<String>();
                    Collections.addAll(receiver_arraylist, receiver_arr);
                    //System.out.println("отработала коллекция");
    		        
    		        
    		        Array sender = resultset.getArray("sender_list");
                    String[] sender_arr = (String[])sender.getArray();
                    ArrayList<String> sender_arraylist= new ArrayList<String>();
                    Collections.addAll(sender_arraylist, sender_arr);
                    //System.out.println("отработала коллекция");
                    
                    int notifications_user_sender = Integer.parseInt (sender_arraylist.get(0));
                    sender_arraylist.set(0, UserDb.selectoneStr(notifications_user_sender));
                    
                    int notifications_user_receiver = Integer.parseInt (receiver_arraylist.get(0));
                    receiver_arraylist.set(0, UserDb.selectoneStr(notifications_user_receiver));
            
                    String dep =  resultset.getString("dep");
                    byte[] blob =  resultset.getBytes("blob"); // 05072019
                    String date_registry =  resultset.getString("date_registry");
    		        int id_tru =  resultset.getInt("id_tru");
    		        String tru =  resultset.getString("tru");
    		        int id_law =  resultset.getInt("id_law");
    		        String law =  resultset.getString("law");
    		        int id_division =  resultset.getInt("id_division");
    		        String division =  resultset.getString("division");
    		        BigDecimal price = resultset.getBigDecimal("price");
    		        boolean paid = resultset.getBoolean("paid");
    		        
    		        Array id_ifo = resultset.getArray("id_ifo");
                    Integer[] id_ifo_arr = (Integer[])id_ifo.getArray();
                    ArrayList<Integer> ifo_arraylist= new ArrayList<Integer>();
                    Collections.addAll(ifo_arraylist, id_ifo_arr);
                    //System.out.println("отработала коллекция");    		        

    		        String add_agr =  resultset.getString("add_agr");
    		        BigDecimal price_add_agr = resultset.getBigDecimal("price_add_agr");
    		        
    				ArrayList<String> ifo_arraylist_str = new ArrayList<String>();
	                for(Integer ifo : ifo_arraylist){                      
	                    String ifo_str = new String(IfoDb.selectoneStr(ifo));
	                    ifo_arraylist_str.add(ifo_str);
	                	}

                    fdoc = new Fdoc (id, id_type_int, type, contractor, name, content, creator_name,creator_second, 
                    		id_urgency, urgency, date_cre, status_finished, rec_date, receiver_arraylist, sender_arraylist, dep, blob,
                    		date_registry,id_tru,tru,id_law,law,id_division,division,price,paid,add_agr,price_add_agr,ifo_arraylist, ifo_arraylist_str);

                fdocs.add(fdoc);
                
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
    	
    	return fdocs;
    	
    }
    
//  ***********************************************************************************************************************************      
//в качестве параметра - массив из пользователей одного отдела
    public static ArrayList<Fdoc> selectForCurUser_Full(List<Integer> id_user) {
    	ArrayList<Fdoc> fdocs = new ArrayList<Fdoc>();
    	Connection conn = DbFilter.getConn();
    	Fdoc fdoc = null;
		//Выполним запрос
		String sqlquery =
		  "SELECT " +        
		  "documents.id as      id     , "+       
		  "type_docs.id as      id_type_int     ,"+         
		  "type_docs.name as      type     ,      "+
		  "contractor.name as      contractor     ,"+       
		  "documents.name as      name     ,       "+
		  "documents.content as      content     , "+      
		  "users.name as      creator_name     ,   "+    
		  "users.second as      creator_second     , "+      
		  "urgency.id as      id_urgency     ,        "+
		  "urgency.name as      urgency     ,       "+
		  "documents.date_cre,       "+
		  "documents.status_finished,       "+
		  "documents.rec_date,       "+
		  "documents.receiver_list,       "+
		  "documents.sender_list,       "+
		  "departments.name as      dep     ,      "+
		  "documents.blob as      blob,           "+
		  "documents.date_registry as    date_registry ,    "+      
		  "tru.id as      id_tru     ,               "+
		  "tru.name as      tru     ,      "+
		  "law.id as      id_law     ,              "+
		  "law.name as      law     ,      "+
		  "division.id as      id_division     ,    "+            
		  "division.name as      division     ,    "+  
		  "documents.price as      price     ,     "+ 
		  "documents.paid as      paid     ,      "+
		  "documents.add_agr as      add_agr     ,    "+  
		  "documents.price_add_agr   as      price_add_agr     , "+     
		
		  "documents.id_ifo       "+
		  "FROM documents       "+
		  "LEFT JOIN contractor ON documents.id_contractor = contractor.id  "+      
		  "LEFT JOIN type_docs ON documents.id_type_docs = type_docs.id     "+  
		  "LEFT JOIN users ON documents.creator = users.id       "+
		  "LEFT JOIN urgency ON documents.id_urgency = urgency.id       "+
		  "LEFT JOIN departments ON departments.id = documents.current_dep  "+      
		  "LEFT JOIN tru ON documents.id_tru = tru.id        "+
		  "LEFT JOIN law ON documents.id_law = law.id        "+
		  "LEFT JOIN division ON documents.id_division = division.id  		"+
		  "WHERE documents.receiver_list[1] = ANY(?::varchar[]) ORDER BY documents.id; ";
		      
		
        try (PreparedStatement preparedStatement = conn.prepareStatement(sqlquery)){
        	
            List<Integer> list = new ArrayList<Integer>(id_user);
            Array id_user2 = conn.createArrayOf("varchar", list.toArray()); //This is Postgre feature Особенность реализации, преобразуем массив понятный Постгре 
             
                    	
            preparedStatement.setArray(1, id_user2);
            ResultSet resultset = preparedStatement.executeQuery();		
    			while (resultset.next()) {
    		        int id = resultset.getInt("id");
    		        int id_type_int =  resultset.getInt("id_type_int");
    		        String type =  resultset.getString("type");
    		        String contractor =  resultset.getString("contractor");
    		        
    		        String name =  resultset.getString("name");
    		        String content =  resultset.getString("content");
    		        String creator_name =  resultset.getString("creator_name");
    		        String creator_second =  resultset.getString("creator_second");
    		        int id_urgency =  resultset.getInt("id_urgency");
    		        String urgency =  resultset.getString("urgency");
    		        String date_cre =  resultset.getString("date_cre");
    		        int status_finished =  resultset.getInt("status_finished");
    		        String rec_date =  resultset.getString("rec_date");
    		        
    		        Array receiver = resultset.getArray("receiver_list");
                    String[] receiver_arr = (String[])receiver.getArray();
                    ArrayList<String> receiver_arraylist= new ArrayList<String>();
                    Collections.addAll(receiver_arraylist, receiver_arr);
                    //System.out.println("отработала коллекция");
    		        
    		        
    		        Array sender = resultset.getArray("sender_list");
                    String[] sender_arr = (String[])sender.getArray();
                    ArrayList<String> sender_arraylist= new ArrayList<String>();
                    Collections.addAll(sender_arraylist, sender_arr);
                    //System.out.println("отработала коллекция");
                    
                    int notifications_user_sender = Integer.parseInt (sender_arraylist.get(0));
                    sender_arraylist.set(0, UserDb.selectoneStr(notifications_user_sender));
                    
                    int notifications_user_receiver = Integer.parseInt (receiver_arraylist.get(0));
                    receiver_arraylist.set(0, UserDb.selectoneStr(notifications_user_receiver));
            
                    String dep =  resultset.getString("dep");
                    byte[] blob =  resultset.getBytes("blob"); // 05072019
                    String date_registry =  resultset.getString("date_registry");
    		        int id_tru =  resultset.getInt("id_tru");
    		        String tru =  resultset.getString("tru");
    		        int id_law =  resultset.getInt("id_law");
    		        String law =  resultset.getString("law");
    		        int id_division =  resultset.getInt("id_division");
    		        String division =  resultset.getString("division");
    		        BigDecimal price = resultset.getBigDecimal("price");
    		        boolean paid = resultset.getBoolean("paid");
    		        
    		        Array id_ifo = resultset.getArray("id_ifo");
                    Integer[] id_ifo_arr = (Integer[])id_ifo.getArray();
                    ArrayList<Integer> ifo_arraylist= new ArrayList<Integer>();
                    Collections.addAll(ifo_arraylist, id_ifo_arr);
                    //System.out.println("отработала коллекция"); 
                    


    		        String add_agr =  resultset.getString("add_agr");
    		        BigDecimal price_add_agr = resultset.getBigDecimal("price_add_agr");
    		        
    				ArrayList<String> ifo_arraylist_str = new ArrayList<String>();
    	                for(Integer ifo : ifo_arraylist){                      
    	                    String ifo_str = new String(IfoDb.selectoneStr(ifo));
    	                    ifo_arraylist_str.add(ifo_str);
    	                	}    		        
  		        
    		        
                    fdoc = new Fdoc (id, id_type_int, type, contractor, name, content, creator_name,creator_second, 
                    		id_urgency, urgency, date_cre, status_finished, rec_date, receiver_arraylist, sender_arraylist, dep, blob,
                    		date_registry,id_tru,tru,id_law,law,id_division,division,price,paid,add_agr,price_add_agr,ifo_arraylist, ifo_arraylist_str);

                fdocs.add(fdoc);
                
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
    	
    	return fdocs;
    	
    }    
//********************************************************************************************************************************
//вывод законченных документов    
    public static ArrayList<Fdoc> selectForCurUser_Full(int id_user, int status_finished_param ) {
    	ArrayList<Fdoc> fdocs = new ArrayList<Fdoc>();
    	Connection conn = DbFilter.getConn();
    	Fdoc fdoc = null;
		//Выполним запрос
		String sqlquery =			
	
		  "SELECT " +        
		  "documents.id as      id     , "+       
		  "type_docs.id as      id_type_int     ,"+         
		  "type_docs.name as      type     ,      "+
		  "contractor.name as      contractor     ,"+       
		  "documents.name as      name     ,       "+
		  "documents.content as      content     , "+      
		  "users.name as      creator_name     ,   "+    
		  "users.second as      creator_second     , "+      
		  "urgency.id as      id_urgency     ,        "+
		  "urgency.name as      urgency     ,       "+
		  "documents.date_cre,       "+
		  "documents.status_finished,       "+
		  "documents.rec_date,       "+
		  "documents.receiver_list,       "+
		  "documents.sender_list,       "+
		  "departments.name as      dep     ,      "+
		  "documents.blob as      blob,           "+
		  "documents.date_registry as    date_registry ,    "+      
		  "tru.id as      id_tru     ,               "+
		  "tru.name as      tru     ,      "+
		  "law.id as      id_law     ,              "+
		  "law.name as      law     ,      "+
		  "division.id as      id_division     ,    "+            
		  "division.name as      division     ,    "+  
		  "documents.price as      price     ,     "+ 
		  "documents.paid as      paid     ,      "+
		  "documents.add_agr as      add_agr     ,    "+  
		  "documents.price_add_agr   as      price_add_agr     , "+     
		
		  "documents.id_ifo       "+
		  "FROM documents       "+
		  "LEFT JOIN contractor ON documents.id_contractor = contractor.id  "+      
		  "LEFT JOIN type_docs ON documents.id_type_docs = type_docs.id     "+  
		  "LEFT JOIN users ON documents.creator = users.id       "+
		  "LEFT JOIN urgency ON documents.id_urgency = urgency.id       "+
		  "LEFT JOIN departments ON departments.id = documents.current_dep  "+      
		  "LEFT JOIN tru ON documents.id_tru = tru.id        "+
		  "LEFT JOIN law ON documents.id_law = law.id        "+
		  "LEFT JOIN division ON documents.id_division = division.id  		"+
		  "WHERE documents.receiver_list[1] = ?::varchar AND documents.status_finished = ? ORDER BY documents.id; ";
		      
		
        try (PreparedStatement preparedStatement = conn.prepareStatement(sqlquery)){
            preparedStatement.setInt(1, id_user);
            preparedStatement.setInt(2, status_finished_param);
            ResultSet resultset = preparedStatement.executeQuery();		
    			while (resultset.next()) {
    		        int id = resultset.getInt("id");
    		        int id_type_int =  resultset.getInt("id_type_int");
    		        String type =  resultset.getString("type");
    		        String contractor =  resultset.getString("contractor");
    		        
    		        String name =  resultset.getString("name");
    		        String content =  resultset.getString("content");
    		        String creator_name =  resultset.getString("creator_name");
    		        String creator_second =  resultset.getString("creator_second");
    		        int id_urgency =  resultset.getInt("id_urgency");
    		        String urgency =  resultset.getString("urgency");
    		        String date_cre =  resultset.getString("date_cre");
    		        int status_finished =  resultset.getInt("status_finished");
    		        String rec_date =  resultset.getString("rec_date");
    		        
    		        Array receiver = resultset.getArray("receiver_list");
                    String[] receiver_arr = (String[])receiver.getArray();
                    ArrayList<String> receiver_arraylist= new ArrayList<String>();
                    Collections.addAll(receiver_arraylist, receiver_arr);
                    //System.out.println("отработала коллекция");
    		        
    		        
    		        Array sender = resultset.getArray("sender_list");
                    String[] sender_arr = (String[])sender.getArray();
                    ArrayList<String> sender_arraylist= new ArrayList<String>();
                    Collections.addAll(sender_arraylist, sender_arr);
                    //System.out.println("отработала коллекция");
                    
                    int notifications_user_sender = Integer.parseInt (sender_arraylist.get(0));
                    sender_arraylist.set(0, UserDb.selectoneStr(notifications_user_sender));
                    
                    int notifications_user_receiver = Integer.parseInt (receiver_arraylist.get(0));
                    receiver_arraylist.set(0, UserDb.selectoneStr(notifications_user_receiver));
            
                    String dep =  resultset.getString("dep");
                    byte[] blob =  resultset.getBytes("blob");
                    String date_registry =  resultset.getString("date_registry");
    		        int id_tru =  resultset.getInt("id_tru");
    		        String tru =  resultset.getString("tru");
    		        int id_law =  resultset.getInt("id_law");
    		        String law =  resultset.getString("law");
    		        int id_division =  resultset.getInt("id_division");
    		        String division =  resultset.getString("division");
    		        BigDecimal price = resultset.getBigDecimal("price");
    		        boolean paid = resultset.getBoolean("paid");
    		        
    		        Array id_ifo = resultset.getArray("id_ifo");
                    Integer[] id_ifo_arr = (Integer[])id_ifo.getArray();
                    ArrayList<Integer> ifo_arraylist= new ArrayList<Integer>();
                    Collections.addAll(ifo_arraylist, id_ifo_arr);
                    //System.out.println("отработала коллекция");    		        

    		        String add_agr =  resultset.getString("add_agr");
    		        BigDecimal price_add_agr = resultset.getBigDecimal("price_add_agr");
    				
    		        ArrayList<String> ifo_arraylist_str = new ArrayList<String>();
	                for(Integer ifo : ifo_arraylist){                      
	                    String ifo_str = new String(IfoDb.selectoneStr(ifo));
	                    ifo_arraylist_str.add(ifo_str);
	                	}
    		        
                    fdoc = new Fdoc (id, id_type_int, type, contractor, name, content, creator_name,creator_second, 
                    		id_urgency, urgency, date_cre, status_finished, rec_date, receiver_arraylist, sender_arraylist, dep, blob,
                    		date_registry,id_tru,tru,id_law,law,id_division,division,price,paid,add_agr,price_add_agr,ifo_arraylist, ifo_arraylist_str);

                fdocs.add(fdoc);
                
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
    	
    	return fdocs;
    	
    }
//  ***********************************************************************************************************************************
    public static int updateTru(int id, String tru) {
    	Connection conn = DbFilter.getConn();       
        String sql = "UPDATE documents SET id_tru = (Select id FROM tru WHERE name = ?) WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){               	
				
					preparedStatement.setString(1, tru);
					preparedStatement.setInt(2, id);
					System.out.println("Запрос на изменение Tru в документе выполнен!!");
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
//  ***********************************************************************************************************************************
    public static int updateLaw(int id, String law) {
    	Connection conn = DbFilter.getConn();       
        String sql = "UPDATE documents SET id_law = (Select id FROM law WHERE name = ?) WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){               	
				
					preparedStatement.setString(1, law);
					preparedStatement.setInt(2, id);
					System.out.println("Запрос на изменение Law в документе выполнен!!");
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
//  ***********************************************************************************************************************************
    public static int updateDivision(int id, String division) {
    	Connection conn = DbFilter.getConn();       
        String sql = "UPDATE documents SET id_division = (Select id FROM division WHERE name = ?) WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){               	
				
					preparedStatement.setString(1, division);
					preparedStatement.setInt(2, id);
					System.out.println("Запрос на изменение Division в документе выполнен!!");
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
//********************************************************************************************************************************
    public static int updatePrice(int id, BigDecimal price) {
    	Connection conn = DbFilter.getConn();       
        String sql = "UPDATE documents SET price =? WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){               	
				
					preparedStatement.setBigDecimal(1, price);
					preparedStatement.setInt(2, id);
					System.out.println("Запрос на изменение price в документе выполнен!!");
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
  //********************************************************************************************************************************
    public static int updateAdd_agr(int id, String add_agr) {
    	Connection conn = DbFilter.getConn();       
        String sql = "UPDATE documents SET add_agr =? WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){               	
				
					preparedStatement.setString(1, add_agr);
					preparedStatement.setInt(2, id);
					System.out.println("Запрос на изменение add_agr в документе выполнен!!");
                    return  preparedStatement.executeUpdate();                 
            
        } catch(SQLException ex){
            System.out.println(ex);
        }        
                finally{
                	/*try {
    				conn.close();
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}*/
    			} 	
                
                
              
        return 0;
    }	        
    //********************************************************************************************************************************
    public static int updatePrice_add_agr(int id, BigDecimal price_add_agr) {
    	Connection conn = DbFilter.getConn();       
        String sql = "UPDATE documents SET price_add_agr =? WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){               	
				
					preparedStatement.setBigDecimal(1, price_add_agr);
					preparedStatement.setInt(2, id);
					System.out.println("Запрос на изменение price_add_agr в документе выполнен!!");
                    return  preparedStatement.executeUpdate();                 
            
        } catch(SQLException ex){
            System.out.println(ex);
        }        
                finally{
                	/*try {
    				conn.close();
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}*/
    			} 	             
                              
        return 0;
    }
    
    //********************************************************************************************************************************
    public static int updatePaid(int id, boolean paid) {
    	Connection conn = DbFilter.getConn();       
        String sql = "UPDATE documents SET paid =? WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){               	
				
					preparedStatement.setBoolean(1, paid);
					preparedStatement.setInt(2, id);
					System.out.println("Запрос на изменение paid в документе выполнен!!");
                    return  preparedStatement.executeUpdate();                 
            
        } catch(SQLException ex){
            System.out.println(ex);
        }        
                finally{
                	/*try {
    				conn.close();
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}*/
    			} 	             
                              
        return 0;
    }
  //**********************************************************************************************************************************************	
    public static int updateIfo(int id, List<Integer> ifo_arr) {
    	Connection conn = DbFilter.getConn();       
        String sql = "UPDATE documents SET id_ifo = ? WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
					
					Array array = conn.createArrayOf("integer", ifo_arr.toArray());// realization feature PG JDBC
					preparedStatement.setArray(1, array);					
					preparedStatement.setInt(2, id);
					System.out.println("Запрос на изменение ifo_arr в документе выполнен!!");
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
                
                System.out.println("Запрос выполнен!!");
              
        return 0;
    }	    
    
}