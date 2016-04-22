package lt.employees.service.dto;

public class EmployeeDTO {

	private Long id;
	
	private String firstName;
	
	private String lastName;

    private AddressDTO address;

	private DepartmentDTO department;

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

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

	public DepartmentDTO getDepartment() {
		return department;
	}

	public void setDepartment(final DepartmentDTO department) {
		this.department = department;
	}
}
