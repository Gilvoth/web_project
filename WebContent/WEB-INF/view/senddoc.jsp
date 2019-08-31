<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Отправка документа ${id}</title>
</head>
<body>
<jsp:include page="_menu.jsp"></jsp:include>

<h3>Отправка документа ${id}. Выберите отдел</h3>

<table border = "1">
<tr><th>Номер</th><th>Наименование отдела</th></tr>

<c:forEach var="department" items="${departments}">
 <tr>
<td>${department.id}   </td>
<td>${department.name} </td>
<td>    <form method="post" action='<c:url value="/SendDocServlet?id=${id}&id_dep=${department.id}" />' style="display:inline;">
        <input type="hidden" name="id" value="${department.id}">
        <input type="submit" value="Отправить">
    </form>
</td>    
</tr>
</c:forEach>
</table>
<br>

<table border = "1">
<tr><th>Номер</th><th>Наименование пользователя</th></tr>

<c:forEach var="user" items="${users}">
 <tr>
<td>${user.id}   </td>
<td>${user.name} </td>
<td>    <form method="post" action='<c:url value="/SendDocServlet?id=${id}&id_user=${user.id}" />' style="display:inline;">
        <input type="submit" value="Отправить">
    </form>
</td>    
</tr>
</c:forEach>
</table>
<br>


<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/UserInfoServlet">
<input type="submit" value="Назад к документам">  
</form>
<br>

</body>
</html>