<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Страница настройки прав пользователей</title>
</head>
<body>
     <jsp:include page="_menu.jsp"></jsp:include>
<br>
<div class="container">
<h3>Страница настройки прав пользователей</h3> 
		<div class="col-xl-1"></div>		
		<div class="col-xl-10">
			<table border = "1">
			<tr><th>id</th><th>Имя</th><th>Фамилия</th><th>Login</th><th>Отдел</th><th>Роли</th></tr>
			<c:forEach var="user" items="${users}">
			 <tr>
			 	<td>${user.id}</td>
				<td>${user.name}</td>
				<td>${user.second}</td>
			    <td>${user.login}</td>
			    <td>${user.id_department}</td>
			    <td>${user.roles}</td>
			    <td>
			    <a href='<c:url value="/SetRoleEditServlet?id=${user.id}" />'  class="btn btn-dark" role="button" >Редактировать</a> |
			    <form method="post" action='<c:url value="/DelUserServlet" />' style="display:inline;">
			        <input type="hidden" name="id" value="${user.id}">
			        <input type="submit" class="btn btn-dark" value="Удалить">
			    </form>
			 </td></tr>
			</c:forEach>
			</table>		
		</div>
</div>

<br>
<br>

</body>
</html>