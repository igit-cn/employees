'use strict';

// Declare app level module which depends on views, and components
var employeesApp = angular.module('employeesApp', [
    'ngRoute',

    'employeesApp.services',
    'employeesViewCtrl',
    'employeeViewCtrl',
    'departmentsViewCtrl',
    'departmentViewCtrl'
]);

employeesApp.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/employeesView', {
        templateUrl: 'employees/employeesView/employees.html',
        controller: 'employeesViewCtrl'
    }).when('/employeeView', {
        templateUrl: 'employees/employeeView/employee.html',
        controller: 'employeeViewCtrl'
    }).when('/employeeView/:id', {
        templateUrl: 'employees/employeeView/employee.html',
        controller: 'employeeViewCtrl'
    }).when('/departmentsView', {
        templateUrl: 'departments/departmentsView/departments.html',
        controller: 'departmentsViewCtrl'
    }).when('/departmentView', {
        templateUrl: 'departments/departmentView/department.html',
        controller: 'departmentViewCtrl'
    }).when('/departmentView/:id', {
        templateUrl: 'departments/departmentView/department.html',
        controller: 'departmentViewCtrl'
    }).otherwise({
        redirectTo: '/employeesView'
    })
}]);
