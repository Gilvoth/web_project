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
      	
<label>Содержание</label><br>
<p><textarea rows="15" cols="75" name="protocol" placeholder="Введите информацию">${doc.protocol}</textarea></p>

<br>
<form method="POST" accept-charset="UTF-8" action="${pageContext.request.contextPath}/ProtocolEditServlet?id=${doc.id}">
<input type="submit" class="btn btn-dark" value="Сохранить">  
</form>
<br>      	
      	
      	</div>
</div>
   </body>
</html>