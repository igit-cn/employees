package lt.employees.service.impl;

import java.util.List;

import lt.employees.domain.dao.EmployeesDAO;
import lt.employees.domain.entity.ContactInfo;
import lt.employees.domain.entity.Employee;
import lt.employees.service.EmployeesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "employeesService")
public class EmployeesServiceImpl implements EmployeesService {

	@Autowired
	private EmployeesDAO employeesDAO;

	public List<Employee> fetchEmployees() {
		return employeesDAO.fetchEmployees();
	}

	public Employee getEmployeeById(Long id) {
		return employeesDAO.getEmployeeById(id);
	}

	public void saveEmployee(Employee employee) {
		final ContactInfo contactInfo = employee.getContactInfo();
		contactInfo.setEmployee(employee);
		contactInfo.getAddress().setContactInfo(contactInfo);

		employeesDAO.save(employee);
	}

	public void deleteEmployee(Long id) {
		employeesDAO.deleteEmployee(id);
	}

}
