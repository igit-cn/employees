package lt.employees.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee extends AbstractEntity {

    @Column(nullable = false)
	private String firstName;

    @Column(nullable = false)
	private String lastName;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
	private ContactInfo contactInfo;

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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(final ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}
}
