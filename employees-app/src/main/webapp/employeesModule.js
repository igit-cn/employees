var employeesApp = angular.module('employeesApp', []);

employeesApp.value('restURL', "http://localhost:8080/employees/rest/api");

employeesApp.factory('employeesREST', function($q, $http, restURL) {
    return {
        getEmployees: function() {
            return $http.get(restURL + '/employees').then(
                function(response) {
                    return $q.resolve(response.data.employeesResponse.employees);
                },
                function(response) {
                    return $q.reject(response.status + " " + response.data.error);
                }
            );
        },
        saveEmployee: function(employee) {
            function EmployeeSaveRequest(employeeDTO) {
                this.employeeDTO = employeeDTO;
            }
            var request = new EmployeeSaveRequest(employee);

            return $http.post(restURL + '/employees/save', request).then(
                function(response) {
                    return $q.resolve(response.data);
                },
                function(response) {
                    return $q.reject(response.status + " " + response.data.error);
                }
            );
        },
        deleteEmployee: function(id) {
            return $http.delete(restURL + '/employees/remove/' + id).then(
                function(response) {
                    return $q.resolve(response.data);
                },
                function(response) {
                    return $q.reject(response.status + " " + response.data.error);
                }
            );
        }
    }
});

employeesApp.factory('employees', function() {
    var employees = {};

    employees.list = [];

    employees.setEmployees = function(data) {
        employees.list.length = 0;

        if( Object.prototype.toString.call(data) == '[object Array]') {
            for (var i in data) {
                employees.list.push(data[i]);
            }
        } else if (typeof data !== 'undefined') {
            employees.list.push(data);
        }
    }

    return employees;
});

employeesApp.factory('employee', function() {
    var employee = {};

    employee.current = {firstName: undefined, lastName: undefined, id: undefined};

    /*employee.setEmployee = function(data) {
        employee.current = data;
        console.log(employee.current);
    }*/

    return employee;
});
