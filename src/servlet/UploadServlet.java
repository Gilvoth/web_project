package servlet;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import utils.DocDb;
//import com.oreilly.servlet.MultipartRequest;  

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*10, 	// 10 MB   //04/12/2019 
maxFileSize=1024*1024*50,      	// 50 MB
maxRequestSize=1024*1024*100)   	// 100 MB
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		String id = null;
		//String filepath = null;
		ByteArrayInputStream filecontent = null;
		try {
			id = request.getParameter("id");
			//filepath = request.getParameter("filepath");
			Part filePart = request.getPart("filepath");
			System.out.println("id " + id);
			//System.out.println("filepath " + filepath);
			System.out.println("filePart " + filePart);
			filecontent = (ByteArrayInputStream) filePart.getInputStream();

			
			
			//doGet(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			
		} 
		
    	if (id!=null) {
    		//Connection conn = DbFilter.getConn();
            DocDb.insertBlob(Integer.parseInt(id), filecontent);
            System.out.println("Запрос на вставку выполнен");
            String path = request.getContextPath() + "/DocEditServlet?id="+id;
            response.sendRedirect(path);
            
    	}
    		//try {
			//	//conn.setAutoCommit(false);
			//} catch (SQLException e) {
			//	// TODO Auto-generated catch block
			//	e.printStackTrace();
			//}
    		
        /*    // Part list (multi files).
            for (Part part : request.getParts()) {
                String fileName = extractFileName(part);
                System.out.println("имя файла" + fileName);
                if (fileName != null && fileName.length() > 0) {
                    // File data
                    InputStream is = part.getInputStream();
                    // Write to file
                    //this.writeToDB(conn, fileName, is, description);
                    */
    		

                
            
            /*
            try {
				conn.commit();
				System.out.println("Файл загружен!");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/


            
            
    		//DocDb.insertBlob(id, file);
    		
    	
		/*
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		          
		MultipartRequest m=new MultipartRequest(request,"d:/new");  
		out.print("successfully uploaded");*/  
		
	}
	
	//read path from jsp            
/*    private String extractFileName(Part part) {
        // form-data; name="file"; filename="C:\file1.zip"
        // form-data; name="file"; filename="C:\Note\file2.zip"
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                // C:\file1.zip
                // C:\Note\file2.zip
                String clientFileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
                clientFileName = clientFileName.replace("\\", "/");
                int i = clientFileName.lastIndexOf('/');
                // file1.zip
                // file2.zip
                return clientFileName.substring(i + 1);
            }
        }
        return null;
    }	
*/
}
