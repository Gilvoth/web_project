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

<c:set var="username" scope="session" value="${user.id}" />


<div class="container">  
	<div class="col-xl-1"></div>
	<div class="col-xl-10">

		<h3>Редактирование документа</h3>
		<br>
		
		<c:if test="${empty doc.blob}">    
		<form method="POST" accept-charset="UTF-8" action="${pageContext.request.contextPath}/UploadServlet?id=${doc.id}">
		        Выберите изображение для загрузки:
		        <br />
		        <input type="file" name="filepath"  accept=".jpg, .png, .jpeg, .gif, .bmp, .tif, .tiff|image/*" />
		<input type="submit" class="btn btn-dark" value="Загрузить изображение в документ" <c:if test="${doc.receiver_list[0]!=username}"> disabled </c:if> >  
		</form> 
		</c:if>
				
		
		<c:if test="${doc.blob!=null}">
		<div>
		<div class="row">    
			<script>
			function ViewDoc() {
			  var myWindow = window.open("${pageContext.request.contextPath}/ViewImageServlet?id=${doc.id}", "", "width=600,height=800");
			}
			</script>
		<button class="btn btn-dark" onclick="ViewDoc()">Просмотр изображения документа</button>

		<form method="POST" accept-charset="UTF-8" action="${pageContext.request.contextPath}/ScanImageServlet">
		<input type="submit" class="btn-sm btn-dark" value="Сканирование изображения документа">  
		</form>
<!-- 		<button class="btn btn-dark" onclick="ScanDoc()">Сканирование изображения документа</button>
			<script>
			function ScanDoc() {
			  var myWindow = window.open("${pageContext.request.contextPath}/ScanImageServlet", "", "width=600,height=800");
			}
			</script>	 -->			
		</div><br>
		
		<div class="row">
		<form method="POST" accept-charset="UTF-8" action="${pageContext.request.contextPath}/UploadServlet?id=${doc.id}">
		Выберите изображение для замены существующего:
		<br />
		<input type="file" name="filepath"  accept=".jpg, .png, .jpeg, .gif, .bmp, .tif, .tiff|image/*" />
		<input type="submit" class="btn-sm btn-secondary" value="Замена изображения в текущем документе" <c:if test="${doc.receiver_list[0]!=username}"> disabled </c:if> >  
		</form>
		</div>
		</div> 
		</c:if>
			
				
		<br>
		<br><br>
		<form method="POST" accept-charset="UTF-8" action="${pageContext.request.contextPath}/DocEditServlet">
		<div class="container">  
		<div class="row">
			<div class="col-md-4">
				<label>ID</label>  
				<br>
				<c:set var="id_doc" scope="session" value="${doc.id}" />
				<input value="${doc.id}" name="id" readonly title="нельзя редактировать" />
				<c:set var="id_doc" scope="session" value="${doc.id}" />
				<br><br>
				<label>Тип документа</label>
				<br>
				<input value="${doc.id_type_int}" name="id_type_int"  type = "hidden"/>
				<input value="${doc.id_type}" name="doc_id_type"  type = "hidden"/>
				<select name = "id_type">
				<c:forEach var="type_doc" items="${type_docs}">
				<option value="<c:out value="${type_doc}"/>"     ${doc.id_type == type_doc ? 'selected' : ' '} ><c:out value="${type_doc}" /></option>
				</c:forEach>
				</select>
				<br><br>
				<label>Контрагент</label><br>
				<input value="${doc.id_contractor}" name="id_contractor" readonly title="нельзя редактировать" />
				<%--                         <select name = "id_contractor2">
				<c:forEach var="contractor" items="${contractors}">
				<option value="<c:out value="${contractor}" />"  ${doc.id_contractor == contractor ? 'selected' : ' '}  ><c:out value="${contractor}" /></option>
				</c:forEach>
				</select> --%>
				
		
			</div>
			<div class="col-md-6 col-md-offset-4">
				<label>Дата создания</label>
				<br>
				<input value="${doc.date_cre}" name="date_cre" readonly title="нельзя редактировать" />
				<br><br>
				<label>Комментарии к документу (Содержание)</label><br>
				<%-- <input value="${doc.content}" name="content"/> --%>
				<p><textarea rows="5" cols="45" name="content" placeholder="Введите информацию">${doc.content}</textarea></p>
				<p><textarea rows="1" cols="45" name="content2" style="display:none;" >${doc.content}</textarea></p>
				<br>
								
			</div>
		</div>
		<div class="row">
		<div class="col-md-4">
				<label>Название документа</label><br>
				<input value="${doc.name}" name="name" />
				<input value="${doc.name}" name="name2" type = "hidden"/>
				<br><br>
				<label>Статус актуальности</label><br>
				<input name="id_urgency" value="${doc.id_urgency}" type = "hidden"/> <!-- поменять имя и принять параметр в метод пост -->
				<input name="doc_urgency" value="${doc.urgency}" type = "hidden" /> <!-- поменять имя и принять параметр в метод пост -->
				<select name = "urgency">
				<c:forEach var="urgency" items="${urgencies}">
				<option value="${urgency}" ${doc.urgency == urgency ? 'selected' : ' '}><c:out value="${urgency}" /></option>
				</c:forEach>                            
				</select>
				<br><br>
		</div>
		<div class="col-md-6 col-md-offset-4">
				<label>Автор (Ответственный)</label><br>
				<input name="creator_name" value="${doc.creator_name}&nbsp;${doc.creator_second}" />
				<br><br>
				<label>Рекомендуемая дата выполнения</label><br>
				<input name="rec_date" value="${doc.rec_date}" />
				<input name="rec_date2" value="${doc.rec_date}" type = "hidden"/>
				<br><br>
		</div>
		</div>
		
		<div class="row">
			<div class="col-md-4">
				<label>ТРУ</label><br>
				<input name="doc_tru" value="${doc.tru}" type = "hidden"/>
				<select name = "tru">
				<c:forEach var="tru" items="${trues}">
				<option value="${tru.name}" ${doc.tru == tru.name ? 'selected' : ' '}><c:out value="${tru.name}" /></option>
				</c:forEach>                            
				</select>
				<br><br>
				<label>Сумма</label><br>
				<input name="price" value="${doc.price}" pattern = "\d+(\.\d{2})?"/><input name="price2" value="${doc.price}" type = "hidden"/><br><br>
						
			</div>
			<div class="col-md-4">
				<label>Закон</label><br>
				<input name="doc_law" value="${doc.law}" type = "hidden"/>
				<select name = "law">
				<c:forEach var="law" items="${laws}">
				<option value="${law.name}" ${doc.law == law.name ? 'selected' : ' '}><c:out value="${law.name}" /></option>
				</c:forEach>                            
				</select>
				<br><br>
				<label>Факт проплаты</label><br>
				<%-- <input name="paid2" value="${doc.paid}" /> --%>
				<input type="checkbox" name="paid"  <c:if test="${doc.paid == true}"> checked </c:if>  />
				<br><br>
								
			</div>
			<div class="col-md-4">
				<label>Подразделение</label><br>
				<input name="doc_division" value="${doc.division}" type = "hidden" />
				<select name = "division">
				<c:forEach var="division" items="${divisions}">
				<option value="${division.name}" ${doc.division == division.name ? 'selected' : ' '}><c:out value="${division.name}" /></option>
				</c:forEach>                            
				</select>
				<br><br>
				<label>Источник финансирования</label><br>	
				<c:forEach var="ifo" items="${doc.ifo}">
				<input type="checkbox" name="ifo" value="${ifo}"  checked class="unvisible"/> 
				</c:forEach>


				
