<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="../header.jsp"></jsp:include>
<link rel='stylesheet' href='../resources/css/loginStyle.css'>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../resources/css/welcomePage.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/css/bootstrap-select.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/js/bootstrap-select.min.js"></script>

<!-- (Optional) Latest compiled and minified JavaScript translation files -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/js/i18n/defaults-*.min.js"></script>

<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/ng-grid/2.0.11/ng-grid.min.js"></script> </head>


<title>Room detail</title>

</head>
<body>
	<div class="container" ng-app="myApps" ng-controller="roomDetailController">
        <div class="card card-container">
            <p id="profile-name" class="profile-name-card"></p>
            <spring:url value="/rooms/addRoomDetail" var="roomDetailActionUrl" />
		    <form:form class="form-signin" method="post" modelAttribute="roomDetailForm" action="${roomDetailActionUrl}">
                <form:select path = "roomType" class="selectpicker" data-live-search="true" onchange="changeHiddenRoomTypeDropDownValue(this)" >
                    <form:option value = "-1">Select Room Type</form:option>
                    <form:option value = "{{roomType}}" ng-repeat="roomType in allRoomTypes">{{roomType.roomDescription}}</form:option>
                </form:select>
                <input type="hidden" name="hiddenRoomTypeDropDown" id="hiddenRoomTypeDropDown" value="" />
                <br>
                <form:select path = "roomCategory" class="selectpicker" data-live-search="true" onchange="changeHiddenRoomCategoryDropDownValue(this)">
                    <form:option value = "-1">Select Room Category</form:option>
                    <form:option value = "{{roomCategory}}" ng-repeat="roomCategory in allRoomCategories">{{roomCategory.categoryName}}</form:option>
                </form:select> 
                <input type="hidden" name="hiddenRoomCategoryDropDown" id="hiddenRoomCategoryDropDown" value="" />
                <br>
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
		        <form:input path="" type="text" value="${roomDetail.perDayCharge}" id="inputPerDayCharge" class="form-control" placeholder="Day Charge" />
				
				<br>
				<button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Add Room</button>
			</form:form>
        </div>
    </div>
	
	<jsp:include page="../footer.jsp"></jsp:include>
	<script type="text/javascript">
	function changeHiddenRoomTypeDropDownValue (roomTypeDropDown)
	{
	   document.getElementById("hiddenRoomTypeDropDown").value = roomTypeDropDown.value; 
	}
	function changeHiddenRoomCategoryDropDownValue (roomCategoryDropDown)
	{
	   document.getElementById("hiddenRoomCategoryDropDown").value = roomCategoryDropDown.value; 
	}
	</script>
<script>
var app = angular.module('myApps', []);
app.controller('roomDetailController', function($scope, $filter) {
    $scope.allRoomTypes = ${allRoomTypes};
    $scope.allRoomCategories = ${allRoomCategories};
});
</script>
</body>
</html>