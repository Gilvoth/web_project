<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<h3>Создание нового типа cтатуса актуальности</h3>


<table border = "1">
<tr><th>Контрагент</th></tr>
<c:forEach var="urgency2" items="${urgencies}">
 <tr>

	<td>${urgency2}</td>

</tr>
</c:forEach>
</table>
<br>
<br>

<form method="POST" accept-charset="UTF-8" action="${pageContext.request.contextPath}/NewUrgencyServlet">
<input type="hidden" value="${urgency.id}" name="id" />
<label>Имя нового типа документа</label><br>
<input name="name" value="${urgency.name}" /><br><br>

<input type="submit" value="Send" />
</form>
<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/EmployeeTaskServlet">
<input type="submit" value="Назад">  
</form>
<br>
<br>
<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/">
<input type="submit" value="На главную страницу">  
</form>  
</body>
</html>