<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Учёт договоров</title>
   </head>
   <body>
    
      <jsp:include page="_menu.jsp"></jsp:include>
    <script src="https://unpkg.com/react@16/umd/react.development.js" crossorigin></script>
    <script src="https://unpkg.com/react-dom@16/umd/react-dom.development.js" crossorigin></script>
    <script crossorigin src="https://unpkg.com/react@16/umd/react.production.min.js"></script>
    <script crossorigin src="https://unpkg.com/react-dom@16/umd/react-dom.production.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/babel-standalone/6.25.0/babel.min.js"></script>
    
    <script src="https://unpkg.com/babel-standalone@6/babel.js"></script>      
<script type="text/babel">
    <%@include file="../../javascript/clock.js"%>
</script>      
<div class="container">
		<div class="col-xl-1"></div>		
		<div class="col-xl-10">    
      	<h3>Учёт договоров</h3>
      	<br/>
	      	<div id="clock">
	    	<!-- This element's contents will be replaced React component. -->
			</div>
      	</div>
</div>
   </body>
</html>