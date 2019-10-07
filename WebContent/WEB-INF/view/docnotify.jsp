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
			<div class="col-md-7">			
				<table border="1" class="table table-bordered table-hover table-responsive table-sm px-3">
				<thead>
				<tr  bgcolor="#C0C0C0" >
				<th>id</th><th>id_creator</th><!-- <th>id_type</th> --><th>Вид уведомления</th><th>date</th><th>id_document</th><th>id_receiver</th>
				</tr>
				</thead>
				<c:forEach var="notification" items="${notifications}">
				 <tbody id="myTable">
				 <tr>
				    <td>${notification.id}</td>
					<td>${notification.id_creator}</td>
<%-- 					<td>${notification.id_type}</td> --%>
					<td>${notification.type_notify_name}</td>			
				    <td>${notification.date}</td>
				    <td>${notification.id_document}</td>
				    <td>${notification.id_receiver}</td>
				</tr>
				</tbody>
				</c:forEach>
				</table>
			</div>
			<div class="col-md-4 col-md-offset-7">	
				<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/UserInfoServlet">
				<input type="submit" class="btn-sm btn-dark" value="Назад к списку документов">  
				</form>	
			</div>
		</div>
	</div>

<br><br>
</body>
</html>