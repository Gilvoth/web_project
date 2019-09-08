<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
  
      <title>Страница авторизации</title>
   </head>
   <body>
 
      <jsp:include page="_menu.jsp"></jsp:include>   
 
   <div class="row justify-content-md-center">

     <h4>Страница авторизации </h4>
      <p style="color: red;">${errorString}</p>

  </div>  
  
 <div class="row justify-content-md-center"> <!-- делаем таблицу адаптивной -->

 <!-- set codepage input data -->
      <form method="POST" accept-charset="UTF-8" action="${pageContext.request.contextPath}/LoginPageServlet">
         <input type="hidden" name="redirectId" value="${param.redirectId}" />
         <table>
            <tr>
               <td>Имя пользователя</td>
               <td><input type="text" name="login" value= "${user.login}" /> </td>
            </tr>
            <tr>
               <td>Пароль</td>
               <td><input type="password" name="password" value= "${user.password}" /> </td>
            </tr>
          
            <tr>
               <td colspan ="2">
                  <input type="submit" class="btn btn-dark" value= "Войти" />
                  <button type="button" class="btn btn-dark" onclick="javascript:document.location.href='${pageContext.request.contextPath}/'"> Отмена </button> 
               </td>
            </tr>
            <tr>
               <td>
					<%-- <form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/RegistrationPageServlet"> --%>
					<!-- <input type="submit" class="btn btn-dark" value="Зарегистрироваться"> -->
					<button type="button" class="btn btn-dark" onclick="javascript:document.location.href='${pageContext.request.contextPath}/RegistrationPageServlet'"> Зарегистрироваться </button>  
					</form>
               </td>
            </tr>            
         </table>
      </form>


<br>
<br>
<br>

</div>

   </body>
</html>