package lt.employees.service.impl;

import java.util.List;

import lt.employees.domain.dao.DepartmentsDAO;
import lt.employees.domain.dao.EmployeesDAO;
import lt.employees.domain.entity.Department;
import lt.employees.domain.entity.Employee;
import lt.employees.service.DepartmentsService;

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

    public List<Department> fetchDepartments() {
        return departmentsDAO.fetchDepartments();
    }

    public Department getDepartmentById(Long id) {
        return departmentsDAO.getDepartmentById(id);
    }

    public void saveDepartment(Department department) {
        if (department.getDirector() != null) {
            final Employee director = employeesDAO.getEmployeeById(department.getDirector().getId());
            department.setDirector(director);
        }

        if (department.getId() != null) {
            resetDepartmentEmployees(department.getId());
        }

        for (Employee employee : department.getEmployees()) {
            final Employee employeeFromDB = employeesDAO.getEmployeeById(employee.getId());
            employeeFromDB.setDepartment(department);
        }

        departmentsDAO.save(department);
    }

    public void deleteDepartment(Long id) {
        departmentsDAO.deleteDepartment(id);
    }

    private void resetDepartmentEmployees(Long departmentId) {
        final List<Employee> employees = employeesDAO.fetchByDepartmentId(departmentId);
        for (Employee employee : employees) {
            employee.setDepartment(null);
        }

    }
}
