<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<input value="${doc.id_type}" name="id_type" />
                        <select name = "id_type">
                        <c:forEach var="type_doc" items="${type_docs}">
                            <option value="<c:out value="${type_doc}" />"><c:out value="${type_doc}" /></option>
                            </c:forEach>
                        </select><br>
<br>
<label>Контрагент</label><br>
<input value="${doc.id_contractor}" name="id_contractor" />
                        <select name = "id_type">
                        <c:forEach var="contractor" items="${contractors}">
                            <option value="<c:out value="${contractor}" />"><c:out value="${contractor}" /></option>
                            </c:forEach>
                        </select><br>
<br>
<label>Название документа</label><br>
<input value="${doc.name}" name="name" /><br><br>
<label>Содержимое документа</label><br>
<input value="${doc.content}" name="content" /><br><br>
<label>Автор Имя Отчество</label><br>
<input name="creator_name" value="${doc.creator_name}" /><br><br>
<label>Автор Фамилия</label><br>
<input name="creator_second" value="${doc.creator_second}" /><br><br>
<label>Статус актуальности</label><br>
<input name="urgency" value="${doc.urgency}" />
                        <select name = "id_type">
                        <c:forEach var="urgency" items="${urgencies}">
                            <option value="<c:out value="${urgency}" />"><c:out value="${urgency}" /></option>
                            </c:forEach>
                        </select><br>
<br>

<label>Отдел</label><br>
<input name="dep" value="${doc.dep}" /><br><br>			
<img src="${doc.blob}" alt="не могу отобразить">
<input type="submit" value="Send" />

<%-- <label>${type_docs}</label><br>  
<table border="1">
<c:forEach var="type_doc" items="${type_docs}">
 	<tr><td><c:out value="${type_doc}" /> </td></tr>
</c:forEach>
</table>
--%>


 

</form>

<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/UserInfoServlet">
<input type="submit" value="На главную страницу">  
</form>

</body>
</html>