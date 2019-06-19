<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Employee Task</title>
   </head>
   <body>
   
      <jsp:include page="_menu.jsp"></jsp:include>
       
      <h3>Employee Task</h3>
       
  <form>
   <p>Выберите дату: <input type="date" name="calendar" value="${st_date}">
   <input type="submit" value="Отправить"></p>
  </form>
       
   </body>
</html>