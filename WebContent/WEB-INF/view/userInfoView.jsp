<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   



    
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">

  
<!--   <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script> -->

       
      <title>User Info</title>
   </head>
   <body>
  
     <jsp:include page="_menu.jsp"></jsp:include>
 

 
   <div class="row">
   	 <div class="col-xl-1"></div>
     <div class="col-xl-4">
     <h4>Документы пользователя ${loginedUser} ${loginedUserSecond} </h4>
     </div>
	 <div class="col-xl-6">
	 <input class="form-control" id="myInput" type="text" placeholder="Поиск совпадений..">
	 </div>
	 <div class="col-xl-1"></div>
  </div>    


<div class="container-fluid  px-3  margin: auto">

<div class="row justify-content-md-center"> <!-- делаем таблицу адаптивной table-responsive -->
<table border="1" class="table table-bordered table-hover table-responsive table-sm px-3">
<thead>
<tr><th>id</th><th>Тип</th><th>Контрагент</th><th>Название</th><th>Комментарии</th><th>Автор</th>
<th>Статус актуальности</th><th>Дата создания</th><th>Закончен ли</th><th>Рек. дата</th><th>Получатели</th><th>Отправители</th><th>Текущий отдел</th>
<th>Дата реестр</th><th>ТРУ</th><th>Закон</th><th>Подразд.</th><th>Сумма</th><th>Оплата</th><th>ИФО</th><th>Доп согл.</th><th>Сумма по доп согл.</th>
<th>Прикр.</th><th>Ред.</th><th>Отпр.</th>
</tr>
</thead>
<c:forEach var="doc" items="${docs}">
 <tbody id="myTable">
 <tr>
 	<td><a href='<c:url value="/SendDocServlet?id=${doc.id}" />'> ${doc.id}</a></td>
	<td>${doc.id_type}</td>
	<td>${doc.id_contractor}</td>
    <td>${doc.name}</td>
    <td>${doc.content}</td>
    <td>${doc.creator_name} 
        ${doc.creator_second}</td>
    <td>${doc.urgency}</td>
    <td>${doc.date_cre}</td>
    <td>${doc.status_finished}</td>
    <td>${doc.rec_date}</td>
    <td>${doc.receiver_list}</td>
    <td>${doc.sender_list}</td>
    <td>${doc.dep}</td>
    <td><c:if test="${empty doc.blob}">Не Загружен</c:if>
    <c:if test="${doc.blob!=null}">Загружен</c:if></td>
    <td><a href='<c:url value="/DocEditServlet?id=${doc.id}" />'  class="btn btn-dark" role="button">Ред.</a> </td>
	<%-- <td><a href='<c:url value="/SendDocServlet?id=${doc.id}" />'> Отпр. </a></td> --%>
	<td><a href="<c:url value="/SendDocServlet?id=${doc.id}" />" class="btn btn-dark" role="button">Отпр.</a></td>
	
</tr>
</tbody>
</c:forEach>
</table>

<br> 


</div>
</div>

   <div class="row">
   	 <div class="col-xl-1"></div>
     <div class="col-xl-3">
     	<form method="POST" accept-charset="UTF-8" action="${pageContext.request.contextPath}/UserInfoServlet?path=${filepath}">
     		
		<input type="submit" class="btn btn-dark" value="Выгрузить список документов в виде отчета">
		
		<input type="file" class="btn btn-dark" name="filepath"  value="Путь выгрузки отчета"/>
	  
		</form> 
	 </div>
	<div class="col-xl-3">
<!-- 	<input type="file" class="btn btn-dark" name="filepath"  value="Путь выгрузки отчета" /> -->

	</div>
		

	 <div class="col-xl-4">
	 <form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/">
	 <input type="submit" class="btn btn-dark" value="На главную страницу">  
	 </form> 
	 </div>
	 <div class="col-xl-1"></div>
  </div>  

<script>
$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
</script>

 
   </body>
</html>