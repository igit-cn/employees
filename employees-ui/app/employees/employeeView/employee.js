'use strict';

angular.module('employeesApp.employeeView', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  var templateUrl = 'employees/employeeView/employee.html';
  var controllerName = 'employeeViewCtrl';

  $routeProvider.when('/employeeView/:id', {
    templateUrl: templateUrl,
    controller: controllerName
  }).when('/employeeView', {
        templateUrl: templateUrl,
        controller: controllerName
      });
}])

.controller('employeeViewCtrl', ['$scope', 'EmployeesFactory', '$location', '$routeParams',
	function($scope, EmployeesFactory, $location, $routeParams) {
  if ($routeParams.id != undefined) {
    $scope.employee = EmployeesFactory.get({id: $routeParams.id})
  }

  $scope.saveEmployee = function() {
  	EmployeesFactory.save($scope.employee, function() {
    	$location.path('/employeesView');
    });
  }

  $scope.cancel = function() {
  	$location.path('/employeesView');
  }
}]);