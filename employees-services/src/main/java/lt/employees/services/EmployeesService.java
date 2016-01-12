package lt.employees.services;

import java.util.List;

import lt.employees.services.dto.EmployeeDTO;

public interface EmployeesService {
	
	List<EmployeeDTO> fetchEmployees();
	
	EmployeeDTO getEmployeeById(Integer id);
	
	void saveEmployee(EmployeeDTO employee);
	
	void deleteEmployee(Integer id);

}
