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
 <div class="row justify-content-md-center"> <!-- делаем таблицу адаптивной -->

<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/NewDocServlet">
<input type="submit" class="btn btn-dark" value="Загрузить новый документ">  
</form>
<br>       <br>
<br>

<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/NewType_docsServlet">
<input type="submit" class="btn btn-dark" value="Создать новый тип документов">  
</form>
<br>
<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/NewContractorServlet">
<input type="submit" class="btn btn-dark" value="Создать нового контрагента">  
</form>
<br>
<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/NewUrgencyServlet">
<input type="submit" class="btn btn-dark" value="Создать новые типы актуальности документов">  
</form>
<br>
<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/NewType_notificationServlet">
<input type="submit" class="btn btn-dark" value="Создать новые типы уведомлений">  
</form>
<br>
<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/NewTruServlet">
<input type="submit" class="btn btn-dark" value="Создать новый ТРУ">  
</form>
<br>
<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/NewLawServlet">
<input type="submit" class="btn btn-dark" value="Создать новый вид закона">  
</form>
<br>
<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/NewDivisionServlet">
<input type="submit" class="btn btn-dark" value="Создать новое подразделение">  
</form>
<br>
<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/NewIfoServlet">
<input type="submit" class="btn btn-dark" value="Создать новый ИФО">  
</form>
<br>
 </div>
<br>
<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/">
<input type="submit" class="btn btn-dark" value="На главную страницу">  
</form>  
   </body>
</html>