package lt.employees.domain.dao.impl;

import java.util.List;

import lt.employees.domain.dao.EmployeesDAO;
import lt.employees.domain.entity.Employee;

import org.springframework.stereotype.Repository;

@Repository(value = "employeesDAO")
public class EmployeesDAOImpl extends AbstractJpaDAO<Employee> implements EmployeesDAO {

	public EmployeesDAOImpl() {
		setClazz(Employee.class);
	}

	public List<Employee> fetchEmployees() {
		return findAll();
	}

	public void save(final Employee employee) {
		saveOrUpdate(employee);
	}

	public Employee getEmployeeById(final Long id) {
		return findById(id);
	}

	public void deleteEmployee(final Long id) {
		deleteById(id);
	}

}
