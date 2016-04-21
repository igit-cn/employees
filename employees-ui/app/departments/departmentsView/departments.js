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
    $scope.departments = DepartmentsFactory.queryNameInfo();

    $scope.editOrCreate = function(departmentId) {
        var path = '/departmentView/'.concat(departmentId ? departmentId : '');
        $location.path(path);
    }

    $scope.deleteDepartment = function(departmentId) {
        DepartmentsFactory.delete({id: departmentId}, function() {
    	    $scope.departments = DepartmentsFactory.query();
    	});
    }
}]);