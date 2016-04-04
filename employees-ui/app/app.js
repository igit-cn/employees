'use strict';

// Declare app level module which depends on views, and components
angular.module('employeesApp', [
  'ngRoute',
  'employeesApp.services',
  'employeesApp.employeesView',
  'employeesApp.createEmployeeView',
  'employeesApp.editEmployeeView'
]).
config(['$routeProvider', function($routeProvider) {
  $routeProvider.otherwise({redirectTo: '/employeesView'});
}]);
