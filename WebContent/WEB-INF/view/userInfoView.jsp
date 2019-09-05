<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
  
  <meta name="viewport" content="width=device-width, initial-scale=1">
<!--   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"> -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
       
      <title>User Info</title>
   </head>
   <body>
 
     <jsp:include page="_menu.jsp"></jsp:include>
 
      <h3>Личный кабинет пользователя: ${loginedUser} ${loginedUserSecond}</h3>

<h4>Документы пользователя:</h4>      


<div class="container mt-3">
<input class="form-control" id="myInput" type="text" placeholder="Поиск совпадений..">
<br>  <br> 
<table border="2" class="table table-bordered">
<thead>
<tr><th>id</th><th>Тип</th><th>Контрагент</th><th>Название</th><th>Комментарии</th><th>Автор</th>
<th>Статус актуальности</th><th>Дата создания</th><th>Закончен ли</th><th>Рек. дата</th><th>Получатели</th><th>Отправители</th><th>Текущий отдел</th>
<th>Прикр.</th><th>Ред.</th><th>Отпр.</th>
</tr>
</thead>
<c:forEach var="doc" items="${docs}">
 <tbody id="myTable">
 <tr align=middle>
<%--  	<td>${doc.id}</td> --%>
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
    <td><a href='<c:url value="/DocEditServlet?id=${doc.id}" />'>Ред.</a> </td>
	<td><a href='<c:url value="/SendDocServlet?id=${doc.id}" />'> Отпр. </a></td>
</tr>
</tbody>
</c:forEach>
</table>
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
 
 
<br> 
<%-- <form method="POST" accept-charset="UTF-8" action="${pageContext.request.contextPath}/UserInfoServlet?doc=${docs}"> --%>
<form method="POST" accept-charset="UTF-8" action="${pageContext.request.contextPath}/UserInfoServlet">
<input type="submit" value="Выгрузить список документов в виде отчета">  
</form> 

<br>
<br>
<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/">
<input type="submit" value="На главную страницу">  
</form>   
 
 <div class="container">
  <h2>Button Elements</h2>
  <a href="#" class="btn btn-info" role="button">Link Button</a>
  <button type="button" class="btn btn-info">Button</button>
  <input type="button" class="btn btn-info" value="Input Button">
  <input type="submit" class="btn btn-info" value="Submit Button">
</div>
 
   </body>
</html>