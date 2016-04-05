package lt.employees.service;

import java.util.List;

import lt.employees.service.dto.EmployeeDTO;

public interface EmployeesService {
	
	List<EmployeeDTO> fetchEmployees();
	
	EmployeeDTO getEmployeeById(Integer id);
	
	void saveEmployee(EmployeeDTO employee);
	
	void deleteEmployee(Integer id);

}
