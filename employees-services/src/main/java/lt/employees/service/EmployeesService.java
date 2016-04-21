package lt.employees.service;

import java.util.List;

import lt.employees.service.dto.EmployeeDTO;
import lt.employees.service.dto.NameInfoDTO;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface EmployeesService {
	
	List<EmployeeDTO> fetchEmployees();
	
	EmployeeDTO getEmployeeById(Long id);
	
	void saveEmployee(EmployeeDTO employee);
	
	void deleteEmployee(Long id);

	List<EmployeeDTO> fetchEmployeesNameInfo();

}
