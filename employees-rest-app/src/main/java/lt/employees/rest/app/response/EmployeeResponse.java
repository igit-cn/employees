package lt.employees.rest.app.response;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Employee response object.
 */
@XmlRootElement
@XmlType(propOrder={"id", "firstName", "lastName", "address"})
public class EmployeeResponse {

	private Long id;

	private String firstName;

	private String lastName;

	private DepartmentResponse department;

	private ContactInfoResponse contactInfo;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public DepartmentResponse getDepartment() {
		return department;
	}

	public void setDepartment(final DepartmentResponse department) {
		this.department = department;
	}

	public ContactInfoResponse getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(final ContactInfoResponse contactInfo) {
		this.contactInfo = contactInfo;
	}
}
