package lt.employees.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entity holds contact information.
 */
@Entity
@Table(name = "ContactInfo")
public class ContactInfo extends AbstractEntity {

	@OneToOne(mappedBy = "contactInfo", cascade = CascadeType.ALL)
	private Address address;

	@OneToOne
	private Employee employee;

	public Address getAddress() {
		return address;
	}

	public void setAddress(final Address address) {
		this.address = address;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(final Employee employee) {
		this.employee = employee;
	}
}
