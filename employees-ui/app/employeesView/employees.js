'use strict';

angular.module('employeesApp.employeesView', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/employeesView', {
    templateUrl: 'employeesView/employees.html',
    controller: 'employeesViewCtrl'
  });
}])

.controller('employeesViewCtrl', ['$scope', 'EmployeesFactory', function($scope, EmployeesFactory) {
	$scope.employees = EmployeesFactory.query();

	$scope.deleteEmployee = function (employeeId) {
		EmployeesFactory.delete({id: employeeId}, function() {
			$scope.employees = EmployeesFactory.query();
		});
	}
}]);