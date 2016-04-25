package lt.employees.rest.app.converter;

import lt.employees.domain.entity.Department;
import lt.employees.domain.entity.Employee;
import lt.employees.rest.app.response.DepartmentResponse;
import lt.employees.rest.app.response.EmployeeResponse;

/**
 * Converter class for department response.
 */
public class DepartmentResponseConverter {

    public static DepartmentResponse convert(Department department) {
        DepartmentResponse result = new DepartmentResponse();
        result.setId(department.getId());
        result.setName(department.getName());
        result.setDescription(department.getDescription());

        if (department.getDirector() != null) {
            result.setDirector(EmployeeResponseConverter.convertNameInfo(department.getDirector()));
        }

        for (Employee employee : department.getEmployees()) {
            result.addEmployee(EmployeeResponseConverter.convertNameInfo(employee));
        }

        return result;
    }

    public static Department convert(DepartmentResponse department) {
        Department result = new Department();
        result.setId(department.getId());
        result.setName(department.getName());
        result.setDescription(department.getDescription());

        if (department.getDirector() != null) {
            result.setDirector(EmployeeResponseConverter.convert(department.getDirector()));
        }

        for (EmployeeResponse employeeResponse : department.getEmployees()) {
            result.addEmployee(EmployeeResponseConverter.convert(employeeResponse));
        }

        return result;
    }

    public static DepartmentResponse convertNameInfo(Department department) {
        DepartmentResponse result = new DepartmentResponse();
        result.setId(department.getId());
        result.setName(department.getName());
        result.setDescription(department.getDescription());

        return result;
    }

}
