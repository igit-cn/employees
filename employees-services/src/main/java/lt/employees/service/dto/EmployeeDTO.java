package lt.employees.service.dto;

public class EmployeeDTO {

	private Long id;
	
	private String firstName;
	
	private String lastName;

	private DepartmentDTO department;

	private ContactInfoDTO contactInfo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public DepartmentDTO getDepartment() {
		return department;
	}

	public void setDepartment(final DepartmentDTO department) {
		this.department = department;
	}

	public ContactInfoDTO getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(final ContactInfoDTO contactInfo) {
		this.contactInfo = contactInfo;
	}
}
