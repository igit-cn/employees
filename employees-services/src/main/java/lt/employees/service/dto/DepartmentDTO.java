package lt.employees.service.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Data transfer object for Department.
 */
public class DepartmentDTO {

    private Long id;

    private String name;

    private String description;

    private EmployeeDTO director;

    private List<EmployeeDTO> employees = new ArrayList<EmployeeDTO>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EmployeeDTO getDirector() {
        return director;
    }

    public void setDirector(EmployeeDTO director) {
        this.director = director;
    }

    public List<EmployeeDTO> getEmployees() {
        return employees;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
