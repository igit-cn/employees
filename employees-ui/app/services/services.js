'use strict';

var services = angular.module('employeesApp.services', ['ngResource']);

var baseUrl = 'http://localhost\\:8080/employees/rest/api';

services.factory('EmployeesFactory', function ($resource) {
    return $resource(baseUrl + '/employees/:id');
});

services.factory('DepartmentsFactory', function ($resource) {
    return $resource(baseUrl + '/departments/:id');
});