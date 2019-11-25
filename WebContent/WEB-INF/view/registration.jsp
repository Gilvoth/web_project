<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Страница регистрации</title>
   </head>
   <body>
 
 <jsp:include page="_menu.jsp"></jsp:include> 
 
 <div class="container">
<h3>Страница регистрации нового пользователя</h3>
		<div class="col-xl-1"></div>		
		<div class="col-xl-10">
			<p style="color: red;">${errorString}</p>      
			 <!-- set codepage input data -->
			      <form method="POST" accept-charset="UTF-8" action="${pageContext.request.contextPath}/RegistrationPageServlet">
			         <input type="hidden" name="redirectId" value="${param.redirectId}" />
			         <table border="1">
			            <tr>
			               <td>Имя пользователя</td>
			               <td><input type="text" name="name" value= "${user.name}" /> </td>
			            </tr>
			            <tr>
			               <td>Фамилия</td>
			               <td><input type="text" name="second" value= "${user.second}" /> </td>
			            </tr>
			            <tr>
			               <td>Логин пользователя</td>
			               <td><input type="text" name="login" value= "${user.login}" /> </td>
			            </tr>
			            <tr>
			               <td>Пароль</td>
			               <td><input type="password" name="pass" value= "${user.pass}" /> </td>
			            </tr>
			            <tr>
			               <td>Отдел</td>
			               <td><%-- <input type="text" name="id_department2" value= "${user.id_department}" /> --%> 
		                 <select name = "id_department">
		                 <c:forEach var="department" items="${departments}">
		                 <option value="<c:out value="${department.id}"/>"><c:out value="${department.name}" /></option>
		                 </c:forEach>
		                 </select>			               
			               </td>
			            </tr>          
			                  
			            <tr>
			               <td colspan ="2">
			                  <input type="submit" class="btn-sm btn-dark" value= "Зарегистрировать" />
			
<%-- <button type="button" class="btn-sm btn-dark" role ="button" onclick="javascript:document.location.href='${pageContext.request.contextPath}/LoginPageServlet"> Отмена </button> --%> 
			               </td>
			            </tr>
			         </table>
			      </form>
			                  <form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/LoginPageServlet">
								<input type="submit" class="btn-sm btn-dark" value="Назад">  
							  </form>		
		</div>       
 </div> 
<br>
<br>
<br>

   </body>
</html>