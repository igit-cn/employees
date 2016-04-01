'use strict';

angular.module('employeesApp.employeesView', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/employeesView', {
    templateUrl: 'employeesView/employees.html',
    controller: 'employeesViewCtrl'
  });
}])

.controller('employeesViewCtrl', ['$scope', 'EmployeesFactory', 'EmployeeFactory', function($scope, EmployeesFactory, EmployeeFactory) {
	$scope.deleteEmployee = function (employeeId) {
		EmployeeFactory.remove({id: employeeId});
		$scope.employees = EmployeesFactory.query();
	}

	$scope.employees = EmployeesFactory.query();
}]);