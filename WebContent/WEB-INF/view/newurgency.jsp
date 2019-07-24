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
<h3>Создание нового типа cтатуса актуальности</h3>


				
<table border = "1">
<tr><th>Имя типа статуса документа</th></tr>



<%-- <c:forEach items="${urgencys}" var="urgency">
    <tr>
        <c:forEach items="${urgency}" var="urgs">

            <td>${urgs.id}</td>

        </c:forEach>
    </tr>
</c:forEach> --%>

<%-- <c:forEach var="urgency" items="${urgencys}"> --%>
 <tr>
<%-- 	<td><c:out value="${urgency2.id}"/></td>
	<td><c:out value="${urgency2.name}"/></td> --%>
	
<%--  	<td>${urgencys.id}   </td>
	<td>${urgencys.name} </td> --%>
	
<%-- 	<td>${urgency2} </td> --%>

</tr>
<%-- </c:forEach> --%>
</table>
<br>

<%-- 	<c:out value="${urgencys.id}"/>
	<c:out value="${urgencys.name}"/> --%>
	
<%-- <table border = "1">
<tr><th>Имя типа статуса документа</th></tr>
<c:forEach var="urgency" items="${urgencys}">
<c:forEach items="#{requestScope.urgencies2}" var="urgency22">
<c:forEach var="prod" begin="1" end="${fn:length(urgencies2)}">
        <option value="${prod.name}" >${l}</option>


 <tr>
	<td><c:out value="${urgency22.id}"/></td>
	<td><c:out value="${urgency22.name}"/></td>
 	<td>${urgency.id}   </td>
	<td>${urgency.name} </td>







</tr>
</c:forEach>
</table> --%>


<%--       <jsp:useBean id = "urgencys" class = "model.Urgency"> 
         <jsp:setProperty name = "urgs" property = "id" value = "777"/>
         <jsp:setProperty name = "urgs" property = "name" value = "Ali"/>
      </jsp:useBean>

      <p>Urgs:
         <jsp:getProperty name = "urgencys" property = "id"/>
         <jsp:getProperty name = "urgencys" property = "name"/>
      </p>
 --%>
<br>

<%-- <form method="POST" accept-charset="UTF-8" action="${pageContext.request.contextPath}/NewUrgencyServlet">
<input  value="${urgency.id}" name="id" type="hidden" />
<label>Имя нового типа статуса документа</label><br>
<input name="name" value="${urgency.name}" /><br><br>

<input type="submit" value="Send" />
</form> --%>

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