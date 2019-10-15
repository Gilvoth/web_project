<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Уведомления документа</title>
</head>
<body>
<jsp:include page="_menu.jsp"></jsp:include>
<br><br>




<div class="container">  
	<div class="col-xl-1"></div>		
		<div class="row">
			<div class="col-md-9">			
				<table border="1" class="table table-bordered table-hover table-responsive table-sm px-3">
				<thead>
				<tr  bgcolor="#C0C0C0" >
				<th>ID уведомления</th><th>Автор уведомления</th><!-- <th>id_type</th> --><th>Вид уведомления</th><th>Дата</th><th>ID документа</th><th>ПолучательID</th><th>Получатель уведомления</th>
				</tr>
				</thead>
				<c:forEach var="notification" items="${notifications}">
				 <tbody id="myTable">
				 <tr>
				    <td>${notification.id}</td>
<%-- 					<td>${notification.id_creator}</td> --%>
					<td>${notification.users_name} ${notification.users_second}</td>
<%-- 					<td>${notification.id_type}</td> --%>
					<td>${notification.type_notify_name}</td>			
				    <td>${notification.date}</td>
				    <td>${notification.id_document}</td>
				    <td>${notification.id_receiver}</td>
				    <td>${notification.receiver_name} ${notification.receiver_second}</td>
				</tr>
				</tbody>
				</c:forEach>
				</table>
			</div>
			<div class="col-md-2 col-md-offset-9">	
				<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/UserInfoServlet">
				<input type="submit" class="btn-sm btn-dark" value="Назад к списку документов">  
				</form>	
			</div>
		</div>
	</div>

<br><br>
</body>
</html>