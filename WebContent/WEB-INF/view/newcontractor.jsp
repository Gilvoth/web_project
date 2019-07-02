<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Создание нового контрагента</title>
</head>
<body>
     <jsp:include page="_menu.jsp"></jsp:include>
<br>
<h3>Создание нового контрагента</h3>
<form method="POST" accept-charset="UTF-8" action="${pageContext.request.contextPath}/NewContractorServlet">
<input type="hidden" value="${contractor.id}" name="id" />
<label>Имя нового контрагента</label><br>
<input name="name" value="${contractor.name}" /><br><br>
<label>Комментарий</label><br>
<input name="comment" value="${contractor.comment}" /><br><br>
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