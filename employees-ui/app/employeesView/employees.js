'use strict';

angular.module('employeesApp.employeesView', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/employeesView', {
    templateUrl: 'employeesView/employees.html',
    controller: 'employeesViewCtrl'
  });
}])

.controller('employeesViewCtrl', ['$scope', 'EmployeesFactory', function($scope, EmployeesFactory) {
	EmployeesFactory.fetch().$promise.then(
		function(result) {
			$scope.employees = result.employees;
		},
		function(error) {
			$scope.notice = error;
		}
	)
}]);