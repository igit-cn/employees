package lt.employees.domain.entity;

import javax.persistence.*;

@Entity
@Table(name="Employee")
public class Employee extends AbstractEntity {

    @Column(nullable = false)
	private String firstName;

    @Column(nullable = false)
	private String lastName;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
	private Address address;

	@OneToOne
	private Department department;

	public Employee() {
	}

	public Employee(final Long id, final String firstName, final String lastName) {
		setId(id);
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
}
