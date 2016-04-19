package lt.employees.domain.dao.impl;

import java.util.List;

import lt.employees.domain.dao.DepartmentsDAO;
import lt.employees.domain.entity.Department;

import org.springframework.stereotype.Repository;

/**
 * DAO class for {@link Department} entity.
 */
@Repository(value = "departmentsDAO")
public class DepartmentsDAOImpl extends AbstractJpaDAO<Department> implements DepartmentsDAO {

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
}
