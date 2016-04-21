package lt.employees.domain.dao;

import java.util.List;

import lt.employees.domain.entity.Employee;

public interface EmployeesDAO {
	
	List<Employee> fetchEmployees();
	
	void save(Employee employee);
	
	Employee getEmployeeById(Long id);
	
	void deleteEmployee(Long id);

	List<Employee> fetchNameInfos();

}
