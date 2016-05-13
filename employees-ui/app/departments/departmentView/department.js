'use strict';

var departmentViewCtrl = angular.module('departmentViewCtrl', ['ngRoute']);

departmentViewCtrl.controller('departmentViewCtrl', ['$scope', 'DepartmentsFactory', 'EmployeesFactory', '$location', '$routeParams',
    function ($scope, DepartmentsFactory, EmployeesFactory, $location, $routeParams) {
        $scope.employees = EmployeesFactory.queryNameInfo();

        if ($routeParams.id != undefined) {
            $scope.department = DepartmentsFactory.get({id: $routeParams.id})
        }

        $scope.saveDepartment = function () {
            DepartmentsFactory.save($scope.department, function () {
                $location.path('/departmentsView');
            });
        }

        $scope.cancel = function () {
            $location.path('/departmentsView');
        }
    }]);