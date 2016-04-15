package lt.employees.service.impl;

import lt.employees.domain.dao.DepartmentsDAO;
import lt.employees.domain.entity.Department;
import lt.employees.service.DepartmentsService;
import lt.employees.service.converter.DepartmentConverter;
import lt.employees.service.dto.DepartmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for {@link DepartmentsService}.
 */
@Service(value = "departmentsService")
public class DepartmentsServiceImpl implements DepartmentsService {

    @Autowired
    private DepartmentsDAO departmentsDAO;

    public List<DepartmentDTO> fetchDepartments() {
        List<Department> departments = departmentsDAO.fetchDepartments();
        return DepartmentConverter.convert(departments);
    }

    public DepartmentDTO getDepartmentById(Integer id) {
        Department department = departmentsDAO.getDepartmentById(id);

        return DepartmentConverter.convert(department);
    }

    public void saveDepartment(DepartmentDTO department) {
        Department departmentEntity = DepartmentConverter.convert(department);

        departmentsDAO.save(departmentEntity);
    }

    public void deleteDepartment(Integer id) {
        departmentsDAO.deleteDepartment(id);
    }
}
