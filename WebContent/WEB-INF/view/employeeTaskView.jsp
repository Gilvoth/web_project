<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Employee Task | Создание документов</title>
   </head>
   <body>
   
      <jsp:include page="_menu.jsp"></jsp:include>
       
      <h3>Employee Task | Создание документов</h3>
       
  <form>
   <p>Выберите дату: <input type="date" name="calendar" value="${st_date}">
   <input type="submit" value="Отправить"></p>
  </form>
       
<br>
<br>
<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/NewDocServlet">
<input type="submit" value="Загрузить новый документ">  
</form>
<br>       <br>
<br>
<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/NewType_docsServlet">
<input type="submit" value="Создать новый тип документов">  
</form>
<br>
<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/NewContractorServlet">
<input type="submit" value="Создать нового контрагента">  
</form>
<br>
<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/NewUrgencyServlet">
<input type="submit" value="Создать новые типы актуальности документов">  
</form>
<br>
<br>
<br>
<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/">
<input type="submit" value="На главную страницу">  
</form>  
   </body>
</html>