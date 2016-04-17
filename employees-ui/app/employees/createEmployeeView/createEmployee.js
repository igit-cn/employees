'use strict';

angular.module('employeesApp.createEmployeeView', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/createEmployeeView', {
    templateUrl: 'employees/createEmployeeView/createEmployee.html',
    controller: 'createEmployeeViewCtrl'
  });
}])

.controller('createEmployeeViewCtrl', ['$scope', 'EmployeesFactory', '$location',
	function($scope, EmployeesFactory, $location) {
  $scope.createEmployee = function () {
    EmployeesFactory.save($scope.employee, function() {
    	$location.path('/employeesView');
    });
  }

  $scope.cancel = function() {
    	$location.path('/employeesView');
  }
}]);