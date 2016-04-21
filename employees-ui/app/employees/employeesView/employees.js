'use strict';

angular.module('employeesApp.employeesView', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/employeesView', {
    templateUrl: 'employees/employeesView/employees.html',
    controller: 'employeesViewCtrl'
  });
}])

.controller('employeesViewCtrl', ['$scope', 'EmployeesFactory', '$location', function($scope, EmployeesFactory, $location) {
	$scope.employees = EmployeesFactory.queryNameInfo();

    $scope.editOrCreate = function(employeeId) {
        var path = '/employeeView/'.concat(employeeId ? employeeId : '');
        $location.path(path);
    }

	$scope.deleteEmployee = function(employeeId) {
		EmployeesFactory.delete({id: employeeId}, function() {
			$scope.employees = EmployeesFactory.query();
		});
	}
}]);