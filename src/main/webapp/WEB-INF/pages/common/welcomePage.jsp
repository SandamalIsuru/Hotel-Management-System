<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../resources/css/welcomePage.css">
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/ng-grid/2.0.11/ng-grid.min.js"></script> </head>
<body>
	<div class="row">
		<div class="col-md-12" id="header">
			<h1>Hotel Management System</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12" id="hotelDetailArea">
			<h1>Hotel Management System</h1>
		</div>
	</div>
	<div class="container-fluid contentBody" ng-app="myApp" ng-controller="welcomeController">
	    <div class="row">
	        <div class="col-md-3 roomsinfo">
		        <div class="row roomsinfotag">
		        	<h5>Rooms Information</h5>
		        </div>
		        <div class="roomstatus">
		        	<div class="row available" id="av">
		        		<h6>Available: {{availableRooms}}</h6>
		        	</div>
		        	<div class="row occupied">
		        		<h6>Occupied: {{occupiedRooms}}</h6>
		        	</div>
		        	<div class="row maintenance">
		        		<h6>Maintenance: {{maintenanceRooms}}</h6>
		        	</div>
		        	<div class="row housekeeping">
		        		<h6>Housekeeping: {{housekeepingRooms}}</h6>
		        	</div>
		        </div>
	        </div>
	        <div class="col-md-9 maingrid">
		        <div class="row mainactivity">
		        	<div class="col-md-2">
			        	<strong>Advanced Booking:</strong>
			        </div>
			    </div>
		        <div class="row filterArea">
			        <div class="col-md-2">
			        	<h5>Room Type: </h5>
			        </div>
			        <div class="col-md-4">
			        	<div class="dropdown">
						  <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Select Room Type
						  <span class="caret"></span></button>
						  <ul class="dropdown-menu">
						    <li><a href="#">HTML</a></li>
						    <li><a href="#">CSS</a></li>
						    <li><a href="#">JavaScript</a></li>
						  </ul>
						</div>
			        </div>
		        </div>
				<div class="row">
				  <div ng-repeat="room in allRooms" ng-switch on="room.isAvailable">
				     <div class="clearfix" ng-if="$index % 3 == 0"></div>
				     <div class="col-sm-4 gridStyle bookingDetailsGrid" ng-switch-when="true">
					    <table class="table table-striped">
					      <thead>
					        <tr>
						      <div id="" ng-style="setColorAvailableRoom()">
						        <h3>{{room.roomNo}}</h3>
						      </div>
					        </tr>
						  </thead>
						  <tfoot>
						    <tr id="" ng-style="setColorAvailableRoom()">
						      <td></td>
						      <td></td>
						    </tr>
						  </tfoot>
						  <tbody>
						      <tr>
								 <td>{{room.roomType.roomDescription}}</td>
								 <td>{{room.roomCategory.categoryName}}</td>
							  </tr>
							  <tr>
								 <td>{{room.roomType.roomDescription}}</td>
								 <td>{{room.roomCategory.categoryName}}</td>
							  </tr>
						  </tbody>
					    </table>
					 </div>
					 <div class="col-sm-4 gridStyle bookingDetailsGrid" ng-switch-when="false">
					    <table class="table table-striped">
					      <thead>
					        <tr>
						      <div id="" ng-style="setColorOccupiedRoom()">
						        <h3>{{room.roomNo}}</h3>
						      </div>
					        </tr>
						  </thead>
						  <tfoot>
						    <tr id="" ng-style="setColorOccupiedRoom()">
						      <td></td>
						      <td></td>
						    </tr>
						  </tfoot>
						  <tbody>
						      <tr>
								 <td>{{room.roomType.roomDescription}}</td>
								 <td>{{room.roomCategory.categoryName}}</td>
							  </tr>
							  <tr>
								 <td>{{room.roomType.roomDescription}}</td>
								 <td>{{room.roomCategory.categoryName}}</td>
							  </tr>
						  </tbody>
					    </table>
					 </div>
				  </div>
				</div>
	        </div>
	    </div>
	</div>
<script>
var app = angular.module('myApp', []);
app.controller('welcomeController', function($scope, $filter) {
    $scope.availableRooms = ${availableRooms};
    $scope.occupiedRooms = ${occupiedRooms};
    $scope.maintenanceRooms = ${maintenanceRooms};
    $scope.housekeepingRooms = ${housekeepingRooms};
    $scope.allReservations = ${allReservations};
    $scope.allRooms = ${allRooms};
    $scope.setColorAvailableRoom = function() {
        return {
        'background-color': '#3de445',
    	'height': '30px',
    	'border-top-left-radius': '25px',
    	'border-top-right-radius': '25px'}
    };
    $scope.setColorOccupiedRoom = function() {
        return {
        'background-color': '#ff0000',
    	'height': '30px',
    	'border-top-left-radius': '25px',
    	'border-top-right-radius': '25px'}
    };
    $scope.setColorMaintenanceRoom = function() {
        return {
        'background-color': '#ffff00',
    	'height': '30px',
    	'border-top-left-radius': '25px',
    	'border-top-right-radius': '25px'}
    };
    $scope.setColorHousekeepingRoom = function() {
        return {
        'background-color': '#3ae9e0',
    	'height': '30px',
    	'border-top-left-radius': '25px',
    	'border-top-right-radius': '25px'}
    };
});
</script>
<%-- <jsp:include page="../footer.jsp"></jsp:include> --%>
</body>
</html>