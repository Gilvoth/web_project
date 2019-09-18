<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <style>
   <%@include file='../../css/styles.css' %>
</style>
  
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<!--   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"> -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
  <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">

<nav class="navbar navbar-expand-sm bg-dark navbar-dark ">
  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="${pageContext.request.contextPath}/EmployeeTaskServlet">Создание документов</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="${pageContext.request.contextPath}/JurTaskServlet">Документы отдела</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="${pageContext.request.contextPath}/AsupTaskServlet">Администрирование</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="${pageContext.request.contextPath}/UserInfoServlet">Документы пользователя</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="${pageContext.request.contextPath}/LoginPageServlet">Войти</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="${pageContext.request.contextPath}/LogoutPageServlet">Выйти</a>
    </li>        
  </ul>
</nav> 
&nbsp;
Вы зашли как: 
<span style="color:green">[ ${loginedUser} ]</span>
<span style="color:green">[ ${loginedUserSecond} ]</span>
<span style="color:green">[ ${id_department} ]</span>


