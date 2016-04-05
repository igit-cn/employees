package lt.employees.service.impl;

import java.util.List;

import lt.employees.domain.dao.EmployeesDAO;
import lt.employees.domain.entity.Employee;
import lt.employees.service.EmployeesService;
import lt.employees.service.converter.EmployeeConverter;
import lt.employees.service.dto.EmployeeDTO;

public class EmployeesServiceImpl implements EmployeesService {

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

	public void setEmployeesDAO(final EmployeesDAO employeesDAO) {
		this.employeesDAO = employeesDAO;
	}
}
