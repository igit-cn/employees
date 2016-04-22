package lt.employees.service.converter;

import java.util.ArrayList;
import java.util.List;

import lt.employees.domain.entity.Department;
import lt.employees.service.dto.DepartmentDTO;

/**
 * Converter class for Department.
 */
public class DepartmentConverter {

    public static DepartmentDTO convert(Department department) {
        DepartmentDTO result = new DepartmentDTO();
        result.setId(department.getId());
        result.setName(department.getName());
        result.setDescription(department.getDescription());
        if (department.getDirector() != null) {
            result.setDirector(EmployeeConverter.convert(department.getDirector()));
        }
        result.getEmployees().addAll(EmployeeConverter.convert(department.getEmployees()));

        return result;
    }

    public static List<DepartmentDTO> convert(List<Department> departments) {
        List<DepartmentDTO> result = new ArrayList<DepartmentDTO>();

        for (Department department : departments) {
            result.add(convert(department));
        }

        return result;
    }

    public static Department convert(DepartmentDTO department) {
        Department result = new Department();
        result.setId(department.getId());
        result.setName(department.getName());
        result.setDescription(department.getDescription());

        return result;
    }

    public static DepartmentDTO convertToNameInfo(Department department) {
        DepartmentDTO result = new DepartmentDTO();
        result.setName(department.getName());
        result.setDescription(department.getDescription());

        return result;
    }

}
