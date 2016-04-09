'use strict';

angular.module('employeesApp.createDepartmentView', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/createDepartmentView', {
    templateUrl: 'createDepartmentView/createDepartment.html',
    controller: 'createDepartmentViewCtrl'
  });
}])

.controller('createDepartmentViewCtrl', ['$scope', '$location', function($scope, $location) {
    $scope.cancel = function() {
        $location.path('/departmentsView');
    }
}]);