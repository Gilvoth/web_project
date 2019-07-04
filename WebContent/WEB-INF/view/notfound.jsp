<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Элемент не найден!</title>
   </head>
   <body>
    
      <jsp:include page="_menu.jsp"></jsp:include>
    
      <br/><br/>
       
      <h3 style="color:red;">Элемент не найден!</h3>
<br><br>
<a href='<c:url value="/UserInfoServlet" />'>Назад к списку документов </a> 

   </body>
</html>