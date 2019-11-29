<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>${infomessage}</title>
   </head>
   <body>
    
      <jsp:include page="_menu.jsp"></jsp:include>
    
      <br/><br/>
       
      <h3>${infomessage}</h3>
      <input type="submit" class="btn-sm btn-dark" value="Назад" onCLick="history.back()">        
   </body>
</html>