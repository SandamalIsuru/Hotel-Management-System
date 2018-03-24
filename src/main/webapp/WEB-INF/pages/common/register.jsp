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
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">

<title>Insert title here</title>

</head>
<body>
	<div class="container">
        <div class="card card-container">
            <p id="profile-name" class="profile-name-card"></p>
            <spring:url value="/register/registerCustomer" var="registerCustomerActionUrl" />
		    <form:form class="form-signin" method="post" modelAttribute="customerRegisterForm" action="${registerCustomerActionUrl}">
		    	<form:input path="guest.firstName" type="text" value="${userRegister.guest.firstName}" id="inputFirstName" class="form-control" placeholder="First Name" />
				<form:input path="guest.middleName" type="text" value="${userRegister.login.middleName}" id="inputMiddleName" class="form-control" placeholder="Middle Name" />
				<form:input path="guest.lastName" type="text" value="${userRegister.login.lastName}" id="inputLastName" class="form-control" placeholder="Last Name"/>
				<form:input path="guest.addressLine1" type="text" value="${userRegister.login.addressLine1}" id="inputAddressLine1" class="form-control" placeholder="Address Line 1" />
				<form:input path="guest.addressLine2" type="text" value="${userRegister.login.addressLine2}" id="inputAddressLine2" class="form-control" placeholder="Address Line 2"/>
				<form:input path="guest.city" type="text" value="${userRegister.guest.city}" id="inputCity" class="form-control" placeholder="City" />
				<form:input path="guest.state" type="text" value="${userRegister.guest.state}" id="inputState" class="form-control" placeholder="State" />
				<form:input path="guest.country" type="text" value="${userRegister.guest.country}" id="inputCountry" class="form-control" placeholder="Country"/>
				<form:radiobutton path="guest.gender" value="M"/> Male 
                <form:radiobutton path="guest.gender" value="F"/> Female 
				<form:input path="guest.dob" type="text" value="${userRegister.guest.dob}" id="inputDOB" class="form-control" placeholder="DOB" />
				<form:input path="guest.mobileNo" type="text" value="${userRegister.guest.mobileNo}" id="inputMobile" class="form-control" placeholder="Mobile Number" />
				
				<br>
				<button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" onclick="registerCustomer();">Add Customer</button>
			</form:form>
			<!-- <br>
			<label id="accountExsist">Already have an account?</label>
            <button class="btn btn-lg btn-primary btn-block btn-signup" type="submit">Sign In</button> -->
        </div><!-- /card-container -->
    </div><!-- /container -->
	
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script>
  $(document).ready(function() {
    $("#inputDOB").datepicker();
  });
  </script>
<script type="text/javascript">

/* function registerCustomer(){
	window.location = "../login/login.htm";
	 } */
</script>

</html>