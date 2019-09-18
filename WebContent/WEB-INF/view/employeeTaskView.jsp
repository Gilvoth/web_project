<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Создание документов и реквизитов</title>
   </head>
   <body>
   
      <jsp:include page="_menu.jsp"></jsp:include>
 
<div class="container mx-auto"  >  
	<div class="row">     
      <h3>Создание документов и реквизитов</h3>
    </div>
</div>
       
<%--   <form>
   <p>Выберите дату: <input type="date" name="calendar" value="${st_date}">
   <input type="submit" value="Отправить"></p>
  </form> --%>
       
<br>
<br>
 <div class="row justify-content-md-start"> <!-- делаем таблицу адаптивной -->
<div class="col-xl-1"></div>
<div class="col-xl-10">
<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/NewDocServlet">
<input type="submit" class="btn btn-dark" value="Загрузить новый документ">  
</form>
</div>
<div class="col-xl-1"></div>
 </div>
<br> <br>
 <div class="row justify-content-md-start"> <!-- делаем таблицу адаптивной -->
  <div class="col-xl-1"></div>
<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/NewType_docsServlet">
<input type="submit" class="btn btn-secondary" value="Типы документов">  
</form>
|
<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/NewContractorServlet">
<input type="submit" class="btn btn-secondary" value="Контрагенты">  
</form>
|
<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/NewUrgencyServlet">
<input type="submit" class="btn btn-secondary" value="Типы актуальности документов">  
</form>
|
<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/NewType_notificationServlet">
<input type="submit" class="btn btn-secondary" value="Типы уведомлений">  
</form>
 <div class="col-xl-1"></div>
 </div>
<br>
 <div class="row justify-content-md-start"> <!-- делаем таблицу адаптивной -->
  <div class="col-xl-1"></div>
<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/NewTruServlet">
<input type="submit" class="btn btn-secondary" value="ТРУ">  
</form>
|
<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/NewLawServlet">
<input type="submit" class="btn btn-secondary" value="Виды закона">  
</form>
|
<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/NewDivisionServlet">
<input type="submit" class="btn btn-secondary" value="Подразделения">  
</form>
|
<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/NewIfoServlet">
<input type="submit" class="btn btn-secondary" value="ИФО">  
</form>
 <div class="col-xl-1"></div>
</div>
<br><br>
 <div class="row justify-content-md-start"> <!-- делаем таблицу адаптивной -->
 <div class="col-xl-1"></div>
 <div class="col-xl-10">
<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/">
<input type="submit" class="btn-sm btn-dark" value="На главную страницу">  
</form>  
</div>
<div class="col-xl-1"></div>
</div>
   </body>
</html>