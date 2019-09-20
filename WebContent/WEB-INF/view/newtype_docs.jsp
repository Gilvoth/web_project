<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Создание нового типа документа</title>
</head>
<body>
     <jsp:include page="_menu.jsp"></jsp:include>
<br>
<div class="container">
<h3>Создание нового типа документа</h3>
		<div class="col-xl-1"></div>		
		<div class="col-xl-10">
			<table border = "1">
			<tr><th>Тип документа</th></tr>
			<c:forEach var="type_doc" items="${type_docs2}">
			 <tr>
				<td>${type_doc}</td>
			</tr>
			</c:forEach>
			</table>
			<br>
			<br>
			<form method="POST" accept-charset="UTF-8" action="${pageContext.request.contextPath}/NewType_docsServlet">
			<input type="hidden" value="${type_docs.id}" name="id" />
			<label>Имя нового типа документа</label><br>
			<input name="name" value="${type_docs.name}" /><br><br>
			<input type="submit" class="btn btn-dark" value="Создать" />
			</form>
			<br>
			<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/EmployeeTaskServlet">
			<input type="submit" class="btn btn-dark" value="Назад">  
			</form>
			<br>
			<br>
			<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/">
			<input type="submit" class="btn-sm btn-dark" value="На главную страницу">  
			</form>		
		</div>
</div>
<br>
<br>

</body>
</html>