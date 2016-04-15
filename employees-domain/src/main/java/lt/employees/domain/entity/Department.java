package lt.employees.domain.entity;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

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

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
