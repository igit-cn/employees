package lt.employees.service.converter;

import java.util.ArrayList;
import java.util.List;

import lt.employees.domain.entity.Address;
import lt.employees.domain.entity.Employee;
import lt.employees.service.dto.AddressDTO;
import lt.employees.service.dto.EmployeeDTO;

public class EmployeeConverter {
	
	public static EmployeeDTO convert(Employee employee) {
        AddressDTO address = new AddressDTO();
        address.setId(employee.getAddress().getId());
        address.setCountry(employee.getAddress().getCountry());
        address.setCity(employee.getAddress().getCity());
        address.setAddress(employee.getAddress().getAddress());

		EmployeeDTO result = new EmployeeDTO();
		result.setId(employee.getId());
		result.setFirstName(employee.getFirstName());
		result.setLastName(employee.getLastName());
        result.setAddress(address);
		
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
        Address address = new Address();
        address.setId(employee.getAddress().getId());
        address.setCountry(employee.getAddress().getCountry());
        address.setCity(employee.getAddress().getCity());
        address.setAddress(employee.getAddress().getAddress());

		Employee result = new Employee();
		result.setId(employee.getId());
		result.setFirstName(employee.getFirstName());
		result.setLastName(employee.getLastName());
        result.setAddress(address);
		
		return result;
	}

}
