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
<a href='<c:url value="/UserInfoServlet" />' class="btn btn-dark" role="button" >Назад к списку документов </a> 

<h3>Редактирование документа</h3>

<br>



<c:if test="${empty doc.blob}">    
<form method="POST" accept-charset="UTF-8" action="${pageContext.request.contextPath}/UploadServlet?id=${doc.id}">
        Выберите изображение для загрузки:
        <br />
        <input type="file" name="filepath"  accept=".jpg, .png, .jpeg, .gif, .bmp, .tif, .tiff|image/*" />
<input type="submit" class="btn btn-dark" value="Загрузить изображение в документ">  
</form> 
</c:if>

<c:if test="${doc.blob!=null}">    
<form method="POST" accept-charset="UTF-8" action="${pageContext.request.contextPath}/ViewImageServlet?id=${doc.id}">
<input type="submit" class="btn btn-dark" value="Просмотр изображения документа">  
</form> 
</c:if>

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
<table>
<tr>
<td><label>ID</label> </td><td> <label>Дата создания</label></td>
</tr>
<tr>
<td><input value="${doc.id}" name="id" readonly title="нельзя редактировать" /></td>
<td><input value="${doc.date_cre}" name="date_cre" readonly title="нельзя редактировать" /></td>
</tr>
</table>
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
<input value="${doc.id_contractor}" name="id_contractor" readonly title="нельзя редактировать" />
<%--                         <select name = "id_contractor2">
                        <c:forEach var="contractor" items="${contractors}">
                            <option value="<c:out value="${contractor}" />"  ${doc.id_contractor == contractor ? 'selected' : ' '}  ><c:out value="${contractor}" /></option>
                            </c:forEach>
                        </select> --%>
                        <br>
<br>
<label>Название документа</label><br>
<input value="${doc.name}" name="name" /><br>
<input value="${doc.name}" name="name2" type = "hidden"/><br><br>
<label>Комментарии к документу</label><br>
<%-- <input value="${doc.content}" name="content"/> --%>
<p><textarea rows="5" cols="45" name="content" placeholder="Введите информацию">${doc.content}</textarea></p>
<p><textarea rows="5" cols="45" name="content2" style="display:none;" >${doc.content}</textarea></p>
<br>

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

<label>Рекомендуемая дата выполнения</label><br>
<input type="date" name="rec_date" value="${doc.rec_date}" />
<input name="rec_date2" value="${doc.rec_date}" type = "hidden"/><br><br>

<label>ТРУ</label><br>
<input name="doc_tru" value="${doc.tru}" type = "hidden"/>
                        <select name = "tru">
                        <c:forEach var="tru" items="${trues}">
                            <option value="${tru.name}" ${doc.tru == tru.name ? 'selected' : ' '}><c:out value="${tru.name}" /></option>
                        </c:forEach>                            
                        </select><br>
<label>Закон</label><br>
<input name="doc_law" value="${doc.law}" type = "hidden"/>
                        <select name = "law">
                        <c:forEach var="law" items="${laws}">
                            <option value="${law.name}" ${doc.law == law.name ? 'selected' : ' '}><c:out value="${law.name}" /></option>
                        </c:forEach>                            
                        </select><br>
<label>Подразделение</label><br>
<input name="doc_division" value="${doc.division}" type = "hidden" />
                        <select name = "division">
                        <c:forEach var="division" items="${divisions}">
                            <option value="${division.name}" ${doc.division == division.name ? 'selected' : ' '}><c:out value="${division.name}" /></option>
                        </c:forEach>                            
                        </select><br>
<label>Сумма</label><br>
<input name="price" value="${doc.price}" /><input name="price2" value="${doc.price}" type = "hidden"/><br><br>
<label>Факт проплаты</label><br>
<input name="paid" value="${doc.paid}" /><br><br>
<label>Источник финансирования</label><br>
<input name="ifo" value="${doc.ifo}" /><br><br>
<label>Доп. соглашение</label><br>
<input name="add_agr" value="${doc.add_agr}" /><input name="add_agr2" value="${doc.add_agr}" type = "hidden"/><br><br>
<label>Сумма по доп. соглашению</label><br>
<input name="price_add_agr" value="${doc.price_add_agr}" /><input name="price_add_agr2" value="${doc.price_add_agr}" type = "hidden"/><br><br>

    		

<label>Отдел</label><br>
<input name="dep" value="${doc.dep}" readonly title="нельзя редактировать"/><br><br>

<input type="submit" class="btn btn-dark" value="Send" />
</form>
<br>
<form method="POST" accept-charset="UTF-8" action="${pageContext.request.contextPath}/DocEndServlet?id=${doc.id}">
<input type="submit" class="btn btn-dark" value="Работа над документом завершена">  
</form>
<br>
<br>	
<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/UserInfoServlet">
<input type="submit" class="btn-sm btn-dark" value="Назад к документам">  
</form>

</body>
</html>