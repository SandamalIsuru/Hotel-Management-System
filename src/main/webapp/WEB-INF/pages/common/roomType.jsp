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
<title>Room Type</title>

</head>
<body>
<div class="container">
        <div class="card card-container">
            <p id="profile-name" class="profile-name-card"></p>
            <spring:url value="/rooms/addRoomType" var="roomTypeActionUrl" />
		    <form:form class="form-signin" method="post" modelAttribute="roomTypeForm" action="${roomTypeActionUrl}">
				<form:input path="roomDescription" type="text" value="${roomType.roomDescription}" id="inputType" class="form-control" placeholder="Room Type"/>
				<br>
				<button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Add</button>
			</form:form>
        </div>
    </div>
	
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
<script type="text/javascript">

 function login(user_name, password) {
     $.ajax(
             {
             	url: "getLogin",
                 type: "POST",
                 data: {username: user_name, password: password},
                 success: function (response) {
                 	alert("Successfully Logged");
                 },
                 error: function (x, e) {
                     alert('There seems to be some problem while fetching records!');
                 }

             }
         );
     }
</script>

</html>