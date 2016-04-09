'use strict';

angular.module('employeesApp.departmentsView', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/departmentsView', {
    templateUrl: 'departmentsView/departments.html',
    controller: 'departmentsViewCtrl'
  });
}])

.controller('departmentsViewCtrl', ['$scope', '$location', function($scope, $location) {
    $scope.newDepartment = function() {
        $location.path('/createDepartmentView');
    }
}]);