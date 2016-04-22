package lt.employees.service.converter;

import java.util.ArrayList;
import java.util.List;

import lt.employees.domain.entity.Employee;
import lt.employees.service.dto.EmployeeDTO;
import lt.employees.service.dto.NameInfoDTO;

/**
 * Converter class for Employee.
 */
public class EmployeeConverter {
	
	public static EmployeeDTO convert(Employee employee) {
		EmployeeDTO result = new EmployeeDTO();
		result.setId(employee.getId());
		result.setFirstName(employee.getFirstName());
		result.setLastName(employee.getLastName());
		if (employee.getAddress() != null) {
			result.setAddress(AddressConverter.convert(employee.getAddress()));
		}
		if (employee.getDepartment() != null) {
			result.setDepartment(DepartmentConverter.convertToNameInfo(employee.getDepartment()));
		}
		
		return result;
	}
	
	public static List<EmployeeDTO> convert(List<Employee> employees) {
		List<EmployeeDTO> result = new ArrayList<EmployeeDTO>();
		
		for (Employee employee : employees) {
			result.add(convert(employee));
		}
		
		return result;
	}
	
	public static Employee convert(EmployeeDTO employee) {
		Employee result = new Employee();
		result.setId(employee.getId());
		result.setFirstName(employee.getFirstName());
		result.setLastName(employee.getLastName());
        result.setAddress(AddressConverter.convert(employee.getAddress()));
		
		return result;
	}

}
