'use strict';

var employeeViewCtrl = angular.module('employeeViewCtrl', ['ngRoute']);

employeeViewCtrl.controller('employeeViewCtrl', ['$scope', 'EmployeesFactory', '$location', '$routeParams',
    function ($scope, EmployeesFactory, $location, $routeParams) {
        if ($routeParams.id != undefined) {
            $scope.employee = EmployeesFactory.get({id: $routeParams.id})
        }

        $scope.saveEmployee = function () {
            EmployeesFactory.save($scope.employee, function () {
                $location.path('/employeesView');
            });
        }

        $scope.cancel = function () {
            $location.path('/employeesView');
        }
    }]);