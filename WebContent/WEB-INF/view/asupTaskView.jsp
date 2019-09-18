<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Администрирование</title>
   </head>
   <body>
   
<jsp:include page="_menu.jsp"></jsp:include>

<div class="container">  
<div class="col-xl-1"></div>
<div class="col-xl-6">
	<h3>Администрирование </h3>
	       
	Внимание!
	Эта страница видна только администраторам (пользователю с ролью ROLE_ASUP). 
	       
	<br>
	<br>
	<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/SetRoleServlet">
	<input type="submit" class="btn btn-dark" value="Страница настройки прав пользователей">  
	</form>
	<br>
	<br>
	<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/">
	<input type="submit" class="btn-sm btn-dark" value="На главную страницу">  
	</form>
</div>
<div class="col-xl-6"></div>
</div> 

   
   </body>
</html>