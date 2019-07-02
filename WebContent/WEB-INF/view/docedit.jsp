<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Редактирование документа</title>
</head>
<body>
<jsp:include page="_menu.jsp"></jsp:include>
<br><br>
<h3>Редактирование документа</h3>

<form method="POST" accept-charset="UTF-8" action="${pageContext.request.contextPath}/DocEditServlet">
<label>ID</label><br>
<input value="${doc.id}" name="id" /><br><br>
<label>Тип документа</label><br>
<input value="${doc.id_type}" name="id_type" /><br><br>
<label>Контрагент</label><br>
<input value="${doc.id_contractor}" name="id_contractor" /><br><br>
<label>Название документа</label><br>
<input value="${doc.name}" name="name" /><br><br>
<label>Содержимое документа</label><br>
<input value="${doc.content}" name="content" /><br><br>
<label>Автор Имя Отчество</label><br>
<input name="creator_name" value="${doc.creator_name}" /><br><br>
<label>Автор Фамилия</label><br>
<input name="creator_second" value="${doc.creator_second}" /><br><br>
<label>Статус актуальности</label><br>
<input name="urgency" value="${doc.urgency}" /><br><br>

<label>Отдел</label><br>
<input name="dep" value="${doc.dep}" /><br><br>			

<input type="submit" value="Send" />
</form>

</body>
</html>