package lt.employees.domain.entity;

import javax.persistence.*;

@Entity
@Table(name="Employees")
public class Employee {
	
	@Id
	@GeneratedValue
	private Integer id;

    @Column(nullable = false)
	private String firstName;

    @Column(nullable = false)
	private String lastName;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Address address;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
}
