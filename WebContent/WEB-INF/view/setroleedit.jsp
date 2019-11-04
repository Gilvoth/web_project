<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Редактирование пользователя</title>
</head>
<body>
     <jsp:include page="_menu.jsp"></jsp:include>
<br><br><br><br>
<div class="container">
<h3>Редактирование пользователя</h3>
		<div class="col-xl-1"></div>		
		<div class="col-xl-10">
			<form method="POST" accept-charset="UTF-8" action="${pageContext.request.contextPath}/SetRoleEditServlet">
				<input type="hidden" value="${user.id}" name="id" />
				<label>Имя Отчество</label><br>
				<input name="name" value="${user.name}" /><br><br>
				<label>Фамилия</label><br>
				<input name="second" value="${user.second}" /><br><br>
				<label>Логин</label><br>
				<input name="login" value="${user.login}" /><br><br>
				<label>Пароль</label><br>
				<input name="password" value="${user.password}" /><br><br>
				<label>Отдел</label><br>
				<input name="id_department" value="${user.id_department}" /><br><br>
				<label>Роли</label><br>
				<%-- <input name="roles" value="${user.roles}" /><br><br> --%>
				<input type="checkbox" name="role" value="ROLE_ASUP" />роль ROLE_ASUP
				<input type="checkbox" name="role" value="ROLE_JUR"  />роль ROLE_JUR
				<br>
				<label>Статус подтверждения</label><br>	
				<input type="checkbox" name="confirmed" value="true"  ${user.confirmed == true ? 'checked' : ' '}  /> Подтверждён
				<br><br>
				<input type="submit" class="btn btn-dark" value="Отредактировать" />
			</form>		
		</div>
</div>


</body>
</html>