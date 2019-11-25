<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Создание нового документа</title>
</head>
<body>
 <jsp:include page="_menu.jsp"></jsp:include>


<style>
   <%@include file='../../css/styles.css' %>
</style>


<br>


<div class="container"> 
<h3>Создание нового документа</h3> 
	<div class="col-xl-1"></div>
	
	<div class="col-xl-10">
		<form method="POST" accept-charset="UTF-8" action="${pageContext.request.contextPath}/NewDocServlet"> <!-- enctype="multipart/form-data" -->
		<input type="hidden" value="${user.id}" name="id" />
		
		<table>
		<tr>
		<td><label>Тип документа</label> 
		<button type="button" class="btn btn-default btn-sm" onclick="javascript:document.location.href='${pageContext.request.contextPath}/NewType_docsServlet'"><span class="glyphicon glyphicon-plus"></span>+ </button>
		</td>
		<td>
		
		</td>
		<td></td><td> <label>Рекомендуемая дата выполнения</label></td>
		</tr>
		<tr>
		<td>
		                 <select name = "id_type">
		                 <c:forEach var="type_doc" items="${type_docs}">
		                 
		                 <option value="<c:out value="${type_doc.id}"/>"><c:out value="${type_doc.name}" /></option>
		                 </c:forEach>
		                 </select>
		</td>
		<td><pre>            </pre></td>
		<td></td>
		<td><input type="date" name="rec_date" value="" placeholder="необязательный">  

  
		</td>
		</tr>
		</table>
		                 
		 <br>
		<label>Контрагент</label> 

		<button type="button" class="btn btn-default btn-sm" onclick="javascript:document.location.href='${pageContext.request.contextPath}/NewContractorServlet'"><span class="glyphicon glyphicon-plus"></span>+ </button>

		<br>
		<!-- <input name="id_contractor2" value="" /><br><br>   -->      
		                 <select name = "id_contractor">
		                 <c:forEach var="contractor" items="${contractors}">
		                 <option value="<c:out value="${contractor.id}"/>"><c:out value="${contractor.name}" /></option>
		                 </c:forEach>
		                 </select><br><br>
		
		
		<label>Название</label><br>
		<input name="name" value="" required    placeholder="Введите название" size = "45"/><br><br> <!-- required -->
		
		<label>Комментарии к содержимому</label>
		<p><textarea rows="5" cols="45" name="content"> </textarea></p>
		<label>Автор</label><br>
		<input name="creator" value="${id_creator}" type="hidden">
		<input name="creator2" value="${loginedUser} ${loginedUserSecond}" readonly title="нельзя редактировать" size = "30"> 
		<br><br>
		<label>Текущий отдел</label><br>
		<input name="current_dep" value="${id_department}" readonly title="нельзя редактировать" type="hidden"/>
		<input name="current_dep2" value="${department.getName()}" readonly title="нельзя редактировать" /><br><br>
		
		<label>Статус актуальности</label>
		<button type="button" class="btn btn-default btn-sm" onclick="javascript:document.location.href='${pageContext.request.contextPath}/NewUrgencyServlet'"><span class="glyphicon glyphicon-plus"></span>+ </button>
		<br>
		                 <select name = "id_urgency">
		                 <c:forEach var="urgency" items="${urgencies}">
		                 <option value="<c:out value="${urgency.id}"/>"><c:out value="${urgency.name}" /></option>
		                 </c:forEach>
		                 </select><br><br>

		<label>ТРУ</label>
		<button type="button" class="btn btn-default btn-sm" onclick="javascript:document.location.href='${pageContext.request.contextPath}/NewTruServlet'"><span class="glyphicon glyphicon-plus"></span>+ </button>
		<br>
		                 <select name = "id_tru">
		                 <c:forEach var="tru" items="${trues}">
		                 <option value="<c:out value="${tru.id}"/>"><c:out value="${tru.name}" /></option>
		                 </c:forEach>
		                 </select><br><br>
		<label>Закон</label><br>
		                 <select name = "id_law">
		                 <c:forEach var="law" items="${laws}">
		                 <option value="<c:out value="${law.id}"/>"><c:out value="${law.name}" /></option>
		                 </c:forEach>
		                 </select><br><br>
		<label>Подразделение</label><br>
		                 <select name = "id_division">
		                 <c:forEach var="division" items="${divisions}">
		                 <option value="<c:out value="${division.id}"/>"><c:out value="${division.name}" /></option>
		                 </c:forEach>
		                 </select><br><br>
		<label>Источник финансирования</label>
		<button type="button" class="btn btn-default btn-sm" onclick="javascript:document.location.href='${pageContext.request.contextPath}/NewIfoServlet'"><span class="glyphicon glyphicon-plus"></span>+ </button>
		<br>	
		                 <!-- <select name = "id_ifo"> -->
		                 <c:forEach var="ifo" items="${ifoes}">
		                <%--  <option value="<c:out value="${ifo.id}"/>"><c:out value="${ifo.name}" /></option> --%>
		                 <input type="checkbox" name="id_ifo" value="<c:out value="${ifo.id}"/>"  <c:if test="${ifo.name == 'н/д'}"> checked </c:if>   /> <c:out value="${ifo.name}" />
		                 </c:forEach>
		                 <!-- </select> --><br><br>
		                 

		<input type="submit" class="btn btn-dark" value="Создать" />
		</form>
		
	</div>
	<br>
	<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/EmployeeTaskServlet">
	<input type="submit" class="btn-sm btn-dark" value="Назад">  
	</form>
	<br>
	<br>
	<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/">
	<input type="submit" class="btn-sm btn-dark" value="На главную страницу">  
	</form>  
</div>
 
<br><br>


    


</body>
</html>