package lt.employees.service;

import java.util.List;

import lt.employees.domain.entity.Employee;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface EmployeesService {
	
	List<Employee> fetchEmployees();
	
	Employee getEmployeeById(Long id);
	
	void saveEmployee(Employee employee);
	
	void deleteEmployee(Long id);

}
