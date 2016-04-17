'use strict';

angular.module('employeesApp.departmentsView', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/departmentsView', {
    templateUrl: 'departments/departmentsView/departments.html',
    controller: 'departmentsViewCtrl'
  });
}])

.controller('departmentsViewCtrl', ['$scope', 'DepartmentsFactory', '$location',
        function($scope, DepartmentsFactory, $location) {
    $scope.departments = DepartmentsFactory.query();

    $scope.newDepartment = function() {
        $location.path('/createDepartmentView');
    }

    $scope.editDepartment = function(departmentId) {
    	$location.path('/editDepartmentView/' + departmentId);
    }

    $scope.deleteDepartment = function(departmentId) {
    		DepartmentsFactory.delete({id: departmentId}, function() {
    			$scope.departments = DepartmentsFactory.query();
    		});
    	}
}]);