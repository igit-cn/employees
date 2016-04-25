package lt.employees.rest.app.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Response object for departments.
 */
@XmlRootElement
@XmlType(propOrder={"id", "name", "description", "director", "employees"})
public class DepartmentResponse {

    private Long id;

    private String name;

    private String description;

    private EmployeeResponse director;

    private List<EmployeeResponse> employees = new ArrayList<EmployeeResponse>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public EmployeeResponse getDirector() {
        return director;
    }

    public void setDirector(EmployeeResponse director) {
        this.director = director;
    }

    public List<EmployeeResponse> getEmployees() {
        return employees;
    }

    public void addEmployee(EmployeeResponse employee) {
        employees.add(employee);
    }
}
