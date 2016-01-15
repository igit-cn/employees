employeesApp.controller('employeesFetchCtrl', function($scope, employeesREST, employees, employee) {
    $scope.employees = employees.list;

    employeesREST.getEmployees().then(
        function(result) {
            employees.setEmployees(result);
        }, function(error) {
            $scope.notice = error;
        }
    );

    $scope.editEmployee = function(employeeToEdit) {
        employee.current = employeeToEdit;
    }

    $scope.deleteEmployee = function(employee) {
        employeesREST.deleteEmployee(employee.id).then(
            function(data) {
                employeesREST.getEmployees().then(
                    function(result) {
                        employees.setEmployees(result);
                    }, function(error) {
                        $scope.notice = error;
                    }
                );
            },
            function(error) {
                $scope.notice = error;
            }
        );
    }
});

employeesApp.controller('employeeEditCtrl', function($scope, employee, employees, employeesREST) {
    $scope.employee = employee;

    $scope.createNewEmployee = function() {
        employee.current = {name: undefined, surname: undefined, id: undefined};
    }

    $scope.saveEmployee = function() {
        employeesREST.saveEmployee($scope.employee.current).then(
            function(data) {
                employee.current = {id: undefined, firsName: undefined, lastName: undefined, address: {id: undefined, country: undefined, city: undefined, address: undefined}};

                employeesREST.getEmployees().then(
                    function(result) {
                        $scope.employeeForm.$setPristine();
                        employees.setEmployees(result);
                    }, function(error) {
                        $scope.notice = error;
                    }
                );
            },
            function(error) {
                $scope.notice = error;
            }
        );
    }
});
