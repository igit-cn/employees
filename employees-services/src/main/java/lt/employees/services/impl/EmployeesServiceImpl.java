package lt.employees.services.impl;

import java.util.List;

import javax.ejb.EJB;

import lt.employees.domain.dao.EmployeesDAO;
import lt.employees.domain.entity.Employee;
import lt.employees.services.EmployeesService;
import lt.employees.services.converters.EmployeeConverter;
import lt.employees.services.dto.EmployeeDTO;

public class EmployeesServiceImpl implements EmployeesService {
	
	@EJB
	private EmployeesDAO employeesDAO;

	public List<EmployeeDTO> fetchEmployees() {
		List<Employee> employees = employeesDAO.fetchEmployees();
		
		return EmployeeConverter.convert(employees);
	}

	public EmployeeDTO getEmployeeById(Integer id) {
		Employee employee = employeesDAO.getEmployeeById(id);
		return employee == null ? null : EmployeeConverter.convert(employee);
	}

	public void saveEmployee(EmployeeDTO employee) {
		employeesDAO.save(EmployeeConverter.convert(employee));
	}

	public void deleteEmployee(Integer id) {
		employeesDAO.deleteEmployee(id);
	}

}
