package lt.employees.rest.app.converter;

import lt.employees.rest.app.response.DepartmentResponse;
import lt.employees.service.dto.DepartmentDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Converter class for department response.
 */
public class DepartmentResponseConverter {

    public static DepartmentResponse convert(DepartmentDTO department) {
        DepartmentResponse result = new DepartmentResponse();
        result.setId(department.getId());
        result.setName(department.getName());
        result.setDescription(department.getDescription());
        if (department.getDirector() != null) {
            result.setDirector(EmployeeResponseConverter.convert(department.getDirector()));
        }
        result.getEmployees().addAll(EmployeeResponseConverter.convertToResponse(department.getEmployees()));

        return result;
    }

    public static List<DepartmentResponse> convert(List<DepartmentDTO> departments) {
        List<DepartmentResponse> result = new ArrayList<DepartmentResponse>();
        for (DepartmentDTO department : departments) {
            result.add(convert(department));
        }

        return result;
    }

    public static DepartmentDTO convert(DepartmentResponse department) {
        DepartmentDTO result = new DepartmentDTO();
        result.setId(department.getId());
        result.setName(department.getName());
        result.setDescription(department.getDescription());
        if (department.getDirector() != null) {
            result.setDirector(EmployeeResponseConverter.convert(department.getDirector()));
        }
        result.getEmployees().addAll(EmployeeResponseConverter.convertToDTO(department.getEmployees()));

        return result;
    }

}
