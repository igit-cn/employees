'use strict';

angular.module('employeesApp.createDepartmentView', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/createDepartmentView', {
    templateUrl: 'departments/createDepartmentView/createDepartment.html',
    controller: 'createDepartmentViewCtrl'
  });
}])

.controller('createDepartmentViewCtrl', ['$scope', 'DepartmentsFactory', '$location',
        function($scope, DepartmentsFactory, $location) {
    $scope.createDepartment = function () {
        DepartmentsFactory.save($scope.department, function() {
        	$location.path('/departmentsView');
        });
      }

    $scope.cancel = function() {
        $location.path('/departmentsView');
    }
}]);