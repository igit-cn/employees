package lt.employees.domain.dao.impl;

import java.util.List;

import javax.persistence.Query;

import lt.employees.domain.dao.EmployeesDAO;
import lt.employees.domain.entity.Employee;

import org.springframework.stereotype.Repository;

@Repository(value = "employeesDAO")
public class EmployeesDAOImpl extends AbstractJpaDAO<Employee> implements EmployeesDAO {

	private static String SELECT_EMPLOYEES_NAME_INFO = "SELECT new lt.employees.domain.entity.Employee(e.id, e.firstName, e.lastName)"
			+ " from Employee e";

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

	public List<Employee> fetchNameInfos() {
		final Query query = getEntityManager().createQuery(SELECT_EMPLOYEES_NAME_INFO);

		return query.getResultList();
	}

}
