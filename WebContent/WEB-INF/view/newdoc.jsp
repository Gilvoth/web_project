<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- <link rel="stylesheet" href="http://bootstraptema.ru/plugins/2015/bootstrap3/bootstrap.min.css" />
<script src="http://bootstraptema.ru/plugins/jquery/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="http://bootstraptema.ru/plugins/2015/b-v3-3-6/bootstrap.min.js"></script>
<script src="http://bootstraptema.ru/_sf/3/393.js"></script> -->

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Создание нового документа</title>
</head>
<body>
 <jsp:include page="_menu.jsp"></jsp:include>
 
<%--  
 <style>
   <%@include file='../../css/calendar_style.css' %>
</style> --%>

<style>
   <%@include file='../../css/styles.css' %>
</style>


<br>
<h3>Создание нового документа</h3>
<form method="POST" accept-charset="UTF-8" action="${pageContext.request.contextPath}/NewDocServlet"> <!-- enctype="multipart/form-data" -->
<input type="hidden" value="${user.id}" name="id" />

<table>
<tr>
<td><label>Тип документа</label> </td><td></td><td> <label>Рекомендуемая дата выполнения</label></td>
</tr>
<tr>
<td>
<!-- <input name="id_type2" value="id_type2" /><br> -->       
                 <select name = "id_type">
                 <c:forEach var="type_doc" items="${type_docs}">
                 
                 <option value="<c:out value="${type_doc.id}"/>"><c:out value="${type_doc.name}" /></option>
                 </c:forEach>
                 </select>
</td>
<td><pre>           </pre></td>
<td><input type="date" name="rec_date" value="" required>  </td>
</tr>
</table>

<!-- <div class="container">
<div class="row"> 
                            <div class="col-lg-4 col-lg-offset-4 well">
<div class="col-sm-4 col-sm-offset-4 well">
                            <h2 class="text-center">Календарь для INPUT</h2>
                             <br />
<div class="controls">
<input class="datepicker form-control" type="text"/>
</div>

</div>
</div>
</div>
<script>
$('.datepicker').datepicker({
weekStart:1,
color: 'red'
});
</script> -->

                 
 <br>
<label>Контрагент</label><br>
<!-- <input name="id_contractor2" value="" /><br><br>   -->      
                 <select name = "id_contractor">
                 <c:forEach var="contractor" items="${contractors}">
                 <option value="<c:out value="${contractor.id}"/>"><c:out value="${contractor.name}" /></option>
                 </c:forEach>
                 </select><br><br>


<label>Название</label><br>
<input name="name" value="${user.name}" required    placeholder="Введите название" /><br><br> <!-- required -->

<label>Комментарии к содержимому</label>
<!-- <input name="content" value="" placeholder="Комментарии к содержимому"/><br><br> -->
<p><textarea rows="5" cols="45" name="content"> </textarea></p>
<label>Автор</label><br>
<%-- <input name="creator" value="${id_creator}" readonly title="нельзя редактировать"/><br><br> --%>
<input name="creator" value="${id_creator}" type="hidden">
<input name="creator2" value="${loginedUser} ${loginedUserSecond}" readonly title="нельзя редактировать"> 
<br><br>

<label>Статус срочности</label><br>
<!-- <input name="id_urgency2" value="" /><br><br> -->
                 <select name = "id_urgency">
                 <c:forEach var="urgency" items="${urgencies}">
                 <option value="<c:out value="${urgency.id}"/>"><c:out value="${urgency.name}" /></option>
                 </c:forEach>
                 </select><br><br>
<!--
<label>Список отправивших</label><br>
<input type="checkbox" name="receiver_m" value="1"  />receiver_list 1
<input type="checkbox" name="receiver_m" value="2"  />receiver_list 2 <br>
<label>Список принявших</label><br>
<input type="checkbox" name="sender_m" value="1"  />sender_list 1
<input type="checkbox" name="sender_m" value="2"  />sender_list 2	 <br>
-->
	
<label>Текущий отдел</label><br>
<input name="current_dep" value="${id_department}" readonly title="нельзя редактировать" type="hidden"/>
<input name="current_dep2" value="${department.getName()}" readonly title="нельзя редактировать" /><br><br>

<!--         Select file to upload:
        <br />
        <input type="file" name="file"  />  -->


<input type="submit" class="btn btn-dark" value="Send" />
</form>

<%--     <form method="post" action="${pageContext.request.contextPath}/uploadToDB"
        enctype="multipart/form-data">
        
        Select file to upload:
        <br />
        <input type="file" name="file"  />
        <br />
        <input type="file" name="file" />
        <br />
        Description:
        <br />
        <input type="text" name="description" size="100" />
        <br />
        <br />
        <input type="submit" value="Upload" />
    </form> --%>
 
<br><br>


    

<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/EmployeeTaskServlet">
<input type="submit" class="btn btn-dark" value="Назад">  
</form>
<br>
<br>
<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/">
<input type="submit" class="btn btn-dark" value="На главную страницу">  
</form>  
</body>
</html>