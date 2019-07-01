<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- <a style="color:green;"></a>    --> 

<style>
.hyper {
    background-color: gray;
    color: white;
    padding: 10px;
}
/* a {
    background-color: gray;
    color: white;
    padding: 10px;
}
 */
</style>

<a class="hyper" href="${pageContext.request.contextPath}/EmployeeTaskServlet">
  Создание документов |Employee Task
</a>
<!-- || -->
<a class="hyper" href="${pageContext.request.contextPath}/JurTaskServlet">
  Jur Task
</a>
<!-- || -->
<a class="hyper" href="${pageContext.request.contextPath}/AsupTaskServlet">
  ASUP Task
</a>
<!-- || -->
<a class="hyper" href="${pageContext.request.contextPath}/UserInfoServlet">
  Документы пользователя | User Info
</a>       
<!-- || -->
<a class="hyper" href="${pageContext.request.contextPath}/LoginPageServlet">
  Login
</a>
<!-- || -->
<a class="hyper" href="${pageContext.request.contextPath}/LogoutPageServlet">
  Logout
</a>
 
&nbsp;
<%-- <span style="color:red">[ ${loginedUser.userName} ]</span> --%>
<span style="color:green">[ ${loginedUser} ]</span>
<span style="color:green">[ ${loginedUserSecond} ]</span>
<%-- <span style="color:green">[ ${name} ]</span> --%>

