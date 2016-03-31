'use strict';

angular.module('employeesApp.createEmployeeView', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/createEmployeeView', {
    templateUrl: 'createEmployeeView/createEmployee.html',
    controller: 'createEmployeeViewCtrl'
  });
}])

.controller('createEmployeeViewCtrl', ['$scope', 'EmployeesFactory', function($scope, EmployeesFactory) {
  $scope.createEmployee = function () {
  	var newAddress = {
  		id: undefined,
  		country:  $scope.employee.address.country,
  		city:  $scope.employee.address.city,
  		address:  $scope.employee.address.address
  	}
  	var newEmployee = {
  		employeeDTO: {
  			id: undefined,
  			firstName: $scope.employee.firstName,
  			lastName: $scope.employee.lastName,
  			address: newAddress
  	}};

    EmployeesFactory.create(newEmployee);
  }
}]);