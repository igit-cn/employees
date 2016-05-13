'use strict';

var employeesViewCtrl = angular.module('employeesViewCtrl', []);

employeesViewCtrl.controller('employeesViewCtrl', ['$scope', 'EmployeesFactory', '$location', function ($scope, EmployeesFactory, $location) {
    $scope.employees = EmployeesFactory.queryNameInfo();

    $scope.editOrCreate = function (employeeId) {
        var path = '/employeeView/'.concat(employeeId ? employeeId : '');
        $location.path(path);
    }

    $scope.deleteEmployee = function (employeeId) {
        EmployeesFactory.delete({id: employeeId}, function () {
            $scope.employees = EmployeesFactory.query();
        });
    }
}]);