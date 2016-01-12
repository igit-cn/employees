package lt.employees.services.converters;

import java.util.ArrayList;
import java.util.List;

import lt.employees.domain.entity.Employee;
import lt.employees.services.dto.EmployeeDTO;

public class EmployeeConverter {
	
	public static EmployeeDTO convert(Employee employee) {
		EmployeeDTO result = new EmployeeDTO();
		result.setId(employee.getId());
		result.setFirstName(employee.getFirstName());
		result.setLastName(employee.getLastName());
		
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
		
		return result;
	}

}
