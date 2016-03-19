package lt.employees.domain.dao.impl;

import lt.employees.domain.dao.EmployeesDAO;
import lt.employees.domain.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class EmployeesDAOImpl implements EmployeesDAO {
	
	private EntityManager entityManager = Persistence.createEntityManagerFactory("employees").createEntityManager();

	public List<Employee> fetchEmployees() {
		
		Query query = entityManager.createQuery("SELECT e FROM Employee e");
		
		@SuppressWarnings("unchecked")
		List<Employee> result = query.getResultList();
		
		return result;
	}

	public void save(Employee employee) {
		EntityTransaction transaction = entityManager.getTransaction();
		
		if (employee != null) {
			try {
				transaction.begin();
				if (employee.getId() != null) {
					entityManager.merge(employee);
				} else {
					entityManager.persist(employee);
				}
				transaction.commit();
			} catch (Exception e) {
				transaction.rollback();
				throw new RuntimeException(e);
			}
		}
		
	}

	public Employee getEmployeeById(Integer id) {
		return entityManager.find(Employee.class, id);
	}

	public void deleteEmployee(Integer id) {
		EntityTransaction transaction = entityManager.getTransaction();
		
		if (id != null) {
			try {
				transaction.begin();
				Query query = entityManager.createQuery("DELETE FROM Employee e WHERE e.id = :id");
				query.setParameter("id", id);
				query.executeUpdate();
				transaction.commit();
			} catch (Exception e) {
				transaction.rollback();
				throw new RuntimeException(e);
			}
		}
	}

}
