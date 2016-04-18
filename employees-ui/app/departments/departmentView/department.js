'use strict';

angular.module('employeesApp.departmentView', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  var templateUrl = 'departments/departmentView/department.html';
  var controllerName = 'departmentViewCtrl'

  $routeProvider.when('/departmentView/:id', {
    templateUrl: templateUrl,
    controller: controllerName
  }).when('/departmentView', {
    templateUrl: templateUrl,
    controller: controllerName
  });
}])

.controller('departmentViewCtrl', ['$scope', 'DepartmentsFactory', 'EmployeesFactory','$location', '$routeParams',
	function($scope, DepartmentsFactory, EmployeesFactory, $location, $routeParams) {
  $scope.employees = EmployeesFactory.query();

  if ($routeParams.id != undefined) {
    $scope.department = DepartmentsFactory.get({id: $routeParams.id})
  }

  $scope.saveDepartment = function() {
    console.log($scope.department);
  	DepartmentsFactory.save($scope.department, function() {
    	$location.path('/departmentsView');
    });
  }

  $scope.cancel = function() {
  	$location.path('/departmentsView');
  }
}]);