'use strict';

var services = angular.module('services', ['ngResource']);

var baseUrl = 'http://localhost\\:8080/employees/rest/api';

services.factory('EmployeesFactory', function ($resource) {
    return $resource(baseUrl + '/employees/:id', {}, {
        queryNameInfo: {
            method: 'GET',
            url: baseUrl + '/employees/nameInfo',
            isArray: true
        }
    });
});

services.factory('DepartmentsFactory', function ($resource) {
    return $resource(baseUrl + '/departments/:id', {}, {
        queryNameInfo: {
            method: 'GET',
            url: baseUrl + '/departments/nameInfo',
            isArray: true
        }
    });
});