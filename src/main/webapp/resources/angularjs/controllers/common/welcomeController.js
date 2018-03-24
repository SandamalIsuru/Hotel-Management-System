var app = angular.module('myApp', []);
app.controller('welcomeController', function($scope, $filter) {
    $scope.firstName = "John";
    $scope.lastName = "Doe";
    $scope.fullName = function() {
        return $scope.firstName + " " + $scope.lastName;
    };
    $scope.availableRooms = ${availableRooms};
    $scope.occupiedRooms = ${occupiedRooms};
    $scopemaintenanceRooms = ${maintenanceRooms};
    $scopehousekeepingRooms = ${housekeepingRooms};
});