package lt.employees.domain.dao.impl;

import lt.employees.domain.dao.DepartmentsDAO;
import lt.employees.domain.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public Department getDepartmentById(Integer id) {
        return findById(id);
    }

    public void deleteDepartment(Integer id) {
        deleteById(id);
    }
}
