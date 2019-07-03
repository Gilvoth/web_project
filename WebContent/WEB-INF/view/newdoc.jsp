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
<br>
<h3>Создание нового документа</h3>
<form method="POST" accept-charset="UTF-8" action="${pageContext.request.contextPath}/NewDocServlet"> <!-- enctype="multipart/form-data" -->
<input type="hidden" value="${user.id}" name="id" />
<label>Тип документа(цифра)</label><br>
<input name="id_type" value="id_type" /><br><br>        
<label>Контрагент(цифра)</label><br>
<input name="id_contractor" value="" /><br><br>        

<label>Название</label><br>
<input name="name" value="${user.name}" /><br><br>

<label>Содержимое описание</label><br>
<input name="content" value="" /><br><br>
<label>Автор</label><br>
<input name="creator" value="" /><br><br>
<label>Статус срочности</label><br>
<input name="id_urgency" value="" /><br><br>
<label>Список отправивших</label><br>
<input type="checkbox" name="receiver_m" value="1"  />receiver_list 1
<input type="checkbox" name="receiver_m" value="2"  />receiver_list 2
<label>Список принявших</label><br>
<input type="checkbox" name="sender_m" value="1"  />sender_list 1
<input type="checkbox" name="sender_m" value="2"  />sender_list 2			
<label>Текущий отдел</label><br>
<input name="current_dep" value="1" /><br><br>

<!--         Select file to upload:
        <br />
        <input type="file" name="file"  />  -->


<input type="submit" value="Send" />
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