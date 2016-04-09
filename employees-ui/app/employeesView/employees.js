'use strict';

angular.module('employeesApp.employeesView', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/employeesView', {
    templateUrl: 'employeesView/employees.html',
    controller: 'employeesViewCtrl'
  });
}])

.controller('employeesViewCtrl', ['$scope', 'EmployeesFactory', '$location', function($scope, EmployeesFactory, $location) {
	$scope.employees = EmployeesFactory.query();

	$scope.editEmployee = function(employeeId) {
		$location.path('/editEmployeeView/' + employeeId);
	}

	$scope.newEmployee = function() {
	    $location.path('/createEmployeeView');
	}

	$scope.deleteEmployee = function(employeeId) {
		EmployeesFactory.delete({id: employeeId}, function() {
			$scope.employees = EmployeesFactory.query();
		});
	}
}]);