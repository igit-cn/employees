package lt.employees.service.impl;

import java.util.List;

import lt.employees.domain.dao.DepartmentsDAO;
import lt.employees.domain.dao.EmployeesDAO;
import lt.employees.domain.entity.Department;
import lt.employees.domain.entity.Employee;
import lt.employees.service.DepartmentsService;
import lt.employees.service.converter.DepartmentConverter;
import lt.employees.service.dto.DepartmentDTO;
import lt.employees.service.dto.EmployeeDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service implementation for {@link DepartmentsService}.
 */
@Service(value = "departmentsService")
public class DepartmentsServiceImpl implements DepartmentsService {

    @Autowired
    private DepartmentsDAO departmentsDAO;

    @Autowired
    private EmployeesDAO employeesDAO;

    public List<DepartmentDTO> fetchDepartments() {
        List<Department> departments = departmentsDAO.fetchDepartments();
        return DepartmentConverter.convert(departments);
    }

    public DepartmentDTO getDepartmentById(Long id) {
        Department department = departmentsDAO.getDepartmentById(id);
        return DepartmentConverter.convert(department);
    }

    public void saveDepartment(DepartmentDTO department) {
        Department departmentEntity = DepartmentConverter.convert(department);

        if (department.getDirector() != null) {
            final Employee director = employeesDAO.getEmployeeById(department.getDirector().getId());
            departmentEntity.setDirector(director);
        }

        if (department.getId() != null) {
            resetDepartmentEmployees(department.getId());
        }

        for (EmployeeDTO employeeDTO : department.getEmployees()) {
            final Employee employee = employeesDAO.getEmployeeById(employeeDTO.getId());
            employee.setDepartment(departmentEntity);
            departmentEntity.addEmployee(employee);
        }

        departmentsDAO.save(departmentEntity);
    }

    public void deleteDepartment(Long id) {
        departmentsDAO.deleteDepartment(id);
    }

    public List<DepartmentDTO> fetchDepartmentsNameInfo() {
        final List<Department> departments = departmentsDAO.fetchNamesInfo();
        return DepartmentConverter.convert(departments);
    }

    private void resetDepartmentEmployees(Long departmentId) {
        final List<Employee> employees = employeesDAO.fetchByDepartmentId(departmentId);
        for (Employee employee : employees) {
            employee.setDepartment(null);
        }

    }
}
