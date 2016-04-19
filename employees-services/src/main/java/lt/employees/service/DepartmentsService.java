package lt.employees.service;

import lt.employees.service.dto.DepartmentDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service for operations with departments.
 */
@Transactional
public interface DepartmentsService {

    List<DepartmentDTO> fetchDepartments();

    DepartmentDTO getDepartmentById(Long id);

    void saveDepartment(DepartmentDTO department);

    void deleteDepartment(Long id);

}
