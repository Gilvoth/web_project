<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Создание нового типа cтатуса актуальности</title>
</head>
<body>
     <jsp:include page="_menu.jsp"></jsp:include>
<br>

<div class="container">
<h3>Создание нового типа cтатуса актуальности</h3>
		<div class="col-xl-1"></div>		
		<div class="col-xl-10">
			<table border = "1">
			<tr><th>Номер</th><th>Имя типа статуса документа</th></tr>
			<c:forEach var="urgency" items="${urgencies}">
			 <tr>
			<td>${urgency.id}   </td>
			<td>${urgency.name} </td>
			</tr>
			</c:forEach>
			</table>
			<br>
			<br>
			<form method="POST" accept-charset="UTF-8" action="${pageContext.request.contextPath}/NewUrgencyServlet">
			<input  value="${urgency.id}" name="id" type="hidden" />
			<label>Имя нового типа статуса документа</label><br>
			<input name="name" value="${urgency.name}" /><br><br>
			<input type="submit" class="btn btn-dark" value="Создать" />
			</form>
			<br>
<%-- 			<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/EmployeeTaskServlet">
			<input type="submit" class="btn btn-dark" value="Назад">  
			</form> --%>
			<input type="submit" class="btn-sm btn-dark" value="Назад" onCLick="history.back()"> 
			<br>
			<br>
			<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/">
			<input type="submit" class="btn btn-dark" value="На главную страницу">  
			</form>		
		</div>
</div>

<br>
<br>  
</body>
</html>