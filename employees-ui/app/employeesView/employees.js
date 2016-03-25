'use strict';

angular.module('employeesApp.employeesView', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/employeesView', {
    templateUrl: 'employeesView/employees.html',
    controller: 'employeesViewCtrl'
  });
}])

.controller('employeesView', [function() {

}]);