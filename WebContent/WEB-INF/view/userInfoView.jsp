<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>User Info</title>
   </head>
   <body>
 
     <jsp:include page="_menu.jsp"></jsp:include>
 
      <h3>Личный кабинет пользователя: ${loginedUser} ${loginedUserSecond}</h3>

<h4>Документы пользователя:</h4>      
<table border="2">

<tr><th>id</th><th>Тип</th><th>Контрагент</th><th>Имя</th><th>Содержание</th><th>Автор</th>
<th>Статус актуальности</th><th>Дата создания</th><th>Закончен ли</th><th>Рек. дата</th><th>Получатели</th><th>Отправители</th><th>Текущий отдел</th>
</tr>
<c:forEach var="doc" items="${docs}">
 <tr align=middle>
 	<td>${doc.id}</td>
	<td>${doc.id_type}</td>
	<td>${doc.id_contractor}</td>
    <td>${doc.name}</td>
    <td>${doc.content}</td>
    <td>${doc.creator}</td>
    <td>${doc.id_urgency}</td>
    <td>${doc.date_cre}</td>
    <td>${doc.status_finished}</td>
    <td>${doc.rec_date}</td>
    <td>${doc.receiver_list}</td>
    <td>${doc.sender_list}</td>
    <td>${doc.current_dep}</td>
    <td>
    <a href='<c:url value="/SetRoleEditServlet?id=${user.id}" />'>Редактировать</a>
    <form method="post" action='<c:url value="/DelUserServlet" />' style="display:inline;">
<%--         <input type="hidden" name="id" value="${user.id}">
        <input type="submit" value="Удалить"> --%>
    </form>
 </td></tr>
</c:forEach>
</table>

 
 
   </body>
</html>