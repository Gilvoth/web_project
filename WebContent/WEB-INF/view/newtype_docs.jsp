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
<h3>Создание нового документа</h3>
<form method="POST" accept-charset="UTF-8" action="${pageContext.request.contextPath}/NewType_docsServlet">
<input type="hidden" value="${type_docs.id}" name="id" />
<label>Имя нового типа документа</label><br>
<input name="name" value="${type_docs.name}" /><br><br>

<input type="submit" value="Send" />
</form>
</body>
</html>