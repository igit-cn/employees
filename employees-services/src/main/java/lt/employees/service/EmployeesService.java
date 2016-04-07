package lt.employees.service;

import java.util.List;

import lt.employees.service.dto.EmployeeDTO;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface EmployeesService {
	
	List<EmployeeDTO> fetchEmployees();
	
	EmployeeDTO getEmployeeById(Integer id);
	
	void saveEmployee(EmployeeDTO employee);
	
	void deleteEmployee(Integer id);

}
