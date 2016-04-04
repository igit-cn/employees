'use strict';

angular.module('employeesApp.editEmployeeView', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/editEmployeeView/:id', {
    templateUrl: 'editEmployeeView/editEmployee.html',
    controller: 'editEmployeeViewCtrl'
  });
}])

.controller('editEmployeeViewCtrl', ['$scope', 'EmployeesFactory', '$location', '$routeParams',
	function($scope, EmployeesFactory, $location, $routeParams) {
  $scope.employee = EmployeesFactory.get({id: $routeParams.id})

  $scope.editEmployee = function() {
  	EmployeesFactory.save($scope.employee, function() {
    	$location.path('/employeesView');
    });
  }

  $scope.cancel = function() {
  	$location.path('/employeesView');
  }
}]);