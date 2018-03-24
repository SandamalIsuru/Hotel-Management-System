<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="../header.jsp"></jsp:include>
<link rel='stylesheet' href='../resources/css/loginStyle.css'>
<title>Insert title here</title>

</head>
<body>
<div class="container">
        <div class="card card-container">
            <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
            <p id="profile-name" class="profile-name-card"></p>
            <spring:url value="/register/registerUser" var="registerUserActionUrl" />
		    <form:form class="form-signin" method="post" modelAttribute="userRegisterForm" action="${registerUserActionUrl}">
		    	<form:input path="user.userName" type="text" value="${userRegister.user.userName}" id="inputName" class="form-control" placeholder="Name" />
				<form:input path="user.email" type="email" value="${userRegister.user.email}" id="inputEmail" class="form-control" placeholder="Email"/>
				<form:input path="login.username" type="text" value="${userRegister.login.username}" id="inputEmail" class="form-control" placeholder="Username" />
				<form:input path="login.password" type="password" value="${userRegister.login.password}" id="inputPassword" class="form-control" placeholder="Password"/>
				<label class="radio-inline"><input type="radio" name="optradio"> Male</label>
				<label class="radio-inline"><input type="radio" name="optradio"> Female</label>
				<br>
				<button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Create Account</button>
			</form:form>
			<br>
			<label id="accountExsist">Already have an account?</label>
            <button class="btn btn-lg btn-primary btn-block btn-signup" type="submit" onclick="goToSignIn();">Sign In</button>
        </div><!-- /card-container -->
    </div><!-- /container -->
	
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
<script type="text/javascript">
function goToSignIn(){
	window.location = "../login/login.htm";
	 }
// function login(user_name, password) {
//     $.ajax(
//             {
//             	url: "getLogin",
//                 type: "POST",
//                 data: {username: user_name, password: password},
//                 success: function (response) {
//                 	alert("Successfully Logged");
//                 },
//                 error: function (x, e) {
//                     alert('There seems to be some problem while fetching records!');
//                 }

//             }
//         );
//     }
</script>

</html>