<c:forEach var="ifo_m" items="${ifoes}">
	<c:forEach var="ifo_str" items="${doc.ifo_str}">
		<c:set var="ifo_cur" scope="session" value="${ifo_str}" />	
		<c:if test="${ifo_m.name == ifo_cur }"> <c:set var="marker" scope="session" value="true" /> </c:if>
	</c:forEach>
	<input type="checkbox" name="ifo_m" value="${ifo_m.id}" <c:if test="${marker == true }"> checked </c:if>  /> ${ifo_m.name}												
	<c:remove var="marker" scope="session" />
</c:forEach>

<br>


				

			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<label>Доп. соглашение</label><br>
				<input name="add_agr" value="${doc.add_agr}" /><input name="add_agr2" value="${doc.add_agr}" type = "hidden"/><br><br>
				<label>Отдел</label><br>
				<input name="dep" value="${doc.dep}" readonly title="нельзя редактировать"/><br><br>
				
				<input type="submit" class="btn btn-dark" value="Сохранить"  <c:if test="${doc.receiver_list[0]!=username}"> disabled </c:if>  />
			</div>
			<div class="col-md-6 col-md-offset-4">	
				<label>Сумма по доп. соглашению</label><br>
				<input name="price_add_agr" value="${doc.price_add_agr}" /><input name="price_add_agr2" value="${doc.price_add_agr}" type = "hidden"/><br><br>				
			</div>
		</div>
		
		</div>
		</form>
		<br>
		<form method="POST" accept-charset="UTF-8" action="${pageContext.request.contextPath}/DocEndServlet?id=${doc.id}">
		<input type="submit" class="btn btn-dark" value="Работа над документом завершена" <c:if test="${doc.receiver_list[0]!=username}"> disabled </c:if> >  
		</form>
		<br>
		<br>
		
		<div class="row">
			<div class="col-md-4">			
				<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/UserInfoServlet">
				<input type="submit" class="btn-sm btn-dark" value="Назад к списку документов">  
				</form>
			</div>
			<div class="col-md-6 col-md-offset-4">	
<%-- 				<form method="GET" accept-charset="UTF-8" action="${pageContext.request.contextPath}/DocNotifyServlet?id_doc=${id_doc}">
				<input type="submit" class="btn-sm btn-dark" value="Просмотреть хронологию уведомлений">  
				</form> --%>
				<a href='<c:url value="/DocNotifyServlet?id_doc=${id_doc}" />'  class="btn-sm btn-dark" role="button">Просмотреть хронологию уведомлений</a>			
			</div>
		</div>
	</div>
</div> 
<br><br>
</body>
</html>