'use strict';

angular.module('employeesApp.editDepartmentView', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/editDepartmentView/:id', {
    templateUrl: 'departments/editDepartmentView/editDepartment.html',
    controller: 'editDepartmentViewCtrl'
  });
}])

.controller('editDepartmentViewCtrl', ['$scope', 'DepartmentsFactory', '$location', '$routeParams',
	function($scope, DepartmentsFactory, $location, $routeParams) {
  $scope.department = DepartmentsFactory.get({id: $routeParams.id})

  $scope.editDepartment = function() {
  	DepartmentsFactory.save($scope.department, function() {
    	$location.path('/departmentsView');
    });
  }

  $scope.cancel = function() {
  	$location.path('/departmentsView');
  }
}]);