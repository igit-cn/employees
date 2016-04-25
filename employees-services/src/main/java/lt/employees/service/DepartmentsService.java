package lt.employees.service;

import java.util.List;

import lt.employees.domain.entity.Department;

import org.springframework.transaction.annotation.Transactional;

/**
 * Service for operations with departments.
 */
@Transactional
public interface DepartmentsService {

    List<Department> fetchDepartments();

    Department getDepartmentById(Long id);

    void saveDepartment(Department department);

    void deleteDepartment(Long id);

}
