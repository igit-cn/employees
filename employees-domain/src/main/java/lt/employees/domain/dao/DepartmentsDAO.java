package lt.employees.domain.dao;

import lt.employees.domain.entity.Department;

import java.util.List;

/**
 * DAO for {@link Department} entity.
 */
public interface DepartmentsDAO {

    List<Department> fetchDepartments();

    void save(Department department);

    Department getDepartmentById(Long id);

    void deleteDepartment(Long id);

    List<Department> fetchNamesInfo();

}
