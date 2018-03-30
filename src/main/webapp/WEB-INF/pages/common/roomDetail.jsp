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

<title>Room detail</title>

</head>
<body>
	<div class="container">
        <div class="card card-container">
            <p id="profile-name" class="profile-name-card"></p>
            <spring:url value="/rooms/addRoomDetail" var="roomDetailActionUrl" />
		    <form:form class="form-signin" method="post" modelAttribute="roomDetailForm" action="${roomDetailActionUrl}">
	            <form:input path="roomFloor" type="text" value="${roomDetail.roomFloor}" id="inputRoomFloor" class="form-control" placeholder="Floor No"/>
                <br>
                <form:checkbox path="" name="isAilability" value="true" /> Is Available
                <br>
                <br> 
                <form:checkbox path="" name="isRepairing" value="true" /> Is Repairing
                <br>
                <br>
                <form:checkbox path="" name="isHousekeeping" value="true" /> Is Housekeeping 
                <br>
                <br>
		        <form:input path="perDayCharge" type="text" value="${roomDetail.perDayCharge}" id="inputPerDayCharge" class="form-control" placeholder="Day Charge" />
				
				<br>
				<button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Add Room</button>
			</form:form>
        </div>
    </div>
	
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>