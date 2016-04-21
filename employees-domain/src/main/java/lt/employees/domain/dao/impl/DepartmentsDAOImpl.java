package lt.employees.domain.dao.impl;

import java.util.List;

import javax.persistence.Query;

import lt.employees.domain.dao.DepartmentsDAO;
import lt.employees.domain.entity.Department;

import org.springframework.stereotype.Repository;

/**
 * DAO class for {@link Department} entity.
 */
@Repository(value = "departmentsDAO")
public class DepartmentsDAOImpl extends AbstractJpaDAO<Department> implements DepartmentsDAO {

    private static String SELECT_DEPARTMENTS_NAME_INFO = "SELECT new lt.employees.domain.entity.Department(d.id, d.name, d.description)"
            + " from Department d";

    public DepartmentsDAOImpl() {
        setClazz(Department.class);
    }

    public List<Department> fetchDepartments() {
        return findAll();
    }

    public void save(Department department) {
        saveOrUpdate(department);
    }

    public Department getDepartmentById(Long id) {
        return findById(id);
    }

    public void deleteDepartment(Long id) {
        deleteById(id);
    }

    public List<Department> fetchNameInfos() {
        final Query query = getEntityManager().createQuery(SELECT_DEPARTMENTS_NAME_INFO);

        return query.getResultList();
    }
}
