<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Протокол разногласий</title>
   </head>
   <body>
    
      <jsp:include page="_menu.jsp"></jsp:include>
<div class="container">
		<div class="col-xl-1"></div>		
		<div class="col-xl-10">    
      	<h3>Протокол разногласий</h3>
      	


<br>

<%-- <form method="POST" accept-charset="UTF-8" action="${pageContext.request.contextPath}/ProtocolEditServlet">
<label>id документа</label><br>
<input name= "id_document" value="${id_document}" readonly title="нельзя редактировать"/><br><br>
<label>id протокола</label><br>
<input name= "id_protocol" value="${id_protocol}" readonly title="нельзя редактировать"/><br><br>
<label>Содержание</label><br>
<p><textarea rows="15" cols="75" name="protocol_content" placeholder="Введите информацию">${protocol_content}</textarea></p>
<input type="submit" class="btn btn-dark" value="Сохранить">  
</form>
<br>      --%> 	
<label>Список замечаний отделов</label><br>
<p><textarea rows="15" cols="75" name="" placeholder="Пустой протокол">
<c:forEach var="selected_protocol" items="${protocols}">${selected_protocol.getId()}       ${selected_protocol.getContent()}        ${selected_protocol.getId_user()} 
</c:forEach>
</textarea></p>
<c:forEach var="selected_protocol" items="${protocols}"> 
<input name= "selected_protocol" value="${selected_protocol.getId()}" readonly title="нельзя редактировать"/>
<input name= "selected_protocol" value="${selected_protocol.getContent()}" readonly title="нельзя редактировать"/>
<input name= "selected_protocol" value="${selected_protocol.getDate()}" readonly title="нельзя редактировать"/>
<input name= "selected_protocol" value="${selected_protocol.getId_user()}" readonly title="нельзя редактировать"/>
<br>
</c:forEach>
      	
      	
      	
      	</div>
</div>
   </body>
</html>