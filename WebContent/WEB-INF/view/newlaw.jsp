<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Создание нового вида закона</title>
</head>
<body>
     <jsp:include page="_menu.jsp"></jsp:include>
<br>
<h3>Создание нового вида закона</h3>


				
<table border = "1">
<tr><th>Название закона</th></tr>

<c:forEach var="law" items="${lawes}">
 <tr>
 <td>${law}   </td>
</tr>
</c:forEach>
</table>
<br>

<br>

<form method="POST" accept-charset="UTF-8" action="${pageContext.request.contextPath}/NewLawServlet">
<input  value="${law.id}" name="id" type="hidden" />
<label>Название закона</label><br>
<input name="name" value="${law.name}" /><br><br>

<input type="submit" class="btn btn-dark" value="Создать" />
</form>
<br>
<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/EmployeeTaskServlet">
<input type="submit" class="btn btn-dark" value="Назад">  
</form>
<br>
<br>
<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/">
<input type="submit" class="btn btn-dark" value="На главную страницу">  
</form>  
</body>
</html>