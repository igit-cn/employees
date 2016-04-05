package lt.employees.domain.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="Employee")
public class Employee extends AbstractEntity {

    @Column(nullable = false)
	private String firstName;

    @Column(nullable = false)
	private String lastName;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Address address;

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
}
