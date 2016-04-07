package lt.employees.service.impl;

import java.util.List;

import lt.employees.domain.dao.EmployeesDAO;
import lt.employees.domain.entity.Employee;
import lt.employees.service.EmployeesService;
import lt.employees.service.converter.EmployeeConverter;
import lt.employees.service.dto.EmployeeDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "employeesService")
public class EmployeesServiceImpl implements EmployeesService {

	@Autowired
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