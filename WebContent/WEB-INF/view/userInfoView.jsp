<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>User Info</title>
   </head>
   <body>
 
     <jsp:include page="_menu.jsp"></jsp:include>
 
      <h3>Личный кабинет пользователя:</h3>

${loginedUser}
${loginedUserSecond}
<%--  
      User Name: <b>${loginedUser}</b>
      User Name: <b>${name}</b> --%>
      <br />

 
 
   </body>
</html>