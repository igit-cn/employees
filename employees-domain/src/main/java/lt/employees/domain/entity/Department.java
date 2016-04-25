package lt.employees.domain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Department entity class.
 */
@Entity
@Table(name = "Department")
public class Department extends AbstractEntity {

    private String name;

    private String description;

    @OneToOne
    private Employee director;

    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
    private List<Employee> employees = new ArrayList<Employee>();

    public Department() {
    }

    public Department(final Long id, final String name, final String description) {
        setId(id);
        this.name = name;
        this.description = description;
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

    public Employee getDirector() {
        return director;
    }

    public void setDirector(Employee director) {
        this.director = director;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
}
