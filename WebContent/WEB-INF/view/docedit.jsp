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
<a href='<c:url value="/UserInfoServlet" />'>Назад к списку документов </a> 

<h3>Редактирование документа</h3>

<br>


<c:if test="${empty doc.blob}">    
<form method="POST" accept-charset="UTF-8" action="${pageContext.request.contextPath}/UploadServlet?id=${doc.id}">
        Выберите изображение для загрузки:
        <br />
        <input type="file" name="filepath"  />
<input type="submit" value="Загрузить изображение в документ">  
</form> 
</c:if>

<c:if test="${doc.blob!=null}">    
<form method="POST" accept-charset="UTF-8" action="${pageContext.request.contextPath}/ViewImageServlet?id=${doc.id}">
<input type="submit" value="Просмотр изображения документа">  
</form> 
</c:if>

<br>
<br>

<%-- <form method="POST" accept-charset="UTF-8" action="${pageContext.request.contextPath}/ViewImageServlet?id=${doc.id}">
<input type="submit" value="Просмотр изображения документа">  
</form> --%>
<%-- <form method="POST" accept-charset="UTF-8" action="${pageContext.request.contextPath}/UploadServlet?id=${doc.id}" 
enctype="multipart/form-data">
        Select file to upload:
        <br />
        <input type="file" name="file"  />
<input type="submit" value="Загрузить изображение в документ">  
</form> --%>


<%-- <form method="POST" accept-charset="UTF-8" action="${pageContext.request.contextPath}/UploadServlet?id=${doc.id}">
        Выберите изображение для загрузки:
        <br />
        <input type="file" name="filepath"  />
<input type="submit" value="Загрузить изображение в документ">  
</form> --%>

<br>
<form method="POST" accept-charset="UTF-8" action="${pageContext.request.contextPath}/DocEditServlet">
<label>ID</label><br>
<input value="${doc.id}" name="id" readonly title="нельзя редактировать" /><br><br>
<label>Тип документа</label><br>
<input value="${doc.id_type_int}" name="id_type_int"  type = "hidden"/>
<input value="${doc.id_type}" name="doc_id_type"  type = "hidden"/>
                        <select name = "id_type">
                        <c:forEach var="type_doc" items="${type_docs}">
                            <%-- <option value="<c:out value="${type_doc}"/>"     ${doc.id_type == type_doc ? 'selected' : ' '} ><c:out value="${type_doc}" /></option> --%>
                            <option value="<c:out value="${type_doc}"/>"     ${doc.id_type == type_doc ? 'selected' : ' '} ><c:out value="${type_doc}" /></option>
                            </c:forEach>
                        </select><br>
<br>
<label>Контрагент</label><br>
<input value="${doc.id_contractor}" name="id_contractor" />
                        <select name = "id_type">
                        <c:forEach var="contractor" items="${contractors}">
                            <option value="<c:out value="${contractor}" />"  ${doc.id_contractor == contractor ? 'selected' : ' '}  ><c:out value="${contractor}" /></option>
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
<input name="id_urgency" value="${doc.id_urgency}" type = "hidden"/> <!-- поменять имя и принять параметр в метод пост -->
<input name="doc_urgency" value="${doc.urgency}" type = "hidden" /> <!-- поменять имя и принять параметр в метод пост -->
                        <select name = "urgency">
                        <c:forEach var="urgency" items="${urgencies}">
                            <option value="${urgency}" ${doc.urgency == urgency ? 'selected' : ' '}><c:out value="${urgency}" /></option>
                            </c:forEach>
                            
                        </select><br>
<br>

<label>Отдел</label><br>
<input name="dep" value="${doc.dep}" readonly title="нельзя редактировать"/><br><br>		


<input type="submit" value="Send" />
</form>
<br>
<br>	
<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/UserInfoServlet">
<input type="submit" value="На главную страницу">  
</form>

</body>
</html>